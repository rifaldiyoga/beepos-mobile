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
import com.bits.bee.bpmc.data.data_source.local.converter.Converters;
import com.bits.bee.bpmc.data.data_source.local.model.CstrEntity;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CstrDao_Impl implements CstrDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CstrEntity> __insertionAdapterOfCstrEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<CstrEntity> __deletionAdapterOfCstrEntity;

  private final EntityDeletionOrUpdateAdapter<CstrEntity> __updateAdapterOfCstrEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCode;

  public CstrDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCstrEntity = new EntityInsertionAdapter<CstrEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `cstr` (`id`,`trxdate`,`amount1`,`amount2`,`exrate1`,`exrate2`,`note`,`reftype`,`refno`,`autogen`,`cash_id1`,`cash_id2`,`isuploaded`,`kode_cstr`,`created_at`,`created_by`,`updated_at`,`updated_by`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CstrEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getTrxDate());
        final String _tmp = __converters.bigDecimalToString(value.getAmount1());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        final String _tmp_1 = __converters.bigDecimalToString(value.getAmount2());
        if (_tmp_1 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp_1);
        }
        final String _tmp_2 = __converters.bigDecimalToString(value.getExcrate1());
        if (_tmp_2 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_2);
        }
        final String _tmp_3 = __converters.bigDecimalToString(value.getExcrate2());
        if (_tmp_3 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_3);
        }
        final int _tmp_4 = value.getNote() ? 1 : 0;
        stmt.bindLong(7, _tmp_4);
        if (value.getRefType() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getRefType());
        }
        if (value.getRefNo() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRefNo());
        }
        if (value.getAutoGen() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getAutoGen());
        }
        stmt.bindLong(11, value.getCashId1());
        stmt.bindLong(12, value.getCashId2());
        final int _tmp_5 = value.isUploaded() ? 1 : 0;
        stmt.bindLong(13, _tmp_5);
        if (value.getKodeCstr() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getKodeCstr());
        }
        final Long _tmp_6 = __converters.dateToLong(value.getCreatedAt());
        if (_tmp_6 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, _tmp_6);
        }
        stmt.bindLong(16, value.getCreatedBy());
        final Long _tmp_7 = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp_7 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, _tmp_7);
        }
        stmt.bindLong(18, value.getUpdatedBy());
      }
    };
    this.__deletionAdapterOfCstrEntity = new EntityDeletionOrUpdateAdapter<CstrEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `cstr` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CstrEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfCstrEntity = new EntityDeletionOrUpdateAdapter<CstrEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `cstr` SET `id` = ?,`trxdate` = ?,`amount1` = ?,`amount2` = ?,`exrate1` = ?,`exrate2` = ?,`note` = ?,`reftype` = ?,`refno` = ?,`autogen` = ?,`cash_id1` = ?,`cash_id2` = ?,`isuploaded` = ?,`kode_cstr` = ?,`created_at` = ?,`created_by` = ?,`updated_at` = ?,`updated_by` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CstrEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getTrxDate());
        final String _tmp = __converters.bigDecimalToString(value.getAmount1());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        final String _tmp_1 = __converters.bigDecimalToString(value.getAmount2());
        if (_tmp_1 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp_1);
        }
        final String _tmp_2 = __converters.bigDecimalToString(value.getExcrate1());
        if (_tmp_2 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_2);
        }
        final String _tmp_3 = __converters.bigDecimalToString(value.getExcrate2());
        if (_tmp_3 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_3);
        }
        final int _tmp_4 = value.getNote() ? 1 : 0;
        stmt.bindLong(7, _tmp_4);
        if (value.getRefType() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getRefType());
        }
        if (value.getRefNo() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRefNo());
        }
        if (value.getAutoGen() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getAutoGen());
        }
        stmt.bindLong(11, value.getCashId1());
        stmt.bindLong(12, value.getCashId2());
        final int _tmp_5 = value.isUploaded() ? 1 : 0;
        stmt.bindLong(13, _tmp_5);
        if (value.getKodeCstr() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getKodeCstr());
        }
        final Long _tmp_6 = __converters.dateToLong(value.getCreatedAt());
        if (_tmp_6 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, _tmp_6);
        }
        stmt.bindLong(16, value.getCreatedBy());
        final Long _tmp_7 = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp_7 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, _tmp_7);
        }
        stmt.bindLong(18, value.getUpdatedBy());
        if (value.getId() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, value.getId());
        }
      }
    };
    this.__preparedStmtOfUpdateCode = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE cstr\n"
                + "SET kode_cstr = ?\n"
                + "WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends CstrEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final CstrEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends CstrEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCstrEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final CstrEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCstrEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final CstrEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCstrEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCode(final String code, final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCode.acquire();
    int _argIndex = 1;
    if (code == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, code);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateCode.release(_stmt);
    }
  }

  @Override
  public CstrEntity getLastId() {
    final String _sql = "SELECT * FROM cstr ORDER BY id DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trxdate");
      final int _cursorIndexOfAmount1 = CursorUtil.getColumnIndexOrThrow(_cursor, "amount1");
      final int _cursorIndexOfAmount2 = CursorUtil.getColumnIndexOrThrow(_cursor, "amount2");
      final int _cursorIndexOfExcrate1 = CursorUtil.getColumnIndexOrThrow(_cursor, "exrate1");
      final int _cursorIndexOfExcrate2 = CursorUtil.getColumnIndexOrThrow(_cursor, "exrate2");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfRefType = CursorUtil.getColumnIndexOrThrow(_cursor, "reftype");
      final int _cursorIndexOfRefNo = CursorUtil.getColumnIndexOrThrow(_cursor, "refno");
      final int _cursorIndexOfAutoGen = CursorUtil.getColumnIndexOrThrow(_cursor, "autogen");
      final int _cursorIndexOfCashId1 = CursorUtil.getColumnIndexOrThrow(_cursor, "cash_id1");
      final int _cursorIndexOfCashId2 = CursorUtil.getColumnIndexOrThrow(_cursor, "cash_id2");
      final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isuploaded");
      final int _cursorIndexOfKodeCstr = CursorUtil.getColumnIndexOrThrow(_cursor, "kode_cstr");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final CstrEntity _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final long _tmpTrxDate;
        _tmpTrxDate = _cursor.getLong(_cursorIndexOfTrxDate);
        final BigDecimal _tmpAmount1;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfAmount1)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfAmount1);
        }
        _tmpAmount1 = __converters.stringToBigDecimal(_tmp);
        final BigDecimal _tmpAmount2;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfAmount2)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfAmount2);
        }
        _tmpAmount2 = __converters.stringToBigDecimal(_tmp_1);
        final BigDecimal _tmpExcrate1;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfExcrate1)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfExcrate1);
        }
        _tmpExcrate1 = __converters.stringToBigDecimal(_tmp_2);
        final BigDecimal _tmpExcrate2;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfExcrate2)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfExcrate2);
        }
        _tmpExcrate2 = __converters.stringToBigDecimal(_tmp_3);
        final boolean _tmpNote;
        final int _tmp_4;
        _tmp_4 = _cursor.getInt(_cursorIndexOfNote);
        _tmpNote = _tmp_4 != 0;
        final String _tmpRefType;
        if (_cursor.isNull(_cursorIndexOfRefType)) {
          _tmpRefType = null;
        } else {
          _tmpRefType = _cursor.getString(_cursorIndexOfRefType);
        }
        final String _tmpRefNo;
        if (_cursor.isNull(_cursorIndexOfRefNo)) {
          _tmpRefNo = null;
        } else {
          _tmpRefNo = _cursor.getString(_cursorIndexOfRefNo);
        }
        final String _tmpAutoGen;
        if (_cursor.isNull(_cursorIndexOfAutoGen)) {
          _tmpAutoGen = null;
        } else {
          _tmpAutoGen = _cursor.getString(_cursorIndexOfAutoGen);
        }
        final long _tmpCashId1;
        _tmpCashId1 = _cursor.getLong(_cursorIndexOfCashId1);
        final long _tmpCashId2;
        _tmpCashId2 = _cursor.getLong(_cursorIndexOfCashId2);
        final boolean _tmpIsUploaded;
        final int _tmp_5;
        _tmp_5 = _cursor.getInt(_cursorIndexOfIsUploaded);
        _tmpIsUploaded = _tmp_5 != 0;
        final String _tmpKodeCstr;
        if (_cursor.isNull(_cursorIndexOfKodeCstr)) {
          _tmpKodeCstr = null;
        } else {
          _tmpKodeCstr = _cursor.getString(_cursorIndexOfKodeCstr);
        }
        final Date _tmpCreatedAt;
        final Long _tmp_6;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp_6);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        final Date _tmpUpdatedAt;
        final Long _tmp_7;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getLong(_cursorIndexOfUpdatedAt);
        }
        _tmpUpdatedAt = __converters.longToDate(_tmp_7);
        final int _tmpUpdatedBy;
        _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        _result = new CstrEntity(_tmpId,_tmpTrxDate,_tmpAmount1,_tmpAmount2,_tmpExcrate1,_tmpExcrate2,_tmpNote,_tmpRefType,_tmpRefNo,_tmpAutoGen,_tmpCashId1,_tmpCashId2,_tmpIsUploaded,_tmpKodeCstr,_tmpCreatedAt,_tmpCreatedBy,_tmpUpdatedAt,_tmpUpdatedBy);
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
