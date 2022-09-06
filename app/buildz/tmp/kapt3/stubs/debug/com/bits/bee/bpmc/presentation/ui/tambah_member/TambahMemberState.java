package com.bits.bee.bpmc.presentation.ui.tambah_member;

import java.lang.System;

/**
 * Created by aldi on 27/04/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\b\u0086\b\u0018\u00002\u00020\u0001B\u00bb\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0002\u0010\u001bJ\t\u0010I\u001a\u00020\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\t\u0010L\u001a\u00020\u0003H\u00c6\u0003J\t\u0010M\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0018H\u00c6\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u001aH\u00c6\u0003J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\t\u0010S\u001a\u00020\u0003H\u00c6\u0003J\t\u0010T\u001a\u00020\u0007H\u00c6\u0003J\t\u0010U\u001a\u00020\u0007H\u00c6\u0003J\t\u0010V\u001a\u00020\u0003H\u00c6\u0003J\t\u0010W\u001a\u00020\u0003H\u00c6\u0003J\t\u0010X\u001a\u00020\fH\u00c6\u0003J\t\u0010Y\u001a\u00020\u0007H\u00c6\u0003J\u00bf\u0001\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u00c6\u0001J\u0013\u0010[\u001a\u00020\u00072\b\u0010\\\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010]\u001a\u00020\fH\u00d6\u0001J\t\u0010^\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001fR\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001d\"\u0004\b-\u0010\u001fR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u00102\"\u0004\b3\u00104R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u00102\"\u0004\b5\u00104R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u00102\"\u0004\b6\u00104R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001d\"\u0004\b8\u0010\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001d\"\u0004\b:\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001d\"\u0004\b<\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H\u00a8\u0006_"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/tambah_member/TambahMemberState;", "", "namaMember", "", "noTelp", "alamat", "isTaxed", "", "isTaxInc", "kota", "email", "priceLvl", "", "isInfoLainnya", "errorNamaMember", "errorNoTelp", "errorAlamat", "errorEmail", "priceLvlList", "", "Lcom/bits/bee/bpmc/domain/model/PriceLvl;", "city", "Lcom/bits/bee/bpmc/domain/model/City;", "district", "Lcom/bits/bee/bpmc/domain/model/District;", "regency", "Lcom/bits/bee/bpmc/domain/model/Regency;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/bits/bee/bpmc/domain/model/City;Lcom/bits/bee/bpmc/domain/model/District;Lcom/bits/bee/bpmc/domain/model/Regency;)V", "getAlamat", "()Ljava/lang/String;", "setAlamat", "(Ljava/lang/String;)V", "getCity", "()Lcom/bits/bee/bpmc/domain/model/City;", "setCity", "(Lcom/bits/bee/bpmc/domain/model/City;)V", "getDistrict", "()Lcom/bits/bee/bpmc/domain/model/District;", "setDistrict", "(Lcom/bits/bee/bpmc/domain/model/District;)V", "getEmail", "setEmail", "getErrorAlamat", "setErrorAlamat", "getErrorEmail", "setErrorEmail", "getErrorNamaMember", "setErrorNamaMember", "getErrorNoTelp", "setErrorNoTelp", "()Z", "setInfoLainnya", "(Z)V", "setTaxInc", "setTaxed", "getKota", "setKota", "getNamaMember", "setNamaMember", "getNoTelp", "setNoTelp", "getPriceLvl", "()I", "setPriceLvl", "(I)V", "getPriceLvlList", "()Ljava/util/List;", "setPriceLvlList", "(Ljava/util/List;)V", "getRegency", "()Lcom/bits/bee/bpmc/domain/model/Regency;", "setRegency", "(Lcom/bits/bee/bpmc/domain/model/Regency;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class TambahMemberState {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String namaMember;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String noTelp;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String alamat;
    private boolean isTaxed;
    private boolean isTaxInc;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String kota;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String email;
    private int priceLvl;
    private boolean isInfoLainnya;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String errorNamaMember;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String errorNoTelp;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String errorAlamat;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String errorEmail;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.bits.bee.bpmc.domain.model.PriceLvl> priceLvlList;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.City city;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.District district;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Regency regency;
    
    /**
     * Created by aldi on 27/04/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.tambah_member.TambahMemberState copy(@org.jetbrains.annotations.NotNull()
    java.lang.String namaMember, @org.jetbrains.annotations.NotNull()
    java.lang.String noTelp, @org.jetbrains.annotations.NotNull()
    java.lang.String alamat, boolean isTaxed, boolean isTaxInc, @org.jetbrains.annotations.NotNull()
    java.lang.String kota, @org.jetbrains.annotations.NotNull()
    java.lang.String email, int priceLvl, boolean isInfoLainnya, @org.jetbrains.annotations.NotNull()
    java.lang.String errorNamaMember, @org.jetbrains.annotations.NotNull()
    java.lang.String errorNoTelp, @org.jetbrains.annotations.NotNull()
    java.lang.String errorAlamat, @org.jetbrains.annotations.NotNull()
    java.lang.String errorEmail, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.PriceLvl> priceLvlList, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.City city, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.District district, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Regency regency) {
        return null;
    }
    
    /**
     * Created by aldi on 27/04/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 27/04/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 27/04/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public TambahMemberState() {
        super();
    }
    
    public TambahMemberState(@org.jetbrains.annotations.NotNull()
    java.lang.String namaMember, @org.jetbrains.annotations.NotNull()
    java.lang.String noTelp, @org.jetbrains.annotations.NotNull()
    java.lang.String alamat, boolean isTaxed, boolean isTaxInc, @org.jetbrains.annotations.NotNull()
    java.lang.String kota, @org.jetbrains.annotations.NotNull()
    java.lang.String email, int priceLvl, boolean isInfoLainnya, @org.jetbrains.annotations.NotNull()
    java.lang.String errorNamaMember, @org.jetbrains.annotations.NotNull()
    java.lang.String errorNoTelp, @org.jetbrains.annotations.NotNull()
    java.lang.String errorAlamat, @org.jetbrains.annotations.NotNull()
    java.lang.String errorEmail, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.PriceLvl> priceLvlList, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.City city, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.District district, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Regency regency) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNamaMember() {
        return null;
    }
    
    public final void setNamaMember(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNoTelp() {
        return null;
    }
    
    public final void setNoTelp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAlamat() {
        return null;
    }
    
    public final void setAlamat(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean isTaxed() {
        return false;
    }
    
    public final void setTaxed(boolean p0) {
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean isTaxInc() {
        return false;
    }
    
    public final void setTaxInc(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKota() {
        return null;
    }
    
    public final void setKota(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getPriceLvl() {
        return 0;
    }
    
    public final void setPriceLvl(int p0) {
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean isInfoLainnya() {
        return false;
    }
    
    public final void setInfoLainnya(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getErrorNamaMember() {
        return null;
    }
    
    public final void setErrorNamaMember(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getErrorNoTelp() {
        return null;
    }
    
    public final void setErrorNoTelp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getErrorAlamat() {
        return null;
    }
    
    public final void setErrorAlamat(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getErrorEmail() {
        return null;
    }
    
    public final void setErrorEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.PriceLvl> component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.PriceLvl> getPriceLvlList() {
        return null;
    }
    
    public final void setPriceLvlList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.PriceLvl> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.City component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.City getCity() {
        return null;
    }
    
    public final void setCity(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.City p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.District component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.District getDistrict() {
        return null;
    }
    
    public final void setDistrict(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.District p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Regency component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Regency getRegency() {
        return null;
    }
    
    public final void setRegency(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Regency p0) {
    }
}