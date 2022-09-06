package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenEntity;
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
public final class PrinterKitchenDao_Impl implements PrinterKitchenDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PrinterKitchenEntity> __insertionAdapterOfPrinterKitchenEntity;

  private final EntityDeletionOrUpdateAdapter<PrinterKitchenEntity> __deletionAdapterOfPrinterKitchenEntity;

  private final EntityDeletionOrUpdateAdapter<PrinterKitchenEntity> __updateAdapterOfPrinterKitchenEntity;

  public PrinterKitchenDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPrinterKitchenEntity = new EntityInsertionAdapter<PrinterKitchenEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `printer_kitchen` (`id`,`kitchen_name`,`printer_id`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PrinterKitchenEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getKitchenName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKitchenName());
        }
        stmt.bindLong(3, value.getPrinterId());
      }
    };
    this.__deletionAdapterOfPrinterKitchenEntity = new EntityDeletionOrUpdateAdapter<PrinterKitchenEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `printer_kitchen` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PrinterKitchenEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPrinterKitchenEntity = new EntityDeletionOrUpdateAdapter<PrinterKitchenEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `printer_kitchen` SET `id` = ?,`kitchen_name` = ?,`printer_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PrinterKitchenEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getKitchenName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKitchenName());
        }
        stmt.bindLong(3, value.getPrinterId());
        stmt.bindLong(4, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends PrinterKitchenEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final PrinterKitchenEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends PrinterKitchenEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPrinterKitchenEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final PrinterKitchenEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPrinterKitchenEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final PrinterKitchenEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPrinterKitchenEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<PrinterKitchenEntity> getByPrinter(final int id) {
    final String _sql = "SELECT * FROM printer_kitchen where printer_id = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfKitchenName = CursorUtil.getColumnIndexOrThrow(_cursor, "kitchen_name");
      final int _cursorIndexOfPrinterId = CursorUtil.getColumnIndexOrThrow(_cursor, "printer_id");
      final List<PrinterKitchenEntity> _result = new ArrayList<PrinterKitchenEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PrinterKitchenEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpKitchenName;
        if (_cursor.isNull(_cursorIndexOfKitchenName)) {
          _tmpKitchenName = null;
        } else {
          _tmpKitchenName = _cursor.getString(_cursorIndexOfKitchenName);
        }
        final int _tmpPrinterId;
        _tmpPrinterId = _cursor.getInt(_cursorIndexOfPrinterId);
        _item = new PrinterKitchenEntity(_tmpId,_tmpKitchenName,_tmpPrinterId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public PrinterKitchenEntity getById(final int id) {
    final String _sql = "SELECT * FROM printer_kitchen where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfKitchenName = CursorUtil.getColumnIndexOrThrow(_cursor, "kitchen_name");
      final int _cursorIndexOfPrinterId = CursorUtil.getColumnIndexOrThrow(_cursor, "printer_id");
      final PrinterKitchenEntity _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpKitchenName;
        if (_cursor.isNull(_cursorIndexOfKitchenName)) {
          _tmpKitchenName = null;
        } else {
          _tmpKitchenName = _cursor.getString(_cursorIndexOfKitchenName);
        }
        final int _tmpPrinterId;
        _tmpPrinterId = _cursor.getInt(_cursorIndexOfPrinterId);
        _result = new PrinterKitchenEntity(_tmpId,_tmpKitchenName,_tmpPrinterId);
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
  public PrinterKitchenEntity getLastId() {
    final String _sql = "SELECT * FROM printer_kitchen ORDER BY id DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfKitchenName = CursorUtil.getColumnIndexOrThrow(_cursor, "kitchen_name");
      final int _cursorIndexOfPrinterId = CursorUtil.getColumnIndexOrThrow(_cursor, "printer_id");
      final PrinterKitchenEntity _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpKitchenName;
        if (_cursor.isNull(_cursorIndexOfKitchenName)) {
          _tmpKitchenName = null;
        } else {
          _tmpKitchenName = _cursor.getString(_cursorIndexOfKitchenName);
        }
        final int _tmpPrinterId;
        _tmpPrinterId = _cursor.getInt(_cursorIndexOfPrinterId);
        _result = new PrinterKitchenEntity(_tmpId,_tmpKitchenName,_tmpPrinterId);
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
