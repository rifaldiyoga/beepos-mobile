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
import com.bits.bee.bpmc.data.data_source.local.model.PriceLvlEntity;
import java.lang.Class;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PriceLvlDao_Impl implements PriceLvlDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PriceLvlEntity> __insertionAdapterOfPriceLvlEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<PriceLvlEntity> __deletionAdapterOfPriceLvlEntity;

  private final EntityDeletionOrUpdateAdapter<PriceLvlEntity> __updateAdapterOfPriceLvlEntity;

  public PriceLvlDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPriceLvlEntity = new EntityInsertionAdapter<PriceLvlEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `price_lvl` (`id`,`name`,`code`,`updated_at`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PriceLvlEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCode());
        }
        final Long _tmp = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
      }
    };
    this.__deletionAdapterOfPriceLvlEntity = new EntityDeletionOrUpdateAdapter<PriceLvlEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `price_lvl` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PriceLvlEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPriceLvlEntity = new EntityDeletionOrUpdateAdapter<PriceLvlEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `price_lvl` SET `id` = ?,`name` = ?,`code` = ?,`updated_at` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PriceLvlEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCode());
        }
        final Long _tmp = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends PriceLvlEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final PriceLvlEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends PriceLvlEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPriceLvlEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final PriceLvlEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPriceLvlEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final PriceLvlEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPriceLvlEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<PriceLvlEntity> getActivePriceLvl() {
    final String _sql = "SELECT * FROM price_lvl";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final List<PriceLvlEntity> _result = new ArrayList<PriceLvlEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PriceLvlEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final Date _tmpUpdatedAt;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfUpdatedAt);
        }
        _tmpUpdatedAt = __converters.longToDate(_tmp);
        _item = new PriceLvlEntity(_tmpId,_tmpName,_tmpCode,_tmpUpdatedAt);
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
