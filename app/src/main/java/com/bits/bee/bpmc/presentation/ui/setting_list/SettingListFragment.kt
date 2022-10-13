package com.bits.bee.bpmc.presentation.ui.setting_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.AbstractListDetailFragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 04/04/22.
 */
@AndroidEntryPoint
class SettingListFragment : AbstractListDetailFragment() {

    private val viewModel : SettingListViewModel by viewModels()

    override fun onCreateListPaneView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_setting_list, container, false)
    }

    override fun onCreateDetailPaneNavHostFragment(): NavHostFragment {
        return NavHostFragment.create(R.navigation.setting_graph)
    }

    override fun onListPaneViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onListPaneViewCreated(view, savedInstanceState)
        val recyclerView = view as RecyclerView
        val adapterS = TwoPaneAdapter(map.keys.toTypedArray()) {
            map[it]?.let { destId ->
                if(destId > 0)
                    openDetails(destId)
                else
                    doKeluar()
            }
        }
        recyclerView.apply {
            adapter = adapterS
            layoutManager = LinearLayoutManager(requireActivity())
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, TwoPaneOnBackPressedCallback(slidingPaneLayout))
        slidingPaneLayout.lockMode = SlidingPaneLayout.LOCK_MODE_LOCKED

    }



    private fun doKeluar(){
        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_last_page), getString(
            R.string.page_pilih_operator))
        val action = SettingListFragmentDirections.actionSettingListFragmentToInitialActivity2()
        findNavController().navigate(action)
    }

    private fun openDetails(destinationId: Int) {
        val detailNavController = detailPaneNavHostFragment.navController
        detailNavController.navigate(
            destinationId,
            null,
            NavOptions.Builder()
                .setPopUpTo(detailNavController.graph.startDestinationId, true)
                .apply {
                    if (slidingPaneLayout.isOpen) {
                        setEnterAnim(R.anim.nav_default_enter_anim)
                        setExitAnim(R.anim.nav_default_exit_anim)
                    }
                }
                .build()
        )
        slidingPaneLayout.open()
    }

    inner class TwoPaneOnBackPressedCallback(
        private val slidingPaneLayout: SlidingPaneLayout
    ) : OnBackPressedCallback(
        // Set the default 'enabled' state to true only if it is slidable (i.e., the panes
        // are overlapping) and open (i.e., the detail pane is visible).
        slidingPaneLayout.isSlideable && slidingPaneLayout.isOpen
    ), SlidingPaneLayout.PanelSlideListener {

        init {
            slidingPaneLayout.addPanelSlideListener(this)
        }

        override fun handleOnBackPressed() {
            if(map.values.contains(detailPaneNavHostFragment.navController.currentDestination?.id))
                slidingPaneLayout.closePane()
            else
                detailPaneNavHostFragment.navController.popBackStack()
        }

        override fun onPanelSlide(panel: View, slideOffset: Float) { }

        override fun onPanelOpened(panel: View) {
            // Intercept the system back button when the detail pane becomes visible.
            isEnabled = true
        }

        override fun onPanelClosed(panel: View) {
            // Disable intercepting the system back button when the user returns to the
            // list pane.
            isEnabled = false
        }
    }

    companion object {
        val map = mapOf(
            "POS" to R.id.settingPosFragment,
            "Favorit" to R.id.settingFavoriteFragmentMain,
            "Nota" to R.id.settingNotaFragment,
            "Print" to R.id.settingPrinterFragment,
            "Sistem" to R.id.settingSistemFragment,
            "Bantuan" to R.id.detailMenuHelpFragment,
            "Keluar" to -1
        )
    }

}