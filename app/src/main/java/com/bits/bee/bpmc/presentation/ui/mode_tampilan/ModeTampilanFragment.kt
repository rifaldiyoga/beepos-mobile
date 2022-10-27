package com.bits.bee.bpmc.presentation.ui.mode_tampilan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentModeTampilanBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 01/04/22.
 */
@AndroidEntryPoint
class ModeTampilanFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentModeTampilanBinding = FragmentModeTampilanBinding::inflate
) : BaseFragment<FragmentModeTampilanBinding>(){

    private val viewModel : ModeTampilanViewModel by viewModels()


    override fun initComponents() {
        binding.apply {
            arguments?.let{
                val type = it.getString("type")
                viewModel.type = type ?: ""
                val isSignUp = BeePreferenceManager.getDataFromPreferences(requireActivity(), getString(R.string.pref_is_sign_up), true) as Boolean
                if(isSignUp)
                    viewModel.type = "signup"
            }
        }
    }

    override fun subscribeListeners() {
        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_last_page), getString(
            R.string.page_mode_tampilan))
        binding.apply {
            clRetailDist.setOnClickListener {
                viewModel.onClickItem(BPMConstants.MODE_RETAIL)
            }
            clFoodBeverages.setOnClickListener {
                viewModel.onClickItem(BPMConstants.MODE_FOOD_BEVERAGES)
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event){
                        is ModeTampilanViewModel.UIEvent.RequestClickItem -> {
                            val action = when (viewModel.type) {
                                "signup" -> {
                                    ModeTampilanFragmentDirections.actionModeTampilanFragmentToAturProdukFragment()
                                }
                                else -> {
                                    ModeTampilanFragmentDirections.actionModeTampilanFragmentToPilihCabangFragment()
                                }
                            }
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }


}