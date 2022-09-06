package com.bits.bee.bpmc.presentation.ui.sign_up.info_kontak;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/info_kontak/InfoKontakViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/info_kontak/InfoKontakState;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/info_kontak/InfoKontakViewModel$UIEvent;", "postSignUpUseCase", "Lcom/bits/bee/bpmc/domain/usecase/signup/PostSignUpUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/signup/PostSignUpUseCase;)V", "registerResponse", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/bits/bee/bpmc/utils/Resource;", "Lcom/bits/bee/bpmc/data/data_source/remote/response/SignUpResponse;", "observeSignUpResponse", "Landroidx/lifecycle/LiveData;", "onClickLanjut", "Lkotlinx/coroutines/Job;", "onSuccesLanjut", "postSignUp", "", "validateInput", "UIEvent", "app_debug"})
public final class InfoKontakViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.sign_up.info_kontak.InfoKontakState, com.bits.bee.bpmc.presentation.ui.sign_up.info_kontak.InfoKontakViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.signup.PostSignUpUseCase postSignUpUseCase = null;
    private androidx.lifecycle.MediatorLiveData<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.data.data_source.remote.response.SignUpResponse>> registerResponse;
    
    @javax.inject.Inject()
    public InfoKontakViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.signup.PostSignUpUseCase postSignUpUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.data.data_source.remote.response.SignUpResponse>> observeSignUpResponse() {
        return null;
    }
    
    public final void postSignUp() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job validateInput() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickLanjut() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onSuccesLanjut() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/info_kontak/InfoKontakViewModel$UIEvent;", "", "()V", "NavigateToOtp", "RequestInfoKontak", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/info_kontak/InfoKontakViewModel$UIEvent$NavigateToOtp;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/info_kontak/InfoKontakViewModel$UIEvent$RequestInfoKontak;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/info_kontak/InfoKontakViewModel$UIEvent$RequestInfoKontak;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/info_kontak/InfoKontakViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestInfoKontak extends com.bits.bee.bpmc.presentation.ui.sign_up.info_kontak.InfoKontakViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.sign_up.info_kontak.InfoKontakViewModel.UIEvent.RequestInfoKontak INSTANCE = null;
            
            private RequestInfoKontak() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/info_kontak/InfoKontakViewModel$UIEvent$NavigateToOtp;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/info_kontak/InfoKontakViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToOtp extends com.bits.bee.bpmc.presentation.ui.sign_up.info_kontak.InfoKontakViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.sign_up.info_kontak.InfoKontakViewModel.UIEvent.NavigateToOtp INSTANCE = null;
            
            private NavigateToOtp() {
                super();
            }
        }
    }
}