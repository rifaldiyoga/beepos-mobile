package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "saled", foreignKeys = {@androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.ItemEntity.class, childColumns = {"item_id"}, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.SaleEntity.class, childColumns = {"sale_id"}, onDelete = 5, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\bj\b\u0087\b\u0018\u0000 \u0089\u00012\u00020\u0001:\u0002\u0089\u0001B\u00b3\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020 \u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\"\u001a\u00020 \u00a2\u0006\u0002\u0010#J\u0010\u0010f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010+J\t\u0010g\u001a\u00020\tH\u00c6\u0003J\t\u0010h\u001a\u00020\tH\u00c6\u0003J\t\u0010i\u001a\u00020\tH\u00c6\u0003J\t\u0010j\u001a\u00020\tH\u00c6\u0003J\t\u0010k\u001a\u00020\tH\u00c6\u0003J\t\u0010l\u001a\u00020\tH\u00c6\u0003J\t\u0010m\u001a\u00020\u0003H\u00c6\u0003J\t\u0010n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010o\u001a\u00020\tH\u00c6\u0003J\t\u0010p\u001a\u00020\tH\u00c6\u0003J\t\u0010q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010r\u001a\u00020\tH\u00c6\u0003J\t\u0010s\u001a\u00020\u0006H\u00c6\u0003J\u0010\u0010t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010+J\u0010\u0010u\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010+J\u000b\u0010v\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010y\u001a\u00020 H\u00c6\u0003J\t\u0010z\u001a\u00020 H\u00c6\u0003J\t\u0010{\u001a\u00020 H\u00c6\u0003J\t\u0010|\u001a\u00020\u0006H\u00c6\u0003J\t\u0010}\u001a\u00020\u0006H\u00c6\u0003J\t\u0010~\u001a\u00020\tH\u00c6\u0003J\t\u0010\u007f\u001a\u00020\tH\u00c6\u0003J\n\u0010\u0080\u0001\u001a\u00020\tH\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\tH\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0006H\u00c6\u0003J\u00be\u0002\u0010\u0083\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 H\u00c6\u0001\u00a2\u0006\u0003\u0010\u0084\u0001J\u0015\u0010\u0085\u0001\u001a\u00020 2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0003H\u00d6\u0001J\n\u0010\u0088\u0001\u001a\u00020\u0006H\u00d6\u0001R\u001e\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R \u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010\'R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010%\"\u0004\b4\u0010\'R\u001e\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010%\"\u0004\b6\u0010\'R\u001e\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010%\"\u0004\b8\u0010\'R\u001e\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u00100\"\u0004\b:\u00102R\u001e\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010.\u001a\u0004\b?\u0010+\"\u0004\b@\u0010-R\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010A\"\u0004\bB\u0010CR\u001e\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010A\"\u0004\bD\u0010CR\u001e\u0010\"\u001a\u00020 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010A\"\u0004\bE\u0010CR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u00100\"\u0004\bG\u00102R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010<\"\u0004\bI\u0010>R\u001e\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010%\"\u0004\bK\u0010\'R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u00100\"\u0004\bM\u00102R \u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u00100\"\u0004\bO\u00102R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010%\"\u0004\bQ\u0010\'R\u001e\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010<\"\u0004\bS\u0010>R\u001e\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010%\"\u0004\bU\u0010\'R\u001e\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010%\"\u0004\bW\u0010\'R\u001e\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010%\"\u0004\bY\u0010\'R \u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u00100\"\u0004\b[\u00102R\u001e\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010%\"\u0004\b]\u0010\'R\u001e\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010%\"\u0004\b_\u0010\'R\u001e\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010%\"\u0004\ba\u0010\'R\u001e\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u0010%\"\u0004\bc\u0010\'R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010.\u001a\u0004\bd\u0010+\"\u0004\be\u0010-\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/SaledEntity;", "", "id", "", "itemId", "itemCode", "", "name", "qty", "Ljava/math/BigDecimal;", "listPrice", "disc", "tax", "discExp", "discAmt", "disc2Amt", "taxAmt", "basePrice", "taxableAmt", "subtotal", "saleId", "dno", "totalDiscAmt", "totalDisc2Amt", "totalTaxAmt", "dNotes", "crcId", "unitId", "conv", "pid", "taxCode", "isBonus", "", "isBonusUsed", "isDeleted", "(Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;IILjava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;ZZZ)V", "getBasePrice", "()Ljava/math/BigDecimal;", "setBasePrice", "(Ljava/math/BigDecimal;)V", "getConv", "setConv", "getCrcId", "()Ljava/lang/Integer;", "setCrcId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDNotes", "()Ljava/lang/String;", "setDNotes", "(Ljava/lang/String;)V", "getDisc", "setDisc", "getDisc2Amt", "setDisc2Amt", "getDiscAmt", "setDiscAmt", "getDiscExp", "setDiscExp", "getDno", "()I", "setDno", "(I)V", "getId", "setId", "()Z", "setBonus", "(Z)V", "setBonusUsed", "setDeleted", "getItemCode", "setItemCode", "getItemId", "setItemId", "getListPrice", "setListPrice", "getName", "setName", "getPid", "setPid", "getQty", "setQty", "getSaleId", "setSaleId", "getSubtotal", "setSubtotal", "getTax", "setTax", "getTaxAmt", "setTaxAmt", "getTaxCode", "setTaxCode", "getTaxableAmt", "setTaxableAmt", "getTotalDisc2Amt", "setTotalDisc2Amt", "getTotalDiscAmt", "setTotalDiscAmt", "getTotalTaxAmt", "setTotalTaxAmt", "getUnitId", "setUnitId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;IILjava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;ZZZ)Lcom/bits/bee/bpmc/data/data_source/local/model/SaledEntity;", "equals", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class SaledEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private java.lang.Integer id;
    @androidx.room.ColumnInfo(name = "item_id", index = true)
    private int itemId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "item_code")
    private java.lang.String itemCode;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "name")
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "qty")
    private java.math.BigDecimal qty;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "listprice")
    private java.math.BigDecimal listPrice;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "disc")
    private java.math.BigDecimal disc;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "tax")
    private java.math.BigDecimal tax;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "discexp")
    private java.lang.String discExp;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "discamt")
    private java.math.BigDecimal discAmt;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "disc2amt")
    private java.math.BigDecimal disc2Amt;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "taxamt")
    private java.math.BigDecimal taxAmt;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "baseprice")
    private java.math.BigDecimal basePrice;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "taxableamt")
    private java.math.BigDecimal taxableAmt;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "subtotal")
    private java.math.BigDecimal subtotal;
    @androidx.room.ColumnInfo(name = "sale_id", index = true)
    private int saleId;
    @androidx.room.ColumnInfo(name = "dno")
    private int dno;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "totaldiscamt")
    private java.math.BigDecimal totalDiscAmt;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "totaldisc2amt")
    private java.math.BigDecimal totalDisc2Amt;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "totaltaxamt")
    private java.math.BigDecimal totalTaxAmt;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "dnote")
    private java.lang.String dNotes;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "crc_id")
    private java.lang.Integer crcId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "unit_id")
    private java.lang.Integer unitId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "conv")
    private java.math.BigDecimal conv;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "pid")
    private java.lang.String pid;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "tax_code")
    private java.lang.String taxCode;
    @androidx.room.Ignore()
    private boolean isBonus;
    @androidx.room.Ignore()
    private boolean isBonusUsed;
    @androidx.room.Ignore()
    private boolean isDeleted;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.SaledEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "saled";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ITEM = "item";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ITEM_ID = "item_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ITEM_CODE = "item_code";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NAME = "name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String QTY = "qty";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LISTPRICE = "listprice";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DISC = "disc";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAX = "tax";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DISCEXP = "discexp";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DISCAMT = "discamt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DISC2AMT = "disc2amt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAXAMT = "taxamt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASEPRICE = "baseprice";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAXABLEAMT = "taxableamt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SUBTOTAL = "subtotal";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SALE_ID = "sale_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DNO = "dno";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOTAL_TAX_AMOUNT = "totaltaxamt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOTAL_DISC_AMOUNT = "totaldiscamt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOTAL_DISC2_AMOUNT = "totaldisc2amt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DNOTES = "dnote";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CRC_ID = "crc_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UNIT_ID = "unit_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CONV = "conv";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PID = "pid";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAX_CODE = "tax_code";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.SaledEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, int itemId, @org.jetbrains.annotations.NotNull()
    java.lang.String itemCode, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal qty, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal listPrice, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal disc, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal tax, @org.jetbrains.annotations.NotNull()
    java.lang.String discExp, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal discAmt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal disc2Amt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal taxAmt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal basePrice, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal taxableAmt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal subtotal, int saleId, int dno, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalDiscAmt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalDisc2Amt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalTaxAmt, @org.jetbrains.annotations.NotNull()
    java.lang.String dNotes, @org.jetbrains.annotations.Nullable()
    java.lang.Integer crcId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer unitId, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal conv, @org.jetbrains.annotations.Nullable()
    java.lang.String pid, @org.jetbrains.annotations.Nullable()
    java.lang.String taxCode, boolean isBonus, boolean isBonusUsed, boolean isDeleted) {
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
    
    public SaledEntity() {
        super();
    }
    
    public SaledEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, int itemId, @org.jetbrains.annotations.NotNull()
    java.lang.String itemCode, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal qty, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal listPrice, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal disc, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal tax, @org.jetbrains.annotations.NotNull()
    java.lang.String discExp, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal discAmt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal disc2Amt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal taxAmt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal basePrice, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal taxableAmt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal subtotal, int saleId, int dno, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalDiscAmt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalDisc2Amt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalTaxAmt, @org.jetbrains.annotations.NotNull()
    java.lang.String dNotes, @org.jetbrains.annotations.Nullable()
    java.lang.Integer crcId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer unitId, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal conv, @org.jetbrains.annotations.Nullable()
    java.lang.String pid, @org.jetbrains.annotations.Nullable()
    java.lang.String taxCode, boolean isBonus, boolean isBonusUsed, boolean isDeleted) {
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
    
    public final int component2() {
        return 0;
    }
    
    public final int getItemId() {
        return 0;
    }
    
    public final void setItemId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getItemCode() {
        return null;
    }
    
    public final void setItemCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getQty() {
        return null;
    }
    
    public final void setQty(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getListPrice() {
        return null;
    }
    
    public final void setListPrice(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getDisc() {
        return null;
    }
    
    public final void setDisc(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTax() {
        return null;
    }
    
    public final void setTax(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDiscExp() {
        return null;
    }
    
    public final void setDiscExp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getDiscAmt() {
        return null;
    }
    
    public final void setDiscAmt(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getDisc2Amt() {
        return null;
    }
    
    public final void setDisc2Amt(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTaxAmt() {
        return null;
    }
    
    public final void setTaxAmt(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getBasePrice() {
        return null;
    }
    
    public final void setBasePrice(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTaxableAmt() {
        return null;
    }
    
    public final void setTaxableAmt(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getSubtotal() {
        return null;
    }
    
    public final void setSubtotal(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    public final int component16() {
        return 0;
    }
    
    public final int getSaleId() {
        return 0;
    }
    
    public final void setSaleId(int p0) {
    }
    
    public final int component17() {
        return 0;
    }
    
    public final int getDno() {
        return 0;
    }
    
    public final void setDno(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotalDiscAmt() {
        return null;
    }
    
    public final void setTotalDiscAmt(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotalDisc2Amt() {
        return null;
    }
    
    public final void setTotalDisc2Amt(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotalTaxAmt() {
        return null;
    }
    
    public final void setTotalTaxAmt(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDNotes() {
        return null;
    }
    
    public final void setDNotes(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCrcId() {
        return null;
    }
    
    public final void setCrcId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getUnitId() {
        return null;
    }
    
    public final void setUnitId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getConv() {
        return null;
    }
    
    public final void setConv(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component25() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPid() {
        return null;
    }
    
    public final void setPid(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTaxCode() {
        return null;
    }
    
    public final void setTaxCode(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean component27() {
        return false;
    }
    
    public final boolean isBonus() {
        return false;
    }
    
    public final void setBonus(boolean p0) {
    }
    
    public final boolean component28() {
        return false;
    }
    
    public final boolean isBonusUsed() {
        return false;
    }
    
    public final void setBonusUsed(boolean p0) {
    }
    
    public final boolean component29() {
        return false;
    }
    
    public final boolean isDeleted() {
        return false;
    }
    
    public final void setDeleted(boolean p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/SaledEntity$Companion;", "", "()V", "BASEPRICE", "", "CONV", "CRC_ID", "DISC", "DISC2AMT", "DISCAMT", "DISCEXP", "DNO", "DNOTES", "ID", "ITEM", "ITEM_CODE", "ITEM_ID", "LISTPRICE", "NAME", "PID", "QTY", "SALE_ID", "SUBTOTAL", "TAX", "TAXABLEAMT", "TAXAMT", "TAX_CODE", "TBL_NAME", "TOTAL_DISC2_AMOUNT", "TOTAL_DISC_AMOUNT", "TOTAL_TAX_AMOUNT", "UNIT_ID", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}