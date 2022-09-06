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
import com.bits.bee.bpmc.data.data_source.local.model.CashierEntity;
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
public final class CashierDao_Impl implements CashierDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CashierEntity> __insertionAdapterOfCashierEntity;

  private final EntityDeletionOrUpdateAdapter<CashierEntity> __deletionAdapterOfCashierEntity;

  private final EntityDeletionOrUpdateAdapter<CashierEntity> __updateAdapterOfCashierEntity;

  private final SharedSQLiteStatement __preparedStmtOfResetActive;

  public CashierDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCashierEntity = new EntityInsertionAdapter<CashierEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `cashier` (`id`,`code`,`cashier_name`,`branch_id`,`cashbranch_id`,`wh_id`,`cash_id`,`active`,`status`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashierEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCode());
        }
        if (value.getCashierName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCashierName());
        }
        stmt.bindLong(4, value.getBranchId());
        stmt.bindLong(5, value.getCashBranchId());
        stmt.bindLong(6, value.getWhId());
        stmt.bindLong(7, value.getCashId());
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        final int _tmp_1 = value.getStatus() ? 1 : 0;
        stmt.bindLong(9, _tmp_1);
      }
    };
    this.__deletionAdapterOfCashierEntity = new EntityDeletionOrUpdateAdapter<CashierEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `cashier` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashierEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfCashierEntity = new EntityDeletionOrUpdateAdapter<CashierEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `cashier` SET `id` = ?,`code` = ?,`cashier_name` = ?,`branch_id` = ?,`cashbranch_id` = ?,`wh_id` = ?,`cash_id` = ?,`active` = ?,`status` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashierEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCode());
        }
        if (value.getCashierName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCashierName());
        }
        stmt.bindLong(4, value.getBranchId());
        stmt.bindLong(5, value.getCashBranchId());
        stmt.bindLong(6, value.getWhId());
        stmt.bindLong(7, value.getCashId());
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        final int _tmp_1 = value.getStatus() ? 1 : 0;
        stmt.bindLong(9, _tmp_1);
        stmt.bindLong(10, value.getId());
      }
    };
    this.__preparedStmtOfResetActive = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE cashier SET active = 0";
        return _query;
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends CashierEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final CashierEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends CashierEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCashierEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final CashierEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCashierEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final CashierEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCashierEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void resetActive() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfResetActive.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfResetActive.release(_stmt);
    }
  }

  @Override
  public List<CashierEntity> getListCashier() {
    final String _sql = "SELECT * FROM cashier";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfCashierName = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_name");
      final int _cursorIndexOfBranchId = CursorUtil.getColumnIndexOrThrow(_cursor, "branch_id");
      final int _cursorIndexOfCashBranchId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashbranch_id");
      final int _cursorIndexOfWhId = CursorUtil.getColumnIndexOrThrow(_cursor, "wh_id");
      final int _cursorIndexOfCashId = CursorUtil.getColumnIndexOrThrow(_cursor, "cash_id");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final List<CashierEntity> _result = new ArrayList<CashierEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CashierEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpCashierName;
        if (_cursor.isNull(_cursorIndexOfCashierName)) {
          _tmpCashierName = null;
        } else {
          _tmpCashierName = _cursor.getString(_cursorIndexOfCashierName);
        }
        final long _tmpBranchId;
        _tmpBranchId = _cursor.getLong(_cursorIndexOfBranchId);
        final int _tmpCashBranchId;
        _tmpCashBranchId = _cursor.getInt(_cursorIndexOfCashBranchId);
        final long _tmpWhId;
        _tmpWhId = _cursor.getLong(_cursorIndexOfWhId);
        final long _tmpCashId;
        _tmpCashId = _cursor.getLong(_cursorIndexOfCashId);
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        final boolean _tmpStatus;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfStatus);
        _tmpStatus = _tmp_1 != 0;
        _item = new CashierEntity(_tmpId,_tmpCode,_tmpCashierName,_tmpBranchId,_tmpCashBranchId,_tmpWhId,_tmpCashId,_tmpIsActive,_tmpStatus);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public CashierEntity getActiveCashier() {
    final String _sql = "SELECT * FROM cashier WHERE active = 1 LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfCashierName = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_name");
      final int _cursorIndexOfBranchId = CursorUtil.getColumnIndexOrThrow(_cursor, "branch_id");
      final int _cursorIndexOfCashBranchId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashbranch_id");
      final int _cursorIndexOfWhId = CursorUtil.getColumnIndexOrThrow(_cursor, "wh_id");
      final int _cursorIndexOfCashId = CursorUtil.getColumnIndexOrThrow(_cursor, "cash_id");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final CashierEntity _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpCashierName;
        if (_cursor.isNull(_cursorIndexOfCashierName)) {
          _tmpCashierName = null;
        } else {
          _tmpCashierName = _cursor.getString(_cursorIndexOfCashierName);
        }
        final long _tmpBranchId;
        _tmpBranchId = _cursor.getLong(_cursorIndexOfBranchId);
        final int _tmpCashBranchId;
        _tmpCashBranchId = _cursor.getInt(_cursorIndexOfCashBranchId);
        final long _tmpWhId;
        _tmpWhId = _cursor.getLong(_cursorIndexOfWhId);
        final long _tmpCashId;
        _tmpCashId = _cursor.getLong(_cursorIndexOfCashId);
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        final boolean _tmpStatus;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfStatus);
        _tmpStatus = _tmp_1 != 0;
        _result = new CashierEntity(_tmpId,_tmpCode,_tmpCashierName,_tmpBranchId,_tmpCashBranchId,_tmpWhId,_tmpCashId,_tmpIsActive,_tmpStatus);
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
  public CashierEntity getCashierById(final int id) {
    final String _sql = "SELECT * FROM cashier WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfCashierName = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_name");
      final int _cursorIndexOfBranchId = CursorUtil.getColumnIndexOrThrow(_cursor, "branch_id");
      final int _cursorIndexOfCashBranchId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashbranch_id");
      final int _cursorIndexOfWhId = CursorUtil.getColumnIndexOrThrow(_cursor, "wh_id");
      final int _cursorIndexOfCashId = CursorUtil.getColumnIndexOrThrow(_cursor, "cash_id");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final CashierEntity _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpCashierName;
        if (_cursor.isNull(_cursorIndexOfCashierName)) {
          _tmpCashierName = null;
        } else {
          _tmpCashierName = _cursor.getString(_cursorIndexOfCashierName);
        }
        final long _tmpBranchId;
        _tmpBranchId = _cursor.getLong(_cursorIndexOfBranchId);
        final int _tmpCashBranchId;
        _tmpCashBranchId = _cursor.getInt(_cursorIndexOfCashBranchId);
        final long _tmpWhId;
        _tmpWhId = _cursor.getLong(_cursorIndexOfWhId);
        final long _tmpCashId;
        _tmpCashId = _cursor.getLong(_cursorIndexOfCashId);
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        final boolean _tmpStatus;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfStatus);
        _tmpStatus = _tmp_1 != 0;
        _result = new CashierEntity(_tmpId,_tmpCode,_tmpCashierName,_tmpBranchId,_tmpCashBranchId,_tmpWhId,_tmpCashId,_tmpIsActive,_tmpStatus);
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
