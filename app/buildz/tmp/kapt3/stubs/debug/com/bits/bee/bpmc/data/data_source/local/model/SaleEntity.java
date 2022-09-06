package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "sale", foreignKeys = {@androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.PossesEntity.class, childColumns = {"posses_id"}, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0003\b\u0092\u0001\b\u0087\b\u0018\u0000 \u00a0\u00012\u00020\u0001:\u0002\u00a0\u0001B\u00dd\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006\u0012\b\b\u0002\u0010!\u001a\u00020\n\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0006\u0012\b\b\u0002\u0010$\u001a\u00020\u000f\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\u000f\u0012\b\b\u0002\u0010\'\u001a\u00020\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010x\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00109J\t\u0010y\u001a\u00020\nH\u00c6\u0003J\t\u0010z\u001a\u00020\nH\u00c6\u0003J\t\u0010{\u001a\u00020\nH\u00c6\u0003J\t\u0010|\u001a\u00020\nH\u00c6\u0003J\t\u0010}\u001a\u00020\u0003H\u00c6\u0003J\t\u0010~\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u007f\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u008b\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u008f\u0001\u001a\u00020\u000fH\u00c6\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0091\u0001\u001a\u00020\u000fH\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00109J\n\u0010\u0094\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u0095\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u0096\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0099\u0001\u001a\u00020\u000fH\u00c6\u0003J\u00e8\u0002\u0010\u009a\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010\'\u001a\u00020\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0003\u0010\u009b\u0001J\u0015\u0010\u009c\u0001\u001a\u00020\b2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0003H\u00d6\u0001J\n\u0010\u009f\u0001\u001a\u00020\u0006H\u00d6\u0001R\u001e\u0010\u0019\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u001a\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R\u001e\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001e\u0010\"\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010+\"\u0004\b7\u0010-R\"\u0010(\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010$\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010%\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010+\"\u0004\bB\u0010-R\u001e\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010/\"\u0004\bH\u00101R\u001e\u0010 \u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010/\"\u0004\bJ\u00101R\u001e\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010/\"\u0004\bL\u00101R\u001e\u0010\u001e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010/\"\u0004\bN\u00101R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010<\u001a\u0004\bO\u00109\"\u0004\bP\u0010;R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010Q\"\u0004\bR\u0010SR\u001e\u0010\u001c\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010Q\"\u0004\bT\u0010SR\u001e\u0010\u001d\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010Q\"\u0004\bU\u0010SR\u001e\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010/\"\u0004\bW\u00101R\u001e\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010/\"\u0004\bY\u00101R\u001e\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010+\"\u0004\b[\u0010-R\u001e\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010D\"\u0004\b]\u0010FR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010D\"\u0004\b_\u0010FR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010D\"\u0004\ba\u0010FR\u001e\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u0010/\"\u0004\bc\u00101R\u001e\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010D\"\u0004\be\u0010FR\u001e\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010D\"\u0004\bg\u0010FR\u001e\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010D\"\u0004\bi\u0010FR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010>\"\u0004\bk\u0010@R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010/\"\u0004\bm\u00101R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010+\"\u0004\bo\u0010-R\u001e\u0010&\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010>\"\u0004\bq\u0010@R\u001e\u0010\'\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010+\"\u0004\bs\u0010-R\u001e\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u0010+\"\u0004\bu\u0010-R\u001e\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010/\"\u0004\bw\u00101\u00a8\u0006\u00a1\u0001"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/SaleEntity;", "", "id", "", "trxOrderNum", "trxNo", "", "isDraft", "", "subtotal", "Ljava/math/BigDecimal;", "total", "oprName", "cashiername", "trxDate", "Ljava/util/Date;", "totPaid", "totChange", "taxAmt", "discAmt", "possesId", "kodePosses", "discExp", "userId", "cashierId", "bpId", "bpName", "termType", "isUploaded", "isVoid", "gopayUrl", "gopayTransactionId", "gopayPaymentStatus", "rounding", "channelId", "voidNote", "createdAt", "createdBy", "updatedAt", "updatedBy", "crcId", "(Ljava/lang/Integer;ILjava/lang/String;ZLjava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;ILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;ILjava/lang/String;Ljava/util/Date;ILjava/util/Date;ILjava/lang/Integer;)V", "getBpId", "()I", "setBpId", "(I)V", "getBpName", "()Ljava/lang/String;", "setBpName", "(Ljava/lang/String;)V", "getCashierId", "setCashierId", "getCashiername", "setCashiername", "getChannelId", "setChannelId", "getCrcId", "()Ljava/lang/Integer;", "setCrcId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "getCreatedBy", "setCreatedBy", "getDiscAmt", "()Ljava/math/BigDecimal;", "setDiscAmt", "(Ljava/math/BigDecimal;)V", "getDiscExp", "setDiscExp", "getGopayPaymentStatus", "setGopayPaymentStatus", "getGopayTransactionId", "setGopayTransactionId", "getGopayUrl", "setGopayUrl", "getId", "setId", "()Z", "setDraft", "(Z)V", "setUploaded", "setVoid", "getKodePosses", "setKodePosses", "getOprName", "setOprName", "getPossesId", "setPossesId", "getRounding", "setRounding", "getSubtotal", "setSubtotal", "getTaxAmt", "setTaxAmt", "getTermType", "setTermType", "getTotChange", "setTotChange", "getTotPaid", "setTotPaid", "getTotal", "setTotal", "getTrxDate", "setTrxDate", "getTrxNo", "setTrxNo", "getTrxOrderNum", "setTrxOrderNum", "getUpdatedAt", "setUpdatedAt", "getUpdatedBy", "setUpdatedBy", "getUserId", "setUserId", "getVoidNote", "setVoidNote", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;ILjava/lang/String;ZLjava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;ILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;ILjava/lang/String;Ljava/util/Date;ILjava/util/Date;ILjava/lang/Integer;)Lcom/bits/bee/bpmc/data/data_source/local/model/SaleEntity;", "equals", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class SaleEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private java.lang.Integer id;
    @androidx.room.ColumnInfo(name = "trx_ordernum")
    private int trxOrderNum;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "trx_no")
    private java.lang.String trxNo;
    @androidx.room.ColumnInfo(name = "draft")
    private boolean isDraft;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "subtotal")
    private java.math.BigDecimal subtotal;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "total")
    private java.math.BigDecimal total;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "opr_name")
    private java.lang.String oprName;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "cashier_name")
    private java.lang.String cashiername;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "trx_date")
    private java.util.Date trxDate;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "paidamt")
    private java.math.BigDecimal totPaid;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "changeamt")
    private java.math.BigDecimal totChange;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "taxamt")
    private java.math.BigDecimal taxAmt;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "discamt")
    private java.math.BigDecimal discAmt;
    @androidx.room.ColumnInfo(name = "posses_id", index = true)
    private int possesId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "kode_posses")
    private java.lang.String kodePosses;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "discexp")
    private java.lang.String discExp;
    @androidx.room.ColumnInfo(name = "user_id", index = true)
    private int userId;
    @androidx.room.ColumnInfo(name = "cashier_id", index = true)
    private int cashierId;
    @androidx.room.ColumnInfo(name = "bp_id", index = true)
    private int bpId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "bp_name")
    private java.lang.String bpName;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "termtype")
    private java.lang.String termType;
    @androidx.room.ColumnInfo(name = "isuploaded")
    private boolean isUploaded;
    @androidx.room.ColumnInfo(name = "isvoid")
    private boolean isVoid;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "url_qrcode")
    private java.lang.String gopayUrl;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "transaction_id")
    private java.lang.String gopayTransactionId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "gopay_paymentstatus")
    private java.lang.String gopayPaymentStatus;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "rounding")
    private java.math.BigDecimal rounding;
    @androidx.room.ColumnInfo(name = "channel_id", index = true)
    private int channelId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "void_note")
    private java.lang.String voidNote;
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
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "crc_id", index = true)
    private java.lang.Integer crcId;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.SaleEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "sale";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TRXORDERNUM = "trx_ordernum";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TRXNO = "trx_no";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DRAFT = "draft";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPRNAME = "opr_name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CASHIERNAME = "cashier_name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TRXDATE = "trx_date";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SUBTOTAL = "subtotal";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOTAL = "total";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOTPAID = "paidamt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOTCHANGE = "changeamt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAXAMT = "taxamt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DISCAMT = "discamt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DISCEXP = "discexp";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String POSSES_ID = "posses_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String POS_KODE = "kode_posses";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String USER_ID = "user_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CASHIER_ID = "cashier_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BP_ID = "bp_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BP_NAME = "bp_name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TERMTYPE = "termtype";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ISUPLOAD = "isuploaded";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ISVOID = "isvoid";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GOPAY_URL = "url_qrcode";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GOPAY_TRANSACTIONID = "transaction_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GOPAY_PAYMENTSTATUS = "gopay_paymentstatus";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ROUNDING = "rounding";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID = "channel_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VOID_NOTE = "void_note";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CREATED_AT = "created_at";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CREATED_BY = "created_by";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UPDATED_AT = "updated_at";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UPDATED_BY = "updated_by";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CRC_ID = "crc_id";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.SaleEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, int trxOrderNum, @org.jetbrains.annotations.NotNull()
    java.lang.String trxNo, boolean isDraft, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal subtotal, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal total, @org.jetbrains.annotations.NotNull()
    java.lang.String oprName, @org.jetbrains.annotations.NotNull()
    java.lang.String cashiername, @org.jetbrains.annotations.NotNull()
    java.util.Date trxDate, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totPaid, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totChange, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal taxAmt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal discAmt, int possesId, @org.jetbrains.annotations.NotNull()
    java.lang.String kodePosses, @org.jetbrains.annotations.NotNull()
    java.lang.String discExp, int userId, int cashierId, int bpId, @org.jetbrains.annotations.NotNull()
    java.lang.String bpName, @org.jetbrains.annotations.NotNull()
    java.lang.String termType, boolean isUploaded, boolean isVoid, @org.jetbrains.annotations.NotNull()
    java.lang.String gopayUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String gopayTransactionId, @org.jetbrains.annotations.NotNull()
    java.lang.String gopayPaymentStatus, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal rounding, int channelId, @org.jetbrains.annotations.NotNull()
    java.lang.String voidNote, @org.jetbrains.annotations.NotNull()
    java.util.Date createdAt, int createdBy, @org.jetbrains.annotations.NotNull()
    java.util.Date updatedAt, int updatedBy, @org.jetbrains.annotations.Nullable()
    java.lang.Integer crcId) {
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
    
    public SaleEntity() {
        super();
    }
    
    public SaleEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, int trxOrderNum, @org.jetbrains.annotations.NotNull()
    java.lang.String trxNo, boolean isDraft, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal subtotal, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal total, @org.jetbrains.annotations.NotNull()
    java.lang.String oprName, @org.jetbrains.annotations.NotNull()
    java.lang.String cashiername, @org.jetbrains.annotations.NotNull()
    java.util.Date trxDate, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totPaid, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totChange, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal taxAmt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal discAmt, int possesId, @org.jetbrains.annotations.NotNull()
    java.lang.String kodePosses, @org.jetbrains.annotations.NotNull()
    java.lang.String discExp, int userId, int cashierId, int bpId, @org.jetbrains.annotations.NotNull()
    java.lang.String bpName, @org.jetbrains.annotations.NotNull()
    java.lang.String termType, boolean isUploaded, boolean isVoid, @org.jetbrains.annotations.NotNull()
    java.lang.String gopayUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String gopayTransactionId, @org.jetbrains.annotations.NotNull()
    java.lang.String gopayPaymentStatus, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal rounding, int channelId, @org.jetbrains.annotations.NotNull()
    java.lang.String voidNote, @org.jetbrains.annotations.NotNull()
    java.util.Date createdAt, int createdBy, @org.jetbrains.annotations.NotNull()
    java.util.Date updatedAt, int updatedBy, @org.jetbrains.annotations.Nullable()
    java.lang.Integer crcId) {
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
    
    public final int getTrxOrderNum() {
        return 0;
    }
    
    public final void setTrxOrderNum(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTrxNo() {
        return null;
    }
    
    public final void setTrxNo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean isDraft() {
        return false;
    }
    
    public final void setDraft(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getSubtotal() {
        return null;
    }
    
    public final void setSubtotal(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component6() {
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
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOprName() {
        return null;
    }
    
    public final void setOprName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCashiername() {
        return null;
    }
    
    public final void setCashiername(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component9() {
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
    public final java.math.BigDecimal component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotPaid() {
        return null;
    }
    
    public final void setTotPaid(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotChange() {
        return null;
    }
    
    public final void setTotChange(@org.jetbrains.annotations.NotNull()
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
    public final java.math.BigDecimal getDiscAmt() {
        return null;
    }
    
    public final void setDiscAmt(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    public final int component14() {
        return 0;
    }
    
    public final int getPossesId() {
        return 0;
    }
    
    public final void setPossesId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKodePosses() {
        return null;
    }
    
    public final void setKodePosses(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDiscExp() {
        return null;
    }
    
    public final void setDiscExp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component17() {
        return 0;
    }
    
    public final int getUserId() {
        return 0;
    }
    
    public final void setUserId(int p0) {
    }
    
    public final int component18() {
        return 0;
    }
    
    public final int getCashierId() {
        return 0;
    }
    
    public final void setCashierId(int p0) {
    }
    
    public final int component19() {
        return 0;
    }
    
    public final int getBpId() {
        return 0;
    }
    
    public final void setBpId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBpName() {
        return null;
    }
    
    public final void setBpName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTermType() {
        return null;
    }
    
    public final void setTermType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component22() {
        return false;
    }
    
    public final boolean isUploaded() {
        return false;
    }
    
    public final void setUploaded(boolean p0) {
    }
    
    public final boolean component23() {
        return false;
    }
    
    public final boolean isVoid() {
        return false;
    }
    
    public final void setVoid(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGopayUrl() {
        return null;
    }
    
    public final void setGopayUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGopayTransactionId() {
        return null;
    }
    
    public final void setGopayTransactionId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGopayPaymentStatus() {
        return null;
    }
    
    public final void setGopayPaymentStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component27() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getRounding() {
        return null;
    }
    
    public final void setRounding(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    public final int component28() {
        return 0;
    }
    
    public final int getChannelId() {
        return 0;
    }
    
    public final void setChannelId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVoidNote() {
        return null;
    }
    
    public final void setVoidNote(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component30() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
    }
    
    public final int component31() {
        return 0;
    }
    
    public final int getCreatedBy() {
        return 0;
    }
    
    public final void setCreatedBy(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component32() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getUpdatedAt() {
        return null;
    }
    
    public final void setUpdatedAt(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
    }
    
    public final int component33() {
        return 0;
    }
    
    public final int getUpdatedBy() {
        return 0;
    }
    
    public final void setUpdatedBy(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component34() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCrcId() {
        return null;
    }
    
    public final void setCrcId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/SaleEntity$Companion;", "", "()V", "BP_ID", "", "BP_NAME", "CASHIERNAME", "CASHIER_ID", "CHANNEL_ID", "CRC_ID", "CREATED_AT", "CREATED_BY", "DISCAMT", "DISCEXP", "DRAFT", "GOPAY_PAYMENTSTATUS", "GOPAY_TRANSACTIONID", "GOPAY_URL", "ID", "ISUPLOAD", "ISVOID", "OPRNAME", "POSSES_ID", "POS_KODE", "ROUNDING", "SUBTOTAL", "TAXAMT", "TBL_NAME", "TERMTYPE", "TOTAL", "TOTCHANGE", "TOTPAID", "TRXDATE", "TRXNO", "TRXORDERNUM", "UPDATED_AT", "UPDATED_BY", "USER_ID", "VOID_NOTE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}