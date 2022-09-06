package com.bits.bee.bpmc.domain.usecase.member;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ#\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/member/GetListDistrictByCodeUseCase;", "", "regencyRepository", "Lcom/bits/bee/bpmc/domain/repository/RegencyRepository;", "districtRepository", "Lcom/bits/bee/bpmc/domain/repository/DistrictRepository;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bits/bee/bpmc/domain/repository/RegencyRepository;Lcom/bits/bee/bpmc/domain/repository/DistrictRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "mListDistrict", "", "Lcom/bits/bee/bpmc/domain/model/District;", "mRegency", "Lcom/bits/bee/bpmc/domain/model/Regency;", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "name", "", "app_debug"})
public final class GetListDistrictByCodeUseCase {
    private final com.bits.bee.bpmc.domain.repository.RegencyRepository regencyRepository = null;
    private final com.bits.bee.bpmc.domain.repository.DistrictRepository districtRepository = null;
    private final kotlinx.coroutines.CoroutineDispatcher defaultDispatcher = null;
    private com.bits.bee.bpmc.domain.model.Regency mRegency;
    private java.util.List<com.bits.bee.bpmc.domain.model.District> mListDistrict;
    
    @javax.inject.Inject()
    public GetListDistrictByCodeUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.RegencyRepository regencyRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.DistrictRepository districtRepository, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.District>>> invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
}