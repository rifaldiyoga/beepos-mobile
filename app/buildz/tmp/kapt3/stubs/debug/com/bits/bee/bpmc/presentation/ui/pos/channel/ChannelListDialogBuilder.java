package com.bits.bee.bpmc.presentation.ui.pos.channel;

import java.lang.System;

/**
 * Created by aldi on 05/04/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BK\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\"\b\u0002\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016R.\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/channel/ChannelListDialogBuilder;", "Lcom/bits/bee/bpmc/presentation/base/BaseBottomSheetDialogFragment;", "Lcom/bits/bee/bpmc/databinding/DialogChannelBinding;", "channelList", "", "Lcom/bits/bee/bpmc/domain/model/Channel;", "onChannelClick", "Lkotlin/Function1;", "", "bindingInflater", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "getBindingInflater", "()Lkotlin/jvm/functions/Function3;", "channelListAdapter", "Lcom/bits/bee/bpmc/presentation/ui/pos/channel/ChannelListAdapter;", "viewModel", "Lcom/bits/bee/bpmc/presentation/ui/pos/channel/ChannelDialogViewModel;", "getViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/pos/channel/ChannelDialogViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initComponents", "subscribeListeners", "subscribeObservers", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class ChannelListDialogBuilder extends com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment<com.bits.bee.bpmc.databinding.DialogChannelBinding> {
    private final java.util.List<com.bits.bee.bpmc.domain.model.Channel> channelList = null;
    private final kotlin.jvm.functions.Function1<com.bits.bee.bpmc.domain.model.Channel, kotlin.Unit> onChannelClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.DialogChannelBinding> bindingInflater = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private com.bits.bee.bpmc.presentation.ui.pos.channel.ChannelListAdapter channelListAdapter;
    
    public ChannelListDialogBuilder(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Channel> channelList, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.bits.bee.bpmc.domain.model.Channel, kotlin.Unit> onChannelClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? super java.lang.Boolean, com.bits.bee.bpmc.databinding.DialogChannelBinding> bindingInflater) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.DialogChannelBinding> getBindingInflater() {
        return null;
    }
    
    private final com.bits.bee.bpmc.presentation.ui.pos.channel.ChannelDialogViewModel getViewModel() {
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