package com.bits.bee.bpmc.presentation.dialog.tipe_printer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002&\'B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001bJ\b\u0010\u001e\u001a\u00020\u001bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/TipePrinterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/TipePrinterAdapter$ViewHolder;", "tipeList", "", "Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/ListTipe;", "ctx", "Landroid/content/Context;", "mListener", "Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/TipePrinterAdapter$PilihTipePrinterAddapterI;", "(Ljava/util/List;Landroid/content/Context;Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/TipePrinterAdapter$PilihTipePrinterAddapterI;)V", "mBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getMBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "setMBluetoothAdapter", "(Landroid/bluetooth/BluetoothAdapter;)V", "mTipeList", "mWifiManager", "Landroid/net/wifi/WifiManager;", "getMWifiManager", "()Landroid/net/wifi/WifiManager;", "setMWifiManager", "(Landroid/net/wifi/WifiManager;)V", "checkTypePrinter", "", "tipe", "", "getItem", "i", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PilihTipePrinterAddapterI", "ViewHolder", "app_debug"})
public final class TipePrinterAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterAdapter.ViewHolder> {
    private java.util.List<com.bits.bee.bpmc.presentation.dialog.tipe_printer.ListTipe> tipeList;
    private android.content.Context ctx;
    private final com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterAdapter.PilihTipePrinterAddapterI mListener = null;
    private java.util.List<com.bits.bee.bpmc.presentation.dialog.tipe_printer.ListTipe> mTipeList;
    public android.bluetooth.BluetoothAdapter mBluetoothAdapter;
    public android.net.wifi.WifiManager mWifiManager;
    
    public TipePrinterAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.presentation.dialog.tipe_printer.ListTipe> tipeList, @org.jetbrains.annotations.NotNull()
    android.content.Context ctx, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterAdapter.PilihTipePrinterAddapterI mListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.bluetooth.BluetoothAdapter getMBluetoothAdapter() {
        return null;
    }
    
    public final void setMBluetoothAdapter(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.wifi.WifiManager getMWifiManager() {
        return null;
    }
    
    public final void setMWifiManager(@org.jetbrains.annotations.NotNull()
    android.net.wifi.WifiManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.dialog.tipe_printer.ListTipe getItem(int i) {
        return null;
    }
    
    public final void checkTypePrinter(int tipe) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/TipePrinterAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bits/bee/bpmc/databinding/ItemTipePrinterBinding;", "(Lcom/bits/bee/bpmc/databinding/ItemTipePrinterBinding;)V", "getBinding", "()Lcom/bits/bee/bpmc/databinding/ItemTipePrinterBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.bits.bee.bpmc.databinding.ItemTipePrinterBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.databinding.ItemTipePrinterBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.databinding.ItemTipePrinterBinding getBinding() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/tipe_printer/TipePrinterAdapter$PilihTipePrinterAddapterI;", "", "OnItemClick", "", "position", "", "app_debug"})
    public static abstract interface PilihTipePrinterAddapterI {
        
        public abstract void OnItemClick(int position);
    }
}