package com.bits.bee.bpmc.presentation.ui.setting_pos;

import java.lang.System;

/**
 * Created by aldi on 05/04/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b4\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0012J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010!J\t\u00105\u001a\u00020\u000bH\u00c6\u0003J\t\u00106\u001a\u00020\u0005H\u00c6\u0003J\t\u00107\u001a\u00020\u0005H\u00c6\u0003J\t\u00108\u001a\u00020\u0005H\u00c6\u0003J\u008a\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010=\u001a\u00020\tH\u00d6\u0001J\t\u0010>\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0017\"\u0004\b\u001a\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016\u00a8\u0006?"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewState;", "", "ukuranFont", "", "isMultiFont", "", "isKonfirmasiCustomer", "customer", "jumlahMeja", "", "presetBukaKasir", "", "isMuatGambarProduk", "isRekapPerCustomer", "isRekapPerProdukChannel", "isRekapPerFaktur", "isRekapPerChannel", "orientation", "(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;DZZZZZLjava/lang/String;)V", "getCustomer", "()Ljava/lang/String;", "setCustomer", "(Ljava/lang/String;)V", "()Z", "setKonfirmasiCustomer", "(Z)V", "setMuatGambarProduk", "setMultiFont", "setRekapPerChannel", "setRekapPerCustomer", "setRekapPerFaktur", "setRekapPerProdukChannel", "getJumlahMeja", "()Ljava/lang/Integer;", "setJumlahMeja", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getOrientation", "setOrientation", "getPresetBukaKasir", "()D", "setPresetBukaKasir", "(D)V", "getUkuranFont", "setUkuranFont", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;DZZZZZLjava/lang/String;)Lcom/bits/bee/bpmc/presentation/ui/setting_pos/SettingPosViewState;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class SettingPosViewState {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String ukuranFont;
    private boolean isMultiFont;
    private boolean isKonfirmasiCustomer;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String customer;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer jumlahMeja;
    private double presetBukaKasir;
    private boolean isMuatGambarProduk;
    private boolean isRekapPerCustomer;
    private boolean isRekapPerProdukChannel;
    private boolean isRekapPerFaktur;
    private boolean isRekapPerChannel;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String orientation;
    
    /**
     * Created by aldi on 05/04/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewState copy(@org.jetbrains.annotations.NotNull()
    java.lang.String ukuranFont, boolean isMultiFont, boolean isKonfirmasiCustomer, @org.jetbrains.annotations.Nullable()
    java.lang.String customer, @org.jetbrains.annotations.Nullable()
    java.lang.Integer jumlahMeja, double presetBukaKasir, boolean isMuatGambarProduk, boolean isRekapPerCustomer, boolean isRekapPerProdukChannel, boolean isRekapPerFaktur, boolean isRekapPerChannel, @org.jetbrains.annotations.NotNull()
    java.lang.String orientation) {
        return null;
    }
    
    /**
     * Created by aldi on 05/04/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 05/04/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 05/04/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public SettingPosViewState() {
        super();
    }
    
    public SettingPosViewState(@org.jetbrains.annotations.NotNull()
    java.lang.String ukuranFont, boolean isMultiFont, boolean isKonfirmasiCustomer, @org.jetbrains.annotations.Nullable()
    java.lang.String customer, @org.jetbrains.annotations.Nullable()
    java.lang.Integer jumlahMeja, double presetBukaKasir, boolean isMuatGambarProduk, boolean isRekapPerCustomer, boolean isRekapPerProdukChannel, boolean isRekapPerFaktur, boolean isRekapPerChannel, @org.jetbrains.annotations.NotNull()
    java.lang.String orientation) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUkuranFont() {
        return null;
    }
    
    public final void setUkuranFont(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean isMultiFont() {
        return false;
    }
    
    public final void setMultiFont(boolean p0) {
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean isKonfirmasiCustomer() {
        return false;
    }
    
    public final void setKonfirmasiCustomer(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCustomer() {
        return null;
    }
    
    public final void setCustomer(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getJumlahMeja() {
        return null;
    }
    
    public final void setJumlahMeja(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double getPresetBukaKasir() {
        return 0.0;
    }
    
    public final void setPresetBukaKasir(double p0) {
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean isMuatGambarProduk() {
        return false;
    }
    
    public final void setMuatGambarProduk(boolean p0) {
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean isRekapPerCustomer() {
        return false;
    }
    
    public final void setRekapPerCustomer(boolean p0) {
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean isRekapPerProdukChannel() {
        return false;
    }
    
    public final void setRekapPerProdukChannel(boolean p0) {
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean isRekapPerFaktur() {
        return false;
    }
    
    public final void setRekapPerFaktur(boolean p0) {
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean isRekapPerChannel() {
        return false;
    }
    
    public final void setRekapPerChannel(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrientation() {
        return null;
    }
    
    public final void setOrientation(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
}