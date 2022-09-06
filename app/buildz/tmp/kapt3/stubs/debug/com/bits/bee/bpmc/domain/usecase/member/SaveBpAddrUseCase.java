package com.bits.bee.bpmc.domain.usecase.member;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ9\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010H\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/member/SaveBpAddrUseCase;", "", "cityRepository", "Lcom/bits/bee/bpmc/domain/repository/CityRepository;", "bpAddrRepository", "Lcom/bits/bee/bpmc/domain/repository/BpAddrRepository;", "bpRepository", "Lcom/bits/bee/bpmc/domain/repository/BpRepository;", "regencyRepository", "Lcom/bits/bee/bpmc/domain/repository/RegencyRepository;", "districtRepository", "Lcom/bits/bee/bpmc/domain/repository/DistrictRepository;", "(Lcom/bits/bee/bpmc/domain/repository/CityRepository;Lcom/bits/bee/bpmc/domain/repository/BpAddrRepository;Lcom/bits/bee/bpmc/domain/repository/BpRepository;Lcom/bits/bee/bpmc/domain/repository/RegencyRepository;Lcom/bits/bee/bpmc/domain/repository/DistrictRepository;)V", "city", "Lcom/bits/bee/bpmc/domain/model/City;", "district_code", "", "mBp", "Lcom/bits/bee/bpmc/domain/model/Bp;", "mDistrict", "Lcom/bits/bee/bpmc/domain/model/District;", "mListDistrict", "", "mRegency", "Lcom/bits/bee/bpmc/domain/model/Regency;", "province_code", "regency_code", "invoke", "", "kota", "bp", "noTelp", "email", "alamat", "(Ljava/lang/String;Lcom/bits/bee/bpmc/domain/model/Bp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SaveBpAddrUseCase {
    private final com.bits.bee.bpmc.domain.repository.CityRepository cityRepository = null;
    private final com.bits.bee.bpmc.domain.repository.BpAddrRepository bpAddrRepository = null;
    private final com.bits.bee.bpmc.domain.repository.BpRepository bpRepository = null;
    private final com.bits.bee.bpmc.domain.repository.RegencyRepository regencyRepository = null;
    private final com.bits.bee.bpmc.domain.repository.DistrictRepository districtRepository = null;
    private com.bits.bee.bpmc.domain.model.City city;
    private com.bits.bee.bpmc.domain.model.Bp mBp;
    private com.bits.bee.bpmc.domain.model.Regency mRegency;
    private com.bits.bee.bpmc.domain.model.District mDistrict;
    private java.util.List<com.bits.bee.bpmc.domain.model.District> mListDistrict;
    private java.lang.String province_code;
    private java.lang.String regency_code;
    private java.lang.String district_code;
    
    @javax.inject.Inject()
    public SaveBpAddrUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.CityRepository cityRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.BpAddrRepository bpAddrRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.BpRepository bpRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.RegencyRepository regencyRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.DistrictRepository districtRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String kota, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Bp bp, @org.jetbrains.annotations.NotNull()
    java.lang.String noTelp, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String alamat, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}