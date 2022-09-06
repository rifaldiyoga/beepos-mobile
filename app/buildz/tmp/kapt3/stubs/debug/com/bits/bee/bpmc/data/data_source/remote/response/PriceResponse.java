package com.bits.bee.bpmc.data.data_source.remote.response;

import java.lang.System;

/**
 * Created by aldi on 14/07/22.
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001 B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014H\u00d6\u0001R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006!"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/PriceResponse;", "Landroid/os/Parcelable;", "status", "", "data", "", "Lcom/bits/bee/bpmc/data/data_source/remote/response/PriceResponse$ItemPriceData;", "(ZLjava/util/List;)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getStatus", "()Z", "setStatus", "(Z)V", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ItemPriceData", "app_debug"})
public final class PriceResponse implements android.os.Parcelable {
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "status")
    private boolean status;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "data")
    private java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse.ItemPriceData> data;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse> CREATOR = null;
    
    /**
     * Created by aldi on 14/07/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse copy(boolean status, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse.ItemPriceData> data) {
        return null;
    }
    
    /**
     * Created by aldi on 14/07/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 14/07/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 14/07/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public PriceResponse(boolean status, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse.ItemPriceData> data) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean getStatus() {
        return false;
    }
    
    public final void setStatus(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse.ItemPriceData> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse.ItemPriceData> getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse.ItemPriceData> p0) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse[] newArray(int size) {
            return null;
        }
    }
    
    @kotlinx.parcelize.Parcelize()
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\bI\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0016J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\t\u0010@\u001a\u00020\tH\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\tH\u00c6\u0003J\t\u0010D\u001a\u00020\tH\u00c6\u0003J\t\u0010E\u001a\u00020\tH\u00c6\u0003J\t\u0010F\u001a\u00020\tH\u00c6\u0003J\t\u0010G\u001a\u00020\tH\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010L\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010N\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u00b9\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\tH\u00c6\u0001J\t\u0010Q\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010UH\u00d6\u0003J\t\u0010V\u001a\u00020\u0003H\u00d6\u0001J\t\u0010W\u001a\u00020\tH\u00d6\u0001J\u0019\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR \u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR \u0010\r\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001e\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001e\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u001e\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00100\"\u0004\b4\u00102R\u001e\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00100\"\u0004\b6\u00102R\u001e\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001eR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0018\"\u0004\b:\u0010\u001aR\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u001aR\u001e\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001c\"\u0004\b>\u0010\u001e\u00a8\u0006]"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/PriceResponse$ItemPriceData;", "Landroid/os/Parcelable;", "itemId", "", "pricelvlId", "crcId", "price1", "Ljava/math/BigDecimal;", "disc1exp", "", "price2", "disc2exp", "price3", "disc3exp", "pricedate", "usrId", "lastpurcprice", "lastavgcost", "itemid", "crcid", "usrid", "prclvlid", "(IIILjava/math/BigDecimal;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCrcId", "()I", "setCrcId", "(I)V", "getCrcid", "()Ljava/lang/String;", "setCrcid", "(Ljava/lang/String;)V", "getDisc1exp", "setDisc1exp", "getDisc2exp", "setDisc2exp", "getDisc3exp", "setDisc3exp", "getItemId", "setItemId", "getItemid", "setItemid", "getLastavgcost", "setLastavgcost", "getLastpurcprice", "setLastpurcprice", "getPrclvlid", "setPrclvlid", "getPrice1", "()Ljava/math/BigDecimal;", "setPrice1", "(Ljava/math/BigDecimal;)V", "getPrice2", "setPrice2", "getPrice3", "setPrice3", "getPricedate", "setPricedate", "getPricelvlId", "setPricelvlId", "getUsrId", "setUsrId", "getUsrid", "setUsrid", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
    public static final class ItemPriceData implements android.os.Parcelable {
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "item_id")
        private int itemId;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "pricelvl_id")
        private int pricelvlId;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "crc_id")
        private int crcId;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "price1")
        private java.math.BigDecimal price1;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "disc1exp")
        private java.lang.String disc1exp;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "price2")
        private java.math.BigDecimal price2;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "disc2exp")
        private java.lang.String disc2exp;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "price3")
        private java.math.BigDecimal price3;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "disc3exp")
        private java.lang.String disc3exp;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "pricedate")
        private java.lang.String pricedate;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "usr_id")
        private int usrId;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "lastpurcprice")
        private int lastpurcprice;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "lastavgcost")
        private java.lang.String lastavgcost;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "itemid")
        private java.lang.String itemid;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "crcid")
        private java.lang.String crcid;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "usrid")
        private java.lang.String usrid;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "prclvlid")
        private java.lang.String prclvlid;
        public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse.ItemPriceData> CREATOR = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse.ItemPriceData copy(int itemId, int pricelvlId, int crcId, @org.jetbrains.annotations.NotNull()
        java.math.BigDecimal price1, @org.jetbrains.annotations.Nullable()
        java.lang.String disc1exp, @org.jetbrains.annotations.NotNull()
        java.math.BigDecimal price2, @org.jetbrains.annotations.Nullable()
        java.lang.String disc2exp, @org.jetbrains.annotations.NotNull()
        java.math.BigDecimal price3, @org.jetbrains.annotations.Nullable()
        java.lang.String disc3exp, @org.jetbrains.annotations.NotNull()
        java.lang.String pricedate, int usrId, int lastpurcprice, @org.jetbrains.annotations.NotNull()
        java.lang.String lastavgcost, @org.jetbrains.annotations.NotNull()
        java.lang.String itemid, @org.jetbrains.annotations.NotNull()
        java.lang.String crcid, @org.jetbrains.annotations.NotNull()
        java.lang.String usrid, @org.jetbrains.annotations.NotNull()
        java.lang.String prclvlid) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public ItemPriceData(int itemId, int pricelvlId, int crcId, @org.jetbrains.annotations.NotNull()
        java.math.BigDecimal price1, @org.jetbrains.annotations.Nullable()
        java.lang.String disc1exp, @org.jetbrains.annotations.NotNull()
        java.math.BigDecimal price2, @org.jetbrains.annotations.Nullable()
        java.lang.String disc2exp, @org.jetbrains.annotations.NotNull()
        java.math.BigDecimal price3, @org.jetbrains.annotations.Nullable()
        java.lang.String disc3exp, @org.jetbrains.annotations.NotNull()
        java.lang.String pricedate, int usrId, int lastpurcprice, @org.jetbrains.annotations.NotNull()
        java.lang.String lastavgcost, @org.jetbrains.annotations.NotNull()
        java.lang.String itemid, @org.jetbrains.annotations.NotNull()
        java.lang.String crcid, @org.jetbrains.annotations.NotNull()
        java.lang.String usrid, @org.jetbrains.annotations.NotNull()
        java.lang.String prclvlid) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int getItemId() {
            return 0;
        }
        
        public final void setItemId(int p0) {
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int getPricelvlId() {
            return 0;
        }
        
        public final void setPricelvlId(int p0) {
        }
        
        public final int component3() {
            return 0;
        }
        
        public final int getCrcId() {
            return 0;
        }
        
        public final void setCrcId(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.math.BigDecimal component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.math.BigDecimal getPrice1() {
            return null;
        }
        
        public final void setPrice1(@org.jetbrains.annotations.NotNull()
        java.math.BigDecimal p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDisc1exp() {
            return null;
        }
        
        public final void setDisc1exp(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.math.BigDecimal component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.math.BigDecimal getPrice2() {
            return null;
        }
        
        public final void setPrice2(@org.jetbrains.annotations.NotNull()
        java.math.BigDecimal p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDisc2exp() {
            return null;
        }
        
        public final void setDisc2exp(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.math.BigDecimal component8() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.math.BigDecimal getPrice3() {
            return null;
        }
        
        public final void setPrice3(@org.jetbrains.annotations.NotNull()
        java.math.BigDecimal p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component9() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDisc3exp() {
            return null;
        }
        
        public final void setDisc3exp(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component10() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPricedate() {
            return null;
        }
        
        public final void setPricedate(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final int component11() {
            return 0;
        }
        
        public final int getUsrId() {
            return 0;
        }
        
        public final void setUsrId(int p0) {
        }
        
        public final int component12() {
            return 0;
        }
        
        public final int getLastpurcprice() {
            return 0;
        }
        
        public final void setLastpurcprice(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component13() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLastavgcost() {
            return null;
        }
        
        public final void setLastavgcost(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component14() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getItemid() {
            return null;
        }
        
        public final void setItemid(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component15() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCrcid() {
            return null;
        }
        
        public final void setCrcid(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component16() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUsrid() {
            return null;
        }
        
        public final void setUsrid(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component17() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPrclvlid() {
            return null;
        }
        
        public final void setPrclvlid(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @java.lang.Override()
        public int describeContents() {
            return 0;
        }
        
        @java.lang.Override()
        public void writeToParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel, int flags) {
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
        public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse.ItemPriceData> {
            
            public Creator() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse.ItemPriceData createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel in) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse.ItemPriceData[] newArray(int size) {
                return null;
            }
        }
    }
}