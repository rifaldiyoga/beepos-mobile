package com.bits.bee.bpmc.presentation.base;

import java.lang.System;

/**
 * Created by aldi on 04/03/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001fR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR$\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00008F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "State", "UIEvent", "Landroidx/lifecycle/ViewModel;", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "error", "Lkotlinx/coroutines/flow/Flow;", "", "getError", "()Lkotlinx/coroutines/flow/Flow;", "errorChannel", "Lkotlinx/coroutines/channels/Channel;", "getErrorChannel", "()Lkotlinx/coroutines/channels/Channel;", "event", "getEvent", "eventChannel", "getEventChannel", "value", "state", "getState", "()Ljava/lang/Object;", "setState", "(Ljava/lang/Object;)V", "updateState", "Lkotlinx/coroutines/Job;", "s", "(Ljava/lang/Object;)Lkotlinx/coroutines/Job;", "viewStates", "Lkotlinx/coroutines/flow/StateFlow;", "app_debug"})
public abstract class BaseViewModel<State extends java.lang.Object, UIEvent extends java.lang.Object> extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<UIEvent> eventChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<UIEvent> event = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<java.lang.String> errorChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.String> error = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<State> _state = null;
    
    public BaseViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.channels.Channel<UIEvent> getEventChannel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<UIEvent> getEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.channels.Channel<java.lang.String> getErrorChannel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<State> viewStates() {
        return null;
    }
    
    public final State getState() {
        return null;
    }
    
    public final void setState(State value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateState(State s) {
        return null;
    }
}