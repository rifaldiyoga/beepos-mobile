package com.bits.bee.bpmc.presentation.ui.info_bisnis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.viewModels
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.source.local.model.City
import com.bits.bee.bpmc.databinding.FragmentInfoBisnisBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible

class InfoBisnisFragment constructor(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentInfoBisnisBinding = FragmentInfoBisnisBinding::inflate
): BaseFragment<FragmentInfoBisnisBinding>() {
    private val viewModel: InfoBisnisViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCityList()
        viewModel.getCityDaoList()
        var dao: List<City> = viewModel.getCityDaoList()

//        var mArrayCity = dao?.let { arrayOfNulls<String>(it.size) }
        val city_array: Array<City> = dao.toTypedArray()

        val autotextView = view.findViewById<AutoCompleteTextView>(R.id.ac_txtView)
        val adapter
                = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,city_array
        )
        autotextView.setAdapter(adapter)
    }

//    fun getNameCity(city: City): List<City>{
//
//        binding.apply {
//            acTxtView.text = city.name
//        }
//    }

    override fun initComponents() {
        TODO("Not yet implemented")
    }

    override fun subscribeListeners() {
        binding.apply {
            viewModel.getCityList()
            viewModel.getCityDaoList()
        }
    }

    override fun subscribeObservers() {
        viewModel.observeListCity().removeObservers(viewLifecycleOwner)
        viewModel.observeListCity().observe(viewLifecycleOwner, {
            it?.let {
                when(it.status){
                    Resource.Status.LOADING -> {
                        setVisibilityComponent(true)
                    }
//                    Resource.Status.SUCCESS -> {
//                        setVisibilityComponent(false)
//                        it.data?.let { data ->
//                            adapter.submitList(data)
//                            adapter.notifyDataSetChanged()
//                        }
//                    }
                    Resource.Status.ERROR -> {
                        setVisibilityComponent(false)
                    }
                    Resource.Status.TIMEOUT -> {
                        setVisibilityComponent(false)
                    }
                    Resource.Status.UNAUTHORIZED -> {
                        setVisibilityComponent(false)
                    }
                }
            }
        })
    }

    private fun setVisibilityComponent(isLoading : Boolean){
        binding.apply {
            if(isLoading){
                progressBar.visible()
            } else {
                progressBar.gone()
            }
        }
    }
}