package com.bits.bee.bpmc.data.data_source.remote

import com.bits.bee.bpmc.data.data_source.remote.apiservices.*
import javax.inject.Inject

/**
 * Created by aldi on 25/02/22.
 */

class ApiUtils @Inject constructor(private val retrofitClient: RetrofitClient) {

    fun getAuthApiService() : AuthApiService {
        return retrofitClient.getClientProvision()!!.create(AuthApiService::class.java)
    }

    fun getBranchApiService() : BranchApiService {
        return retrofitClient.getClientApi()!!.create(BranchApiService::class.java)
    }

    fun getCashierApiService() : CashierApiService {
        return retrofitClient.getClientApi()!!.create(CashierApiService::class.java)
    }

    fun getCityApiService() : CityApiService {
        return retrofitClient.getClientApi()!!.create(CityApiService::class.java)
    }

    fun getBpApiService() : BpApiService {
        return retrofitClient.getClientApi()!!.create(BpApiService::class.java)
    }

    fun getTaxApiService() : TaxApiService {
        return retrofitClient.getClientApi()!!.create(TaxApiService::class.java)
    }

    fun getPmtdApiService() : PmtdApiService {
        return retrofitClient.getClientApi()!!.create(PmtdApiService::class.java)
    }

    fun getChannelApiService() : ChannelApiService {
        return retrofitClient.getClientApi()!!.create(ChannelApiService::class.java)
    }

    fun getItemGroupApiService() : ItemGroupApiService {
        return retrofitClient.getClientApi()!!.create(ItemGroupApiService::class.java)
    }

    fun getItemApiService() : ItemApiService {
        return retrofitClient.getClientApi()!!.create(ItemApiService::class.java)
    }

    fun getPriceLvlApiService() : PriceLvlApiService {
        return retrofitClient.getClientApi()!!.create(PriceLvlApiService::class.java)
    }

    fun getProvinceApiService() : ProvinceApiService {
        return retrofitClient.getClientApi()!!.create(ProvinceApiService::class.java)
    }

    fun getRegencyApiService(): RegencyApiService{
        return retrofitClient.getClientApi()!!.create(RegencyApiService::class.java)
    }

    fun getDistrictApiService(): DistrictApiService{
        return retrofitClient.getClientApi()!!.create(DistrictApiService::class.java)
    }

}