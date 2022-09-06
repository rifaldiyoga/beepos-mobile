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
import com.bits.bee.bpmc.data.data_source.local.model.PmtdEntity;
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
public final class PmtdDao_Impl implements PmtdDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PmtdEntity> __insertionAdapterOfPmtdEntity;

  private final EntityDeletionOrUpdateAdapter<PmtdEntity> __deletionAdapterOfPmtdEntity;

  private final EntityDeletionOrUpdateAdapter<PmtdEntity> __updateAdapterOfPmtdEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public PmtdDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPmtdEntity = new EntityInsertionAdapter<PmtdEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `pmtd` (`id`,`idx`,`code`,`name`,`cash_id`,`mdrexp`,`mdracc`,`surcexp`,`surcacc`,`branch_id`,`settledays`,`cash_name`,`branch_name`,`cctype`,`edcsurctype`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PmtdEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getIdx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getIdx());
        }
        if (value.getCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCode());
        }
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        if (value.getCashId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getCashId());
        }
        if (value.getMdrExp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMdrExp());
        }
        stmt.bindLong(7, value.getMdrAcc());
        if (value.getSurExp() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSurExp());
        }
        stmt.bindLong(9, value.getSurAcc());
        if (value.getBranchId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getBranchId());
        }
        if (value.getSettleDays() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getSettleDays());
        }
        if (value.getCashName() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCashName());
        }
        if (value.getBranchName() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getBranchName());
        }
        if (value.getCcType() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getCcType());
        }
        if (value.getEdcSurcType() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getEdcSurcType());
        }
      }
    };
    this.__deletionAdapterOfPmtdEntity = new EntityDeletionOrUpdateAdapter<PmtdEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `pmtd` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PmtdEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfPmtdEntity = new EntityDeletionOrUpdateAdapter<PmtdEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `pmtd` SET `id` = ?,`idx` = ?,`code` = ?,`name` = ?,`cash_id` = ?,`mdrexp` = ?,`mdracc` = ?,`surcexp` = ?,`surcacc` = ?,`branch_id` = ?,`settledays` = ?,`cash_name` = ?,`branch_name` = ?,`cctype` = ?,`edcsurctype` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PmtdEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getIdx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getIdx());
        }
        if (value.getCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCode());
        }
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        if (value.getCashId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getCashId());
        }
        if (value.getMdrExp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMdrExp());
        }
        stmt.bindLong(7, value.getMdrAcc());
        if (value.getSurExp() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSurExp());
        }
        stmt.bindLong(9, value.getSurAcc());
        if (value.getBranchId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getBranchId());
        }
        if (value.getSettleDays() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getSettleDays());
        }
        if (value.getCashName() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCashName());
        }
        if (value.getBranchName() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getBranchName());
        }
        if (value.getCcType() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getCcType());
        }
        if (value.getEdcSurcType() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getEdcSurcType());
        }
        if (value.getId() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindLong(16, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM pmtd";
        return _query;
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends PmtdEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final PmtdEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends PmtdEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPmtdEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final PmtdEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPmtdEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final PmtdEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPmtdEntity.handle(entity);
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
  public List<PmtdEntity> getPmtdList() {
    final String _sql = "SELECT * FROM pmtd";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfCashId = CursorUtil.getColumnIndexOrThrow(_cursor, "cash_id");
      final int _cursorIndexOfMdrExp = CursorUtil.getColumnIndexOrThrow(_cursor, "mdrexp");
      final int _cursorIndexOfMdrAcc = CursorUtil.getColumnIndexOrThrow(_cursor, "mdracc");
      final int _cursorIndexOfSurExp = CursorUtil.getColumnIndexOrThrow(_cursor, "surcexp");
      final int _cursorIndexOfSurAcc = CursorUtil.getColumnIndexOrThrow(_cursor, "surcacc");
      final int _cursorIndexOfBranchId = CursorUtil.getColumnIndexOrThrow(_cursor, "branch_id");
      final int _cursorIndexOfSettleDays = CursorUtil.getColumnIndexOrThrow(_cursor, "settledays");
      final int _cursorIndexOfCashName = CursorUtil.getColumnIndexOrThrow(_cursor, "cash_name");
      final int _cursorIndexOfBranchName = CursorUtil.getColumnIndexOrThrow(_cursor, "branch_name");
      final int _cursorIndexOfCcType = CursorUtil.getColumnIndexOrThrow(_cursor, "cctype");
      final int _cursorIndexOfEdcSurcType = CursorUtil.getColumnIndexOrThrow(_cursor, "edcsurctype");
      final List<PmtdEntity> _result = new ArrayList<PmtdEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PmtdEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final Integer _tmpIdx;
        if (_cursor.isNull(_cursorIndexOfIdx)) {
          _tmpIdx = null;
        } else {
          _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
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
        final Integer _tmpCashId;
        if (_cursor.isNull(_cursorIndexOfCashId)) {
          _tmpCashId = null;
        } else {
          _tmpCashId = _cursor.getInt(_cursorIndexOfCashId);
        }
        final String _tmpMdrExp;
        if (_cursor.isNull(_cursorIndexOfMdrExp)) {
          _tmpMdrExp = null;
        } else {
          _tmpMdrExp = _cursor.getString(_cursorIndexOfMdrExp);
        }
        final int _tmpMdrAcc;
        _tmpMdrAcc = _cursor.getInt(_cursorIndexOfMdrAcc);
        final String _tmpSurExp;
        if (_cursor.isNull(_cursorIndexOfSurExp)) {
          _tmpSurExp = null;
        } else {
          _tmpSurExp = _cursor.getString(_cursorIndexOfSurExp);
        }
        final int _tmpSurAcc;
        _tmpSurAcc = _cursor.getInt(_cursorIndexOfSurAcc);
        final Integer _tmpBranchId;
        if (_cursor.isNull(_cursorIndexOfBranchId)) {
          _tmpBranchId = null;
        } else {
          _tmpBranchId = _cursor.getInt(_cursorIndexOfBranchId);
        }
        final Integer _tmpSettleDays;
        if (_cursor.isNull(_cursorIndexOfSettleDays)) {
          _tmpSettleDays = null;
        } else {
          _tmpSettleDays = _cursor.getInt(_cursorIndexOfSettleDays);
        }
        final String _tmpCashName;
        if (_cursor.isNull(_cursorIndexOfCashName)) {
          _tmpCashName = null;
        } else {
          _tmpCashName = _cursor.getString(_cursorIndexOfCashName);
        }
        final String _tmpBranchName;
        if (_cursor.isNull(_cursorIndexOfBranchName)) {
          _tmpBranchName = null;
        } else {
          _tmpBranchName = _cursor.getString(_cursorIndexOfBranchName);
        }
        final String _tmpCcType;
        if (_cursor.isNull(_cursorIndexOfCcType)) {
          _tmpCcType = null;
        } else {
          _tmpCcType = _cursor.getString(_cursorIndexOfCcType);
        }
        final String _tmpEdcSurcType;
        if (_cursor.isNull(_cursorIndexOfEdcSurcType)) {
          _tmpEdcSurcType = null;
        } else {
          _tmpEdcSurcType = _cursor.getString(_cursorIndexOfEdcSurcType);
        }
        _item = new PmtdEntity(_tmpId,_tmpIdx,_tmpCode,_tmpName,_tmpCashId,_tmpMdrExp,_tmpMdrAcc,_tmpSurExp,_tmpSurAcc,_tmpBranchId,_tmpSettleDays,_tmpCashName,_tmpBranchName,_tmpCcType,_tmpEdcSurcType);
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
