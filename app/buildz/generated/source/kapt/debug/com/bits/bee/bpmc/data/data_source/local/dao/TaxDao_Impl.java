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
import com.bits.bee.bpmc.data.data_source.local.model.TaxEntity;
import java.lang.Class;
import java.lang.Integer;
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
public final class TaxDao_Impl implements TaxDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TaxEntity> __insertionAdapterOfTaxEntity;

  private final EntityDeletionOrUpdateAdapter<TaxEntity> __deletionAdapterOfTaxEntity;

  private final EntityDeletionOrUpdateAdapter<TaxEntity> __updateAdapterOfTaxEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public TaxDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTaxEntity = new EntityInsertionAdapter<TaxEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `tax` (`id`,`code`,`name`,`expr`,`active`,`isdefault`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaxEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
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
        if (value.getExpr() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getExpr());
        }
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        final int _tmp_1 = value.isDefault() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
      }
    };
    this.__deletionAdapterOfTaxEntity = new EntityDeletionOrUpdateAdapter<TaxEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `tax` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaxEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfTaxEntity = new EntityDeletionOrUpdateAdapter<TaxEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tax` SET `id` = ?,`code` = ?,`name` = ?,`expr` = ?,`active` = ?,`isdefault` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaxEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
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
        if (value.getExpr() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getExpr());
        }
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        final int _tmp_1 = value.isDefault() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        if (value.getId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tax";
        return _query;
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends TaxEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final TaxEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends TaxEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTaxEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final TaxEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTaxEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final TaxEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTaxEntity.handle(entity);
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
  public List<TaxEntity> getTaxList() {
    final String _sql = "SELECT * FROM tax";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfExpr = CursorUtil.getColumnIndexOrThrow(_cursor, "expr");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfIsDefault = CursorUtil.getColumnIndexOrThrow(_cursor, "isdefault");
      final List<TaxEntity> _result = new ArrayList<TaxEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TaxEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
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
        final String _tmpExpr;
        if (_cursor.isNull(_cursorIndexOfExpr)) {
          _tmpExpr = null;
        } else {
          _tmpExpr = _cursor.getString(_cursorIndexOfExpr);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        final boolean _tmpIsDefault;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsDefault);
        _tmpIsDefault = _tmp_1 != 0;
        _item = new TaxEntity(_tmpId,_tmpCode,_tmpName,_tmpExpr,_tmpIsActive,_tmpIsDefault);
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
