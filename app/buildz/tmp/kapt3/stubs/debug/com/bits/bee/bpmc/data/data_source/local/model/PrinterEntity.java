package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "printer")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b(\b\u0087\b\u0018\u0000 12\u00020\u0001:\u00011BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000eJ\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\nH\u00c6\u0003J\t\u0010)\u001a\u00020\nH\u00c6\u0003J\t\u0010*\u001a\u00020\nH\u00c6\u0003J\t\u0010+\u001a\u00020\nH\u00c6\u0003Jc\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\nH\u00c6\u0001J\u0013\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001J\t\u00100\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0017\"\u0004\b\u001a\u0010\u0019R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001e\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016\u00a8\u00062"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/PrinterEntity;", "", "id", "", "printerName", "", "address", "tipe", "size", "isReceipt", "", "isKitchen", "isReport", "isChecker", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZZZ)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "()Z", "setChecker", "(Z)V", "setKitchen", "setReceipt", "setReport", "getPrinterName", "setPrinterName", "getSize", "setSize", "getTipe", "setTipe", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class PrinterEntity {
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "printername")
    private java.lang.String printerName;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "address")
    private java.lang.String address;
    @androidx.room.ColumnInfo(name = "tipe")
    private int tipe;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "size")
    private java.lang.String size;
    @androidx.room.ColumnInfo(name = "is_receipt")
    private boolean isReceipt;
    @androidx.room.ColumnInfo(name = "is_kitchen")
    private boolean isKitchen;
    @androidx.room.ColumnInfo(name = "is_report")
    private boolean isReport;
    @androidx.room.ColumnInfo(name = "is_checker")
    private boolean isChecker;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "printer";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PRINTERNAME = "printername";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ADDRESS = "address";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TIPE = "tipe";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SIZE = "size";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_RECEIPT = "is_receipt";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_KITCHEN = "is_kitchen";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_REPORT = "is_report";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_CHECKER = "is_checker";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KITCHENNAME = "kitchen";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String printerName, @org.jetbrains.annotations.NotNull()
    java.lang.String address, int tipe, @org.jetbrains.annotations.NotNull()
    java.lang.String size, boolean isReceipt, boolean isKitchen, boolean isReport, boolean isChecker) {
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
    
    public PrinterEntity(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String printerName, @org.jetbrains.annotations.NotNull()
    java.lang.String address, int tipe, @org.jetbrains.annotations.NotNull()
    java.lang.String size, boolean isReceipt, boolean isKitchen, boolean isReport, boolean isChecker) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPrinterName() {
        return null;
    }
    
    public final void setPrinterName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAddress() {
        return null;
    }
    
    public final void setAddress(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getTipe() {
        return 0;
    }
    
    public final void setTipe(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSize() {
        return null;
    }
    
    public final void setSize(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean isReceipt() {
        return false;
    }
    
    public final void setReceipt(boolean p0) {
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean isKitchen() {
        return false;
    }
    
    public final void setKitchen(boolean p0) {
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean isReport() {
        return false;
    }
    
    public final void setReport(boolean p0) {
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean isChecker() {
        return false;
    }
    
    public final void setChecker(boolean p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/PrinterEntity$Companion;", "", "()V", "ADDRESS", "", "ID", "IS_CHECKER", "IS_KITCHEN", "IS_RECEIPT", "IS_REPORT", "KITCHENNAME", "PRINTERNAME", "SIZE", "TBL_NAME", "TIPE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}