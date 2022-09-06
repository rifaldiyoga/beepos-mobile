package com.bits.bee.bpmc.domain.model;

import java.lang.System;

/**
 * Created by aldi on 12/05/22.
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bj\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00b7\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030$\u00a2\u0006\u0002\u0010\'J\t\u0010l\u001a\u00020\u0003H\u00c6\u0003J\t\u0010m\u001a\u00020\nH\u00c6\u0003J\t\u0010n\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010p\u001a\u00020\nH\u00c6\u0003J\u0010\u0010q\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010-J\u0010\u0010r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010-J\t\u0010s\u001a\u00020\u0015H\u00c6\u0003J\t\u0010t\u001a\u00020\nH\u00c6\u0003J\t\u0010u\u001a\u00020\u0005H\u00c6\u0003J\t\u0010v\u001a\u00020\nH\u00c6\u0003J\t\u0010w\u001a\u00020\u0005H\u00c6\u0003J\t\u0010x\u001a\u00020\nH\u00c6\u0003J\t\u0010y\u001a\u00020\nH\u00c6\u0003J\t\u0010z\u001a\u00020\nH\u00c6\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010}\u001a\u00020\u0015H\u00c6\u0003J\t\u0010~\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u007f\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020%0$H\u00c6\u0003J\u0010\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030$H\u00c6\u0003J\u0011\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010-J\n\u0010\u0086\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u0088\u0001\u001a\u00020\nH\u00c6\u0003J\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010-J\n\u0010\u008a\u0001\u001a\u00020\nH\u00c6\u0003J\u00e0\u0002\u0010\u008b\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00152\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00052\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030$H\u00c6\u0001\u00a2\u0006\u0003\u0010\u008c\u0001J\n\u0010\u008d\u0001\u001a\u00020\u0003H\u00d6\u0001J\u0016\u0010\u008e\u0001\u001a\u00020\n2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001H\u00d6\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0003H\u00d6\u0001J\n\u0010\u0092\u0001\u001a\u00020\u0005H\u00d6\u0001J\u001e\u0010\u0093\u0001\u001a\u00030\u0094\u00012\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0011\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010!\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u00102\"\u0004\b:\u00104R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\u001a\u0010\u001a\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010)\"\u0004\b=\u0010+R\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010)\"\u0004\b>\u0010+R\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010)\"\u0004\b?\u0010+R\u001a\u0010\u0016\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010)\"\u0004\b@\u0010+R\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010)\"\u0004\bA\u0010+R\u001a\u0010\r\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010)\"\u0004\bB\u0010+R\u001a\u0010\u0019\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010)\"\u0004\bC\u0010+R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00100\u001a\u0004\bD\u0010-\"\u0004\bE\u0010/R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u00102\"\u0004\bG\u00104R \u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u00102\"\u0004\bM\u00104R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u00102\"\u0004\bO\u00104R\u001a\u0010\u001e\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010Q\"\u0004\bU\u0010SR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00100\u001a\u0004\bV\u0010-\"\u0004\bW\u0010/R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00100\u001a\u0004\bX\u0010-\"\u0004\bY\u0010/R\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u00102\"\u0004\b[\u00104R\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u00102\"\u0004\b]\u00104R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u00102\"\u0004\b_\u00104R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010)\"\u0004\ba\u0010+R \u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u0010I\"\u0004\bc\u0010KR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u00102\"\u0004\be\u00104R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010)\"\u0004\bg\u0010+R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u00102\"\u0004\bi\u00104R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u00102\"\u0004\bk\u00104\u00a8\u0006\u0098\u0001"}, d2 = {"Lcom/bits/bee/bpmc/domain/model/Item;", "Landroid/os/Parcelable;", "id", "", "code", "", "name1", "brandId", "itemTypeCode", "usePid", "", "uniqueid", "itemGrpId", "isStock", "isSale", "unitdesc", "note", "active", "saleUnit", "stockUnit", "qty", "Ljava/math/BigDecimal;", "isPos", "type", "isAvailable", "isVariant", "isAddOn", "isHaveAddOn", "vCode", "vColor", "price", "tax", "taxCode", "crcId", "crcSymbol", "unitList", "", "Lcom/bits/bee/bpmc/domain/model/Unit;", "itemVariantList", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZZLjava/lang/Integer;ZZLjava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/math/BigDecimal;ZLjava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getActive", "()Z", "setActive", "(Z)V", "getBrandId", "()Ljava/lang/Integer;", "setBrandId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getCrcId", "()I", "setCrcId", "(I)V", "getCrcSymbol", "setCrcSymbol", "getId", "setId", "setAddOn", "setAvailable", "setHaveAddOn", "setPos", "setSale", "setStock", "setVariant", "getItemGrpId", "setItemGrpId", "getItemTypeCode", "setItemTypeCode", "getItemVariantList", "()Ljava/util/List;", "setItemVariantList", "(Ljava/util/List;)V", "getName1", "setName1", "getNote", "setNote", "getPrice", "()Ljava/math/BigDecimal;", "setPrice", "(Ljava/math/BigDecimal;)V", "getQty", "setQty", "getSaleUnit", "setSaleUnit", "getStockUnit", "setStockUnit", "getTax", "setTax", "getTaxCode", "setTaxCode", "getType", "setType", "getUniqueid", "setUniqueid", "getUnitList", "setUnitList", "getUnitdesc", "setUnitdesc", "getUsePid", "setUsePid", "getVCode", "setVCode", "getVColor", "setVColor", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZZLjava/lang/Integer;ZZLjava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/math/BigDecimal;ZLjava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/bits/bee/bpmc/domain/model/Item;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Item implements android.os.Parcelable {
    private int id;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String code;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name1;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer brandId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String itemTypeCode;
    private boolean usePid;
    private boolean uniqueid;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer itemGrpId;
    private boolean isStock;
    private boolean isSale;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String unitdesc;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String note;
    private boolean active;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer saleUnit;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer stockUnit;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal qty;
    private boolean isPos;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String type;
    private boolean isAvailable;
    private boolean isVariant;
    private boolean isAddOn;
    private boolean isHaveAddOn;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String vCode;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String vColor;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal price;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String tax;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String taxCode;
    private int crcId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String crcSymbol;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.bits.bee.bpmc.domain.model.Unit> unitList;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.Integer> itemVariantList;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.Item> CREATOR = null;
    
    /**
     * Created by aldi on 12/05/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.model.Item copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String name1, @org.jetbrains.annotations.Nullable()
    java.lang.Integer brandId, @org.jetbrains.annotations.NotNull()
    java.lang.String itemTypeCode, boolean usePid, boolean uniqueid, @org.jetbrains.annotations.Nullable()
    java.lang.Integer itemGrpId, boolean isStock, boolean isSale, @org.jetbrains.annotations.NotNull()
    java.lang.String unitdesc, @org.jetbrains.annotations.Nullable()
    java.lang.String note, boolean active, @org.jetbrains.annotations.Nullable()
    java.lang.Integer saleUnit, @org.jetbrains.annotations.Nullable()
    java.lang.Integer stockUnit, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal qty, boolean isPos, @org.jetbrains.annotations.NotNull()
    java.lang.String type, boolean isAvailable, boolean isVariant, boolean isAddOn, boolean isHaveAddOn, @org.jetbrains.annotations.Nullable()
    java.lang.String vCode, @org.jetbrains.annotations.Nullable()
    java.lang.String vColor, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal price, @org.jetbrains.annotations.NotNull()
    java.lang.String tax, @org.jetbrains.annotations.NotNull()
    java.lang.String taxCode, int crcId, @org.jetbrains.annotations.NotNull()
    java.lang.String crcSymbol, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Unit> unitList, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> itemVariantList) {
        return null;
    }
    
    /**
     * Created by aldi on 12/05/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 12/05/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 12/05/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Item(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String name1, @org.jetbrains.annotations.Nullable()
    java.lang.Integer brandId, @org.jetbrains.annotations.NotNull()
    java.lang.String itemTypeCode, boolean usePid, boolean uniqueid, @org.jetbrains.annotations.Nullable()
    java.lang.Integer itemGrpId, boolean isStock, boolean isSale, @org.jetbrains.annotations.NotNull()
    java.lang.String unitdesc, @org.jetbrains.annotations.Nullable()
    java.lang.String note, boolean active, @org.jetbrains.annotations.Nullable()
    java.lang.Integer saleUnit, @org.jetbrains.annotations.Nullable()
    java.lang.Integer stockUnit, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal qty, boolean isPos, @org.jetbrains.annotations.NotNull()
    java.lang.String type, boolean isAvailable, boolean isVariant, boolean isAddOn, boolean isHaveAddOn, @org.jetbrains.annotations.Nullable()
    java.lang.String vCode, @org.jetbrains.annotations.Nullable()
    java.lang.String vColor, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal price, @org.jetbrains.annotations.NotNull()
    java.lang.String tax, @org.jetbrains.annotations.NotNull()
    java.lang.String taxCode, int crcId, @org.jetbrains.annotations.NotNull()
    java.lang.String crcSymbol, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Unit> unitList, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> itemVariantList) {
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
    public final java.lang.String getCode() {
        return null;
    }
    
    public final void setCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName1() {
        return null;
    }
    
    public final void setName1(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getBrandId() {
        return null;
    }
    
    public final void setBrandId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getItemTypeCode() {
        return null;
    }
    
    public final void setItemTypeCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getUsePid() {
        return false;
    }
    
    public final void setUsePid(boolean p0) {
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean getUniqueid() {
        return false;
    }
    
    public final void setUniqueid(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getItemGrpId() {
        return null;
    }
    
    public final void setItemGrpId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean isStock() {
        return false;
    }
    
    public final void setStock(boolean p0) {
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean isSale() {
        return false;
    }
    
    public final void setSale(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUnitdesc() {
        return null;
    }
    
    public final void setUnitdesc(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNote() {
        return null;
    }
    
    public final void setNote(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final boolean getActive() {
        return false;
    }
    
    public final void setActive(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSaleUnit() {
        return null;
    }
    
    public final void setSaleUnit(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getStockUnit() {
        return null;
    }
    
    public final void setStockUnit(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getQty() {
        return null;
    }
    
    public final void setQty(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    public final boolean component17() {
        return false;
    }
    
    public final boolean isPos() {
        return false;
    }
    
    public final void setPos(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component19() {
        return false;
    }
    
    public final boolean isAvailable() {
        return false;
    }
    
    public final void setAvailable(boolean p0) {
    }
    
    public final boolean component20() {
        return false;
    }
    
    public final boolean isVariant() {
        return false;
    }
    
    public final void setVariant(boolean p0) {
    }
    
    public final boolean component21() {
        return false;
    }
    
    public final boolean isAddOn() {
        return false;
    }
    
    public final void setAddOn(boolean p0) {
    }
    
    public final boolean component22() {
        return false;
    }
    
    public final boolean isHaveAddOn() {
        return false;
    }
    
    public final void setHaveAddOn(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getVCode() {
        return null;
    }
    
    public final void setVCode(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getVColor() {
        return null;
    }
    
    public final void setVColor(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getPrice() {
        return null;
    }
    
    public final void setPrice(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTax() {
        return null;
    }
    
    public final void setTax(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component27() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTaxCode() {
        return null;
    }
    
    public final void setTaxCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component28() {
        return 0;
    }
    
    public final int getCrcId() {
        return 0;
    }
    
    public final void setCrcId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCrcSymbol() {
        return null;
    }
    
    public final void setCrcSymbol(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Unit> component30() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Unit> getUnitList() {
        return null;
    }
    
    public final void setUnitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> component31() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getItemVariantList() {
        return null;
    }
    
    public final void setItemVariantList(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.Item> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.Item createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.Item[] newArray(int size) {
            return null;
        }
    }
}