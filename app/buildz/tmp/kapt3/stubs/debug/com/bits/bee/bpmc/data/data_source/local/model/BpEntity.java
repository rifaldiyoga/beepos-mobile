package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "bp", foreignKeys = {@androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.PriceLvlEntity.class, childColumns = {"pricelvl_id"}, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bD\b\u0087\b\u0018\u0000 T2\u00020\u0001:\u0001TB\u009d\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\t\u0010@\u001a\u00020\nH\u00c6\u0003J\t\u0010A\u001a\u00020\u0011H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\t\u0010E\u001a\u00020\nH\u00c6\u0003J\t\u0010F\u001a\u00020\u0005H\u00c6\u0003J\t\u0010G\u001a\u00020\u0005H\u00c6\u0003J\t\u0010H\u001a\u00020\u0005H\u00c6\u0003J\t\u0010I\u001a\u00020\u0005H\u00c6\u0003J\t\u0010J\u001a\u00020\nH\u00c6\u0003J\t\u0010K\u001a\u00020\nH\u00c6\u0003J\t\u0010L\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u00b6\u0001\u0010N\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\nH\u00c6\u0001\u00a2\u0006\u0002\u0010OJ\u0013\u0010P\u001a\u00020\n2\b\u0010Q\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010R\u001a\u00020\u0003H\u00d6\u0001J\t\u0010S\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010.\"\u0004\b/\u00100R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010.\"\u0004\b1\u00100R\u001e\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010.\"\u0004\b2\u00100R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010.\"\u0004\b3\u00100R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001aR\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0018\"\u0004\b7\u0010\u001aR\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\'\"\u0004\b9\u0010)R \u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010#\"\u0004\b;\u0010%R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b<\u0010\u001c\"\u0004\b=\u0010\u001e\u00a8\u0006U"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/BpEntity;", "", "id", "", "code", "", "name", "greeting", "anniversary", "isTaxedOnSale", "", "isTaxIncOnSale", "note", "bpgrpId", "priceLvlId", "isActive", "createdAt", "Ljava/util/Date;", "createdBy", "updatedAt", "updatedBy", "isFavorit", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;IZLjava/util/Date;ILjava/util/Date;Ljava/lang/Integer;Z)V", "getAnniversary", "()Ljava/lang/String;", "setAnniversary", "(Ljava/lang/String;)V", "getBpgrpId", "()Ljava/lang/Integer;", "setBpgrpId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCode", "setCode", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "getCreatedBy", "()I", "setCreatedBy", "(I)V", "getGreeting", "setGreeting", "getId", "setId", "()Z", "setActive", "(Z)V", "setFavorit", "setTaxIncOnSale", "setTaxedOnSale", "getName", "setName", "getNote", "setNote", "getPriceLvlId", "setPriceLvlId", "getUpdatedAt", "setUpdatedAt", "getUpdatedBy", "setUpdatedBy", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;IZLjava/util/Date;ILjava/util/Date;Ljava/lang/Integer;Z)Lcom/bits/bee/bpmc/data/data_source/local/model/BpEntity;", "equals", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class BpEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = false)
    private java.lang.Integer id;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "code")
    private java.lang.String code;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "name")
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "greeting")
    private java.lang.String greeting;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "anniversary")
    private java.lang.String anniversary;
    @androidx.room.ColumnInfo(name = "taxedonsale")
    private boolean isTaxedOnSale;
    @androidx.room.ColumnInfo(name = "taxinconsale")
    private boolean isTaxIncOnSale;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "note")
    private java.lang.String note;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "bpgrp1_id")
    private java.lang.Integer bpgrpId;
    @androidx.room.ColumnInfo(name = "pricelvl_id", index = true)
    private int priceLvlId;
    @androidx.room.ColumnInfo(name = "active")
    private boolean isActive;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "created_at")
    private java.util.Date createdAt;
    @androidx.room.ColumnInfo(name = "created_by")
    private int createdBy;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "updated_at")
    private java.util.Date updatedAt;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "updated_by")
    private java.lang.Integer updatedBy;
    @androidx.room.ColumnInfo(name = "isfavorit")
    private boolean isFavorit;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.BpEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "bp";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CODE = "code";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NAME = "name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GREETING = "greeting";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ANNIVERSARY = "anniversary";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAXEDONSALE = "taxedonsale";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAXINCONSALE = "taxinconsale";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTE = "note";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BPGRP1_ID = "bpgrp1_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PRICELVL_ID = "pricelvl_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVE = "active";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CREATED_AT = "created_at";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CREATED_BY = "created_by";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UPDATED_AT = "updated_at";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UPDATED_BY = "updated_by";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ISFAVORIT = "isfavorit";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.BpEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String greeting, @org.jetbrains.annotations.NotNull()
    java.lang.String anniversary, boolean isTaxedOnSale, boolean isTaxIncOnSale, @org.jetbrains.annotations.NotNull()
    java.lang.String note, @org.jetbrains.annotations.Nullable()
    java.lang.Integer bpgrpId, int priceLvlId, boolean isActive, @org.jetbrains.annotations.NotNull()
    java.util.Date createdAt, int createdBy, @org.jetbrains.annotations.Nullable()
    java.util.Date updatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.Integer updatedBy, boolean isFavorit) {
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
    
    public BpEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String greeting, @org.jetbrains.annotations.NotNull()
    java.lang.String anniversary, boolean isTaxedOnSale, boolean isTaxIncOnSale, @org.jetbrains.annotations.NotNull()
    java.lang.String note, @org.jetbrains.annotations.Nullable()
    java.lang.Integer bpgrpId, int priceLvlId, boolean isActive, @org.jetbrains.annotations.NotNull()
    java.util.Date createdAt, int createdBy, @org.jetbrains.annotations.Nullable()
    java.util.Date updatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.Integer updatedBy, boolean isFavorit) {
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
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGreeting() {
        return null;
    }
    
    public final void setGreeting(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAnniversary() {
        return null;
    }
    
    public final void setAnniversary(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean isTaxedOnSale() {
        return false;
    }
    
    public final void setTaxedOnSale(boolean p0) {
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean isTaxIncOnSale() {
        return false;
    }
    
    public final void setTaxIncOnSale(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
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
    public final java.lang.Integer component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getBpgrpId() {
        return null;
    }
    
    public final void setBpgrpId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int getPriceLvlId() {
        return 0;
    }
    
    public final void setPriceLvlId(int p0) {
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean isActive() {
        return false;
    }
    
    public final void setActive(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
    }
    
    public final int component13() {
        return 0;
    }
    
    public final int getCreatedBy() {
        return 0;
    }
    
    public final void setCreatedBy(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getUpdatedAt() {
        return null;
    }
    
    public final void setUpdatedAt(@org.jetbrains.annotations.Nullable()
    java.util.Date p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getUpdatedBy() {
        return null;
    }
    
    public final void setUpdatedBy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public final boolean component16() {
        return false;
    }
    
    public final boolean isFavorit() {
        return false;
    }
    
    public final void setFavorit(boolean p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/BpEntity$Companion;", "", "()V", "ACTIVE", "", "ANNIVERSARY", "BPGRP1_ID", "CODE", "CREATED_AT", "CREATED_BY", "GREETING", "ID", "ISFAVORIT", "NAME", "NOTE", "PRICELVL_ID", "TAXEDONSALE", "TAXINCONSALE", "TBL_NAME", "UPDATED_AT", "UPDATED_BY", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}