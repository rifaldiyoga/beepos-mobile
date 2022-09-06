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
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenDEntity;
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
public final class PrinterKitchenDDao_Impl implements PrinterKitchenDDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PrinterKitchenDEntity> __insertionAdapterOfPrinterKitchenDEntity;

  private final EntityDeletionOrUpdateAdapter<PrinterKitchenDEntity> __deletionAdapterOfPrinterKitchenDEntity;

  private final EntityDeletionOrUpdateAdapter<PrinterKitchenDEntity> __updateAdapterOfPrinterKitchenDEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeletePrinterKitchen;

  public PrinterKitchenDDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPrinterKitchenDEntity = new EntityInsertionAdapter<PrinterKitchenDEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `printer_kitchend` (`id`,`printer_kitchen_id`,`kitchen_id`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PrinterKitchenDEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getPrinterKitchenId());
        stmt.bindLong(3, value.getKitchenId());
      }
    };
    this.__deletionAdapterOfPrinterKitchenDEntity = new EntityDeletionOrUpdateAdapter<PrinterKitchenDEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `printer_kitchend` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PrinterKitchenDEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPrinterKitchenDEntity = new EntityDeletionOrUpdateAdapter<PrinterKitchenDEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `printer_kitchend` SET `id` = ?,`printer_kitchen_id` = ?,`kitchen_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PrinterKitchenDEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getPrinterKitchenId());
        stmt.bindLong(3, value.getKitchenId());
        stmt.bindLong(4, value.getId());
      }
    };
    this.__preparedStmtOfDeletePrinterKitchen = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM printer_kitchend where printer_kitchen_id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends PrinterKitchenDEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final PrinterKitchenDEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends PrinterKitchenDEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPrinterKitchenDEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final PrinterKitchenDEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPrinterKitchenDEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final PrinterKitchenDEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPrinterKitchenDEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deletePrinterKitchen(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePrinterKitchen.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeletePrinterKitchen.release(_stmt);
    }
  }

  @Override
  public List<PrinterKitchenDEntity> getPrinterKitchen(final int id) {
    final String _sql = "SELECT * FROM printer_kitchend where printer_kitchen_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPrinterKitchenId = CursorUtil.getColumnIndexOrThrow(_cursor, "printer_kitchen_id");
      final int _cursorIndexOfKitchenId = CursorUtil.getColumnIndexOrThrow(_cursor, "kitchen_id");
      final List<PrinterKitchenDEntity> _result = new ArrayList<PrinterKitchenDEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PrinterKitchenDEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpPrinterKitchenId;
        _tmpPrinterKitchenId = _cursor.getInt(_cursorIndexOfPrinterKitchenId);
        final int _tmpKitchenId;
        _tmpKitchenId = _cursor.getInt(_cursorIndexOfKitchenId);
        _item = new PrinterKitchenDEntity(_tmpId,_tmpPrinterKitchenId,_tmpKitchenId);
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
