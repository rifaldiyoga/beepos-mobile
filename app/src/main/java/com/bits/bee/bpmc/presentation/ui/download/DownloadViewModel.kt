package com.bits.bee.bpmc.presentation.ui.download

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.mapper.DistrictDataMapper
import com.bits.bee.bpmc.domain.repository.DistrictRepository
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.domain.repository.ProvinceRepository
import com.bits.bee.bpmc.domain.repository.RegencyRepository
import com.bits.bee.bpmc.domain.usecase.download.DownloadInteractor
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 29/03/22.
 */

@HiltViewModel
class DownloadViewModel @Inject constructor (
    private val itemGroupRepository: ItemGroupRepository,
    private val provinceRepository: ProvinceRepository,
    private val regencyRepository: RegencyRepository,
    private val districtRepository: DistrictRepository,
    private val di: DownloadInteractor,
) : ViewModel() {

    private var page : Int = 1

    private val _state = MutableStateFlow(DownloadState())
    var state = _state.asStateFlow()

    init {
        downloadAll()
    }

    private fun downloadAll() = viewModelScope.launch {
        downloadItemGroup()
    }

    private fun downloadItemGroup() = viewModelScope.launch {
        di.getLatestItemGroupUseCase(page).collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Item Group")
                    }
                }
                Resource.Status.SUCCESS -> {
                    it.data?.let { data ->
                        _state.update {
                            it.copy(status = "Finish Downloading Item Group")
                        }

                        downloadPriceLvl()
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadChannel() = viewModelScope.launch {
        di.getLatestChannelUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Channel")
                    }

                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Channel")
                    }
                    downloadBp()
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadBp() = viewModelScope.launch {
        di.getLatestBpUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {

                    _state.update {
                        it.copy(status = "Downloading Bp")
                    }
                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Bp")
                    }

                    downloadItem()
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadPriceLvl() = viewModelScope.launch {
        di.getLatestPriceLvlUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Price Lvl")
                    }
                }
                Resource.Status.SUCCESS -> {

                    downloadChannel()
                    _state.update {
                        it.copy(status = "Finish Downloading Price Lvl")
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadItem() = viewModelScope.launch {
        di.getLatestItemUseCase(page).collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Item")
                    }
                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Item")
                    }
                    downloadPrice()
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadCity() = viewModelScope.launch {
        di.getLatestCityUseCase(page).collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading City")
                    }
                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading City")
                    }
                    downloadItemSaleTax()
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadOperator() = viewModelScope.launch {
        di.getLatestOperatorUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Operator")
                    }
                }
                Resource.Status.ERROR -> {
                }
            }
        }
    }

//    private fun downloadProvince(): Job = viewModelScope.launch {
//        downloadInteractor.getLatestProvinceUseCase.invoke(page).collect {
//            when(it.status){
//                Resource.Status.LOADING -> {
//                    _state.update {
//                        it.copy(
//                            status = "Download Province"
//                        )
//                    }
//                }
//                Resource.Status.SUCCESS ->{
//                    it.data?.let { data ->
//                        provinceRepository.insertBulkProvince(
//                            data.data.data.map { ProvinceDataMapper.fromResponseToData(it) }
//                        )
//                        page++
//                        if (data.data.page <= data.data.total_page){
//                            downloadProvince()
//                        }else{
//                            _state.update {
//                                it.copy(
//                                    status = "Finish Download Province"
//                                )
//                            }
//                            page = 1
//                            downloadRegency()
//                        }
//                    }
//                }
//                Resource.Status.ERROR ->{
//
//                }
//            }
//        }
//    }

    private fun downloadCrc() : Job = viewModelScope.launch {
        di.getLatestCrcUseCase().collect {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Crc")
                    }
                    downloadPrice()
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }


//    private fun downloadRegency(): Job = viewModelScope.launch {
//        downloadInteractor.getLatestRegencyUseCase.invoke(page).collect {
//            when(it.status){
//                Resource.Status.LOADING ->{
//                    _state.update {
//                        it.copy(
//                            status = "Download Regency"
//                        )
//                    }
//                }
//                Resource.Status.SUCCESS ->{
//                    it.data?.let { data ->
//                        regencyRepository.insertBulkRegency(
//                            data.data.data.map { RegencyDataMapper.fromResponseToData(it) }
//                        )
//                        page++
//                        if (data.data.page <= data.data.total_page){
//                            downloadRegency()
//                        }else{
//                            _state.update {
//                                it.copy(
//                                    status = "Finish Download Regency"
//                                )
//                            }
//                            page = 1
//                            downloadDistrict()
//                        }
//                    }
//                }
//                Resource.Status.ERROR ->{
//
//
//                }
//            }
//        }
//    }

    private fun downloadCmp() = viewModelScope.launch {
        di.getLatestCmpUseCase().collect {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
//                    downloadProvince()
                    _state.update {
                        it.copy(status = "Finish Downloading Cmp")
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadDistrict(): Job = viewModelScope.launch {
        di.getLatestDistrictUseCase.invoke(page).collect {
            when(it.status){
                Resource.Status.LOADING ->{
                    _state.update {
                        it.copy(
                            status = "Download District"
                        )
                    }
                }
                Resource.Status.SUCCESS ->{
                    it.data?.let { data ->
                        districtRepository.insertBulkDistrict(
                            data.data.data.map { DistrictDataMapper.fromNetworkToDb(it) }
                        )
                        page++
                        if (data.data.page <= data.data.total_page){
                            downloadDistrict()
                        }else{
                            downloadPrice()
                            _state.update {
                                it.copy(
                                    status = "Finish Download District"
                                )
                            }
                        }
                    }

                }
                Resource.Status.ERROR -> {
                    downloadPrice()
                }
            }
        }
    }

    private fun downloadPrice() = viewModelScope.launch {
        di.getLatestPriceUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Price")
                    }
                }
                Resource.Status.SUCCESS -> {
                    downloadItemBranch()
                    _state.update {
                        it.copy(status = "Finish Downloading Price")
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadItemBranch() = viewModelScope.launch {
        di.getLatestItemBranchUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Item Branch")
                    }
                }
                Resource.Status.SUCCESS -> {
                    downloadCity()
                    _state.update {
                        it.copy(status = "Finish Downloading Item Branch")
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadItemSaleTax() = viewModelScope.launch {
        di.getLatestItemSaleTaxUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Item Sale Tax")
                    }
                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Item Sale Tax")
                    }
                    downloadTax()
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadTax() = viewModelScope.launch {
        di.getLatestTaxUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Tax")
                    }
                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Tax")
                    }
                    downloadEdc()
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadEdc() = viewModelScope.launch {
        di.getLatestEdcUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Edc")
                    }
                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Edc")
                    }
                    downloadEdcSurc()
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadEdcSurc() = viewModelScope.launch {
        di.getLatestEdcSurcUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Edc Surc")
                    }
                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Edc Surc")
                    }
                    downloadCcType()
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadCcType() = viewModelScope.launch {
        di.getLatestCcTypeUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Cc Type")
                    }
                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Cc Type")
                    }
                    downloadPmtd()
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadPmtd() = viewModelScope.launch {
        di.getLatestPmtdUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Pmtd")
                    }
                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Pmtd")
                    }
                    downloadUnit()
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadUnit() = viewModelScope.launch {
        di.getLatestUnitUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Unit")
                    }
                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Unit")
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    suspend fun awaitAll(vararg blocks: suspend () -> Unit) = viewModelScope.launch {
        blocks.forEach {
            launch { it() }
        }
    }

}