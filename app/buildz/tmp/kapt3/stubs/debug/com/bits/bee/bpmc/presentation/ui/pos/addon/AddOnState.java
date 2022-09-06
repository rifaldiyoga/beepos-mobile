package com.bits.bee.bpmc.presentation.ui.pos.addon;

import java.lang.System;

/**
 * Created by aldi on 15/08/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\t\u0010+\u001a\u00020\u000eH\u00c6\u0003J\u0011\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\tH\u00c6\u0003J\t\u0010-\u001a\u00020\u000eH\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003Jy\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\t2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u00c6\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u00020\u0007H\u00d6\u0001J\t\u00104\u001a\u000205H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u001a\u0010\u0011\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u00a8\u00066"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnState;", "", "item", "Lcom/bits/bee/bpmc/domain/model/Item;", "bp", "Lcom/bits/bee/bpmc/domain/model/Bp;", "priceLvlId", "", "selectionList", "", "Lcom/bits/bee/bpmc/domain/model/SelectionWithItem;", "variantWithItem", "Lcom/bits/bee/bpmc/domain/model/VariantWithItem;", "qty", "Ljava/math/BigDecimal;", "selectedAddOnList", "Lcom/bits/bee/bpmc/domain/model/Saled;", "subtotal", "saled", "(Lcom/bits/bee/bpmc/domain/model/Item;Lcom/bits/bee/bpmc/domain/model/Bp;ILjava/util/List;Lcom/bits/bee/bpmc/domain/model/VariantWithItem;Ljava/math/BigDecimal;Ljava/util/List;Ljava/math/BigDecimal;Lcom/bits/bee/bpmc/domain/model/Saled;)V", "getBp", "()Lcom/bits/bee/bpmc/domain/model/Bp;", "getItem", "()Lcom/bits/bee/bpmc/domain/model/Item;", "getPriceLvlId", "()I", "getQty", "()Ljava/math/BigDecimal;", "getSaled", "()Lcom/bits/bee/bpmc/domain/model/Saled;", "getSelectedAddOnList", "()Ljava/util/List;", "getSelectionList", "getSubtotal", "setSubtotal", "(Ljava/math/BigDecimal;)V", "getVariantWithItem", "()Lcom/bits/bee/bpmc/domain/model/VariantWithItem;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class AddOnState {
    @org.jetbrains.annotations.Nullable()
    private final com.bits.bee.bpmc.domain.model.Item item = null;
    @org.jetbrains.annotations.Nullable()
    private final com.bits.bee.bpmc.domain.model.Bp bp = null;
    private final int priceLvlId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.bits.bee.bpmc.domain.model.SelectionWithItem> selectionList = null;
    @org.jetbrains.annotations.Nullable()
    private final com.bits.bee.bpmc.domain.model.VariantWithItem variantWithItem = null;
    @org.jetbrains.annotations.NotNull()
    private final java.math.BigDecimal qty = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.bits.bee.bpmc.domain.model.Saled> selectedAddOnList = null;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal subtotal;
    @org.jetbrains.annotations.Nullable()
    private final com.bits.bee.bpmc.domain.model.Saled saled = null;
    
    /**
     * Created by aldi on 15/08/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.pos.addon.AddOnState copy(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Item item, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Bp bp, int priceLvlId, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.SelectionWithItem> selectionList, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.VariantWithItem variantWithItem, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal qty, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> selectedAddOnList, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal subtotal, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Saled saled) {
        return null;
    }
    
    /**
     * Created by aldi on 15/08/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 15/08/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 15/08/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public AddOnState() {
        super();
    }
    
    public AddOnState(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Item item, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Bp bp, int priceLvlId, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.SelectionWithItem> selectionList, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.VariantWithItem variantWithItem, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal qty, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> selectedAddOnList, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal subtotal, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Saled saled) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Item component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Item getItem() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Bp component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Bp getBp() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getPriceLvlId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.SelectionWithItem> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.SelectionWithItem> getSelectionList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.VariantWithItem component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.VariantWithItem getVariantWithItem() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getQty() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Saled> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Saled> getSelectedAddOnList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getSubtotal() {
        return null;
    }
    
    public final void setSubtotal(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Saled component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Saled getSaled() {
        return null;
    }
}