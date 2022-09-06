package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "edcsurc", foreignKeys = {@androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.EdcEntity.class, childColumns = {"edc_id"}, onDelete = 5, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b/\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0001=B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\u000fH\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u0005H\u00c6\u0003J\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003Jw\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u00c6\u0001J\u0013\u00109\u001a\u00020\u000f2\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010;\u001a\u00020\u0003H\u00d6\u0001J\t\u0010<\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018\u00a8\u0006>"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/EdcSurcEntity;", "", "id", "", "edcSurcNo", "", "edcId", "ccType", "ccTypeDesc", "surcExp", "mdrExp", "surcAccId", "mdrAccId", "edcSurcType", "active", "", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Z)V", "getActive", "()Z", "setActive", "(Z)V", "getCcType", "()Ljava/lang/String;", "setCcType", "(Ljava/lang/String;)V", "getCcTypeDesc", "setCcTypeDesc", "getEdcId", "()I", "setEdcId", "(I)V", "getEdcSurcNo", "setEdcSurcNo", "getEdcSurcType", "setEdcSurcType", "getId", "setId", "getMdrAccId", "setMdrAccId", "getMdrExp", "setMdrExp", "getSurcAccId", "setSurcAccId", "getSurcExp", "setSurcExp", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class EdcSurcEntity {
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = false)
    private int id;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "edcsurcno")
    private java.lang.String edcSurcNo;
    @androidx.room.ColumnInfo(name = "edc_id", index = true)
    private int edcId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "cctype")
    private java.lang.String ccType;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "cctypedesc")
    private java.lang.String ccTypeDesc;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "surcexp")
    private java.lang.String surcExp;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "mdrexp")
    private java.lang.String mdrExp;
    @androidx.room.ColumnInfo(name = "surcacc_id")
    private int surcAccId;
    @androidx.room.ColumnInfo(name = "mdracc_id")
    private int mdrAccId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "edcsurctype")
    private java.lang.String edcSurcType;
    @androidx.room.ColumnInfo(name = "active")
    private boolean active;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.EdcSurcEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "edcsurc";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EDCSURCN0 = "edcsurcno";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EDC_ID = "edc_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CCTYPE = "cctype";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CCTYPEDESC = "cctypedesc";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SURCEXP = "surcexp";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MDREXP = "mdrexp";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SURCACC_ID = "surcacc_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MDRACC_ID = "mdracc_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EDCSURCTYPE = "edcsurctype";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVE = "active";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.EdcSurcEntity copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String edcSurcNo, int edcId, @org.jetbrains.annotations.NotNull()
    java.lang.String ccType, @org.jetbrains.annotations.NotNull()
    java.lang.String ccTypeDesc, @org.jetbrains.annotations.NotNull()
    java.lang.String surcExp, @org.jetbrains.annotations.NotNull()
    java.lang.String mdrExp, int surcAccId, int mdrAccId, @org.jetbrains.annotations.NotNull()
    java.lang.String edcSurcType, boolean active) {
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
    
    public EdcSurcEntity(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String edcSurcNo, int edcId, @org.jetbrains.annotations.NotNull()
    java.lang.String ccType, @org.jetbrains.annotations.NotNull()
    java.lang.String ccTypeDesc, @org.jetbrains.annotations.NotNull()
    java.lang.String surcExp, @org.jetbrains.annotations.NotNull()
    java.lang.String mdrExp, int surcAccId, int mdrAccId, @org.jetbrains.annotations.NotNull()
    java.lang.String edcSurcType, boolean active) {
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
    public final java.lang.String getEdcSurcNo() {
        return null;
    }
    
    public final void setEdcSurcNo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getEdcId() {
        return 0;
    }
    
    public final void setEdcId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCcType() {
        return null;
    }
    
    public final void setCcType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCcTypeDesc() {
        return null;
    }
    
    public final void setCcTypeDesc(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSurcExp() {
        return null;
    }
    
    public final void setSurcExp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMdrExp() {
        return null;
    }
    
    public final void setMdrExp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getSurcAccId() {
        return 0;
    }
    
    public final void setSurcAccId(int p0) {
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getMdrAccId() {
        return 0;
    }
    
    public final void setMdrAccId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEdcSurcType() {
        return null;
    }
    
    public final void setEdcSurcType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean getActive() {
        return false;
    }
    
    public final void setActive(boolean p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/EdcSurcEntity$Companion;", "", "()V", "ACTIVE", "", "CCTYPE", "CCTYPEDESC", "EDCSURCN0", "EDCSURCTYPE", "EDC_ID", "ID", "MDRACC_ID", "MDREXP", "SURCACC_ID", "SURCEXP", "TBL_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}