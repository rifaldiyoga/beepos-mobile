package com.bits.bee.bpmc.presentation.ui.nama_device;

import java.lang.System;

/**
 * Created by aldi on 21/03/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/nama_device/NamaDeviceViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bits/bee/bpmc/presentation/ui/nama_device/NamaDeviceState;", "event", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/presentation/ui/nama_device/NamaDeviceViewModel$UIEvent;", "getEvent", "()Lkotlinx/coroutines/flow/Flow;", "eventChannel", "Lkotlinx/coroutines/channels/Channel;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "onArgumentRecived", "Lkotlinx/coroutines/Job;", "email", "", "password", "onClickLanjutkan", "context", "Landroid/content/Context;", "onInputName", "deviceName", "UIEvent", "app_debug"})
public final class NamaDeviceViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.channels.Channel<com.bits.bee.bpmc.presentation.ui.nama_device.NamaDeviceViewModel.UIEvent> eventChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.presentation.ui.nama_device.NamaDeviceViewModel.UIEvent> event = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.bits.bee.bpmc.presentation.ui.nama_device.NamaDeviceState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.bits.bee.bpmc.presentation.ui.nama_device.NamaDeviceState> state = null;
    
    @javax.inject.Inject()
    public NamaDeviceViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.presentation.ui.nama_device.NamaDeviceViewModel.UIEvent> getEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.bits.bee.bpmc.presentation.ui.nama_device.NamaDeviceState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onArgumentRecived(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onInputName(@org.jetbrains.annotations.NotNull()
    java.lang.String deviceName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickLanjutkan(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/nama_device/NamaDeviceViewModel$UIEvent;", "", "()V", "NavigateToPilihDb", "Lcom/bits/bee/bpmc/presentation/ui/nama_device/NamaDeviceViewModel$UIEvent$NavigateToPilihDb;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/nama_device/NamaDeviceViewModel$UIEvent$NavigateToPilihDb;", "Lcom/bits/bee/bpmc/presentation/ui/nama_device/NamaDeviceViewModel$UIEvent;", "username", "", "password", "(Ljava/lang/String;Ljava/lang/String;)V", "getPassword", "()Ljava/lang/String;", "getUsername", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class NavigateToPilihDb extends com.bits.bee.bpmc.presentation.ui.nama_device.NamaDeviceViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String username = null;
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String password = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.presentation.ui.nama_device.NamaDeviceViewModel.UIEvent.NavigateToPilihDb copy(@org.jetbrains.annotations.NotNull()
            java.lang.String username, @org.jetbrains.annotations.NotNull()
            java.lang.String password) {
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
            
            public NavigateToPilihDb(@org.jetbrains.annotations.NotNull()
            java.lang.String username, @org.jetbrains.annotations.NotNull()
            java.lang.String password) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getUsername() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getPassword() {
                return null;
            }
        }
    }
}