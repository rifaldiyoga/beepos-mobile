package com.bits.bee.bpmc.presentation.ui.pos.edit_item;

import java.lang.System;

/**
 * Created by aldi on 25/05/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/edit_item/EditItemViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/pos/edit_item/EditItemState;", "Lcom/bits/bee/bpmc/presentation/ui/pos/edit_item/EditItemViewModel$UIEvent;", "getUnitItemUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetUnitItemUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/common/GetUnitItemUseCase;)V", "loadUnit", "Lkotlinx/coroutines/Job;", "id", "", "onClickAddOn", "onClickMinus", "onClickPlus", "onClickSubmit", "onDiscChange", "disc", "", "onPriceChange", "price", "onQtyChange", "qty", "UIEvent", "app_debug"})
public final class EditItemViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.pos.edit_item.EditItemState, com.bits.bee.bpmc.presentation.ui.pos.edit_item.EditItemViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.common.GetUnitItemUseCase getUnitItemUseCase = null;
    
    @javax.inject.Inject()
    public EditItemViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetUnitItemUseCase getUnitItemUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadUnit(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onPriceChange(@org.jetbrains.annotations.NotNull()
    java.lang.String price) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onDiscChange(@org.jetbrains.annotations.NotNull()
    java.lang.String disc) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onQtyChange(@org.jetbrains.annotations.NotNull()
    java.lang.String qty) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickPlus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickMinus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickSubmit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickAddOn() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/edit_item/EditItemViewModel$UIEvent;", "", "()V", "NavigateToAddOn", "RequestAdd", "RequestSubmit", "Lcom/bits/bee/bpmc/presentation/ui/pos/edit_item/EditItemViewModel$UIEvent$NavigateToAddOn;", "Lcom/bits/bee/bpmc/presentation/ui/pos/edit_item/EditItemViewModel$UIEvent$RequestAdd;", "Lcom/bits/bee/bpmc/presentation/ui/pos/edit_item/EditItemViewModel$UIEvent$RequestSubmit;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/edit_item/EditItemViewModel$UIEvent$RequestSubmit;", "Lcom/bits/bee/bpmc/presentation/ui/pos/edit_item/EditItemViewModel$UIEvent;", "saled", "Lcom/bits/bee/bpmc/domain/model/Saled;", "(Lcom/bits/bee/bpmc/domain/model/Saled;)V", "getSaled", "()Lcom/bits/bee/bpmc/domain/model/Saled;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class RequestSubmit extends com.bits.bee.bpmc.presentation.ui.pos.edit_item.EditItemViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            private final com.bits.bee.bpmc.domain.model.Saled saled = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.presentation.ui.pos.edit_item.EditItemViewModel.UIEvent.RequestSubmit copy(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Saled saled) {
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
            
            public RequestSubmit(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Saled saled) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Saled component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Saled getSaled() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/edit_item/EditItemViewModel$UIEvent$RequestAdd;", "Lcom/bits/bee/bpmc/presentation/ui/pos/edit_item/EditItemViewModel$UIEvent;", "itemWithUnit", "Lcom/bits/bee/bpmc/domain/model/ItemWithUnit;", "(Lcom/bits/bee/bpmc/domain/model/ItemWithUnit;)V", "getItemWithUnit", "()Lcom/bits/bee/bpmc/domain/model/ItemWithUnit;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class RequestAdd extends com.bits.bee.bpmc.presentation.ui.pos.edit_item.EditItemViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            private final com.bits.bee.bpmc.domain.model.ItemWithUnit itemWithUnit = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.presentation.ui.pos.edit_item.EditItemViewModel.UIEvent.RequestAdd copy(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.ItemWithUnit itemWithUnit) {
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
            
            public RequestAdd(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.ItemWithUnit itemWithUnit) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.ItemWithUnit component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.ItemWithUnit getItemWithUnit() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/edit_item/EditItemViewModel$UIEvent$NavigateToAddOn;", "Lcom/bits/bee/bpmc/presentation/ui/pos/edit_item/EditItemViewModel$UIEvent;", "item", "Lcom/bits/bee/bpmc/domain/model/Item;", "saled", "Lcom/bits/bee/bpmc/domain/model/Saled;", "(Lcom/bits/bee/bpmc/domain/model/Item;Lcom/bits/bee/bpmc/domain/model/Saled;)V", "getItem", "()Lcom/bits/bee/bpmc/domain/model/Item;", "getSaled", "()Lcom/bits/bee/bpmc/domain/model/Saled;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class NavigateToAddOn extends com.bits.bee.bpmc.presentation.ui.pos.edit_item.EditItemViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            private final com.bits.bee.bpmc.domain.model.Item item = null;
            @org.jetbrains.annotations.NotNull()
            private final com.bits.bee.bpmc.domain.model.Saled saled = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.presentation.ui.pos.edit_item.EditItemViewModel.UIEvent.NavigateToAddOn copy(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Item item, @org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Saled saled) {
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
            
            public NavigateToAddOn(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Item item, @org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Saled saled) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Item component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Item getItem() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Saled component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Saled getSaled() {
                return null;
            }
        }
    }
}