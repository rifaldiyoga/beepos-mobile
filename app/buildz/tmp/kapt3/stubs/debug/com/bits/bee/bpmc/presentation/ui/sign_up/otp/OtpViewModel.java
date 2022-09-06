package com.bits.bee.bpmc.presentation.ui.sign_up.otp;

import java.lang.System;

/**
 * Created by aldi on 30/08/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/otp/OtpViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/otp/OtpState;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/otp/OtpViewModel$UIEvent;", "()V", "onInputPin", "Lkotlinx/coroutines/Job;", "pin", "", "UIEvent", "app_debug"})
public final class OtpViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.sign_up.otp.OtpState, com.bits.bee.bpmc.presentation.ui.sign_up.otp.OtpViewModel.UIEvent> {
    
    public OtpViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onInputPin(@org.jetbrains.annotations.NotNull()
    java.lang.String pin) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/otp/OtpViewModel$UIEvent;", "", "()V", "NavigateToAturPin", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/otp/OtpViewModel$UIEvent$NavigateToAturPin;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/otp/OtpViewModel$UIEvent$NavigateToAturPin;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/otp/OtpViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToAturPin extends com.bits.bee.bpmc.presentation.ui.sign_up.otp.OtpViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.sign_up.otp.OtpViewModel.UIEvent.NavigateToAturPin INSTANCE = null;
            
            private NavigateToAturPin() {
                super();
            }
        }
    }
}