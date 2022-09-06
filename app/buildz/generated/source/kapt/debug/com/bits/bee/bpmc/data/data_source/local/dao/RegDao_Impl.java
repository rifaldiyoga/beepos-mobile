package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.RegEntity;
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
public final class RegDao_Impl implements RegDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RegEntity> __insertionAdapterOfRegEntity;

  private final EntityDeletionOrUpdateAdapter<RegEntity> __deletionAdapterOfRegEntity;

  private final EntityDeletionOrUpdateAdapter<RegEntity> __updateAdapterOfRegEntity;

  public RegDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRegEntity = new EntityInsertionAdapter<RegEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `reg` (`code`,`name`,`value`,`isvisible`,`modul_code`,`validator`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RegEntity value) {
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
        if (value.getValue() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getValue());
        }
        final int _tmp = value.isVisible() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getModulCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModulCode());
        }
        if (value.getValidator() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getValidator());
        }
      }
    };
    this.__deletionAdapterOfRegEntity = new EntityDeletionOrUpdateAdapter<RegEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `reg` WHERE `code` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RegEntity value) {
        if (value.getCode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCode());
        }
      }
    };
    this.__updateAdapterOfRegEntity = new EntityDeletionOrUpdateAdapter<RegEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `reg` SET `code` = ?,`name` = ?,`value` = ?,`isvisible` = ?,`modul_code` = ?,`validator` = ? WHERE `code` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RegEntity value) {
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
        if (value.getValue() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getValue());
        }
        final int _tmp = value.isVisible() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getModulCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModulCode());
        }
        if (value.getValidator() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getValidator());
        }
        if (value.getCode() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCode());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends RegEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final RegEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends RegEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRegEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final RegEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRegEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final RegEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfRegEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<RegEntity> getRegList() {
    final String _sql = "SELECT * FROM reg";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final int _cursorIndexOfIsVisible = CursorUtil.getColumnIndexOrThrow(_cursor, "isvisible");
      final int _cursorIndexOfModulCode = CursorUtil.getColumnIndexOrThrow(_cursor, "modul_code");
      final int _cursorIndexOfValidator = CursorUtil.getColumnIndexOrThrow(_cursor, "validator");
      final List<RegEntity> _result = new ArrayList<RegEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final RegEntity _item;
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
        final String _tmpValue;
        if (_cursor.isNull(_cursorIndexOfValue)) {
          _tmpValue = null;
        } else {
          _tmpValue = _cursor.getString(_cursorIndexOfValue);
        }
        final boolean _tmpIsVisible;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsVisible);
        _tmpIsVisible = _tmp != 0;
        final String _tmpModulCode;
        if (_cursor.isNull(_cursorIndexOfModulCode)) {
          _tmpModulCode = null;
        } else {
          _tmpModulCode = _cursor.getString(_cursorIndexOfModulCode);
        }
        final String _tmpValidator;
        if (_cursor.isNull(_cursorIndexOfValidator)) {
          _tmpValidator = null;
        } else {
          _tmpValidator = _cursor.getString(_cursorIndexOfValidator);
        }
        _item = new RegEntity(_tmpCode,_tmpName,_tmpValue,_tmpIsVisible,_tmpModulCode,_tmpValidator);
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
