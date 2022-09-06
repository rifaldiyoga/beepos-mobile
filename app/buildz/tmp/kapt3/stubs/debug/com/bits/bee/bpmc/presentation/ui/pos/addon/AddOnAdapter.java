package com.bits.bee.bpmc.presentation.ui.pos.addon;

import java.lang.System;

/**
 * Created by aldi on 15/08/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001e\u001f Bq\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u001c\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0013j\b\u0012\u0004\u0012\u00020\u0002`\u00140\u0012\u00a2\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0013j\b\u0012\u0004\u0012\u00020\u0002`\u00140\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bits/bee/bpmc/domain/model/Item;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "lastPosition", "", "selectedPosition", "selectionPosition", "isMultiSelect", "", "isMultiQty", "addOnI", "Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnAdapter$AddOnI;", "selectionAdapter", "Lcom/bits/bee/bpmc/presentation/ui/pos/addon/SelectionAdapter;", "lifecycleScope", "Landroidx/lifecycle/LifecycleOwner;", "addOnSelected", "Landroidx/lifecycle/LiveData;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(IIIZZLcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnAdapter$AddOnI;Lcom/bits/bee/bpmc/presentation/ui/pos/addon/SelectionAdapter;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LiveData;)V", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AddOnI", "DiffCallback", "ViewHolder", "app_debug"})
public final class AddOnAdapter extends androidx.recyclerview.widget.ListAdapter<com.bits.bee.bpmc.domain.model.Item, androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private int lastPosition;
    private int selectedPosition;
    private int selectionPosition;
    private final boolean isMultiSelect = false;
    private final boolean isMultiQty = false;
    private final com.bits.bee.bpmc.presentation.ui.pos.addon.AddOnAdapter.AddOnI addOnI = null;
    private final com.bits.bee.bpmc.presentation.ui.pos.addon.SelectionAdapter selectionAdapter = null;
    private final androidx.lifecycle.LifecycleOwner lifecycleScope = null;
    private final androidx.lifecycle.LiveData<java.util.ArrayList<com.bits.bee.bpmc.domain.model.Item>> addOnSelected = null;
    
    public AddOnAdapter(int lastPosition, int selectedPosition, int selectionPosition, boolean isMultiSelect, boolean isMultiQty, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.presentation.ui.pos.addon.AddOnAdapter.AddOnI addOnI, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.presentation.ui.pos.addon.SelectionAdapter selectionAdapter, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner lifecycleScope, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.util.ArrayList<com.bits.bee.bpmc.domain.model.Item>> addOnSelected) {
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nJ\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bits/bee/bpmc/databinding/ItemAddonBinding;", "(Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnAdapter;Lcom/bits/bee/bpmc/databinding/ItemAddonBinding;)V", "getBinding", "()Lcom/bits/bee/bpmc/databinding/ItemAddonBinding;", "addItem", "", "item", "Lcom/bits/bee/bpmc/domain/model/Item;", "bind", "model", "bindView", "qty", "Ljava/math/BigDecimal;", "deleteItem", "doClick", "minItem", "setSelected", "position", "", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.bits.bee.bpmc.databinding.ItemAddonBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.databinding.ItemAddonBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.databinding.ItemAddonBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Item model) {
        }
        
        private final void bindView(java.math.BigDecimal qty) {
        }
        
        private final void doClick(com.bits.bee.bpmc.domain.model.Item item) {
        }
        
        private final void setSelected(int position, com.bits.bee.bpmc.domain.model.Item item) {
        }
        
        private final void addItem(com.bits.bee.bpmc.domain.model.Item item) {
        }
        
        private final void minItem(com.bits.bee.bpmc.domain.model.Item item) {
        }
        
        private final void deleteItem(com.bits.bee.bpmc.domain.model.Item item) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/bits/bee/bpmc/domain/model/Item;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class DiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.bits.bee.bpmc.domain.model.Item> {
        
        public DiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Item oldItem, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Item newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Item oldItem, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Item newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/addon/AddOnAdapter$AddOnI;", "", "addOrRemoveItem", "", "item", "Lcom/bits/bee/bpmc/domain/model/Item;", "onDeselect", "onItemClick", "app_debug"})
    public static abstract interface AddOnI {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Item item);
        
        public abstract void onDeselect(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Item item);
        
        public abstract void addOrRemoveItem(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Item item);
    }
}