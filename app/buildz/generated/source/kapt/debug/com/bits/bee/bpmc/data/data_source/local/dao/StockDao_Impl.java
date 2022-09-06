package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.StockEntity;
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
public final class StockDao_Impl implements StockDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<StockEntity> __insertionAdapterOfStockEntity;

  private final EntityDeletionOrUpdateAdapter<StockEntity> __deletionAdapterOfStockEntity;

  private final EntityDeletionOrUpdateAdapter<StockEntity> __updateAdapterOfStockEntity;

  public StockDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStockEntity = new EntityInsertionAdapter<StockEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `stock` (`id`,`item_id`,`wh_id`,`item_code`,`wh_code`,`pid`,`qty`,`qtyx`,`active`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, StockEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getItemId());
        stmt.bindLong(3, value.getWhId());
        if (value.getItemCode() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getItemCode());
        }
        if (value.getWhCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWhCode());
        }
        if (value.getPid() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPid());
        }
        if (value.getQty() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getQty());
        }
        if (value.getQtyx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getQtyx());
        }
        final int _tmp = value.getActive() ? 1 : 0;
        stmt.bindLong(9, _tmp);
      }
    };
    this.__deletionAdapterOfStockEntity = new EntityDeletionOrUpdateAdapter<StockEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `stock` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, StockEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfStockEntity = new EntityDeletionOrUpdateAdapter<StockEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `stock` SET `id` = ?,`item_id` = ?,`wh_id` = ?,`item_code` = ?,`wh_code` = ?,`pid` = ?,`qty` = ?,`qtyx` = ?,`active` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, StockEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getItemId());
        stmt.bindLong(3, value.getWhId());
        if (value.getItemCode() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getItemCode());
        }
        if (value.getWhCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWhCode());
        }
        if (value.getPid() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPid());
        }
        if (value.getQty() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getQty());
        }
        if (value.getQtyx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getQtyx());
        }
        final int _tmp = value.getActive() ? 1 : 0;
        stmt.bindLong(9, _tmp);
        if (value.getId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends StockEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final StockEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends StockEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfStockEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final StockEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfStockEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final StockEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfStockEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<StockEntity> getStockByItemAndWh(final int itemId, final int whId) {
    final String _sql = "SELECT * FROM stock WHERE item_id = ? AND wh_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, itemId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, whId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfWhId = CursorUtil.getColumnIndexOrThrow(_cursor, "wh_id");
      final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "item_code");
      final int _cursorIndexOfWhCode = CursorUtil.getColumnIndexOrThrow(_cursor, "wh_code");
      final int _cursorIndexOfPid = CursorUtil.getColumnIndexOrThrow(_cursor, "pid");
      final int _cursorIndexOfQty = CursorUtil.getColumnIndexOrThrow(_cursor, "qty");
      final int _cursorIndexOfQtyx = CursorUtil.getColumnIndexOrThrow(_cursor, "qtyx");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final List<StockEntity> _result = new ArrayList<StockEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final StockEntity _item;
        _item = new StockEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _item.setItemId(_tmpItemId);
        final int _tmpWhId;
        _tmpWhId = _cursor.getInt(_cursorIndexOfWhId);
        _item.setWhId(_tmpWhId);
        final String _tmpItemCode;
        if (_cursor.isNull(_cursorIndexOfItemCode)) {
          _tmpItemCode = null;
        } else {
          _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
        }
        _item.setItemCode(_tmpItemCode);
        final String _tmpWhCode;
        if (_cursor.isNull(_cursorIndexOfWhCode)) {
          _tmpWhCode = null;
        } else {
          _tmpWhCode = _cursor.getString(_cursorIndexOfWhCode);
        }
        _item.setWhCode(_tmpWhCode);
        final String _tmpPid;
        if (_cursor.isNull(_cursorIndexOfPid)) {
          _tmpPid = null;
        } else {
          _tmpPid = _cursor.getString(_cursorIndexOfPid);
        }
        _item.setPid(_tmpPid);
        final String _tmpQty;
        if (_cursor.isNull(_cursorIndexOfQty)) {
          _tmpQty = null;
        } else {
          _tmpQty = _cursor.getString(_cursorIndexOfQty);
        }
        _item.setQty(_tmpQty);
        final String _tmpQtyx;
        if (_cursor.isNull(_cursorIndexOfQtyx)) {
          _tmpQtyx = null;
        } else {
          _tmpQtyx = _cursor.getString(_cursorIndexOfQtyx);
        }
        _item.setQtyx(_tmpQtyx);
        final boolean _tmpActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp != 0;
        _item.setActive(_tmpActive);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<StockEntity> getStockByItem(final String itemId) {
    final String _sql = "SELECT * FROM stock WHERE item_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (itemId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, itemId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfWhId = CursorUtil.getColumnIndexOrThrow(_cursor, "wh_id");
      final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "item_code");
      final int _cursorIndexOfWhCode = CursorUtil.getColumnIndexOrThrow(_cursor, "wh_code");
      final int _cursorIndexOfPid = CursorUtil.getColumnIndexOrThrow(_cursor, "pid");
      final int _cursorIndexOfQty = CursorUtil.getColumnIndexOrThrow(_cursor, "qty");
      final int _cursorIndexOfQtyx = CursorUtil.getColumnIndexOrThrow(_cursor, "qtyx");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final List<StockEntity> _result = new ArrayList<StockEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final StockEntity _item;
        _item = new StockEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _item.setItemId(_tmpItemId);
        final int _tmpWhId;
        _tmpWhId = _cursor.getInt(_cursorIndexOfWhId);
        _item.setWhId(_tmpWhId);
        final String _tmpItemCode;
        if (_cursor.isNull(_cursorIndexOfItemCode)) {
          _tmpItemCode = null;
        } else {
          _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
        }
        _item.setItemCode(_tmpItemCode);
        final String _tmpWhCode;
        if (_cursor.isNull(_cursorIndexOfWhCode)) {
          _tmpWhCode = null;
        } else {
          _tmpWhCode = _cursor.getString(_cursorIndexOfWhCode);
        }
        _item.setWhCode(_tmpWhCode);
        final String _tmpPid;
        if (_cursor.isNull(_cursorIndexOfPid)) {
          _tmpPid = null;
        } else {
          _tmpPid = _cursor.getString(_cursorIndexOfPid);
        }
        _item.setPid(_tmpPid);
        final String _tmpQty;
        if (_cursor.isNull(_cursorIndexOfQty)) {
          _tmpQty = null;
        } else {
          _tmpQty = _cursor.getString(_cursorIndexOfQty);
        }
        _item.setQty(_tmpQty);
        final String _tmpQtyx;
        if (_cursor.isNull(_cursorIndexOfQtyx)) {
          _tmpQtyx = null;
        } else {
          _tmpQtyx = _cursor.getString(_cursorIndexOfQtyx);
        }
        _item.setQtyx(_tmpQtyx);
        final boolean _tmpActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp != 0;
        _item.setActive(_tmpActive);
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
