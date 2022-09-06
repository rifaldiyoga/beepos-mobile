package com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0018\u0019\u001aB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/rekap_sesi_kasir/RekapSesiAdapter;", "Landroidx/paging/PagingDataAdapter;", "Lcom/bits/bee/bpmc/domain/model/Posses;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mListener", "Lcom/bits/bee/bpmc/presentation/ui/rekap_sesi_kasir/RekapSesiAdapter$PilihRekapSesiI;", "(Lcom/bits/bee/bpmc/presentation/ui/rekap_sesi_kasir/RekapSesiAdapter$PilihRekapSesiI;)V", "mUser", "Lcom/bits/bee/bpmc/domain/model/User;", "getMUser", "()Lcom/bits/bee/bpmc/domain/model/User;", "setMUser", "(Lcom/bits/bee/bpmc/domain/model/User;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitValue", "user", "DiffCallback", "PilihRekapSesiI", "ViewHolder", "app_debug"})
public final class RekapSesiAdapter extends androidx.paging.PagingDataAdapter<com.bits.bee.bpmc.domain.model.Posses, androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private final com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir.RekapSesiAdapter.PilihRekapSesiI mListener = null;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.User mUser;
    
    public RekapSesiAdapter(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir.RekapSesiAdapter.PilihRekapSesiI mListener) {
        super(null, null, null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.User getMUser() {
        return null;
    }
    
    public final void setMUser(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.User p0) {
    }
    
    public final void submitValue(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.User user) {
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/rekap_sesi_kasir/RekapSesiAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bits/bee/bpmc/databinding/ItemRekapSesiBinding;", "(Lcom/bits/bee/bpmc/presentation/ui/rekap_sesi_kasir/RekapSesiAdapter;Lcom/bits/bee/bpmc/databinding/ItemRekapSesiBinding;)V", "bind", "", "posses", "Lcom/bits/bee/bpmc/domain/model/Posses;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.bits.bee.bpmc.databinding.ItemRekapSesiBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.databinding.ItemRekapSesiBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Posses posses) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/rekap_sesi_kasir/RekapSesiAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/bits/bee/bpmc/domain/model/Posses;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class DiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.bits.bee.bpmc.domain.model.Posses> {
        
        public DiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Posses oldItem, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Posses newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Posses oldItem, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Posses newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/rekap_sesi_kasir/RekapSesiAdapter$PilihRekapSesiI;", "", "onclick", "", "posses", "Lcom/bits/bee/bpmc/domain/model/Posses;", "app_debug"})
    public static abstract interface PilihRekapSesiI {
        
        public abstract void onclick(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Posses posses);
    }
}