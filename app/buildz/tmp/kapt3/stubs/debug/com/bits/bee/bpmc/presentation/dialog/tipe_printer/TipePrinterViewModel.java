package com.bits.bee.bpmc.presentation.dialog.tipe_printer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0007B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\b"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/TipePrinterViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/ListTipe;", "Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/TipePrinterViewModel$UIEvent;", "()V", "OnClickLoadPrinter", "Lkotlinx/coroutines/Job;", "UIEvent", "app_debug"})
public final class TipePrinterViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.dialog.tipe_printer.ListTipe, com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterViewModel.UIEvent> {
    
    @javax.inject.Inject()
    public TipePrinterViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job OnClickLoadPrinter() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/TipePrinterViewModel$UIEvent;", "", "()V", "RequestSearchPrinterBluetooth", "Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/TipePrinterViewModel$UIEvent$RequestSearchPrinterBluetooth;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/TipePrinterViewModel$UIEvent$RequestSearchPrinterBluetooth;", "Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/TipePrinterViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestSearchPrinterBluetooth extends com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterViewModel.UIEvent.RequestSearchPrinterBluetooth INSTANCE = null;
            
            private RequestSearchPrinterBluetooth() {
                super();
            }
        }
    }
}