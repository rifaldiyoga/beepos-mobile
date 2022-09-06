package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "grpprv")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b>\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0001GBo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0007H\u00c6\u0003J\t\u00107\u001a\u00020\u0007H\u00c6\u0003J\t\u00108\u001a\u00020\u0007H\u00c6\u0003J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0005H\u00c6\u0003J\t\u0010;\u001a\u00020\u0007H\u00c6\u0003J\t\u0010<\u001a\u00020\u0007H\u00c6\u0003J\t\u0010=\u001a\u00020\nH\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\t\u0010@\u001a\u00020\u0007H\u00c6\u0003J\t\u0010A\u001a\u00020\u0007H\u00c6\u0003J\u008d\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010C\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010E\u001a\u00020\u0003H\u00d6\u0001J\t\u0010F\u001a\u00020\u0007H\u00d6\u0001R\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR\u001e\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0015\"\u0004\b(\u0010\u0017R\u001e\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R\u001e\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R\u001e\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u0006H"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/GrpPrvEntity;", "", "id", "", "updatedAt", "Ljava/util/Date;", "objCode", "", "acsType", "isEnable", "", "acsVal", "grpId", "codeObj", "upCode", "moduleCode", "nameObj", "mnemonic", "level", "(ILjava/util/Date;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAcsType", "()Ljava/lang/String;", "setAcsType", "(Ljava/lang/String;)V", "getAcsVal", "setAcsVal", "getCodeObj", "setCodeObj", "getGrpId", "()I", "setGrpId", "(I)V", "getId", "setId", "()Z", "setEnable", "(Z)V", "getLevel", "setLevel", "getMnemonic", "setMnemonic", "getModuleCode", "setModuleCode", "getNameObj", "setNameObj", "getObjCode", "setObjCode", "getUpCode", "setUpCode", "getUpdatedAt", "()Ljava/util/Date;", "setUpdatedAt", "(Ljava/util/Date;)V", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class GrpPrvEntity {
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "updated_at")
    private java.util.Date updatedAt;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "obj_code")
    private java.lang.String objCode;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "acstype")
    private java.lang.String acsType;
    @androidx.room.ColumnInfo(name = "enabled")
    private boolean isEnable;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "acsval")
    private java.lang.String acsVal;
    @androidx.room.ColumnInfo(name = "grp_id")
    private int grpId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "code")
    private java.lang.String codeObj;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "up_code")
    private java.lang.String upCode;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "modul_code")
    private java.lang.String moduleCode;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "name")
    private java.lang.String nameObj;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "mnemonic")
    private java.lang.String mnemonic;
    @androidx.room.ColumnInfo(name = "level")
    private int level;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.GrpPrvEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "grpprv";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OBJ_CODE = "obj_code";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACS_TYPE = "acstype";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_ENABLE = "enabled";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACS_VAL = "acsval";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GRP_ID = "grp_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UPDATE_AT = "updated_at";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CODE_OBJ = "code";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UP_CODE = "up_code";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MODUL_CODE = "modul_code";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NAME_OBJ = "name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MNEMONIC = "mnemonic";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LEVEL = "level";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.GrpPrvEntity copy(int id, @org.jetbrains.annotations.NotNull()
    java.util.Date updatedAt, @org.jetbrains.annotations.NotNull()
    java.lang.String objCode, @org.jetbrains.annotations.NotNull()
    java.lang.String acsType, boolean isEnable, @org.jetbrains.annotations.Nullable()
    java.lang.String acsVal, int grpId, @org.jetbrains.annotations.NotNull()
    java.lang.String codeObj, @org.jetbrains.annotations.NotNull()
    java.lang.String upCode, @org.jetbrains.annotations.NotNull()
    java.lang.String moduleCode, @org.jetbrains.annotations.NotNull()
    java.lang.String nameObj, @org.jetbrains.annotations.NotNull()
    java.lang.String mnemonic, int level) {
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
    
    public GrpPrvEntity(int id, @org.jetbrains.annotations.NotNull()
    java.util.Date updatedAt, @org.jetbrains.annotations.NotNull()
    java.lang.String objCode, @org.jetbrains.annotations.NotNull()
    java.lang.String acsType, boolean isEnable, @org.jetbrains.annotations.Nullable()
    java.lang.String acsVal, int grpId, @org.jetbrains.annotations.NotNull()
    java.lang.String codeObj, @org.jetbrains.annotations.NotNull()
    java.lang.String upCode, @org.jetbrains.annotations.NotNull()
    java.lang.String moduleCode, @org.jetbrains.annotations.NotNull()
    java.lang.String nameObj, @org.jetbrains.annotations.NotNull()
    java.lang.String mnemonic, int level) {
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
    public final java.util.Date component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getUpdatedAt() {
        return null;
    }
    
    public final void setUpdatedAt(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getObjCode() {
        return null;
    }
    
    public final void setObjCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAcsType() {
        return null;
    }
    
    public final void setAcsType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean isEnable() {
        return false;
    }
    
    public final void setEnable(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAcsVal() {
        return null;
    }
    
    public final void setAcsVal(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int getGrpId() {
        return 0;
    }
    
    public final void setGrpId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCodeObj() {
        return null;
    }
    
    public final void setCodeObj(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUpCode() {
        return null;
    }
    
    public final void setUpCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getModuleCode() {
        return null;
    }
    
    public final void setModuleCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNameObj() {
        return null;
    }
    
    public final void setNameObj(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMnemonic() {
        return null;
    }
    
    public final void setMnemonic(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component13() {
        return 0;
    }
    
    public final int getLevel() {
        return 0;
    }
    
    public final void setLevel(int p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/GrpPrvEntity$Companion;", "", "()V", "ACS_TYPE", "", "ACS_VAL", "CODE_OBJ", "GRP_ID", "ID", "IS_ENABLE", "LEVEL", "MNEMONIC", "MODUL_CODE", "NAME_OBJ", "OBJ_CODE", "TBL_NAME", "UPDATE_AT", "UP_CODE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}