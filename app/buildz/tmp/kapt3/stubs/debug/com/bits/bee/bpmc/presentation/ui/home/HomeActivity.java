package com.bits.bee.bpmc.presentation.ui.home;

import java.lang.System;

/**
 * Created by aldi on 07/04/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/home/HomeActivity;", "Lcom/bits/bee/bpmc/presentation/base/BaseActivity;", "Lcom/bits/bee/bpmc/databinding/ActivityHomeBinding;", "bindingInflater", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "(Lkotlin/jvm/functions/Function1;)V", "getBindingInflater", "()Lkotlin/jvm/functions/Function1;", "navController", "Landroidx/navigation/NavController;", "navHostFragment", "Landroidx/navigation/fragment/NavHostFragment;", "sharedViewModel", "Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/BukaTutupKasirSharedViewModel;", "getSharedViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/BukaTutupKasirSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/bits/bee/bpmc/presentation/ui/home/HomeViewModel;", "getViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/home/HomeViewModel;", "viewModel$delegate", "initComponents", "", "onResume", "onSupportNavigateUp", "", "setVisibilityBottom", "isShow", "subscribeListeners", "subscribeObservers", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class HomeActivity extends com.bits.bee.bpmc.presentation.base.BaseActivity<com.bits.bee.bpmc.databinding.ActivityHomeBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<android.view.LayoutInflater, com.bits.bee.bpmc.databinding.ActivityHomeBinding> bindingInflater = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy sharedViewModel$delegate = null;
    private androidx.navigation.fragment.NavHostFragment navHostFragment;
    private androidx.navigation.NavController navController;
    
    public HomeActivity() {
        super();
    }
    
    public HomeActivity(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.view.LayoutInflater, com.bits.bee.bpmc.databinding.ActivityHomeBinding> bindingInflater) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<android.view.LayoutInflater, com.bits.bee.bpmc.databinding.ActivityHomeBinding> getBindingInflater() {
        return null;
    }
    
    private final com.bits.bee.bpmc.presentation.ui.home.HomeViewModel getViewModel() {
        return null;
    }
    
    private final com.bits.bee.bpmc.presentation.ui.buka_kasir.BukaTutupKasirSharedViewModel getSharedViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onResume() {
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
    
    private final void setVisibilityBottom(boolean isShow) {
    }
}