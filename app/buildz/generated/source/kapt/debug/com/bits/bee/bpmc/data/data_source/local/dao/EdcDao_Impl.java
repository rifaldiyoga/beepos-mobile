package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.EdcEntity;
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
public final class EdcDao_Impl implements EdcDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EdcEntity> __insertionAdapterOfEdcEntity;

  private final EntityDeletionOrUpdateAdapter<EdcEntity> __deletionAdapterOfEdcEntity;

  private final EntityDeletionOrUpdateAdapter<EdcEntity> __updateAdapterOfEdcEntity;

  public EdcDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEdcEntity = new EntityInsertionAdapter<EdcEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `edc` (`id`,`code`,`name`,`cash_id`,`note`,`surcpayto`,`branch_id`,`active`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EdcEntity value) {
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
        stmt.bindLong(4, value.getCash());
        if (value.getNote() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNote());
        }
        if (value.getSurcPayTo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSurcPayTo());
        }
        if (value.getBranchId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getBranchId());
        }
        final int _tmp = value.getActive() ? 1 : 0;
        stmt.bindLong(8, _tmp);
      }
    };
    this.__deletionAdapterOfEdcEntity = new EntityDeletionOrUpdateAdapter<EdcEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `edc` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EdcEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfEdcEntity = new EntityDeletionOrUpdateAdapter<EdcEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `edc` SET `id` = ?,`code` = ?,`name` = ?,`cash_id` = ?,`note` = ?,`surcpayto` = ?,`branch_id` = ?,`active` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EdcEntity value) {
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
        stmt.bindLong(4, value.getCash());
        if (value.getNote() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNote());
        }
        if (value.getSurcPayTo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSurcPayTo());
        }
        if (value.getBranchId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getBranchId());
        }
        final int _tmp = value.getActive() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        stmt.bindLong(9, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends EdcEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final EdcEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends EdcEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEdcEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final EdcEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEdcEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EdcEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEdcEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<EdcEntity> getEdcList() {
    final String _sql = "SELECT * FROM edc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfCash = CursorUtil.getColumnIndexOrThrow(_cursor, "cash_id");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfSurcPayTo = CursorUtil.getColumnIndexOrThrow(_cursor, "surcpayto");
      final int _cursorIndexOfBranchId = CursorUtil.getColumnIndexOrThrow(_cursor, "branch_id");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final List<EdcEntity> _result = new ArrayList<EdcEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EdcEntity _item;
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
        final int _tmpCash;
        _tmpCash = _cursor.getInt(_cursorIndexOfCash);
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final String _tmpSurcPayTo;
        if (_cursor.isNull(_cursorIndexOfSurcPayTo)) {
          _tmpSurcPayTo = null;
        } else {
          _tmpSurcPayTo = _cursor.getString(_cursorIndexOfSurcPayTo);
        }
        final Integer _tmpBranchId;
        if (_cursor.isNull(_cursorIndexOfBranchId)) {
          _tmpBranchId = null;
        } else {
          _tmpBranchId = _cursor.getInt(_cursorIndexOfBranchId);
        }
        final boolean _tmpActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp != 0;
        _item = new EdcEntity(_tmpId,_tmpCode,_tmpName,_tmpCash,_tmpNote,_tmpSurcPayTo,_tmpBranchId,_tmpActive);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<EdcEntity> getActiveEdc(final int branchId) {
    final String _sql = "SELECT * FROM edc WHERE active = 1 AND (branch_id = ? OR branch_id IS NULL)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, branchId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfCash = CursorUtil.getColumnIndexOrThrow(_cursor, "cash_id");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfSurcPayTo = CursorUtil.getColumnIndexOrThrow(_cursor, "surcpayto");
      final int _cursorIndexOfBranchId = CursorUtil.getColumnIndexOrThrow(_cursor, "branch_id");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final List<EdcEntity> _result = new ArrayList<EdcEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EdcEntity _item;
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
        final int _tmpCash;
        _tmpCash = _cursor.getInt(_cursorIndexOfCash);
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final String _tmpSurcPayTo;
        if (_cursor.isNull(_cursorIndexOfSurcPayTo)) {
          _tmpSurcPayTo = null;
        } else {
          _tmpSurcPayTo = _cursor.getString(_cursorIndexOfSurcPayTo);
        }
        final Integer _tmpBranchId;
        if (_cursor.isNull(_cursorIndexOfBranchId)) {
          _tmpBranchId = null;
        } else {
          _tmpBranchId = _cursor.getInt(_cursorIndexOfBranchId);
        }
        final boolean _tmpActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp != 0;
        _item = new EdcEntity(_tmpId,_tmpCode,_tmpName,_tmpCash,_tmpNote,_tmpSurcPayTo,_tmpBranchId,_tmpActive);
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
