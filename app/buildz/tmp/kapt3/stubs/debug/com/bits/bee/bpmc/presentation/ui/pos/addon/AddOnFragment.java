package com.bits.bee.bpmc.presentation.ui.pos.addon;

import java.lang.System;

/**
 * Created by aldi on 15/08/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\u0012\"\b\u0002\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0016J\b\u0010$\u001a\u00020\u001cH\u0016R.\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006%"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnFragment;", "Lcom/bits/bee/bpmc/presentation/base/BaseFragment;", "Lcom/bits/bee/bpmc/databinding/FragmentAddonBinding;", "Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnAdapter$AddOnI;", "bindingInflater", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "(Lkotlin/jvm/functions/Function3;)V", "getBindingInflater", "()Lkotlin/jvm/functions/Function3;", "mainViewModel", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel;", "getMainViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "selectionAdapter", "Lcom/bits/bee/bpmc/presentation/ui/pos/addon/SelectionAdapter;", "variantAdapter", "Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnAdapter;", "viewModel", "Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnViewModel;", "getViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnViewModel;", "viewModel$delegate", "addOrRemoveItem", "", "item", "Lcom/bits/bee/bpmc/domain/model/Item;", "initComponents", "onDeselect", "onItemClick", "recalcSubtotal", "subscribeListeners", "subscribeObservers", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class AddOnFragment extends com.bits.bee.bpmc.presentation.base.BaseFragment<com.bits.bee.bpmc.databinding.FragmentAddonBinding> implements com.bits.bee.bpmc.presentation.ui.pos.addon.AddOnAdapter.AddOnI {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentAddonBinding> bindingInflater = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy mainViewModel$delegate = null;
    private com.bits.bee.bpmc.presentation.ui.pos.addon.SelectionAdapter selectionAdapter;
    private com.bits.bee.bpmc.presentation.ui.pos.addon.AddOnAdapter variantAdapter;
    
    public AddOnFragment() {
        super();
    }
    
    public AddOnFragment(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? super java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentAddonBinding> bindingInflater) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentAddonBinding> getBindingInflater() {
        return null;
    }
    
    private final com.bits.bee.bpmc.presentation.ui.pos.addon.AddOnViewModel getViewModel() {
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
    
    private final void recalcSubtotal() {
    }
    
    @java.lang.Override()
    public void onItemClick(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Item item) {
    }
    
    @java.lang.Override()
    public void onDeselect(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Item item) {
    }
    
    @java.lang.Override()
    public void addOrRemoveItem(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Item item) {
    }
}