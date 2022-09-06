package com.bits.bee.bpmc.presentation.dialog.radio_list;

import java.lang.System;

/**
 * Created by aldi on 05/04/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\u0006\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016R.\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/radio_list/RadioListDialogBuilder;", "Lcom/bits/bee/bpmc/presentation/base/BaseBottomSheetDialogFragment;", "Lcom/bits/bee/bpmc/databinding/DialogRadioListBinding;", "builder", "Lcom/bits/bee/bpmc/presentation/dialog/radio_list/RadioListDialogBuilder$Builder;", "bindingInflater", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "(Lcom/bits/bee/bpmc/presentation/dialog/radio_list/RadioListDialogBuilder$Builder;Lkotlin/jvm/functions/Function3;)V", "getBindingInflater", "()Lkotlin/jvm/functions/Function3;", "radioAdapter", "Lcom/bits/bee/bpmc/presentation/dialog/radio_list/RadioListAdapter;", "initComponents", "", "subscribeListeners", "subscribeObservers", "Builder", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class RadioListDialogBuilder extends com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment<com.bits.bee.bpmc.databinding.DialogRadioListBinding> {
    private final com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListDialogBuilder.Builder builder = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.DialogRadioListBinding> bindingInflater = null;
    private com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListAdapter radioAdapter;
    
    public RadioListDialogBuilder(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListDialogBuilder.Builder builder, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? super java.lang.Boolean, com.bits.bee.bpmc.databinding.DialogRadioListBinding> bindingInflater) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.DialogRadioListBinding> getBindingInflater() {
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u000eJ\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u00c6\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u0017\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u00c6\u0003J\u0017\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u00c6\u0003Jp\u0010,\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u00c6\u0001\u00a2\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u00020\tH\u00d6\u0001J\u0014\u0010\u0013\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007J\u001a\u00102\u001a\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000bJ\u001a\u00103\u001a\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000bJ\u0015\u00104\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u00106J\u0010\u0010\"\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\t\u00107\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u00068"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/radio_list/RadioListDialogBuilder$Builder;", "", "context", "Landroid/content/Context;", "title", "", "list", "", "posSelected", "", "onSaveClick", "Lkotlin/Function1;", "", "onCustomButton", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getContext", "()Landroid/content/Context;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getOnCustomButton", "()Lkotlin/jvm/functions/Function1;", "setOnCustomButton", "(Lkotlin/jvm/functions/Function1;)V", "getOnSaveClick", "setOnSaveClick", "getPosSelected", "()Ljava/lang/Integer;", "setPosSelected", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "build", "Lcom/bits/bee/bpmc/presentation/dialog/radio_list/RadioListDialogBuilder;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lcom/bits/bee/bpmc/presentation/dialog/radio_list/RadioListDialogBuilder$Builder;", "equals", "", "other", "hashCode", "setOnCustomButtonListener", "setOnSaveListener", "setSelectedPos", "pos", "(Ljava/lang/Integer;)Lcom/bits/bee/bpmc/presentation/dialog/radio_list/RadioListDialogBuilder$Builder;", "toString", "app_debug"})
    public static final class Builder {
        @org.jetbrains.annotations.NotNull()
        private final android.content.Context context = null;
        @org.jetbrains.annotations.Nullable()
        private java.lang.String title;
        @org.jetbrains.annotations.NotNull()
        private java.util.List<java.lang.String> list;
        @org.jetbrains.annotations.Nullable()
        private java.lang.Integer posSelected;
        @org.jetbrains.annotations.Nullable()
        private kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSaveClick;
        @org.jetbrains.annotations.Nullable()
        private kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onCustomButton;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListDialogBuilder.Builder copy(@org.jetbrains.annotations.NotNull()
        @dagger.hilt.android.qualifiers.ApplicationContext()
        android.content.Context context, @org.jetbrains.annotations.Nullable()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> list, @org.jetbrains.annotations.Nullable()
        java.lang.Integer posSelected, @org.jetbrains.annotations.Nullable()
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSaveClick, @org.jetbrains.annotations.Nullable()
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onCustomButton) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public Builder(@org.jetbrains.annotations.NotNull()
        @dagger.hilt.android.qualifiers.ApplicationContext()
        android.content.Context context, @org.jetbrains.annotations.Nullable()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> list, @org.jetbrains.annotations.Nullable()
        java.lang.Integer posSelected, @org.jetbrains.annotations.Nullable()
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSaveClick, @org.jetbrains.annotations.Nullable()
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onCustomButton) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getTitle() {
            return null;
        }
        
        public final void setTitle(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getList() {
            return null;
        }
        
        public final void setList(@org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component4() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getPosSelected() {
            return null;
        }
        
        public final void setPosSelected(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> component5() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> getOnSaveClick() {
            return null;
        }
        
        public final void setOnSaveClick(@org.jetbrains.annotations.Nullable()
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> component6() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> getOnCustomButton() {
            return null;
        }
        
        public final void setOnCustomButton(@org.jetbrains.annotations.Nullable()
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListDialogBuilder.Builder setTitle(@org.jetbrains.annotations.Nullable()
        java.lang.String title) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListDialogBuilder.Builder setList(@org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> list) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListDialogBuilder.Builder setSelectedPos(@org.jetbrains.annotations.Nullable()
        java.lang.Integer pos) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListDialogBuilder.Builder setOnSaveListener(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSaveClick) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListDialogBuilder.Builder setOnCustomButtonListener(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSaveClick) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListDialogBuilder build() {
            return null;
        }
    }
}