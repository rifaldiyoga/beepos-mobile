package com.bits.bee.bpmc.presentation.base;

import java.lang.System;

/**
 * Created by aldi on 28/03/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J*\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0005\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\u0005\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&\u00a8\u0006\u000f"}, d2 = {"Lcom/bits/bee/bpmc/presentation/base/BaseInterface;", "", "initComponents", "", "showSnackbar", "message", "", "showSnackbarWithAction", "", "actionText", "action", "Lkotlin/Function0;", "showToast", "subscribeListeners", "subscribeObservers", "app_debug"})
public abstract interface BaseInterface {
    
    public abstract void initComponents();
    
    public abstract void subscribeListeners();
    
    public abstract void subscribeObservers();
    
    public abstract void showSnackbar(@org.jetbrains.annotations.NotNull()
    java.lang.String message);
    
    public abstract void showSnackbarWithAction(@androidx.annotation.StringRes()
    int message, @androidx.annotation.StringRes()
    int actionText, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends java.lang.Object> action);
    
    public abstract void showToast(@androidx.annotation.StringRes()
    int message);
}