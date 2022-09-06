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
import com.bits.bee.bpmc.data.data_source.local.model.BranchEntity;
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
public final class BranchDao_Impl implements BranchDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BranchEntity> __insertionAdapterOfBranchEntity;

  private final EntityDeletionOrUpdateAdapter<BranchEntity> __deletionAdapterOfBranchEntity;

  private final EntityDeletionOrUpdateAdapter<BranchEntity> __updateAdapterOfBranchEntity;

  private final SharedSQLiteStatement __preparedStmtOfResetActive;

  public BranchDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBranchEntity = new EntityInsertionAdapter<BranchEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `branch` (`id`,`code`,`name`,`version`,`cmp_name`,`cmp_phone`,`active`,`cmp_address`,`cmp_fax`,`custdeft_id`,`created_at`,`created_by`,`updated_at`,`updated_by`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BranchEntity value) {
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
        stmt.bindLong(4, value.getVersion());
        if (value.getCmpName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCmpName());
        }
        if (value.getCmpPhone() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCmpPhone());
        }
        final int _tmp = value.getActive() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        if (value.getCmpAddress() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCmpAddress());
        }
        if (value.getCmpFax() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCmpFax());
        }
        if (value.getCustDeftId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getCustDeftId());
        }
        stmt.bindLong(11, value.getCreatedAt());
        stmt.bindLong(12, value.getCreatedBy());
        stmt.bindLong(13, value.getUpdatedAt());
        stmt.bindLong(14, value.getUpdatedBy());
      }
    };
    this.__deletionAdapterOfBranchEntity = new EntityDeletionOrUpdateAdapter<BranchEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `branch` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BranchEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfBranchEntity = new EntityDeletionOrUpdateAdapter<BranchEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `branch` SET `id` = ?,`code` = ?,`name` = ?,`version` = ?,`cmp_name` = ?,`cmp_phone` = ?,`active` = ?,`cmp_address` = ?,`cmp_fax` = ?,`custdeft_id` = ?,`created_at` = ?,`created_by` = ?,`updated_at` = ?,`updated_by` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BranchEntity value) {
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
        stmt.bindLong(4, value.getVersion());
        if (value.getCmpName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCmpName());
        }
        if (value.getCmpPhone() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCmpPhone());
        }
        final int _tmp = value.getActive() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        if (value.getCmpAddress() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCmpAddress());
        }
        if (value.getCmpFax() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCmpFax());
        }
        if (value.getCustDeftId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getCustDeftId());
        }
        stmt.bindLong(11, value.getCreatedAt());
        stmt.bindLong(12, value.getCreatedBy());
        stmt.bindLong(13, value.getUpdatedAt());
        stmt.bindLong(14, value.getUpdatedBy());
        stmt.bindLong(15, value.getId());
      }
    };
    this.__preparedStmtOfResetActive = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE branch SET active = 0";
        return _query;
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends BranchEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final BranchEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends BranchEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfBranchEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final BranchEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfBranchEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final BranchEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfBranchEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void resetActive() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfResetActive.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfResetActive.release(_stmt);
    }
  }

  @Override
  public List<BranchEntity> getBranchList() {
    final String _sql = "SELECT * FROM branch";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfVersion = CursorUtil.getColumnIndexOrThrow(_cursor, "version");
      final int _cursorIndexOfCmpName = CursorUtil.getColumnIndexOrThrow(_cursor, "cmp_name");
      final int _cursorIndexOfCmpPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "cmp_phone");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfCmpAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "cmp_address");
      final int _cursorIndexOfCmpFax = CursorUtil.getColumnIndexOrThrow(_cursor, "cmp_fax");
      final int _cursorIndexOfCustDeftId = CursorUtil.getColumnIndexOrThrow(_cursor, "custdeft_id");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final List<BranchEntity> _result = new ArrayList<BranchEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BranchEntity _item;
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
        final int _tmpVersion;
        _tmpVersion = _cursor.getInt(_cursorIndexOfVersion);
        final String _tmpCmpName;
        if (_cursor.isNull(_cursorIndexOfCmpName)) {
          _tmpCmpName = null;
        } else {
          _tmpCmpName = _cursor.getString(_cursorIndexOfCmpName);
        }
        final String _tmpCmpPhone;
        if (_cursor.isNull(_cursorIndexOfCmpPhone)) {
          _tmpCmpPhone = null;
        } else {
          _tmpCmpPhone = _cursor.getString(_cursorIndexOfCmpPhone);
        }
        final boolean _tmpActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp != 0;
        final String _tmpCmpAddress;
        if (_cursor.isNull(_cursorIndexOfCmpAddress)) {
          _tmpCmpAddress = null;
        } else {
          _tmpCmpAddress = _cursor.getString(_cursorIndexOfCmpAddress);
        }
        final String _tmpCmpFax;
        if (_cursor.isNull(_cursorIndexOfCmpFax)) {
          _tmpCmpFax = null;
        } else {
          _tmpCmpFax = _cursor.getString(_cursorIndexOfCmpFax);
        }
        final Integer _tmpCustDeftId;
        if (_cursor.isNull(_cursorIndexOfCustDeftId)) {
          _tmpCustDeftId = null;
        } else {
          _tmpCustDeftId = _cursor.getInt(_cursorIndexOfCustDeftId);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        final int _tmpUpdatedBy;
        _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        _item = new BranchEntity(_tmpId,_tmpCode,_tmpName,_tmpVersion,_tmpCmpName,_tmpCmpPhone,_tmpActive,_tmpCmpAddress,_tmpCmpFax,_tmpCustDeftId,_tmpCreatedAt,_tmpCreatedBy,_tmpUpdatedAt,_tmpUpdatedBy);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public BranchEntity getActiveBranch() {
    final String _sql = "SELECT * FROM branch WHERE active = 1 LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfVersion = CursorUtil.getColumnIndexOrThrow(_cursor, "version");
      final int _cursorIndexOfCmpName = CursorUtil.getColumnIndexOrThrow(_cursor, "cmp_name");
      final int _cursorIndexOfCmpPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "cmp_phone");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfCmpAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "cmp_address");
      final int _cursorIndexOfCmpFax = CursorUtil.getColumnIndexOrThrow(_cursor, "cmp_fax");
      final int _cursorIndexOfCustDeftId = CursorUtil.getColumnIndexOrThrow(_cursor, "custdeft_id");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final BranchEntity _result;
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
        final int _tmpVersion;
        _tmpVersion = _cursor.getInt(_cursorIndexOfVersion);
        final String _tmpCmpName;
        if (_cursor.isNull(_cursorIndexOfCmpName)) {
          _tmpCmpName = null;
        } else {
          _tmpCmpName = _cursor.getString(_cursorIndexOfCmpName);
        }
        final String _tmpCmpPhone;
        if (_cursor.isNull(_cursorIndexOfCmpPhone)) {
          _tmpCmpPhone = null;
        } else {
          _tmpCmpPhone = _cursor.getString(_cursorIndexOfCmpPhone);
        }
        final boolean _tmpActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp != 0;
        final String _tmpCmpAddress;
        if (_cursor.isNull(_cursorIndexOfCmpAddress)) {
          _tmpCmpAddress = null;
        } else {
          _tmpCmpAddress = _cursor.getString(_cursorIndexOfCmpAddress);
        }
        final String _tmpCmpFax;
        if (_cursor.isNull(_cursorIndexOfCmpFax)) {
          _tmpCmpFax = null;
        } else {
          _tmpCmpFax = _cursor.getString(_cursorIndexOfCmpFax);
        }
        final Integer _tmpCustDeftId;
        if (_cursor.isNull(_cursorIndexOfCustDeftId)) {
          _tmpCustDeftId = null;
        } else {
          _tmpCustDeftId = _cursor.getInt(_cursorIndexOfCustDeftId);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        final int _tmpUpdatedBy;
        _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        _result = new BranchEntity(_tmpId,_tmpCode,_tmpName,_tmpVersion,_tmpCmpName,_tmpCmpPhone,_tmpActive,_tmpCmpAddress,_tmpCmpFax,_tmpCustDeftId,_tmpCreatedAt,_tmpCreatedBy,_tmpUpdatedAt,_tmpUpdatedBy);
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
  public BranchEntity getBranchById(final int branchId) {
    final String _sql = "SELECT * FROM branch WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, branchId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfVersion = CursorUtil.getColumnIndexOrThrow(_cursor, "version");
      final int _cursorIndexOfCmpName = CursorUtil.getColumnIndexOrThrow(_cursor, "cmp_name");
      final int _cursorIndexOfCmpPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "cmp_phone");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfCmpAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "cmp_address");
      final int _cursorIndexOfCmpFax = CursorUtil.getColumnIndexOrThrow(_cursor, "cmp_fax");
      final int _cursorIndexOfCustDeftId = CursorUtil.getColumnIndexOrThrow(_cursor, "custdeft_id");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final BranchEntity _result;
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
        final int _tmpVersion;
        _tmpVersion = _cursor.getInt(_cursorIndexOfVersion);
        final String _tmpCmpName;
        if (_cursor.isNull(_cursorIndexOfCmpName)) {
          _tmpCmpName = null;
        } else {
          _tmpCmpName = _cursor.getString(_cursorIndexOfCmpName);
        }
        final String _tmpCmpPhone;
        if (_cursor.isNull(_cursorIndexOfCmpPhone)) {
          _tmpCmpPhone = null;
        } else {
          _tmpCmpPhone = _cursor.getString(_cursorIndexOfCmpPhone);
        }
        final boolean _tmpActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp != 0;
        final String _tmpCmpAddress;
        if (_cursor.isNull(_cursorIndexOfCmpAddress)) {
          _tmpCmpAddress = null;
        } else {
          _tmpCmpAddress = _cursor.getString(_cursorIndexOfCmpAddress);
        }
        final String _tmpCmpFax;
        if (_cursor.isNull(_cursorIndexOfCmpFax)) {
          _tmpCmpFax = null;
        } else {
          _tmpCmpFax = _cursor.getString(_cursorIndexOfCmpFax);
        }
        final Integer _tmpCustDeftId;
        if (_cursor.isNull(_cursorIndexOfCustDeftId)) {
          _tmpCustDeftId = null;
        } else {
          _tmpCustDeftId = _cursor.getInt(_cursorIndexOfCustDeftId);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        final int _tmpUpdatedBy;
        _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        _result = new BranchEntity(_tmpId,_tmpCode,_tmpName,_tmpVersion,_tmpCmpName,_tmpCmpPhone,_tmpActive,_tmpCmpAddress,_tmpCmpFax,_tmpCustDeftId,_tmpCreatedAt,_tmpCreatedBy,_tmpUpdatedAt,_tmpUpdatedBy);
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
