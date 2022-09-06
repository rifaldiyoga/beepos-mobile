package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.ProvinceEntity;
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
public final class ProvinceDao_Impl implements ProvinceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ProvinceEntity> __insertionAdapterOfProvinceEntity;

  private final EntityDeletionOrUpdateAdapter<ProvinceEntity> __deletionAdapterOfProvinceEntity;

  private final EntityDeletionOrUpdateAdapter<ProvinceEntity> __updateAdapterOfProvinceEntity;

  public ProvinceDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProvinceEntity = new EntityInsertionAdapter<ProvinceEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `province` (`code`,`name`,`active`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProvinceEntity value) {
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
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(3, _tmp);
      }
    };
    this.__deletionAdapterOfProvinceEntity = new EntityDeletionOrUpdateAdapter<ProvinceEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `province` WHERE `code` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProvinceEntity value) {
        if (value.getCode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCode());
        }
      }
    };
    this.__updateAdapterOfProvinceEntity = new EntityDeletionOrUpdateAdapter<ProvinceEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `province` SET `code` = ?,`name` = ?,`active` = ? WHERE `code` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProvinceEntity value) {
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
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        if (value.getCode() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCode());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends ProvinceEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final ProvinceEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends ProvinceEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProvinceEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ProvinceEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProvinceEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ProvinceEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfProvinceEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ProvinceEntity> getProvinceList() {
    final String _sql = "SELECT * FROM province";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final List<ProvinceEntity> _result = new ArrayList<ProvinceEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ProvinceEntity _item;
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
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        _item = new ProvinceEntity(_tmpCode,_tmpName,_tmpIsActive);
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
