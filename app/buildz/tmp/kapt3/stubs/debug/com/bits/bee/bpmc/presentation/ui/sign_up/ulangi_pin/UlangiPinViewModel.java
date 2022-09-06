package com.bits.bee.bpmc.presentation.ui.sign_up.ulangi_pin;

import java.lang.System;

/**
 * Created by aldi on 30/08/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\u000b"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/ulangi_pin/UlangiPinViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/ulangi_pin/UlangiPinState;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/ulangi_pin/UlangiPinViewModel$UIEvent;", "()V", "onPinFilled", "Lkotlinx/coroutines/Job;", "onPinInput", "pin", "", "UIEvent", "app_debug"})
public final class UlangiPinViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.sign_up.ulangi_pin.UlangiPinState, com.bits.bee.bpmc.presentation.ui.sign_up.ulangi_pin.UlangiPinViewModel.UIEvent> {
    
    public UlangiPinViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onPinInput(@org.jetbrains.annotations.NotNull()
    java.lang.String pin) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onPinFilled() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/ulangi_pin/UlangiPinViewModel$UIEvent;", "", "()V", "NavigateToAturProduk", "PinNotSame", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/ulangi_pin/UlangiPinViewModel$UIEvent$NavigateToAturProduk;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/ulangi_pin/UlangiPinViewModel$UIEvent$PinNotSame;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/ulangi_pin/UlangiPinViewModel$UIEvent$NavigateToAturProduk;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/ulangi_pin/UlangiPinViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToAturProduk extends com.bits.bee.bpmc.presentation.ui.sign_up.ulangi_pin.UlangiPinViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.sign_up.ulangi_pin.UlangiPinViewModel.UIEvent.NavigateToAturProduk INSTANCE = null;
            
            private NavigateToAturProduk() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/sign_up/ulangi_pin/UlangiPinViewModel$UIEvent$PinNotSame;", "Lcom/bits/bee/bpmc/presentation/ui/sign_up/ulangi_pin/UlangiPinViewModel$UIEvent;", "()V", "app_debug"})
        public static final class PinNotSame extends com.bits.bee.bpmc.presentation.ui.sign_up.ulangi_pin.UlangiPinViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.sign_up.ulangi_pin.UlangiPinViewModel.UIEvent.PinNotSame INSTANCE = null;
            
            private PinNotSame() {
                super();
            }
        }
    }
}