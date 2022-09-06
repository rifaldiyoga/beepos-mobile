package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.SelectionDEntity;
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
public final class SelectionDDao_Impl implements SelectionDDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SelectionDEntity> __insertionAdapterOfSelectionDEntity;

  private final EntityDeletionOrUpdateAdapter<SelectionDEntity> __deletionAdapterOfSelectionDEntity;

  private final EntityDeletionOrUpdateAdapter<SelectionDEntity> __updateAdapterOfSelectionDEntity;

  public SelectionDDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSelectionDEntity = new EntityInsertionAdapter<SelectionDEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `selectiond` (`id`,`selection_id`,`dno`,`item_id`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SelectionDEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getSelectionId());
        stmt.bindLong(3, value.getDno());
        stmt.bindLong(4, value.getItemId());
      }
    };
    this.__deletionAdapterOfSelectionDEntity = new EntityDeletionOrUpdateAdapter<SelectionDEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `selectiond` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SelectionDEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfSelectionDEntity = new EntityDeletionOrUpdateAdapter<SelectionDEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `selectiond` SET `id` = ?,`selection_id` = ?,`dno` = ?,`item_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SelectionDEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getSelectionId());
        stmt.bindLong(3, value.getDno());
        stmt.bindLong(4, value.getItemId());
        if (value.getId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends SelectionDEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final SelectionDEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends SelectionDEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSelectionDEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final SelectionDEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSelectionDEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final SelectionDEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSelectionDEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<SelectionDEntity> getSelectionDList() {
    final String _sql = "SELECT * FROM selectiond";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSelectionId = CursorUtil.getColumnIndexOrThrow(_cursor, "selection_id");
      final int _cursorIndexOfDno = CursorUtil.getColumnIndexOrThrow(_cursor, "dno");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final List<SelectionDEntity> _result = new ArrayList<SelectionDEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SelectionDEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final int _tmpSelectionId;
        _tmpSelectionId = _cursor.getInt(_cursorIndexOfSelectionId);
        final int _tmpDno;
        _tmpDno = _cursor.getInt(_cursorIndexOfDno);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _item = new SelectionDEntity(_tmpId,_tmpSelectionId,_tmpDno,_tmpItemId);
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
