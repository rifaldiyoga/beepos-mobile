package com.bits.bee.bpmc.data.repository

import android.content.res.Resources
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.post.RegisterPost
import com.bits.bee.bpmc.data.data_source.remote.response.RegisterResponse
import com.bits.bee.bpmc.utils.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InfoBisnisRepository @Inject constructor(
    private val api: ApiUtils,
    private val provideContext: ProvideContext
) {
    lateinit var utm: RegisterPost.UTM
    var strRegid: String = BeePreferenceManager.getDataFromPreferences(provideContext.getContext(),
        Resources.getSystem().getString(R.string.pref_regid), "") as String

     fun infoBisnis(
        namaPerusahaan: String,
        tipe: String,
        kota: String,
        alamat: String
    ): Flow<Resource<RegisterResponse>> {
        utm = RegisterPost.UTM(
            "ANDROID",
            "",
            "",
            "",
            ""
        )

        val infoBisnisPost = RegisterPost(
            false,
            "",
            "",
            alamat,
            kota,
            tipe,
            "lainnya",
            namaPerusahaan,
            "",
            strRegid,
            2,
            1,
            "",
            utm
        )
        return object : NetworkBoundResource<RegisterResponse>(){
            override fun createCall(): Flow<ApiResponse<RegisterResponse>> {
                return api.getAuthApiService().signup(infoBisnisPost)
            }
        }.getAsFlow()
    }

    fun setSpinner(){

    }

}