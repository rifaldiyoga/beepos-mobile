package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.VariantEntity;
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
public final class VariantDao_Impl implements VariantDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<VariantEntity> __insertionAdapterOfVariantEntity;

  private final EntityDeletionOrUpdateAdapter<VariantEntity> __deletionAdapterOfVariantEntity;

  private final EntityDeletionOrUpdateAdapter<VariantEntity> __updateAdapterOfVariantEntity;

  public VariantDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVariantEntity = new EntityInsertionAdapter<VariantEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `variant` (`id`,`code`,`name`,`itgrp_id`,`picpath`,`isfavorit`,`isavailable`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, VariantEntity value) {
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
        stmt.bindLong(4, value.getItgrpId());
        if (value.getPicPath() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPicPath());
        }
        final int _tmp = value.isFavorit() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        final int _tmp_1 = value.isAvailable() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
      }
    };
    this.__deletionAdapterOfVariantEntity = new EntityDeletionOrUpdateAdapter<VariantEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `variant` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, VariantEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfVariantEntity = new EntityDeletionOrUpdateAdapter<VariantEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `variant` SET `id` = ?,`code` = ?,`name` = ?,`itgrp_id` = ?,`picpath` = ?,`isfavorit` = ?,`isavailable` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, VariantEntity value) {
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
        stmt.bindLong(4, value.getItgrpId());
        if (value.getPicPath() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPicPath());
        }
        final int _tmp = value.isFavorit() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        final int _tmp_1 = value.isAvailable() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends VariantEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final VariantEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends VariantEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfVariantEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final VariantEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfVariantEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final VariantEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfVariantEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<VariantEntity> getVariantList() {
    final String _sql = "SELECT * FROM variant";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfItgrpId = CursorUtil.getColumnIndexOrThrow(_cursor, "itgrp_id");
      final int _cursorIndexOfPicPath = CursorUtil.getColumnIndexOrThrow(_cursor, "picpath");
      final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(_cursor, "isfavorit");
      final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "isavailable");
      final List<VariantEntity> _result = new ArrayList<VariantEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final VariantEntity _item;
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
        final int _tmpItgrpId;
        _tmpItgrpId = _cursor.getInt(_cursorIndexOfItgrpId);
        final String _tmpPicPath;
        if (_cursor.isNull(_cursorIndexOfPicPath)) {
          _tmpPicPath = null;
        } else {
          _tmpPicPath = _cursor.getString(_cursorIndexOfPicPath);
        }
        final boolean _tmpIsFavorit;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorit);
        _tmpIsFavorit = _tmp != 0;
        final boolean _tmpIsAvailable;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsAvailable);
        _tmpIsAvailable = _tmp_1 != 0;
        _item = new VariantEntity(_tmpId,_tmpCode,_tmpName,_tmpItgrpId,_tmpPicPath,_tmpIsFavorit,_tmpIsAvailable);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public VariantEntity getVariantById(final int id) {
    final String _sql = "SELECT * FROM variant WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfItgrpId = CursorUtil.getColumnIndexOrThrow(_cursor, "itgrp_id");
      final int _cursorIndexOfPicPath = CursorUtil.getColumnIndexOrThrow(_cursor, "picpath");
      final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(_cursor, "isfavorit");
      final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "isavailable");
      final VariantEntity _result;
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
        final int _tmpItgrpId;
        _tmpItgrpId = _cursor.getInt(_cursorIndexOfItgrpId);
        final String _tmpPicPath;
        if (_cursor.isNull(_cursorIndexOfPicPath)) {
          _tmpPicPath = null;
        } else {
          _tmpPicPath = _cursor.getString(_cursorIndexOfPicPath);
        }
        final boolean _tmpIsFavorit;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorit);
        _tmpIsFavorit = _tmp != 0;
        final boolean _tmpIsAvailable;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsAvailable);
        _tmpIsAvailable = _tmp_1 != 0;
        _result = new VariantEntity(_tmpId,_tmpCode,_tmpName,_tmpItgrpId,_tmpPicPath,_tmpIsFavorit,_tmpIsAvailable);
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
