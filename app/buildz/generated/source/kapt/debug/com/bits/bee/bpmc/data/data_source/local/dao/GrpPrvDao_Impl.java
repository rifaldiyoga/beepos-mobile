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
import com.bits.bee.bpmc.data.data_source.local.model.GrpPrvEntity;
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
public final class GrpPrvDao_Impl implements GrpPrvDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GrpPrvEntity> __insertionAdapterOfGrpPrvEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<GrpPrvEntity> __deletionAdapterOfGrpPrvEntity;

  private final EntityDeletionOrUpdateAdapter<GrpPrvEntity> __updateAdapterOfGrpPrvEntity;

  public GrpPrvDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGrpPrvEntity = new EntityInsertionAdapter<GrpPrvEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `grpprv` (`id`,`updated_at`,`obj_code`,`acstype`,`enabled`,`acsval`,`grp_id`,`code`,`up_code`,`modul_code`,`name`,`mnemonic`,`level`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GrpPrvEntity value) {
        stmt.bindLong(1, value.getId());
        final Long _tmp = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, _tmp);
        }
        if (value.getObjCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getObjCode());
        }
        if (value.getAcsType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAcsType());
        }
        final int _tmp_1 = value.isEnable() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
        if (value.getAcsVal() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAcsVal());
        }
        stmt.bindLong(7, value.getGrpId());
        if (value.getCodeObj() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCodeObj());
        }
        if (value.getUpCode() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUpCode());
        }
        if (value.getModuleCode() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModuleCode());
        }
        if (value.getNameObj() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getNameObj());
        }
        if (value.getMnemonic() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMnemonic());
        }
        stmt.bindLong(13, value.getLevel());
      }
    };
    this.__deletionAdapterOfGrpPrvEntity = new EntityDeletionOrUpdateAdapter<GrpPrvEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `grpprv` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GrpPrvEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfGrpPrvEntity = new EntityDeletionOrUpdateAdapter<GrpPrvEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `grpprv` SET `id` = ?,`updated_at` = ?,`obj_code` = ?,`acstype` = ?,`enabled` = ?,`acsval` = ?,`grp_id` = ?,`code` = ?,`up_code` = ?,`modul_code` = ?,`name` = ?,`mnemonic` = ?,`level` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GrpPrvEntity value) {
        stmt.bindLong(1, value.getId());
        final Long _tmp = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, _tmp);
        }
        if (value.getObjCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getObjCode());
        }
        if (value.getAcsType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAcsType());
        }
        final int _tmp_1 = value.isEnable() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
        if (value.getAcsVal() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAcsVal());
        }
        stmt.bindLong(7, value.getGrpId());
        if (value.getCodeObj() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCodeObj());
        }
        if (value.getUpCode() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUpCode());
        }
        if (value.getModuleCode() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModuleCode());
        }
        if (value.getNameObj() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getNameObj());
        }
        if (value.getMnemonic() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMnemonic());
        }
        stmt.bindLong(13, value.getLevel());
        stmt.bindLong(14, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends GrpPrvEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final GrpPrvEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends GrpPrvEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfGrpPrvEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final GrpPrvEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfGrpPrvEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final GrpPrvEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfGrpPrvEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<GrpPrvEntity> getGrpPrvList() {
    final String _sql = "SELECT * FROM grpprv";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfObjCode = CursorUtil.getColumnIndexOrThrow(_cursor, "obj_code");
      final int _cursorIndexOfAcsType = CursorUtil.getColumnIndexOrThrow(_cursor, "acstype");
      final int _cursorIndexOfIsEnable = CursorUtil.getColumnIndexOrThrow(_cursor, "enabled");
      final int _cursorIndexOfAcsVal = CursorUtil.getColumnIndexOrThrow(_cursor, "acsval");
      final int _cursorIndexOfGrpId = CursorUtil.getColumnIndexOrThrow(_cursor, "grp_id");
      final int _cursorIndexOfCodeObj = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfUpCode = CursorUtil.getColumnIndexOrThrow(_cursor, "up_code");
      final int _cursorIndexOfModuleCode = CursorUtil.getColumnIndexOrThrow(_cursor, "modul_code");
      final int _cursorIndexOfNameObj = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfMnemonic = CursorUtil.getColumnIndexOrThrow(_cursor, "mnemonic");
      final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
      final List<GrpPrvEntity> _result = new ArrayList<GrpPrvEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final GrpPrvEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final Date _tmpUpdatedAt;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfUpdatedAt);
        }
        _tmpUpdatedAt = __converters.longToDate(_tmp);
        final String _tmpObjCode;
        if (_cursor.isNull(_cursorIndexOfObjCode)) {
          _tmpObjCode = null;
        } else {
          _tmpObjCode = _cursor.getString(_cursorIndexOfObjCode);
        }
        final String _tmpAcsType;
        if (_cursor.isNull(_cursorIndexOfAcsType)) {
          _tmpAcsType = null;
        } else {
          _tmpAcsType = _cursor.getString(_cursorIndexOfAcsType);
        }
        final boolean _tmpIsEnable;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsEnable);
        _tmpIsEnable = _tmp_1 != 0;
        final String _tmpAcsVal;
        if (_cursor.isNull(_cursorIndexOfAcsVal)) {
          _tmpAcsVal = null;
        } else {
          _tmpAcsVal = _cursor.getString(_cursorIndexOfAcsVal);
        }
        final int _tmpGrpId;
        _tmpGrpId = _cursor.getInt(_cursorIndexOfGrpId);
        final String _tmpCodeObj;
        if (_cursor.isNull(_cursorIndexOfCodeObj)) {
          _tmpCodeObj = null;
        } else {
          _tmpCodeObj = _cursor.getString(_cursorIndexOfCodeObj);
        }
        final String _tmpUpCode;
        if (_cursor.isNull(_cursorIndexOfUpCode)) {
          _tmpUpCode = null;
        } else {
          _tmpUpCode = _cursor.getString(_cursorIndexOfUpCode);
        }
        final String _tmpModuleCode;
        if (_cursor.isNull(_cursorIndexOfModuleCode)) {
          _tmpModuleCode = null;
        } else {
          _tmpModuleCode = _cursor.getString(_cursorIndexOfModuleCode);
        }
        final String _tmpNameObj;
        if (_cursor.isNull(_cursorIndexOfNameObj)) {
          _tmpNameObj = null;
        } else {
          _tmpNameObj = _cursor.getString(_cursorIndexOfNameObj);
        }
        final String _tmpMnemonic;
        if (_cursor.isNull(_cursorIndexOfMnemonic)) {
          _tmpMnemonic = null;
        } else {
          _tmpMnemonic = _cursor.getString(_cursorIndexOfMnemonic);
        }
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        _item = new GrpPrvEntity(_tmpId,_tmpUpdatedAt,_tmpObjCode,_tmpAcsType,_tmpIsEnable,_tmpAcsVal,_tmpGrpId,_tmpCodeObj,_tmpUpCode,_tmpModuleCode,_tmpNameObj,_tmpMnemonic,_tmpLevel);
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
