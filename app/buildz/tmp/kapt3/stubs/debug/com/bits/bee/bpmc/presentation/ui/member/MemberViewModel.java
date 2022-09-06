package com.bits.bee.bpmc.presentation.ui.member;

import java.lang.System;

/**
 * Created by aldi on 22/04/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017R#\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/member/MemberViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/member/MemberState;", "Lcom/bits/bee/bpmc/presentation/ui/member/MemberViewModel$UIEvent;", "memberInteractor", "Lcom/bits/bee/bpmc/domain/usecase/member/MemberInteractor;", "searchMemberUseCase", "Lcom/bits/bee/bpmc/domain/usecase/member/SearchMemberUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/member/MemberInteractor;Lcom/bits/bee/bpmc/domain/usecase/member/SearchMemberUseCase;)V", "memberList", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "", "Lcom/bits/bee/bpmc/domain/model/Bp;", "getMemberList", "()Lkotlinx/coroutines/flow/Flow;", "onClickAddMember", "Lkotlinx/coroutines/Job;", "onClickDetailMember", "model", "onClickEye", "onSearch", "query", "", "UIEvent", "app_debug"})
public final class MemberViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.member.MemberState, com.bits.bee.bpmc.presentation.ui.member.MemberViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.member.SearchMemberUseCase searchMemberUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Bp>>> memberList = null;
    
    @javax.inject.Inject()
    public MemberViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.MemberInteractor memberInteractor, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.member.SearchMemberUseCase searchMemberUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Bp>>> getMemberList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickDetailMember(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Bp model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickEye(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Bp model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickAddMember() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/member/MemberViewModel$UIEvent;", "", "()V", "RequestAddMember", "RequestIconEye", "RequestPos", "Lcom/bits/bee/bpmc/presentation/ui/member/MemberViewModel$UIEvent$RequestAddMember;", "Lcom/bits/bee/bpmc/presentation/ui/member/MemberViewModel$UIEvent$RequestIconEye;", "Lcom/bits/bee/bpmc/presentation/ui/member/MemberViewModel$UIEvent$RequestPos;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/member/MemberViewModel$UIEvent$RequestAddMember;", "Lcom/bits/bee/bpmc/presentation/ui/member/MemberViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestAddMember extends com.bits.bee.bpmc.presentation.ui.member.MemberViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.member.MemberViewModel.UIEvent.RequestAddMember INSTANCE = null;
            
            private RequestAddMember() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/member/MemberViewModel$UIEvent$RequestPos;", "Lcom/bits/bee/bpmc/presentation/ui/member/MemberViewModel$UIEvent;", "model", "Lcom/bits/bee/bpmc/domain/model/Bp;", "(Lcom/bits/bee/bpmc/domain/model/Bp;)V", "getModel", "()Lcom/bits/bee/bpmc/domain/model/Bp;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class RequestPos extends com.bits.bee.bpmc.presentation.ui.member.MemberViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            private final com.bits.bee.bpmc.domain.model.Bp model = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.presentation.ui.member.MemberViewModel.UIEvent.RequestPos copy(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Bp model) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            public RequestPos(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Bp model) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Bp component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Bp getModel() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/member/MemberViewModel$UIEvent$RequestIconEye;", "Lcom/bits/bee/bpmc/presentation/ui/member/MemberViewModel$UIEvent;", "model", "Lcom/bits/bee/bpmc/domain/model/Bp;", "(Lcom/bits/bee/bpmc/domain/model/Bp;)V", "getModel", "()Lcom/bits/bee/bpmc/domain/model/Bp;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class RequestIconEye extends com.bits.bee.bpmc.presentation.ui.member.MemberViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            private final com.bits.bee.bpmc.domain.model.Bp model = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.presentation.ui.member.MemberViewModel.UIEvent.RequestIconEye copy(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Bp model) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            public RequestIconEye(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Bp model) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Bp component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Bp getModel() {
                return null;
            }
        }
    }
}