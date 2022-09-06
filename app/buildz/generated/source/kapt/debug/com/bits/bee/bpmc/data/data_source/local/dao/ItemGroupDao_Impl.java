package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity;
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
public final class ItemGroupDao_Impl implements ItemGroupDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemGroupEntity> __insertionAdapterOfItemGroupEntity;

  private final EntityDeletionOrUpdateAdapter<ItemGroupEntity> __deletionAdapterOfItemGroupEntity;

  private final EntityDeletionOrUpdateAdapter<ItemGroupEntity> __updateAdapterOfItemGroupEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ItemGroupDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemGroupEntity = new EntityInsertionAdapter<ItemGroupEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `itemgrp` (`id`,`code`,`name`,`level`,`up_id`,`ispos`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemGroupEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCode());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        stmt.bindLong(4, value.getLevel());
        stmt.bindLong(5, value.getUpId());
        final int _tmp = value.isPos() ? 1 : 0;
        stmt.bindLong(6, _tmp);
      }
    };
    this.__deletionAdapterOfItemGroupEntity = new EntityDeletionOrUpdateAdapter<ItemGroupEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `itemgrp` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemGroupEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfItemGroupEntity = new EntityDeletionOrUpdateAdapter<ItemGroupEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `itemgrp` SET `id` = ?,`code` = ?,`name` = ?,`level` = ?,`up_id` = ?,`ispos` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemGroupEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCode());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        stmt.bindLong(4, value.getLevel());
        stmt.bindLong(5, value.getUpId());
        final int _tmp = value.isPos() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        stmt.bindLong(7, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM itemgrp";
        return _query;
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends ItemGroupEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final ItemGroupEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends ItemGroupEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemGroupEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ItemGroupEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemGroupEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ItemGroupEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfItemGroupEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<ItemGroupEntity> getItemGroupList() {
    final String _sql = "SELECT * FROM itemgrp";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
      final int _cursorIndexOfUpId = CursorUtil.getColumnIndexOrThrow(_cursor, "up_id");
      final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(_cursor, "ispos");
      final List<ItemGroupEntity> _result = new ArrayList<ItemGroupEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemGroupEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        final int _tmpUpId;
        _tmpUpId = _cursor.getInt(_cursorIndexOfUpId);
        final boolean _tmpIsPos;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPos);
        _tmpIsPos = _tmp != 0;
        _item = new ItemGroupEntity(_tmpId,_tmpCode,_tmpName,_tmpLevel,_tmpUpId,_tmpIsPos);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemGroupEntity> getActiveItemGroupList() {
    final String _sql = "SELECT * FROM itemgrp WHERE ispos = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
      final int _cursorIndexOfUpId = CursorUtil.getColumnIndexOrThrow(_cursor, "up_id");
      final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(_cursor, "ispos");
      final List<ItemGroupEntity> _result = new ArrayList<ItemGroupEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemGroupEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        final int _tmpUpId;
        _tmpUpId = _cursor.getInt(_cursorIndexOfUpId);
        final boolean _tmpIsPos;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPos);
        _tmpIsPos = _tmp != 0;
        _item = new ItemGroupEntity(_tmpId,_tmpCode,_tmpName,_tmpLevel,_tmpUpId,_tmpIsPos);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemGroupEntity> getItgrpNotAddon(final boolean ispos) {
    final String _sql = "SELECT * FROM itemgrp WHERE code = 'ADDON' AND ispos = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp = ispos ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
      final int _cursorIndexOfUpId = CursorUtil.getColumnIndexOrThrow(_cursor, "up_id");
      final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(_cursor, "ispos");
      final List<ItemGroupEntity> _result = new ArrayList<ItemGroupEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemGroupEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        final int _tmpUpId;
        _tmpUpId = _cursor.getInt(_cursorIndexOfUpId);
        final boolean _tmpIsPos;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsPos);
        _tmpIsPos = _tmp_1 != 0;
        _item = new ItemGroupEntity(_tmpId,_tmpCode,_tmpName,_tmpLevel,_tmpUpId,_tmpIsPos);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ItemGroupEntity getId(final int id) {
    final String _sql = "SELECT * FROM itemgrp WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
      final int _cursorIndexOfUpId = CursorUtil.getColumnIndexOrThrow(_cursor, "up_id");
      final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(_cursor, "ispos");
      final ItemGroupEntity _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        final int _tmpUpId;
        _tmpUpId = _cursor.getInt(_cursorIndexOfUpId);
        final boolean _tmpIsPos;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPos);
        _tmpIsPos = _tmp != 0;
        _result = new ItemGroupEntity(_tmpId,_tmpCode,_tmpName,_tmpLevel,_tmpUpId,_tmpIsPos);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemGroupEntity> getItemgrpKitchen() {
    final String _sql = "SELECT * FROM itemgrp where ispos = 1 AND NOT code = 1 AND NOT code = '*'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
      final int _cursorIndexOfUpId = CursorUtil.getColumnIndexOrThrow(_cursor, "up_id");
      final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(_cursor, "ispos");
      final List<ItemGroupEntity> _result = new ArrayList<ItemGroupEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemGroupEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        final int _tmpUpId;
        _tmpUpId = _cursor.getInt(_cursorIndexOfUpId);
        final boolean _tmpIsPos;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPos);
        _tmpIsPos = _tmp != 0;
        _item = new ItemGroupEntity(_tmpId,_tmpCode,_tmpName,_tmpLevel,_tmpUpId,_tmpIsPos);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ItemGroupEntity getItgrpAddOn() {
    final String _sql = "SELECT * FROM itemgrp WHERE code = 'ADDON'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
      final int _cursorIndexOfUpId = CursorUtil.getColumnIndexOrThrow(_cursor, "up_id");
      final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(_cursor, "ispos");
      final ItemGroupEntity _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        final int _tmpUpId;
        _tmpUpId = _cursor.getInt(_cursorIndexOfUpId);
        final boolean _tmpIsPos;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPos);
        _tmpIsPos = _tmp != 0;
        _result = new ItemGroupEntity(_tmpId,_tmpCode,_tmpName,_tmpLevel,_tmpUpId,_tmpIsPos);
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
