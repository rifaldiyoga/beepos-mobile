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
import com.bits.bee.bpmc.data.data_source.local.model.ChannelEntity;
import java.lang.Class;
import java.lang.Integer;
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
public final class ChannelDao_Impl implements ChannelDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ChannelEntity> __insertionAdapterOfChannelEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<ChannelEntity> __deletionAdapterOfChannelEntity;

  private final EntityDeletionOrUpdateAdapter<ChannelEntity> __updateAdapterOfChannelEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ChannelDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChannelEntity = new EntityInsertionAdapter<ChannelEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `channel` (`id`,`code`,`name`,`active`,`ispos`,`created_by`,`created_at`,`updated_by`,`updated_at`,`color`,`pricelvl_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChannelEntity value) {
        stmt.bindLong(1, value.getId());
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
        final int _tmp = value.getActive() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        final int _tmp_1 = value.isPos() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
        if (value.getCreatedBy() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getCreatedBy());
        }
        final Long _tmp_2 = __converters.dateToLong(value.getCreatedAt());
        if (_tmp_2 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp_2);
        }
        if (value.getUpdatedBy() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getUpdatedBy());
        }
        final Long _tmp_3 = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp_3 == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, _tmp_3);
        }
        if (value.getColor() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getColor());
        }
        if (value.getPriceLvlId() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getPriceLvlId());
        }
      }
    };
    this.__deletionAdapterOfChannelEntity = new EntityDeletionOrUpdateAdapter<ChannelEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `channel` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChannelEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfChannelEntity = new EntityDeletionOrUpdateAdapter<ChannelEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `channel` SET `id` = ?,`code` = ?,`name` = ?,`active` = ?,`ispos` = ?,`created_by` = ?,`created_at` = ?,`updated_by` = ?,`updated_at` = ?,`color` = ?,`pricelvl_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChannelEntity value) {
        stmt.bindLong(1, value.getId());
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
        final int _tmp = value.getActive() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        final int _tmp_1 = value.isPos() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
        if (value.getCreatedBy() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getCreatedBy());
        }
        final Long _tmp_2 = __converters.dateToLong(value.getCreatedAt());
        if (_tmp_2 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp_2);
        }
        if (value.getUpdatedBy() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getUpdatedBy());
        }
        final Long _tmp_3 = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp_3 == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, _tmp_3);
        }
        if (value.getColor() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getColor());
        }
        if (value.getPriceLvlId() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getPriceLvlId());
        }
        stmt.bindLong(12, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM channel";
        return _query;
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends ChannelEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final ChannelEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends ChannelEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfChannelEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ChannelEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfChannelEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ChannelEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfChannelEntity.handle(entity);
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
  public List<ChannelEntity> getChannelList() {
    final String _sql = "SELECT * FROM channel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(_cursor, "ispos");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
      final int _cursorIndexOfPriceLvlId = CursorUtil.getColumnIndexOrThrow(_cursor, "pricelvl_id");
      final List<ChannelEntity> _result = new ArrayList<ChannelEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ChannelEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
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
        final boolean _tmpActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp != 0;
        final boolean _tmpIsPos;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsPos);
        _tmpIsPos = _tmp_1 != 0;
        final Integer _tmpCreatedBy;
        if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
          _tmpCreatedBy = null;
        } else {
          _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        }
        final Date _tmpCreatedAt;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp_2);
        final Integer _tmpUpdatedBy;
        if (_cursor.isNull(_cursorIndexOfUpdatedBy)) {
          _tmpUpdatedBy = null;
        } else {
          _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        }
        final Date _tmpUpdatedAt;
        final Long _tmp_3;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getLong(_cursorIndexOfUpdatedAt);
        }
        _tmpUpdatedAt = __converters.longToDate(_tmp_3);
        final String _tmpColor;
        if (_cursor.isNull(_cursorIndexOfColor)) {
          _tmpColor = null;
        } else {
          _tmpColor = _cursor.getString(_cursorIndexOfColor);
        }
        final Integer _tmpPriceLvlId;
        if (_cursor.isNull(_cursorIndexOfPriceLvlId)) {
          _tmpPriceLvlId = null;
        } else {
          _tmpPriceLvlId = _cursor.getInt(_cursorIndexOfPriceLvlId);
        }
        _item = new ChannelEntity(_tmpId,_tmpCode,_tmpName,_tmpActive,_tmpIsPos,_tmpCreatedBy,_tmpCreatedAt,_tmpUpdatedBy,_tmpUpdatedAt,_tmpColor,_tmpPriceLvlId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ChannelEntity> getActiveChannelList() {
    final String _sql = "SELECT * FROM channel WHERE ispos = 1 AND active = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(_cursor, "ispos");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
      final int _cursorIndexOfPriceLvlId = CursorUtil.getColumnIndexOrThrow(_cursor, "pricelvl_id");
      final List<ChannelEntity> _result = new ArrayList<ChannelEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ChannelEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
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
        final boolean _tmpActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp != 0;
        final boolean _tmpIsPos;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsPos);
        _tmpIsPos = _tmp_1 != 0;
        final Integer _tmpCreatedBy;
        if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
          _tmpCreatedBy = null;
        } else {
          _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        }
        final Date _tmpCreatedAt;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp_2);
        final Integer _tmpUpdatedBy;
        if (_cursor.isNull(_cursorIndexOfUpdatedBy)) {
          _tmpUpdatedBy = null;
        } else {
          _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        }
        final Date _tmpUpdatedAt;
        final Long _tmp_3;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getLong(_cursorIndexOfUpdatedAt);
        }
        _tmpUpdatedAt = __converters.longToDate(_tmp_3);
        final String _tmpColor;
        if (_cursor.isNull(_cursorIndexOfColor)) {
          _tmpColor = null;
        } else {
          _tmpColor = _cursor.getString(_cursorIndexOfColor);
        }
        final Integer _tmpPriceLvlId;
        if (_cursor.isNull(_cursorIndexOfPriceLvlId)) {
          _tmpPriceLvlId = null;
        } else {
          _tmpPriceLvlId = _cursor.getInt(_cursorIndexOfPriceLvlId);
        }
        _item = new ChannelEntity(_tmpId,_tmpCode,_tmpName,_tmpActive,_tmpIsPos,_tmpCreatedBy,_tmpCreatedAt,_tmpUpdatedBy,_tmpUpdatedAt,_tmpColor,_tmpPriceLvlId);
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
