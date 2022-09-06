package com.bits.bee.bpmc.presentation.ui.pos.edit_item;

import java.lang.System;

/**
 * Created by aldi on 25/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e\u00a2\u0006\u0002\u0010\u0016J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\t\u0010A\u001a\u00020\u0014H\u00c6\u0003J\u0011\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000eH\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010D\u001a\u00020\u0007H\u00c6\u0003J\t\u0010E\u001a\u00020\u0007H\u00c6\u0003J\t\u0010F\u001a\u00020\nH\u00c6\u0003J\t\u0010G\u001a\u00020\u0007H\u00c6\u0003J\t\u0010H\u001a\u00020\nH\u00c6\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\u0097\u0001\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\n2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000eH\u00c6\u0001J\u0013\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010O\u001a\u00020PH\u00d6\u0001J\t\u0010Q\u001a\u00020\nH\u00d6\u0001R\"\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0018\"\u0004\b>\u0010\u001a\u00a8\u0006R"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/edit_item/EditItemState;", "", "saled", "Lcom/bits/bee/bpmc/domain/model/Saled;", "item", "Lcom/bits/bee/bpmc/domain/model/Item;", "qty", "Ljava/math/BigDecimal;", "listPrice", "diskon", "", "discAmt", "note", "unitList", "", "Lcom/bits/bee/bpmc/domain/model/Unit;", "unit", "pid", "Lcom/bits/bee/bpmc/domain/model/Stock;", "modePos", "Lcom/bits/bee/bpmc/presentation/ui/pos/PosModeState;", "addOnList", "(Lcom/bits/bee/bpmc/domain/model/Saled;Lcom/bits/bee/bpmc/domain/model/Item;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/util/List;Lcom/bits/bee/bpmc/domain/model/Unit;Lcom/bits/bee/bpmc/domain/model/Stock;Lcom/bits/bee/bpmc/presentation/ui/pos/PosModeState;Ljava/util/List;)V", "getAddOnList", "()Ljava/util/List;", "setAddOnList", "(Ljava/util/List;)V", "getDiscAmt", "()Ljava/math/BigDecimal;", "setDiscAmt", "(Ljava/math/BigDecimal;)V", "getDiskon", "()Ljava/lang/String;", "setDiskon", "(Ljava/lang/String;)V", "getItem", "()Lcom/bits/bee/bpmc/domain/model/Item;", "setItem", "(Lcom/bits/bee/bpmc/domain/model/Item;)V", "getListPrice", "setListPrice", "getModePos", "()Lcom/bits/bee/bpmc/presentation/ui/pos/PosModeState;", "setModePos", "(Lcom/bits/bee/bpmc/presentation/ui/pos/PosModeState;)V", "getNote", "setNote", "getPid", "()Lcom/bits/bee/bpmc/domain/model/Stock;", "setPid", "(Lcom/bits/bee/bpmc/domain/model/Stock;)V", "getQty", "setQty", "getSaled", "()Lcom/bits/bee/bpmc/domain/model/Saled;", "setSaled", "(Lcom/bits/bee/bpmc/domain/model/Saled;)V", "getUnit", "()Lcom/bits/bee/bpmc/domain/model/Unit;", "setUnit", "(Lcom/bits/bee/bpmc/domain/model/Unit;)V", "getUnitList", "setUnitList", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class EditItemState {
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Saled saled;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Item item;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal qty;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal listPrice;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String diskon;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal discAmt;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String note;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.bits.bee.bpmc.domain.model.Unit> unitList;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Unit unit;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Stock pid;
    @org.jetbrains.annotations.NotNull()
    private com.bits.bee.bpmc.presentation.ui.pos.PosModeState modePos;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.bits.bee.bpmc.domain.model.Saled> addOnList;
    
    /**
     * Created by aldi on 25/05/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.pos.edit_item.EditItemState copy(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Saled saled, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Item item, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal qty, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal listPrice, @org.jetbrains.annotations.NotNull()
    java.lang.String diskon, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal discAmt, @org.jetbrains.annotations.NotNull()
    java.lang.String note, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Unit> unitList, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Unit unit, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Stock pid, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.presentation.ui.pos.PosModeState modePos, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> addOnList) {
        return null;
    }
    
    /**
     * Created by aldi on 25/05/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 25/05/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 25/05/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public EditItemState() {
        super();
    }
    
    public EditItemState(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Saled saled, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Item item, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal qty, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal listPrice, @org.jetbrains.annotations.NotNull()
    java.lang.String diskon, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal discAmt, @org.jetbrains.annotations.NotNull()
    java.lang.String note, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Unit> unitList, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Unit unit, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Stock pid, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.presentation.ui.pos.PosModeState modePos, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> addOnList) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Saled component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Saled getSaled() {
        return null;
    }
    
    public final void setSaled(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Saled p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Item component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Item getItem() {
        return null;
    }
    
    public final void setItem(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Item p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component3() {
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
    public final java.math.BigDecimal component4() {
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
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDiskon() {
        return null;
    }
    
    public final void setDiskon(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component6() {
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
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNote() {
        return null;
    }
    
    public final void setNote(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Unit> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Unit> getUnitList() {
        return null;
    }
    
    public final void setUnitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Unit component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Unit getUnit() {
        return null;
    }
    
    public final void setUnit(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Unit p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Stock component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Stock getPid() {
        return null;
    }
    
    public final void setPid(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Stock p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.pos.PosModeState component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.pos.PosModeState getModePos() {
        return null;
    }
    
    public final void setModePos(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.presentation.ui.pos.PosModeState p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Saled> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Saled> getAddOnList() {
        return null;
    }
    
    public final void setAddOnList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> p0) {
    }
}