package com.bits.bee.bpmc.presentation.ui.pos.diskon_nota;

import java.lang.System;

/**
 * Created by aldi on 27/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\b"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/diskon_nota/DiskonNotaViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/pos/diskon_nota/DiskonNotaState;", "Lcom/bits/bee/bpmc/presentation/ui/pos/diskon_nota/DiskonNotaViewModel$UIEvent;", "()V", "onTambahClick", "Lkotlinx/coroutines/Job;", "UIEvent", "app_debug"})
public final class DiskonNotaViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.pos.diskon_nota.DiskonNotaState, com.bits.bee.bpmc.presentation.ui.pos.diskon_nota.DiskonNotaViewModel.UIEvent> {
    
    public DiskonNotaViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onTambahClick() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/diskon_nota/DiskonNotaViewModel$UIEvent;", "", "()V", "RequestDiskonNota", "Lcom/bits/bee/bpmc/presentation/ui/pos/diskon_nota/DiskonNotaViewModel$UIEvent$RequestDiskonNota;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/diskon_nota/DiskonNotaViewModel$UIEvent$RequestDiskonNota;", "Lcom/bits/bee/bpmc/presentation/ui/pos/diskon_nota/DiskonNotaViewModel$UIEvent;", "diskon", "", "(Ljava/lang/String;)V", "getDiskon", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class RequestDiskonNota extends com.bits.bee.bpmc.presentation.ui.pos.diskon_nota.DiskonNotaViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String diskon = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.presentation.ui.pos.diskon_nota.DiskonNotaViewModel.UIEvent.RequestDiskonNota copy(@org.jetbrains.annotations.NotNull()
            java.lang.String diskon) {
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
            
            public RequestDiskonNota(@org.jetbrains.annotations.NotNull()
            java.lang.String diskon) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getDiskon() {
                return null;
            }
        }
    }
}