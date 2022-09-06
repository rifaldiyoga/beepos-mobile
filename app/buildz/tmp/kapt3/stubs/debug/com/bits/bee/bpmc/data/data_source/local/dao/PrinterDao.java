package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\'J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\'J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\'J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\'\u00a8\u0006\u0015"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/PrinterDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/PrinterEntity;", "getLastId", "readByActiveChecker", "", "isChecker", "", "readByActiveKitchen", "isKitchen", "readByActiveReceipt", "isReceipt", "readByActiveReport", "isReport", "readByAddress", "id", "", "readByTipe", "tipe", "", "readPrinter", "app_debug"})
public abstract interface PrinterDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM printer where address = :id ")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity> readByAddress(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM printer where is_receipt = :isReceipt ")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity> readByActiveReceipt(boolean isReceipt);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM printer where is_report = :isReport ")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity> readByActiveReport(boolean isReport);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM printer where is_kitchen = :isKitchen ")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity> readByActiveKitchen(boolean isKitchen);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM printer where is_checker = :isChecker ")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity> readByActiveChecker(boolean isChecker);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM printer where tipe = :tipe")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity> readByTipe(int tipe);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM printer ORDER BY id DESC LIMIT 1")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity getLastId();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM printer")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity> readPrinter();
}