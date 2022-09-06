package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.converter.Converters;
import com.bits.bee.bpmc.data.data_source.local.model.ItemKitchenEntity;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ItemKitchenDao_Impl implements ItemKitchenDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemKitchenEntity> __insertionAdapterOfItemKitchenEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<ItemKitchenEntity> __deletionAdapterOfItemKitchenEntity;

  private final EntityDeletionOrUpdateAdapter<ItemKitchenEntity> __updateAdapterOfItemKitchenEntity;

  public ItemKitchenDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemKitchenEntity = new EntityInsertionAdapter<ItemKitchenEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `item_kitchen` (`id`,`item_id`,`kitchen_id`,`created_by`,`created_at`,`updated_by`,`updated_at`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemKitchenEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getItemId());
        stmt.bindLong(3, value.getKitchenId());
        if (value.getCreatedBy() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getCreatedBy());
        }
        final Long _tmp = __converters.dateToLong(value.getCreatedAt());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        if (value.getUpdatedBy() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getUpdatedBy());
        }
        final Long _tmp_1 = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp_1 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp_1);
        }
      }
    };
    this.__deletionAdapterOfItemKitchenEntity = new EntityDeletionOrUpdateAdapter<ItemKitchenEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `item_kitchen` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemKitchenEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfItemKitchenEntity = new EntityDeletionOrUpdateAdapter<ItemKitchenEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `item_kitchen` SET `id` = ?,`item_id` = ?,`kitchen_id` = ?,`created_by` = ?,`created_at` = ?,`updated_by` = ?,`updated_at` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemKitchenEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getItemId());
        stmt.bindLong(3, value.getKitchenId());
        if (value.getCreatedBy() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getCreatedBy());
        }
        final Long _tmp = __converters.dateToLong(value.getCreatedAt());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        if (value.getUpdatedBy() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getUpdatedBy());
        }
        final Long _tmp_1 = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp_1 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp_1);
        }
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends ItemKitchenEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final ItemKitchenEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends ItemKitchenEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemKitchenEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ItemKitchenEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemKitchenEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ItemKitchenEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfItemKitchenEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ItemKitchenEntity> getItemKitchen() {
    final String _sql = "SELECT * FROM item_kitchen";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfKitchenId = CursorUtil.getColumnIndexOrThrow(_cursor, "kitchen_id");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final List<ItemKitchenEntity> _result = new ArrayList<ItemKitchenEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemKitchenEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        final int _tmpKitchenId;
        _tmpKitchenId = _cursor.getInt(_cursorIndexOfKitchenId);
        final Integer _tmpCreatedBy;
        if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
          _tmpCreatedBy = null;
        } else {
          _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        }
        final Date _tmpCreatedAt;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp);
        final Integer _tmpUpdatedBy;
        if (_cursor.isNull(_cursorIndexOfUpdatedBy)) {
          _tmpUpdatedBy = null;
        } else {
          _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        }
        final Date _tmpUpdatedAt;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfUpdatedAt);
        }
        _tmpUpdatedAt = __converters.longToDate(_tmp_1);
        _item = new ItemKitchenEntity(_tmpId,_tmpItemId,_tmpKitchenId,_tmpCreatedBy,_tmpCreatedAt,_tmpUpdatedBy,_tmpUpdatedAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
