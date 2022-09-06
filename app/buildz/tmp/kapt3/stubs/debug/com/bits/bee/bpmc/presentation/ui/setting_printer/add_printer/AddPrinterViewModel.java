package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B\'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u001c\u001a\u00020\u0015J\u0006\u0010\u001d\u001a\u00020\u0015J,\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0010\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010 R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_printer/add_printer/AddPrinterViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/add_printer/AddPrinterState;", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/add_printer/AddPrinterViewModel$UIEvent;", "printerInteractor", "Lcom/bits/bee/bpmc/domain/usecase/printer/PrinterInteractor;", "savePrinterUseCase", "Lcom/bits/bee/bpmc/domain/usecase/printer/SavePrinterUseCase;", "getListKitchenUseCase", "Lcom/bits/bee/bpmc/domain/usecase/printer/GetListKitchenUseCase;", "getKategoriPrinterKitchenUseCase", "Lcom/bits/bee/bpmc/domain/usecase/printer/GetKategoriPrinterKitchenUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/printer/PrinterInteractor;Lcom/bits/bee/bpmc/domain/usecase/printer/SavePrinterUseCase;Lcom/bits/bee/bpmc/domain/usecase/printer/GetListKitchenUseCase;Lcom/bits/bee/bpmc/domain/usecase/printer/GetKategoriPrinterKitchenUseCase;)V", "data_kitchen", "", "listKitchen", "", "Lcom/bits/bee/bpmc/domain/model/Kitchen;", "sectionKitchenAdapter", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/printer_kitchen/SectionKitchenAdapter;", "clearPrinterKitchen", "Lkotlinx/coroutines/Job;", "id", "", "deletePrinterKit", "printK", "Lcom/bits/bee/bpmc/domain/model/PrinterKitchen;", "deletePrinterKitD", "loadKategoriPrinterKit", "onClickShowPrinter", "save", "printer", "Lcom/bits/bee/bpmc/domain/model/Printer;", "printerKitchenList", "", "mListKitchen", "setPrinterKitchen", "mPrinter", "UIEvent", "app_debug"})
public final class AddPrinterViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer.AddPrinterState, com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer.AddPrinterViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.printer.PrinterInteractor printerInteractor = null;
    private final com.bits.bee.bpmc.domain.usecase.printer.SavePrinterUseCase savePrinterUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.printer.GetListKitchenUseCase getListKitchenUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.printer.GetKategoriPrinterKitchenUseCase getKategoriPrinterKitchenUseCase = null;
    private com.bits.bee.bpmc.presentation.ui.setting_printer.printer_kitchen.SectionKitchenAdapter sectionKitchenAdapter;
    private boolean data_kitchen = false;
    private java.util.List<com.bits.bee.bpmc.domain.model.Kitchen> listKitchen;
    
    @javax.inject.Inject()
    public AddPrinterViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.printer.PrinterInteractor printerInteractor, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.printer.SavePrinterUseCase savePrinterUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.printer.GetListKitchenUseCase getListKitchenUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.printer.GetKategoriPrinterKitchenUseCase getKategoriPrinterKitchenUseCase) {
        super();
    }
    
    private final kotlinx.coroutines.Job deletePrinterKitD(int id) {
        return null;
    }
    
    private final kotlinx.coroutines.Job deletePrinterKit(com.bits.bee.bpmc.domain.model.PrinterKitchen printK) {
        return null;
    }
    
    private final kotlinx.coroutines.Job clearPrinterKitchen(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setPrinterKitchen(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Printer mPrinter) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickShowPrinter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job save(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Printer printer, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.PrinterKitchen> printerKitchenList, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Kitchen> mListKitchen) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadKategoriPrinterKit() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_printer/add_printer/AddPrinterViewModel$UIEvent;", "", "()V", "RequestSimpan", "RequestTipePrinter", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/add_printer/AddPrinterViewModel$UIEvent$RequestSimpan;", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/add_printer/AddPrinterViewModel$UIEvent$RequestTipePrinter;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_printer/add_printer/AddPrinterViewModel$UIEvent$RequestTipePrinter;", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/add_printer/AddPrinterViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestTipePrinter extends com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer.AddPrinterViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer.AddPrinterViewModel.UIEvent.RequestTipePrinter INSTANCE = null;
            
            private RequestTipePrinter() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_printer/add_printer/AddPrinterViewModel$UIEvent$RequestSimpan;", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/add_printer/AddPrinterViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestSimpan extends com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer.AddPrinterViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer.AddPrinterViewModel.UIEvent.RequestSimpan INSTANCE = null;
            
            private RequestSimpan() {
                super();
            }
        }
    }
}