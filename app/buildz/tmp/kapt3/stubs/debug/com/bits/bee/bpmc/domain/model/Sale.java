package com.bits.bee.bpmc.domain.model;

import java.lang.System;

/**
 * Created by aldi on 20/05/22.
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0003\b\u0093\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00e7\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006\u0012\b\b\u0002\u0010!\u001a\u00020\n\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0006\u0012\b\b\u0002\u0010$\u001a\u00020\u000f\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\u000f\u0012\b\b\u0002\u0010\'\u001a\u00020\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010)\u001a\u00020\u0006\u00a2\u0006\u0002\u0010*J\u0010\u0010{\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00108J\t\u0010|\u001a\u00020\nH\u00c6\u0003J\t\u0010}\u001a\u00020\nH\u00c6\u0003J\t\u0010~\u001a\u00020\nH\u00c6\u0003J\t\u0010\u007f\u001a\u00020\nH\u00c6\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0089\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u008a\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u008e\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020\u000fH\u00c6\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0094\u0001\u001a\u00020\u000fH\u00c6\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00108J\n\u0010\u0097\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0098\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u0099\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u009a\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u009d\u0001\u001a\u00020\u000fH\u00c6\u0003J\u00f2\u0002\u0010\u009e\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010\'\u001a\u00020\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010)\u001a\u00020\u0006H\u00c6\u0001\u00a2\u0006\u0003\u0010\u009f\u0001J\n\u0010\u00a0\u0001\u001a\u00020\u0003H\u00d6\u0001J\u0016\u0010\u00a1\u0001\u001a\u00020\b2\n\u0010\u00a2\u0001\u001a\u0005\u0018\u00010\u00a3\u0001H\u00d6\u0003J\n\u0010\u00a4\u0001\u001a\u00020\u0003H\u00d6\u0001J\n\u0010\u00a5\u0001\u001a\u00020\u0006H\u00d6\u0001J\u001e\u0010\u00a6\u0001\u001a\u00030\u00a7\u00012\b\u0010\u00a8\u0001\u001a\u00030\u00a9\u00012\u0007\u0010\u00aa\u0001\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\"\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010,\"\u0004\b6\u0010.R\u001e\u0010(\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010)\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u00102\"\u0004\b=\u00104R\u001a\u0010$\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010%\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010,\"\u0004\bC\u0010.R\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u00102\"\u0004\bE\u00104R\u001a\u0010\u0013\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010\u0016\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u00102\"\u0004\bK\u00104R\u001a\u0010 \u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u00102\"\u0004\bM\u00104R\u001a\u0010\u001f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u00102\"\u0004\bO\u00104R\u001a\u0010\u001e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u00102\"\u0004\bQ\u00104R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010;\u001a\u0004\bR\u00108\"\u0004\bS\u0010:R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010T\"\u0004\bU\u0010VR\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010T\"\u0004\bW\u0010VR\u001a\u0010\u001d\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010T\"\u0004\bX\u0010VR\u001a\u0010\u0015\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u00102\"\u0004\bZ\u00104R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010,\"\u0004\b\\\u0010.R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010,\"\u0004\b^\u0010.R\u001a\u0010!\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010G\"\u0004\b`\u0010IR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010G\"\u0004\bb\u0010IR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010G\"\u0004\bd\u0010IR\u001a\u0010\u001b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u00102\"\u0004\bf\u00104R\u001a\u0010\u0011\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010G\"\u0004\bh\u0010IR\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010G\"\u0004\bj\u0010IR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010G\"\u0004\bl\u0010IR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010?\"\u0004\bn\u0010AR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u00102\"\u0004\bp\u00104R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010,\"\u0004\br\u0010.R\u001a\u0010&\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bs\u0010?\"\u0004\bt\u0010AR\u001a\u0010\'\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u0010,\"\u0004\bv\u0010.R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u00102\"\u0004\bx\u00104R\u001a\u0010#\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u00102\"\u0004\bz\u00104\u00a8\u0006\u00ab\u0001"}, d2 = {"Lcom/bits/bee/bpmc/domain/model/Sale;", "Landroid/os/Parcelable;", "id", "", "trxOrderNum", "trxNo", "", "isDraft", "", "subtotal", "Ljava/math/BigDecimal;", "total", "userName", "cashiername", "trxDate", "Ljava/util/Date;", "totPaid", "totChange", "taxAmt", "discAmt", "possesId", "kodePosses", "discExp", "operatorId", "cashierId", "bpId", "custName", "termType", "isUploaded", "isVoid", "gopayUrl", "gopayTransactionId", "gopayPaymentStatus", "rounding", "channelId", "voidNote", "createdAt", "createdBy", "updatedAt", "updatedBy", "crcId", "crcSymbol", "(Ljava/lang/Integer;ILjava/lang/String;ZLjava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;ILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;ILjava/lang/String;Ljava/util/Date;ILjava/util/Date;ILjava/lang/Integer;Ljava/lang/String;)V", "getBpId", "()I", "setBpId", "(I)V", "getCashierId", "setCashierId", "getCashiername", "()Ljava/lang/String;", "setCashiername", "(Ljava/lang/String;)V", "getChannelId", "setChannelId", "getCrcId", "()Ljava/lang/Integer;", "setCrcId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCrcSymbol", "setCrcSymbol", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "getCreatedBy", "setCreatedBy", "getCustName", "setCustName", "getDiscAmt", "()Ljava/math/BigDecimal;", "setDiscAmt", "(Ljava/math/BigDecimal;)V", "getDiscExp", "setDiscExp", "getGopayPaymentStatus", "setGopayPaymentStatus", "getGopayTransactionId", "setGopayTransactionId", "getGopayUrl", "setGopayUrl", "getId", "setId", "()Z", "setDraft", "(Z)V", "setUploaded", "setVoid", "getKodePosses", "setKodePosses", "getOperatorId", "setOperatorId", "getPossesId", "setPossesId", "getRounding", "setRounding", "getSubtotal", "setSubtotal", "getTaxAmt", "setTaxAmt", "getTermType", "setTermType", "getTotChange", "setTotChange", "getTotPaid", "setTotPaid", "getTotal", "setTotal", "getTrxDate", "setTrxDate", "getTrxNo", "setTrxNo", "getTrxOrderNum", "setTrxOrderNum", "getUpdatedAt", "setUpdatedAt", "getUpdatedBy", "setUpdatedBy", "getUserName", "setUserName", "getVoidNote", "setVoidNote", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;ILjava/lang/String;ZLjava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;ILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;ILjava/lang/String;Ljava/util/Date;ILjava/util/Date;ILjava/lang/Integer;Ljava/lang/String;)Lcom/bits/bee/bpmc/domain/model/Sale;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Sale implements android.os.Parcelable {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer id;
    private int trxOrderNum;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String trxNo;
    private boolean isDraft;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal subtotal;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal total;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String userName;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String cashiername;
    @org.jetbrains.annotations.NotNull()
    private java.util.Date trxDate;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal totPaid;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal totChange;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal taxAmt;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal discAmt;
    private int possesId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String kodePosses;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String discExp;
    private int operatorId;
    private int cashierId;
    private int bpId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String custName;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String termType;
    private boolean isUploaded;
    private boolean isVoid;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String gopayUrl;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String gopayTransactionId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String gopayPaymentStatus;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal rounding;
    private int channelId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String voidNote;
    @org.jetbrains.annotations.NotNull()
    private java.util.Date createdAt;
    private int createdBy;
    @org.jetbrains.annotations.NotNull()
    private java.util.Date updatedAt;
    private int updatedBy;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer crcId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String crcSymbol;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.Sale> CREATOR = null;
    
    /**
     * Created by aldi on 20/05/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.model.Sale copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, int trxOrderNum, @org.jetbrains.annotations.NotNull()
    java.lang.String trxNo, boolean isDraft, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal subtotal, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal total, @org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String cashiername, @org.jetbrains.annotations.NotNull()
    java.util.Date trxDate, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totPaid, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totChange, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal taxAmt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal discAmt, int possesId, @org.jetbrains.annotations.NotNull()
    java.lang.String kodePosses, @org.jetbrains.annotations.NotNull()
    java.lang.String discExp, int operatorId, int cashierId, int bpId, @org.jetbrains.annotations.NotNull()
    java.lang.String custName, @org.jetbrains.annotations.NotNull()
    java.lang.String termType, boolean isUploaded, boolean isVoid, @org.jetbrains.annotations.NotNull()
    java.lang.String gopayUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String gopayTransactionId, @org.jetbrains.annotations.NotNull()
    java.lang.String gopayPaymentStatus, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal rounding, int channelId, @org.jetbrains.annotations.NotNull()
    java.lang.String voidNote, @org.jetbrains.annotations.NotNull()
    java.util.Date createdAt, int createdBy, @org.jetbrains.annotations.NotNull()
    java.util.Date updatedAt, int updatedBy, @org.jetbrains.annotations.Nullable()
    java.lang.Integer crcId, @org.jetbrains.annotations.NotNull()
    java.lang.String crcSymbol) {
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
    
    public Sale() {
        super();
    }
    
    public Sale(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, int trxOrderNum, @org.jetbrains.annotations.NotNull()
    java.lang.String trxNo, boolean isDraft, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal subtotal, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal total, @org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String cashiername, @org.jetbrains.annotations.NotNull()
    java.util.Date trxDate, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totPaid, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totChange, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal taxAmt, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal discAmt, int possesId, @org.jetbrains.annotations.NotNull()
    java.lang.String kodePosses, @org.jetbrains.annotations.NotNull()
    java.lang.String discExp, int operatorId, int cashierId, int bpId, @org.jetbrains.annotations.NotNull()
    java.lang.String custName, @org.jetbrains.annotations.NotNull()
    java.lang.String termType, boolean isUploaded, boolean isVoid, @org.jetbrains.annotations.NotNull()
    java.lang.String gopayUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String gopayTransactionId, @org.jetbrains.annotations.NotNull()
    java.lang.String gopayPaymentStatus, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal rounding, int channelId, @org.jetbrains.annotations.NotNull()
    java.lang.String voidNote, @org.jetbrains.annotations.NotNull()
    java.util.Date createdAt, int createdBy, @org.jetbrains.annotations.NotNull()
    java.util.Date updatedAt, int updatedBy, @org.jetbrains.annotations.Nullable()
    java.lang.Integer crcId, @org.jetbrains.annotations.NotNull()
    java.lang.String crcSymbol) {
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
    public final java.lang.String getUserName() {
        return null;
    }
    
    public final void setUserName(@org.jetbrains.annotations.NotNull()
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
    
    public final int getOperatorId() {
        return 0;
    }
    
    public final void setOperatorId(int p0) {
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
    public final java.lang.String getCustName() {
        return null;
    }
    
    public final void setCustName(@org.jetbrains.annotations.NotNull()
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component35() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCrcSymbol() {
        return null;
    }
    
    public final void setCrcSymbol(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.Sale> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.Sale createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.Sale[] newArray(int size) {
            return null;
        }
    }
}