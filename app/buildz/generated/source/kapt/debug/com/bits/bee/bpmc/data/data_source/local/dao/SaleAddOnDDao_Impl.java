package com.bits.bee.bpmc.data.data_source.local.dao;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.SaleAddOnDEntity;
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
public final class SaleAddOnDDao_Impl implements SaleAddOnDDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SaleAddOnDEntity> __insertionAdapterOfSaleAddOnDEntity;

  private final EntityDeletionOrUpdateAdapter<SaleAddOnDEntity> __deletionAdapterOfSaleAddOnDEntity;

  private final EntityDeletionOrUpdateAdapter<SaleAddOnDEntity> __updateAdapterOfSaleAddOnDEntity;

  public SaleAddOnDDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSaleAddOnDEntity = new EntityInsertionAdapter<SaleAddOnDEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `saleaddond` (`id`,`saledaddon_id`,`up_saled_id`,`saled_id`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaleAddOnDEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getSaleAddOnId());
        stmt.bindLong(3, value.getUpSaledId());
        stmt.bindLong(4, value.getSaledId());
      }
    };
    this.__deletionAdapterOfSaleAddOnDEntity = new EntityDeletionOrUpdateAdapter<SaleAddOnDEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `saleaddond` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaleAddOnDEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfSaleAddOnDEntity = new EntityDeletionOrUpdateAdapter<SaleAddOnDEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `saleaddond` SET `id` = ?,`saledaddon_id` = ?,`up_saled_id` = ?,`saled_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaleAddOnDEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getSaleAddOnId());
        stmt.bindLong(3, value.getUpSaledId());
        stmt.bindLong(4, value.getSaledId());
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends SaleAddOnDEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final SaleAddOnDEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends SaleAddOnDEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSaleAddOnDEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final SaleAddOnDEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSaleAddOnDEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final SaleAddOnDEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSaleAddOnDEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
