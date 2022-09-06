package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

/**
 * Created by aldi on 20/05/22.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\'J$\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\'J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0007H\'J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0007H\'J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0007H\'J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0007H\'J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0007H\'J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0007H\'\u00a8\u0006\u0015"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/SaleEntity;", "getLatestDraftList", "", "getLatestSaleList", "Landroidx/paging/PagingSource;", "", "query", "", "isDraft", "", "getSaleByPosses", "id", "getTotalNota", "Ljava/math/BigDecimal;", "getTotalNotaVoid", "getTotalPaidDebit", "getTotalPaidGopay", "getTotalPaidKredit", "getTotalPaidTunai", "app_debug"})
public abstract interface SaleDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.SaleEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM sale WHERE draft = :isDraft AND (trx_no LIKE \'%\' || :query || \'%\' OR bp_name LIKE \'%\' || :query || \'%\') ORDER BY id DESC")
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.bits.bee.bpmc.data.data_source.local.model.SaleEntity> getLatestSaleList(@org.jetbrains.annotations.NotNull()
    java.lang.String query, boolean isDraft);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM sale WHERE draft = 1 ORDER BY id DESC LIMIT 5")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.SaleEntity> getLatestDraftList();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM sale WHERE posses_id = :id AND draft = 0")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.SaleEntity> getSaleByPosses(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT COUNT(*) FROM sale WHERE posses_id = :id and isvoid = 0 and draft = 0")
    public abstract java.math.BigDecimal getTotalNota(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT COUNT(*) FROM sale WHERE posses_id = :id and isvoid = 1")
    public abstract java.math.BigDecimal getTotalNotaVoid(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT SUM(total) FROM sale WHERE posses_id = :id and termtype = \'TUNAI\' and isvoid = 0")
    public abstract java.math.BigDecimal getTotalPaidTunai(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT SUM(total) FROM sale WHERE posses_id = :id and termtype = \'Debit Card\' and isvoid = 0")
    public abstract java.math.BigDecimal getTotalPaidDebit(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT SUM(total) FROM sale WHERE posses_id = :id and termtype = \'Credit Card\' and isvoid = 0")
    public abstract java.math.BigDecimal getTotalPaidKredit(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT SUM(total) FROM sale WHERE posses_id = :id and termtype = \'GOPAY\' and isvoid = 0")
    public abstract java.math.BigDecimal getTotalPaidGopay(int id);
}