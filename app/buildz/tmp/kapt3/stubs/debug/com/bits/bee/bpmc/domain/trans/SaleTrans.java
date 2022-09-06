package com.bits.bee.bpmc.domain.trans;

import java.lang.System;

/**
 * Created by aldi on 19/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0006\u0010\u001c\u001a\u00020\u0015J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0003J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0003H\u0002J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0003J\u0018\u0010\'\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0002J\b\u0010)\u001a\u00020\u0002H\u0016J\u0016\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030+2\u0006\u0010,\u001a\u00020\u0003J\u0010\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u0002H\u0016J\u0006\u0010/\u001a\u00020\u0015J\u0006\u00100\u001a\u00020\u0015J\u0016\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0003J\b\u00104\u001a\u00020\u0015H\u0016J\b\u00105\u001a\u00020\u0015H\u0016J\u000e\u00106\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u00107\u001a\u00020\u00152\b\u00108\u001a\u0004\u0018\u00010\u0011J\b\u00109\u001a\u00020\u0015H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/bits/bee/bpmc/domain/trans/SaleTrans;", "Lcom/bits/bee/bpmc/domain/trans/BaseTrans;", "Lcom/bits/bee/bpmc/domain/model/Sale;", "Lcom/bits/bee/bpmc/domain/model/Saled;", "()V", "addOnTrans", "Lcom/bits/bee/bpmc/domain/trans/AddOnTrans;", "getAddOnTrans", "()Lcom/bits/bee/bpmc/domain/trans/AddOnTrans;", "setAddOnTrans", "(Lcom/bits/bee/bpmc/domain/trans/AddOnTrans;)V", "bp", "Lcom/bits/bee/bpmc/domain/model/Bp;", "currentSaled", "dnoCounter", "", "grpAddon", "Lcom/bits/bee/bpmc/domain/model/ItemGroup;", "roundVal", "saledParent", "addDetail", "", "itemWithUnit", "Lcom/bits/bee/bpmc/domain/model/ItemWithUnit;", "isBonus", "", "useItemqty", "d", "calcDetailDiskon", "calculate", "deleteDetail", "saledDel", "deleteOldSaleAddonD", "saled", "diskonMaster", "diskon", "", "editDetail", "saledEdit", "editSaled", "newSaled", "getMaster", "getSaledByUpSaledList", "", "model", "loadTrans", "var1", "mergeAddon", "mergeItemAddon", "mergeSaled", "saled1", "saled2", "newTrans", "saveTrans", "setBp", "setGrpAddOn", "itemGroup", "voidTrans", "app_debug"})
@javax.inject.Singleton()
public final class SaleTrans extends com.bits.bee.bpmc.domain.trans.BaseTrans<com.bits.bee.bpmc.domain.model.Sale, com.bits.bee.bpmc.domain.model.Saled> {
    private com.bits.bee.bpmc.domain.model.Bp bp;
    private com.bits.bee.bpmc.domain.model.Saled saledParent;
    private com.bits.bee.bpmc.domain.model.Saled currentSaled;
    private com.bits.bee.bpmc.domain.model.ItemGroup grpAddon;
    private int dnoCounter = 0;
    private int roundVal = 0;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.trans.AddOnTrans addOnTrans;
    
    @javax.inject.Inject()
    public SaleTrans() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.trans.AddOnTrans getAddOnTrans() {
        return null;
    }
    
    public final void setAddOnTrans(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.trans.AddOnTrans p0) {
    }
    
    public final void setBp(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Bp bp) {
    }
    
    public final void setGrpAddOn(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.ItemGroup itemGroup) {
    }
    
    @java.lang.Override()
    public void newTrans() {
    }
    
    @java.lang.Override()
    public void saveTrans() {
    }
    
    @java.lang.Override()
    public void voidTrans() {
    }
    
    @java.lang.Override()
    public void loadTrans(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale var1) {
    }
    
    public final void addDetail(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.ItemWithUnit itemWithUnit, boolean isBonus, boolean useItemqty) {
    }
    
    @java.lang.Override()
    public void addDetail(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Saled d) {
    }
    
    public final void editDetail(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Saled saledEdit) {
    }
    
    public final void diskonMaster(@org.jetbrains.annotations.NotNull()
    java.lang.String diskon) {
    }
    
    public final void calcDetailDiskon() {
    }
    
    private final com.bits.bee.bpmc.domain.model.Saled editSaled(com.bits.bee.bpmc.domain.model.Saled saled, com.bits.bee.bpmc.domain.model.Saled newSaled) {
        return null;
    }
    
    public final void deleteDetail(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Saled saledDel) {
    }
    
    private final void calculate() {
    }
    
    public final void mergeAddon() {
    }
    
    public final void mergeItemAddon() {
    }
    
    public final void mergeSaled(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Saled saled1, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Saled saled2) {
    }
    
    private final void deleteOldSaleAddonD(com.bits.bee.bpmc.domain.model.Saled saled) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Saled> getSaledByUpSaledList(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Saled model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.bits.bee.bpmc.domain.model.Sale getMaster() {
        return null;
    }
}