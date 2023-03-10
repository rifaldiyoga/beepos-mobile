package com.bits.bee.bpmc.data.data_source.remote

import com.bits.bee.bpmc.data.data_source.remote.apiservices.*
import com.bits.bee.bpmc.utils.BPMConstants
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

    fun getCrcApiService() : CrcApiService {
        return retrofitClient.getClientApi()!!.create(CrcApiService::class.java)
    }

    fun getCmpApiService() : CmpApiService {
        return retrofitClient.getClientApi()!!.create(CmpApiService::class.java)
    }

    fun getAddOnApiService() : AddOnApiService {
        return retrofitClient.getClientApi()!!.create(AddOnApiService::class.java)
    }

    fun getAddOnDApiService() : AddOnDApiService {
        return retrofitClient.getClientApi()!!.create(AddOnDApiService::class.java)
    }

    fun getItemAddOnApiService() : ItemAddOnApiService {
        return retrofitClient.getClientApi()!!.create(ItemAddOnApiService::class.java)
    }

    fun getVariantApiService() : VariantApiService {
        return retrofitClient.getClientApi()!!.create(VariantApiService::class.java)
    }

    fun getItemVariantApiService() : ItemVariantApiService {
        return retrofitClient.getClientApi()!!.create(ItemVariantApiService::class.java)
    }

    fun getSelectionApiService() : SelectionApiService {
        return retrofitClient.getClientApi()!!.create(SelectionApiService::class.java)
    }

    fun getSelectionDApiService() : SelectionDApiService {
        return retrofitClient.getClientApi()!!.create(SelectionDApiService::class.java)
    }

    fun getRegApiService() : RegApiService {
        return retrofitClient.getClientApi()!!.create(RegApiService::class.java)
    }

    fun getPromoApiService() : PromoApiService {
        return retrofitClient.getClientApi()!!.create(PromoApiService::class.java)
    }

    fun getGrpPrvApiService() : GrpPrvApiService {
        return retrofitClient.getClientApi()!!.create(GrpPrvApiService::class.java)
    }

    fun getUsrGrpApiService() : UsrGrpApiService {
        return retrofitClient.getClientApi()!!.create(UsrGrpApiService::class.java)
    }

    fun getCcTypeApiService() : CcTypeApiService {
        return retrofitClient.getClientApi()!!.create(CcTypeApiService::class.java)
    }

    fun getEdcApiService() : EdcApiService {
        return retrofitClient.getClientApi()!!.create(EdcApiService::class.java)
    }

    fun getEdcSurcApiService() : EdcSurcApiService {
        return retrofitClient.getClientApi()!!.create(EdcSurcApiService::class.java)
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

    fun getInitialApiService(): InitialApiService{
        return retrofitClient.getClientApi()!!.create(InitialApiService::class.java)
    }

    fun getPriceApiService(): PriceApiService{
        return retrofitClient.getClientApi()!!.create(PriceApiService::class.java)
    }

    fun getStockApiService(): StockApiService{
        return retrofitClient.getClientApi()!!.create(StockApiService::class.java)
    }

    fun getUnitApiService(): UnitApiService{
        return retrofitClient.getClientApi()!!.create(UnitApiService::class.java)
    }

    fun getSignUpApiService() : SignUpApiService {
        return retrofitClient.getClientProvision(BPMConstants.API_MY)!!.create(SignUpApiService::class.java)
    }

    fun getItemDummyApiService() : ItemDummyApiService {
        return retrofitClient.getClientApi()!!.create(ItemDummyApiService::class.java)
    }

    fun getSyncApiService() : SyncApiService {
        return retrofitClient.getClientApi()!!.create(SyncApiService::class.java)
    }

    fun getLicenseApiService() : LicenseApiService {
        return retrofitClient.getClientApi()!!.create(LicenseApiService::class.java)
    }

    fun getGopayApiService() : GopayApiService {
        return retrofitClient.getClientApi()!!.create(GopayApiService::class.java)
    }

    fun getKitchenApiService() : KitchenApiService {
        return retrofitClient.getClientApi()!!.create(KitchenApiService::class.java)
    }

}