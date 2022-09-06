package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.ItemSaleTaxEntity;
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
public final class ItemSaleTaxDao_Impl implements ItemSaleTaxDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemSaleTaxEntity> __insertionAdapterOfItemSaleTaxEntity;

  private final EntityDeletionOrUpdateAdapter<ItemSaleTaxEntity> __deletionAdapterOfItemSaleTaxEntity;

  private final EntityDeletionOrUpdateAdapter<ItemSaleTaxEntity> __updateAdapterOfItemSaleTaxEntity;

  public ItemSaleTaxDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemSaleTaxEntity = new EntityInsertionAdapter<ItemSaleTaxEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `item_tax` (`id`,`item_code`,`tax_code`,`calcmtd`,`expr`,`expr_noreg`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemSaleTaxEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getItemCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItemCode());
        }
        if (value.getCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCode());
        }
        if (value.getCalcMtd() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCalcMtd());
        }
        if (value.getExpr() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getExpr());
        }
        if (value.getExprNoReg() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getExprNoReg());
        }
      }
    };
    this.__deletionAdapterOfItemSaleTaxEntity = new EntityDeletionOrUpdateAdapter<ItemSaleTaxEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `item_tax` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemSaleTaxEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfItemSaleTaxEntity = new EntityDeletionOrUpdateAdapter<ItemSaleTaxEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `item_tax` SET `id` = ?,`item_code` = ?,`tax_code` = ?,`calcmtd` = ?,`expr` = ?,`expr_noreg` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemSaleTaxEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getItemCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItemCode());
        }
        if (value.getCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCode());
        }
        if (value.getCalcMtd() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCalcMtd());
        }
        if (value.getExpr() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getExpr());
        }
        if (value.getExprNoReg() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getExprNoReg());
        }
        if (value.getId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends ItemSaleTaxEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final ItemSaleTaxEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends ItemSaleTaxEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemSaleTaxEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ItemSaleTaxEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemSaleTaxEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ItemSaleTaxEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfItemSaleTaxEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ItemSaleTaxEntity> getItemSaleTax() {
    final String _sql = "SELECT * FROM item_tax";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "item_code");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "tax_code");
      final int _cursorIndexOfCalcMtd = CursorUtil.getColumnIndexOrThrow(_cursor, "calcmtd");
      final int _cursorIndexOfExpr = CursorUtil.getColumnIndexOrThrow(_cursor, "expr");
      final int _cursorIndexOfExprNoReg = CursorUtil.getColumnIndexOrThrow(_cursor, "expr_noreg");
      final List<ItemSaleTaxEntity> _result = new ArrayList<ItemSaleTaxEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemSaleTaxEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpItemCode;
        if (_cursor.isNull(_cursorIndexOfItemCode)) {
          _tmpItemCode = null;
        } else {
          _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
        }
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpCalcMtd;
        if (_cursor.isNull(_cursorIndexOfCalcMtd)) {
          _tmpCalcMtd = null;
        } else {
          _tmpCalcMtd = _cursor.getString(_cursorIndexOfCalcMtd);
        }
        final String _tmpExpr;
        if (_cursor.isNull(_cursorIndexOfExpr)) {
          _tmpExpr = null;
        } else {
          _tmpExpr = _cursor.getString(_cursorIndexOfExpr);
        }
        final String _tmpExprNoReg;
        if (_cursor.isNull(_cursorIndexOfExprNoReg)) {
          _tmpExprNoReg = null;
        } else {
          _tmpExprNoReg = _cursor.getString(_cursorIndexOfExprNoReg);
        }
        _item = new ItemSaleTaxEntity(_tmpId,_tmpItemCode,_tmpCode,_tmpCalcMtd,_tmpExpr,_tmpExprNoReg);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ItemSaleTaxEntity getItemTaxByCodeItem(final String itemCode) {
    final String _sql = "SELECT a.*, b.expr FROM item_tax a JOIN tax b ON a.tax_code = b.code WHERE item_code = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (itemCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, itemCode);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "item_code");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "tax_code");
      final int _cursorIndexOfCalcMtd = CursorUtil.getColumnIndexOrThrow(_cursor, "calcmtd");
      final int _cursorIndexOfExpr = CursorUtil.getColumnIndexOrThrow(_cursor, "expr");
      final int _cursorIndexOfExprNoReg = CursorUtil.getColumnIndexOrThrow(_cursor, "expr_noreg");
      final int _cursorIndexOfExpr_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "expr");
      final ItemSaleTaxEntity _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpItemCode;
        if (_cursor.isNull(_cursorIndexOfItemCode)) {
          _tmpItemCode = null;
        } else {
          _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
        }
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpCalcMtd;
        if (_cursor.isNull(_cursorIndexOfCalcMtd)) {
          _tmpCalcMtd = null;
        } else {
          _tmpCalcMtd = _cursor.getString(_cursorIndexOfCalcMtd);
        }
        final String _tmpExpr;
        if (_cursor.isNull(_cursorIndexOfExpr)) {
          _tmpExpr = null;
        } else {
          _tmpExpr = _cursor.getString(_cursorIndexOfExpr);
        }
        final String _tmpExprNoReg;
        if (_cursor.isNull(_cursorIndexOfExprNoReg)) {
          _tmpExprNoReg = null;
        } else {
          _tmpExprNoReg = _cursor.getString(_cursorIndexOfExprNoReg);
        }
        final String _tmpExpr_1;
        if (_cursor.isNull(_cursorIndexOfExpr_1)) {
          _tmpExpr_1 = null;
        } else {
          _tmpExpr_1 = _cursor.getString(_cursorIndexOfExpr_1);
        }
        _result = new ItemSaleTaxEntity(_tmpId,_tmpItemCode,_tmpCode,_tmpCalcMtd,_tmpExpr,_tmpExprNoReg);
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
