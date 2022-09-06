package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.KitchenEntity;
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
public final class KitchenDao_Impl implements KitchenDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<KitchenEntity> __insertionAdapterOfKitchenEntity;

  private final EntityDeletionOrUpdateAdapter<KitchenEntity> __deletionAdapterOfKitchenEntity;

  private final EntityDeletionOrUpdateAdapter<KitchenEntity> __updateAdapterOfKitchenEntity;

  public KitchenDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKitchenEntity = new EntityInsertionAdapter<KitchenEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `kitchen` (`id`,`code`,`name`,`branch_id`,`created_by`,`created_at`,`updated_by`,`updated_at`,`is_used`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KitchenEntity value) {
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
        stmt.bindLong(4, value.getBranchId());
        stmt.bindLong(5, value.getCreatedBy());
        stmt.bindLong(6, value.getCreatedAt());
        stmt.bindLong(7, value.getUpdatedBy());
        stmt.bindLong(8, value.getUpdatedAt());
        final int _tmp = value.isUsed() ? 1 : 0;
        stmt.bindLong(9, _tmp);
      }
    };
    this.__deletionAdapterOfKitchenEntity = new EntityDeletionOrUpdateAdapter<KitchenEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `kitchen` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KitchenEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfKitchenEntity = new EntityDeletionOrUpdateAdapter<KitchenEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `kitchen` SET `id` = ?,`code` = ?,`name` = ?,`branch_id` = ?,`created_by` = ?,`created_at` = ?,`updated_by` = ?,`updated_at` = ?,`is_used` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KitchenEntity value) {
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
        stmt.bindLong(4, value.getBranchId());
        stmt.bindLong(5, value.getCreatedBy());
        stmt.bindLong(6, value.getCreatedAt());
        stmt.bindLong(7, value.getUpdatedBy());
        stmt.bindLong(8, value.getUpdatedAt());
        final int _tmp = value.isUsed() ? 1 : 0;
        stmt.bindLong(9, _tmp);
        stmt.bindLong(10, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends KitchenEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final KitchenEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends KitchenEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfKitchenEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final KitchenEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfKitchenEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final KitchenEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfKitchenEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public KitchenEntity getByKitchenId(final int id) {
    final String _sql = "SELECT * FROM kitchen WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfBranchId = CursorUtil.getColumnIndexOrThrow(_cursor, "branch_id");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfIsUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_used");
      final KitchenEntity _result;
      if(_cursor.moveToFirst()) {
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
        final int _tmpBranchId;
        _tmpBranchId = _cursor.getInt(_cursorIndexOfBranchId);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpUpdatedBy;
        _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        final boolean _tmpIsUsed;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsUsed);
        _tmpIsUsed = _tmp != 0;
        _result = new KitchenEntity(_tmpId,_tmpCode,_tmpName,_tmpBranchId,_tmpCreatedBy,_tmpCreatedAt,_tmpUpdatedBy,_tmpUpdatedAt,_tmpIsUsed);
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
  public KitchenEntity getLastKitchen() {
    final String _sql = "SELECT * FROM kitchen ORDER BY id DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfBranchId = CursorUtil.getColumnIndexOrThrow(_cursor, "branch_id");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfIsUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_used");
      final KitchenEntity _result;
      if(_cursor.moveToFirst()) {
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
        final int _tmpBranchId;
        _tmpBranchId = _cursor.getInt(_cursorIndexOfBranchId);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpUpdatedBy;
        _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        final boolean _tmpIsUsed;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsUsed);
        _tmpIsUsed = _tmp != 0;
        _result = new KitchenEntity(_tmpId,_tmpCode,_tmpName,_tmpBranchId,_tmpCreatedBy,_tmpCreatedAt,_tmpUpdatedBy,_tmpUpdatedAt,_tmpIsUsed);
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
  public List<KitchenEntity> read() {
    final String _sql = "SELECT * FROM  kitchen";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfBranchId = CursorUtil.getColumnIndexOrThrow(_cursor, "branch_id");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfIsUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_used");
      final List<KitchenEntity> _result = new ArrayList<KitchenEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final KitchenEntity _item;
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
        final int _tmpBranchId;
        _tmpBranchId = _cursor.getInt(_cursorIndexOfBranchId);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpUpdatedBy;
        _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        final boolean _tmpIsUsed;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsUsed);
        _tmpIsUsed = _tmp != 0;
        _item = new KitchenEntity(_tmpId,_tmpCode,_tmpName,_tmpBranchId,_tmpCreatedBy,_tmpCreatedAt,_tmpUpdatedBy,_tmpUpdatedAt,_tmpIsUsed);
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
