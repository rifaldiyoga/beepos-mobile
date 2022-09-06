package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "salepromo", foreignKeys = {@androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.SaleEntity.class, childColumns = {"sale_id"}, onDelete = 5, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.SaledEntity.class, childColumns = {"saled_id"}, onDelete = 5, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.PromoEntity.class, childColumns = {"promo_id"}, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.BpEntity.class, childColumns = {"bp_id"}, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 22\u00020\u0001:\u00012BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u000bH\u00c6\u0003J\t\u0010+\u001a\u00020\u0006H\u00c6\u0003JY\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u00020\u0003H\u00d6\u0001J\t\u00101\u001a\u00020\u0006H\u00d6\u0001R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011\u00a8\u00063"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/SalePromoEntity;", "", "id", "", "saleId", "saleNo", "", "saledId", "promoId", "bpId", "promoQty", "Ljava/math/BigDecimal;", "promoRule", "(IILjava/lang/String;IIILjava/math/BigDecimal;Ljava/lang/String;)V", "getBpId", "()I", "setBpId", "(I)V", "getId", "setId", "getPromoId", "setPromoId", "getPromoQty", "()Ljava/math/BigDecimal;", "setPromoQty", "(Ljava/math/BigDecimal;)V", "getPromoRule", "()Ljava/lang/String;", "setPromoRule", "(Ljava/lang/String;)V", "getSaleId", "setSaleId", "getSaleNo", "setSaleNo", "getSaledId", "setSaledId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class SalePromoEntity {
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = false)
    private int id;
    @androidx.room.ColumnInfo(name = "sale_id", index = true)
    private int saleId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "saleno")
    private java.lang.String saleNo;
    @androidx.room.ColumnInfo(name = "saled_id", index = true)
    private int saledId;
    @androidx.room.ColumnInfo(name = "promo_id", index = true)
    private int promoId;
    @androidx.room.ColumnInfo(name = "bp_id", index = true)
    private int bpId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "promoqty")
    private java.math.BigDecimal promoQty;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "promorole")
    private java.lang.String promoRule;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.SalePromoEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "salepromo";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SALE_ID = "sale_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SALENO = "saleno";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SALED_ID = "saled_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROMO_ID = "promo_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BP_ID = "bp_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROMOQTY = "promoqty";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROMOROLE = "promorole";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.SalePromoEntity copy(int id, int saleId, @org.jetbrains.annotations.NotNull()
    java.lang.String saleNo, int saledId, int promoId, int bpId, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal promoQty, @org.jetbrains.annotations.NotNull()
    java.lang.String promoRule) {
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
    
    public SalePromoEntity(int id, int saleId, @org.jetbrains.annotations.NotNull()
    java.lang.String saleNo, int saledId, int promoId, int bpId, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal promoQty, @org.jetbrains.annotations.NotNull()
    java.lang.String promoRule) {
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
    
    public final int component2() {
        return 0;
    }
    
    public final int getSaleId() {
        return 0;
    }
    
    public final void setSaleId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSaleNo() {
        return null;
    }
    
    public final void setSaleNo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getSaledId() {
        return 0;
    }
    
    public final void setSaledId(int p0) {
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getPromoId() {
        return 0;
    }
    
    public final void setPromoId(int p0) {
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getBpId() {
        return 0;
    }
    
    public final void setBpId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getPromoQty() {
        return null;
    }
    
    public final void setPromoQty(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPromoRule() {
        return null;
    }
    
    public final void setPromoRule(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/SalePromoEntity$Companion;", "", "()V", "BP_ID", "", "ID", "PROMOQTY", "PROMOROLE", "PROMO_ID", "SALED_ID", "SALENO", "SALE_ID", "TBL_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}