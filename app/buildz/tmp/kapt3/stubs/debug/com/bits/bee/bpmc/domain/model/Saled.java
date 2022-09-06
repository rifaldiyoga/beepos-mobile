package com.bits.bee.bpmc.domain.model;

import java.lang.System;

/**
 * Created by aldi on 20/05/22.
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\br\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00e1\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010$\u001a\u00020\u001b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\'\u00a2\u0006\u0002\u0010(J\u0010\u0010t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00100J\t\u0010u\u001a\u00020\tH\u00c6\u0003J\t\u0010v\u001a\u00020\tH\u00c6\u0003J\t\u0010w\u001a\u00020\tH\u00c6\u0003J\t\u0010x\u001a\u00020\tH\u00c6\u0003J\t\u0010y\u001a\u00020\tH\u00c6\u0003J\t\u0010z\u001a\u00020\tH\u00c6\u0003J\t\u0010{\u001a\u00020\u0003H\u00c6\u0003J\t\u0010|\u001a\u00020\u0003H\u00c6\u0003J\t\u0010}\u001a\u00020\tH\u00c6\u0003J\t\u0010~\u001a\u00020\tH\u00c6\u0003J\t\u0010\u007f\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0080\u0001\u001a\u00020\tH\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u001bH\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u001bH\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u001bH\u00c6\u0003J\u0011\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00100J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00100J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0006H\u00c6\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\n\u0010\u008c\u0001\u001a\u00020\u001bH\u00c6\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\'H\u00c6\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0090\u0001\u001a\u00020\tH\u00c6\u0003J\n\u0010\u0091\u0001\u001a\u00020\tH\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020\tH\u00c6\u0003J\n\u0010\u0093\u0001\u001a\u00020\tH\u00c6\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0006H\u00c6\u0003J\u00ec\u0002\u0010\u0095\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010$\u001a\u00020\u001b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\'H\u00c6\u0001\u00a2\u0006\u0003\u0010\u0096\u0001J\n\u0010\u0097\u0001\u001a\u00020\u0003H\u00d6\u0001J\u0016\u0010\u0098\u0001\u001a\u00020\u001b2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u00d6\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0003H\u00d6\u0001J\n\u0010\u009c\u0001\u001a\u00020\u0006H\u00d6\u0001J\u001e\u0010\u009d\u0001\u001a\u00030\u009e\u00012\b\u0010\u009f\u0001\u001a\u00030\u00a0\u00012\u0007\u0010\u00a1\u0001\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\"\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0019\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00105\"\u0004\b9\u00107R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010*\"\u0004\b;\u0010,R\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010*\"\u0004\b=\u0010,R\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010*\"\u0004\b?\u0010,R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u00105\"\u0004\bA\u00107R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00103\u001a\u0004\bF\u00100\"\u0004\bG\u00102R\u001a\u0010$\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010H\"\u0004\bI\u0010JR\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010H\"\u0004\bK\u0010JR\u001a\u0010\u001c\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010H\"\u0004\bL\u0010JR\u001a\u0010\u001d\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010H\"\u0004\bM\u0010JR\u001c\u0010&\u001a\u0004\u0018\u00010\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u00105\"\u0004\bS\u00107R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010C\"\u0004\bU\u0010ER\u001a\u0010\n\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010*\"\u0004\bW\u0010,R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u00105\"\u0004\bY\u00107R\u001c\u0010#\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u00105\"\u0004\b[\u00107R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010*\"\u0004\b]\u0010,R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010C\"\u0004\b_\u0010ER\u001a\u0010\u0013\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010*\"\u0004\ba\u0010,R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u0010*\"\u0004\bc\u0010,R\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010*\"\u0004\be\u0010,R\u001c\u0010%\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u00105\"\u0004\bg\u00107R\u001a\u0010\u0012\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010*\"\u0004\bi\u0010,R\u001a\u0010\u0017\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010*\"\u0004\bk\u0010,R\u001a\u0010\u0016\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010*\"\u0004\bm\u0010,R\u001a\u0010\u0018\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010*\"\u0004\bo\u0010,R\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u00105\"\u0004\bq\u00107R\u001e\u0010 \u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00103\u001a\u0004\br\u00100\"\u0004\bs\u00102\u00a8\u0006\u00a2\u0001"}, d2 = {"Lcom/bits/bee/bpmc/domain/model/Saled;", "Landroid/os/Parcelable;", "id", "", "itemId", "itemCode", "", "name", "qty", "Ljava/math/BigDecimal;", "listPrice", "disc", "tax", "discExp", "discAmt", "disc2Amt", "taxAmt", "basePrice", "taxableAmt", "subtotal", "saleId", "dno", "totalDiscAmt", "totalDisc2Amt", "totalTaxAmt", "dNotes", "isBonus", "", "isBonusUsed", "isDeleted", "crcId", "crcSymbol", "unitId", "unit", "conv", "pid", "isAddOn", "taxCode", "item", "Lcom/bits/bee/bpmc/domain/model/Item;", "(Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;IILjava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;ZLjava/lang/String;Lcom/bits/bee/bpmc/domain/model/Item;)V", "getBasePrice", "()Ljava/math/BigDecimal;", "setBasePrice", "(Ljava/math/BigDecimal;)V", "getConv", "setConv", "getCrcId", "()Ljava/lang/Integer;", "setCrcId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCrcSymbol", "()Ljava/lang/String;", "setCrcSymbol", "(Ljava/lang/String;)V", "getDNotes", "setDNotes", "getDisc", "setDisc", "getDisc2Amt", "setDisc2Amt", "getDiscAmt", "setDiscAmt", "getDiscExp", "setDiscExp", "getDno", "()I", "setDno", "(I)V", "getId", "setId", "()Z", "setAddOn", "(Z)V", "setBonus", "setBonusUsed", "setDeleted", "getItem", "()Lcom/bits/bee/bpmc/domain/model/Item;", "setItem", "(Lcom/bits/bee/bpmc/domain/model/Item;)V", "getItemCode", "setItemCode", "getItemId", "setItemId", "getListPrice", "setListPrice", "getName", "setName", "getPid", "setPid", "getQty", "setQty", "getSaleId", "setSaleId", "getSubtotal", "setSubtotal", "getTax", "setTax", "getTaxAmt", "setTaxAmt", "getTaxCode", "setTaxCode", "getTaxableAmt", "setTaxableAmt", "getTotalDisc2Amt", "setTotalDisc2Amt", "getTotalDiscAmt", "setTotalDiscAmt", "getTotalTaxAmt", "setTotalTaxAmt", "getUnit", "setUnit", "getUnitId", "setUnitId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;IILjava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;ZLjava/lang/String;Lcom/bits/bee/bpmc/domain/model/Item;)Lcom/bits/bee/bpmc/domain/model/Saled;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Saled implements android.os.Parcelable {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer id;
    private int itemId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String itemCode;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal qty;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal listPrice;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal disc;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal tax;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String discExp;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal discAmt;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal disc2Amt;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal taxAmt;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal basePrice;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal taxableAmt;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal subtotal;
    private int saleId;
    private int dno;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal totalDiscAmt;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal totalDisc2Amt;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal totalTaxAmt;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String dNotes;
    private boolean isBonus;
    private boolean isBonusUsed;
    private boolean isDeleted;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer crcId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String crcSymbol;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer unitId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String unit;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal conv;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String pid;
    private boolean isAddOn;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String taxCode;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Item item;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.Saled> CREATOR = null;
    
    /**
     * Created by aldi on 20/05/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.model.Saled copy(@org.jetbrains.annotations.Nullable()
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
    java.lang.String dNotes, boolean isBonus, boolean isBonusUsed, boolean isDeleted, @org.jetbrains.annotations.Nullable()
    java.lang.Integer crcId, @org.jetbrains.annotations.Nullable()
    java.lang.String crcSymbol, @org.jetbrains.annotations.Nullable()
    java.lang.Integer unitId, @org.jetbrains.annotations.Nullable()
    java.lang.String unit, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal conv, @org.jetbrains.annotations.Nullable()
    java.lang.String pid, boolean isAddOn, @org.jetbrains.annotations.Nullable()
    java.lang.String taxCode, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Item item) {
        return null;
    }
    
    /**
     * Created by aldi on 20/05/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 20/05/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 20/05/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Saled() {
        super();
    }
    
    public Saled(@org.jetbrains.annotations.Nullable()
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
    java.lang.String dNotes, boolean isBonus, boolean isBonusUsed, boolean isDeleted, @org.jetbrains.annotations.Nullable()
    java.lang.Integer crcId, @org.jetbrains.annotations.Nullable()
    java.lang.String crcSymbol, @org.jetbrains.annotations.Nullable()
    java.lang.Integer unitId, @org.jetbrains.annotations.Nullable()
    java.lang.String unit, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal conv, @org.jetbrains.annotations.Nullable()
    java.lang.String pid, boolean isAddOn, @org.jetbrains.annotations.Nullable()
    java.lang.String taxCode, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Item item) {
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
    
    public final boolean component22() {
        return false;
    }
    
    public final boolean isBonus() {
        return false;
    }
    
    public final void setBonus(boolean p0) {
    }
    
    public final boolean component23() {
        return false;
    }
    
    public final boolean isBonusUsed() {
        return false;
    }
    
    public final void setBonusUsed(boolean p0) {
    }
    
    public final boolean component24() {
        return false;
    }
    
    public final boolean isDeleted() {
        return false;
    }
    
    public final void setDeleted(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component25() {
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
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCrcSymbol() {
        return null;
    }
    
    public final void setCrcSymbol(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component27() {
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
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUnit() {
        return null;
    }
    
    public final void setUnit(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component29() {
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
    public final java.lang.String component30() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPid() {
        return null;
    }
    
    public final void setPid(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean component31() {
        return false;
    }
    
    public final boolean isAddOn() {
        return false;
    }
    
    public final void setAddOn(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component32() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTaxCode() {
        return null;
    }
    
    public final void setTaxCode(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Item component33() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Item getItem() {
        return null;
    }
    
    public final void setItem(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Item p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.Saled> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.Saled createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.Saled[] newArray(int size) {
            return null;
        }
    }
}