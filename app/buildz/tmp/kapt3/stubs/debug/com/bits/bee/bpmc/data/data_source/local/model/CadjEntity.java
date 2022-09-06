package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "cadj", foreignKeys = {@androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.CashEntity.class, childColumns = {"cash_id"}, onDelete = 5, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.UserEntity.class, childColumns = {"user_id"}, onDelete = 5, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.CashierEntity.class, childColumns = {"cashier_id"}, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\bI\b\u0087\b\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0095\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0019J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\u000bH\u00c6\u0003J\t\u0010J\u001a\u00020\tH\u00c6\u0003J\t\u0010K\u001a\u00020\tH\u00c6\u0003J\t\u0010L\u001a\u00020\u0015H\u00c6\u0003J\t\u0010M\u001a\u00020\u0003H\u00c6\u0003J\t\u0010N\u001a\u00020\u0015H\u00c6\u0003J\t\u0010O\u001a\u00020\u0003H\u00c6\u0003J\t\u0010P\u001a\u00020\u0005H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0007H\u00c6\u0003J\t\u0010R\u001a\u00020\tH\u00c6\u0003J\t\u0010S\u001a\u00020\u000bH\u00c6\u0003J\t\u0010T\u001a\u00020\tH\u00c6\u0003J\t\u0010U\u001a\u00020\tH\u00c6\u0003J\t\u0010V\u001a\u00020\u0003H\u00c6\u0003J\t\u0010W\u001a\u00020\u0003H\u00c6\u0003J\u00b3\u0001\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010Y\u001a\u00020\u000b2\b\u0010Z\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010[\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\\\u001a\u00020\tH\u00d6\u0001R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b\'\u0010%R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R\u001e\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u00100\"\u0004\b1\u00102R\u001e\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001f\"\u0004\b4\u0010!R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R\u001e\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001f\"\u0004\b:\u0010!R\u001e\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u00100\"\u0004\b>\u00102R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010\u0017\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010)\"\u0004\bD\u0010+R\u001e\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010#\"\u0004\bF\u0010%\u00a8\u0006^"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/CadjEntity;", "", "id", "", "trxDate", "", "amount", "Ljava/math/BigDecimal;", "note", "", "status", "", "refType", "autoGen", "cashAId", "operatorId", "cashierId", "isUploaded", "kodeCadj", "refNo", "createdAt", "Ljava/util/Date;", "createdBy", "updatedAt", "updatedBy", "(IJLjava/math/BigDecimal;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;IIIZLjava/lang/String;Ljava/lang/String;Ljava/util/Date;ILjava/util/Date;I)V", "getAmount", "()Ljava/math/BigDecimal;", "setAmount", "(Ljava/math/BigDecimal;)V", "getAutoGen", "()Ljava/lang/String;", "setAutoGen", "(Ljava/lang/String;)V", "getCashAId", "()I", "setCashAId", "(I)V", "getCashierId", "setCashierId", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "getCreatedBy", "setCreatedBy", "getId", "setId", "()Z", "setUploaded", "(Z)V", "getKodeCadj", "setKodeCadj", "getNote", "setNote", "getOperatorId", "setOperatorId", "getRefNo", "setRefNo", "getRefType", "setRefType", "getStatus", "setStatus", "getTrxDate", "()J", "setTrxDate", "(J)V", "getUpdatedAt", "setUpdatedAt", "getUpdatedBy", "setUpdatedBy", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class CadjEntity {
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = false)
    private int id;
    @androidx.room.ColumnInfo(name = "trxdate")
    private long trxDate;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "amount")
    private java.math.BigDecimal amount;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "note")
    private java.lang.String note;
    @androidx.room.ColumnInfo(name = "inout")
    private boolean status;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "reftype")
    private java.lang.String refType;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "autogen")
    private java.lang.String autoGen;
    @androidx.room.ColumnInfo(name = "cash_id", index = true)
    private int cashAId;
    @androidx.room.ColumnInfo(name = "user_id", index = true)
    private int operatorId;
    @androidx.room.ColumnInfo(name = "cashier_id", index = true)
    private int cashierId;
    @androidx.room.ColumnInfo(name = "isuploaded")
    private boolean isUploaded;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "kode_cadj")
    private java.lang.String kodeCadj;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "refno")
    private java.lang.String refNo;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "created_at")
    private java.util.Date createdAt;
    @androidx.room.ColumnInfo(name = "created_by")
    private int createdBy;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "updated_at")
    private java.util.Date updatedAt;
    @androidx.room.ColumnInfo(name = "updated_by")
    private int updatedBy;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.CadjEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "cadj";
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
    public static final java.lang.String KODE_CADJ = "kode_cadj";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String REFNO = "refno";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CREATED_AT = "created_at";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CREATED_BY = "created_by";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UPDATED_AT = "updated_at";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UPDATED_BY = "updated_by";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.CadjEntity copy(int id, long trxDate, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal amount, @org.jetbrains.annotations.NotNull()
    java.lang.String note, boolean status, @org.jetbrains.annotations.NotNull()
    java.lang.String refType, @org.jetbrains.annotations.NotNull()
    java.lang.String autoGen, int cashAId, int operatorId, int cashierId, boolean isUploaded, @org.jetbrains.annotations.NotNull()
    java.lang.String kodeCadj, @org.jetbrains.annotations.NotNull()
    java.lang.String refNo, @org.jetbrains.annotations.NotNull()
    java.util.Date createdAt, int createdBy, @org.jetbrains.annotations.NotNull()
    java.util.Date updatedAt, int updatedBy) {
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
    
    public CadjEntity(int id, long trxDate, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal amount, @org.jetbrains.annotations.NotNull()
    java.lang.String note, boolean status, @org.jetbrains.annotations.NotNull()
    java.lang.String refType, @org.jetbrains.annotations.NotNull()
    java.lang.String autoGen, int cashAId, int operatorId, int cashierId, boolean isUploaded, @org.jetbrains.annotations.NotNull()
    java.lang.String kodeCadj, @org.jetbrains.annotations.NotNull()
    java.lang.String refNo, @org.jetbrains.annotations.NotNull()
    java.util.Date createdAt, int createdBy, @org.jetbrains.annotations.NotNull()
    java.util.Date updatedAt, int updatedBy) {
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
    
    public final long component2() {
        return 0L;
    }
    
    public final long getTrxDate() {
        return 0L;
    }
    
    public final void setTrxDate(long p0) {
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
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean getStatus() {
        return false;
    }
    
    public final void setStatus(boolean p0) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAutoGen() {
        return null;
    }
    
    public final void setAutoGen(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getCashAId() {
        return 0;
    }
    
    public final void setCashAId(int p0) {
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getOperatorId() {
        return 0;
    }
    
    public final void setOperatorId(int p0) {
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int getCashierId() {
        return 0;
    }
    
    public final void setCashierId(int p0) {
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean isUploaded() {
        return false;
    }
    
    public final void setUploaded(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKodeCadj() {
        return null;
    }
    
    public final void setKodeCadj(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRefNo() {
        return null;
    }
    
    public final void setRefNo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
    }
    
    public final int component15() {
        return 0;
    }
    
    public final int getCreatedBy() {
        return 0;
    }
    
    public final void setCreatedBy(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getUpdatedAt() {
        return null;
    }
    
    public final void setUpdatedAt(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
    }
    
    public final int component17() {
        return 0;
    }
    
    public final int getUpdatedBy() {
        return 0;
    }
    
    public final void setUpdatedBy(int p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/CadjEntity$Companion;", "", "()V", "AMOUNT", "", "AUTOGEN", "CASHIER_ID", "CASH_ID", "CREATED_AT", "CREATED_BY", "DATE_TRANS", "ID", "ISUPLOADED", "KODE_CADJ", "NOTE", "REFNO", "REFTYPE", "STATUS", "TBL_NAME", "UPDATED_AT", "UPDATED_BY", "USER_ID", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}