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
import com.bits.bee.bpmc.data.data_source.local.model.CrcEntity;
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
public final class CrcDao_Impl implements CrcDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CrcEntity> __insertionAdapterOfCrcEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<CrcEntity> __deletionAdapterOfCrcEntity;

  private final EntityDeletionOrUpdateAdapter<CrcEntity> __updateAdapterOfCrcEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public CrcDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCrcEntity = new EntityInsertionAdapter<CrcEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `crc` (`id`,`code`,`name`,`symbol`,`isdefault`,`excrate`,`fisrate`,`ratetype`,`active`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CrcEntity value) {
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
        if (value.getSymbol() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSymbol());
        }
        final int _tmp = value.isDefault() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        final String _tmp_1 = __converters.bigDecimalToString(value.getExcRate());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_1);
        }
        final String _tmp_2 = __converters.bigDecimalToString(value.getFisRate());
        if (_tmp_2 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_2);
        }
        if (value.getRateType() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getRateType());
        }
        final int _tmp_3 = value.getActive() ? 1 : 0;
        stmt.bindLong(9, _tmp_3);
      }
    };
    this.__deletionAdapterOfCrcEntity = new EntityDeletionOrUpdateAdapter<CrcEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `crc` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CrcEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfCrcEntity = new EntityDeletionOrUpdateAdapter<CrcEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `crc` SET `id` = ?,`code` = ?,`name` = ?,`symbol` = ?,`isdefault` = ?,`excrate` = ?,`fisrate` = ?,`ratetype` = ?,`active` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CrcEntity value) {
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
        if (value.getSymbol() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSymbol());
        }
        final int _tmp = value.isDefault() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        final String _tmp_1 = __converters.bigDecimalToString(value.getExcRate());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_1);
        }
        final String _tmp_2 = __converters.bigDecimalToString(value.getFisRate());
        if (_tmp_2 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_2);
        }
        if (value.getRateType() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getRateType());
        }
        final int _tmp_3 = value.getActive() ? 1 : 0;
        stmt.bindLong(9, _tmp_3);
        if (value.getId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM crc";
        return _query;
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends CrcEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final CrcEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends CrcEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCrcEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final CrcEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCrcEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final CrcEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCrcEntity.handle(entity);
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
  public List<CrcEntity> getCrcList() {
    final String _sql = "SELECT * FROM crc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfSymbol = CursorUtil.getColumnIndexOrThrow(_cursor, "symbol");
      final int _cursorIndexOfIsDefault = CursorUtil.getColumnIndexOrThrow(_cursor, "isdefault");
      final int _cursorIndexOfExcRate = CursorUtil.getColumnIndexOrThrow(_cursor, "excrate");
      final int _cursorIndexOfFisRate = CursorUtil.getColumnIndexOrThrow(_cursor, "fisrate");
      final int _cursorIndexOfRateType = CursorUtil.getColumnIndexOrThrow(_cursor, "ratetype");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final List<CrcEntity> _result = new ArrayList<CrcEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CrcEntity _item;
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
        final String _tmpSymbol;
        if (_cursor.isNull(_cursorIndexOfSymbol)) {
          _tmpSymbol = null;
        } else {
          _tmpSymbol = _cursor.getString(_cursorIndexOfSymbol);
        }
        final boolean _tmpIsDefault;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsDefault);
        _tmpIsDefault = _tmp != 0;
        final BigDecimal _tmpExcRate;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfExcRate)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfExcRate);
        }
        _tmpExcRate = __converters.stringToBigDecimal(_tmp_1);
        final BigDecimal _tmpFisRate;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfFisRate)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfFisRate);
        }
        _tmpFisRate = __converters.stringToBigDecimal(_tmp_2);
        final String _tmpRateType;
        if (_cursor.isNull(_cursorIndexOfRateType)) {
          _tmpRateType = null;
        } else {
          _tmpRateType = _cursor.getString(_cursorIndexOfRateType);
        }
        final boolean _tmpActive;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp_3 != 0;
        _item = new CrcEntity(_tmpId,_tmpCode,_tmpName,_tmpSymbol,_tmpIsDefault,_tmpExcRate,_tmpFisRate,_tmpRateType,_tmpActive);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public CrcEntity getDefaultCrc() {
    final String _sql = "SELECT * FROM crc WHERE id = (SELECT crc_id FROM cmp LIMIT 1)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfSymbol = CursorUtil.getColumnIndexOrThrow(_cursor, "symbol");
      final int _cursorIndexOfIsDefault = CursorUtil.getColumnIndexOrThrow(_cursor, "isdefault");
      final int _cursorIndexOfExcRate = CursorUtil.getColumnIndexOrThrow(_cursor, "excrate");
      final int _cursorIndexOfFisRate = CursorUtil.getColumnIndexOrThrow(_cursor, "fisrate");
      final int _cursorIndexOfRateType = CursorUtil.getColumnIndexOrThrow(_cursor, "ratetype");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final CrcEntity _result;
      if(_cursor.moveToFirst()) {
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
        final String _tmpSymbol;
        if (_cursor.isNull(_cursorIndexOfSymbol)) {
          _tmpSymbol = null;
        } else {
          _tmpSymbol = _cursor.getString(_cursorIndexOfSymbol);
        }
        final boolean _tmpIsDefault;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsDefault);
        _tmpIsDefault = _tmp != 0;
        final BigDecimal _tmpExcRate;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfExcRate)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfExcRate);
        }
        _tmpExcRate = __converters.stringToBigDecimal(_tmp_1);
        final BigDecimal _tmpFisRate;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfFisRate)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfFisRate);
        }
        _tmpFisRate = __converters.stringToBigDecimal(_tmp_2);
        final String _tmpRateType;
        if (_cursor.isNull(_cursorIndexOfRateType)) {
          _tmpRateType = null;
        } else {
          _tmpRateType = _cursor.getString(_cursorIndexOfRateType);
        }
        final boolean _tmpActive;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp_3 != 0;
        _result = new CrcEntity(_tmpId,_tmpCode,_tmpName,_tmpSymbol,_tmpIsDefault,_tmpExcRate,_tmpFisRate,_tmpRateType,_tmpActive);
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
