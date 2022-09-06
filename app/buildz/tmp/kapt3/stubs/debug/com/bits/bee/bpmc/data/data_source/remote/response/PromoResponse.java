package com.bits.bee.bpmc.data.data_source.remote.response;

import java.lang.System;

/**
 * Created by Med.
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u00d6\u0001R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/PromoResponse;", "Landroid/os/Parcelable;", "status", "", "data", "", "Lcom/bits/bee/bpmc/data/data_source/remote/response/PromoResponse$DataPromo;", "(ZLjava/util/List;)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getStatus", "()Z", "setStatus", "(Z)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "DataPromo", "app_debug"})
public final class PromoResponse implements android.os.Parcelable {
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "status")
    private boolean status;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "data")
    private java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse.DataPromo> data;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse> CREATOR = null;
    
    public PromoResponse() {
        super();
    }
    
    public PromoResponse(boolean status, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse.DataPromo> data) {
        super();
    }
    
    public final boolean getStatus() {
        return false;
    }
    
    public final void setStatus(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse.DataPromo> getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse.DataPromo> p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse[] newArray(int size) {
            return null;
        }
    }
    
    @kotlinx.parcelize.Parcelize()
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0003\b\u0099\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00d3\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\b\u0012\b\b\u0002\u0010\"\u001a\u00020\b\u0012\b\b\u0002\u0010#\u001a\u00020\b\u0012\b\b\u0002\u0010$\u001a\u00020\b\u0012\b\b\u0002\u0010%\u001a\u00020\b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\'\u001a\u00020\b\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010+\u001a\u00020\u0005\u0012\b\b\u0002\u0010,\u001a\u00020\u0005\u0012\b\b\u0002\u0010-\u001a\u00020\u0005\u0012\b\b\u0002\u0010.\u001a\u00020\u0005\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u00100\u001a\u00020\u0005\u00a2\u0006\u0002\u00101J\t\u0010\u007f\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0015H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010=J\n\u0010\u0089\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0093\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u0094\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0096\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u0097\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u0098\u0001\u001a\u00020\bH\u00c6\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\n\u0010\u009a\u0001\u001a\u00020\bH\u00c6\u0003J\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010=J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u00a0\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\n\u0010\u00a1\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00a2\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u00a3\u0001\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\n\u0010\u00a4\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00a5\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u00a6\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\f\u0010\u00a7\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\n\u0010\u00a8\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u00a9\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u00e0\u0003\u0010\u00aa\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001c\u001a\u00020\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\'\u001a\u00020\b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u00100\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0003\u0010\u00ab\u0001J\n\u0010\u00ac\u0001\u001a\u00020\u0003H\u00d6\u0001J\u0016\u0010\u00ad\u0001\u001a\u00020\u00052\n\u0010\u00ae\u0001\u001a\u0005\u0018\u00010\u00af\u0001H\u00d6\u0003J\n\u0010\u00b0\u0001\u001a\u00020\u0003H\u00d6\u0001J\n\u0010\u00b1\u0001\u001a\u00020\bH\u00d6\u0001J\u001e\u0010\u00b2\u0001\u001a\u00030\u00b3\u00012\b\u0010\u00b4\u0001\u001a\u00030\u00b5\u00012\u0007\u0010\u00b6\u0001\u001a\u00020\u0003H\u00d6\u0001R \u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00103\"\u0004\b7\u00105R \u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00103\"\u0004\b9\u00105R\u001e\u0010\"\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00105R\"\u0010(\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010@\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R \u0010/\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR \u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u00103\"\u0004\bF\u00105R \u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u00103\"\u0004\bH\u00105R \u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u00103\"\u0004\bJ\u00105R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010O\"\u0004\bP\u0010QR\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010O\"\u0004\bR\u0010QR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010O\"\u0004\bS\u0010QR\u001e\u00100\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010O\"\u0004\bT\u0010QR\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010O\"\u0004\bU\u0010QR\u001e\u0010+\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010O\"\u0004\bV\u0010QR\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010O\"\u0004\bW\u0010QR\u001e\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010O\"\u0004\bX\u0010QR\u001e\u0010,\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010O\"\u0004\bY\u0010QR\u001e\u0010.\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010O\"\u0004\bZ\u0010QR\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010O\"\u0004\b[\u0010QR\u001e\u0010-\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010O\"\u0004\b\\\u0010QR\u001e\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010O\"\u0004\b]\u0010QR\u001e\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010O\"\u0004\b^\u0010QR\u001e\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010O\"\u0004\b_\u0010QR\u001e\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010O\"\u0004\b`\u0010QR\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010O\"\u0004\ba\u0010QR \u0010&\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u00103\"\u0004\bc\u00105R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010@\u001a\u0004\bd\u0010=\"\u0004\be\u0010?R \u0010)\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010B\"\u0004\bg\u0010DR \u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u00103\"\u0004\bi\u00105R \u0010*\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010B\"\u0004\bV\u0010DR\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010B\"\u0004\bW\u0010DR \u0010\u001f\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010B\"\u0004\bX\u0010DR\u001e\u0010%\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u00103\"\u0004\bn\u00105R\u001e\u0010!\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u00103\"\u0004\bp\u00105R\u001e\u0010 \u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010L\"\u0004\br\u0010NR\u001e\u0010\'\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bs\u00103\"\u0004\bt\u00105R\u001e\u0010$\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u00103\"\u0004\bv\u00105R \u0010\n\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u00103\"\u0004\bx\u00105R \u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u00103\"\u0004\bz\u00105R\u001e\u0010#\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b{\u00103\"\u0004\b|\u00105R \u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b}\u00103\"\u0004\b~\u00105\u00a8\u0006\u00b7\u0001"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/PromoResponse$DataPromo;", "Landroid/os/Parcelable;", "id", "", "isActive", "", "isBranch", "branchId", "", "isPeriode", "startDate", "endDate", "isTime", "starttime", "endTime", "isDow", "dowExp", "isBpgrp1", "bpgrp1Id", "isMinAmt", "minAmt", "Ljava/math/BigDecimal;", "isTargetItem", "itemId", "isTargetItgrp1", "itemgrp1Id", "isTargetBrand", "brandId", "isTargetVendor", "vendorId", "isMinQty", "minQty", "priority", "offerType", "code", "type", "promoName", "note", "itemDiscExp", "promoCat", "dealItemId", "itemPrice", "maxQty", "isMaxQty", "isMinQtyMultiply", "isPriceOverride", "isMulti", "dealQty", "isDealSameItem", "(IZZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;ZLjava/math/BigDecimal;ZLjava/lang/Integer;ZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;ZLjava/math/BigDecimal;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/math/BigDecimal;ZZZZLjava/math/BigDecimal;Z)V", "getBpgrp1Id", "()Ljava/lang/String;", "setBpgrp1Id", "(Ljava/lang/String;)V", "getBranchId", "setBranchId", "getBrandId", "setBrandId", "getCode", "setCode", "getDealItemId", "()Ljava/lang/Integer;", "setDealItemId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDealQty", "()Ljava/math/BigDecimal;", "setDealQty", "(Ljava/math/BigDecimal;)V", "getDowExp", "setDowExp", "getEndDate", "setEndDate", "getEndTime", "setEndTime", "getId", "()I", "setId", "(I)V", "()Z", "setActive", "(Z)V", "setBpgrp1", "setBranch", "setDealSameItem", "setDow", "setMaxQty", "setMinAmt", "setMinQty", "setMinQtyMultiply", "setMulti", "setPeriode", "setPriceOverride", "setTargetBrand", "setTargetItem", "setTargetItgrp1", "setTargetVendor", "setTime", "getItemDiscExp", "setItemDiscExp", "getItemId", "setItemId", "getItemPrice", "setItemPrice", "getItemgrp1Id", "setItemgrp1Id", "getMaxQty", "getMinAmt", "getMinQty", "getNote", "setNote", "getOfferType", "setOfferType", "getPriority", "setPriority", "getPromoCat", "setPromoCat", "getPromoName", "setPromoName", "getStartDate", "setStartDate", "getStarttime", "setStarttime", "getType", "setType", "getVendorId", "setVendorId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component5", "component6", "component7", "component8", "component9", "copy", "(IZZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;ZLjava/math/BigDecimal;ZLjava/lang/Integer;ZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;ZLjava/math/BigDecimal;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/math/BigDecimal;ZZZZLjava/math/BigDecimal;Z)Lcom/bits/bee/bpmc/data/data_source/remote/response/PromoResponse$DataPromo;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
    public static final class DataPromo implements android.os.Parcelable {
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "id")
        private int id;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "isactive")
        private boolean isActive;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "isbranch")
        private boolean isBranch;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "branch_id")
        private java.lang.String branchId;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "isperiode")
        private boolean isPeriode;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "startdate")
        private java.lang.String startDate;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "enddate")
        private java.lang.String endDate;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "istime")
        private boolean isTime;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "starttime")
        private java.lang.String starttime;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "endtime")
        private java.lang.String endTime;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "isdow")
        private boolean isDow;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "dowexp")
        private java.lang.String dowExp;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "isbpgrp1")
        private boolean isBpgrp1;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "bpgrp1_id")
        private java.lang.String bpgrp1Id;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "isminamt")
        private boolean isMinAmt;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "minamt")
        private java.math.BigDecimal minAmt;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "istargetitem")
        private boolean isTargetItem;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "item_id")
        private java.lang.Integer itemId;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "istargetitgrp1")
        private boolean isTargetItgrp1;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "itemgrp1_id")
        private java.lang.String itemgrp1Id;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "istargetbrand")
        private boolean isTargetBrand;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "brand_id")
        private java.lang.String brandId;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "istargetvendor")
        private boolean isTargetVendor;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "vendor_id")
        private java.lang.String vendorId;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "isminqty")
        private boolean isMinQty;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "minqty")
        private java.math.BigDecimal minQty;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "priority")
        private int priority;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "offertype")
        private java.lang.String offerType;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "code")
        private java.lang.String code;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "type")
        private java.lang.String type;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "name")
        private java.lang.String promoName;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "note")
        private java.lang.String note;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "item_discexp")
        private java.lang.String itemDiscExp;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "promo_cat")
        private java.lang.String promoCat;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "deal_item_id")
        private java.lang.Integer dealItemId;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "item_price")
        private java.math.BigDecimal itemPrice;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "maxqty")
        private java.math.BigDecimal maxQty;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ismaxqty")
        private boolean isMaxQty;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "isminqtymultiply")
        private boolean isMinQtyMultiply;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ispriceoverride")
        private boolean isPriceOverride;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ismulti")
        private boolean isMulti;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "deal_qty")
        private java.math.BigDecimal dealQty;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "isdealsameitem")
        private boolean isDealSameItem;
        public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse.DataPromo> CREATOR = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse.DataPromo copy(int id, boolean isActive, boolean isBranch, @org.jetbrains.annotations.Nullable()
        java.lang.String branchId, boolean isPeriode, @org.jetbrains.annotations.Nullable()
        java.lang.String startDate, @org.jetbrains.annotations.Nullable()
        java.lang.String endDate, boolean isTime, @org.jetbrains.annotations.Nullable()
        java.lang.String starttime, @org.jetbrains.annotations.Nullable()
        java.lang.String endTime, boolean isDow, @org.jetbrains.annotations.Nullable()
        java.lang.String dowExp, boolean isBpgrp1, @org.jetbrains.annotations.Nullable()
        java.lang.String bpgrp1Id, boolean isMinAmt, @org.jetbrains.annotations.NotNull()
        java.math.BigDecimal minAmt, boolean isTargetItem, @org.jetbrains.annotations.Nullable()
        java.lang.Integer itemId, boolean isTargetItgrp1, @org.jetbrains.annotations.Nullable()
        java.lang.String itemgrp1Id, boolean isTargetBrand, @org.jetbrains.annotations.Nullable()
        java.lang.String brandId, boolean isTargetVendor, @org.jetbrains.annotations.Nullable()
        java.lang.String vendorId, boolean isMinQty, @org.jetbrains.annotations.Nullable()
        java.math.BigDecimal minQty, int priority, @org.jetbrains.annotations.NotNull()
        java.lang.String offerType, @org.jetbrains.annotations.NotNull()
        java.lang.String code, @org.jetbrains.annotations.NotNull()
        java.lang.String type, @org.jetbrains.annotations.NotNull()
        java.lang.String promoName, @org.jetbrains.annotations.NotNull()
        java.lang.String note, @org.jetbrains.annotations.Nullable()
        java.lang.String itemDiscExp, @org.jetbrains.annotations.NotNull()
        java.lang.String promoCat, @org.jetbrains.annotations.Nullable()
        java.lang.Integer dealItemId, @org.jetbrains.annotations.Nullable()
        java.math.BigDecimal itemPrice, @org.jetbrains.annotations.Nullable()
        java.math.BigDecimal maxQty, boolean isMaxQty, boolean isMinQtyMultiply, boolean isPriceOverride, boolean isMulti, @org.jetbrains.annotations.Nullable()
        java.math.BigDecimal dealQty, boolean isDealSameItem) {
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
        
        public DataPromo(int id, boolean isActive, boolean isBranch, @org.jetbrains.annotations.Nullable()
        java.lang.String branchId, boolean isPeriode, @org.jetbrains.annotations.Nullable()
        java.lang.String startDate, @org.jetbrains.annotations.Nullable()
        java.lang.String endDate, boolean isTime, @org.jetbrains.annotations.Nullable()
        java.lang.String starttime, @org.jetbrains.annotations.Nullable()
        java.lang.String endTime, boolean isDow, @org.jetbrains.annotations.Nullable()
        java.lang.String dowExp, boolean isBpgrp1, @org.jetbrains.annotations.Nullable()
        java.lang.String bpgrp1Id, boolean isMinAmt, @org.jetbrains.annotations.NotNull()
        java.math.BigDecimal minAmt, boolean isTargetItem, @org.jetbrains.annotations.Nullable()
        java.lang.Integer itemId, boolean isTargetItgrp1, @org.jetbrains.annotations.Nullable()
        java.lang.String itemgrp1Id, boolean isTargetBrand, @org.jetbrains.annotations.Nullable()
        java.lang.String brandId, boolean isTargetVendor, @org.jetbrains.annotations.Nullable()
        java.lang.String vendorId, boolean isMinQty, @org.jetbrains.annotations.Nullable()
        java.math.BigDecimal minQty, int priority, @org.jetbrains.annotations.NotNull()
        java.lang.String offerType, @org.jetbrains.annotations.NotNull()
        java.lang.String code, @org.jetbrains.annotations.NotNull()
        java.lang.String type, @org.jetbrains.annotations.NotNull()
        java.lang.String promoName, @org.jetbrains.annotations.NotNull()
        java.lang.String note, @org.jetbrains.annotations.Nullable()
        java.lang.String itemDiscExp, @org.jetbrains.annotations.NotNull()
        java.lang.String promoCat, @org.jetbrains.annotations.Nullable()
        java.lang.Integer dealItemId, @org.jetbrains.annotations.Nullable()
        java.math.BigDecimal itemPrice, @org.jetbrains.annotations.Nullable()
        java.math.BigDecimal maxQty, boolean isMaxQty, boolean isMinQtyMultiply, boolean isPriceOverride, boolean isMulti, @org.jetbrains.annotations.Nullable()
        java.math.BigDecimal dealQty, boolean isDealSameItem) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int getId() {
            return 0;
        }
        
        public final void setId(int p0) {
        }
        
        public final boolean component2() {
            return false;
        }
        
        public final boolean isActive() {
            return false;
        }
        
        public final void setActive(boolean p0) {
        }
        
        public final boolean component3() {
            return false;
        }
        
        public final boolean isBranch() {
            return false;
        }
        
        public final void setBranch(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getBranchId() {
            return null;
        }
        
        public final void setBranchId(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        public final boolean component5() {
            return false;
        }
        
        public final boolean isPeriode() {
            return false;
        }
        
        public final void setPeriode(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getStartDate() {
            return null;
        }
        
        public final void setStartDate(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getEndDate() {
            return null;
        }
        
        public final void setEndDate(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        public final boolean component8() {
            return false;
        }
        
        public final boolean isTime() {
            return false;
        }
        
        public final void setTime(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component9() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getStarttime() {
            return null;
        }
        
        public final void setStarttime(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component10() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getEndTime() {
            return null;
        }
        
        public final void setEndTime(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        public final boolean component11() {
            return false;
        }
        
        public final boolean isDow() {
            return false;
        }
        
        public final void setDow(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component12() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDowExp() {
            return null;
        }
        
        public final void setDowExp(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        public final boolean component13() {
            return false;
        }
        
        public final boolean isBpgrp1() {
            return false;
        }
        
        public final void setBpgrp1(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component14() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getBpgrp1Id() {
            return null;
        }
        
        public final void setBpgrp1Id(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        public final boolean component15() {
            return false;
        }
        
        public final boolean isMinAmt() {
            return false;
        }
        
        public final void setMinAmt(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.math.BigDecimal component16() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.math.BigDecimal getMinAmt() {
            return null;
        }
        
        public final void setMinAmt(@org.jetbrains.annotations.NotNull()
        java.math.BigDecimal p0) {
        }
        
        public final boolean component17() {
            return false;
        }
        
        public final boolean isTargetItem() {
            return false;
        }
        
        public final void setTargetItem(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component18() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getItemId() {
            return null;
        }
        
        public final void setItemId(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        public final boolean component19() {
            return false;
        }
        
        public final boolean isTargetItgrp1() {
            return false;
        }
        
        public final void setTargetItgrp1(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component20() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getItemgrp1Id() {
            return null;
        }
        
        public final void setItemgrp1Id(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        public final boolean component21() {
            return false;
        }
        
        public final boolean isTargetBrand() {
            return false;
        }
        
        public final void setTargetBrand(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component22() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getBrandId() {
            return null;
        }
        
        public final void setBrandId(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        public final boolean component23() {
            return false;
        }
        
        public final boolean isTargetVendor() {
            return false;
        }
        
        public final void setTargetVendor(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component24() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getVendorId() {
            return null;
        }
        
        public final void setVendorId(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        public final boolean component25() {
            return false;
        }
        
        public final boolean isMinQty() {
            return false;
        }
        
        public final void setMinQty(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.math.BigDecimal component26() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.math.BigDecimal getMinQty() {
            return null;
        }
        
        public final void setMinQty(@org.jetbrains.annotations.Nullable()
        java.math.BigDecimal p0) {
        }
        
        public final int component27() {
            return 0;
        }
        
        public final int getPriority() {
            return 0;
        }
        
        public final void setPriority(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component28() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getOfferType() {
            return null;
        }
        
        public final void setOfferType(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component29() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCode() {
            return null;
        }
        
        public final void setCode(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component30() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getType() {
            return null;
        }
        
        public final void setType(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component31() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPromoName() {
            return null;
        }
        
        public final void setPromoName(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component32() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getNote() {
            return null;
        }
        
        public final void setNote(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component33() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getItemDiscExp() {
            return null;
        }
        
        public final void setItemDiscExp(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component34() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPromoCat() {
            return null;
        }
        
        public final void setPromoCat(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component35() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getDealItemId() {
            return null;
        }
        
        public final void setDealItemId(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.math.BigDecimal component36() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.math.BigDecimal getItemPrice() {
            return null;
        }
        
        public final void setItemPrice(@org.jetbrains.annotations.Nullable()
        java.math.BigDecimal p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.math.BigDecimal component37() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.math.BigDecimal getMaxQty() {
            return null;
        }
        
        public final void setMaxQty(@org.jetbrains.annotations.Nullable()
        java.math.BigDecimal p0) {
        }
        
        public final boolean component38() {
            return false;
        }
        
        public final boolean isMaxQty() {
            return false;
        }
        
        public final void setMaxQty(boolean p0) {
        }
        
        public final boolean component39() {
            return false;
        }
        
        public final boolean isMinQtyMultiply() {
            return false;
        }
        
        public final void setMinQtyMultiply(boolean p0) {
        }
        
        public final boolean component40() {
            return false;
        }
        
        public final boolean isPriceOverride() {
            return false;
        }
        
        public final void setPriceOverride(boolean p0) {
        }
        
        public final boolean component41() {
            return false;
        }
        
        public final boolean isMulti() {
            return false;
        }
        
        public final void setMulti(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.math.BigDecimal component42() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.math.BigDecimal getDealQty() {
            return null;
        }
        
        public final void setDealQty(@org.jetbrains.annotations.Nullable()
        java.math.BigDecimal p0) {
        }
        
        public final boolean component43() {
            return false;
        }
        
        public final boolean isDealSameItem() {
            return false;
        }
        
        public final void setDealSameItem(boolean p0) {
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
        public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse.DataPromo> {
            
            public Creator() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse.DataPromo createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel in) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse.DataPromo[] newArray(int size) {
                return null;
            }
        }
    }
}