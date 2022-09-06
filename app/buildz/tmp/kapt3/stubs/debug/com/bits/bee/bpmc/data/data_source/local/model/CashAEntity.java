package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "casha", foreignKeys = {})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b=\b\u0087\b\u0018\u0000 J2\u00020\u0001:\u0001JBi\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u0013J\u0010\u00108\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010#J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u000eH\u00c6\u0003J\t\u0010<\u001a\u00020\u0005H\u00c6\u0003J\t\u0010=\u001a\u00020\u0007H\u00c6\u0003J\t\u0010>\u001a\u00020\u0005H\u00c6\u0003J\t\u0010?\u001a\u00020\u0005H\u00c6\u0003J\t\u0010@\u001a\u00020\u0005H\u00c6\u0003J\t\u0010A\u001a\u00020\fH\u00c6\u0003J\t\u0010B\u001a\u00020\u000eH\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\u0088\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000eH\u00c6\u0001\u00a2\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020\u000e2\b\u0010G\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010H\u001a\u00020\u0003H\u00d6\u0001J\t\u0010I\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001e\u0010\u0012\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0019\"\u0004\b+\u0010\u001bR\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010(\"\u0004\b5\u0010*R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010\u001f\u00a8\u0006K"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/CashAEntity;", "", "id", "", "trxDate", "", "amount", "Ljava/math/BigDecimal;", "note", "inOut", "refType", "refId", "", "autoGen", "", "cashId", "userId", "cashierId", "isUploaded", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZIIIZ)V", "getAmount", "()Ljava/math/BigDecimal;", "setAmount", "(Ljava/math/BigDecimal;)V", "getAutoGen", "()Z", "setAutoGen", "(Z)V", "getCashId", "()I", "setCashId", "(I)V", "getCashierId", "setCashierId", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getInOut", "()Ljava/lang/String;", "setInOut", "(Ljava/lang/String;)V", "setUploaded", "getNote", "setNote", "getRefId", "()J", "setRefId", "(J)V", "getRefType", "setRefType", "getTrxDate", "setTrxDate", "getUserId", "setUserId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZIIIZ)Lcom/bits/bee/bpmc/data/data_source/local/model/CashAEntity;", "equals", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class CashAEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private java.lang.Integer id;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "trxdate")
    private java.lang.String trxDate;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "amount")
    private java.math.BigDecimal amount;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "note")
    private java.lang.String note;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "inout")
    private java.lang.String inOut;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "reftype")
    private java.lang.String refType;
    @androidx.room.ColumnInfo(name = "refid")
    private long refId;
    @androidx.room.ColumnInfo(name = "autogen")
    private boolean autoGen;
    @androidx.room.ColumnInfo(name = "cash_id")
    private int cashId;
    @androidx.room.ColumnInfo(name = "user_id")
    private int userId;
    @androidx.room.ColumnInfo(name = "cashier_id")
    private int cashierId;
    @androidx.room.ColumnInfo(name = "isuploaded")
    private boolean isUploaded;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.CashAEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "casha";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_TRANS = "trxdate";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AMOUNT = "amount";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTE = "note";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATUS = "inout";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String REFTYPE = "reftype";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String REFID = "refid";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AUTOGEN = "autogen";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CASH_ID = "cash_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String USER_ID = "user_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CASHIER_ID = "cashier_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ISUPLOADED = "isuploaded";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.CashAEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.NotNull()
    java.lang.String trxDate, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal amount, @org.jetbrains.annotations.NotNull()
    java.lang.String note, @org.jetbrains.annotations.NotNull()
    java.lang.String inOut, @org.jetbrains.annotations.NotNull()
    java.lang.String refType, long refId, boolean autoGen, int cashId, int userId, int cashierId, boolean isUploaded) {
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
    
    public CashAEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.NotNull()
    java.lang.String trxDate, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal amount, @org.jetbrains.annotations.NotNull()
    java.lang.String note, @org.jetbrains.annotations.NotNull()
    java.lang.String inOut, @org.jetbrains.annotations.NotNull()
    java.lang.String refType, long refId, boolean autoGen, int cashId, int userId, int cashierId, boolean isUploaded) {
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
    public final java.lang.String getTrxDate() {
        return null;
    }
    
    public final void setTrxDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getAmount() {
        return null;
    }
    
    public final void setAmount(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNote() {
        return null;
    }
    
    public final void setNote(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getInOut() {
        return null;
    }
    
    public final void setInOut(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRefType() {
        return null;
    }
    
    public final void setRefType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final long component7() {
        return 0L;
    }
    
    public final long getRefId() {
        return 0L;
    }
    
    public final void setRefId(long p0) {
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean getAutoGen() {
        return false;
    }
    
    public final void setAutoGen(boolean p0) {
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getCashId() {
        return 0;
    }
    
    public final void setCashId(int p0) {
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int getUserId() {
        return 0;
    }
    
    public final void setUserId(int p0) {
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int getCashierId() {
        return 0;
    }
    
    public final void setCashierId(int p0) {
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final boolean isUploaded() {
        return false;
    }
    
    public final void setUploaded(boolean p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/CashAEntity$Companion;", "", "()V", "AMOUNT", "", "AUTOGEN", "CASHIER_ID", "CASH_ID", "DATE_TRANS", "ID", "ISUPLOADED", "NOTE", "REFID", "REFTYPE", "STATUS", "TBL_NAME", "USER_ID", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}