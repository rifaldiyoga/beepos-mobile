package com.bits.bee.bpmc.presentation.dialog.tipe_printer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BE\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\"\b\u0002\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0002\u0010\u000eJ\u0006\u0010 \u001a\u00020\u0006J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R.\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/TipePrinterDialog;", "Lcom/bits/bee/bpmc/presentation/base/BaseBottomSheetDialogFragment;", "Lcom/bits/bee/bpmc/databinding/DialogTipePrinterBinding;", "onSaveClick", "Lkotlin/Function1;", "", "", "ctx", "Landroid/content/Context;", "bindingInflater", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "(Lkotlin/jvm/functions/Function1;Landroid/content/Context;Lkotlin/jvm/functions/Function3;)V", "getBindingInflater", "()Lkotlin/jvm/functions/Function3;", "getCtx", "()Landroid/content/Context;", "list", "", "Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/ListTipe;", "getOnSaveClick", "()Lkotlin/jvm/functions/Function1;", "tipeAdapter", "Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/TipePrinterAdapter;", "viewModel", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/SettingPrinterViewModel;", "getViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/setting_printer/SettingPrinterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTipe", "initComponents", "subscribeListeners", "subscribeObservers", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class TipePrinterDialog extends com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment<com.bits.bee.bpmc.databinding.DialogTipePrinterBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSaveClick = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context ctx = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.DialogTipePrinterBinding> bindingInflater = null;
    private java.util.List<com.bits.bee.bpmc.presentation.dialog.tipe_printer.ListTipe> list;
    private com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterAdapter tipeAdapter;
    private final kotlin.Lazy viewModel$delegate = null;
    
    public TipePrinterDialog(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSaveClick, @org.jetbrains.annotations.NotNull()
    android.content.Context ctx, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? super java.lang.Boolean, com.bits.bee.bpmc.databinding.DialogTipePrinterBinding> bindingInflater) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> getOnSaveClick() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getCtx() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.DialogTipePrinterBinding> getBindingInflater() {
        return null;
    }
    
    private final com.bits.bee.bpmc.presentation.ui.setting_printer.SettingPrinterViewModel getViewModel() {
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
    
    public final void getTipe() {
    }
}