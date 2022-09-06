package com.bits.bee.bpmc.presentation.ui.pos.pid;

import java.lang.System;

/**
 * Created by aldi on 04/08/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/pid/PilihPidViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/pos/pid/PilihPidState;", "Lcom/bits/bee/bpmc/presentation/ui/pos/pid/PilihPidViewModel$UIEvent;", "getPidByItemUseCase", "Lcom/bits/bee/bpmc/domain/usecase/pos/GetPidByItemUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/pos/GetPidByItemUseCase;)V", "loadData", "Lkotlinx/coroutines/Job;", "onItemClick", "stock", "Lcom/bits/bee/bpmc/domain/model/Stock;", "UIEvent", "app_debug"})
public final class PilihPidViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.pos.pid.PilihPidState, com.bits.bee.bpmc.presentation.ui.pos.pid.PilihPidViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.pos.GetPidByItemUseCase getPidByItemUseCase = null;
    
    @javax.inject.Inject()
    public PilihPidViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pos.GetPidByItemUseCase getPidByItemUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onItemClick(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Stock stock) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadData() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/pid/PilihPidViewModel$UIEvent;", "", "()V", "NavigateToAddItem", "Lcom/bits/bee/bpmc/presentation/ui/pos/pid/PilihPidViewModel$UIEvent$NavigateToAddItem;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/pid/PilihPidViewModel$UIEvent$NavigateToAddItem;", "Lcom/bits/bee/bpmc/presentation/ui/pos/pid/PilihPidViewModel$UIEvent;", "item", "Lcom/bits/bee/bpmc/domain/model/Item;", "stock", "Lcom/bits/bee/bpmc/domain/model/Stock;", "(Lcom/bits/bee/bpmc/domain/model/Item;Lcom/bits/bee/bpmc/domain/model/Stock;)V", "getItem", "()Lcom/bits/bee/bpmc/domain/model/Item;", "getStock", "()Lcom/bits/bee/bpmc/domain/model/Stock;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class NavigateToAddItem extends com.bits.bee.bpmc.presentation.ui.pos.pid.PilihPidViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            private final com.bits.bee.bpmc.domain.model.Item item = null;
            @org.jetbrains.annotations.NotNull()
            private final com.bits.bee.bpmc.domain.model.Stock stock = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.presentation.ui.pos.pid.PilihPidViewModel.UIEvent.NavigateToAddItem copy(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Item item, @org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Stock stock) {
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
            
            public NavigateToAddItem(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Item item, @org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Stock stock) {
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
            public final com.bits.bee.bpmc.domain.model.Stock component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Stock getStock() {
                return null;
            }
        }
    }
}