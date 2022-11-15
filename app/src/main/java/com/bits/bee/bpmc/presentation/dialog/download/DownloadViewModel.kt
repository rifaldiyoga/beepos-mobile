package com.bits.bee.bpmc.presentation.dialog.download

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.mapper.DistrictDataMapper
import com.bits.bee.bpmc.domain.repository.DistrictRepository
import com.bits.bee.bpmc.domain.usecase.download.DownloadInteractor
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 29/03/22.
 */

@HiltViewModel
class DownloadViewModel @Inject constructor (
    private val districtRepository: DistrictRepository,
    private val di: DownloadInteractor,
) : BaseViewModel<DownloadState, DownloadViewModel.UIEvent>() {

    private var page : Int = 1
    private val progressPercent = 100 / 25

    init {
        state = DownloadState()
        downloadAll()
    }

    private fun downloadAll() = viewModelScope.launch(Dispatchers.Main) {
        downloadItemGroup()
        downloadPriceLvl()
        downloadChannel()
        downloadBp()
        downloadItem()
        downloadCity()
        downloadPrice()
        downloadItemBranch()
        downloadItemSaleTax()
        downloadTax()
        downloadEdc()
        downloadEdcSurc()
        downloadCcType()
        downloadPmtd()
        downloadUnit()
        downloadAddOn()
        downloadSelection()
        downloadSelectionD()
        downloadAddOnD()
        downloadItemAddOn()
        downloadVariant()
        downloadItemVariant()
        downloadPromo()
        downloadPromoMulti()
        downloadUsrGrp()
        downloadGrpPrv()
        onFinsihDownload()
    }

    private suspend fun downloadItemGroup()  {
        di.getLatestItemGroupUseCase(page).collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Item Group")
                    )
                }
                Resource.Status.SUCCESS -> {
                    it.data?.let { _ ->
                        updateState(
                            state.copy(
                                status = "Finish Downloading Item Group",
                                progress = state.progress + progressPercent
                            )
                        )
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadChannel()  {
        di.getLatestChannelUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Channel")
                    )

                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Channel",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadBp()  {
        di.getLatestBpUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {

                    updateState(
                        state.copy(status = "Downloading Bp")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Bp",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadPriceLvl()  {
        di.getLatestPriceLvlUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Price Lvl")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Price Lvl",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadItem()  {
        di.getLatestItemUseCase(page).collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Item")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Item",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadCity()  {
        di.getLatestCityUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading City")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading City",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadOperator()  {
        di.getLatestOperatorUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Operator",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {
                }
            }
        }
    }

    private suspend fun downloadProvince()  {
//        di.getLatestProvinceUseCase.invoke(page).collect {
//            when(it.status){
//                Resource.Status.LOADING -> {
//                    updateState(
//                       it.copy(
//                         status { = "Download Province"
//                       )
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
//                            updateState(
//                               it.copy(
//                                status { = "Finish Download Province"
//                               )
//                            }
//                            page = 1
//                        }
//                    }
//                }
//                Resource.Status.ERROR ->{
//
//                }
//            }
//        }
    }

    private suspend fun downloadCrc()  {
        di.getLatestCrcUseCase().collect {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Crc",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadRegency() {
//        downloadInteractor.getLatestRegencyUseCase.invoke(page).collect {
//            when(it.status){
//                Resource.Status.LOADING ->{
//                    updateState(
//                       it.copy(
//state                          status { = "Download Regency"
//                       )
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
//                            updateState(
//                               it.copy(
//state                                  status { = "Finish Download Regency"
//                               )
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
    }

    private suspend fun downloadCmp()  {
        di.getLatestCmpUseCase().collect {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Cmp")
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadDistrict() {
        di.getLatestDistrictUseCase.invoke(page).collect {
            when(it.status){
                Resource.Status.LOADING ->{
                    updateState( state.copy(status  = "Download District"))
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
                            updateState( state.copy(status  = "Finish Download District"))
                        }
                    }

                }
                Resource.Status.ERROR -> {
                    downloadPrice()
                }
            }
        }
    }

    private suspend fun downloadPrice()  {
        di.getLatestPriceUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Price")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Price",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadItemBranch()  {
        di.getLatestItemBranchUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Item Branch")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Item Branch",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadItemSaleTax()  {
        di.getLatestItemSaleTaxUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Item Sale Tax")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Item Sale Tax",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadTax()  {
        di.getLatestTaxUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Tax")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Tax",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadEdc()  {
        di.getLatestEdcUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Edc")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Edc",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadEdcSurc()  {
        di.getLatestEdcSurcUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Edc Surc")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Edc Surc",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadCcType()  {
        di.getLatestCcTypeUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Cc Type")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Cc Type",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadPmtd()  {
        di.getLatestPmtdUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Pmtd")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Pmtd",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadUnit()  {
        di.getLatestUnitUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Unit")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Unit",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadAddOn()  {
        di.getLatestAddOnUseCase().catch {
            it.printStackTrace()
        }.collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading AddOn")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading AddOn",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadSelection()  {
        di.getLatestSelectionUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Selection")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Selection",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadSelectionD()  {
        di.getLatestSelectionDUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading SelectionD")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading SelectionD",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadAddOnD()  {
        di.getLatestAddOnDUseCase().catch {
            it.printStackTrace()
        }.collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading AddOnD")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading AddOnD",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadItemAddOn()  {
        di.getLatestItemAddOnUseCase().catch {
            it.printStackTrace()
        }.collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading ItemAddOn")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading ItemAddOn",
                            progress = state.progress + progressPercent)
                    )
                    downloadVariant()
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadVariant()  {
        di.getLatestVariantUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Variant")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Variant",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadItemVariant()  {
        di.getLatestItemVariantUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading ItemVstateiant")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Item Variant",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadPromo()  {
        di.getLatestPromoUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Promo")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Promo",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadPromoMulti()  {
        di.getLatestPromoMultiUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Promo Multi")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Promo Multi",
                            progress = state.progress + progressPercent)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadUsrGrp()  {
        di.getLatestUsrGrpUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Usr Grp")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Usr Grp",
                            progress = 100)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadGrpPrv()  {
        di.getLatestGrpPrvUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Usr Grp")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Grp Prv",
                            progress = 100)
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private suspend fun downloadReg()  {
        di.getLatestRegUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    updateState(
                        state.copy(status = "Downloading Reg")
                    )
                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(status = "Finish Downloading Reg")
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    fun onFinsihDownload() = viewModelScope.launch{
        updateState(
            state.copy(progress = 100)
        )
        eventChannel.send(UIEvent.FinishDownload)
    }

    sealed class UIEvent {
        object FinishDownload : UIEvent()
    }

}