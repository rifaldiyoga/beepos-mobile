package com.bits.bee.bpmc.presentation.ui.transaksi_berhasil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentTransaksiBerhasilBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 31/05/22.
 */
@AndroidEntryPoint
class TransaksiBerhasilFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTransaksiBerhasilBinding = FragmentTransaksiBerhasilBinding::inflate
) : BaseFragment<FragmentTransaksiBerhasilBinding>() {

    private val viewModel : TransaksiBerhasilViewModel by viewModels()

    override fun initComponents() {
        binding.apply {

        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnTutup.setOnClickListener {
                viewModel.onTutupClick()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect {
                    when(it){
                        TransaksiBerhasilViewModel.UIEvent.NavigateToPos -> {
                            val action = TransaksiBerhasilFragmentDirections.actionTransaksiBerhasilFragmentToPosFragment()
                            findNavController().popBackStack(R.id.posFragment, false)
                        }
                    }
                }
            }
        }
    }

    private val mBackStackField by lazy {
        val field = NavController::class.java.getDeclaredField("mBackStack")
        field.isAccessible = true
        field
    }

    fun popToRoot(navController: NavController) {
        val arrayDeque = mBackStackField.get(navController) as java.util.ArrayDeque<NavBackStackEntry>
        val graph = arrayDeque.first.destination as NavGraph
        val rootDestinationId = graph.startDestinationId

        val navOptions = NavOptions.Builder()
            .setPopUpTo(rootDestinationId, false)
            .build()

        navController.navigate(rootDestinationId, null, navOptions)
    }


}