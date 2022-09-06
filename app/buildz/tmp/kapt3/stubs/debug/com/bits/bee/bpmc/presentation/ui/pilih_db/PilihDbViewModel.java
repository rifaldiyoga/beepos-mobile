package com.bits.bee.bpmc.presentation.ui.pilih_db;

import java.lang.System;

/**
 * Created by aldi on 04/03/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0017J\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000b0\u0017J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000b0\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pilih_db/PilihDbViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/pilih_db/PilihDbState;", "Lcom/bits/bee/bpmc/presentation/ui/pilih_db/PilihDbViewModel$UIEvent;", "loginUseCase", "Lcom/bits/bee/bpmc/domain/usecase/login/LoginUseCase;", "initialUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/InitialUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/login/LoginUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/InitialUseCase;)V", "initial", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "", "getInitial", "()Lkotlinx/coroutines/flow/Flow;", "initialResponse", "Landroidx/lifecycle/MediatorLiveData;", "loginResponse", "Lcom/bits/bee/bpmc/data/data_source/remote/response/LoginResponse;", "initialData", "", "login", "observeInitialResponse", "Landroidx/lifecycle/LiveData;", "observeLoginResponse", "onClickDb", "Lkotlinx/coroutines/Job;", "onSuccessDb", "UIEvent", "app_debug"})
public final class PilihDbViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.pilih_db.PilihDbState, com.bits.bee.bpmc.presentation.ui.pilih_db.PilihDbViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.login.LoginUseCase loginUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.InitialUseCase initialUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.lang.Object>> initial = null;
    private androidx.lifecycle.MediatorLiveData<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse>> loginResponse;
    private androidx.lifecycle.MediatorLiveData<com.bits.bee.bpmc.utils.Resource<java.lang.Object>> initialResponse;
    
    @javax.inject.Inject()
    public PilihDbViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.login.LoginUseCase loginUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.InitialUseCase initialUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.lang.Object>> getInitial() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse>> observeLoginResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bits.bee.bpmc.utils.Resource<java.lang.Object>> observeInitialResponse() {
        return null;
    }
    
    public final void login() {
    }
    
    public final void initialData() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onSuccessDb() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pilih_db/PilihDbViewModel$UIEvent;", "", "()V", "NavigateToPilihMode", "RequestDb", "Lcom/bits/bee/bpmc/presentation/ui/pilih_db/PilihDbViewModel$UIEvent$NavigateToPilihMode;", "Lcom/bits/bee/bpmc/presentation/ui/pilih_db/PilihDbViewModel$UIEvent$RequestDb;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pilih_db/PilihDbViewModel$UIEvent$NavigateToPilihMode;", "Lcom/bits/bee/bpmc/presentation/ui/pilih_db/PilihDbViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToPilihMode extends com.bits.bee.bpmc.presentation.ui.pilih_db.PilihDbViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pilih_db.PilihDbViewModel.UIEvent.NavigateToPilihMode INSTANCE = null;
            
            private NavigateToPilihMode() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pilih_db/PilihDbViewModel$UIEvent$RequestDb;", "Lcom/bits/bee/bpmc/presentation/ui/pilih_db/PilihDbViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestDb extends com.bits.bee.bpmc.presentation.ui.pilih_db.PilihDbViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pilih_db.PilihDbViewModel.UIEvent.RequestDb INSTANCE = null;
            
            private RequestDb() {
                super();
            }
        }
    }
}