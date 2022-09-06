package com.bits.bee.bpmc.presentation.ui.cari_kecamatan;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/cari_kecamatan/CariKecamatanViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/cari_kecamatan/CariKecamatanState;", "Lcom/bits/bee/bpmc/presentation/ui/cari_kecamatan/CariKecamatanViewModel$UIEvent;", "getListDistrictByCodeUseCase", "Lcom/bits/bee/bpmc/domain/usecase/member/GetListDistrictByCodeUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/member/GetListDistrictByCodeUseCase;)V", "getDistrictByCode", "Lkotlinx/coroutines/Job;", "UIEvent", "app_debug"})
public final class CariKecamatanViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.cari_kecamatan.CariKecamatanState, com.bits.bee.bpmc.presentation.ui.cari_kecamatan.CariKecamatanViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.member.GetListDistrictByCodeUseCase getListDistrictByCodeUseCase = null;
    
    @javax.inject.Inject()
    public CariKecamatanViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.GetListDistrictByCodeUseCase getListDistrictByCodeUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getDistrictByCode() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/cari_kecamatan/CariKecamatanViewModel$UIEvent;", "", "()V", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
    }
}