package com.bits.bee.bpmc.data.repository;

import java.lang.System;

/**
 * Created by aldi on 13/07/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/bits/bee/bpmc/data/repository/InitialRepositoryImpl;", "Lcom/bits/bee/bpmc/domain/repository/InitialRepository;", "apiUtils", "Lcom/bits/bee/bpmc/data/data_source/remote/ApiUtils;", "cmpDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CmpDao;", "regDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/RegDao;", "userDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UserDao;", "usrGrpDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UsrGrpDao;", "grpPrvDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/GrpPrvDao;", "crcDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CrcDao;", "whDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/WhDao;", "(Lcom/bits/bee/bpmc/data/data_source/remote/ApiUtils;Lcom/bits/bee/bpmc/data/data_source/local/dao/CmpDao;Lcom/bits/bee/bpmc/data/data_source/local/dao/RegDao;Lcom/bits/bee/bpmc/data/data_source/local/dao/UserDao;Lcom/bits/bee/bpmc/data/data_source/local/dao/UsrGrpDao;Lcom/bits/bee/bpmc/data/data_source/local/dao/GrpPrvDao;Lcom/bits/bee/bpmc/data/data_source/local/dao/CrcDao;Lcom/bits/bee/bpmc/data/data_source/local/dao/WhDao;)V", "getInitialData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "", "app_debug"})
public final class InitialRepositoryImpl implements com.bits.bee.bpmc.domain.repository.InitialRepository {
    private final com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils = null;
    private final com.bits.bee.bpmc.data.data_source.local.dao.CmpDao cmpDao = null;
    private final com.bits.bee.bpmc.data.data_source.local.dao.RegDao regDao = null;
    private final com.bits.bee.bpmc.data.data_source.local.dao.UserDao userDao = null;
    private final com.bits.bee.bpmc.data.data_source.local.dao.UsrGrpDao usrGrpDao = null;
    private final com.bits.bee.bpmc.data.data_source.local.dao.GrpPrvDao grpPrvDao = null;
    private final com.bits.bee.bpmc.data.data_source.local.dao.CrcDao crcDao = null;
    private final com.bits.bee.bpmc.data.data_source.local.dao.WhDao whDao = null;
    
    @javax.inject.Inject()
    public InitialRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CmpDao cmpDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.RegDao regDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.UsrGrpDao usrGrpDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.GrpPrvDao grpPrvDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CrcDao crcDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.WhDao whDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.lang.Object>> getInitialData() {
        return null;
    }
}