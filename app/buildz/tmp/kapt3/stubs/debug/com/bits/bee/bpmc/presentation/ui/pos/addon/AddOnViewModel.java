package com.bits.bee.bpmc.presentation.ui.pos.addon;

import java.lang.System;

/**
 * Created by aldi on 15/08/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u001dB\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\u0013J\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\u000fJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0017R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\'\u0010\r\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\u000f0\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnState;", "Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnViewModel$UIEvent;", "getSelectionAddOnUseCase", "Lcom/bits/bee/bpmc/domain/usecase/addon/GetSelectionAddOnUseCase;", "getItemVariantUseCase", "Lcom/bits/bee/bpmc/domain/usecase/addon/GetItemVariantUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/addon/GetSelectionAddOnUseCase;Lcom/bits/bee/bpmc/domain/usecase/addon/GetItemVariantUseCase;)V", "_selectedAddOn", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/bits/bee/bpmc/domain/model/Item;", "selectedAddOn", "Landroidx/lifecycle/LiveData;", "Lkotlin/collections/ArrayList;", "getSelectedAddOn", "()Landroidx/lifecycle/LiveData;", "addItemSelectedList", "", "item", "clearSelectedAddOn", "getSelection", "Lkotlinx/coroutines/Job;", "getVariant", "id", "", "loadData", "UIEvent", "VariantState", "app_debug"})
public final class AddOnViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.pos.addon.AddOnState, com.bits.bee.bpmc.presentation.ui.pos.addon.AddOnViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.addon.GetSelectionAddOnUseCase getSelectionAddOnUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.addon.GetItemVariantUseCase getItemVariantUseCase = null;
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.bits.bee.bpmc.domain.model.Item>> _selectedAddOn = null;
    
    @javax.inject.Inject()
    public AddOnViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.addon.GetSelectionAddOnUseCase getSelectionAddOnUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.addon.GetItemVariantUseCase getItemVariantUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.ArrayList<com.bits.bee.bpmc.domain.model.Item>> getSelectedAddOn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.bits.bee.bpmc.domain.model.Item> getSelectedAddOn() {
        return null;
    }
    
    public final void addItemSelectedList(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Item item) {
    }
    
    public final void clearSelectedAddOn() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getSelection(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Item item) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getVariant(int id) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnViewModel$UIEvent;", "", "()V", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnViewModel$VariantState;", "", "item", "Lcom/bits/bee/bpmc/domain/model/Item;", "(Lcom/bits/bee/bpmc/domain/model/Item;)V", "getItem", "()Lcom/bits/bee/bpmc/domain/model/Item;", "setItem", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class VariantState {
        @org.jetbrains.annotations.Nullable()
        private com.bits.bee.bpmc.domain.model.Item item;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.presentation.ui.pos.addon.AddOnViewModel.VariantState copy(@org.jetbrains.annotations.Nullable()
        com.bits.bee.bpmc.domain.model.Item item) {
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
        
        public VariantState(@org.jetbrains.annotations.Nullable()
        com.bits.bee.bpmc.domain.model.Item item) {
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
        
        public final void setItem(@org.jetbrains.annotations.Nullable()
        com.bits.bee.bpmc.domain.model.Item p0) {
        }
    }
}