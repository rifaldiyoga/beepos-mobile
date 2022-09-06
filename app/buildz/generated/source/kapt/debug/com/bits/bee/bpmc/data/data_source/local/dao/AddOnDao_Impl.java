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
import com.bits.bee.bpmc.data.data_source.local.model.AddOnEntity;
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
public final class AddOnDao_Impl implements AddOnDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AddOnEntity> __insertionAdapterOfAddOnEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<AddOnEntity> __deletionAdapterOfAddOnEntity;

  private final EntityDeletionOrUpdateAdapter<AddOnEntity> __updateAdapterOfAddOnEntity;

  public AddOnDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAddOnEntity = new EntityInsertionAdapter<AddOnEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `addon` (`id`,`code`,`name`,`is_active`,`created_at`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddOnEntity value) {
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
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        final Long _tmp_1 = __converters.dateToLong(value.getCreatedAt());
        if (_tmp_1 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp_1);
        }
      }
    };
    this.__deletionAdapterOfAddOnEntity = new EntityDeletionOrUpdateAdapter<AddOnEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `addon` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddOnEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfAddOnEntity = new EntityDeletionOrUpdateAdapter<AddOnEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `addon` SET `id` = ?,`code` = ?,`name` = ?,`is_active` = ?,`created_at` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddOnEntity value) {
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
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        final Long _tmp_1 = __converters.dateToLong(value.getCreatedAt());
        if (_tmp_1 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp_1);
        }
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends AddOnEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final AddOnEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends AddOnEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAddOnEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final AddOnEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAddOnEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final AddOnEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAddOnEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<AddOnEntity> getAddOnList() {
    final String _sql = "SELECT * FROM addon";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "is_active");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final List<AddOnEntity> _result = new ArrayList<AddOnEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AddOnEntity _item;
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
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        final Date _tmpCreatedAt;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp_1);
        _item = new AddOnEntity(_tmpId,_tmpCode,_tmpName,_tmpIsActive,_tmpCreatedAt);
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
