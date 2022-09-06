package com.bits.bee.bpmc.presentation.ui.pos.invoice;

import java.lang.System;

/**
 * Created by aldi on 25/04/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u001c\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u0010\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "", "Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel$UIEvent;", "addTransactionUseCase", "Lcom/bits/bee/bpmc/domain/usecase/pos/AddTransactionUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/pos/AddTransactionUseCase;)V", "onClickBatal", "Lkotlinx/coroutines/Job;", "onClickBayar", "onClickDraft", "sale", "Lcom/bits/bee/bpmc/domain/model/Sale;", "saledList", "", "Lcom/bits/bee/bpmc/domain/model/Saled;", "onDetailEmpty", "UIEvent", "app_debug"})
public final class InvoiceViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<java.lang.Object, com.bits.bee.bpmc.presentation.ui.pos.invoice.InvoiceViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.pos.AddTransactionUseCase addTransactionUseCase = null;
    
    @javax.inject.Inject()
    public InvoiceViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pos.AddTransactionUseCase addTransactionUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickBayar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickBatal() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickDraft(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> saledList) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onDetailEmpty() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel$UIEvent;", "", "()V", "NavigatePos", "RequestBatal", "RequestDraft", "RequestPembayaran", "Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel$UIEvent$NavigatePos;", "Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel$UIEvent$RequestBatal;", "Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel$UIEvent$RequestDraft;", "Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel$UIEvent$RequestPembayaran;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel$UIEvent$NavigatePos;", "Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigatePos extends com.bits.bee.bpmc.presentation.ui.pos.invoice.InvoiceViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pos.invoice.InvoiceViewModel.UIEvent.NavigatePos INSTANCE = null;
            
            private NavigatePos() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel$UIEvent$RequestPembayaran;", "Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestPembayaran extends com.bits.bee.bpmc.presentation.ui.pos.invoice.InvoiceViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pos.invoice.InvoiceViewModel.UIEvent.RequestPembayaran INSTANCE = null;
            
            private RequestPembayaran() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel$UIEvent$RequestBatal;", "Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestBatal extends com.bits.bee.bpmc.presentation.ui.pos.invoice.InvoiceViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pos.invoice.InvoiceViewModel.UIEvent.RequestBatal INSTANCE = null;
            
            private RequestBatal() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel$UIEvent$RequestDraft;", "Lcom/bits/bee/bpmc/presentation/ui/pos/invoice/InvoiceViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestDraft extends com.bits.bee.bpmc.presentation.ui.pos.invoice.InvoiceViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pos.invoice.InvoiceViewModel.UIEvent.RequestDraft INSTANCE = null;
            
            private RequestDraft() {
                super();
            }
        }
    }
}