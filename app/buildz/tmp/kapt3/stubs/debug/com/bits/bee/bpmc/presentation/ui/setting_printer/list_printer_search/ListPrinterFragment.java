package com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\"\b\u0002\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0004\u00a2\u0006\u0002\u0010\bJ\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J\u0006\u00106\u001a\u000204J\u0006\u00107\u001a\u000204J\u0006\u00108\u001a\u000204J\b\u00109\u001a\u000204H\u0016J\b\u0010:\u001a\u000204H\u0016J\u0006\u0010;\u001a\u000204J\b\u0010<\u001a\u000204H\u0016J\b\u0010=\u001a\u000204H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R.\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\'0&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020 0)X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b/\u00100\u00a8\u0006>"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_printer/list_printer_search/ListPrinterFragment;", "Lcom/bits/bee/bpmc/presentation/base/BaseFragment;", "Lcom/bits/bee/bpmc/databinding/FragmentSettingListPrinterBinding;", "bindingInflater", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "(Lkotlin/jvm/functions/Function3;)V", "REQUEST_ENABLE_BLUETOOTH", "", "getBindingInflater", "()Lkotlin/jvm/functions/Function3;", "deviceName", "", "getDeviceName", "()Ljava/lang/String;", "setDeviceName", "(Ljava/lang/String;)V", "findPrinterAdapter", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/list_printer_search/FindPrinterAdapter;", "getFindPrinterAdapter", "()Lcom/bits/bee/bpmc/presentation/ui/setting_printer/list_printer_search/FindPrinterAdapter;", "setFindPrinterAdapter", "(Lcom/bits/bee/bpmc/presentation/ui/setting_printer/list_printer_search/FindPrinterAdapter;)V", "mBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getMBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "setMBluetoothAdapter", "(Landroid/bluetooth/BluetoothAdapter;)V", "mDevice", "Landroid/bluetooth/BluetoothDevice;", "getMDevice", "()Landroid/bluetooth/BluetoothDevice;", "setMDevice", "(Landroid/bluetooth/BluetoothDevice;)V", "mListPrinter", "", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/list_printer_search/ListPrinter;", "m_pairedDevices", "", "receiver", "Landroid/content/BroadcastReceiver;", "receiver2", "viewModel", "Lcom/bits/bee/bpmc/presentation/ui/setting_printer/list_printer_search/FindPrinterViewModel;", "getViewModel", "()Lcom/bits/bee/bpmc/presentation/ui/setting_printer/list_printer_search/FindPrinterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkBTPermission", "", "enableDiscover", "evenDiscover", "init", "initBinding", "initComponents", "onDestroy", "stopDiscovery", "subscribeListeners", "subscribeObservers", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class ListPrinterFragment extends com.bits.bee.bpmc.presentation.base.BaseFragment<com.bits.bee.bpmc.databinding.FragmentSettingListPrinterBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentSettingListPrinterBinding> bindingInflater = null;
    public android.bluetooth.BluetoothAdapter mBluetoothAdapter;
    public android.bluetooth.BluetoothDevice mDevice;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String deviceName = "My_Device_Name";
    private java.util.List<com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search.ListPrinter> mListPrinter;
    public com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search.FindPrinterAdapter findPrinterAdapter;
    private final int REQUEST_ENABLE_BLUETOOTH = 1;
    private java.util.Set<android.bluetooth.BluetoothDevice> m_pairedDevices;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final android.content.BroadcastReceiver receiver = null;
    private final android.content.BroadcastReceiver receiver2 = null;
    
    public ListPrinterFragment() {
        super();
    }
    
    public ListPrinterFragment(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? super java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentSettingListPrinterBinding> bindingInflater) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, com.bits.bee.bpmc.databinding.FragmentSettingListPrinterBinding> getBindingInflater() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.bluetooth.BluetoothAdapter getMBluetoothAdapter() {
        return null;
    }
    
    public final void setMBluetoothAdapter(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.bluetooth.BluetoothDevice getMDevice() {
        return null;
    }
    
    public final void setMDevice(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeviceName() {
        return null;
    }
    
    public final void setDeviceName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search.FindPrinterAdapter getFindPrinterAdapter() {
        return null;
    }
    
    public final void setFindPrinterAdapter(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search.FindPrinterAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search.FindPrinterViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void initComponents() {
    }
    
    public final void init() {
    }
    
    public final void stopDiscovery() {
    }
    
    @java.lang.Override()
    public void subscribeListeners() {
    }
    
    @java.lang.Override()
    public void subscribeObservers() {
    }
    
    public final void enableDiscover() {
    }
    
    public final void evenDiscover() {
    }
    
    public final void checkBTPermission() {
    }
    
    public final void initBinding() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
}