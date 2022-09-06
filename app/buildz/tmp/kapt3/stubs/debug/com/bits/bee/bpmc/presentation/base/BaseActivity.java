package com.bits.bee.bpmc.presentation.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0014J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J*\u0010\u0019\u001a\u00020\u00112\b\b\u0001\u0010\u0017\u001a\u00020\u001a2\b\b\u0001\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\u0011H&J\b\u0010!\u001a\u00020\u0011H&R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00028\u00008DX\u0084\u0004\u00a2\u0006\f\u0012\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\""}, d2 = {"Lcom/bits/bee/bpmc/presentation/base/BaseActivity;", "T", "Landroidx/viewbinding/ViewBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bits/bee/bpmc/presentation/base/BaseInterface;", "()V", "_binding", "binding", "getBinding$annotations", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "bindingInflater", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "getBindingInflater", "()Lkotlin/jvm/functions/Function1;", "initComponents", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showSnackbar", "message", "", "showSnackbarWithAction", "", "actionText", "action", "Lkotlin/Function0;", "", "showToast", "subscribeListeners", "subscribeObservers", "app_debug"})
public abstract class BaseActivity<T extends androidx.viewbinding.ViewBinding> extends androidx.appcompat.app.AppCompatActivity implements com.bits.bee.bpmc.presentation.base.BaseInterface {
    private androidx.viewbinding.ViewBinding _binding;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.jvm.functions.Function1<android.view.LayoutInflater, T> getBindingInflater();
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @java.lang.Deprecated()
    protected static void getBinding$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final T getBinding() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public abstract void initComponents();
    
    @java.lang.Override()
    public abstract void subscribeListeners();
    
    @java.lang.Override()
    public abstract void subscribeObservers();
    
    @java.lang.Override()
    public void showSnackbar(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void showSnackbarWithAction(@androidx.annotation.StringRes()
    int message, @androidx.annotation.StringRes()
    int actionText, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends java.lang.Object> action) {
    }
    
    @java.lang.Override()
    public void showToast(int message) {
    }
}