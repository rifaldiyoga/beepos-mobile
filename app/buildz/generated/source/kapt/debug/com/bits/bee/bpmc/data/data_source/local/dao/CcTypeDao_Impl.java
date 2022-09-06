package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.CcTypeEntity;
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
public final class CcTypeDao_Impl implements CcTypeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CcTypeEntity> __insertionAdapterOfCcTypeEntity;

  private final EntityDeletionOrUpdateAdapter<CcTypeEntity> __deletionAdapterOfCcTypeEntity;

  private final EntityDeletionOrUpdateAdapter<CcTypeEntity> __updateAdapterOfCcTypeEntity;

  public CcTypeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCcTypeEntity = new EntityInsertionAdapter<CcTypeEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `cc_type` (`id`,`cctype`,`cctypedesc`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CcTypeEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getCctype() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCctype());
        }
        if (value.getCctypeDesc() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCctypeDesc());
        }
      }
    };
    this.__deletionAdapterOfCcTypeEntity = new EntityDeletionOrUpdateAdapter<CcTypeEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `cc_type` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CcTypeEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfCcTypeEntity = new EntityDeletionOrUpdateAdapter<CcTypeEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `cc_type` SET `id` = ?,`cctype` = ?,`cctypedesc` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CcTypeEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getCctype() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCctype());
        }
        if (value.getCctypeDesc() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCctypeDesc());
        }
        if (value.getId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends CcTypeEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final CcTypeEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends CcTypeEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCcTypeEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final CcTypeEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCcTypeEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final CcTypeEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCcTypeEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<CcTypeEntity> getCcTypeList() {
    final String _sql = "SELECT * FROM cc_type";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCctype = CursorUtil.getColumnIndexOrThrow(_cursor, "cctype");
      final int _cursorIndexOfCctypeDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "cctypedesc");
      final List<CcTypeEntity> _result = new ArrayList<CcTypeEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CcTypeEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpCctype;
        if (_cursor.isNull(_cursorIndexOfCctype)) {
          _tmpCctype = null;
        } else {
          _tmpCctype = _cursor.getString(_cursorIndexOfCctype);
        }
        final String _tmpCctypeDesc;
        if (_cursor.isNull(_cursorIndexOfCctypeDesc)) {
          _tmpCctypeDesc = null;
        } else {
          _tmpCctypeDesc = _cursor.getString(_cursorIndexOfCctypeDesc);
        }
        _item = new CcTypeEntity(_tmpId,_tmpCctype,_tmpCctypeDesc);
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
