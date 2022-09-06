package com.bits.bee.bpmc.domain.usecase.transaksi_penjualan;

import java.lang.System;

/**
 * Created by aldi on 23/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/transaksi_penjualan/GetLatestSaleUseCase;", "", "saleRepository", "Lcom/bits/bee/bpmc/domain/repository/SaleRepository;", "(Lcom/bits/bee/bpmc/domain/repository/SaleRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/bits/bee/bpmc/domain/model/Sale;", "query", "", "isDraft", "", "app_debug"})
public final class GetLatestSaleUseCase {
    private final com.bits.bee.bpmc.domain.repository.SaleRepository saleRepository = null;
    
    @javax.inject.Inject()
    public GetLatestSaleUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.SaleRepository saleRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Sale>> invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String query, boolean isDraft) {
        return null;
    }
}