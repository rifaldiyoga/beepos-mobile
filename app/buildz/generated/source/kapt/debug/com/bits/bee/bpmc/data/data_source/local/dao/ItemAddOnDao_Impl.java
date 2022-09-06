package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.ItemAddOnEntity;
import java.lang.Class;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ItemAddOnDao_Impl implements ItemAddOnDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemAddOnEntity> __insertionAdapterOfItemAddOnEntity;

  private final EntityDeletionOrUpdateAdapter<ItemAddOnEntity> __deletionAdapterOfItemAddOnEntity;

  private final EntityDeletionOrUpdateAdapter<ItemAddOnEntity> __updateAdapterOfItemAddOnEntity;

  public ItemAddOnDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemAddOnEntity = new EntityInsertionAdapter<ItemAddOnEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `itemaddon` (`id`,`addon`,`code`,`item_id`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemAddOnEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getAddOnId());
        if (value.getCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCode());
        }
        stmt.bindLong(4, value.getItemId());
      }
    };
    this.__deletionAdapterOfItemAddOnEntity = new EntityDeletionOrUpdateAdapter<ItemAddOnEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `itemaddon` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemAddOnEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfItemAddOnEntity = new EntityDeletionOrUpdateAdapter<ItemAddOnEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `itemaddon` SET `id` = ?,`addon` = ?,`code` = ?,`item_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemAddOnEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getAddOnId());
        if (value.getCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCode());
        }
        stmt.bindLong(4, value.getItemId());
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends ItemAddOnEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final ItemAddOnEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends ItemAddOnEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemAddOnEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ItemAddOnEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemAddOnEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ItemAddOnEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfItemAddOnEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ItemAddOnEntity> getItemAddOnList() {
    final String _sql = "SELECT * FROM itemaddon";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfAddOnId = CursorUtil.getColumnIndexOrThrow(_cursor, "addon");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final List<ItemAddOnEntity> _result = new ArrayList<ItemAddOnEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemAddOnEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpAddOnId;
        _tmpAddOnId = _cursor.getInt(_cursorIndexOfAddOnId);
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _item = new ItemAddOnEntity(_tmpId,_tmpAddOnId,_tmpCode,_tmpItemId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ItemAddOnEntity getItemAddOnByItem(final int itemId) {
    final String _sql = "SELECT * FROM itemaddon where item_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, itemId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfAddOnId = CursorUtil.getColumnIndexOrThrow(_cursor, "addon");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final ItemAddOnEntity _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpAddOnId;
        _tmpAddOnId = _cursor.getInt(_cursorIndexOfAddOnId);
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _result = new ItemAddOnEntity(_tmpId,_tmpAddOnId,_tmpCode,_tmpItemId);
      } else {
        _result = null;
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
