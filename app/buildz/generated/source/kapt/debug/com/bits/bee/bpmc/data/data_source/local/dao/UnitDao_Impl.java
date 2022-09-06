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
import com.bits.bee.bpmc.data.data_source.local.model.UnitEntity;
import java.lang.Class;
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
public final class UnitDao_Impl implements UnitDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UnitEntity> __insertionAdapterOfUnitEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<UnitEntity> __deletionAdapterOfUnitEntity;

  private final EntityDeletionOrUpdateAdapter<UnitEntity> __updateAdapterOfUnitEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public UnitDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUnitEntity = new EntityInsertionAdapter<UnitEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `unit` (`id`,`item_id`,`idx`,`unit`,`conv`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UnitEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getItemId());
        stmt.bindLong(3, value.getIdx());
        if (value.getUnit() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUnit());
        }
        final String _tmp = __converters.bigDecimalToString(value.getConv());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp);
        }
      }
    };
    this.__deletionAdapterOfUnitEntity = new EntityDeletionOrUpdateAdapter<UnitEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `unit` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UnitEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfUnitEntity = new EntityDeletionOrUpdateAdapter<UnitEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `unit` SET `id` = ?,`item_id` = ?,`idx` = ?,`unit` = ?,`conv` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UnitEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getItemId());
        stmt.bindLong(3, value.getIdx());
        if (value.getUnit() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUnit());
        }
        final String _tmp = __converters.bigDecimalToString(value.getConv());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp);
        }
        stmt.bindLong(6, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM unit";
        return _query;
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends UnitEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final UnitEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends UnitEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUnitEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final UnitEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUnitEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final UnitEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUnitEntity.handle(entity);
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
  public List<UnitEntity> getUnitList() {
    final String _sql = "SELECT * FROM unit";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final int _cursorIndexOfUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "unit");
      final int _cursorIndexOfConv = CursorUtil.getColumnIndexOrThrow(_cursor, "conv");
      final List<UnitEntity> _result = new ArrayList<UnitEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UnitEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        final String _tmpUnit;
        if (_cursor.isNull(_cursorIndexOfUnit)) {
          _tmpUnit = null;
        } else {
          _tmpUnit = _cursor.getString(_cursorIndexOfUnit);
        }
        final BigDecimal _tmpConv;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfConv)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfConv);
        }
        _tmpConv = __converters.stringToBigDecimal(_tmp);
        _item = new UnitEntity(_tmpId,_tmpItemId,_tmpIdx,_tmpUnit,_tmpConv);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UnitEntity> getUnitByItem(final int itemId) {
    final String _sql = "SELECT * FROM unit WHERE item_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, itemId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final int _cursorIndexOfUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "unit");
      final int _cursorIndexOfConv = CursorUtil.getColumnIndexOrThrow(_cursor, "conv");
      final List<UnitEntity> _result = new ArrayList<UnitEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UnitEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        final String _tmpUnit;
        if (_cursor.isNull(_cursorIndexOfUnit)) {
          _tmpUnit = null;
        } else {
          _tmpUnit = _cursor.getString(_cursorIndexOfUnit);
        }
        final BigDecimal _tmpConv;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfConv)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfConv);
        }
        _tmpConv = __converters.stringToBigDecimal(_tmp);
        _item = new UnitEntity(_tmpId,_tmpItemId,_tmpIdx,_tmpUnit,_tmpConv);
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
