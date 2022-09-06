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
import com.bits.bee.bpmc.data.data_source.local.model.PriceEntity;
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
public final class PriceDao_Impl implements PriceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PriceEntity> __insertionAdapterOfPriceEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<PriceEntity> __deletionAdapterOfPriceEntity;

  private final EntityDeletionOrUpdateAdapter<PriceEntity> __updateAdapterOfPriceEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public PriceDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPriceEntity = new EntityInsertionAdapter<PriceEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `price` (`id`,`itemid`,`pricelvl_id`,`price1`,`discexp1`,`crc_id`,`crc_symbol`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PriceEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getItemId());
        stmt.bindLong(3, value.getPriceLvlId());
        final String _tmp = __converters.bigDecimalToString(value.getPrice());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        if (value.getDiscExp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDiscExp());
        }
        stmt.bindLong(6, value.getCrcId());
        if (value.getCrcSymbol() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCrcSymbol());
        }
      }
    };
    this.__deletionAdapterOfPriceEntity = new EntityDeletionOrUpdateAdapter<PriceEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `price` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PriceEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfPriceEntity = new EntityDeletionOrUpdateAdapter<PriceEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `price` SET `id` = ?,`itemid` = ?,`pricelvl_id` = ?,`price1` = ?,`discexp1` = ?,`crc_id` = ?,`crc_symbol` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PriceEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getItemId());
        stmt.bindLong(3, value.getPriceLvlId());
        final String _tmp = __converters.bigDecimalToString(value.getPrice());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        if (value.getDiscExp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDiscExp());
        }
        stmt.bindLong(6, value.getCrcId());
        if (value.getCrcSymbol() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCrcSymbol());
        }
        if (value.getId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM price";
        return _query;
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends PriceEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final PriceEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends PriceEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPriceEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final PriceEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPriceEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final PriceEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPriceEntity.handle(entity);
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
  public List<PriceEntity> getPriceList() {
    final String _sql = "SELECT * FROM price";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemid");
      final int _cursorIndexOfPriceLvlId = CursorUtil.getColumnIndexOrThrow(_cursor, "pricelvl_id");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price1");
      final int _cursorIndexOfDiscExp = CursorUtil.getColumnIndexOrThrow(_cursor, "discexp1");
      final int _cursorIndexOfCrcId = CursorUtil.getColumnIndexOrThrow(_cursor, "crc_id");
      final int _cursorIndexOfCrcSymbol = CursorUtil.getColumnIndexOrThrow(_cursor, "crc_symbol");
      final List<PriceEntity> _result = new ArrayList<PriceEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PriceEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        final int _tmpPriceLvlId;
        _tmpPriceLvlId = _cursor.getInt(_cursorIndexOfPriceLvlId);
        final BigDecimal _tmpPrice;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfPrice);
        }
        _tmpPrice = __converters.stringToBigDecimal(_tmp);
        final String _tmpDiscExp;
        if (_cursor.isNull(_cursorIndexOfDiscExp)) {
          _tmpDiscExp = null;
        } else {
          _tmpDiscExp = _cursor.getString(_cursorIndexOfDiscExp);
        }
        final int _tmpCrcId;
        _tmpCrcId = _cursor.getInt(_cursorIndexOfCrcId);
        final String _tmpCrcSymbol;
        if (_cursor.isNull(_cursorIndexOfCrcSymbol)) {
          _tmpCrcSymbol = null;
        } else {
          _tmpCrcSymbol = _cursor.getString(_cursorIndexOfCrcSymbol);
        }
        _item = new PriceEntity(_tmpId,_tmpItemId,_tmpPriceLvlId,_tmpPrice,_tmpDiscExp,_tmpCrcId,_tmpCrcSymbol);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public PriceEntity getPriceByPriceLvlItem(final int priceLvlId, final int itemId) {
    final String _sql = "SELECT * FROM price WHERE pricelvl_id = ? AND itemid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, priceLvlId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, itemId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemid");
      final int _cursorIndexOfPriceLvlId = CursorUtil.getColumnIndexOrThrow(_cursor, "pricelvl_id");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price1");
      final int _cursorIndexOfDiscExp = CursorUtil.getColumnIndexOrThrow(_cursor, "discexp1");
      final int _cursorIndexOfCrcId = CursorUtil.getColumnIndexOrThrow(_cursor, "crc_id");
      final int _cursorIndexOfCrcSymbol = CursorUtil.getColumnIndexOrThrow(_cursor, "crc_symbol");
      final PriceEntity _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        final int _tmpPriceLvlId;
        _tmpPriceLvlId = _cursor.getInt(_cursorIndexOfPriceLvlId);
        final BigDecimal _tmpPrice;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfPrice);
        }
        _tmpPrice = __converters.stringToBigDecimal(_tmp);
        final String _tmpDiscExp;
        if (_cursor.isNull(_cursorIndexOfDiscExp)) {
          _tmpDiscExp = null;
        } else {
          _tmpDiscExp = _cursor.getString(_cursorIndexOfDiscExp);
        }
        final int _tmpCrcId;
        _tmpCrcId = _cursor.getInt(_cursorIndexOfCrcId);
        final String _tmpCrcSymbol;
        if (_cursor.isNull(_cursorIndexOfCrcSymbol)) {
          _tmpCrcSymbol = null;
        } else {
          _tmpCrcSymbol = _cursor.getString(_cursorIndexOfCrcSymbol);
        }
        _result = new PriceEntity(_tmpId,_tmpItemId,_tmpPriceLvlId,_tmpPrice,_tmpDiscExp,_tmpCrcId,_tmpCrcSymbol);
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
