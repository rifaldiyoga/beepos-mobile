package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.converter.Converters;
import com.bits.bee.bpmc.data.data_source.local.model.CashAEntity;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CashADao_Impl implements CashADao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CashAEntity> __insertionAdapterOfCashAEntity;

  private final Converters __converters = new Converters();

  private final EntityInsertionAdapter<CashAEntity> __insertionAdapterOfCashAEntity_1;

  private final EntityDeletionOrUpdateAdapter<CashAEntity> __deletionAdapterOfCashAEntity;

  private final EntityDeletionOrUpdateAdapter<CashAEntity> __updateAdapterOfCashAEntity;

  public CashADao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCashAEntity = new EntityInsertionAdapter<CashAEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `casha` (`id`,`trxdate`,`amount`,`note`,`inout`,`reftype`,`refid`,`autogen`,`cash_id`,`user_id`,`cashier_id`,`isuploaded`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashAEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTrxDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTrxDate());
        }
        final String _tmp = __converters.bigDecimalToString(value.getAmount());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        if (value.getNote() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNote());
        }
        if (value.getInOut() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getInOut());
        }
        if (value.getRefType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRefType());
        }
        stmt.bindLong(7, value.getRefId());
        final int _tmp_1 = value.getAutoGen() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        stmt.bindLong(9, value.getCashId());
        stmt.bindLong(10, value.getUserId());
        stmt.bindLong(11, value.getCashierId());
        final int _tmp_2 = value.isUploaded() ? 1 : 0;
        stmt.bindLong(12, _tmp_2);
      }
    };
    this.__insertionAdapterOfCashAEntity_1 = new EntityInsertionAdapter<CashAEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `casha` (`id`,`trxdate`,`amount`,`note`,`inout`,`reftype`,`refid`,`autogen`,`cash_id`,`user_id`,`cashier_id`,`isuploaded`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashAEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTrxDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTrxDate());
        }
        final String _tmp = __converters.bigDecimalToString(value.getAmount());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        if (value.getNote() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNote());
        }
        if (value.getInOut() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getInOut());
        }
        if (value.getRefType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRefType());
        }
        stmt.bindLong(7, value.getRefId());
        final int _tmp_1 = value.getAutoGen() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        stmt.bindLong(9, value.getCashId());
        stmt.bindLong(10, value.getUserId());
        stmt.bindLong(11, value.getCashierId());
        final int _tmp_2 = value.isUploaded() ? 1 : 0;
        stmt.bindLong(12, _tmp_2);
      }
    };
    this.__deletionAdapterOfCashAEntity = new EntityDeletionOrUpdateAdapter<CashAEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `casha` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashAEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfCashAEntity = new EntityDeletionOrUpdateAdapter<CashAEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `casha` SET `id` = ?,`trxdate` = ?,`amount` = ?,`note` = ?,`inout` = ?,`reftype` = ?,`refid` = ?,`autogen` = ?,`cash_id` = ?,`user_id` = ?,`cashier_id` = ?,`isuploaded` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashAEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTrxDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTrxDate());
        }
        final String _tmp = __converters.bigDecimalToString(value.getAmount());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        if (value.getNote() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNote());
        }
        if (value.getInOut() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getInOut());
        }
        if (value.getRefType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRefType());
        }
        stmt.bindLong(7, value.getRefId());
        final int _tmp_1 = value.getAutoGen() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        stmt.bindLong(9, value.getCashId());
        stmt.bindLong(10, value.getUserId());
        stmt.bindLong(11, value.getCashierId());
        final int _tmp_2 = value.isUploaded() ? 1 : 0;
        stmt.bindLong(12, _tmp_2);
        if (value.getId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends CashAEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final CashAEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insert(final CashAEntity en, final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends CashAEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCashAEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final CashAEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCashAEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final CashAEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCashAEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public CashAEntity getCashAByRef(final long refId, final String refType) {
    final String _sql = "SELECT * FROM casha WHERE refid = ? AND reftype = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, refId);
    _argIndex = 2;
    if (refType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, refType);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trxdate");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfInOut = CursorUtil.getColumnIndexOrThrow(_cursor, "inout");
      final int _cursorIndexOfRefType = CursorUtil.getColumnIndexOrThrow(_cursor, "reftype");
      final int _cursorIndexOfRefId = CursorUtil.getColumnIndexOrThrow(_cursor, "refid");
      final int _cursorIndexOfAutoGen = CursorUtil.getColumnIndexOrThrow(_cursor, "autogen");
      final int _cursorIndexOfCashId = CursorUtil.getColumnIndexOrThrow(_cursor, "cash_id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isuploaded");
      final CashAEntity _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpTrxDate;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmpTrxDate = null;
        } else {
          _tmpTrxDate = _cursor.getString(_cursorIndexOfTrxDate);
        }
        final BigDecimal _tmpAmount;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfAmount)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfAmount);
        }
        _tmpAmount = __converters.stringToBigDecimal(_tmp);
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final String _tmpInOut;
        if (_cursor.isNull(_cursorIndexOfInOut)) {
          _tmpInOut = null;
        } else {
          _tmpInOut = _cursor.getString(_cursorIndexOfInOut);
        }
        final String _tmpRefType;
        if (_cursor.isNull(_cursorIndexOfRefType)) {
          _tmpRefType = null;
        } else {
          _tmpRefType = _cursor.getString(_cursorIndexOfRefType);
        }
        final long _tmpRefId;
        _tmpRefId = _cursor.getLong(_cursorIndexOfRefId);
        final boolean _tmpAutoGen;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfAutoGen);
        _tmpAutoGen = _tmp_1 != 0;
        final int _tmpCashId;
        _tmpCashId = _cursor.getInt(_cursorIndexOfCashId);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        final boolean _tmpIsUploaded;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsUploaded);
        _tmpIsUploaded = _tmp_2 != 0;
        _result = new CashAEntity(_tmpId,_tmpTrxDate,_tmpAmount,_tmpNote,_tmpInOut,_tmpRefType,_tmpRefId,_tmpAutoGen,_tmpCashId,_tmpUserId,_tmpCashierId,_tmpIsUploaded);
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
  public List<CashAEntity> getLastCasha() {
    final String _sql = "SELECT * FROM casha where reftype = 'POSSES' ORDER BY id DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trxdate");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfInOut = CursorUtil.getColumnIndexOrThrow(_cursor, "inout");
      final int _cursorIndexOfRefType = CursorUtil.getColumnIndexOrThrow(_cursor, "reftype");
      final int _cursorIndexOfRefId = CursorUtil.getColumnIndexOrThrow(_cursor, "refid");
      final int _cursorIndexOfAutoGen = CursorUtil.getColumnIndexOrThrow(_cursor, "autogen");
      final int _cursorIndexOfCashId = CursorUtil.getColumnIndexOrThrow(_cursor, "cash_id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isuploaded");
      final List<CashAEntity> _result = new ArrayList<CashAEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CashAEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpTrxDate;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmpTrxDate = null;
        } else {
          _tmpTrxDate = _cursor.getString(_cursorIndexOfTrxDate);
        }
        final BigDecimal _tmpAmount;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfAmount)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfAmount);
        }
        _tmpAmount = __converters.stringToBigDecimal(_tmp);
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final String _tmpInOut;
        if (_cursor.isNull(_cursorIndexOfInOut)) {
          _tmpInOut = null;
        } else {
          _tmpInOut = _cursor.getString(_cursorIndexOfInOut);
        }
        final String _tmpRefType;
        if (_cursor.isNull(_cursorIndexOfRefType)) {
          _tmpRefType = null;
        } else {
          _tmpRefType = _cursor.getString(_cursorIndexOfRefType);
        }
        final long _tmpRefId;
        _tmpRefId = _cursor.getLong(_cursorIndexOfRefId);
        final boolean _tmpAutoGen;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfAutoGen);
        _tmpAutoGen = _tmp_1 != 0;
        final int _tmpCashId;
        _tmpCashId = _cursor.getInt(_cursorIndexOfCashId);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        final boolean _tmpIsUploaded;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsUploaded);
        _tmpIsUploaded = _tmp_2 != 0;
        _item = new CashAEntity(_tmpId,_tmpTrxDate,_tmpAmount,_tmpNote,_tmpInOut,_tmpRefType,_tmpRefId,_tmpAutoGen,_tmpCashId,_tmpUserId,_tmpCashierId,_tmpIsUploaded);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<CashAEntity> getCashAByCashId(final int cashId) {
    final String _sql = "SELECT * FROM casha WHERE cash_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, cashId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trxdate");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfInOut = CursorUtil.getColumnIndexOrThrow(_cursor, "inout");
      final int _cursorIndexOfRefType = CursorUtil.getColumnIndexOrThrow(_cursor, "reftype");
      final int _cursorIndexOfRefId = CursorUtil.getColumnIndexOrThrow(_cursor, "refid");
      final int _cursorIndexOfAutoGen = CursorUtil.getColumnIndexOrThrow(_cursor, "autogen");
      final int _cursorIndexOfCashId = CursorUtil.getColumnIndexOrThrow(_cursor, "cash_id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isuploaded");
      final List<CashAEntity> _result = new ArrayList<CashAEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CashAEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpTrxDate;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmpTrxDate = null;
        } else {
          _tmpTrxDate = _cursor.getString(_cursorIndexOfTrxDate);
        }
        final BigDecimal _tmpAmount;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfAmount)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfAmount);
        }
        _tmpAmount = __converters.stringToBigDecimal(_tmp);
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final String _tmpInOut;
        if (_cursor.isNull(_cursorIndexOfInOut)) {
          _tmpInOut = null;
        } else {
          _tmpInOut = _cursor.getString(_cursorIndexOfInOut);
        }
        final String _tmpRefType;
        if (_cursor.isNull(_cursorIndexOfRefType)) {
          _tmpRefType = null;
        } else {
          _tmpRefType = _cursor.getString(_cursorIndexOfRefType);
        }
        final long _tmpRefId;
        _tmpRefId = _cursor.getLong(_cursorIndexOfRefId);
        final boolean _tmpAutoGen;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfAutoGen);
        _tmpAutoGen = _tmp_1 != 0;
        final int _tmpCashId;
        _tmpCashId = _cursor.getInt(_cursorIndexOfCashId);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        final boolean _tmpIsUploaded;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsUploaded);
        _tmpIsUploaded = _tmp_2 != 0;
        _item = new CashAEntity(_tmpId,_tmpTrxDate,_tmpAmount,_tmpNote,_tmpInOut,_tmpRefType,_tmpRefId,_tmpAutoGen,_tmpCashId,_tmpUserId,_tmpCashierId,_tmpIsUploaded);
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
