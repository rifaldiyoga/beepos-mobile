package com.bits.bee.bpmc.data.data_source.local.dao;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.SaleAddOnEntity;
import java.lang.Class;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SaleAddOnDao_Impl implements SaleAddOnDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SaleAddOnEntity> __insertionAdapterOfSaleAddOnEntity;

  private final EntityDeletionOrUpdateAdapter<SaleAddOnEntity> __deletionAdapterOfSaleAddOnEntity;

  private final EntityDeletionOrUpdateAdapter<SaleAddOnEntity> __updateAdapterOfSaleAddOnEntity;

  public SaleAddOnDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSaleAddOnEntity = new EntityInsertionAdapter<SaleAddOnEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `saleaddon` (`id`,`sale_id`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaleAddOnEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getSaleId());
      }
    };
    this.__deletionAdapterOfSaleAddOnEntity = new EntityDeletionOrUpdateAdapter<SaleAddOnEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `saleaddon` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaleAddOnEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfSaleAddOnEntity = new EntityDeletionOrUpdateAdapter<SaleAddOnEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `saleaddon` SET `id` = ?,`sale_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaleAddOnEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getSaleId());
        stmt.bindLong(3, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends SaleAddOnEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final SaleAddOnEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends SaleAddOnEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSaleAddOnEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final SaleAddOnEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSaleAddOnEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final SaleAddOnEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSaleAddOnEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
