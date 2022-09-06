package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk;

import java.lang.System;

/**
 * Created by aldi on 31/08/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/tambah_produk/TambahProdukViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/tambah_produk/TambahProdukState;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/tambah_produk/TambahProdukViewModel$UIEvent;", "addEditProdukUseCase", "Lcom/bits/bee/bpmc/domain/usecase/signup/AddEditProdukUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/signup/AddEditProdukUseCase;)V", "onSubmit", "Lkotlinx/coroutines/Job;", "UIEvent", "app_debug"})
public final class TambahProdukViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.TambahProdukState, com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.TambahProdukViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.signup.AddEditProdukUseCase addEditProdukUseCase = null;
    
    @javax.inject.Inject()
    public TambahProdukViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.signup.AddEditProdukUseCase addEditProdukUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onSubmit() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/tambah_produk/TambahProdukViewModel$UIEvent;", "", "()V", "FinsihSubmit", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/tambah_produk/TambahProdukViewModel$UIEvent$FinsihSubmit;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/tambah_produk/TambahProdukViewModel$UIEvent$FinsihSubmit;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/tambah_produk/TambahProdukViewModel$UIEvent;", "()V", "app_debug"})
        public static final class FinsihSubmit extends com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.TambahProdukViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.TambahProdukViewModel.UIEvent.FinsihSubmit INSTANCE = null;
            
            private FinsihSubmit() {
                super();
            }
        }
    }
}