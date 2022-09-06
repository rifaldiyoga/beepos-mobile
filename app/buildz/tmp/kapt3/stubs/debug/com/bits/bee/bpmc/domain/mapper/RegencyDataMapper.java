package com.bits.bee.bpmc.domain.mapper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/bits/bee/bpmc/domain/mapper/RegencyDataMapper;", "Lcom/bits/bee/bpmc/domain/mapper/BaseMapper;", "Lcom/bits/bee/bpmc/data/data_source/local/model/RegencyEntity;", "Lcom/bits/bee/bpmc/domain/model/Regency;", "Lcom/bits/bee/bpmc/data/data_source/remote/response/RegencyResponse$RegencyModel;", "()V", "fromDbToDomain", "model", "fromDomainToDb", "fromNetworkToDb", "fromResponseToData", "app_debug"})
public final class RegencyDataMapper extends com.bits.bee.bpmc.domain.mapper.BaseMapper<com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity, com.bits.bee.bpmc.domain.model.Regency, com.bits.bee.bpmc.data.data_source.remote.response.RegencyResponse.RegencyModel> {
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.domain.mapper.RegencyDataMapper INSTANCE = null;
    
    private RegencyDataMapper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.bits.bee.bpmc.domain.model.Regency fromDbToDomain(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity fromDomainToDb(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Regency model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity fromResponseToData(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.response.RegencyResponse.RegencyModel model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity fromNetworkToDb(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.response.RegencyResponse.RegencyModel model) {
        return null;
    }
}