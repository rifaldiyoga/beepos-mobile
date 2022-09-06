package com.bits.bee.bpmc.data.data_source.remote.response;

import java.lang.System;

/**
 * Created by bits on 09/09/16.
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u001f B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013H\u00d6\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006!"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/InitialItemResponse;", "Landroid/os/Parcelable;", "status", "", "item", "Lcom/bits/bee/bpmc/data/data_source/remote/response/InitialItemResponse$Item;", "(ZLcom/bits/bee/bpmc/data/data_source/remote/response/InitialItemResponse$Item;)V", "getItem", "()Lcom/bits/bee/bpmc/data/data_source/remote/response/InitialItemResponse$Item;", "setItem", "(Lcom/bits/bee/bpmc/data/data_source/remote/response/InitialItemResponse$Item;)V", "getStatus", "()Z", "setStatus", "(Z)V", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Datum", "Item", "app_debug"})
public final class InitialItemResponse implements android.os.Parcelable {
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "status")
    private boolean status;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "data")
    private com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Item item;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse> CREATOR = null;
    
    /**
     * Created by bits on 09/09/16.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse copy(boolean status, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Item item) {
        return null;
    }
    
    /**
     * Created by bits on 09/09/16.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by bits on 09/09/16.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by bits on 09/09/16.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public InitialItemResponse() {
        super();
    }
    
    public InitialItemResponse(boolean status, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Item item) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Item component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Item getItem() {
        return null;
    }
    
    public final void setItem(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Item p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse[] newArray(int size) {
            return null;
        }
    }
    
    @kotlinx.parcelize.Parcelize()
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\fH\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u00d6\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u00a8\u0006\u0019"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/InitialItemResponse$Item;", "Landroid/os/Parcelable;", "data", "", "Lcom/bits/bee/bpmc/data/data_source/remote/response/InitialItemResponse$Datum;", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "setData", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
    public static final class Item implements android.os.Parcelable {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "item")
        private java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Datum> data;
        public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Item> CREATOR = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Item copy(@org.jetbrains.annotations.Nullable()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Datum> data) {
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
        
        public Item() {
            super();
        }
        
        public Item(@org.jetbrains.annotations.Nullable()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Datum> data) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Datum> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Datum> getData() {
            return null;
        }
        
        public final void setData(@org.jetbrains.annotations.Nullable()
        java.util.List<com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Datum> p0) {
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
        public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Item> {
            
            public Creator() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Item createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel in) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Item[] newArray(int size) {
                return null;
            }
        }
    }
    
    @kotlinx.parcelize.Parcelize()
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0003\b\u00d0\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\r\u0012\b\b\u0002\u0010%\u001a\u00020\r\u0012\b\b\u0002\u0010&\u001a\u00020\r\u0012\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010(\u001a\u00020\u0005\u0012\b\b\u0002\u0010)\u001a\u00020\u0005\u0012\b\b\u0002\u0010*\u001a\u00020\u0005\u0012\b\b\u0002\u0010+\u001a\u00020\u0005\u0012\b\b\u0002\u0010,\u001a\u00020\u0005\u0012\b\b\u0002\u0010-\u001a\u00020\u0005\u0012\b\b\u0002\u0010.\u001a\u00020\u0005\u0012\b\b\u0002\u0010/\u001a\u00020\u0005\u0012\b\b\u0002\u00100\u001a\u00020\u0005\u0012\b\b\u0002\u00101\u001a\u00020\r\u0012\b\b\u0002\u00102\u001a\u00020\u0005\u0012\b\b\u0002\u00103\u001a\u00020\u0005\u0012\b\b\u0002\u00104\u001a\u00020\r\u0012\b\b\u0002\u00105\u001a\u00020\u0005\u0012\b\b\u0002\u00106\u001a\u00020\u0005\u0012\b\b\u0002\u00107\u001a\u00020\r\u00a2\u0006\u0002\u00108J\u0011\u0010\u00a6\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010JJ\n\u0010\u00a7\u0001\u001a\u00020\rH\u00c6\u0003J\n\u0010\u00a8\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010\u00a9\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010JJ\u0011\u0010\u00aa\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010JJ\n\u0010\u00ab\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00ac\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00ad\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00ae\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00af\u0001\u001a\u00020\rH\u00c6\u0003J\n\u0010\u00b0\u0001\u001a\u00020\rH\u00c6\u0003J\n\u0010\u00b1\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00b2\u0001\u001a\u00020\rH\u00c6\u0003J\n\u0010\u00b3\u0001\u001a\u00020\rH\u00c6\u0003J\n\u0010\u00b4\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00b5\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00b6\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00b7\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00b8\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00b9\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00ba\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00bb\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00bc\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00bd\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00be\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00bf\u0001\u001a\u00020\rH\u00c6\u0003J\n\u0010\u00c0\u0001\u001a\u00020\rH\u00c6\u0003J\n\u0010\u00c1\u0001\u001a\u00020\rH\u00c6\u0003J\u0011\u0010\u00c2\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010JJ\n\u0010\u00c3\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00c4\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00c5\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00c6\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00c7\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00c8\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00c9\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00ca\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00cb\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00cc\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00cd\u0001\u001a\u00020\rH\u00c6\u0003J\n\u0010\u00ce\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00cf\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00d0\u0001\u001a\u00020\rH\u00c6\u0003J\n\u0010\u00d1\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00d2\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00d3\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00d4\u0001\u001a\u00020\rH\u00c6\u0003J\n\u0010\u00d5\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010\u00d6\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010JJ\n\u0010\u00d7\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00d8\u0001\u001a\u00020\rH\u00c6\u0003J\u0098\u0004\u0010\u00d9\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\r2\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020\r2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\r2\b\b\u0002\u00102\u001a\u00020\u00052\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\r2\b\b\u0002\u00105\u001a\u00020\u00052\b\b\u0002\u00106\u001a\u00020\u00052\b\b\u0002\u00107\u001a\u00020\rH\u00c6\u0001\u00a2\u0006\u0003\u0010\u00da\u0001J\n\u0010\u00db\u0001\u001a\u00020\u0003H\u00d6\u0001J\u0016\u0010\u00dc\u0001\u001a\u00020\r2\n\u0010\u00dd\u0001\u001a\u0005\u0018\u00010\u00de\u0001H\u00d6\u0003J\n\u0010\u00df\u0001\u001a\u00020\u0003H\u00d6\u0001J\n\u0010\u00e0\u0001\u001a\u00020\u0005H\u00d6\u0001J\u001e\u0010\u00e1\u0001\u001a\u00030\u00e2\u00012\b\u0010\u00e3\u0001\u001a\u00030\u00e4\u00012\u0007\u0010\u00e5\u0001\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010:\"\u0004\b>\u0010<R\u001e\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R\u001e\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010:\"\u0004\bB\u0010<R\u001e\u0010$\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010:\"\u0004\bH\u0010<R\"\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010M\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001e\u00102\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010:\"\u0004\bO\u0010<R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010:\"\u0004\bQ\u0010<R\u001e\u00100\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010:\"\u0004\bS\u0010<R\u001e\u0010,\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010:\"\u0004\bU\u0010<R\u001e\u0010-\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010:\"\u0004\bW\u0010<R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010M\u001a\u0004\bX\u0010J\"\u0004\bY\u0010LR\u001e\u00101\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010D\"\u0004\b[\u0010FR\u001e\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010D\"\u0004\b]\u0010FR\u001e\u00104\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010D\"\u0004\b_\u0010FR\u001e\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010D\"\u0004\ba\u0010FR\u001e\u0010\u0019\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u0010D\"\u0004\bc\u0010FR\u001e\u0010\u0017\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010D\"\u0004\be\u0010FR\u001e\u00107\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010D\"\u0004\bg\u0010FR\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010:\"\u0004\bi\u0010<R\"\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010M\u001a\u0004\bj\u0010J\"\u0004\bk\u0010LR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010M\u001a\u0004\bl\u0010J\"\u0004\bm\u0010LR\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010:\"\u0004\bo\u0010<R\u001e\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010:\"\u0004\bq\u0010<R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010:\"\u0004\bs\u0010<R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u0010:\"\u0004\bu\u0010<R\u001e\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010:\"\u0004\bw\u0010<R\u001e\u00103\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bx\u0010:\"\u0004\by\u0010<R\u001e\u0010%\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u0010D\"\u0004\b{\u0010FR\u001e\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u0010:\"\u0004\b}\u0010<R\u001e\u0010)\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b~\u0010:\"\u0004\b\u007f\u0010<R \u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010:\"\u0005\b\u0081\u0001\u0010<R \u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010:\"\u0005\b\u0083\u0001\u0010<R \u0010 \u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010:\"\u0005\b\u0085\u0001\u0010<R \u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010:\"\u0005\b\u0087\u0001\u0010<R \u0010!\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010:\"\u0005\b\u0089\u0001\u0010<R \u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010:\"\u0005\b\u008b\u0001\u0010<R \u0010*\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010:\"\u0005\b\u008d\u0001\u0010<R \u0010&\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010D\"\u0005\b\u008f\u0001\u0010FR \u0010+\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010:\"\u0005\b\u0091\u0001\u0010<R \u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010D\"\u0005\b\u0093\u0001\u0010FR \u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010:\"\u0005\b\u0095\u0001\u0010<R \u0010.\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010:\"\u0005\b\u0097\u0001\u0010<R \u0010/\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010:\"\u0005\b\u0099\u0001\u0010<R \u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010D\"\u0005\b\u009b\u0001\u0010FR \u00105\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010:\"\u0005\b\u009d\u0001\u0010<R \u00106\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010:\"\u0005\b\u009f\u0001\u0010<R$\u0010\'\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0002\u0010M\u001a\u0005\b\u00a0\u0001\u0010J\"\u0005\b\u00a1\u0001\u0010LR \u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a2\u0001\u0010:\"\u0005\b\u00a3\u0001\u0010<R \u0010(\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a4\u0001\u0010:\"\u0005\b\u00a5\u0001\u0010<\u00a8\u0006\u00e6\u0001"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/response/InitialItemResponse$Datum;", "Landroid/os/Parcelable;", "id", "", "code", "", "name1", "name2", "barcode", "version", "brandId", "itemtypeCode", "usepid", "", "uniquepid", "itemgrp1Id", "itemgrp2Id", "itemgrp3Id", "accinv", "acccost", "accsale", "accsret", "ispurc", "isstock", "ismfg", "issale", "unitdesc", "purcqtymin", "leadtime", "qtymin", "qtymax", "qtyreorder", "qtypo", "qtyso", "qtywip", "note", "active", "pousepid", "sousepid", "vendorId", "vitemcode", "purcunit", "saleunit", "stockunit", "createdAt", "createdBy", "updatedAt", "updatedBy", "costtype", "isimport", "bucket", "objkey", "ispos", "vcode", "vcolor", "isvariant", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)V", "getAcccost", "()Ljava/lang/String;", "setAcccost", "(Ljava/lang/String;)V", "getAccinv", "setAccinv", "getAccsale", "setAccsale", "getAccsret", "setAccsret", "getActive", "()Z", "setActive", "(Z)V", "getBarcode", "setBarcode", "getBrandId", "()Ljava/lang/Integer;", "setBrandId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBucket", "setBucket", "getCode", "setCode", "getCosttype", "setCosttype", "getCreatedAt", "setCreatedAt", "getCreatedBy", "setCreatedBy", "getId", "setId", "getIsimport", "setIsimport", "getIsmfg", "setIsmfg", "getIspos", "setIspos", "getIspurc", "setIspurc", "getIssale", "setIssale", "getIsstock", "setIsstock", "getIsvariant", "setIsvariant", "getItemgrp1Id", "setItemgrp1Id", "getItemgrp2Id", "setItemgrp2Id", "getItemgrp3Id", "setItemgrp3Id", "getItemtypeCode", "setItemtypeCode", "getLeadtime", "setLeadtime", "getName1", "setName1", "getName2", "setName2", "getNote", "setNote", "getObjkey", "setObjkey", "getPousepid", "setPousepid", "getPurcqtymin", "setPurcqtymin", "getPurcunit", "setPurcunit", "getQtymax", "setQtymax", "getQtymin", "setQtymin", "getQtypo", "setQtypo", "getQtyreorder", "setQtyreorder", "getQtyso", "setQtyso", "getQtywip", "setQtywip", "getSaleunit", "setSaleunit", "getSousepid", "setSousepid", "getStockunit", "setStockunit", "getUniquepid", "setUniquepid", "getUnitdesc", "setUnitdesc", "getUpdatedAt", "setUpdatedAt", "getUpdatedBy", "setUpdatedBy", "getUsepid", "setUsepid", "getVcode", "setVcode", "getVcolor", "setVcolor", "getVendorId", "setVendorId", "getVersion", "setVersion", "getVitemcode", "setVitemcode", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)Lcom/bits/bee/bpmc/data/data_source/remote/response/InitialItemResponse$Datum;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
    public static final class Datum implements android.os.Parcelable {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "id")
        private java.lang.Integer id;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "code")
        private java.lang.String code;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "name1")
        private java.lang.String name1;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "name2")
        private java.lang.String name2;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "barcode")
        private java.lang.String barcode;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "version")
        private java.lang.String version;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "brand_id")
        private java.lang.Integer brandId;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "itemtype_code")
        private java.lang.String itemtypeCode;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "usepid")
        private boolean usepid;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "uniquepid")
        private boolean uniquepid;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "itemgrp1_id")
        private java.lang.String itemgrp1Id;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "itemgrp2_id")
        private java.lang.Integer itemgrp2Id;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "itemgrp3_id")
        private java.lang.Integer itemgrp3Id;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "accinv")
        private java.lang.String accinv;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "acccost")
        private java.lang.String acccost;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "accsale")
        private java.lang.String accsale;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "accsret")
        private java.lang.String accsret;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ispurc")
        private boolean ispurc;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "isstock")
        private boolean isstock;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ismfg")
        private boolean ismfg;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "issale")
        private boolean issale;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "unitdesc")
        private java.lang.String unitdesc;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "purcqtymin")
        private java.lang.String purcqtymin;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "leadtime")
        private java.lang.String leadtime;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "qtymin")
        private java.lang.String qtymin;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "qtymax")
        private java.lang.String qtymax;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "qtyreorder")
        private java.lang.String qtyreorder;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "qtypo")
        private java.lang.String qtypo;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "qtyso")
        private java.lang.String qtyso;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "qtywip")
        private java.lang.String qtywip;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "note")
        private java.lang.String note;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "active")
        private boolean active;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "pousepid")
        private boolean pousepid;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "sousepid")
        private boolean sousepid;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "vendor_id")
        private java.lang.Integer vendorId;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "vitemcode")
        private java.lang.String vitemcode;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "purcunit")
        private java.lang.String purcunit;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "saleunit")
        private java.lang.String saleunit;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "stockunit")
        private java.lang.String stockunit;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "created_at")
        private java.lang.String createdAt;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "created_by")
        private java.lang.String createdBy;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "updated_at")
        private java.lang.String updatedAt;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "updated_by")
        private java.lang.String updatedBy;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "costtype")
        private java.lang.String costtype;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "isimport")
        private boolean isimport;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "bucket")
        private java.lang.String bucket;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "objkey")
        private java.lang.String objkey;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ispos")
        private boolean ispos;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "vcode")
        private java.lang.String vcode;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "vcolor")
        private java.lang.String vcolor;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "isvariant")
        private boolean isvariant;
        public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Datum> CREATOR = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Datum copy(@org.jetbrains.annotations.Nullable()
        java.lang.Integer id, @org.jetbrains.annotations.NotNull()
        java.lang.String code, @org.jetbrains.annotations.NotNull()
        java.lang.String name1, @org.jetbrains.annotations.NotNull()
        java.lang.String name2, @org.jetbrains.annotations.NotNull()
        java.lang.String barcode, @org.jetbrains.annotations.NotNull()
        java.lang.String version, @org.jetbrains.annotations.Nullable()
        java.lang.Integer brandId, @org.jetbrains.annotations.NotNull()
        java.lang.String itemtypeCode, boolean usepid, boolean uniquepid, @org.jetbrains.annotations.NotNull()
        java.lang.String itemgrp1Id, @org.jetbrains.annotations.Nullable()
        java.lang.Integer itemgrp2Id, @org.jetbrains.annotations.Nullable()
        java.lang.Integer itemgrp3Id, @org.jetbrains.annotations.NotNull()
        java.lang.String accinv, @org.jetbrains.annotations.NotNull()
        java.lang.String acccost, @org.jetbrains.annotations.NotNull()
        java.lang.String accsale, @org.jetbrains.annotations.NotNull()
        java.lang.String accsret, boolean ispurc, boolean isstock, boolean ismfg, boolean issale, @org.jetbrains.annotations.NotNull()
        java.lang.String unitdesc, @org.jetbrains.annotations.NotNull()
        java.lang.String purcqtymin, @org.jetbrains.annotations.NotNull()
        java.lang.String leadtime, @org.jetbrains.annotations.NotNull()
        java.lang.String qtymin, @org.jetbrains.annotations.NotNull()
        java.lang.String qtymax, @org.jetbrains.annotations.NotNull()
        java.lang.String qtyreorder, @org.jetbrains.annotations.NotNull()
        java.lang.String qtypo, @org.jetbrains.annotations.NotNull()
        java.lang.String qtyso, @org.jetbrains.annotations.NotNull()
        java.lang.String qtywip, @org.jetbrains.annotations.NotNull()
        java.lang.String note, boolean active, boolean pousepid, boolean sousepid, @org.jetbrains.annotations.Nullable()
        java.lang.Integer vendorId, @org.jetbrains.annotations.NotNull()
        java.lang.String vitemcode, @org.jetbrains.annotations.NotNull()
        java.lang.String purcunit, @org.jetbrains.annotations.NotNull()
        java.lang.String saleunit, @org.jetbrains.annotations.NotNull()
        java.lang.String stockunit, @org.jetbrains.annotations.NotNull()
        java.lang.String createdAt, @org.jetbrains.annotations.NotNull()
        java.lang.String createdBy, @org.jetbrains.annotations.NotNull()
        java.lang.String updatedAt, @org.jetbrains.annotations.NotNull()
        java.lang.String updatedBy, @org.jetbrains.annotations.NotNull()
        java.lang.String costtype, boolean isimport, @org.jetbrains.annotations.NotNull()
        java.lang.String bucket, @org.jetbrains.annotations.NotNull()
        java.lang.String objkey, boolean ispos, @org.jetbrains.annotations.NotNull()
        java.lang.String vcode, @org.jetbrains.annotations.NotNull()
        java.lang.String vcolor, boolean isvariant) {
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
        
        public Datum() {
            super();
        }
        
        public Datum(@org.jetbrains.annotations.Nullable()
        java.lang.Integer id, @org.jetbrains.annotations.NotNull()
        java.lang.String code, @org.jetbrains.annotations.NotNull()
        java.lang.String name1, @org.jetbrains.annotations.NotNull()
        java.lang.String name2, @org.jetbrains.annotations.NotNull()
        java.lang.String barcode, @org.jetbrains.annotations.NotNull()
        java.lang.String version, @org.jetbrains.annotations.Nullable()
        java.lang.Integer brandId, @org.jetbrains.annotations.NotNull()
        java.lang.String itemtypeCode, boolean usepid, boolean uniquepid, @org.jetbrains.annotations.NotNull()
        java.lang.String itemgrp1Id, @org.jetbrains.annotations.Nullable()
        java.lang.Integer itemgrp2Id, @org.jetbrains.annotations.Nullable()
        java.lang.Integer itemgrp3Id, @org.jetbrains.annotations.NotNull()
        java.lang.String accinv, @org.jetbrains.annotations.NotNull()
        java.lang.String acccost, @org.jetbrains.annotations.NotNull()
        java.lang.String accsale, @org.jetbrains.annotations.NotNull()
        java.lang.String accsret, boolean ispurc, boolean isstock, boolean ismfg, boolean issale, @org.jetbrains.annotations.NotNull()
        java.lang.String unitdesc, @org.jetbrains.annotations.NotNull()
        java.lang.String purcqtymin, @org.jetbrains.annotations.NotNull()
        java.lang.String leadtime, @org.jetbrains.annotations.NotNull()
        java.lang.String qtymin, @org.jetbrains.annotations.NotNull()
        java.lang.String qtymax, @org.jetbrains.annotations.NotNull()
        java.lang.String qtyreorder, @org.jetbrains.annotations.NotNull()
        java.lang.String qtypo, @org.jetbrains.annotations.NotNull()
        java.lang.String qtyso, @org.jetbrains.annotations.NotNull()
        java.lang.String qtywip, @org.jetbrains.annotations.NotNull()
        java.lang.String note, boolean active, boolean pousepid, boolean sousepid, @org.jetbrains.annotations.Nullable()
        java.lang.Integer vendorId, @org.jetbrains.annotations.NotNull()
        java.lang.String vitemcode, @org.jetbrains.annotations.NotNull()
        java.lang.String purcunit, @org.jetbrains.annotations.NotNull()
        java.lang.String saleunit, @org.jetbrains.annotations.NotNull()
        java.lang.String stockunit, @org.jetbrains.annotations.NotNull()
        java.lang.String createdAt, @org.jetbrains.annotations.NotNull()
        java.lang.String createdBy, @org.jetbrains.annotations.NotNull()
        java.lang.String updatedAt, @org.jetbrains.annotations.NotNull()
        java.lang.String updatedBy, @org.jetbrains.annotations.NotNull()
        java.lang.String costtype, boolean isimport, @org.jetbrains.annotations.NotNull()
        java.lang.String bucket, @org.jetbrains.annotations.NotNull()
        java.lang.String objkey, boolean ispos, @org.jetbrains.annotations.NotNull()
        java.lang.String vcode, @org.jetbrains.annotations.NotNull()
        java.lang.String vcolor, boolean isvariant) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getId() {
            return null;
        }
        
        public final void setId(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
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
        public final java.lang.String getName1() {
            return null;
        }
        
        public final void setName1(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getName2() {
            return null;
        }
        
        public final void setName2(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBarcode() {
            return null;
        }
        
        public final void setBarcode(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getVersion() {
            return null;
        }
        
        public final void setVersion(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component7() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getBrandId() {
            return null;
        }
        
        public final void setBrandId(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component8() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getItemtypeCode() {
            return null;
        }
        
        public final void setItemtypeCode(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final boolean component9() {
            return false;
        }
        
        public final boolean getUsepid() {
            return false;
        }
        
        public final void setUsepid(boolean p0) {
        }
        
        public final boolean component10() {
            return false;
        }
        
        public final boolean getUniquepid() {
            return false;
        }
        
        public final void setUniquepid(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component11() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getItemgrp1Id() {
            return null;
        }
        
        public final void setItemgrp1Id(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component12() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getItemgrp2Id() {
            return null;
        }
        
        public final void setItemgrp2Id(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component13() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getItemgrp3Id() {
            return null;
        }
        
        public final void setItemgrp3Id(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component14() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAccinv() {
            return null;
        }
        
        public final void setAccinv(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component15() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAcccost() {
            return null;
        }
        
        public final void setAcccost(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component16() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAccsale() {
            return null;
        }
        
        public final void setAccsale(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component17() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAccsret() {
            return null;
        }
        
        public final void setAccsret(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final boolean component18() {
            return false;
        }
        
        public final boolean getIspurc() {
            return false;
        }
        
        public final void setIspurc(boolean p0) {
        }
        
        public final boolean component19() {
            return false;
        }
        
        public final boolean getIsstock() {
            return false;
        }
        
        public final void setIsstock(boolean p0) {
        }
        
        public final boolean component20() {
            return false;
        }
        
        public final boolean getIsmfg() {
            return false;
        }
        
        public final void setIsmfg(boolean p0) {
        }
        
        public final boolean component21() {
            return false;
        }
        
        public final boolean getIssale() {
            return false;
        }
        
        public final void setIssale(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component22() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUnitdesc() {
            return null;
        }
        
        public final void setUnitdesc(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component23() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPurcqtymin() {
            return null;
        }
        
        public final void setPurcqtymin(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component24() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLeadtime() {
            return null;
        }
        
        public final void setLeadtime(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component25() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getQtymin() {
            return null;
        }
        
        public final void setQtymin(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component26() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getQtymax() {
            return null;
        }
        
        public final void setQtymax(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component27() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getQtyreorder() {
            return null;
        }
        
        public final void setQtyreorder(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component28() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getQtypo() {
            return null;
        }
        
        public final void setQtypo(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component29() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getQtyso() {
            return null;
        }
        
        public final void setQtyso(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component30() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getQtywip() {
            return null;
        }
        
        public final void setQtywip(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component31() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getNote() {
            return null;
        }
        
        public final void setNote(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final boolean component32() {
            return false;
        }
        
        public final boolean getActive() {
            return false;
        }
        
        public final void setActive(boolean p0) {
        }
        
        public final boolean component33() {
            return false;
        }
        
        public final boolean getPousepid() {
            return false;
        }
        
        public final void setPousepid(boolean p0) {
        }
        
        public final boolean component34() {
            return false;
        }
        
        public final boolean getSousepid() {
            return false;
        }
        
        public final void setSousepid(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component35() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getVendorId() {
            return null;
        }
        
        public final void setVendorId(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component36() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getVitemcode() {
            return null;
        }
        
        public final void setVitemcode(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component37() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPurcunit() {
            return null;
        }
        
        public final void setPurcunit(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component38() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSaleunit() {
            return null;
        }
        
        public final void setSaleunit(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component39() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getStockunit() {
            return null;
        }
        
        public final void setStockunit(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component40() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCreatedAt() {
            return null;
        }
        
        public final void setCreatedAt(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component41() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCreatedBy() {
            return null;
        }
        
        public final void setCreatedBy(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component42() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUpdatedAt() {
            return null;
        }
        
        public final void setUpdatedAt(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component43() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUpdatedBy() {
            return null;
        }
        
        public final void setUpdatedBy(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component44() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCosttype() {
            return null;
        }
        
        public final void setCosttype(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final boolean component45() {
            return false;
        }
        
        public final boolean getIsimport() {
            return false;
        }
        
        public final void setIsimport(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component46() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBucket() {
            return null;
        }
        
        public final void setBucket(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component47() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getObjkey() {
            return null;
        }
        
        public final void setObjkey(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final boolean component48() {
            return false;
        }
        
        public final boolean getIspos() {
            return false;
        }
        
        public final void setIspos(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component49() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getVcode() {
            return null;
        }
        
        public final void setVcode(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component50() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getVcolor() {
            return null;
        }
        
        public final void setVcolor(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final boolean component51() {
            return false;
        }
        
        public final boolean getIsvariant() {
            return false;
        }
        
        public final void setIsvariant(boolean p0) {
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
        public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Datum> {
            
            public Creator() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Datum createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel in) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public final com.bits.bee.bpmc.data.data_source.remote.response.InitialItemResponse.Datum[] newArray(int size) {
                return null;
            }
        }
    }
}