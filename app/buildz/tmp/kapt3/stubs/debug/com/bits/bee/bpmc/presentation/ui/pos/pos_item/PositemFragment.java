package com.bits.bee.bpmc.presentation.ui.pos.pos_item;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\"\b\u0002\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0004\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\u0019H\u0016J\b\u0010%\u001a\u00020\u0019H\u0016R.\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006&"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/pos_item/PositemFragment;", "Lcom/bits/bee/bpmc/presentation/base/BaseFragment;", "Lcom/bits/bee/bpmc/databinding/FragmentPosItemBinding;", "bindingInflater", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "(Lkotlin/jvm/functions/Function3;)V", "getBindingInflater", "()Lkotlin/jvm/functions/Function3;", "mainViewModel", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel;", "getMainViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "posAdapter", "Lcom/bits/bee/bpmc/presentation/ui/pos/pos_item/ItemPosAdapter;", "viewModel", "Lcom/bits/bee/bpmc/presentation/ui/pos/pos_item/PosItemViewModel;", "getViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/pos/pos_item/PosItemViewModel;", "viewModel$delegate", "initComponents", "", "onItemClick", "item", "Lcom/bits/bee/bpmc/domain/model/Item;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setVisibilityComponent", "isLoading", "subscribeListeners", "subscribeObservers", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class PositemFragment extends com.bits.bee.bpmc.presentation.base.BaseFragment<com.bits.bee.bpmc.databinding.FragmentPosItemBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentPosItemBinding> bindingInflater = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy mainViewModel$delegate = null;
    private com.bits.bee.bpmc.presentation.ui.pos.pos_item.ItemPosAdapter posAdapter;
    
    public PositemFragment() {
        super();
    }
    
    public PositemFragment(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? super java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentPosItemBinding> bindingInflater) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentPosItemBinding> getBindingInflater() {
        return null;
    }
    
    private final com.bits.bee.bpmc.presentation.ui.pos.pos_item.PosItemViewModel getViewModel() {
        return null;
    }
    
    private final com.bits.bee.bpmc.presentation.ui.pos.MainViewModel getMainViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    
    private final void setVisibilityComponent(boolean isLoading) {
    }
    
    private final void onItemClick(com.bits.bee.bpmc.domain.model.Item item) {
    }
}