package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "item")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bZ\b\u0087\b\u0018\u0000 n2\u00020\u0001:\u0001nB\u00db\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001dJ\t\u0010Q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010R\u001a\u00020\nH\u00c6\u0003J\t\u0010S\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010U\u001a\u00020\nH\u00c6\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010W\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010#J\t\u0010X\u001a\u00020\u0015H\u00c6\u0003J\t\u0010Y\u001a\u00020\nH\u00c6\u0003J\t\u0010Z\u001a\u00020\u0005H\u00c6\u0003J\t\u0010[\u001a\u00020\nH\u00c6\u0003J\t\u0010\\\u001a\u00020\u0005H\u00c6\u0003J\t\u0010]\u001a\u00020\nH\u00c6\u0003J\t\u0010^\u001a\u00020\nH\u00c6\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010a\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010#J\t\u0010c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010d\u001a\u00020\nH\u00c6\u0003J\t\u0010e\u001a\u00020\nH\u00c6\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010#J\t\u0010g\u001a\u00020\nH\u00c6\u0003J\u0082\u0002\u0010h\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010iJ\u0013\u0010j\u001a\u00020\n2\b\u0010k\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010l\u001a\u00020\u0003H\u00d6\u0001J\t\u0010m\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001f\"\u0004\b/\u0010!R\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001f\"\u0004\b0\u0010!R\u001e\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u001f\"\u0004\b1\u0010!R\u001e\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u001f\"\u0004\b2\u0010!R\u001e\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u001f\"\u0004\b3\u0010!R\u001e\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001f\"\u0004\b4\u0010!R\"\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b5\u0010#\"\u0004\b6\u0010%R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010(\"\u0004\b8\u0010*R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010(\"\u0004\b:\u0010*R \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010(\"\u0004\b<\u0010*R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\bA\u0010#\"\u0004\bB\u0010%R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\bC\u0010#\"\u0004\bD\u0010%R\u001e\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010(\"\u0004\bF\u0010*R\u001e\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001f\"\u0004\bH\u0010!R\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010(\"\u0004\bJ\u0010*R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u001f\"\u0004\bL\u0010!R \u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010(\"\u0004\bN\u0010*R \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010(\"\u0004\bP\u0010*\u00a8\u0006o"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/ItemEntity;", "", "id", "", "code", "", "name1", "brandId", "itemTypeCode", "usePid", "", "uniquePid", "itemGrpId", "isStock", "isSale", "unitdesc", "note", "active", "saleUnit", "stockUnit", "qty", "Ljava/math/BigDecimal;", "isPos", "type", "isFavorit", "isAvailable", "isVariant", "vCode", "vColor", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZZLjava/lang/Integer;ZZLjava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/math/BigDecimal;ZLjava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;)V", "getActive", "()Z", "setActive", "(Z)V", "getBrandId", "()Ljava/lang/Integer;", "setBrandId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "setAvailable", "setFavorit", "setPos", "setSale", "setStock", "setVariant", "getItemGrpId", "setItemGrpId", "getItemTypeCode", "setItemTypeCode", "getName1", "setName1", "getNote", "setNote", "getQty", "()Ljava/math/BigDecimal;", "setQty", "(Ljava/math/BigDecimal;)V", "getSaleUnit", "setSaleUnit", "getStockUnit", "setStockUnit", "getType", "setType", "getUniquePid", "setUniquePid", "getUnitdesc", "setUnitdesc", "getUsePid", "setUsePid", "getVCode", "setVCode", "getVColor", "setVColor", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZZLjava/lang/Integer;ZZLjava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/math/BigDecimal;ZLjava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;)Lcom/bits/bee/bpmc/data/data_source/local/model/ItemEntity;", "equals", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class ItemEntity {
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = false)
    private int id;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "code")
    private java.lang.String code;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "name1")
    private java.lang.String name1;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "brand_id")
    private java.lang.Integer brandId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "itemtype_code")
    private java.lang.String itemTypeCode;
    @androidx.room.ColumnInfo(name = "usepid")
    private boolean usePid;
    @androidx.room.ColumnInfo(name = "uniquepid")
    private boolean uniquePid;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "itemgrp1_id")
    private java.lang.Integer itemGrpId;
    @androidx.room.ColumnInfo(name = "isstock")
    private boolean isStock;
    @androidx.room.ColumnInfo(name = "issale")
    private boolean isSale;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "unitdesc")
    private java.lang.String unitdesc;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "note")
    private java.lang.String note;
    @androidx.room.ColumnInfo(name = "active")
    private boolean active;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "saleunit")
    private java.lang.Integer saleUnit;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "stockunit")
    private java.lang.Integer stockUnit;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "itemqty")
    private java.math.BigDecimal qty;
    @androidx.room.ColumnInfo(name = "ispos")
    private boolean isPos;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "type")
    private java.lang.String type;
    @androidx.room.ColumnInfo(name = "favorit")
    private boolean isFavorit;
    @androidx.room.ColumnInfo(name = "is_available")
    private boolean isAvailable;
    @androidx.room.ColumnInfo(name = "is_variant")
    private boolean isVariant;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "vcode")
    private java.lang.String vCode;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "vcolor")
    private java.lang.String vColor;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.ItemEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "item";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CODE = "code";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NAME1 = "name1";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BRAND_ID = "brand_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ITEMTYPE_CODE = "itemtype_code";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UNIQUEPID = "uniquepid";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ITEMGRP_ID = "itemgrp1_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ISSTOCK = "isstock";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ISSALE = "issale";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UNITDESC = "unitdesc";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTE = "note";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ITGRP_ID = "itemgrp1_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LASTSYNC = "last_sync";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUCKET = "bucket";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OBJKEY = "objkey";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TEMPURL = "temp_url";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SALEUNIT = "saleunit";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STOCKUNIT = "stockunit";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVE = "active";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ITEMQTY = "itemqty";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ISPOS = "ispos";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FAVORIT = "favorit";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TYPE = "type";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VARIANT = "is_variant";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AVAILABLE = "is_available";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String USEPID = "usepid";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VCODE = "vcode";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VCOLOR = "vcolor";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.ItemEntity copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String name1, @org.jetbrains.annotations.Nullable()
    java.lang.Integer brandId, @org.jetbrains.annotations.NotNull()
    java.lang.String itemTypeCode, boolean usePid, boolean uniquePid, @org.jetbrains.annotations.Nullable()
    java.lang.Integer itemGrpId, boolean isStock, boolean isSale, @org.jetbrains.annotations.NotNull()
    java.lang.String unitdesc, @org.jetbrains.annotations.Nullable()
    java.lang.String note, boolean active, @org.jetbrains.annotations.Nullable()
    java.lang.Integer saleUnit, @org.jetbrains.annotations.Nullable()
    java.lang.Integer stockUnit, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal qty, boolean isPos, @org.jetbrains.annotations.NotNull()
    java.lang.String type, boolean isFavorit, boolean isAvailable, boolean isVariant, @org.jetbrains.annotations.Nullable()
    java.lang.String vCode, @org.jetbrains.annotations.Nullable()
    java.lang.String vColor) {
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
    
    public ItemEntity(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String name1, @org.jetbrains.annotations.Nullable()
    java.lang.Integer brandId, @org.jetbrains.annotations.NotNull()
    java.lang.String itemTypeCode, boolean usePid, boolean uniquePid, @org.jetbrains.annotations.Nullable()
    java.lang.Integer itemGrpId, boolean isStock, boolean isSale, @org.jetbrains.annotations.NotNull()
    java.lang.String unitdesc, @org.jetbrains.annotations.Nullable()
    java.lang.String note, boolean active, @org.jetbrains.annotations.Nullable()
    java.lang.Integer saleUnit, @org.jetbrains.annotations.Nullable()
    java.lang.Integer stockUnit, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal qty, boolean isPos, @org.jetbrains.annotations.NotNull()
    java.lang.String type, boolean isFavorit, boolean isAvailable, boolean isVariant, @org.jetbrains.annotations.Nullable()
    java.lang.String vCode, @org.jetbrains.annotations.Nullable()
    java.lang.String vColor) {
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
    
    public final boolean getUniquePid() {
        return false;
    }
    
    public final void setUniquePid(boolean p0) {
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
    
    public final boolean isFavorit() {
        return false;
    }
    
    public final void setFavorit(boolean p0) {
    }
    
    public final boolean component20() {
        return false;
    }
    
    public final boolean isAvailable() {
        return false;
    }
    
    public final void setAvailable(boolean p0) {
    }
    
    public final boolean component21() {
        return false;
    }
    
    public final boolean isVariant() {
        return false;
    }
    
    public final void setVariant(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component22() {
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
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getVColor() {
        return null;
    }
    
    public final void setVColor(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/ItemEntity$Companion;", "", "()V", "ACTIVE", "", "AVAILABLE", "BRAND_ID", "BUCKET", "CODE", "FAVORIT", "ID", "ISPOS", "ISSALE", "ISSTOCK", "ITEMGRP_ID", "ITEMQTY", "ITEMTYPE_CODE", "ITGRP_ID", "LASTSYNC", "NAME1", "NOTE", "OBJKEY", "SALEUNIT", "STOCKUNIT", "TBL_NAME", "TEMPURL", "TYPE", "UNIQUEPID", "UNITDESC", "USEPID", "VARIANT", "VCODE", "VCOLOR", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}