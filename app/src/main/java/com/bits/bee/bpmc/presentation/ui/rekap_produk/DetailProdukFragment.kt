package com.bits.bee.bpmc.presentation.ui.rekap_produk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bits.bee.bpmc.databinding.FragmentDetailProdukBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailProdukFragment (
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailProdukBinding = FragmentDetailProdukBinding::inflate
): BaseFragment<FragmentDetailProdukBinding>() {

    private val viewModel : RekapProdukViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            if (!it.getString("item").equals("null") && it.getString("item")?.isNotEmpty() == true){
                viewModel.updateState(
                    viewModel.state.copy(
                        item = Gson().fromJson(it.getString("item"), Item::class.java)
                    )
                )
            }
        }
    }

    override fun initComponents() {

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }
}