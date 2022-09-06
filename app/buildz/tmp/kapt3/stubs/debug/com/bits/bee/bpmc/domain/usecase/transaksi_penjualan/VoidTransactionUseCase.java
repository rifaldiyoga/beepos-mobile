package com.bits.bee.bpmc.domain.usecase.transaksi_penjualan;

import java.lang.System;

/**
 * Created by aldi on 11/08/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/transaksi_penjualan/VoidTransactionUseCase;", "", "saleRepository", "Lcom/bits/bee/bpmc/domain/repository/SaleRepository;", "(Lcom/bits/bee/bpmc/domain/repository/SaleRepository;)V", "invoke", "", "sale", "Lcom/bits/bee/bpmc/domain/model/Sale;", "(Lcom/bits/bee/bpmc/domain/model/Sale;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class VoidTransactionUseCase {
    private final com.bits.bee.bpmc.domain.repository.SaleRepository saleRepository = null;
    
    @javax.inject.Inject()
    public VoidTransactionUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.SaleRepository saleRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}