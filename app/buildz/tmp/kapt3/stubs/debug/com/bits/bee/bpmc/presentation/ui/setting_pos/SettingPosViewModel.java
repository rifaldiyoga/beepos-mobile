package com.bits.bee.bpmc.presentation.ui.setting_pos;

import java.lang.System;

/**
 * Created by aldi on 05/04/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewState;", "event", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent;", "getEvent", "()Lkotlinx/coroutines/flow/Flow;", "eventChannel", "Lkotlinx/coroutines/channels/Channel;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "setState", "(Lkotlinx/coroutines/flow/StateFlow;)V", "onClickCustomer", "Lkotlinx/coroutines/Job;", "onClickJumlahMeja", "onClickPosisiOrientasi", "onClickPresetBukaKasir", "onClickUkuranFont", "UIEvent", "app_debug"})
public final class SettingPosViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.channels.Channel<com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel.UIEvent> eventChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel.UIEvent> event = null;
    private kotlinx.coroutines.flow.MutableStateFlow<com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewState> _state;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.StateFlow<com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewState> state;
    
    @javax.inject.Inject()
    public SettingPosViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel.UIEvent> getEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewState> getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.StateFlow<com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewState> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickUkuranFont() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickCustomer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickJumlahMeja() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickPresetBukaKasir() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickPosisiOrientasi() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent;", "", "()V", "RequestCustomer", "RequestJumlahMeja", "RequestPosisiOrientasi", "RequestPresetBukaKasir", "RequestUkuranFont", "Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent$RequestCustomer;", "Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent$RequestJumlahMeja;", "Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent$RequestPosisiOrientasi;", "Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent$RequestPresetBukaKasir;", "Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent$RequestUkuranFont;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent$RequestUkuranFont;", "Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestUkuranFont extends com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel.UIEvent.RequestUkuranFont INSTANCE = null;
            
            private RequestUkuranFont() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent$RequestCustomer;", "Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestCustomer extends com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel.UIEvent.RequestCustomer INSTANCE = null;
            
            private RequestCustomer() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent$RequestJumlahMeja;", "Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestJumlahMeja extends com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel.UIEvent.RequestJumlahMeja INSTANCE = null;
            
            private RequestJumlahMeja() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent$RequestPresetBukaKasir;", "Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestPresetBukaKasir extends com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel.UIEvent.RequestPresetBukaKasir INSTANCE = null;
            
            private RequestPresetBukaKasir() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent$RequestPosisiOrientasi;", "Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestPosisiOrientasi extends com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel.UIEvent.RequestPosisiOrientasi INSTANCE = null;
            
            private RequestPosisiOrientasi() {
                super();
            }
        }
    }
}