package com.bits.bee.bpmc.domain.model;

import java.lang.System;

@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\nH\u00c6\u0003J9\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\t\u0010!\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$H\u00d6\u0003J\t\u0010%\u001a\u00020\bH\u00d6\u0001J\t\u0010&\u001a\u00020\'H\u00d6\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\bH\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006-"}, d2 = {"Lcom/bits/bee/bpmc/domain/model/Sesi;", "Landroid/os/Parcelable;", "date", "", "listPosses", "", "Lcom/bits/bee/bpmc/domain/model/Posses;", "jmltrans", "", "expand", "", "(JLjava/util/List;IZ)V", "getDate", "()J", "setDate", "(J)V", "getExpand", "()Z", "setExpand", "(Z)V", "getJmltrans", "()I", "setJmltrans", "(I)V", "getListPosses", "()Ljava/util/List;", "setListPosses", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Sesi implements android.os.Parcelable {
    private long date;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.bits.bee.bpmc.domain.model.Posses> listPosses;
    private int jmltrans;
    private boolean expand;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.Sesi> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.model.Sesi copy(long date, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Posses> listPosses, int jmltrans, boolean expand) {
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
    
    public Sesi(long date, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Posses> listPosses, int jmltrans, boolean expand) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getDate() {
        return 0L;
    }
    
    public final void setDate(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Posses> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Posses> getListPosses() {
        return null;
    }
    
    public final void setListPosses(@org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Posses> p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getJmltrans() {
        return 0;
    }
    
    public final void setJmltrans(int p0) {
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean getExpand() {
        return false;
    }
    
    public final void setExpand(boolean p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.Sesi> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.Sesi createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.Sesi[] newArray(int size) {
            return null;
        }
    }
}