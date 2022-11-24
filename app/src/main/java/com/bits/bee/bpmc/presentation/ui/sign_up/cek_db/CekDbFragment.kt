package com.bits.bee.bpmc.presentation.ui.sign_up.cek_db

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentCekDbBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 23/11/22
 */
@AndroidEntryPoint
class CekDbFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCekDbBinding = FragmentCekDbBinding::inflate
) : BaseFragment<FragmentCekDbBinding>() {

    private val viewModel : CekDbViewModel by viewModels()
    val mHandler : Handler = Handler(Looper.getMainLooper())
    lateinit var serial : String


    override fun initComponents() {
        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_last_page), getString(R.string.page_cek_db))
        serial = BeePreferenceManager.getDataFromPreferences(requireActivity(), getString(R.string.pref_serial_number), "") as String
        viewModel.checkDb(serial)
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewModel.observeCheckDbResponse().observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    it.data?.let {
                        if(it.data) {
                            showSnackbar("Berhasil Verifikasi Database!")
                            val action =
                                CekDbFragmentDirections.actionCekDbFragmentToAturPinFragment()
                            findNavController().navigate(action)
                        } else {
                            mHandler.postDelayed({
                                viewModel.checkDb(serial)
                            }, 10000)
                        }
                    }

                }
                Resource.Status.ERROR -> {

                }
                Resource.Status.NOINTERNET -> {
                    val dialog = NoInternetDialogBuilder({
                        viewModel.checkDb(serial)
                    })
                    dialog.show(parentFragmentManager, "")
                }
            }
        }
    }


}