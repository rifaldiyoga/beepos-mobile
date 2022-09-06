package com.bits.bee.bpmc.presentation.ui.pos.addon;

import java.lang.System;

/**
 * Created by aldi on 15/08/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0019\u001aBG\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/addon/SelectionAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bits/bee/bpmc/domain/model/SelectionWithItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "addOnSelected", "Landroidx/lifecycle/LiveData;", "Ljava/util/ArrayList;", "Lcom/bits/bee/bpmc/domain/model/Item;", "Lkotlin/collections/ArrayList;", "lifecycleScope", "Landroidx/lifecycle/LifecycleOwner;", "onItemClick", "Lkotlin/Function1;", "", "addOnI", "Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnAdapter$AddOnI;", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnAdapter$AddOnI;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "ViewHolder", "app_debug"})
public final class SelectionAdapter extends androidx.recyclerview.widget.ListAdapter<com.bits.bee.bpmc.domain.model.SelectionWithItem, androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private final androidx.lifecycle.LiveData<java.util.ArrayList<com.bits.bee.bpmc.domain.model.Item>> addOnSelected = null;
    private final androidx.lifecycle.LifecycleOwner lifecycleScope = null;
    private final kotlin.jvm.functions.Function1<com.bits.bee.bpmc.domain.model.Item, kotlin.Unit> onItemClick = null;
    private final com.bits.bee.bpmc.presentation.ui.pos.addon.AddOnAdapter.AddOnI addOnI = null;
    
    public SelectionAdapter(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.util.ArrayList<com.bits.bee.bpmc.domain.model.Item>> addOnSelected, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner lifecycleScope, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.bits.bee.bpmc.domain.model.Item, kotlin.Unit> onItemClick, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.presentation.ui.pos.addon.AddOnAdapter.AddOnI addOnI) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\"\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/addon/SelectionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bits/bee/bpmc/databinding/ItemSelectionBinding;", "(Lcom/bits/bee/bpmc/presentation/ui/pos/addon/SelectionAdapter;Lcom/bits/bee/bpmc/databinding/ItemSelectionBinding;)V", "getBinding", "()Lcom/bits/bee/bpmc/databinding/ItemSelectionBinding;", "bind", "", "model", "Lcom/bits/bee/bpmc/domain/model/SelectionWithItem;", "checkSelected", "", "itemList", "", "Lcom/bits/bee/bpmc/domain/model/Item;", "selectedList", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.bits.bee.bpmc.databinding.ItemSelectionBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.databinding.ItemSelectionBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.databinding.ItemSelectionBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.SelectionWithItem model) {
        }
        
        public final boolean checkSelected(@org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.domain.model.Item> itemList, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.domain.model.Item> selectedList) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/addon/SelectionAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/bits/bee/bpmc/domain/model/SelectionWithItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class DiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.bits.bee.bpmc.domain.model.SelectionWithItem> {
        
        public DiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.SelectionWithItem oldItem, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.SelectionWithItem newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.SelectionWithItem oldItem, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.SelectionWithItem newItem) {
            return false;
        }
    }
}