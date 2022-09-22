package com.bits.bee.bpmc.presentation.ui.pos.klaim_promo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentKlaimPromoBinding
import com.bits.bee.bpmc.domain.model.ItemWithUnit
import com.bits.bee.bpmc.domain.model.Promo
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import java.math.BigDecimal


/**
 * Created by aldi on 09/09/22
 */
@AndroidEntryPoint
class KlaimPromoFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentKlaimPromoBinding = FragmentKlaimPromoBinding::inflate
) : BaseFragment<FragmentKlaimPromoBinding>() {

    private val viewModel : KlaimPromoViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    private lateinit var itemAdapter : KlaimPromoAdapater

    override fun initComponents() {
        binding.apply {

            viewModel.state.apply {
                listPromoBonus = mainViewModel.listPromoBonus
                promoBonus = mainViewModel.listPromoBonus[viewModel.state.index]
                saledList = mainViewModel.saleTrans.getListDetail()
                bp = mainViewModel.state.bp
                priceLvlId = bp!!.priceLvlId
                viewModel.state.promoBonus?.let {
                    val promo = it.getPromo()
                    totalQtyPromo = it.qty
                    qtyPromo = it.qty
                    maxIndex = mainViewModel.listPromoBonus.size - 1
                    isPromoBonus = promo.promoCat == "BONUS" || (promo.itemDiscExp != null && promo.itemDiscExp.equals("100%"))
                    val title = if(promo.itemDiscExp != null && promo.itemDiscExp == "100%")
                        getString(R.string.kamu_mendapatkan_item_gratis, CurrencyUtils.formatCurrency(it.qty))
                    else getString(R.string.tebus_murah_item, CurrencyUtils.formatCurrency(it.qty), getOffer(promo, viewModel.state.isPromoBonus))
                    setToolbarTitle(title)
                }
                for (bonus in mainViewModel.listPromoBonus) {
                    listQtyPerPromo.add(BigDecimal.ZERO)
                }
            }

            itemAdapter = KlaimPromoAdapater(
                onAddClick = { item ->
                    viewModel.onAddItem(item)
                },
                onMinusClick = { item ->
                    viewModel.onMinItem(item)
                }
            )

            rvList.apply {
                adapter = itemAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
        viewModel.loadData()
    }

    override fun subscribeListeners() {
        binding.apply {
            btnNext.setOnClickListener {
                viewModel.onClickNext()
            }
            btnBatal.setOnClickListener {
                viewModel.onClickCancel()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewStates().collect {
                it?.let { state ->
                    state.promoBonus?.let { promoBonus ->
                        val promo = promoBonus.getPromo()
                        val title = if(promo.itemDiscExp != null && promo.itemDiscExp == "100%")
                            getString(R.string.kamu_mendapatkan_item_gratis, CurrencyUtils.formatCurrency(promoBonus.qty))
                        else getString(R.string.tebus_murah_item, CurrencyUtils.formatCurrency(promoBonus.qty), getOffer(promo, viewModel.state.isPromoBonus))
                        setToolbarTitle(title)
                    }
                    binding.tvQty.text = "${CurrencyUtils.formatCurrency(it.qtyItem)}/${CurrencyUtils.formatCurrency(it.totalQtyPromo)}"
                    binding.btnNext.text = if(state.index == state.maxIndex ) getString(R.string.ambil_promo) else getString(R.string.next)
                    itemAdapter.submitList(it.itemListBonus)
                    itemAdapter.notifyDataSetChanged()
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.event.collect{
                when(it){
                    is KlaimPromoViewModel.UIEvent.ShowSnackBar -> {
                        Snackbar.make(binding.root, it.msg, Snackbar.LENGTH_LONG).setAnchorView(R.id.btnNext).show()
                    }
                    KlaimPromoViewModel.UIEvent.NavigateBack -> {
                        mainViewModel.listPromoBonus.clear()
                        findNavController().popBackStack()
                    }
                    is KlaimPromoViewModel.UIEvent.RequestAdd -> {
                        mainViewModel.onAddDetail(
                            ItemWithUnit(item = it.item),
                            useItemqty = true,
                            promoBonus = it.promoBonus,
                            isBonus = it.isPromoBonus
                        )
                    }
                }
            }
        }
    }

    private fun getOffer(promo : Promo, isPromoBonus : Boolean): String {
        if (!isPromoBonus) {
            if (promo.isPriceOveride) {
                return "SEHARGA " + CurrencyUtils.formatCurrency(promo.itemPrice)
            }
            if (promo.itemDiscExp != null) {
                val isPercentage: Boolean = promo.itemDiscExp!!.contains("%")
                return "DISKON " + if (isPercentage) promo.itemDiscExp else CurrencyUtils.formatCurrency(
                    BigDecimal(promo.itemDiscExp)
                )
            }
        }
        return ""
    }

}