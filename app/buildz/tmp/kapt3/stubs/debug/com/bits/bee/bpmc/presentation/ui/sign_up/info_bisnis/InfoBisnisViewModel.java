package com.bits.bee.bpmc.presentation.ui.sign_up.info_bisnis;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u0013J\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\u0013J\u0006\u0010\u0015\u001a\u00020\u0011R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/info_bisnis/InfoBisnisViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/info_bisnis/InfoBisnisState;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/info_bisnis/InfoBisnisViewModel$UIEvent;", "cityInteractor", "Lcom/bits/bee/bpmc/domain/usecase/CityInteractor;", "postSignUpUseCase", "Lcom/bits/bee/bpmc/domain/usecase/signup/PostSignUpUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/CityInteractor;Lcom/bits/bee/bpmc/domain/usecase/signup/PostSignUpUseCase;)V", "cityEntityResponse", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/bits/bee/bpmc/utils/Resource;", "", "Lcom/bits/bee/bpmc/domain/model/City;", "registerResponse", "Lcom/bits/bee/bpmc/data/data_source/remote/response/SignUpResponse;", "getCityList", "", "observeListCity", "Landroidx/lifecycle/LiveData;", "observeSignUpResponse", "postSignUp", "UIEvent", "app_debug"})
public final class InfoBisnisViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.sign_up.info_bisnis.InfoBisnisState, com.bits.bee.bpmc.presentation.ui.sign_up.info_bisnis.InfoBisnisViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.CityInteractor cityInteractor = null;
    private final com.bits.bee.bpmc.domain.usecase.signup.PostSignUpUseCase postSignUpUseCase = null;
    private androidx.lifecycle.MediatorLiveData<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.City>>> cityEntityResponse;
    private androidx.lifecycle.MediatorLiveData<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.data.data_source.remote.response.SignUpResponse>> registerResponse;
    
    @javax.inject.Inject()
    public InfoBisnisViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.CityInteractor cityInteractor, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.signup.PostSignUpUseCase postSignUpUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.City>>> observeListCity() {
        return null;
    }
    
    public final void getCityList() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.data.data_source.remote.response.SignUpResponse>> observeSignUpResponse() {
        return null;
    }
    
    public final void postSignUp() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/info_bisnis/InfoBisnisViewModel$UIEvent;", "", "()V", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
    }
}