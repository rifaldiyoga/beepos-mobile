package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "salecrcvs", foreignKeys = {@androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.SaleEntity.class, childColumns = {"sale"}, onDelete = 5, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\bM\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 W2\u00020\u0001:\u0001WB\u00a9\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u000b\u0010@\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010H\u001a\u00020\u0005H\u00c6\u0003J\t\u0010I\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010K\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u000b\u0010N\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u00d4\u0001\u0010P\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010QJ\u0013\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010U\u001a\u00020\u0003H\u00d6\u0001J\t\u0010V\u001a\u00020\u0005H\u00d6\u0001R \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR \u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0017\"\u0004\b(\u0010\u0019R \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0019R \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010\u0019R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0017\"\u0004\b8\u0010\u0019R \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0017\"\u0004\b:\u0010\u0019R \u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0017\"\u0004\b<\u0010\u0019R \u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0017\"\u0004\b>\u0010\u0019\u00a8\u0006X"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/SaleCrcvEntity;", "", "id", "", "rcvTypeCode", "", "saleInt", "rcvAmt", "note", "edcId", "cashId", "cardNo", "cctypeCode", "mdrExp", "mdrAmt", "surcExp", "surcAmt", "mdrAccId", "surAccId", "refId", "trackNo", "(Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardNo", "()Ljava/lang/String;", "setCardNo", "(Ljava/lang/String;)V", "getCashId", "()Ljava/lang/Integer;", "setCashId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCctypeCode", "setCctypeCode", "getEdcId", "setEdcId", "getId", "setId", "getMdrAccId", "setMdrAccId", "getMdrAmt", "setMdrAmt", "getMdrExp", "setMdrExp", "getNote", "setNote", "getRcvAmt", "setRcvAmt", "getRcvTypeCode", "setRcvTypeCode", "getRefId", "setRefId", "getSaleInt", "()I", "setSaleInt", "(I)V", "getSurAccId", "setSurAccId", "getSurcAmt", "setSurcAmt", "getSurcExp", "setSurcExp", "getTrackNo", "setTrackNo", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bits/bee/bpmc/data/data_source/local/model/SaleCrcvEntity;", "equals", "", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class SaleCrcvEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private java.lang.Integer id;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "rcvtype_code")
    private java.lang.String rcvTypeCode;
    @androidx.room.ColumnInfo(name = "sale", index = true)
    private int saleInt;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "rcvamt")
    private java.lang.String rcvAmt;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "note")
    private java.lang.String note;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "edc_id")
    private java.lang.Integer edcId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "cash_id")
    private java.lang.Integer cashId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "card_no")
    private java.lang.String cardNo;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "cctype_code")
    private java.lang.String cctypeCode;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "mdrexp")
    private java.lang.String mdrExp;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "mdramt")
    private java.lang.String mdrAmt;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "surcexp")
    private java.lang.String surcExp;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "surcamt")
    private java.lang.String surcAmt;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "mdracc_id")
    private java.lang.String mdrAccId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "surcacc_id")
    private java.lang.String surAccId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "ref_id")
    private java.lang.String refId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "track_no")
    private java.lang.String trackNo;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.SaleCrcvEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "salecrcvs";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RCVTYPE_CODE = "rcvtype_code";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SALE_ID = "sale";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RCVAMT = "rcvamt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTE = "note";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EDC_ID = "edc_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CASH_ID = "cash_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CARD_NO = "card_no";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CCTYPE_CODE = "cctype_code";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MDREXP = "mdrexp";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MDRAMT = "mdramt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SURCEXP = "surcexp";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SURCAMT = "surcamt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MDRACC_ID = "mdracc_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SURACC_ID = "surcacc_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String REF_ID = "ref_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TRACK_NO = "track_no";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.SaleCrcvEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.NotNull()
    java.lang.String rcvTypeCode, int saleInt, @org.jetbrains.annotations.Nullable()
    java.lang.String rcvAmt, @org.jetbrains.annotations.NotNull()
    java.lang.String note, @org.jetbrains.annotations.Nullable()
    java.lang.Integer edcId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer cashId, @org.jetbrains.annotations.Nullable()
    java.lang.String cardNo, @org.jetbrains.annotations.Nullable()
    java.lang.String cctypeCode, @org.jetbrains.annotations.Nullable()
    java.lang.String mdrExp, @org.jetbrains.annotations.Nullable()
    java.lang.String mdrAmt, @org.jetbrains.annotations.Nullable()
    java.lang.String surcExp, @org.jetbrains.annotations.Nullable()
    java.lang.String surcAmt, @org.jetbrains.annotations.Nullable()
    java.lang.String mdrAccId, @org.jetbrains.annotations.Nullable()
    java.lang.String surAccId, @org.jetbrains.annotations.Nullable()
    java.lang.String refId, @org.jetbrains.annotations.Nullable()
    java.lang.String trackNo) {
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
    
    public SaleCrcvEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.NotNull()
    java.lang.String rcvTypeCode, int saleInt, @org.jetbrains.annotations.Nullable()
    java.lang.String rcvAmt, @org.jetbrains.annotations.NotNull()
    java.lang.String note, @org.jetbrains.annotations.Nullable()
    java.lang.Integer edcId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer cashId, @org.jetbrains.annotations.Nullable()
    java.lang.String cardNo, @org.jetbrains.annotations.Nullable()
    java.lang.String cctypeCode, @org.jetbrains.annotations.Nullable()
    java.lang.String mdrExp, @org.jetbrains.annotations.Nullable()
    java.lang.String mdrAmt, @org.jetbrains.annotations.Nullable()
    java.lang.String surcExp, @org.jetbrains.annotations.Nullable()
    java.lang.String surcAmt, @org.jetbrains.annotations.Nullable()
    java.lang.String mdrAccId, @org.jetbrains.annotations.Nullable()
    java.lang.String surAccId, @org.jetbrains.annotations.Nullable()
    java.lang.String refId, @org.jetbrains.annotations.Nullable()
    java.lang.String trackNo) {
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
    public final java.lang.String getRcvTypeCode() {
        return null;
    }
    
    public final void setRcvTypeCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getSaleInt() {
        return 0;
    }
    
    public final void setSaleInt(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRcvAmt() {
        return null;
    }
    
    public final void setRcvAmt(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNote() {
        return null;
    }
    
    public final void setNote(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getEdcId() {
        return null;
    }
    
    public final void setEdcId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCashId() {
        return null;
    }
    
    public final void setCashId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCardNo() {
        return null;
    }
    
    public final void setCardNo(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCctypeCode() {
        return null;
    }
    
    public final void setCctypeCode(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMdrExp() {
        return null;
    }
    
    public final void setMdrExp(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMdrAmt() {
        return null;
    }
    
    public final void setMdrAmt(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSurcExp() {
        return null;
    }
    
    public final void setSurcExp(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSurcAmt() {
        return null;
    }
    
    public final void setSurcAmt(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMdrAccId() {
        return null;
    }
    
    public final void setMdrAccId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSurAccId() {
        return null;
    }
    
    public final void setSurAccId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRefId() {
        return null;
    }
    
    public final void setRefId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTrackNo() {
        return null;
    }
    
    public final void setTrackNo(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/SaleCrcvEntity$Companion;", "", "()V", "CARD_NO", "", "CASH_ID", "CCTYPE_CODE", "EDC_ID", "ID", "MDRACC_ID", "MDRAMT", "MDREXP", "NOTE", "RCVAMT", "RCVTYPE_CODE", "REF_ID", "SALE_ID", "SURACC_ID", "SURCAMT", "SURCEXP", "TBL_NAME", "TRACK_NO", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}