package com.bits.bee.bpmc.data.repository;

import java.lang.System;

/**
 * Created by aldi on 30/03/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/data/repository/UnitDummyRepositoryImpl;", "Lcom/bits/bee/bpmc/domain/repository/UnitDummyRepository;", "unitDummyDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UnitDummyDao;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bits/bee/bpmc/data/data_source/local/dao/UnitDummyDao;Lkotlinx/coroutines/CoroutineDispatcher;)V", "app_debug"})
public final class UnitDummyRepositoryImpl implements com.bits.bee.bpmc.domain.repository.UnitDummyRepository {
    private final com.bits.bee.bpmc.data.data_source.local.dao.UnitDummyDao unitDummyDao = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    
    @javax.inject.Inject()
    public UnitDummyRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.UnitDummyDao unitDummyDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher) {
        super();
    }
}