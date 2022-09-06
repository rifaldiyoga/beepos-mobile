package com.bits.bee.bpmc.domain.usecase.printer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\u00a8\u0006#"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/printer/PrinterInteractor;", "", "getPrinterFromPrinterKitchen", "Lcom/bits/bee/bpmc/domain/usecase/printer/GetPrinterFromPrinterKitchenUseCase;", "itemGrpId", "Lcom/bits/bee/bpmc/domain/usecase/printer/GetItemgrpIdUseCase;", "getLastId", "Lcom/bits/bee/bpmc/domain/usecase/printer/GetLastIdUseCase;", "getByPrinterUseCase", "Lcom/bits/bee/bpmc/domain/usecase/printer/GetByPrinterUseCase;", "deletePrinterKitchenD", "Lcom/bits/bee/bpmc/domain/usecase/printer/DeletePrinterKitchenDDUseCase;", "deletePrinterKit", "Lcom/bits/bee/bpmc/domain/usecase/printer/DeletePrinterKitchenUseCase;", "loadPrinter", "Lcom/bits/bee/bpmc/domain/usecase/printer/LoadPrinterUseCase;", "getItemgrpKitchen", "Lcom/bits/bee/bpmc/domain/usecase/printer/GetItemgrpKitchenUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/printer/GetPrinterFromPrinterKitchenUseCase;Lcom/bits/bee/bpmc/domain/usecase/printer/GetItemgrpIdUseCase;Lcom/bits/bee/bpmc/domain/usecase/printer/GetLastIdUseCase;Lcom/bits/bee/bpmc/domain/usecase/printer/GetByPrinterUseCase;Lcom/bits/bee/bpmc/domain/usecase/printer/DeletePrinterKitchenDDUseCase;Lcom/bits/bee/bpmc/domain/usecase/printer/DeletePrinterKitchenUseCase;Lcom/bits/bee/bpmc/domain/usecase/printer/LoadPrinterUseCase;Lcom/bits/bee/bpmc/domain/usecase/printer/GetItemgrpKitchenUseCase;)V", "getDeletePrinterKit", "()Lcom/bits/bee/bpmc/domain/usecase/printer/DeletePrinterKitchenUseCase;", "getDeletePrinterKitchenD", "()Lcom/bits/bee/bpmc/domain/usecase/printer/DeletePrinterKitchenDDUseCase;", "getGetByPrinterUseCase", "()Lcom/bits/bee/bpmc/domain/usecase/printer/GetByPrinterUseCase;", "getGetItemgrpKitchen", "()Lcom/bits/bee/bpmc/domain/usecase/printer/GetItemgrpKitchenUseCase;", "getGetLastId", "()Lcom/bits/bee/bpmc/domain/usecase/printer/GetLastIdUseCase;", "getGetPrinterFromPrinterKitchen", "()Lcom/bits/bee/bpmc/domain/usecase/printer/GetPrinterFromPrinterKitchenUseCase;", "getItemGrpId", "()Lcom/bits/bee/bpmc/domain/usecase/printer/GetItemgrpIdUseCase;", "getLoadPrinter", "()Lcom/bits/bee/bpmc/domain/usecase/printer/LoadPrinterUseCase;", "app_debug"})
public final class PrinterInteractor {
    @org.jetbrains.annotations.NotNull()
    private final com.bits.bee.bpmc.domain.usecase.printer.GetPrinterFromPrinterKitchenUseCase getPrinterFromPrinterKitchen = null;
    @org.jetbrains.annotations.NotNull()
    private final com.bits.bee.bpmc.domain.usecase.printer.GetItemgrpIdUseCase itemGrpId = null;
    @org.jetbrains.annotations.NotNull()
    private final com.bits.bee.bpmc.domain.usecase.printer.GetLastIdUseCase getLastId = null;
    @org.jetbrains.annotations.NotNull()
    private final com.bits.bee.bpmc.domain.usecase.printer.GetByPrinterUseCase getByPrinterUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.bits.bee.bpmc.domain.usecase.printer.DeletePrinterKitchenDDUseCase deletePrinterKitchenD = null;
    @org.jetbrains.annotations.NotNull()
    private final com.bits.bee.bpmc.domain.usecase.printer.DeletePrinterKitchenUseCase deletePrinterKit = null;
    @org.jetbrains.annotations.NotNull()
    private final com.bits.bee.bpmc.domain.usecase.printer.LoadPrinterUseCase loadPrinter = null;
    @org.jetbrains.annotations.NotNull()
    private final com.bits.bee.bpmc.domain.usecase.printer.GetItemgrpKitchenUseCase getItemgrpKitchen = null;
    
    @javax.inject.Inject()
    public PrinterInteractor(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.printer.GetPrinterFromPrinterKitchenUseCase getPrinterFromPrinterKitchen, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.printer.GetItemgrpIdUseCase itemGrpId, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.printer.GetLastIdUseCase getLastId, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.printer.GetByPrinterUseCase getByPrinterUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.printer.DeletePrinterKitchenDDUseCase deletePrinterKitchenD, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.printer.DeletePrinterKitchenUseCase deletePrinterKit, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.printer.LoadPrinterUseCase loadPrinter, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.printer.GetItemgrpKitchenUseCase getItemgrpKitchen) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.usecase.printer.GetPrinterFromPrinterKitchenUseCase getGetPrinterFromPrinterKitchen() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.usecase.printer.GetItemgrpIdUseCase getItemGrpId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.usecase.printer.GetLastIdUseCase getGetLastId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.usecase.printer.GetByPrinterUseCase getGetByPrinterUseCase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.usecase.printer.DeletePrinterKitchenDDUseCase getDeletePrinterKitchenD() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.usecase.printer.DeletePrinterKitchenUseCase getDeletePrinterKit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.usecase.printer.LoadPrinterUseCase getLoadPrinter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.usecase.printer.GetItemgrpKitchenUseCase getGetItemgrpKitchen() {
        return null;
    }
}