package com.bits.bee.bpmc.presentation.ui.pos.invoice_list;

import java.lang.System;

/**
 * Created by aldi on 24/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0017\u0018\u0019\u001aBI\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/invoice_list/InvoiceAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bits/bee/bpmc/domain/model/Saled;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onItemClicK", "Lkotlin/Function1;", "", "onDeleteClick", "isDelete", "", "modePos", "Lcom/bits/bee/bpmc/presentation/ui/pos/PosModeState;", "saleTrans", "Lcom/bits/bee/bpmc/domain/trans/SaleTrans;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLcom/bits/bee/bpmc/presentation/ui/pos/PosModeState;Lcom/bits/bee/bpmc/domain/trans/SaleTrans;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "ViewHolder", "ViewHolderFnb", "ViewHolderRetail", "app_debug"})
public final class InvoiceAdapter extends androidx.recyclerview.widget.ListAdapter<com.bits.bee.bpmc.domain.model.Saled, androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private final kotlin.jvm.functions.Function1<com.bits.bee.bpmc.domain.model.Saled, kotlin.Unit> onItemClicK = null;
    private final kotlin.jvm.functions.Function1<com.bits.bee.bpmc.domain.model.Saled, kotlin.Unit> onDeleteClick = null;
    private final boolean isDelete = false;
    private final com.bits.bee.bpmc.presentation.ui.pos.PosModeState modePos = null;
    private final com.bits.bee.bpmc.domain.trans.SaleTrans saleTrans = null;
    
    public InvoiceAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.bits.bee.bpmc.domain.model.Saled, kotlin.Unit> onItemClicK, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.bits.bee.bpmc.domain.model.Saled, kotlin.Unit> onDeleteClick, boolean isDelete, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.presentation.ui.pos.PosModeState modePos, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.trans.SaleTrans saleTrans) {
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/invoice_list/InvoiceAdapter$ViewHolder;", "", "bind", "", "model", "Lcom/bits/bee/bpmc/domain/model/Saled;", "app_debug"})
    public static abstract interface ViewHolder {
        
        public abstract void bind(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Saled model);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/invoice_list/InvoiceAdapter$ViewHolderFnb;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bits/bee/bpmc/presentation/ui/pos/invoice_list/InvoiceAdapter$ViewHolder;", "binding", "Lcom/bits/bee/bpmc/databinding/ItemInvoiceBinding;", "(Lcom/bits/bee/bpmc/presentation/ui/pos/invoice_list/InvoiceAdapter;Lcom/bits/bee/bpmc/databinding/ItemInvoiceBinding;)V", "bind", "", "model", "Lcom/bits/bee/bpmc/domain/model/Saled;", "app_debug"})
    public final class ViewHolderFnb extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements com.bits.bee.bpmc.presentation.ui.pos.invoice_list.InvoiceAdapter.ViewHolder {
        private final com.bits.bee.bpmc.databinding.ItemInvoiceBinding binding = null;
        
        public ViewHolderFnb(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.databinding.ItemInvoiceBinding binding) {
            super(null);
        }
        
        @java.lang.Override()
        public void bind(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Saled model) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/invoice_list/InvoiceAdapter$ViewHolderRetail;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bits/bee/bpmc/presentation/ui/pos/invoice_list/InvoiceAdapter$ViewHolder;", "binding", "Lcom/bits/bee/bpmc/databinding/ItemInvoiceRetailBinding;", "(Lcom/bits/bee/bpmc/presentation/ui/pos/invoice_list/InvoiceAdapter;Lcom/bits/bee/bpmc/databinding/ItemInvoiceRetailBinding;)V", "bind", "", "model", "Lcom/bits/bee/bpmc/domain/model/Saled;", "app_debug"})
    public final class ViewHolderRetail extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements com.bits.bee.bpmc.presentation.ui.pos.invoice_list.InvoiceAdapter.ViewHolder {
        private final com.bits.bee.bpmc.databinding.ItemInvoiceRetailBinding binding = null;
        
        public ViewHolderRetail(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.databinding.ItemInvoiceRetailBinding binding) {
            super(null);
        }
        
        @java.lang.Override()
        public void bind(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Saled model) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/invoice_list/InvoiceAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/bits/bee/bpmc/domain/model/Saled;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class DiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.bits.bee.bpmc.domain.model.Saled> {
        
        public DiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Saled oldItem, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Saled newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Saled oldItem, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Saled newItem) {
            return false;
        }
    }
}