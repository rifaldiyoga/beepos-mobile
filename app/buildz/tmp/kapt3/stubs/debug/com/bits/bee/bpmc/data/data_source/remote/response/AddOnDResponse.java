package com.bits.bee.bpmc.data.data_source.remote.response;

import java.lang.System;

@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001 B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014H\u00d6\u0001R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006!"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/AddOnDResponse;", "Landroid/os/Parcelable;", "status", "", "data", "", "Lcom/bits/bee/bpmc/data/data_source/remote/response/AddOnDResponse$AddOnDModel;", "(ZLjava/util/List;)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getStatus", "()Z", "setStatus", "(Z)V", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "AddOnDModel", "app_debug"})
public final class AddOnDResponse implements android.os.Parcelable {
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "status")
    private boolean status;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "data")
    private java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse.AddOnDModel> data;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse copy(boolean status, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse.AddOnDModel> data) {
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
    
    public AddOnDResponse(boolean status, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse.AddOnDModel> data) {
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
    public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse.AddOnDModel> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse.AddOnDModel> getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse.AddOnDModel> p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse[] newArray(int size) {
            return null;
        }
    }
    
    @kotlinx.parcelize.Parcelize()
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f\u00a8\u0006%"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/AddOnDResponse$AddOnDModel;", "Landroid/os/Parcelable;", "addOnId", "", "idx", "selectaddonId", "isSkip", "", "(IIIZ)V", "getAddOnId", "()I", "setAddOnId", "(I)V", "getIdx", "setIdx", "()Z", "setSkip", "(Z)V", "getSelectaddonId", "setSelectaddonId", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
    public static final class AddOnDModel implements android.os.Parcelable {
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "addon_id")
        private int addOnId;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "idx")
        private int idx;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "selectaddon_id")
        private int selectaddonId;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "isskip")
        private boolean isSkip;
        public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse.AddOnDModel> CREATOR = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse.AddOnDModel copy(int addOnId, int idx, int selectaddonId, boolean isSkip) {
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
        
        public AddOnDModel() {
            super();
        }
        
        public AddOnDModel(int addOnId, int idx, int selectaddonId, boolean isSkip) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int getAddOnId() {
            return 0;
        }
        
        public final void setAddOnId(int p0) {
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int getIdx() {
            return 0;
        }
        
        public final void setIdx(int p0) {
        }
        
        public final int component3() {
            return 0;
        }
        
        public final int getSelectaddonId() {
            return 0;
        }
        
        public final void setSelectaddonId(int p0) {
        }
        
        public final boolean component4() {
            return false;
        }
        
        public final boolean isSkip() {
            return false;
        }
        
        public final void setSkip(boolean p0) {
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
        public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse.AddOnDModel> {
            
            public Creator() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse.AddOnDModel createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel in) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse.AddOnDModel[] newArray(int size) {
                return null;
            }
        }
    }
}