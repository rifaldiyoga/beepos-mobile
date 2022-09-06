package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

/**
 * Created by aldi on 20/05/22.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\'\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/SaledDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/SaledEntity;", "getRankItem", "", "Lcom/bits/bee/bpmc/data/data_source/local/model/RankItemEntity;", "possesId", "", "getSaledList", "id", "app_debug"})
public abstract interface SaledDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.SaledEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM saled WHERE sale_id = :id")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.SaledEntity> getSaledList(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select a.name, sum(qty) qty, sum(a.subtotal) total from saled a JOIN sale d ON d.id = a.sale_id WHERE d.posses_id = :possesId AND d.isvoid = 0 group by item_id order by qty DESC LIMIT 10")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.RankItemEntity> getRankItem(int possesId);
}