package com.bits.bee.bpmc.presentation.ui.tutup_kasir;

import java.lang.System;

/**
 * Created by aldi on 13/04/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\"\b\u0002\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0004\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016R.\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/tutup_kasir/DetailTutupKasirFragment;", "Lcom/bits/bee/bpmc/presentation/base/BaseFragment;", "Lcom/bits/bee/bpmc/databinding/FragmentDetailTutupKasirBinding;", "bindingInflater", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "(Lkotlin/jvm/functions/Function3;)V", "getBindingInflater", "()Lkotlin/jvm/functions/Function3;", "mCounter", "", "sharedViewModel", "Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/BukaTutupKasirSharedViewModel;", "getSharedViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/BukaTutupKasirSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/bits/bee/bpmc/presentation/ui/tutup_kasir/DetailTutupKasirViewModel;", "getViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/tutup_kasir/DetailTutupKasirViewModel;", "viewModel$delegate", "initComponents", "", "subscribeListeners", "subscribeObservers", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class DetailTutupKasirFragment extends com.bits.bee.bpmc.presentation.base.BaseFragment<com.bits.bee.bpmc.databinding.FragmentDetailTutupKasirBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentDetailTutupKasirBinding> bindingInflater = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy sharedViewModel$delegate = null;
    private int mCounter = 0;
    
    public DetailTutupKasirFragment() {
        super();
    }
    
    public DetailTutupKasirFragment(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? super java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentDetailTutupKasirBinding> bindingInflater) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentDetailTutupKasirBinding> getBindingInflater() {
        return null;
    }
    
    private final com.bits.bee.bpmc.presentation.ui.tutup_kasir.DetailTutupKasirViewModel getViewModel() {
        return null;
    }
    
    private final com.bits.bee.bpmc.presentation.ui.buka_kasir.BukaTutupKasirSharedViewModel getSharedViewModel() {
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