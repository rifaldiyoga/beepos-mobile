package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.SelectionEntity;
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
public final class SelectionDao_Impl implements SelectionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SelectionEntity> __insertionAdapterOfSelectionEntity;

  private final EntityDeletionOrUpdateAdapter<SelectionEntity> __deletionAdapterOfSelectionEntity;

  private final EntityDeletionOrUpdateAdapter<SelectionEntity> __updateAdapterOfSelectionEntity;

  public SelectionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSelectionEntity = new EntityInsertionAdapter<SelectionEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `selection` (`id`,`code`,`name`,`note`,`isactive`,`ismultiselect`,`ismultiqty`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SelectionEntity value) {
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
        if (value.getNote() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNote());
        }
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        final int _tmp_1 = value.isMultiSelect() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        final int _tmp_2 = value.isMultiQty() ? 1 : 0;
        stmt.bindLong(7, _tmp_2);
      }
    };
    this.__deletionAdapterOfSelectionEntity = new EntityDeletionOrUpdateAdapter<SelectionEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `selection` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SelectionEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfSelectionEntity = new EntityDeletionOrUpdateAdapter<SelectionEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `selection` SET `id` = ?,`code` = ?,`name` = ?,`note` = ?,`isactive` = ?,`ismultiselect` = ?,`ismultiqty` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SelectionEntity value) {
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
        if (value.getNote() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNote());
        }
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        final int _tmp_1 = value.isMultiSelect() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        final int _tmp_2 = value.isMultiQty() ? 1 : 0;
        stmt.bindLong(7, _tmp_2);
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends SelectionEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final SelectionEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends SelectionEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSelectionEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final SelectionEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSelectionEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final SelectionEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSelectionEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<SelectionEntity> getSelectionList() {
    final String _sql = "SELECT * FROM selection";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isactive");
      final int _cursorIndexOfIsMultiSelect = CursorUtil.getColumnIndexOrThrow(_cursor, "ismultiselect");
      final int _cursorIndexOfIsMultiQty = CursorUtil.getColumnIndexOrThrow(_cursor, "ismultiqty");
      final List<SelectionEntity> _result = new ArrayList<SelectionEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SelectionEntity _item;
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
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        final boolean _tmpIsMultiSelect;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsMultiSelect);
        _tmpIsMultiSelect = _tmp_1 != 0;
        final boolean _tmpIsMultiQty;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsMultiQty);
        _tmpIsMultiQty = _tmp_2 != 0;
        _item = new SelectionEntity(_tmpId,_tmpCode,_tmpName,_tmpNote,_tmpIsActive,_tmpIsMultiSelect,_tmpIsMultiQty);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<SelectionEntity> getSelectionByItemid(final int itemId) {
    final String _sql = "SELECT DISTINCT(a.id), a.code, a.name, a.note, a.isactive, a.ismultiselect, a.ismultiqty FROM selection a JOIN addond b on b.selection_id = a.id JOIN itemaddon c ON c.addon = b.addon_id WHERE c.item_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, itemId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfCode = 1;
      final int _cursorIndexOfName = 2;
      final int _cursorIndexOfNote = 3;
      final int _cursorIndexOfIsActive = 4;
      final int _cursorIndexOfIsMultiSelect = 5;
      final int _cursorIndexOfIsMultiQty = 6;
      final List<SelectionEntity> _result = new ArrayList<SelectionEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SelectionEntity _item;
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
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        final boolean _tmpIsMultiSelect;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsMultiSelect);
        _tmpIsMultiSelect = _tmp_1 != 0;
        final boolean _tmpIsMultiQty;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsMultiQty);
        _tmpIsMultiQty = _tmp_2 != 0;
        _item = new SelectionEntity(_tmpId,_tmpCode,_tmpName,_tmpNote,_tmpIsActive,_tmpIsMultiSelect,_tmpIsMultiQty);
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
