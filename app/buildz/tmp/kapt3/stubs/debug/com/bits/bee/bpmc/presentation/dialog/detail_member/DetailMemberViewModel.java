package com.bits.bee.bpmc.presentation.dialog.detail_member;

import java.lang.System;

/**
 * Created by aldi on 27/04/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u001f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/detail_member/DetailMemberViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/dialog/detail_member/DetailMemberState;", "Lcom/bits/bee/bpmc/presentation/dialog/detail_member/DetailMemberViewModel$UIEvent;", "getBpAddrByBpUseCase", "Lcom/bits/bee/bpmc/domain/usecase/member/GetBpAddrByBpUseCase;", "getRegencyByCodeUseCase", "Lcom/bits/bee/bpmc/domain/usecase/member/GetRegencyByCodeUseCase;", "getDistrictByCodeUseCase", "Lcom/bits/bee/bpmc/domain/usecase/member/GetDistrictByCodeUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/member/GetBpAddrByBpUseCase;Lcom/bits/bee/bpmc/domain/usecase/member/GetRegencyByCodeUseCase;Lcom/bits/bee/bpmc/domain/usecase/member/GetDistrictByCodeUseCase;)V", "getBpaddr", "Lkotlinx/coroutines/Job;", "setOnClickInfo", "setOnClickInfoTax", "update", "data", "Lcom/bits/bee/bpmc/domain/model/Bp;", "UIEvent", "app_debug"})
public final class DetailMemberViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.dialog.detail_member.DetailMemberState, com.bits.bee.bpmc.presentation.dialog.detail_member.DetailMemberViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.member.GetBpAddrByBpUseCase getBpAddrByBpUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.member.GetRegencyByCodeUseCase getRegencyByCodeUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.member.GetDistrictByCodeUseCase getDistrictByCodeUseCase = null;
    
    @javax.inject.Inject()
    public DetailMemberViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.GetBpAddrByBpUseCase getBpAddrByBpUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.GetRegencyByCodeUseCase getRegencyByCodeUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.GetDistrictByCodeUseCase getDistrictByCodeUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setOnClickInfoTax() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setOnClickInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job update(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Bp data) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getBpaddr() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/detail_member/DetailMemberViewModel$UIEvent;", "", "()V", "RequestInfoTax", "Lcom/bits/bee/bpmc/presentation/dialog/detail_member/DetailMemberViewModel$UIEvent$RequestInfoTax;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/detail_member/DetailMemberViewModel$UIEvent$RequestInfoTax;", "Lcom/bits/bee/bpmc/presentation/dialog/detail_member/DetailMemberViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestInfoTax extends com.bits.bee.bpmc.presentation.dialog.detail_member.DetailMemberViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.dialog.detail_member.DetailMemberViewModel.UIEvent.RequestInfoTax INSTANCE = null;
            
            private RequestInfoTax() {
                super();
            }
        }
    }
}