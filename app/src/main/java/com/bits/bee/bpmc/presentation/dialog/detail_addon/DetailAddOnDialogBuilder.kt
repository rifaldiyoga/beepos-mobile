package com.bits.bee.bpmc.presentation.dialog.detail_addon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogDetailAddonBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.math.BigDecimal

/**
 * Created by aldi on 09/12/22
 */
@AndroidEntryPoint
class DetailAddOnDialogBuilder(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogDetailAddonBinding = DialogDetailAddonBinding::inflate
) : BaseBottomSheetDialogFragment<DialogDetailAddonBinding>() {

    private val viewModel : DetailAddOnViewModel by viewModels()
    private val mainViewModel : MainViewModel by activityViewModels()

    private lateinit var addOnAdapter: DetailAddOnAdapter

    override fun initComponents() {
        binding.apply {
            arguments?.let {
                val item = it.getParcelable<Item>("item")
                viewModel.updateState(
                    viewModel.state.copy(
                        item = item
                    )
                )
            }
            addOnAdapter = DetailAddOnAdapter(onItemClick = {
                val action = DetailAddOnDialogBuilderDirections.actionDetailAddOnDialogBuilderToEditItemDialog(saled = it)
                findNavController().navigate(action)
            },
                onMinusClick = { saled ->
                    if(saled.qty > BigDecimal.ONE)
                        mainViewModel.onMinusAddOn(saled)
                    else {
                        val dialog = DialogBuilderHelper.showDialogChoice(
                            requireContext(),
                            title = getString(R.string.hapus_produk),
                            msg = getString(R.string.msg_hapus_produk),
                            positiveTxt = getString(R.string.ya),
                            positiveListener = {
                                it.dismiss()
                                mainViewModel.onDeleteDetail(saled)
                            },
                            negativeTxt = getString(R.string.batal),
                            negativeListener = {
                                it.dismiss()
                            }
                        )
                        dialog.show(parentFragmentManager, "")
                    }
                },
                onPlusClick = {
                    mainViewModel.onPlusAddOn(it)
                },
                mainViewModel.saleTrans.addOnTrans?.getListDetail() ?: mutableListOf()
            )

            rvList.apply {
                adapter = addOnAdapter
                layoutManager = LinearLayoutManager(requireActivity())
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            imageView2.setOnClickListener {
                findNavController().popBackStack()
            }
            btnLihatSelengkapnya.setOnClickListener {
                val action = DetailAddOnDialogBuilderDirections.actionDetailAddOnDialogBuilderToAddOnFragment(viewModel.state.item!!, mainViewModel.state.bp!!, mainViewModel.state.bp!!.priceLvlId)
                findNavController().navigate(action)
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            mainViewModel.viewStates().collect { state ->
                state?.let {
                    val saledList = getSaledByItem()
                    if(saledList.isEmpty()) {
                        findNavController().popBackStack()
                    }
                    addOnAdapter.submitList(saledList)
                    addOnAdapter.submitSaleAddOnDList(mainViewModel.saleTrans.addOnTrans?.getListDetail() ?: mutableListOf())
                }
            }
        }
    }

    private fun getSaledByItem() : List<Saled>{
        val item = viewModel.state.item!!
        var saledListFilter = mainViewModel.state.saledList.filter { !it.isAddOn && !it.isBonus}
        if(item.isVariant){
            saledListFilter = saledListFilter.filter { item.itemVariantList.contains(it.itemId) }
        } else {
            saledListFilter = saledListFilter.filter { item.id == it.itemId }
        }
        return saledListFilter
    }

}