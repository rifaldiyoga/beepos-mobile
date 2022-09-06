package com.bits.bee.bpmc.domain.usecase.printer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J7\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/printer/SavePrinterUseCase;", "", "printerRepo", "Lcom/bits/bee/bpmc/domain/repository/PrinterRespository;", "printerKitchenRepo", "Lcom/bits/bee/bpmc/domain/repository/PrinterKitchenRepository;", "printerKitchenDRepo", "Lcom/bits/bee/bpmc/domain/repository/PrinterKitchenDRepository;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bits/bee/bpmc/domain/repository/PrinterRespository;Lcom/bits/bee/bpmc/domain/repository/PrinterKitchenRepository;Lcom/bits/bee/bpmc/domain/repository/PrinterKitchenDRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "mlistPrinter", "", "Lcom/bits/bee/bpmc/domain/model/Printer;", "mlistPrinterKitchen", "Lcom/bits/bee/bpmc/domain/model/PrinterKitchen;", "mprinter", "mprinterKitchen", "clearPrinterKitchen", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "printer", "printerKitchenList", "mListKitchen", "", "Lcom/bits/bee/bpmc/domain/model/Kitchen;", "(Lcom/bits/bee/bpmc/domain/model/Printer;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SavePrinterUseCase {
    private final com.bits.bee.bpmc.domain.repository.PrinterRespository printerRepo = null;
    private final com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository printerKitchenRepo = null;
    private final com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository printerKitchenDRepo = null;
    private final kotlinx.coroutines.CoroutineDispatcher defaultDispatcher = null;
    private java.util.List<com.bits.bee.bpmc.domain.model.Printer> mlistPrinter;
    private com.bits.bee.bpmc.domain.model.Printer mprinter;
    private com.bits.bee.bpmc.domain.model.PrinterKitchen mprinterKitchen;
    private java.util.List<com.bits.bee.bpmc.domain.model.PrinterKitchen> mlistPrinterKitchen;
    
    @javax.inject.Inject()
    public SavePrinterUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.PrinterRespository printerRepo, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository printerKitchenRepo, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository printerKitchenDRepo, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Printer printer, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.PrinterKitchen> printerKitchenList, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Kitchen> mListKitchen, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object clearPrinterKitchen(int id, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}