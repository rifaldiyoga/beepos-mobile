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
import com.bits.bee.bpmc.data.data_source.local.model.BpAddrEntity;
import java.lang.Class;
import java.lang.Integer;
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
public final class BpAddrDao_Impl implements BpAddrDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BpAddrEntity> __insertionAdapterOfBpAddrEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<BpAddrEntity> __deletionAdapterOfBpAddrEntity;

  private final EntityDeletionOrUpdateAdapter<BpAddrEntity> __updateAdapterOfBpAddrEntity;

  public BpAddrDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBpAddrEntity = new EntityInsertionAdapter<BpAddrEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `bpaddr` (`id`,`bp_id`,`name`,`greeting`,`address`,`phone`,`zipcode`,`email`,`note`,`isbilladdr`,`isshipaddr`,`ismainaddr`,`province_code`,`regency_code`,`city_code`,`district_code`,`created_at`,`created_by`,`updated_at`,`updated_by`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BpAddrEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getBpId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getBpId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getGreeting() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGreeting());
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
        if (value.getZipCode() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getZipCode());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getEmail());
        }
        if (value.getNote() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getNote());
        }
        final int _tmp = value.isBillAddr() ? 1 : 0;
        stmt.bindLong(10, _tmp);
        final int _tmp_1 = value.isShipAddr() ? 1 : 0;
        stmt.bindLong(11, _tmp_1);
        final int _tmp_2 = value.isMainAddr() ? 1 : 0;
        stmt.bindLong(12, _tmp_2);
        if (value.getProvinceCode() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getProvinceCode());
        }
        if (value.getRegencyCode() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getRegencyCode());
        }
        stmt.bindLong(15, value.getCityId());
        if (value.getDistrictCode() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getDistrictCode());
        }
        final Long _tmp_3 = __converters.dateToLong(value.getCreatedAt());
        if (_tmp_3 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, _tmp_3);
        }
        if (value.getCreatedBy() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindLong(18, value.getCreatedBy());
        }
        final Long _tmp_4 = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp_4 == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, _tmp_4);
        }
        if (value.getUpdatedBy() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindLong(20, value.getUpdatedBy());
        }
      }
    };
    this.__deletionAdapterOfBpAddrEntity = new EntityDeletionOrUpdateAdapter<BpAddrEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `bpaddr` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BpAddrEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfBpAddrEntity = new EntityDeletionOrUpdateAdapter<BpAddrEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `bpaddr` SET `id` = ?,`bp_id` = ?,`name` = ?,`greeting` = ?,`address` = ?,`phone` = ?,`zipcode` = ?,`email` = ?,`note` = ?,`isbilladdr` = ?,`isshipaddr` = ?,`ismainaddr` = ?,`province_code` = ?,`regency_code` = ?,`city_code` = ?,`district_code` = ?,`created_at` = ?,`created_by` = ?,`updated_at` = ?,`updated_by` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BpAddrEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getBpId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getBpId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getGreeting() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGreeting());
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
        if (value.getZipCode() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getZipCode());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getEmail());
        }
        if (value.getNote() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getNote());
        }
        final int _tmp = value.isBillAddr() ? 1 : 0;
        stmt.bindLong(10, _tmp);
        final int _tmp_1 = value.isShipAddr() ? 1 : 0;
        stmt.bindLong(11, _tmp_1);
        final int _tmp_2 = value.isMainAddr() ? 1 : 0;
        stmt.bindLong(12, _tmp_2);
        if (value.getProvinceCode() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getProvinceCode());
        }
        if (value.getRegencyCode() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getRegencyCode());
        }
        stmt.bindLong(15, value.getCityId());
        if (value.getDistrictCode() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getDistrictCode());
        }
        final Long _tmp_3 = __converters.dateToLong(value.getCreatedAt());
        if (_tmp_3 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, _tmp_3);
        }
        if (value.getCreatedBy() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindLong(18, value.getCreatedBy());
        }
        final Long _tmp_4 = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp_4 == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, _tmp_4);
        }
        if (value.getUpdatedBy() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindLong(20, value.getUpdatedBy());
        }
        if (value.getId() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindLong(21, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends BpAddrEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final BpAddrEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends BpAddrEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfBpAddrEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final BpAddrEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfBpAddrEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final BpAddrEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfBpAddrEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<BpAddrEntity> getBpAddrList() {
    final String _sql = "SELECT * FROM bpaddr";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfBpId = CursorUtil.getColumnIndexOrThrow(_cursor, "bp_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGreeting = CursorUtil.getColumnIndexOrThrow(_cursor, "greeting");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfZipCode = CursorUtil.getColumnIndexOrThrow(_cursor, "zipcode");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfIsBillAddr = CursorUtil.getColumnIndexOrThrow(_cursor, "isbilladdr");
      final int _cursorIndexOfIsShipAddr = CursorUtil.getColumnIndexOrThrow(_cursor, "isshipaddr");
      final int _cursorIndexOfIsMainAddr = CursorUtil.getColumnIndexOrThrow(_cursor, "ismainaddr");
      final int _cursorIndexOfProvinceCode = CursorUtil.getColumnIndexOrThrow(_cursor, "province_code");
      final int _cursorIndexOfRegencyCode = CursorUtil.getColumnIndexOrThrow(_cursor, "regency_code");
      final int _cursorIndexOfCityId = CursorUtil.getColumnIndexOrThrow(_cursor, "city_code");
      final int _cursorIndexOfDistrictCode = CursorUtil.getColumnIndexOrThrow(_cursor, "district_code");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final List<BpAddrEntity> _result = new ArrayList<BpAddrEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BpAddrEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final Integer _tmpBpId;
        if (_cursor.isNull(_cursorIndexOfBpId)) {
          _tmpBpId = null;
        } else {
          _tmpBpId = _cursor.getInt(_cursorIndexOfBpId);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpGreeting;
        if (_cursor.isNull(_cursorIndexOfGreeting)) {
          _tmpGreeting = null;
        } else {
          _tmpGreeting = _cursor.getString(_cursorIndexOfGreeting);
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
        final String _tmpZipCode;
        if (_cursor.isNull(_cursorIndexOfZipCode)) {
          _tmpZipCode = null;
        } else {
          _tmpZipCode = _cursor.getString(_cursorIndexOfZipCode);
        }
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final boolean _tmpIsBillAddr;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsBillAddr);
        _tmpIsBillAddr = _tmp != 0;
        final boolean _tmpIsShipAddr;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsShipAddr);
        _tmpIsShipAddr = _tmp_1 != 0;
        final boolean _tmpIsMainAddr;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsMainAddr);
        _tmpIsMainAddr = _tmp_2 != 0;
        final String _tmpProvinceCode;
        if (_cursor.isNull(_cursorIndexOfProvinceCode)) {
          _tmpProvinceCode = null;
        } else {
          _tmpProvinceCode = _cursor.getString(_cursorIndexOfProvinceCode);
        }
        final String _tmpRegencyCode;
        if (_cursor.isNull(_cursorIndexOfRegencyCode)) {
          _tmpRegencyCode = null;
        } else {
          _tmpRegencyCode = _cursor.getString(_cursorIndexOfRegencyCode);
        }
        final int _tmpCityId;
        _tmpCityId = _cursor.getInt(_cursorIndexOfCityId);
        final String _tmpDistrictCode;
        if (_cursor.isNull(_cursorIndexOfDistrictCode)) {
          _tmpDistrictCode = null;
        } else {
          _tmpDistrictCode = _cursor.getString(_cursorIndexOfDistrictCode);
        }
        final Date _tmpCreatedAt;
        final Long _tmp_3;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp_3);
        final Integer _tmpCreatedBy;
        if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
          _tmpCreatedBy = null;
        } else {
          _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        }
        final Date _tmpUpdatedAt;
        final Long _tmp_4;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getLong(_cursorIndexOfUpdatedAt);
        }
        _tmpUpdatedAt = __converters.longToDate(_tmp_4);
        final Integer _tmpUpdatedBy;
        if (_cursor.isNull(_cursorIndexOfUpdatedBy)) {
          _tmpUpdatedBy = null;
        } else {
          _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        }
        _item = new BpAddrEntity(_tmpId,_tmpBpId,_tmpName,_tmpGreeting,_tmpAddress,_tmpPhone,_tmpZipCode,_tmpEmail,_tmpNote,_tmpIsBillAddr,_tmpIsShipAddr,_tmpIsMainAddr,_tmpProvinceCode,_tmpRegencyCode,_tmpCityId,_tmpDistrictCode,_tmpCreatedAt,_tmpCreatedBy,_tmpUpdatedAt,_tmpUpdatedBy);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public BpAddrEntity getBpAddrByBp(final int id) {
    final String _sql = "SELECT * FROM bpaddr where bp_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfBpId = CursorUtil.getColumnIndexOrThrow(_cursor, "bp_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGreeting = CursorUtil.getColumnIndexOrThrow(_cursor, "greeting");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfZipCode = CursorUtil.getColumnIndexOrThrow(_cursor, "zipcode");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfIsBillAddr = CursorUtil.getColumnIndexOrThrow(_cursor, "isbilladdr");
      final int _cursorIndexOfIsShipAddr = CursorUtil.getColumnIndexOrThrow(_cursor, "isshipaddr");
      final int _cursorIndexOfIsMainAddr = CursorUtil.getColumnIndexOrThrow(_cursor, "ismainaddr");
      final int _cursorIndexOfProvinceCode = CursorUtil.getColumnIndexOrThrow(_cursor, "province_code");
      final int _cursorIndexOfRegencyCode = CursorUtil.getColumnIndexOrThrow(_cursor, "regency_code");
      final int _cursorIndexOfCityId = CursorUtil.getColumnIndexOrThrow(_cursor, "city_code");
      final int _cursorIndexOfDistrictCode = CursorUtil.getColumnIndexOrThrow(_cursor, "district_code");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final BpAddrEntity _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final Integer _tmpBpId;
        if (_cursor.isNull(_cursorIndexOfBpId)) {
          _tmpBpId = null;
        } else {
          _tmpBpId = _cursor.getInt(_cursorIndexOfBpId);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpGreeting;
        if (_cursor.isNull(_cursorIndexOfGreeting)) {
          _tmpGreeting = null;
        } else {
          _tmpGreeting = _cursor.getString(_cursorIndexOfGreeting);
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
        final String _tmpZipCode;
        if (_cursor.isNull(_cursorIndexOfZipCode)) {
          _tmpZipCode = null;
        } else {
          _tmpZipCode = _cursor.getString(_cursorIndexOfZipCode);
        }
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final boolean _tmpIsBillAddr;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsBillAddr);
        _tmpIsBillAddr = _tmp != 0;
        final boolean _tmpIsShipAddr;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsShipAddr);
        _tmpIsShipAddr = _tmp_1 != 0;
        final boolean _tmpIsMainAddr;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsMainAddr);
        _tmpIsMainAddr = _tmp_2 != 0;
        final String _tmpProvinceCode;
        if (_cursor.isNull(_cursorIndexOfProvinceCode)) {
          _tmpProvinceCode = null;
        } else {
          _tmpProvinceCode = _cursor.getString(_cursorIndexOfProvinceCode);
        }
        final String _tmpRegencyCode;
        if (_cursor.isNull(_cursorIndexOfRegencyCode)) {
          _tmpRegencyCode = null;
        } else {
          _tmpRegencyCode = _cursor.getString(_cursorIndexOfRegencyCode);
        }
        final int _tmpCityId;
        _tmpCityId = _cursor.getInt(_cursorIndexOfCityId);
        final String _tmpDistrictCode;
        if (_cursor.isNull(_cursorIndexOfDistrictCode)) {
          _tmpDistrictCode = null;
        } else {
          _tmpDistrictCode = _cursor.getString(_cursorIndexOfDistrictCode);
        }
        final Date _tmpCreatedAt;
        final Long _tmp_3;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp_3);
        final Integer _tmpCreatedBy;
        if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
          _tmpCreatedBy = null;
        } else {
          _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        }
        final Date _tmpUpdatedAt;
        final Long _tmp_4;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getLong(_cursorIndexOfUpdatedAt);
        }
        _tmpUpdatedAt = __converters.longToDate(_tmp_4);
        final Integer _tmpUpdatedBy;
        if (_cursor.isNull(_cursorIndexOfUpdatedBy)) {
          _tmpUpdatedBy = null;
        } else {
          _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        }
        _result = new BpAddrEntity(_tmpId,_tmpBpId,_tmpName,_tmpGreeting,_tmpAddress,_tmpPhone,_tmpZipCode,_tmpEmail,_tmpNote,_tmpIsBillAddr,_tmpIsShipAddr,_tmpIsMainAddr,_tmpProvinceCode,_tmpRegencyCode,_tmpCityId,_tmpDistrictCode,_tmpCreatedAt,_tmpCreatedBy,_tmpUpdatedAt,_tmpUpdatedBy);
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
