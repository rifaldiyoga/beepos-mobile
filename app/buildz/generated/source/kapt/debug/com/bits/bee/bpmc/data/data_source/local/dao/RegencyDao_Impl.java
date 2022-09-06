package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity;
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
public final class RegencyDao_Impl implements RegencyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RegencyEntity> __insertionAdapterOfRegencyEntity;

  private final EntityDeletionOrUpdateAdapter<RegencyEntity> __deletionAdapterOfRegencyEntity;

  private final EntityDeletionOrUpdateAdapter<RegencyEntity> __updateAdapterOfRegencyEntity;

  public RegencyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRegencyEntity = new EntityInsertionAdapter<RegencyEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `regency` (`code`,`name`,`province_code`,`active`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RegencyEntity value) {
        if (value.getCode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCode());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getProvinceCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProvinceCode());
        }
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(4, _tmp);
      }
    };
    this.__deletionAdapterOfRegencyEntity = new EntityDeletionOrUpdateAdapter<RegencyEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `regency` WHERE `code` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RegencyEntity value) {
        if (value.getCode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCode());
        }
      }
    };
    this.__updateAdapterOfRegencyEntity = new EntityDeletionOrUpdateAdapter<RegencyEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `regency` SET `code` = ?,`name` = ?,`province_code` = ?,`active` = ? WHERE `code` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RegencyEntity value) {
        if (value.getCode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCode());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getProvinceCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProvinceCode());
        }
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCode());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends RegencyEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final RegencyEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends RegencyEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRegencyEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final RegencyEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRegencyEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final RegencyEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfRegencyEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<RegencyEntity> getRegencyList() {
    final String _sql = "SELECT * FROM regency";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfProvinceCode = CursorUtil.getColumnIndexOrThrow(_cursor, "province_code");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final List<RegencyEntity> _result = new ArrayList<RegencyEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final RegencyEntity _item;
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
        final String _tmpProvinceCode;
        if (_cursor.isNull(_cursorIndexOfProvinceCode)) {
          _tmpProvinceCode = null;
        } else {
          _tmpProvinceCode = _cursor.getString(_cursorIndexOfProvinceCode);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        _item = new RegencyEntity(_tmpCode,_tmpName,_tmpProvinceCode,_tmpIsActive);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<RegencyEntity> searchRegencyList(final String query) {
    final String _sql = "SELECT * FROM regency WHERE active = 1 AND name LIKE '%'|| ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfProvinceCode = CursorUtil.getColumnIndexOrThrow(_cursor, "province_code");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final List<RegencyEntity> _result = new ArrayList<RegencyEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final RegencyEntity _item;
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
        final String _tmpProvinceCode;
        if (_cursor.isNull(_cursorIndexOfProvinceCode)) {
          _tmpProvinceCode = null;
        } else {
          _tmpProvinceCode = _cursor.getString(_cursorIndexOfProvinceCode);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        _item = new RegencyEntity(_tmpCode,_tmpName,_tmpProvinceCode,_tmpIsActive);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public RegencyEntity getCodeByName(final String name) {
    final String _sql = "SELECT * FROM regency WHERE name = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfProvinceCode = CursorUtil.getColumnIndexOrThrow(_cursor, "province_code");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final RegencyEntity _result;
      if(_cursor.moveToFirst()) {
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
        final String _tmpProvinceCode;
        if (_cursor.isNull(_cursorIndexOfProvinceCode)) {
          _tmpProvinceCode = null;
        } else {
          _tmpProvinceCode = _cursor.getString(_cursorIndexOfProvinceCode);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        _result = new RegencyEntity(_tmpCode,_tmpName,_tmpProvinceCode,_tmpIsActive);
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
  public RegencyEntity getNameByCode(final String code) {
    final String _sql = "SELECT * FROM regency WHERE code = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (code == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, code);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfProvinceCode = CursorUtil.getColumnIndexOrThrow(_cursor, "province_code");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final RegencyEntity _result;
      if(_cursor.moveToFirst()) {
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
        final String _tmpProvinceCode;
        if (_cursor.isNull(_cursorIndexOfProvinceCode)) {
          _tmpProvinceCode = null;
        } else {
          _tmpProvinceCode = _cursor.getString(_cursorIndexOfProvinceCode);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        _result = new RegencyEntity(_tmpCode,_tmpName,_tmpProvinceCode,_tmpIsActive);
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
