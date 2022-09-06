package com.bits.bee.bpmc.presentation.ui.pembayaran;

import java.lang.System;

/**
 * Created by aldi on 25/04/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\"\b\u0002\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0004\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016R.\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranFragment;", "Lcom/bits/bee/bpmc/presentation/base/BaseFragment;", "Lcom/bits/bee/bpmc/databinding/FragmentPembayaranBinding;", "bindingInflater", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "(Lkotlin/jvm/functions/Function3;)V", "getBindingInflater", "()Lkotlin/jvm/functions/Function3;", "mainViewModel", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel;", "getMainViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "rekomBayarAdapter", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran/RekomBayarAdapter;", "viewModel", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel;", "getViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel;", "viewModel$delegate", "initComponents", "", "subscribeListeners", "subscribeObservers", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class PembayaranFragment extends com.bits.bee.bpmc.presentation.base.BaseFragment<com.bits.bee.bpmc.databinding.FragmentPembayaranBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentPembayaranBinding> bindingInflater = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy mainViewModel$delegate = null;
    private com.bits.bee.bpmc.presentation.ui.pembayaran.RekomBayarAdapter rekomBayarAdapter;
    
    public PembayaranFragment() {
        super();
    }
    
    public PembayaranFragment(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? super java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentPembayaranBinding> bindingInflater) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentPembayaranBinding> getBindingInflater() {
        return null;
    }
    
    private final com.bits.bee.bpmc.presentation.ui.pembayaran.PembayaranViewModel getViewModel() {
        return null;
    }
    
    private final com.bits.bee.bpmc.presentation.ui.pos.MainViewModel getMainViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void initComponents() {
    }
    
    @java.lang.Override()
    public void subscribeListeners() {
    }
    
    @java.lang.Override()
    public void subscribeObservers() {
    }
}