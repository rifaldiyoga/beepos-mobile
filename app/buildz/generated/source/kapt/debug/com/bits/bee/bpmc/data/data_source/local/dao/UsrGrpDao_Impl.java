package com.bits.bee.bpmc.data.data_source.local.dao;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.converter.Converters;
import com.bits.bee.bpmc.data.data_source.local.model.UsrGrpEntity;
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
public final class UsrGrpDao_Impl implements UsrGrpDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UsrGrpEntity> __insertionAdapterOfUsrGrpEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<UsrGrpEntity> __deletionAdapterOfUsrGrpEntity;

  private final EntityDeletionOrUpdateAdapter<UsrGrpEntity> __updateAdapterOfUsrGrpEntity;

  public UsrGrpDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUsrGrpEntity = new EntityInsertionAdapter<UsrGrpEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `usrgrp` (`id`,`usr_code`,`disabled`,`grp_id`,`usr_id`,`updated_at`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UsrGrpEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getUsrCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUsrCode());
        }
        final int _tmp = value.getDisabled() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        stmt.bindLong(4, value.getGrpId());
        if (value.getBpName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBpName());
        }
        final Long _tmp_1 = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp_1);
        }
      }
    };
    this.__deletionAdapterOfUsrGrpEntity = new EntityDeletionOrUpdateAdapter<UsrGrpEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `usrgrp` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UsrGrpEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfUsrGrpEntity = new EntityDeletionOrUpdateAdapter<UsrGrpEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `usrgrp` SET `id` = ?,`usr_code` = ?,`disabled` = ?,`grp_id` = ?,`usr_id` = ?,`updated_at` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UsrGrpEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getUsrCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUsrCode());
        }
        final int _tmp = value.getDisabled() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        stmt.bindLong(4, value.getGrpId());
        if (value.getBpName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBpName());
        }
        final Long _tmp_1 = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp_1);
        }
        stmt.bindLong(7, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends UsrGrpEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final UsrGrpEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends UsrGrpEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUsrGrpEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final UsrGrpEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUsrGrpEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final UsrGrpEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUsrGrpEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
