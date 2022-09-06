package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.DistrictEntity;
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
public final class DistrictDao_Impl implements DistrictDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DistrictEntity> __insertionAdapterOfDistrictEntity;

  private final EntityDeletionOrUpdateAdapter<DistrictEntity> __deletionAdapterOfDistrictEntity;

  private final EntityDeletionOrUpdateAdapter<DistrictEntity> __updateAdapterOfDistrictEntity;

  public DistrictDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDistrictEntity = new EntityInsertionAdapter<DistrictEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `district` (`code`,`name`,`regency_code`,`active`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DistrictEntity value) {
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
        if (value.getRegencyCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRegencyCode());
        }
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(4, _tmp);
      }
    };
    this.__deletionAdapterOfDistrictEntity = new EntityDeletionOrUpdateAdapter<DistrictEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `district` WHERE `code` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DistrictEntity value) {
        if (value.getCode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCode());
        }
      }
    };
    this.__updateAdapterOfDistrictEntity = new EntityDeletionOrUpdateAdapter<DistrictEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `district` SET `code` = ?,`name` = ?,`regency_code` = ?,`active` = ? WHERE `code` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DistrictEntity value) {
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
        if (value.getRegencyCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRegencyCode());
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
  public Object insertBulk(final List<? extends DistrictEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final DistrictEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends DistrictEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDistrictEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final DistrictEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDistrictEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final DistrictEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfDistrictEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<DistrictEntity> getDistrictList() {
    final String _sql = "SELECT * FROM district";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfRegencyCode = CursorUtil.getColumnIndexOrThrow(_cursor, "regency_code");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final List<DistrictEntity> _result = new ArrayList<DistrictEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DistrictEntity _item;
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
        final String _tmpRegencyCode;
        if (_cursor.isNull(_cursorIndexOfRegencyCode)) {
          _tmpRegencyCode = null;
        } else {
          _tmpRegencyCode = _cursor.getString(_cursorIndexOfRegencyCode);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        _item = new DistrictEntity(_tmpCode,_tmpName,_tmpRegencyCode,_tmpIsActive);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<DistrictEntity> getListDistrictByCode(final String code) {
    final String _sql = "SELECT * FROM district where regency_code = ?";
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
      final int _cursorIndexOfRegencyCode = CursorUtil.getColumnIndexOrThrow(_cursor, "regency_code");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final List<DistrictEntity> _result = new ArrayList<DistrictEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DistrictEntity _item;
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
        final String _tmpRegencyCode;
        if (_cursor.isNull(_cursorIndexOfRegencyCode)) {
          _tmpRegencyCode = null;
        } else {
          _tmpRegencyCode = _cursor.getString(_cursorIndexOfRegencyCode);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        _item = new DistrictEntity(_tmpCode,_tmpName,_tmpRegencyCode,_tmpIsActive);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public DistrictEntity getCodeByName(final String name) {
    final String _sql = "SELECT * FROM district WHERE name = ?";
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
      final int _cursorIndexOfRegencyCode = CursorUtil.getColumnIndexOrThrow(_cursor, "regency_code");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final DistrictEntity _result;
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
        final String _tmpRegencyCode;
        if (_cursor.isNull(_cursorIndexOfRegencyCode)) {
          _tmpRegencyCode = null;
        } else {
          _tmpRegencyCode = _cursor.getString(_cursorIndexOfRegencyCode);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        _result = new DistrictEntity(_tmpCode,_tmpName,_tmpRegencyCode,_tmpIsActive);
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
  public DistrictEntity getNameByCode(final String code) {
    final String _sql = "SELECT * FROM district WHERE code = ?";
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
      final int _cursorIndexOfRegencyCode = CursorUtil.getColumnIndexOrThrow(_cursor, "regency_code");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final DistrictEntity _result;
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
        final String _tmpRegencyCode;
        if (_cursor.isNull(_cursorIndexOfRegencyCode)) {
          _tmpRegencyCode = null;
        } else {
          _tmpRegencyCode = _cursor.getString(_cursorIndexOfRegencyCode);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        _result = new DistrictEntity(_tmpCode,_tmpName,_tmpRegencyCode,_tmpIsActive);
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
