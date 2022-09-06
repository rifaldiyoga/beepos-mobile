package com.bits.bee.bpmc.presentation.ui.tambah_member;

import java.lang.System;

/**
 * Created by aldi on 22/04/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/tambah_member/TambahMemberViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/tambah_member/TambahMemberState;", "Lcom/bits/bee/bpmc/presentation/ui/tambah_member/TambahMemberViewModel$UIEvent;", "addUpdateMemberUseCase", "Lcom/bits/bee/bpmc/domain/usecase/member/AddUpdateMemberUseCase;", "getActivePriceLvlUseCase", "Lcom/bits/bee/bpmc/domain/usecase/member/GetActivePriceLvlUseCase;", "saveBpAddrUseCase", "Lcom/bits/bee/bpmc/domain/usecase/member/SaveBpAddrUseCase;", "getRegencyByCodeUseCase", "Lcom/bits/bee/bpmc/domain/usecase/member/GetRegencyByCodeUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/member/AddUpdateMemberUseCase;Lcom/bits/bee/bpmc/domain/usecase/member/GetActivePriceLvlUseCase;Lcom/bits/bee/bpmc/domain/usecase/member/SaveBpAddrUseCase;Lcom/bits/bee/bpmc/domain/usecase/member/GetRegencyByCodeUseCase;)V", "priceLvlList", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/bits/bee/bpmc/domain/model/PriceLvl;", "getPriceLvlList", "()Lkotlinx/coroutines/flow/Flow;", "setPriceLvlList", "(Lkotlinx/coroutines/flow/Flow;)V", "getRegency", "Lkotlinx/coroutines/Job;", "onClickIcon", "onClickInfoLainnya", "onClickKota", "onClickSimpan", "UIEvent", "app_debug"})
public final class TambahMemberViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.tambah_member.TambahMemberState, com.bits.bee.bpmc.presentation.ui.tambah_member.TambahMemberViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.member.AddUpdateMemberUseCase addUpdateMemberUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.member.GetActivePriceLvlUseCase getActivePriceLvlUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.member.SaveBpAddrUseCase saveBpAddrUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.member.GetRegencyByCodeUseCase getRegencyByCodeUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.Flow<? extends java.util.List<com.bits.bee.bpmc.domain.model.PriceLvl>> priceLvlList;
    
    @javax.inject.Inject()
    public TambahMemberViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.AddUpdateMemberUseCase addUpdateMemberUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.GetActivePriceLvlUseCase getActivePriceLvlUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.SaveBpAddrUseCase saveBpAddrUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.GetRegencyByCodeUseCase getRegencyByCodeUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.PriceLvl>> getPriceLvlList() {
        return null;
    }
    
    public final void setPriceLvlList(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<? extends java.util.List<com.bits.bee.bpmc.domain.model.PriceLvl>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickSimpan() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getRegency() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickInfoLainnya() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickKota() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickIcon() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/tambah_member/TambahMemberViewModel$UIEvent;", "", "()V", "RequestKota", "RequestTaxInfo", "SuccessAddMember", "Lcom/bits/bee/bpmc/presentation/ui/tambah_member/TambahMemberViewModel$UIEvent$RequestKota;", "Lcom/bits/bee/bpmc/presentation/ui/tambah_member/TambahMemberViewModel$UIEvent$RequestTaxInfo;", "Lcom/bits/bee/bpmc/presentation/ui/tambah_member/TambahMemberViewModel$UIEvent$SuccessAddMember;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/tambah_member/TambahMemberViewModel$UIEvent$SuccessAddMember;", "Lcom/bits/bee/bpmc/presentation/ui/tambah_member/TambahMemberViewModel$UIEvent;", "()V", "app_debug"})
        public static final class SuccessAddMember extends com.bits.bee.bpmc.presentation.ui.tambah_member.TambahMemberViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.tambah_member.TambahMemberViewModel.UIEvent.SuccessAddMember INSTANCE = null;
            
            private SuccessAddMember() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/tambah_member/TambahMemberViewModel$UIEvent$RequestKota;", "Lcom/bits/bee/bpmc/presentation/ui/tambah_member/TambahMemberViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestKota extends com.bits.bee.bpmc.presentation.ui.tambah_member.TambahMemberViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.tambah_member.TambahMemberViewModel.UIEvent.RequestKota INSTANCE = null;
            
            private RequestKota() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/tambah_member/TambahMemberViewModel$UIEvent$RequestTaxInfo;", "Lcom/bits/bee/bpmc/presentation/ui/tambah_member/TambahMemberViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestTaxInfo extends com.bits.bee.bpmc.presentation.ui.tambah_member.TambahMemberViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.tambah_member.TambahMemberViewModel.UIEvent.RequestTaxInfo INSTANCE = null;
            
            private RequestTaxInfo() {
                super();
            }
        }
    }
}