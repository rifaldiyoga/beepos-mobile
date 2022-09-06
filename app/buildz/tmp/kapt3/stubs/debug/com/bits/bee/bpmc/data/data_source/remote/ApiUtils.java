package com.bits.bee.bpmc.data.data_source.remote;

import java.lang.System;

/**
 * Created by aldi on 25/02/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00e4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020&J\u0006\u0010\'\u001a\u00020(J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u00020:J\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020BJ\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020HJ\u0006\u0010I\u001a\u00020JR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006K"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/ApiUtils;", "", "retrofitClient", "Lcom/bits/bee/bpmc/data/data_source/remote/RetrofitClient;", "(Lcom/bits/bee/bpmc/data/data_source/remote/RetrofitClient;)V", "getAddOnApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/AddOnApiService;", "getAddOnDApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/AddOnDApiService;", "getAuthApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/AuthApiService;", "getBpApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/BpApiService;", "getBranchApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/BranchApiService;", "getCashierApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/CashierApiService;", "getCcTypeApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/CcTypeApiService;", "getChannelApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/ChannelApiService;", "getCityApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/CityApiService;", "getCmpApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/CmpApiService;", "getCrcApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/CrcApiService;", "getDistrictApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/DistrictApiService;", "getEdcApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/EdcApiService;", "getEdcSurcApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/EdcSurcApiService;", "getGrpPrvApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/GrpPrvApiService;", "getInitialApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/InitialApiService;", "getItemAddOnApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/ItemAddOnApiService;", "getItemApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/ItemApiService;", "getItemGroupApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/ItemGroupApiService;", "getItemVariantApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/ItemVariantApiService;", "getPmtdApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/PmtdApiService;", "getPriceApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/PriceApiService;", "getPriceLvlApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/PriceLvlApiService;", "getPromoApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/PromoApiService;", "getProvinceApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/ProvinceApiService;", "getRegApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/RegApiService;", "getRegencyApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/RegencyApiService;", "getSelectionApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/SelectionApiService;", "getSelectionDApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/SelectionDApiService;", "getSignUpApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/SignUpApiService;", "getStockApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/StockApiService;", "getTaxApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/TaxApiService;", "getUnitApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/UnitApiService;", "getUsrGrpApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/UsrGrpApiService;", "getVariantApiService", "Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/VariantApiService;", "app_debug"})
public final class ApiUtils {
    private final com.bits.bee.bpmc.data.data_source.remote.RetrofitClient retrofitClient = null;
    
    @javax.inject.Inject()
    public ApiUtils(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.RetrofitClient retrofitClient) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.AuthApiService getAuthApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.BranchApiService getBranchApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.CashierApiService getCashierApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.CityApiService getCityApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.BpApiService getBpApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.TaxApiService getTaxApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.PmtdApiService getPmtdApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.ChannelApiService getChannelApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.ItemGroupApiService getItemGroupApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.ItemApiService getItemApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.PriceLvlApiService getPriceLvlApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.CrcApiService getCrcApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.CmpApiService getCmpApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.AddOnApiService getAddOnApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.AddOnDApiService getAddOnDApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.ItemAddOnApiService getItemAddOnApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.VariantApiService getVariantApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.ItemVariantApiService getItemVariantApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.SelectionApiService getSelectionApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.SelectionDApiService getSelectionDApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.RegApiService getRegApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.PromoApiService getPromoApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.GrpPrvApiService getGrpPrvApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.UsrGrpApiService getUsrGrpApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.CcTypeApiService getCcTypeApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.EdcApiService getEdcApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.EdcSurcApiService getEdcSurcApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.ProvinceApiService getProvinceApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.RegencyApiService getRegencyApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.DistrictApiService getDistrictApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.InitialApiService getInitialApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.PriceApiService getPriceApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.StockApiService getStockApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.UnitApiService getUnitApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.apiservices.SignUpApiService getSignUpApiService() {
        return null;
    }
}