package com.bits.bee.bpmc.presentation.ui.sign_up.atur_produk;

import java.lang.System;

/**
 * Created by aldi on 31/08/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/atur_produk/AturProdukViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/atur_produk/AturProdukState;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/atur_produk/AturProdukViewModel$UIEvent;", "getItemDummyUseCase", "Lcom/bits/bee/bpmc/domain/usecase/signup/GetItemDummyUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/signup/GetItemDummyUseCase;)V", "itemDummyList", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/bits/bee/bpmc/domain/model/ItemDummy;", "getItemDummyList", "()Lkotlinx/coroutines/flow/Flow;", "UIEvent", "app_debug"})
public final class AturProdukViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.sign_up.atur_produk.AturProdukState, com.bits.bee.bpmc.presentation.ui.sign_up.atur_produk.AturProdukViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.signup.GetItemDummyUseCase getItemDummyUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.ItemDummy>> itemDummyList = null;
    
    @javax.inject.Inject()
    public AturProdukViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.signup.GetItemDummyUseCase getItemDummyUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.ItemDummy>> getItemDummyList() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/atur_produk/AturProdukViewModel$UIEvent;", "", "()V", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
    }
}