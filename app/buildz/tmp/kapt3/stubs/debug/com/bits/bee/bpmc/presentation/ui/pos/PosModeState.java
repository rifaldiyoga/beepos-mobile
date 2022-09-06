package com.bits.bee.bpmc.presentation.ui.pos;

import java.lang.System;

/**
 * Created by aldi on 03/08/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/PosModeState;", "", "()V", "FnBState", "RetailState", "Lcom/bits/bee/bpmc/presentation/ui/pos/PosModeState$FnBState;", "Lcom/bits/bee/bpmc/presentation/ui/pos/PosModeState$RetailState;", "app_debug"})
public abstract class PosModeState {
    
    private PosModeState() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/PosModeState$FnBState;", "Lcom/bits/bee/bpmc/presentation/ui/pos/PosModeState;", "()V", "app_debug"})
    public static final class FnBState extends com.bits.bee.bpmc.presentation.ui.pos.PosModeState {
        @org.jetbrains.annotations.NotNull()
        public static final com.bits.bee.bpmc.presentation.ui.pos.PosModeState.FnBState INSTANCE = null;
        
        private FnBState() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/PosModeState$RetailState;", "Lcom/bits/bee/bpmc/presentation/ui/pos/PosModeState;", "()V", "app_debug"})
    public static final class RetailState extends com.bits.bee.bpmc.presentation.ui.pos.PosModeState {
        @org.jetbrains.annotations.NotNull()
        public static final com.bits.bee.bpmc.presentation.ui.pos.PosModeState.RetailState INSTANCE = null;
        
        private RetailState() {
            super();
        }
    }
}