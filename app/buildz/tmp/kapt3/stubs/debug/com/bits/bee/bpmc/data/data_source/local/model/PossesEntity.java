package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "posses", foreignKeys = {@androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.UserEntity.class, childColumns = {"user_id"}, onDelete = 5, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.CashierEntity.class, childColumns = {"cashier_id"}, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\bG\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 ]2\u00020\u0001:\u0001]B\u00a1\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u0011H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010K\u001a\u00020\tH\u00c6\u0003J\t\u0010L\u001a\u00020\tH\u00c6\u0003J\t\u0010M\u001a\u00020\tH\u00c6\u0003J\t\u0010N\u001a\u00020\u0005H\u00c6\u0003J\t\u0010O\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010Q\u001a\u00020\tH\u00c6\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010S\u001a\u00020\tH\u00c6\u0003J\t\u0010T\u001a\u00020\tH\u00c6\u0003J\t\u0010U\u001a\u00020\u0003H\u00c6\u0003J\u00c2\u0001\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\tH\u00c6\u0001\u00a2\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010[\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\\\u001a\u00020\u0011H\u00d6\u0001R\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001e\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u001bR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010%\"\u0004\b2\u0010\'R \u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010\u001fR \u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001d\"\u0004\b6\u0010\u001fR\u001e\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001d\"\u0004\b8\u0010\u001fR\u001e\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001d\"\u0004\b:\u0010\u001fR\u001e\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001d\"\u0004\b<\u0010\u001fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010%\"\u0004\b>\u0010\'R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0019\"\u0004\bD\u0010\u001b\u00a8\u0006^"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/PossesEntity;", "", "possesId", "", "trxDate", "Ljava/util/Date;", "startTime", "endTime", "startBal", "Ljava/math/BigDecimal;", "endBal", "total", "credit", "shift", "userId", "cashierId", "trxNo", "", "totIn", "totOut", "endCash", "totalActualCash", "totalDiffCash", "(Ljava/lang/Integer;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;IIILjava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;)V", "getCashierId", "()I", "setCashierId", "(I)V", "getCredit", "()Ljava/math/BigDecimal;", "setCredit", "(Ljava/math/BigDecimal;)V", "getEndBal", "setEndBal", "getEndCash", "setEndCash", "getEndTime", "()Ljava/util/Date;", "setEndTime", "(Ljava/util/Date;)V", "getPossesId", "()Ljava/lang/Integer;", "setPossesId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getShift", "setShift", "getStartBal", "setStartBal", "getStartTime", "setStartTime", "getTotIn", "setTotIn", "getTotOut", "setTotOut", "getTotal", "setTotal", "getTotalActualCash", "setTotalActualCash", "getTotalDiffCash", "setTotalDiffCash", "getTrxDate", "setTrxDate", "getTrxNo", "()Ljava/lang/String;", "setTrxNo", "(Ljava/lang/String;)V", "getUserId", "setUserId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;IIILjava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;)Lcom/bits/bee/bpmc/data/data_source/local/model/PossesEntity;", "equals", "", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class PossesEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = false)
    private java.lang.Integer possesId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "trxdate")
    private java.util.Date trxDate;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "starttime")
    private java.util.Date startTime;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "endtime")
    private java.util.Date endTime;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "startbal")
    private java.math.BigDecimal startBal;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "endbal")
    private java.math.BigDecimal endBal;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "total")
    private java.math.BigDecimal total;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "credit")
    private java.math.BigDecimal credit;
    @androidx.room.ColumnInfo(name = "shift")
    private int shift;
    @androidx.room.ColumnInfo(name = "user_id", index = true)
    private int userId;
    @androidx.room.ColumnInfo(name = "cashier_id", index = true)
    private int cashierId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "trxno")
    private java.lang.String trxNo;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "totin")
    private java.math.BigDecimal totIn;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "totout")
    private java.math.BigDecimal totOut;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "endcash")
    private java.math.BigDecimal endCash;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "totactualcash")
    private java.math.BigDecimal totalActualCash;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "totdiffcash")
    private java.math.BigDecimal totalDiffCash;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.PossesEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "posses";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TRXDATE = "trxdate";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String START_TIME = "starttime";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String END_TIME = "endtime";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String START_BAL = "startbal";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String END_BAL = "endbal";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOTAL = "total";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CREDIT = "credit";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SHIFT = "shift";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String USER_ID = "user_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CASHIER_ID = "cashier_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TRXNO = "trxno";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KODE_POSSES = "kode_posses";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOTIN = "totin";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOTOUT = "totout";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ENDCASH = "endcash";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOTAL_ACTUAL_CASH = "totactualcash";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOTAL_DIFF_CASH = "totdiffcash";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.PossesEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer possesId, @org.jetbrains.annotations.NotNull()
    java.util.Date trxDate, @org.jetbrains.annotations.NotNull()
    java.util.Date startTime, @org.jetbrains.annotations.Nullable()
    java.util.Date endTime, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal startBal, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal endBal, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal total, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal credit, int shift, int userId, int cashierId, @org.jetbrains.annotations.NotNull()
    java.lang.String trxNo, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal totIn, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal totOut, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal endCash, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalActualCash, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalDiffCash) {
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
    
    public PossesEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Integer possesId, @org.jetbrains.annotations.NotNull()
    java.util.Date trxDate, @org.jetbrains.annotations.NotNull()
    java.util.Date startTime, @org.jetbrains.annotations.Nullable()
    java.util.Date endTime, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal startBal, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal endBal, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal total, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal credit, int shift, int userId, int cashierId, @org.jetbrains.annotations.NotNull()
    java.lang.String trxNo, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal totIn, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal totOut, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal endCash, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalActualCash, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalDiffCash) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getPossesId() {
        return null;
    }
    
    public final void setPossesId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getTrxDate() {
        return null;
    }
    
    public final void setTrxDate(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getStartTime() {
        return null;
    }
    
    public final void setStartTime(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getEndTime() {
        return null;
    }
    
    public final void setEndTime(@org.jetbrains.annotations.Nullable()
    java.util.Date p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getStartBal() {
        return null;
    }
    
    public final void setStartBal(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getEndBal() {
        return null;
    }
    
    public final void setEndBal(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotal() {
        return null;
    }
    
    public final void setTotal(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getCredit() {
        return null;
    }
    
    public final void setCredit(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getShift() {
        return 0;
    }
    
    public final void setShift(int p0) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTrxNo() {
        return null;
    }
    
    public final void setTrxNo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getTotIn() {
        return null;
    }
    
    public final void setTotIn(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getTotOut() {
        return null;
    }
    
    public final void setTotOut(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getEndCash() {
        return null;
    }
    
    public final void setEndCash(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotalActualCash() {
        return null;
    }
    
    public final void setTotalActualCash(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotalDiffCash() {
        return null;
    }
    
    public final void setTotalDiffCash(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/PossesEntity$Companion;", "", "()V", "CASHIER_ID", "", "CREDIT", "ENDCASH", "END_BAL", "END_TIME", "ID", "KODE_POSSES", "SHIFT", "START_BAL", "START_TIME", "TBL_NAME", "TOTAL", "TOTAL_ACTUAL_CASH", "TOTAL_DIFF_CASH", "TOTIN", "TOTOUT", "TRXDATE", "TRXNO", "USER_ID", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}