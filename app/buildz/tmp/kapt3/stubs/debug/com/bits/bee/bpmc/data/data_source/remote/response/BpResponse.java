package com.bits.bee.bpmc.data.data_source.remote.response;

import java.lang.System;

/**
 * Created by aldi on 17/03/22.
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001:\u0004&\'()B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J-\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u001bH\u00d6\u0001J\t\u0010 \u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bH\u00d6\u0001R$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006*"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/BpResponse;", "Landroid/os/Parcelable;", "status", "", "msg", "", "data", "", "Lcom/bits/bee/bpmc/data/data_source/remote/response/BpResponse$BpModel;", "(ZLjava/lang/String;Ljava/util/List;)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "getStatus", "()Z", "setStatus", "(Z)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "BpAddrModel", "BpModel", "Data", "EmailModel", "app_debug"})
public final class BpResponse implements android.os.Parcelable {
    @com.google.gson.annotations.SerializedName(value = "status")
    private boolean status;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "message")
    private java.lang.String msg;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "data")
    private java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel> data;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse> CREATOR = null;
    
    /**
     * Created by aldi on 17/03/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse copy(boolean status, @org.jetbrains.annotations.NotNull()
    java.lang.String msg, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel> data) {
        return null;
    }
    
    /**
     * Created by aldi on 17/03/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 17/03/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 17/03/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public BpResponse() {
        super();
    }
    
    public BpResponse(boolean status, @org.jetbrains.annotations.NotNull()
    java.lang.String msg, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel> data) {
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
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMsg() {
        return null;
    }
    
    public final void setMsg(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel> getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel> p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse[] newArray(int size) {
            return null;
        }
    }
    
    @kotlinx.parcelize.Parcelize()
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\n\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u00d6\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0018"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/BpResponse$Data;", "Landroid/os/Parcelable;", "data", "Lcom/bits/bee/bpmc/data/data_source/remote/response/BpResponse$BpModel;", "(Lcom/bits/bee/bpmc/data/data_source/remote/response/BpResponse$BpModel;)V", "getData", "()Lcom/bits/bee/bpmc/data/data_source/remote/response/BpResponse$BpModel;", "setData", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
    public static final class Data implements android.os.Parcelable {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "data")
        private com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel data;
        public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.Data> CREATOR = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.Data copy(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel data) {
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
        
        public Data(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel data) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel getData() {
            return null;
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel p0) {
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
        public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.Data> {
            
            public Creator() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.Data createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel in) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.Data[] newArray(int size) {
                return null;
            }
        }
    }
    
    @kotlinx.parcelize.Parcelize()
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b@\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0013J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0005H\u00c6\u0003J\t\u0010;\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\t\u0010=\u001a\u00020\u0005H\u00c6\u0003J\t\u0010>\u001a\u00020\u0005H\u00c6\u0003J\t\u0010?\u001a\u00020\u0005H\u00c6\u0003J\t\u0010@\u001a\u00020\u0005H\u00c6\u0003J\t\u0010A\u001a\u00020\u0005H\u00c6\u0003J\t\u0010B\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010D\u001a\u00020\u000bH\u00c6\u0003J\t\u0010E\u001a\u00020\u000bH\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\u009e\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010HJ\t\u0010I\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010J\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010LH\u00d6\u0003J\t\u0010M\u001a\u00020\u0003H\u00d6\u0001J\t\u0010N\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0003H\u00d6\u0001R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\"\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001e\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0015\"\u0004\b(\u0010\u0017R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106\u00a8\u0006T"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/BpResponse$BpModel;", "Landroid/os/Parcelable;", "id", "", "code", "", "name", "phone", "bpId", "address", "saleistaxed", "", "saletaxinc", "pricelvl_id", "city_code", "email", "bpgrpid", "created_at", "createdBy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getBpId", "setBpId", "getBpgrpid", "()Ljava/lang/Integer;", "setBpgrpid", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCity_code", "setCity_code", "getCode", "setCode", "getCreatedBy", "setCreatedBy", "getCreated_at", "setCreated_at", "getEmail", "setEmail", "getId", "()I", "setId", "(I)V", "getName", "setName", "getPhone", "setPhone", "getPricelvl_id", "setPricelvl_id", "getSaleistaxed", "()Z", "setSaleistaxed", "(Z)V", "getSaletaxinc", "setSaletaxinc", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bits/bee/bpmc/data/data_source/remote/response/BpResponse$BpModel;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
    public static final class BpModel implements android.os.Parcelable {
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "id")
        private int id;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "code")
        private java.lang.String code;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "name")
        private java.lang.String name;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "mobile")
        private java.lang.String phone;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "bp_id")
        private java.lang.String bpId;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "address")
        private java.lang.String address;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "taxedonsale")
        private boolean saleistaxed;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "taxinconsale")
        private boolean saletaxinc;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "pricelvl_id")
        private int pricelvl_id;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "city_code")
        private java.lang.String city_code;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "email")
        private java.lang.String email;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "bpgrp1_id")
        private java.lang.Integer bpgrpid;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "created_at")
        private java.lang.String created_at;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "created_by")
        private java.lang.String createdBy;
        public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel> CREATOR = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel copy(int id, @org.jetbrains.annotations.NotNull()
        java.lang.String code, @org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        java.lang.String phone, @org.jetbrains.annotations.NotNull()
        java.lang.String bpId, @org.jetbrains.annotations.Nullable()
        java.lang.String address, boolean saleistaxed, boolean saletaxinc, int pricelvl_id, @org.jetbrains.annotations.NotNull()
        java.lang.String city_code, @org.jetbrains.annotations.NotNull()
        java.lang.String email, @org.jetbrains.annotations.Nullable()
        java.lang.Integer bpgrpid, @org.jetbrains.annotations.NotNull()
        java.lang.String created_at, @org.jetbrains.annotations.NotNull()
        java.lang.String createdBy) {
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
        
        public BpModel(int id, @org.jetbrains.annotations.NotNull()
        java.lang.String code, @org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        java.lang.String phone, @org.jetbrains.annotations.NotNull()
        java.lang.String bpId, @org.jetbrains.annotations.Nullable()
        java.lang.String address, boolean saleistaxed, boolean saletaxinc, int pricelvl_id, @org.jetbrains.annotations.NotNull()
        java.lang.String city_code, @org.jetbrains.annotations.NotNull()
        java.lang.String email, @org.jetbrains.annotations.Nullable()
        java.lang.Integer bpgrpid, @org.jetbrains.annotations.NotNull()
        java.lang.String created_at, @org.jetbrains.annotations.NotNull()
        java.lang.String createdBy) {
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
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
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
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getName() {
            return null;
        }
        
        public final void setName(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPhone() {
            return null;
        }
        
        public final void setPhone(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBpId() {
            return null;
        }
        
        public final void setBpId(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getAddress() {
            return null;
        }
        
        public final void setAddress(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        public final boolean component7() {
            return false;
        }
        
        public final boolean getSaleistaxed() {
            return false;
        }
        
        public final void setSaleistaxed(boolean p0) {
        }
        
        public final boolean component8() {
            return false;
        }
        
        public final boolean getSaletaxinc() {
            return false;
        }
        
        public final void setSaletaxinc(boolean p0) {
        }
        
        public final int component9() {
            return 0;
        }
        
        public final int getPricelvl_id() {
            return 0;
        }
        
        public final void setPricelvl_id(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component10() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCity_code() {
            return null;
        }
        
        public final void setCity_code(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component11() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEmail() {
            return null;
        }
        
        public final void setEmail(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component12() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getBpgrpid() {
            return null;
        }
        
        public final void setBpgrpid(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component13() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCreated_at() {
            return null;
        }
        
        public final void setCreated_at(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component14() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCreatedBy() {
            return null;
        }
        
        public final void setCreatedBy(@org.jetbrains.annotations.NotNull()
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
        public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel> {
            
            public Creator() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel in) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpModel[] newArray(int size) {
                return null;
            }
        }
    }
    
    @kotlinx.parcelize.Parcelize()
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00ab\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0002\u0010\u001aJ\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0010H\u00c6\u0003J\t\u0010H\u001a\u00020\u0010H\u00c6\u0003J\t\u0010I\u001a\u00020\u0010H\u00c6\u0003J\t\u0010J\u001a\u00020\u0014H\u00c6\u0003J\t\u0010K\u001a\u00020\u0014H\u00c6\u0003J\t\u0010L\u001a\u00020\u0014H\u00c6\u0003J\t\u0010M\u001a\u00020\u0018H\u00c6\u0003J\t\u0010N\u001a\u00020\u0018H\u00c6\u0003J\t\u0010O\u001a\u00020\u0003H\u00c6\u0003J\t\u0010P\u001a\u00020\u0006H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0006H\u00c6\u0003J\t\u0010R\u001a\u00020\u0006H\u00c6\u0003J\t\u0010S\u001a\u00020\u0006H\u00c6\u0003J\t\u0010T\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010U\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00c6\u0003J\t\u0010V\u001a\u00020\u0006H\u00c6\u0003J\u00b9\u0001\u0010W\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u00c6\u0001J\t\u0010X\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010Y\u001a\u00020\u00102\b\u0010Z\u001a\u0004\u0018\u00010[H\u00d6\u0003J\t\u0010\\\u001a\u00020\u0003H\u00d6\u0001J\t\u0010]\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\u0016\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u00103\"\u0004\b4\u00105R\u001e\u0010\u0012\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u00103\"\u0004\b6\u00105R\u001e\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u00103\"\u0004\b7\u00105R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u001eR\u001e\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u0010\u001eR\u001e\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001c\"\u0004\b=\u0010\u001eR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010(\"\u0004\b?\u0010*R\u001e\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010(\"\u0004\bA\u0010*R\u001e\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010$\"\u0004\bC\u0010&R\u001e\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001c\"\u0004\bE\u0010\u001e\u00a8\u0006c"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/BpResponse$BpAddrModel;", "Landroid/os/Parcelable;", "id", "", "bpId", "name", "", "greeting", "address", "phone", "zipCode", "email", "", "Lcom/bits/bee/bpmc/data/data_source/remote/response/BpResponse$EmailModel;", "note", "isBillAddr", "", "isShipAddr", "isMainAddr", "provinceCode", "Lcom/bits/bee/bpmc/data/data_source/remote/model/ValueLabelModel;", "regencyCode", "districtId", "createdAt", "Ljava/util/Date;", "updatedAt", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZZZLcom/bits/bee/bpmc/data/data_source/remote/model/ValueLabelModel;Lcom/bits/bee/bpmc/data/data_source/remote/model/ValueLabelModel;Lcom/bits/bee/bpmc/data/data_source/remote/model/ValueLabelModel;Ljava/util/Date;Ljava/util/Date;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getBpId", "()I", "setBpId", "(I)V", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "getDistrictId", "()Lcom/bits/bee/bpmc/data/data_source/remote/model/ValueLabelModel;", "setDistrictId", "(Lcom/bits/bee/bpmc/data/data_source/remote/model/ValueLabelModel;)V", "getEmail", "()Ljava/util/List;", "setEmail", "(Ljava/util/List;)V", "getGreeting", "setGreeting", "getId", "setId", "()Z", "setBillAddr", "(Z)V", "setMainAddr", "setShipAddr", "getName", "setName", "getNote", "setNote", "getPhone", "setPhone", "getProvinceCode", "setProvinceCode", "getRegencyCode", "setRegencyCode", "getUpdatedAt", "setUpdatedAt", "getZipCode", "setZipCode", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
    public static final class BpAddrModel implements android.os.Parcelable {
        @com.google.gson.annotations.SerializedName(value = "id")
        private int id;
        @com.google.gson.annotations.SerializedName(value = "bp_id")
        private int bpId;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "name")
        private java.lang.String name;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "greeting")
        private java.lang.String greeting;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "address")
        private java.lang.String address;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "phone")
        private java.lang.String phone;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "zipcode")
        private java.lang.String zipCode;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "email")
        private java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.EmailModel> email;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "note")
        private java.lang.String note;
        @com.google.gson.annotations.SerializedName(value = "isbilladdr")
        private boolean isBillAddr;
        @com.google.gson.annotations.SerializedName(value = "isshipaddr")
        private boolean isShipAddr;
        @com.google.gson.annotations.SerializedName(value = "ismainaddr")
        private boolean isMainAddr;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "province_code")
        private com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel provinceCode;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "regency_code")
        private com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel regencyCode;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "district_code")
        private com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel districtId;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "created_at")
        private java.util.Date createdAt;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "updated_at")
        private java.util.Date updatedAt;
        public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpAddrModel> CREATOR = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpAddrModel copy(int id, int bpId, @org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        java.lang.String greeting, @org.jetbrains.annotations.NotNull()
        java.lang.String address, @org.jetbrains.annotations.NotNull()
        java.lang.String phone, @org.jetbrains.annotations.NotNull()
        java.lang.String zipCode, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.EmailModel> email, @org.jetbrains.annotations.NotNull()
        java.lang.String note, boolean isBillAddr, boolean isShipAddr, boolean isMainAddr, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel provinceCode, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel regencyCode, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel districtId, @org.jetbrains.annotations.NotNull()
        java.util.Date createdAt, @org.jetbrains.annotations.NotNull()
        java.util.Date updatedAt) {
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
        
        public BpAddrModel(int id, int bpId, @org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        java.lang.String greeting, @org.jetbrains.annotations.NotNull()
        java.lang.String address, @org.jetbrains.annotations.NotNull()
        java.lang.String phone, @org.jetbrains.annotations.NotNull()
        java.lang.String zipCode, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.EmailModel> email, @org.jetbrains.annotations.NotNull()
        java.lang.String note, boolean isBillAddr, boolean isShipAddr, boolean isMainAddr, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel provinceCode, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel regencyCode, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel districtId, @org.jetbrains.annotations.NotNull()
        java.util.Date createdAt, @org.jetbrains.annotations.NotNull()
        java.util.Date updatedAt) {
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
        
        public final int component2() {
            return 0;
        }
        
        public final int getBpId() {
            return 0;
        }
        
        public final void setBpId(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getName() {
            return null;
        }
        
        public final void setName(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getGreeting() {
            return null;
        }
        
        public final void setGreeting(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAddress() {
            return null;
        }
        
        public final void setAddress(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPhone() {
            return null;
        }
        
        public final void setPhone(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getZipCode() {
            return null;
        }
        
        public final void setZipCode(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.EmailModel> component8() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.EmailModel> getEmail() {
            return null;
        }
        
        public final void setEmail(@org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.EmailModel> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getNote() {
            return null;
        }
        
        public final void setNote(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final boolean component10() {
            return false;
        }
        
        public final boolean isBillAddr() {
            return false;
        }
        
        public final void setBillAddr(boolean p0) {
        }
        
        public final boolean component11() {
            return false;
        }
        
        public final boolean isShipAddr() {
            return false;
        }
        
        public final void setShipAddr(boolean p0) {
        }
        
        public final boolean component12() {
            return false;
        }
        
        public final boolean isMainAddr() {
            return false;
        }
        
        public final void setMainAddr(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel component13() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel getProvinceCode() {
            return null;
        }
        
        public final void setProvinceCode(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel component14() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel getRegencyCode() {
            return null;
        }
        
        public final void setRegencyCode(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel component15() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel getDistrictId() {
            return null;
        }
        
        public final void setDistrictId(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date component16() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date getCreatedAt() {
            return null;
        }
        
        public final void setCreatedAt(@org.jetbrains.annotations.NotNull()
        java.util.Date p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date component17() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date getUpdatedAt() {
            return null;
        }
        
        public final void setUpdatedAt(@org.jetbrains.annotations.NotNull()
        java.util.Date p0) {
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
        public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpAddrModel> {
            
            public Creator() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpAddrModel createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel in) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.BpAddrModel[] newArray(int size) {
                return null;
            }
        }
    }
    
    @kotlinx.parcelize.Parcelize()
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001J\t\u0010 \u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f\u00a8\u0006&"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/BpResponse$EmailModel;", "Landroid/os/Parcelable;", "id", "", "refId", "refType", "", "email", "(IILjava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getRefId", "setRefId", "getRefType", "setRefType", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
    public static final class EmailModel implements android.os.Parcelable {
        @com.google.gson.annotations.SerializedName(value = "id")
        private int id;
        @com.google.gson.annotations.SerializedName(value = "refid")
        private int refId;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "reftype")
        private java.lang.String refType;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "email")
        private java.lang.String email;
        public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.EmailModel> CREATOR = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.EmailModel copy(int id, int refId, @org.jetbrains.annotations.NotNull()
        java.lang.String refType, @org.jetbrains.annotations.NotNull()
        java.lang.String email) {
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
        
        public EmailModel() {
            super();
        }
        
        public EmailModel(int id, int refId, @org.jetbrains.annotations.NotNull()
        java.lang.String refType, @org.jetbrains.annotations.NotNull()
        java.lang.String email) {
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
        
        public final int component2() {
            return 0;
        }
        
        public final int getRefId() {
            return 0;
        }
        
        public final void setRefId(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getRefType() {
            return null;
        }
        
        public final void setRefType(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEmail() {
            return null;
        }
        
        public final void setEmail(@org.jetbrains.annotations.NotNull()
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
        public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.EmailModel> {
            
            public Creator() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.EmailModel createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel in) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.BpResponse.EmailModel[] newArray(int size) {
                return null;
            }
        }
    }
}