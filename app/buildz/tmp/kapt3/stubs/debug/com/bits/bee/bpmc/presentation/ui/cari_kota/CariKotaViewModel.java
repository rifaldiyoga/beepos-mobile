package com.bits.bee.bpmc.presentation.ui.cari_kota;

import java.lang.System;

/**
 * Created by aldi on 13/05/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0016J\u0006\u0010\u001d\u001a\u00020\u0016R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/cari_kota/CariKotaViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/cari_kota/CariKotaState;", "Lcom/bits/bee/bpmc/presentation/ui/cari_kota/CariKotaViewModel$UIEvent;", "getActiveCityUseCase", "Lcom/bits/bee/bpmc/domain/usecase/member/GetActiveCityUseCase;", "searchActiveCityUseCase", "Lcom/bits/bee/bpmc/domain/usecase/member/SearchActiveCityUseCase;", "saveCityUseCase", "Lcom/bits/bee/bpmc/domain/usecase/member/SaveCityUseCase;", "searchActiveRegencyUseCase", "Lcom/bits/bee/bpmc/domain/usecase/member/SearchActiveRegencyUseCase;", "getCityPopulerUseCase", "Lcom/bits/bee/bpmc/domain/usecase/member/GetCityPopularUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/member/GetActiveCityUseCase;Lcom/bits/bee/bpmc/domain/usecase/member/SearchActiveCityUseCase;Lcom/bits/bee/bpmc/domain/usecase/member/SaveCityUseCase;Lcom/bits/bee/bpmc/domain/usecase/member/SearchActiveRegencyUseCase;Lcom/bits/bee/bpmc/domain/usecase/member/GetCityPopularUseCase;)V", "cityPopuler", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/bits/bee/bpmc/domain/model/CityPopuler;", "getCityPopuler", "()Lkotlinx/coroutines/flow/Flow;", "onGetList", "Lkotlinx/coroutines/Job;", "cityListCari", "Lcom/bits/bee/bpmc/domain/model/City;", "onSearch", "query", "", "saveValidate", "searchCity", "UIEvent", "app_debug"})
public final class CariKotaViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.cari_kota.CariKotaState, com.bits.bee.bpmc.presentation.ui.cari_kota.CariKotaViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.member.GetActiveCityUseCase getActiveCityUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.member.SearchActiveCityUseCase searchActiveCityUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.member.SaveCityUseCase saveCityUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.member.SearchActiveRegencyUseCase searchActiveRegencyUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.member.GetCityPopularUseCase getCityPopulerUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.CityPopuler>> cityPopuler = null;
    
    @javax.inject.Inject()
    public CariKotaViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.GetActiveCityUseCase getActiveCityUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.SearchActiveCityUseCase searchActiveCityUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.SaveCityUseCase saveCityUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.SearchActiveRegencyUseCase searchActiveRegencyUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.GetCityPopularUseCase getCityPopulerUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.CityPopuler>> getCityPopuler() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job searchCity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onGetList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.City> cityListCari) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job saveValidate() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/cari_kota/CariKotaViewModel$UIEvent;", "", "()V", "SuccesSaveCity", "Lcom/bits/bee/bpmc/presentation/ui/cari_kota/CariKotaViewModel$UIEvent$SuccesSaveCity;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/cari_kota/CariKotaViewModel$UIEvent$SuccesSaveCity;", "Lcom/bits/bee/bpmc/presentation/ui/cari_kota/CariKotaViewModel$UIEvent;", "()V", "app_debug"})
        public static final class SuccesSaveCity extends com.bits.bee.bpmc.presentation.ui.cari_kota.CariKotaViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.cari_kota.CariKotaViewModel.UIEvent.SuccesSaveCity INSTANCE = null;
            
            private SuccesSaveCity() {
                super();
            }
        }
    }
}