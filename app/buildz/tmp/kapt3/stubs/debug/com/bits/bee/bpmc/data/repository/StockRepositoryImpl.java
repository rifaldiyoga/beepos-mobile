package com.bits.bee.bpmc.data.repository;

import java.lang.System;

/**
 * Created by aldi on 30/03/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/bits/bee/bpmc/data/repository/StockRepositoryImpl;", "Lcom/bits/bee/bpmc/domain/repository/StockRepository;", "apiUtils", "Lcom/bits/bee/bpmc/data/data_source/remote/ApiUtils;", "stockDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/StockDao;", "(Lcom/bits/bee/bpmc/data/data_source/remote/ApiUtils;Lcom/bits/bee/bpmc/data/data_source/local/dao/StockDao;)V", "getStockByItem", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "", "Lcom/bits/bee/bpmc/domain/model/Stock;", "item", "Lcom/bits/bee/bpmc/domain/model/Item;", "wh", "Lcom/bits/bee/bpmc/domain/model/Wh;", "app_debug"})
public final class StockRepositoryImpl implements com.bits.bee.bpmc.domain.repository.StockRepository {
    private final com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils = null;
    private final com.bits.bee.bpmc.data.data_source.local.dao.StockDao stockDao = null;
    
    @javax.inject.Inject()
    public StockRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.StockDao stockDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Stock>>> getStockByItem(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Item item, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Wh wh) {
        return null;
    }
}