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
import com.bits.bee.bpmc.data.data_source.local.model.CmpEntity;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CmpDao_Impl implements CmpDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CmpEntity> __insertionAdapterOfCmpEntity;

  private final EntityDeletionOrUpdateAdapter<CmpEntity> __deletionAdapterOfCmpEntity;

  private final EntityDeletionOrUpdateAdapter<CmpEntity> __updateAdapterOfCmpEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public CmpDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCmpEntity = new EntityInsertionAdapter<CmpEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `cmp` (`id`,`city_code`,`crc_id`,`name`,`address`,`phone`,`fax`,`zipcode`,`startdate`,`fiscalyear`,`ownername`,`ownertaxregno`,`formserno`,`taxregno`,`vatregno`,`cosstype`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CmpEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getCityCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCityCode());
        }
        stmt.bindLong(3, value.getCrcId());
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAddress());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPhone());
        }
        if (value.getFax() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getFax());
        }
        if (value.getZipCode() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getZipCode());
        }
        if (value.getStartDate() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStartDate());
        }
        if (value.getFiscalYear() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getFiscalYear());
        }
        if (value.getOwnerName() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getOwnerName());
        }
        if (value.getOwnerTaxRegNo() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getOwnerTaxRegNo());
        }
        if (value.getFormSerno() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getFormSerno());
        }
        if (value.getTaxRegNo() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTaxRegNo());
        }
        if (value.getVatRegNo() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getVatRegNo());
        }
        if (value.getCossType() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getCossType());
        }
      }
    };
    this.__deletionAdapterOfCmpEntity = new EntityDeletionOrUpdateAdapter<CmpEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `cmp` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CmpEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfCmpEntity = new EntityDeletionOrUpdateAdapter<CmpEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `cmp` SET `id` = ?,`city_code` = ?,`crc_id` = ?,`name` = ?,`address` = ?,`phone` = ?,`fax` = ?,`zipcode` = ?,`startdate` = ?,`fiscalyear` = ?,`ownername` = ?,`ownertaxregno` = ?,`formserno` = ?,`taxregno` = ?,`vatregno` = ?,`cosstype` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CmpEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getCityCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCityCode());
        }
        stmt.bindLong(3, value.getCrcId());
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAddress());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPhone());
        }
        if (value.getFax() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getFax());
        }
        if (value.getZipCode() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getZipCode());
        }
        if (value.getStartDate() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStartDate());
        }
        if (value.getFiscalYear() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getFiscalYear());
        }
        if (value.getOwnerName() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getOwnerName());
        }
        if (value.getOwnerTaxRegNo() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getOwnerTaxRegNo());
        }
        if (value.getFormSerno() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getFormSerno());
        }
        if (value.getTaxRegNo() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTaxRegNo());
        }
        if (value.getVatRegNo() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getVatRegNo());
        }
        if (value.getCossType() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getCossType());
        }
        if (value.getId() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM cmp";
        return _query;
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends CmpEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final CmpEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends CmpEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCmpEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final CmpEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCmpEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final CmpEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCmpEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public CmpEntity getCmp() {
    final String _sql = "SELECT * FROM cmp";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCityCode = CursorUtil.getColumnIndexOrThrow(_cursor, "city_code");
      final int _cursorIndexOfCrcId = CursorUtil.getColumnIndexOrThrow(_cursor, "crc_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfFax = CursorUtil.getColumnIndexOrThrow(_cursor, "fax");
      final int _cursorIndexOfZipCode = CursorUtil.getColumnIndexOrThrow(_cursor, "zipcode");
      final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "startdate");
      final int _cursorIndexOfFiscalYear = CursorUtil.getColumnIndexOrThrow(_cursor, "fiscalyear");
      final int _cursorIndexOfOwnerName = CursorUtil.getColumnIndexOrThrow(_cursor, "ownername");
      final int _cursorIndexOfOwnerTaxRegNo = CursorUtil.getColumnIndexOrThrow(_cursor, "ownertaxregno");
      final int _cursorIndexOfFormSerno = CursorUtil.getColumnIndexOrThrow(_cursor, "formserno");
      final int _cursorIndexOfTaxRegNo = CursorUtil.getColumnIndexOrThrow(_cursor, "taxregno");
      final int _cursorIndexOfVatRegNo = CursorUtil.getColumnIndexOrThrow(_cursor, "vatregno");
      final int _cursorIndexOfCossType = CursorUtil.getColumnIndexOrThrow(_cursor, "cosstype");
      final CmpEntity _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpCityCode;
        if (_cursor.isNull(_cursorIndexOfCityCode)) {
          _tmpCityCode = null;
        } else {
          _tmpCityCode = _cursor.getString(_cursorIndexOfCityCode);
        }
        final int _tmpCrcId;
        _tmpCrcId = _cursor.getInt(_cursorIndexOfCrcId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        final String _tmpFax;
        if (_cursor.isNull(_cursorIndexOfFax)) {
          _tmpFax = null;
        } else {
          _tmpFax = _cursor.getString(_cursorIndexOfFax);
        }
        final String _tmpZipCode;
        if (_cursor.isNull(_cursorIndexOfZipCode)) {
          _tmpZipCode = null;
        } else {
          _tmpZipCode = _cursor.getString(_cursorIndexOfZipCode);
        }
        final String _tmpStartDate;
        if (_cursor.isNull(_cursorIndexOfStartDate)) {
          _tmpStartDate = null;
        } else {
          _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
        }
        final String _tmpFiscalYear;
        if (_cursor.isNull(_cursorIndexOfFiscalYear)) {
          _tmpFiscalYear = null;
        } else {
          _tmpFiscalYear = _cursor.getString(_cursorIndexOfFiscalYear);
        }
        final String _tmpOwnerName;
        if (_cursor.isNull(_cursorIndexOfOwnerName)) {
          _tmpOwnerName = null;
        } else {
          _tmpOwnerName = _cursor.getString(_cursorIndexOfOwnerName);
        }
        final String _tmpOwnerTaxRegNo;
        if (_cursor.isNull(_cursorIndexOfOwnerTaxRegNo)) {
          _tmpOwnerTaxRegNo = null;
        } else {
          _tmpOwnerTaxRegNo = _cursor.getString(_cursorIndexOfOwnerTaxRegNo);
        }
        final String _tmpFormSerno;
        if (_cursor.isNull(_cursorIndexOfFormSerno)) {
          _tmpFormSerno = null;
        } else {
          _tmpFormSerno = _cursor.getString(_cursorIndexOfFormSerno);
        }
        final String _tmpTaxRegNo;
        if (_cursor.isNull(_cursorIndexOfTaxRegNo)) {
          _tmpTaxRegNo = null;
        } else {
          _tmpTaxRegNo = _cursor.getString(_cursorIndexOfTaxRegNo);
        }
        final String _tmpVatRegNo;
        if (_cursor.isNull(_cursorIndexOfVatRegNo)) {
          _tmpVatRegNo = null;
        } else {
          _tmpVatRegNo = _cursor.getString(_cursorIndexOfVatRegNo);
        }
        final String _tmpCossType;
        if (_cursor.isNull(_cursorIndexOfCossType)) {
          _tmpCossType = null;
        } else {
          _tmpCossType = _cursor.getString(_cursorIndexOfCossType);
        }
        _result = new CmpEntity(_tmpId,_tmpCityCode,_tmpCrcId,_tmpName,_tmpAddress,_tmpPhone,_tmpFax,_tmpZipCode,_tmpStartDate,_tmpFiscalYear,_tmpOwnerName,_tmpOwnerTaxRegNo,_tmpFormSerno,_tmpTaxRegNo,_tmpVatRegNo,_tmpCossType);
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
