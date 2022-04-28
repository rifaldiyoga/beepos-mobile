package com.bits.bee.bpmc.presentation.ui.member

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.FragmentMemberBinding
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 22/04/22.
 */
@AndroidEntryPoint
class MemberFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMemberBinding = FragmentMemberBinding::inflate
) : BaseFragment<FragmentMemberBinding>() {

    private val viewModel : MemberViewModel by viewModels()

    private lateinit var memberAdapter: MemberAdapter

    override fun initComponents() {
        binding.apply {
            memberAdapter = MemberAdapter(
                onMemberClick = { model ->
                    viewModel.onClickDetailMember(model)
                }
            )

            rvList.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = memberAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            fabTambahMember.setOnClickListener {
                viewModel.onClickAddMember()
            }
            btnTambahBaru.setOnClickListener {
                viewModel.onClickAddMember()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        MemberViewModel.UIEvent.RequestAddMember -> {
                            val action = MemberFragmentDirections.actionMemberFragmentToTambahMemberFragment()
                            findNavController().navigate(action)
                        }
                        is MemberViewModel.UIEvent.RequestDetailMember -> {
                            val action = MemberFragmentDirections.actionMemberFragmentToDetailMemberDialog(it.model)
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.memberList.collect {
                    when(it.status){
                        Resource.Status.LOADING -> {
                            setVisibilityLoading(true)
                        }
                        Resource.Status.SUCCESS -> {
                            val data = it.data?.let {
                                it
                            } ?: mutableListOf()

                            setVisibilityLoading(false,  data)
                            memberAdapter.submitList(data)
                        }
                        Resource.Status.ERROR -> {
                            setVisibilityLoading(false)
                        }
                        Resource.Status.TIMEOUT -> {
                            setVisibilityLoading(false)
                        }
                        Resource.Status.UNAUTHORIZED -> {
                            setVisibilityLoading(false)
                        }
                    }
                }
            }
        }
    }

    private fun setVisibilityLoading(isLoading : Boolean, data : List<Bp> = mutableListOf()){
        binding.apply {
            if(isLoading){
                progressBar.visible()
                groupList.gone()
                groupEmpty.gone()
            } else {
                progressBar.gone()
                if(data.isEmpty()) {
                    groupEmpty.visible()
                    groupList.gone()
                } else {
                    groupList.visible()
                    groupEmpty.gone()
                }
            }
        }
    }
}