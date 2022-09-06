package com.bits.bee.bpmc.presentation.ui.pos;

import java.lang.System;

/**
 * Created by aldi on 07/04/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006!"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/MainActivity;", "Lcom/bits/bee/bpmc/presentation/base/BaseActivity;", "Lcom/bits/bee/bpmc/databinding/ActivityMainBinding;", "bindingInflater", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "(Lkotlin/jvm/functions/Function1;)V", "getBindingInflater", "()Lkotlin/jvm/functions/Function1;", "navController", "Landroidx/navigation/NavController;", "navHostFragment", "Landroidx/navigation/fragment/NavHostFragment;", "viewModel", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel;", "getViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initComponents", "", "initStetho", "onBackPressed", "onSupportNavigateUp", "", "setBackgroundToolbar", "destinationId", "", "setVisibilityToolbar", "showSalesman", "isVisible", "subscribeListeners", "subscribeObservers", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MainActivity extends com.bits.bee.bpmc.presentation.base.BaseActivity<com.bits.bee.bpmc.databinding.ActivityMainBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<android.view.LayoutInflater, com.bits.bee.bpmc.databinding.ActivityMainBinding> bindingInflater = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private androidx.navigation.fragment.NavHostFragment navHostFragment;
    private androidx.navigation.NavController navController;
    
    public MainActivity() {
        super();
    }
    
    public MainActivity(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.view.LayoutInflater, com.bits.bee.bpmc.databinding.ActivityMainBinding> bindingInflater) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<android.view.LayoutInflater, com.bits.bee.bpmc.databinding.ActivityMainBinding> getBindingInflater() {
        return null;
    }
    
    private final com.bits.bee.bpmc.presentation.ui.pos.MainViewModel getViewModel() {
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
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    private final void initStetho() {
    }
    
    private final void setVisibilityToolbar(int destinationId) {
    }
    
    private final void setBackgroundToolbar(int destinationId) {
    }
    
    private final void showSalesman(boolean isVisible) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
}