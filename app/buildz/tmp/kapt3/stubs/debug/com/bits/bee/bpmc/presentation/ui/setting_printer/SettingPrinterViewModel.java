package com.bits.bee.bpmc.presentation.ui.setting_printer;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0014\u0010\u0015\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010\u0017\u001a\u00020\u0018R#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_printer/SettingPrinterViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/SettingPrinterState;", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/SettingPrinterViewModel$UIEvent;", "printerInteractor", "Lcom/bits/bee/bpmc/domain/usecase/printer/PrinterInteractor;", "(Lcom/bits/bee/bpmc/domain/usecase/printer/PrinterInteractor;)V", "loadPrinter", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "", "Lcom/bits/bee/bpmc/domain/model/Printer;", "getLoadPrinter", "()Lkotlinx/coroutines/flow/Flow;", "mPrinterInteractor", "printList", "", "checkDuplicatePrinter", "", "list", "get", "loadFromState", "data", "onClickAddPrinter", "Lkotlinx/coroutines/Job;", "UIEvent", "app_debug"})
public final class SettingPrinterViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.setting_printer.SettingPrinterState, com.bits.bee.bpmc.presentation.ui.setting_printer.SettingPrinterViewModel.UIEvent> {
    private java.util.List<com.bits.bee.bpmc.domain.model.Printer> printList;
    private com.bits.bee.bpmc.domain.usecase.printer.PrinterInteractor mPrinterInteractor;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Printer>>> loadPrinter = null;
    
    @javax.inject.Inject()
    public SettingPrinterViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.printer.PrinterInteractor printerInteractor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Printer>>> getLoadPrinter() {
        return null;
    }
    
    public final void loadFromState(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Printer> data) {
    }
    
    private final void checkDuplicatePrinter(java.util.List<com.bits.bee.bpmc.domain.model.Printer> list) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Printer> get() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickAddPrinter() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_printer/SettingPrinterViewModel$UIEvent;", "", "()V", "RequestAddPrinter", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/SettingPrinterViewModel$UIEvent$RequestAddPrinter;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_printer/SettingPrinterViewModel$UIEvent$RequestAddPrinter;", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/SettingPrinterViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestAddPrinter extends com.bits.bee.bpmc.presentation.ui.setting_printer.SettingPrinterViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_printer.SettingPrinterViewModel.UIEvent.RequestAddPrinter INSTANCE = null;
            
            private RequestAddPrinter() {
                super();
            }
        }
    }
}