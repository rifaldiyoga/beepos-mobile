package com.bits.bee.bpmc.presentation.ui.cari_kota;

import java.lang.System;

/**
 * Created by aldi on 13/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003Jw\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00c6\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u000203H\u00d6\u0001J\t\u00104\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017\u00a8\u00065"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/cari_kota/CariKotaState;", "", "cari", "", "cityListRekomendasi", "", "Lcom/bits/bee/bpmc/domain/model/City;", "cityListCari", "nameList", "errorMsg", "regencyListCari", "Lcom/bits/bee/bpmc/domain/model/Regency;", "etKota", "district", "Lcom/bits/bee/bpmc/domain/model/District;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/bits/bee/bpmc/domain/model/District;)V", "getCari", "()Ljava/lang/String;", "setCari", "(Ljava/lang/String;)V", "getCityListCari", "()Ljava/util/List;", "setCityListCari", "(Ljava/util/List;)V", "getCityListRekomendasi", "setCityListRekomendasi", "getDistrict", "()Lcom/bits/bee/bpmc/domain/model/District;", "setDistrict", "(Lcom/bits/bee/bpmc/domain/model/District;)V", "getErrorMsg", "setErrorMsg", "getEtKota", "setEtKota", "getNameList", "setNameList", "getRegencyListCari", "setRegencyListCari", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class CariKotaState {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String cari;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.bits.bee.bpmc.domain.model.City> cityListRekomendasi;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.bits.bee.bpmc.domain.model.City> cityListCari;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.String> nameList;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String errorMsg;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.bits.bee.bpmc.domain.model.Regency> regencyListCari;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String etKota;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.District district;
    
    /**
     * Created by aldi on 13/05/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.cari_kota.CariKotaState copy(@org.jetbrains.annotations.NotNull()
    java.lang.String cari, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.City> cityListRekomendasi, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.City> cityListCari, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> nameList, @org.jetbrains.annotations.NotNull()
    java.lang.String errorMsg, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Regency> regencyListCari, @org.jetbrains.annotations.Nullable()
    java.lang.String etKota, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.District district) {
        return null;
    }
    
    /**
     * Created by aldi on 13/05/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 13/05/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 13/05/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public CariKotaState() {
        super();
    }
    
    public CariKotaState(@org.jetbrains.annotations.NotNull()
    java.lang.String cari, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.City> cityListRekomendasi, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.City> cityListCari, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> nameList, @org.jetbrains.annotations.NotNull()
    java.lang.String errorMsg, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Regency> regencyListCari, @org.jetbrains.annotations.Nullable()
    java.lang.String etKota, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.District district) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCari() {
        return null;
    }
    
    public final void setCari(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.City> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.City> getCityListRekomendasi() {
        return null;
    }
    
    public final void setCityListRekomendasi(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.City> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.City> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.City> getCityListCari() {
        return null;
    }
    
    public final void setCityListCari(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.City> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getNameList() {
        return null;
    }
    
    public final void setNameList(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getErrorMsg() {
        return null;
    }
    
    public final void setErrorMsg(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Regency> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Regency> getRegencyListCari() {
        return null;
    }
    
    public final void setRegencyListCari(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Regency> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEtKota() {
        return null;
    }
    
    public final void setEtKota(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.District component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.District getDistrict() {
        return null;
    }
    
    public final void setDistrict(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.District p0) {
    }
}