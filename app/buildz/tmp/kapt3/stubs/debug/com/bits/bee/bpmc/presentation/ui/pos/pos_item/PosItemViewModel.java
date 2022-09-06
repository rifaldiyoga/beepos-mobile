package com.bits.bee.bpmc.presentation.ui.pos.pos_item;

import java.lang.System;

/**
 * Created by aldi on 12/05/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/pos_item/PosItemViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/pos/pos_item/PosItemState;", "Lcom/bits/bee/bpmc/presentation/ui/pos/pos_item/PosItemViewModel$UIEvent;", "getActiveItemUseCase", "Lcom/bits/bee/bpmc/domain/usecase/pos/GetActiveItemUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/pos/GetActiveItemUseCase;)V", "itemFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/bits/bee/bpmc/domain/model/Item;", "getItemFlow", "()Lkotlinx/coroutines/flow/Flow;", "setItemFlow", "(Lkotlinx/coroutines/flow/Flow;)V", "loadItem", "Lkotlinx/coroutines/Job;", "bp", "Lcom/bits/bee/bpmc/domain/model/Bp;", "onReciveItemGroup", "itemGroup", "Lcom/bits/bee/bpmc/domain/model/ItemGroup;", "UIEvent", "app_debug"})
public final class PosItemViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.pos.pos_item.PosItemState, com.bits.bee.bpmc.presentation.ui.pos.pos_item.PosItemViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemUseCase getActiveItemUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Item>> itemFlow;
    
    @javax.inject.Inject()
    public PosItemViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemUseCase getActiveItemUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Item>> getItemFlow() {
        return null;
    }
    
    public final void setItemFlow(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Item>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadItem(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Bp bp) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onReciveItemGroup(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.ItemGroup itemGroup) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/pos_item/PosItemViewModel$UIEvent;", "", "()V", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
    }
}