package com.bits.bee.bpmc.presentation.dialog.detail_pendapatan;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0005B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/detail_pendapatan/DetailPendapatanViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/dialog/detail_pendapatan/DetailPendapatanState;", "Lcom/bits/bee/bpmc/presentation/dialog/detail_pendapatan/DetailPendapatanViewModel$UIEvent;", "()V", "UIEvent", "app_debug"})
public final class DetailPendapatanViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.dialog.detail_pendapatan.DetailPendapatanState, com.bits.bee.bpmc.presentation.dialog.detail_pendapatan.DetailPendapatanViewModel.UIEvent> {
    
    @javax.inject.Inject()
    public DetailPendapatanViewModel() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/detail_pendapatan/DetailPendapatanViewModel$UIEvent;", "", "()V", "RequestInfoTax", "Lcom/bits/bee/bpmc/presentation/dialog/detail_pendapatan/DetailPendapatanViewModel$UIEvent$RequestInfoTax;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/detail_pendapatan/DetailPendapatanViewModel$UIEvent$RequestInfoTax;", "Lcom/bits/bee/bpmc/presentation/dialog/detail_pendapatan/DetailPendapatanViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestInfoTax extends com.bits.bee.bpmc.presentation.dialog.detail_pendapatan.DetailPendapatanViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.dialog.detail_pendapatan.DetailPendapatanViewModel.UIEvent.RequestInfoTax INSTANCE = null;
            
            private RequestInfoTax() {
                super();
            }
        }
    }
}