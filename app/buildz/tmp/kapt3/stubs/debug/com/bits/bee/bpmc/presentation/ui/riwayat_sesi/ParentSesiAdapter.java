package com.bits.bee.bpmc.presentation.ui.riwayat_sesi;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0014\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001aH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/riwayat_sesi/ParentSesiAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bits/bee/bpmc/presentation/ui/riwayat_sesi/ParentSesiAdapter$ViewHolder;", "ctx", "Landroid/content/Context;", "listener", "Lcom/bits/bee/bpmc/presentation/ui/riwayat_sesi/NestedSesiAdapter$PilihRiwayatSesiI;", "(Landroid/content/Context;Lcom/bits/bee/bpmc/presentation/ui/riwayat_sesi/NestedSesiAdapter$PilihRiwayatSesiI;)V", "getCtx", "()Landroid/content/Context;", "getListener", "()Lcom/bits/bee/bpmc/presentation/ui/riwayat_sesi/NestedSesiAdapter$PilihRiwayatSesiI;", "mList", "", "Lcom/bits/bee/bpmc/domain/model/Sesi;", "mlistPosses", "Lcom/bits/bee/bpmc/domain/model/Posses;", "nestedSesiAdapter", "Lcom/bits/bee/bpmc/presentation/ui/riwayat_sesi/NestedSesiAdapter;", "sf", "Ljava/text/SimpleDateFormat;", "getDate", "", "dates", "Ljava/util/Date;", "getItemCount", "", "initList", "", "sesi", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class ParentSesiAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.bits.bee.bpmc.presentation.ui.riwayat_sesi.ParentSesiAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context ctx = null;
    @org.jetbrains.annotations.NotNull()
    private final com.bits.bee.bpmc.presentation.ui.riwayat_sesi.NestedSesiAdapter.PilihRiwayatSesiI listener = null;
    private java.util.List<com.bits.bee.bpmc.domain.model.Sesi> mList;
    private java.util.List<com.bits.bee.bpmc.domain.model.Posses> mlistPosses;
    private com.bits.bee.bpmc.presentation.ui.riwayat_sesi.NestedSesiAdapter nestedSesiAdapter;
    private final java.text.SimpleDateFormat sf = null;
    
    public ParentSesiAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.presentation.ui.riwayat_sesi.NestedSesiAdapter.PilihRiwayatSesiI listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getCtx() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.riwayat_sesi.NestedSesiAdapter.PilihRiwayatSesiI getListener() {
        return null;
    }
    
    public final void initList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Sesi> sesi) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.bits.bee.bpmc.presentation.ui.riwayat_sesi.ParentSesiAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.presentation.ui.riwayat_sesi.ParentSesiAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDate(@org.jetbrains.annotations.NotNull()
    java.util.Date dates) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/riwayat_sesi/ParentSesiAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bits/bee/bpmc/databinding/ItemParentSesiAdptBinding;", "(Lcom/bits/bee/bpmc/databinding/ItemParentSesiAdptBinding;)V", "getBinding", "()Lcom/bits/bee/bpmc/databinding/ItemParentSesiAdptBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.bits.bee.bpmc.databinding.ItemParentSesiAdptBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.databinding.ItemParentSesiAdptBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.databinding.ItemParentSesiAdptBinding getBinding() {
            return null;
        }
    }
}