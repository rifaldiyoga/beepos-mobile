package com.bits.bee.bpmc.data.data_source.local.dao;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.converter.Converters;
import com.bits.bee.bpmc.data.data_source.local.model.UnitDummyEntity;
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
public final class UnitDummyDao_Impl implements UnitDummyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UnitDummyEntity> __insertionAdapterOfUnitDummyEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<UnitDummyEntity> __deletionAdapterOfUnitDummyEntity;

  private final EntityDeletionOrUpdateAdapter<UnitDummyEntity> __updateAdapterOfUnitDummyEntity;

  public UnitDummyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUnitDummyEntity = new EntityInsertionAdapter<UnitDummyEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `unit_dummy` (`id`,`item_id`,`idx`,`unit`,`conv`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UnitDummyEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getItemId());
        stmt.bindLong(3, value.getIdx());
        if (value.getUnit() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUnit());
        }
        final String _tmp = __converters.bigDecimalToString(value.getConv());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp);
        }
      }
    };
    this.__deletionAdapterOfUnitDummyEntity = new EntityDeletionOrUpdateAdapter<UnitDummyEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `unit_dummy` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UnitDummyEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfUnitDummyEntity = new EntityDeletionOrUpdateAdapter<UnitDummyEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `unit_dummy` SET `id` = ?,`item_id` = ?,`idx` = ?,`unit` = ?,`conv` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UnitDummyEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getItemId());
        stmt.bindLong(3, value.getIdx());
        if (value.getUnit() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUnit());
        }
        final String _tmp = __converters.bigDecimalToString(value.getConv());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp);
        }
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends UnitDummyEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final UnitDummyEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends UnitDummyEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUnitDummyEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final UnitDummyEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUnitDummyEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final UnitDummyEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUnitDummyEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
