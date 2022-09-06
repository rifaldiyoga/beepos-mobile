package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity;
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
public final class PrinterDao_Impl implements PrinterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PrinterEntity> __insertionAdapterOfPrinterEntity;

  private final EntityDeletionOrUpdateAdapter<PrinterEntity> __deletionAdapterOfPrinterEntity;

  private final EntityDeletionOrUpdateAdapter<PrinterEntity> __updateAdapterOfPrinterEntity;

  public PrinterDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPrinterEntity = new EntityInsertionAdapter<PrinterEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `printer` (`id`,`printername`,`address`,`tipe`,`size`,`is_receipt`,`is_kitchen`,`is_report`,`is_checker`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PrinterEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getPrinterName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPrinterName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAddress());
        }
        stmt.bindLong(4, value.getTipe());
        if (value.getSize() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSize());
        }
        final int _tmp = value.isReceipt() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        final int _tmp_1 = value.isKitchen() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        final int _tmp_2 = value.isReport() ? 1 : 0;
        stmt.bindLong(8, _tmp_2);
        final int _tmp_3 = value.isChecker() ? 1 : 0;
        stmt.bindLong(9, _tmp_3);
      }
    };
    this.__deletionAdapterOfPrinterEntity = new EntityDeletionOrUpdateAdapter<PrinterEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `printer` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PrinterEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPrinterEntity = new EntityDeletionOrUpdateAdapter<PrinterEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `printer` SET `id` = ?,`printername` = ?,`address` = ?,`tipe` = ?,`size` = ?,`is_receipt` = ?,`is_kitchen` = ?,`is_report` = ?,`is_checker` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PrinterEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getPrinterName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPrinterName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAddress());
        }
        stmt.bindLong(4, value.getTipe());
        if (value.getSize() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSize());
        }
        final int _tmp = value.isReceipt() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        final int _tmp_1 = value.isKitchen() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        final int _tmp_2 = value.isReport() ? 1 : 0;
        stmt.bindLong(8, _tmp_2);
        final int _tmp_3 = value.isChecker() ? 1 : 0;
        stmt.bindLong(9, _tmp_3);
        stmt.bindLong(10, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends PrinterEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final PrinterEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends PrinterEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPrinterEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final PrinterEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPrinterEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final PrinterEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPrinterEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<PrinterEntity> readByAddress(final String id) {
    final String _sql = "SELECT * FROM printer where address = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPrinterName = CursorUtil.getColumnIndexOrThrow(_cursor, "printername");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfTipe = CursorUtil.getColumnIndexOrThrow(_cursor, "tipe");
      final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
      final int _cursorIndexOfIsReceipt = CursorUtil.getColumnIndexOrThrow(_cursor, "is_receipt");
      final int _cursorIndexOfIsKitchen = CursorUtil.getColumnIndexOrThrow(_cursor, "is_kitchen");
      final int _cursorIndexOfIsReport = CursorUtil.getColumnIndexOrThrow(_cursor, "is_report");
      final int _cursorIndexOfIsChecker = CursorUtil.getColumnIndexOrThrow(_cursor, "is_checker");
      final List<PrinterEntity> _result = new ArrayList<PrinterEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PrinterEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpPrinterName;
        if (_cursor.isNull(_cursorIndexOfPrinterName)) {
          _tmpPrinterName = null;
        } else {
          _tmpPrinterName = _cursor.getString(_cursorIndexOfPrinterName);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final int _tmpTipe;
        _tmpTipe = _cursor.getInt(_cursorIndexOfTipe);
        final String _tmpSize;
        if (_cursor.isNull(_cursorIndexOfSize)) {
          _tmpSize = null;
        } else {
          _tmpSize = _cursor.getString(_cursorIndexOfSize);
        }
        final boolean _tmpIsReceipt;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsReceipt);
        _tmpIsReceipt = _tmp != 0;
        final boolean _tmpIsKitchen;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsKitchen);
        _tmpIsKitchen = _tmp_1 != 0;
        final boolean _tmpIsReport;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsReport);
        _tmpIsReport = _tmp_2 != 0;
        final boolean _tmpIsChecker;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfIsChecker);
        _tmpIsChecker = _tmp_3 != 0;
        _item = new PrinterEntity(_tmpId,_tmpPrinterName,_tmpAddress,_tmpTipe,_tmpSize,_tmpIsReceipt,_tmpIsKitchen,_tmpIsReport,_tmpIsChecker);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PrinterEntity> readByActiveReceipt(final boolean isReceipt) {
    final String _sql = "SELECT * FROM printer where is_receipt = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp = isReceipt ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPrinterName = CursorUtil.getColumnIndexOrThrow(_cursor, "printername");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfTipe = CursorUtil.getColumnIndexOrThrow(_cursor, "tipe");
      final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
      final int _cursorIndexOfIsReceipt = CursorUtil.getColumnIndexOrThrow(_cursor, "is_receipt");
      final int _cursorIndexOfIsKitchen = CursorUtil.getColumnIndexOrThrow(_cursor, "is_kitchen");
      final int _cursorIndexOfIsReport = CursorUtil.getColumnIndexOrThrow(_cursor, "is_report");
      final int _cursorIndexOfIsChecker = CursorUtil.getColumnIndexOrThrow(_cursor, "is_checker");
      final List<PrinterEntity> _result = new ArrayList<PrinterEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PrinterEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpPrinterName;
        if (_cursor.isNull(_cursorIndexOfPrinterName)) {
          _tmpPrinterName = null;
        } else {
          _tmpPrinterName = _cursor.getString(_cursorIndexOfPrinterName);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final int _tmpTipe;
        _tmpTipe = _cursor.getInt(_cursorIndexOfTipe);
        final String _tmpSize;
        if (_cursor.isNull(_cursorIndexOfSize)) {
          _tmpSize = null;
        } else {
          _tmpSize = _cursor.getString(_cursorIndexOfSize);
        }
        final boolean _tmpIsReceipt;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsReceipt);
        _tmpIsReceipt = _tmp_1 != 0;
        final boolean _tmpIsKitchen;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsKitchen);
        _tmpIsKitchen = _tmp_2 != 0;
        final boolean _tmpIsReport;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfIsReport);
        _tmpIsReport = _tmp_3 != 0;
        final boolean _tmpIsChecker;
        final int _tmp_4;
        _tmp_4 = _cursor.getInt(_cursorIndexOfIsChecker);
        _tmpIsChecker = _tmp_4 != 0;
        _item = new PrinterEntity(_tmpId,_tmpPrinterName,_tmpAddress,_tmpTipe,_tmpSize,_tmpIsReceipt,_tmpIsKitchen,_tmpIsReport,_tmpIsChecker);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PrinterEntity> readByActiveReport(final boolean isReport) {
    final String _sql = "SELECT * FROM printer where is_report = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp = isReport ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPrinterName = CursorUtil.getColumnIndexOrThrow(_cursor, "printername");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfTipe = CursorUtil.getColumnIndexOrThrow(_cursor, "tipe");
      final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
      final int _cursorIndexOfIsReceipt = CursorUtil.getColumnIndexOrThrow(_cursor, "is_receipt");
      final int _cursorIndexOfIsKitchen = CursorUtil.getColumnIndexOrThrow(_cursor, "is_kitchen");
      final int _cursorIndexOfIsReport = CursorUtil.getColumnIndexOrThrow(_cursor, "is_report");
      final int _cursorIndexOfIsChecker = CursorUtil.getColumnIndexOrThrow(_cursor, "is_checker");
      final List<PrinterEntity> _result = new ArrayList<PrinterEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PrinterEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpPrinterName;
        if (_cursor.isNull(_cursorIndexOfPrinterName)) {
          _tmpPrinterName = null;
        } else {
          _tmpPrinterName = _cursor.getString(_cursorIndexOfPrinterName);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final int _tmpTipe;
        _tmpTipe = _cursor.getInt(_cursorIndexOfTipe);
        final String _tmpSize;
        if (_cursor.isNull(_cursorIndexOfSize)) {
          _tmpSize = null;
        } else {
          _tmpSize = _cursor.getString(_cursorIndexOfSize);
        }
        final boolean _tmpIsReceipt;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsReceipt);
        _tmpIsReceipt = _tmp_1 != 0;
        final boolean _tmpIsKitchen;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsKitchen);
        _tmpIsKitchen = _tmp_2 != 0;
        final boolean _tmpIsReport;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfIsReport);
        _tmpIsReport = _tmp_3 != 0;
        final boolean _tmpIsChecker;
        final int _tmp_4;
        _tmp_4 = _cursor.getInt(_cursorIndexOfIsChecker);
        _tmpIsChecker = _tmp_4 != 0;
        _item = new PrinterEntity(_tmpId,_tmpPrinterName,_tmpAddress,_tmpTipe,_tmpSize,_tmpIsReceipt,_tmpIsKitchen,_tmpIsReport,_tmpIsChecker);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PrinterEntity> readByActiveKitchen(final boolean isKitchen) {
    final String _sql = "SELECT * FROM printer where is_kitchen = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp = isKitchen ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPrinterName = CursorUtil.getColumnIndexOrThrow(_cursor, "printername");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfTipe = CursorUtil.getColumnIndexOrThrow(_cursor, "tipe");
      final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
      final int _cursorIndexOfIsReceipt = CursorUtil.getColumnIndexOrThrow(_cursor, "is_receipt");
      final int _cursorIndexOfIsKitchen = CursorUtil.getColumnIndexOrThrow(_cursor, "is_kitchen");
      final int _cursorIndexOfIsReport = CursorUtil.getColumnIndexOrThrow(_cursor, "is_report");
      final int _cursorIndexOfIsChecker = CursorUtil.getColumnIndexOrThrow(_cursor, "is_checker");
      final List<PrinterEntity> _result = new ArrayList<PrinterEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PrinterEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpPrinterName;
        if (_cursor.isNull(_cursorIndexOfPrinterName)) {
          _tmpPrinterName = null;
        } else {
          _tmpPrinterName = _cursor.getString(_cursorIndexOfPrinterName);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final int _tmpTipe;
        _tmpTipe = _cursor.getInt(_cursorIndexOfTipe);
        final String _tmpSize;
        if (_cursor.isNull(_cursorIndexOfSize)) {
          _tmpSize = null;
        } else {
          _tmpSize = _cursor.getString(_cursorIndexOfSize);
        }
        final boolean _tmpIsReceipt;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsReceipt);
        _tmpIsReceipt = _tmp_1 != 0;
        final boolean _tmpIsKitchen;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsKitchen);
        _tmpIsKitchen = _tmp_2 != 0;
        final boolean _tmpIsReport;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfIsReport);
        _tmpIsReport = _tmp_3 != 0;
        final boolean _tmpIsChecker;
        final int _tmp_4;
        _tmp_4 = _cursor.getInt(_cursorIndexOfIsChecker);
        _tmpIsChecker = _tmp_4 != 0;
        _item = new PrinterEntity(_tmpId,_tmpPrinterName,_tmpAddress,_tmpTipe,_tmpSize,_tmpIsReceipt,_tmpIsKitchen,_tmpIsReport,_tmpIsChecker);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PrinterEntity> readByActiveChecker(final boolean isChecker) {
    final String _sql = "SELECT * FROM printer where is_checker = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp = isChecker ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPrinterName = CursorUtil.getColumnIndexOrThrow(_cursor, "printername");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfTipe = CursorUtil.getColumnIndexOrThrow(_cursor, "tipe");
      final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
      final int _cursorIndexOfIsReceipt = CursorUtil.getColumnIndexOrThrow(_cursor, "is_receipt");
      final int _cursorIndexOfIsKitchen = CursorUtil.getColumnIndexOrThrow(_cursor, "is_kitchen");
      final int _cursorIndexOfIsReport = CursorUtil.getColumnIndexOrThrow(_cursor, "is_report");
      final int _cursorIndexOfIsChecker = CursorUtil.getColumnIndexOrThrow(_cursor, "is_checker");
      final List<PrinterEntity> _result = new ArrayList<PrinterEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PrinterEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpPrinterName;
        if (_cursor.isNull(_cursorIndexOfPrinterName)) {
          _tmpPrinterName = null;
        } else {
          _tmpPrinterName = _cursor.getString(_cursorIndexOfPrinterName);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final int _tmpTipe;
        _tmpTipe = _cursor.getInt(_cursorIndexOfTipe);
        final String _tmpSize;
        if (_cursor.isNull(_cursorIndexOfSize)) {
          _tmpSize = null;
        } else {
          _tmpSize = _cursor.getString(_cursorIndexOfSize);
        }
        final boolean _tmpIsReceipt;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsReceipt);
        _tmpIsReceipt = _tmp_1 != 0;
        final boolean _tmpIsKitchen;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsKitchen);
        _tmpIsKitchen = _tmp_2 != 0;
        final boolean _tmpIsReport;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfIsReport);
        _tmpIsReport = _tmp_3 != 0;
        final boolean _tmpIsChecker;
        final int _tmp_4;
        _tmp_4 = _cursor.getInt(_cursorIndexOfIsChecker);
        _tmpIsChecker = _tmp_4 != 0;
        _item = new PrinterEntity(_tmpId,_tmpPrinterName,_tmpAddress,_tmpTipe,_tmpSize,_tmpIsReceipt,_tmpIsKitchen,_tmpIsReport,_tmpIsChecker);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PrinterEntity> readByTipe(final int tipe) {
    final String _sql = "SELECT * FROM printer where tipe = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, tipe);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPrinterName = CursorUtil.getColumnIndexOrThrow(_cursor, "printername");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfTipe = CursorUtil.getColumnIndexOrThrow(_cursor, "tipe");
      final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
      final int _cursorIndexOfIsReceipt = CursorUtil.getColumnIndexOrThrow(_cursor, "is_receipt");
      final int _cursorIndexOfIsKitchen = CursorUtil.getColumnIndexOrThrow(_cursor, "is_kitchen");
      final int _cursorIndexOfIsReport = CursorUtil.getColumnIndexOrThrow(_cursor, "is_report");
      final int _cursorIndexOfIsChecker = CursorUtil.getColumnIndexOrThrow(_cursor, "is_checker");
      final List<PrinterEntity> _result = new ArrayList<PrinterEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PrinterEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpPrinterName;
        if (_cursor.isNull(_cursorIndexOfPrinterName)) {
          _tmpPrinterName = null;
        } else {
          _tmpPrinterName = _cursor.getString(_cursorIndexOfPrinterName);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final int _tmpTipe;
        _tmpTipe = _cursor.getInt(_cursorIndexOfTipe);
        final String _tmpSize;
        if (_cursor.isNull(_cursorIndexOfSize)) {
          _tmpSize = null;
        } else {
          _tmpSize = _cursor.getString(_cursorIndexOfSize);
        }
        final boolean _tmpIsReceipt;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsReceipt);
        _tmpIsReceipt = _tmp != 0;
        final boolean _tmpIsKitchen;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsKitchen);
        _tmpIsKitchen = _tmp_1 != 0;
        final boolean _tmpIsReport;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsReport);
        _tmpIsReport = _tmp_2 != 0;
        final boolean _tmpIsChecker;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfIsChecker);
        _tmpIsChecker = _tmp_3 != 0;
        _item = new PrinterEntity(_tmpId,_tmpPrinterName,_tmpAddress,_tmpTipe,_tmpSize,_tmpIsReceipt,_tmpIsKitchen,_tmpIsReport,_tmpIsChecker);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public PrinterEntity getLastId() {
    final String _sql = "SELECT * FROM printer ORDER BY id DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPrinterName = CursorUtil.getColumnIndexOrThrow(_cursor, "printername");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfTipe = CursorUtil.getColumnIndexOrThrow(_cursor, "tipe");
      final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
      final int _cursorIndexOfIsReceipt = CursorUtil.getColumnIndexOrThrow(_cursor, "is_receipt");
      final int _cursorIndexOfIsKitchen = CursorUtil.getColumnIndexOrThrow(_cursor, "is_kitchen");
      final int _cursorIndexOfIsReport = CursorUtil.getColumnIndexOrThrow(_cursor, "is_report");
      final int _cursorIndexOfIsChecker = CursorUtil.getColumnIndexOrThrow(_cursor, "is_checker");
      final PrinterEntity _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpPrinterName;
        if (_cursor.isNull(_cursorIndexOfPrinterName)) {
          _tmpPrinterName = null;
        } else {
          _tmpPrinterName = _cursor.getString(_cursorIndexOfPrinterName);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final int _tmpTipe;
        _tmpTipe = _cursor.getInt(_cursorIndexOfTipe);
        final String _tmpSize;
        if (_cursor.isNull(_cursorIndexOfSize)) {
          _tmpSize = null;
        } else {
          _tmpSize = _cursor.getString(_cursorIndexOfSize);
        }
        final boolean _tmpIsReceipt;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsReceipt);
        _tmpIsReceipt = _tmp != 0;
        final boolean _tmpIsKitchen;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsKitchen);
        _tmpIsKitchen = _tmp_1 != 0;
        final boolean _tmpIsReport;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsReport);
        _tmpIsReport = _tmp_2 != 0;
        final boolean _tmpIsChecker;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfIsChecker);
        _tmpIsChecker = _tmp_3 != 0;
        _result = new PrinterEntity(_tmpId,_tmpPrinterName,_tmpAddress,_tmpTipe,_tmpSize,_tmpIsReceipt,_tmpIsKitchen,_tmpIsReport,_tmpIsChecker);
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
  public List<PrinterEntity> readPrinter() {
    final String _sql = "SELECT * FROM printer";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPrinterName = CursorUtil.getColumnIndexOrThrow(_cursor, "printername");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfTipe = CursorUtil.getColumnIndexOrThrow(_cursor, "tipe");
      final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
      final int _cursorIndexOfIsReceipt = CursorUtil.getColumnIndexOrThrow(_cursor, "is_receipt");
      final int _cursorIndexOfIsKitchen = CursorUtil.getColumnIndexOrThrow(_cursor, "is_kitchen");
      final int _cursorIndexOfIsReport = CursorUtil.getColumnIndexOrThrow(_cursor, "is_report");
      final int _cursorIndexOfIsChecker = CursorUtil.getColumnIndexOrThrow(_cursor, "is_checker");
      final List<PrinterEntity> _result = new ArrayList<PrinterEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PrinterEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpPrinterName;
        if (_cursor.isNull(_cursorIndexOfPrinterName)) {
          _tmpPrinterName = null;
        } else {
          _tmpPrinterName = _cursor.getString(_cursorIndexOfPrinterName);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final int _tmpTipe;
        _tmpTipe = _cursor.getInt(_cursorIndexOfTipe);
        final String _tmpSize;
        if (_cursor.isNull(_cursorIndexOfSize)) {
          _tmpSize = null;
        } else {
          _tmpSize = _cursor.getString(_cursorIndexOfSize);
        }
        final boolean _tmpIsReceipt;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsReceipt);
        _tmpIsReceipt = _tmp != 0;
        final boolean _tmpIsKitchen;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsKitchen);
        _tmpIsKitchen = _tmp_1 != 0;
        final boolean _tmpIsReport;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsReport);
        _tmpIsReport = _tmp_2 != 0;
        final boolean _tmpIsChecker;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfIsChecker);
        _tmpIsChecker = _tmp_3 != 0;
        _item = new PrinterEntity(_tmpId,_tmpPrinterName,_tmpAddress,_tmpTipe,_tmpSize,_tmpIsReceipt,_tmpIsKitchen,_tmpIsReport,_tmpIsChecker);
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
