package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.AddOnDEntity;
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
public final class AddOnDDao_Impl implements AddOnDDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AddOnDEntity> __insertionAdapterOfAddOnDEntity;

  private final EntityDeletionOrUpdateAdapter<AddOnDEntity> __deletionAdapterOfAddOnDEntity;

  private final EntityDeletionOrUpdateAdapter<AddOnDEntity> __updateAdapterOfAddOnDEntity;

  public AddOnDDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAddOnDEntity = new EntityInsertionAdapter<AddOnDEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `addond` (`id`,`addon_id`,`selection_id`,`idx`,`addond`,`isskip`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddOnDEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getAddOnId());
        stmt.bindLong(3, value.getSelectionId());
        stmt.bindLong(4, value.getIdx());
        stmt.bindLong(5, value.getUpIdx());
        final int _tmp = value.isSkip() ? 1 : 0;
        stmt.bindLong(6, _tmp);
      }
    };
    this.__deletionAdapterOfAddOnDEntity = new EntityDeletionOrUpdateAdapter<AddOnDEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `addond` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddOnDEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfAddOnDEntity = new EntityDeletionOrUpdateAdapter<AddOnDEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `addond` SET `id` = ?,`addon_id` = ?,`selection_id` = ?,`idx` = ?,`addond` = ?,`isskip` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddOnDEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getAddOnId());
        stmt.bindLong(3, value.getSelectionId());
        stmt.bindLong(4, value.getIdx());
        stmt.bindLong(5, value.getUpIdx());
        final int _tmp = value.isSkip() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        if (value.getId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends AddOnDEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final AddOnDEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends AddOnDEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAddOnDEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final AddOnDEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAddOnDEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final AddOnDEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAddOnDEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<AddOnDEntity> getAddOnDList() {
    final String _sql = "SELECT * FROM addond";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfAddOnId = CursorUtil.getColumnIndexOrThrow(_cursor, "addon_id");
      final int _cursorIndexOfSelectionId = CursorUtil.getColumnIndexOrThrow(_cursor, "selection_id");
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final int _cursorIndexOfUpIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "addond");
      final int _cursorIndexOfIsSkip = CursorUtil.getColumnIndexOrThrow(_cursor, "isskip");
      final List<AddOnDEntity> _result = new ArrayList<AddOnDEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AddOnDEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final int _tmpAddOnId;
        _tmpAddOnId = _cursor.getInt(_cursorIndexOfAddOnId);
        final int _tmpSelectionId;
        _tmpSelectionId = _cursor.getInt(_cursorIndexOfSelectionId);
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        final int _tmpUpIdx;
        _tmpUpIdx = _cursor.getInt(_cursorIndexOfUpIdx);
        final boolean _tmpIsSkip;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSkip);
        _tmpIsSkip = _tmp != 0;
        _item = new AddOnDEntity(_tmpId,_tmpAddOnId,_tmpSelectionId,_tmpIdx,_tmpUpIdx,_tmpIsSkip);
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
