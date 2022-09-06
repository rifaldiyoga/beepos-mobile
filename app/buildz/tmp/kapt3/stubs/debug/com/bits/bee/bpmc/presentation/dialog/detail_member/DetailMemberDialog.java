package com.bits.bee.bpmc.presentation.dialog.detail_member;

import java.lang.System;

/**
 * Created by aldi on 22/04/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\u0006\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016R.\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/detail_member/DetailMemberDialog;", "Lcom/bits/bee/bpmc/presentation/base/BaseBottomSheetDialogFragment;", "Lcom/bits/bee/bpmc/databinding/DialogDetailMemberBinding;", "mBp", "Lcom/bits/bee/bpmc/domain/model/Bp;", "bindingInflater", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "(Lcom/bits/bee/bpmc/domain/model/Bp;Lkotlin/jvm/functions/Function3;)V", "getBindingInflater", "()Lkotlin/jvm/functions/Function3;", "viewModel", "Lcom/bits/bee/bpmc/presentation/dialog/detail_member/DetailMemberViewModel;", "getViewModel", "()Lcom/bits/bee/bpmc/presentation/dialog/detail_member/DetailMemberViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initComponents", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "subscribeListeners", "subscribeObservers", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class DetailMemberDialog extends com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment<com.bits.bee.bpmc.databinding.DialogDetailMemberBinding> {
    private final com.bits.bee.bpmc.domain.model.Bp mBp = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.DialogDetailMemberBinding> bindingInflater = null;
    private final kotlin.Lazy viewModel$delegate = null;
    
    public DetailMemberDialog(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Bp mBp, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? super java.lang.Boolean, com.bits.bee.bpmc.databinding.DialogDetailMemberBinding> bindingInflater) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.DialogDetailMemberBinding> getBindingInflater() {
        return null;
    }
    
    private final com.bits.bee.bpmc.presentation.dialog.detail_member.DetailMemberViewModel getViewModel() {
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
}