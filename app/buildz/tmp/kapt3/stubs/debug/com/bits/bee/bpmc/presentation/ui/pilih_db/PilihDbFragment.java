package com.bits.bee.bpmc.presentation.ui.pilih_db;

import java.lang.System;

/**
 * Created by aldi on 04/03/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\"\b\u0002\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0004\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020\u0016H\u0016J\b\u0010\'\u001a\u00020\u0016H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R.\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006("}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pilih_db/PilihDbFragment;", "Lcom/bits/bee/bpmc/presentation/base/BaseFragment;", "Lcom/bits/bee/bpmc/databinding/FragmentPilihDbBinding;", "bindingInflater", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "(Lkotlin/jvm/functions/Function3;)V", "adapter", "Lcom/bits/bee/bpmc/presentation/ui/pilih_db/PilihDbAdapter;", "getBindingInflater", "()Lkotlin/jvm/functions/Function3;", "dialog", "Lcom/bits/bee/bpmc/presentation/dialog/LoadingDialogHelper;", "viewModel", "Lcom/bits/bee/bpmc/presentation/ui/pilih_db/PilihDbViewModel;", "getViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/pilih_db/PilihDbViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initComponents", "", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setVisibilityComponent", "isLoading", "subscribeListeners", "subscribeObservers", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class PilihDbFragment extends com.bits.bee.bpmc.presentation.base.BaseFragment<com.bits.bee.bpmc.databinding.FragmentPilihDbBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentPilihDbBinding> bindingInflater = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private com.bits.bee.bpmc.presentation.ui.pilih_db.PilihDbAdapter adapter;
    private com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper dialog;
    
    public PilihDbFragment() {
        super();
    }
    
    public PilihDbFragment(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? super java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentPilihDbBinding> bindingInflater) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentPilihDbBinding> getBindingInflater() {
        return null;
    }
    
    private final com.bits.bee.bpmc.presentation.ui.pilih_db.PilihDbViewModel getViewModel() {
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
    
    @java.lang.Override()
    public void onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu, @org.jetbrains.annotations.NotNull()
    android.view.MenuInflater inflater) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    /**
     * Check visibiliy of progress bar and recycler view when request data from api
     * @param isLoading
     */
    private final void setVisibilityComponent(boolean isLoading) {
    }
}