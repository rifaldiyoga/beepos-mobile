package com.bits.bee.bpmc.presentation.ui.member

import android.Manifest
import android.view.*
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentMemberBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.detail_member.DetailMemberDialog
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer.TAG
import com.bits.bee.bpmc.utils.PermissionUtils
import com.bits.bee.bpmc.utils.extension.decideOnState
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.setSearchViewStyle
import com.bits.bee.bpmc.utils.extension.visible
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
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

    private val requestPermissionCamera = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
        if(!isGranted){
            Toast.makeText(requireActivity(), "Beberapa permission belum aktif!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_search_member, menu)

        val searchItem = menu.findItem(R.id.search_member)
        val searchView = searchItem.actionView as SearchView
        searchView.setSearchViewStyle(requireActivity(), R.color.black)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText?.length == 0){
                    viewModel.onSearch("")
                }else if (newText!!.length >= 3){
                    viewModel.onSearch(newText.toString().trim())
                }
                return false
            }

        })
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("scan")?.observe(viewLifecycleOwner) {
//            searchItem.expandActionView()
            searchView.setQuery(it, true)
            showSnackbar(it)
            viewModel.onSearch(it)
        }
        searchView.requestFocus()
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_scan -> {
                if(PermissionUtils.checkPermissionIsGranted(requireActivity(), Manifest.permission.CAMERA)) {
                    val action =
                        MemberFragmentDirections.actionMemberFragmentToScannerFragment()
                    findNavController().navigate(action)
                } else {
                    requestPermissionCamera.launch(Manifest.permission.CAMERA)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun initComponents() {
        setHasOptionsMenu(true)
        binding.apply {
            memberAdapter = MemberAdapter(
                onMemberClick = { model ->
                    viewModel.onClickDetailMember(model)
                },
                onEyeClick = { model ->
                    viewModel.onClickEye(model)
                },
                mainViewModel.activeBp.value
            )
            memberAdapter.addLoadStateListener { loadState ->
                loadState.decideOnState(
                    memberAdapter as PagingDataAdapter<Any, RecyclerView.ViewHolder>,
                    showLoading = {
                        setVisibilityLoading(it)
                    },
                    showEmptyState = { isVisible ->
                        binding.group4.isVisible = isVisible
                        binding.groupList.isVisible = !isVisible
                    },
                    showError = {
                        showSnackbar(it)
                    }
                )
            }

            rvList.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = memberAdapter
            }
            findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Boolean>("isUse")?.observe(viewLifecycleOwner){
                findNavController().popBackStack()
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
                            mainViewModel.updateActiveBp(it.model)
                            findNavController().popBackStack()
                        }

                        is MemberViewModel.UIEvent.RequestIconEye ->{
                            val dialog = DetailMemberDialog(it.model, onSubmit = {
                                findNavController().popBackStack()
                            })
                            dialog.show(parentFragmentManager, TAG)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.memberList.collectLatest {
                    memberAdapter.submitData(it)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            memberAdapter.loadStateFlow.collectLatest {
                if (it.append is LoadState.NotLoading && it.append.endOfPaginationReached) {
                    binding.group4.isVisible = memberAdapter.itemCount == 0 && viewModel.currentQuery.value.length > 2
                }
            }
        }

    }

    private fun setVisibilityLoading(isLoading : Boolean){
        binding.apply {
            if(isLoading){
                progressBar.visible()
                groupList.gone()
            } else {
                progressBar.gone()
                groupList.visible()
//                if(data.isEmpty()) {
//                    groupEmpty.visible()
//                    groupList.gone()
//                } else {
//                    groupList.visible()
//                    groupEmpty.gone()
//                }
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