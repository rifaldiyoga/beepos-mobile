package com.bits.bee.bpmc.presentation.ui.sign_up.info_bisnis

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.bits.bee.bpmc.data.data_source.remote.response.BidangUsahaResponse
import com.bits.bee.bpmc.data.data_source.remote.response.SignUpResponse
import com.bits.bee.bpmc.domain.model.Utm
import com.bits.bee.bpmc.domain.usecase.common.GetLatestCityUseCase
import com.bits.bee.bpmc.domain.usecase.signup.GetBidangUsahaUseCase
import com.bits.bee.bpmc.domain.usecase.signup.PostSignUpUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


@HiltViewModel
class InfoBisnisViewModel @Inject constructor(
    private val getLatestCityUseCase: GetLatestCityUseCase,
    private val postSignUpUseCase: PostSignUpUseCase,
    private val getBidangUsahaUseCase: GetBidangUsahaUseCase
) : BaseViewModel<InfoBisnisState,InfoBisnisViewModel.UIEvent >() {

    init {
        state = InfoBisnisState()
    }

    var usahaList = mutableListOf<BidangUsahaResponse.DataUsaha>()

    var kategoriList = mutableListOf<String>()

    val cityList = getLatestCityUseCase(true)

    val bidangUsahaList = getBidangUsahaUseCase()

    private var registerResponse: MediatorLiveData<Resource<SignUpResponse>> = MediatorLiveData()
    fun observeSignUpResponse() = registerResponse as LiveData<Resource<SignUpResponse>>

    suspend fun postSignUp(context : Context) : Flow<Resource<SignUpResponse>> {
        state.signUp?.let {
            val utm = Utm(
                "ANDROID"
            )

            val utmData: String = BeePreferenceManager.getDataFromPreferences(context, "utm", "") as String
            val utms: Array<String>

            val utmList: MutableList<String> = ArrayList()
            utmList.add("utm_source")
            utmList.add("utm_medium")
            utmList.add("utm_campaign")
            utmList.add("utm_term")
            utmList.add("utm_content")
            if (utmData.isNotEmpty()) {
                utms = utmData.split("&".toRegex()).toTypedArray()
                if (utms.isNotEmpty()) {
                    for (i in utms.indices) {
                        if (utms[i].contains("utm_source")) {
                            val utmVal = utms[i].split("=".toRegex()).toTypedArray()
                            utm. utm_source = if (utmVal[1] == "google-play") "ANDROID" else "ANDR-ADS"
                        }
                        if (utms[i].contains("utm_medium")) {
                            val utmVal = utms[i].split("=".toRegex()).toTypedArray()
                            utm.utm_medium = utmVal[1]
                        }
                        if (utms[i].contains("utm_campaign")) {
                            val utmVal = utms[i].split("=".toRegex()).toTypedArray()
                            utm.utm_campaign = utmVal[1]
                        }
                        if (utms[i].contains("utm_term")) {
                            val utmVal = utms[i].split("=".toRegex()).toTypedArray()
                            utm.utm_term = utmVal[1]
                        }
                        if (utms[i].contains("utm_content")) {
                            val utmVal = utms[i].split("=".toRegex()).toTypedArray()
                            utm.utm_content = utmVal[1]
                        }
                    }
                }
            }

            val signUp = it.copy(
                namaPerusahaan = state.namaPerusahaan,
                address = state.alamat,
                bidangUsah = usahaList.firstOrNull { it.name == state.tipeUsaha }?.id.toString(),
                step = 2,
                utm_content = utm.utm_content,
                utm_source = utm.utm_source,
                utm_campaign = utm.utm_campaign,
                utm_medium = utm.utm_medium,
                utm_term = utm.utm_term,
            )
            return postSignUpUseCase(signUp, state.kota)
        }
        return flow {  }
    }

    sealed class UIEvent {

    }

}
//{"address":"Tes","bussiness":"5","city_id":"1","company":"Tes","cust_id":0,"dataUTM":{"utm_campaign":"","utm_content":"","utm_medium":"","utm_source":"ANDROID","utm_term":""},"email":"hafis@beeaccounting.comm","mobile":"08454554588","otp_tipe":"WA","regid":"46649","step":2,"username":"Tes"}