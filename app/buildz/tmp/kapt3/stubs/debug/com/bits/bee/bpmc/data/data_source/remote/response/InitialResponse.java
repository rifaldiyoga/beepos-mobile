package com.bits.bee.bpmc.data.data_source.remote.response;

import java.lang.System;

/**
 * Created by aldi on 29/03/22.
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u001f B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013H\u00d6\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006!"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/InitialResponse;", "Landroid/os/Parcelable;", "status", "", "data", "Lcom/bits/bee/bpmc/data/data_source/remote/response/InitialResponse$Data;", "(ZLcom/bits/bee/bpmc/data/data_source/remote/response/InitialResponse$Data;)V", "getData", "()Lcom/bits/bee/bpmc/data/data_source/remote/response/InitialResponse$Data;", "setData", "(Lcom/bits/bee/bpmc/data/data_source/remote/response/InitialResponse$Data;)V", "getStatus", "()Z", "setStatus", "(Z)V", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Data", "ValueLabelStringModel", "app_debug"})
public final class InitialResponse implements android.os.Parcelable {
    @com.google.gson.annotations.SerializedName(value = "status")
    private boolean status;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "data")
    private com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.Data data;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse> CREATOR = null;
    
    /**
     * Created by aldi on 29/03/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse copy(boolean status, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.Data data) {
        return null;
    }
    
    /**
     * Created by aldi on 29/03/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 29/03/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 29/03/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public InitialResponse(boolean status, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.Data data) {
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
    public final com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.Data component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.Data getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.Data p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse[] newArray(int size) {
            return null;
        }
    }
    
    @kotlinx.parcelize.Parcelize()
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003\u00a2\u0006\u0002\u0010\u0011J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H\u00c6\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H\u00c6\u0003J\u000f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003H\u00c6\u0003Jy\u0010)\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003H\u00c6\u0001J\t\u0010*\u001a\u00020+H\u00d6\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u00d6\u0003J\t\u00100\u001a\u00020+H\u00d6\u0001J\t\u00101\u001a\u000202H\u00d6\u0001J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020+H\u00d6\u0001R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015\u00a8\u00068"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/InitialResponse$Data;", "Landroid/os/Parcelable;", "cmp", "", "Lcom/bits/bee/bpmc/data/data_source/remote/model/CmpModel;", "reg", "Lcom/bits/bee/bpmc/data/data_source/remote/model/RegModel;", "usr", "Lcom/bits/bee/bpmc/data/data_source/remote/model/UsrModel;", "usrGrp", "Lcom/bits/bee/bpmc/data/data_source/remote/model/UsrGrpModel;", "grpPrv", "Lcom/bits/bee/bpmc/data/data_source/remote/model/GrpPrvModel;", "crc", "Lcom/bits/bee/bpmc/data/data_source/remote/model/CrcModel;", "wh", "Lcom/bits/bee/bpmc/data/data_source/remote/model/WhModel;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCmp", "()Ljava/util/List;", "setCmp", "(Ljava/util/List;)V", "getCrc", "setCrc", "getGrpPrv", "setGrpPrv", "getReg", "setReg", "getUsr", "setUsr", "getUsrGrp", "setUsrGrp", "getWh", "setWh", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
    public static final class Data implements android.os.Parcelable {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "cmp")
        private java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.CmpModel> cmp;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "reg")
        private java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.RegModel> reg;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "usr")
        private java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.UsrModel> usr;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "usrgrp")
        private java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.UsrGrpModel> usrGrp;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "grpprv")
        private java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.GrpPrvModel> grpPrv;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "crc")
        private java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.CrcModel> crc;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "wh")
        private java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.WhModel> wh;
        public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.Data> CREATOR = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.Data copy(@org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.CmpModel> cmp, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.RegModel> reg, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.UsrModel> usr, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.UsrGrpModel> usrGrp, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.GrpPrvModel> grpPrv, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.CrcModel> crc, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.WhModel> wh) {
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
        
        public Data() {
            super();
        }
        
        public Data(@org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.CmpModel> cmp, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.RegModel> reg, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.UsrModel> usr, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.UsrGrpModel> usrGrp, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.GrpPrvModel> grpPrv, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.CrcModel> crc, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.WhModel> wh) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.CmpModel> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.CmpModel> getCmp() {
            return null;
        }
        
        public final void setCmp(@org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.CmpModel> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.RegModel> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.RegModel> getReg() {
            return null;
        }
        
        public final void setReg(@org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.RegModel> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.UsrModel> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.UsrModel> getUsr() {
            return null;
        }
        
        public final void setUsr(@org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.UsrModel> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.UsrGrpModel> component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.UsrGrpModel> getUsrGrp() {
            return null;
        }
        
        public final void setUsrGrp(@org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.UsrGrpModel> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.GrpPrvModel> component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.GrpPrvModel> getGrpPrv() {
            return null;
        }
        
        public final void setGrpPrv(@org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.GrpPrvModel> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.CrcModel> component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.CrcModel> getCrc() {
            return null;
        }
        
        public final void setCrc(@org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.CrcModel> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.WhModel> component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.WhModel> getWh() {
            return null;
        }
        
        public final void setWh(@org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.model.WhModel> p0) {
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
        public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.Data> {
            
            public Creator() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.Data createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel in) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.Data[] newArray(int size) {
                return null;
            }
        }
    }
    
    @kotlinx.parcelize.Parcelize()
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u00d6\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u001c"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/InitialResponse$ValueLabelStringModel;", "Landroid/os/Parcelable;", "value", "", "label", "(Ljava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "getValue", "setValue", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
    public static final class ValueLabelStringModel implements android.os.Parcelable {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "value")
        private java.lang.String value;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "label")
        private java.lang.String label;
        public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.ValueLabelStringModel> CREATOR = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.ValueLabelStringModel copy(@org.jetbrains.annotations.NotNull()
        java.lang.String value, @org.jetbrains.annotations.NotNull()
        java.lang.String label) {
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
        
        public ValueLabelStringModel() {
            super();
        }
        
        public ValueLabelStringModel(@org.jetbrains.annotations.NotNull()
        java.lang.String value, @org.jetbrains.annotations.NotNull()
        java.lang.String label) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getValue() {
            return null;
        }
        
        public final void setValue(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLabel() {
            return null;
        }
        
        public final void setLabel(@org.jetbrains.annotations.NotNull()
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
        public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.ValueLabelStringModel> {
            
            public Creator() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.ValueLabelStringModel createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel in) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse.ValueLabelStringModel[] newArray(int size) {
                return null;
            }
        }
    }
}