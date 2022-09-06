package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "price", foreignKeys = {@androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.PriceLvlEntity.class, childColumns = {"pricelvl_id"}, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 22\u00020\u0001:\u00012BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0002\u0010\fJ\u0010\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\tH\u00c6\u0003JX\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\tH\u00c6\u0001\u00a2\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u00020\u0003H\u00d6\u0001J\t\u00101\u001a\u00020\tH\u00d6\u0001R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010\u00a8\u00063"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/PriceEntity;", "", "id", "", "itemId", "priceLvlId", "price", "Ljava/math/BigDecimal;", "discExp", "", "crcId", "crcSymbol", "(Ljava/lang/Integer;IILjava/math/BigDecimal;Ljava/lang/String;ILjava/lang/String;)V", "getCrcId", "()I", "setCrcId", "(I)V", "getCrcSymbol", "()Ljava/lang/String;", "setCrcSymbol", "(Ljava/lang/String;)V", "getDiscExp", "setDiscExp", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getItemId", "setItemId", "getPrice", "()Ljava/math/BigDecimal;", "setPrice", "(Ljava/math/BigDecimal;)V", "getPriceLvlId", "setPriceLvlId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;IILjava/math/BigDecimal;Ljava/lang/String;ILjava/lang/String;)Lcom/bits/bee/bpmc/data/data_source/local/model/PriceEntity;", "equals", "", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class PriceEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private java.lang.Integer id;
    @androidx.room.ColumnInfo(name = "itemid", index = true)
    private int itemId;
    @androidx.room.ColumnInfo(name = "pricelvl_id", index = true)
    private int priceLvlId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "price1")
    private java.math.BigDecimal price;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "discexp1")
    private java.lang.String discExp;
    @androidx.room.ColumnInfo(name = "crc_id")
    private int crcId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "crc_symbol")
    private java.lang.String crcSymbol;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.PriceEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "price";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ITEM_ID = "itemid";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PRICE1 = "price1";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DISCEXP1 = "discexp1";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PRICELVL_ID = "pricelvl_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CRC_ID = "crc_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CRC_SYMBOL = "crc_symbol";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LASTSYNC = "last_sync";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.PriceEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, int itemId, int priceLvlId, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal price, @org.jetbrains.annotations.Nullable()
    java.lang.String discExp, int crcId, @org.jetbrains.annotations.NotNull()
    java.lang.String crcSymbol) {
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
    
    public PriceEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, int itemId, int priceLvlId, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal price, @org.jetbrains.annotations.Nullable()
    java.lang.String discExp, int crcId, @org.jetbrains.annotations.NotNull()
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
    
    public final int getItemId() {
        return 0;
    }
    
    public final void setItemId(int p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getPriceLvlId() {
        return 0;
    }
    
    public final void setPriceLvlId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getPrice() {
        return null;
    }
    
    public final void setPrice(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDiscExp() {
        return null;
    }
    
    public final void setDiscExp(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getCrcId() {
        return 0;
    }
    
    public final void setCrcId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCrcSymbol() {
        return null;
    }
    
    public final void setCrcSymbol(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/PriceEntity$Companion;", "", "()V", "CRC_ID", "", "CRC_SYMBOL", "DISCEXP1", "ID", "ITEM_ID", "LASTSYNC", "PRICE1", "PRICELVL_ID", "TBL_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}