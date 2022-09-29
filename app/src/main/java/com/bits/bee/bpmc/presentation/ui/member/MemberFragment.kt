package com.bits.bee.bpmc.presentation.ui.member

import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentMemberBinding
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.detail_member.DetailMemberDialog
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer.TAG
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 22/04/22.
 */
@AndroidEntryPoint
class MemberFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMemberBinding = FragmentMemberBinding::inflate
) : BaseFragment<FragmentMemberBinding>() {

    private val viewModel : MemberViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    private lateinit var memberAdapter: MemberAdapter

    override fun initComponents() {
        setHasOptionsMenu(true)
        binding.apply {
            memberAdapter = MemberAdapter(
                onMemberClick = { model ->
                    viewModel.onClickDetailMember(model)
                },
                onEyeClick = { model ->
                    viewModel.onClickEye(model)
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
                clearPref()
                viewModel.onClickAddMember()
            }
            btnTambahBaru.setOnClickListener {
                clearPref()
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
                            val action = MemberFragmentDirections.actionMemberFragmentToTambahMemberFragment(
                                Gson().toJson(null))
                            findNavController().navigate(action)
                        }
                        is MemberViewModel.UIEvent.RequestPos -> {
                            val action = MemberFragmentDirections.actionMemberFragmentToPosFragment()

                            mainViewModel.updateActiveBp(it.model)
                            findNavController().navigate(action)
                        }

                        is MemberViewModel.UIEvent.RequestIconEye ->{
                            val dialog = DetailMemberDialog(it.model)
                            dialog.show(parentFragmentManager, TAG)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.memberList.collect {
                    memberAdapter.submitList(it)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_search_member, menu)

//        val searchManager = requireContext().getSystemService(Context.SEARCH_SERVICE)

        val searchItem = menu.findItem(R.id.search_member)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel.viewStates().collect {
                            it?.let {
                                if (newText?.length == 0){
                                    viewModel.onSearch("")
                                    it.listBp?.let {
                                        memberAdapter.submitList(it)
                                    }
                                }else if (newText!!.length >= 3){
                                    viewModel.onSearch(newText.toString().trim())
                                    it.listBp?.let {
                                        memberAdapter.submitList(it)
                                    }
                                }
                            }
                        }
                    }
                }
                return false
            }

        })
//        if (searchItem != null){
//            searchView = searchItem.actionView as SearchView
//        }
//
//        if (searchView != null){
//            searchView.setSearchableInfo(searchManager)
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search_member ->{

            }
        }
        return super.onOptionsItemSelected(item)
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

    private fun clearPref(){
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext()).edit()
        sharedPreferences.remove(getString(R.string.pref_city))
        sharedPreferences.remove(getString(R.string.pref_add_member_name))
        sharedPreferences.remove(getString(R.string.pref_add_member_notelp))
        sharedPreferences.remove(getString(R.string.pref_add_member_email))
        sharedPreferences.remove(getString(R.string.pref_add_member_alamat))
        sharedPreferences.commit()
    }
}