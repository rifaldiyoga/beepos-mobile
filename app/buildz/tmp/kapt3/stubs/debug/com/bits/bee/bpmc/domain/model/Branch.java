package com.bits.bee.bpmc.domain.model;

import java.lang.System;

/**
 * Created by aldi on 17/03/22.
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0014J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\t\u0010+\u001a\u00020\u0010H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0010H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u000bH\u00c6\u0003J\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\t\u00106\u001a\u00020\u0005H\u00c6\u0003J\u009c\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u00108J\t\u00109\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010:\u001a\u00020\u000b2\b\u0010;\u001a\u0004\u0018\u00010<H\u00d6\u0003J\t\u0010=\u001a\u00020\u0003H\u00d6\u0001J\t\u0010>\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010 R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010 \u00a8\u0006D"}, d2 = {"Lcom/bits/bee/bpmc/domain/model/Branch;", "Landroid/os/Parcelable;", "id", "", "code", "", "name", "version", "cmpName", "cmpPhone", "active", "", "cmpAddress", "cmpFax", "custDeftId", "createdAt", "", "createdBy", "updatedAt", "updatedBy", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JIJI)V", "getActive", "()Z", "getCmpAddress", "()Ljava/lang/String;", "getCmpFax", "getCmpName", "getCmpPhone", "getCode", "getCreatedAt", "()J", "getCreatedBy", "()I", "getCustDeftId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getName", "getUpdatedAt", "getUpdatedBy", "getVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JIJI)Lcom/bits/bee/bpmc/domain/model/Branch;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Branch implements android.os.Parcelable {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String code = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    private final int version = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String cmpName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String cmpPhone = null;
    private final boolean active = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String cmpAddress = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String cmpFax = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer custDeftId = null;
    private final long createdAt = 0L;
    private final int createdBy = 0;
    private final long updatedAt = 0L;
    private final int updatedBy = 0;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.Branch> CREATOR = null;
    
    /**
     * Created by aldi on 17/03/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.model.Branch copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String cmpName, @org.jetbrains.annotations.NotNull()
    java.lang.String cmpPhone, boolean active, @org.jetbrains.annotations.NotNull()
    java.lang.String cmpAddress, @org.jetbrains.annotations.NotNull()
    java.lang.String cmpFax, @org.jetbrains.annotations.Nullable()
    java.lang.Integer custDeftId, long createdAt, int createdBy, long updatedAt, int updatedBy) {
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
    
    public Branch(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String cmpName, @org.jetbrains.annotations.NotNull()
    java.lang.String cmpPhone, boolean active, @org.jetbrains.annotations.NotNull()
    java.lang.String cmpAddress, @org.jetbrains.annotations.NotNull()
    java.lang.String cmpFax, @org.jetbrains.annotations.Nullable()
    java.lang.Integer custDeftId, long createdAt, int createdBy, long updatedAt, int updatedBy) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getVersion() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCmpName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCmpPhone() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean getActive() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCmpAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCmpFax() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCustDeftId() {
        return null;
    }
    
    public final long component11() {
        return 0L;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final int component12() {
        return 0;
    }
    
    public final int getCreatedBy() {
        return 0;
    }
    
    public final long component13() {
        return 0L;
    }
    
    public final long getUpdatedAt() {
        return 0L;
    }
    
    public final int component14() {
        return 0;
    }
    
    public final int getUpdatedBy() {
        return 0;
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
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.Branch> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.Branch createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.Branch[] newArray(int size) {
            return null;
        }
    }
}