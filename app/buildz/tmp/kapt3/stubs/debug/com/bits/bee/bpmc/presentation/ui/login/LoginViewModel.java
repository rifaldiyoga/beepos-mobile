package com.bits.bee.bpmc.presentation.ui.login;

import java.lang.System;

/**
 * Created by aldi on 01/03/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\'B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150 J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020\"J\b\u0010%\u001a\u00020\"H\u0002J\u0006\u0010&\u001a\u00020\"R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006("}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "loginUseCase", "Lcom/bits/bee/bpmc/domain/usecase/login/LoginUseCase;", "context", "Landroid/content/Context;", "(Lcom/bits/bee/bpmc/domain/usecase/login/LoginUseCase;Landroid/content/Context;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bits/bee/bpmc/presentation/ui/login/LoginViewState;", "getContext", "()Landroid/content/Context;", "event", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/presentation/ui/login/LoginViewModel$UIEvent;", "getEvent", "()Lkotlinx/coroutines/flow/Flow;", "eventChannel", "Lkotlinx/coroutines/channels/Channel;", "loginResponse", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/bits/bee/bpmc/utils/Resource;", "Lcom/bits/bee/bpmc/data/data_source/remote/response/LoginResponse;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "setState", "(Lkotlinx/coroutines/flow/StateFlow;)V", "login", "", "observeLoginResponse", "Landroidx/lifecycle/LiveData;", "onClickLogin", "Lkotlinx/coroutines/Job;", "onSuccessLogin", "validateEmail", "validateInput", "validatePassword", "UIEvent", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    private final com.bits.bee.bpmc.domain.usecase.login.LoginUseCase loginUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final kotlinx.coroutines.channels.Channel<com.bits.bee.bpmc.presentation.ui.login.LoginViewModel.UIEvent> eventChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.presentation.ui.login.LoginViewModel.UIEvent> event = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.bits.bee.bpmc.presentation.ui.login.LoginViewState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.StateFlow<com.bits.bee.bpmc.presentation.ui.login.LoginViewState> state;
    private androidx.lifecycle.MediatorLiveData<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse>> loginResponse;
    
    @javax.inject.Inject()
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.login.LoginUseCase loginUseCase, @org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.presentation.ui.login.LoginViewModel.UIEvent> getEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.bits.bee.bpmc.presentation.ui.login.LoginViewState> getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.StateFlow<com.bits.bee.bpmc.presentation.ui.login.LoginViewState> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse>> observeLoginResponse() {
        return null;
    }
    
    public final void login() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job validateEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job validatePassword() {
        return null;
    }
    
    private final kotlinx.coroutines.Job validateInput() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickLogin() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onSuccessLogin() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/login/LoginViewModel$UIEvent;", "", "()V", "NavigateToNamaDevice", "RequestLogin", "Lcom/bits/bee/bpmc/presentation/ui/login/LoginViewModel$UIEvent$NavigateToNamaDevice;", "Lcom/bits/bee/bpmc/presentation/ui/login/LoginViewModel$UIEvent$RequestLogin;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/login/LoginViewModel$UIEvent$RequestLogin;", "Lcom/bits/bee/bpmc/presentation/ui/login/LoginViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestLogin extends com.bits.bee.bpmc.presentation.ui.login.LoginViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.login.LoginViewModel.UIEvent.RequestLogin INSTANCE = null;
            
            private RequestLogin() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/login/LoginViewModel$UIEvent$NavigateToNamaDevice;", "Lcom/bits/bee/bpmc/presentation/ui/login/LoginViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToNamaDevice extends com.bits.bee.bpmc.presentation.ui.login.LoginViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.login.LoginViewModel.UIEvent.NavigateToNamaDevice INSTANCE = null;
            
            private NavigateToNamaDevice() {
                super();
            }
        }
    }
}