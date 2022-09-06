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
import com.bits.bee.bpmc.data.data_source.local.model.BpEntity;
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
public final class BpDao_Impl implements BpDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BpEntity> __insertionAdapterOfBpEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<BpEntity> __deletionAdapterOfBpEntity;

  private final EntityDeletionOrUpdateAdapter<BpEntity> __updateAdapterOfBpEntity;

  public BpDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBpEntity = new EntityInsertionAdapter<BpEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `bp` (`id`,`code`,`name`,`greeting`,`anniversary`,`taxedonsale`,`taxinconsale`,`note`,`bpgrp1_id`,`pricelvl_id`,`active`,`created_at`,`created_by`,`updated_at`,`updated_by`,`isfavorit`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BpEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
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
        if (value.getGreeting() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGreeting());
        }
        if (value.getAnniversary() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAnniversary());
        }
        final int _tmp = value.isTaxedOnSale() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        final int _tmp_1 = value.isTaxIncOnSale() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        if (value.getNote() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNote());
        }
        if (value.getBpgrpId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getBpgrpId());
        }
        stmt.bindLong(10, value.getPriceLvlId());
        final int _tmp_2 = value.isActive() ? 1 : 0;
        stmt.bindLong(11, _tmp_2);
        final Long _tmp_3 = __converters.dateToLong(value.getCreatedAt());
        if (_tmp_3 == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, _tmp_3);
        }
        stmt.bindLong(13, value.getCreatedBy());
        final Long _tmp_4 = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp_4 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, _tmp_4);
        }
        if (value.getUpdatedBy() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.getUpdatedBy());
        }
        final int _tmp_5 = value.isFavorit() ? 1 : 0;
        stmt.bindLong(16, _tmp_5);
      }
    };
    this.__deletionAdapterOfBpEntity = new EntityDeletionOrUpdateAdapter<BpEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `bp` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BpEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfBpEntity = new EntityDeletionOrUpdateAdapter<BpEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `bp` SET `id` = ?,`code` = ?,`name` = ?,`greeting` = ?,`anniversary` = ?,`taxedonsale` = ?,`taxinconsale` = ?,`note` = ?,`bpgrp1_id` = ?,`pricelvl_id` = ?,`active` = ?,`created_at` = ?,`created_by` = ?,`updated_at` = ?,`updated_by` = ?,`isfavorit` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BpEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
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
        if (value.getGreeting() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGreeting());
        }
        if (value.getAnniversary() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAnniversary());
        }
        final int _tmp = value.isTaxedOnSale() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        final int _tmp_1 = value.isTaxIncOnSale() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        if (value.getNote() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNote());
        }
        if (value.getBpgrpId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getBpgrpId());
        }
        stmt.bindLong(10, value.getPriceLvlId());
        final int _tmp_2 = value.isActive() ? 1 : 0;
        stmt.bindLong(11, _tmp_2);
        final Long _tmp_3 = __converters.dateToLong(value.getCreatedAt());
        if (_tmp_3 == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, _tmp_3);
        }
        stmt.bindLong(13, value.getCreatedBy());
        final Long _tmp_4 = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp_4 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, _tmp_4);
        }
        if (value.getUpdatedBy() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.getUpdatedBy());
        }
        final int _tmp_5 = value.isFavorit() ? 1 : 0;
        stmt.bindLong(16, _tmp_5);
        if (value.getId() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends BpEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final BpEntity entity, final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends BpEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfBpEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final BpEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfBpEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final BpEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfBpEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<BpEntity> getBpList() {
    final String _sql = "SELECT * FROM bp";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGreeting = CursorUtil.getColumnIndexOrThrow(_cursor, "greeting");
      final int _cursorIndexOfAnniversary = CursorUtil.getColumnIndexOrThrow(_cursor, "anniversary");
      final int _cursorIndexOfIsTaxedOnSale = CursorUtil.getColumnIndexOrThrow(_cursor, "taxedonsale");
      final int _cursorIndexOfIsTaxIncOnSale = CursorUtil.getColumnIndexOrThrow(_cursor, "taxinconsale");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfBpgrpId = CursorUtil.getColumnIndexOrThrow(_cursor, "bpgrp1_id");
      final int _cursorIndexOfPriceLvlId = CursorUtil.getColumnIndexOrThrow(_cursor, "pricelvl_id");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(_cursor, "isfavorit");
      final List<BpEntity> _result = new ArrayList<BpEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BpEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
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
        final String _tmpGreeting;
        if (_cursor.isNull(_cursorIndexOfGreeting)) {
          _tmpGreeting = null;
        } else {
          _tmpGreeting = _cursor.getString(_cursorIndexOfGreeting);
        }
        final String _tmpAnniversary;
        if (_cursor.isNull(_cursorIndexOfAnniversary)) {
          _tmpAnniversary = null;
        } else {
          _tmpAnniversary = _cursor.getString(_cursorIndexOfAnniversary);
        }
        final boolean _tmpIsTaxedOnSale;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsTaxedOnSale);
        _tmpIsTaxedOnSale = _tmp != 0;
        final boolean _tmpIsTaxIncOnSale;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsTaxIncOnSale);
        _tmpIsTaxIncOnSale = _tmp_1 != 0;
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final Integer _tmpBpgrpId;
        if (_cursor.isNull(_cursorIndexOfBpgrpId)) {
          _tmpBpgrpId = null;
        } else {
          _tmpBpgrpId = _cursor.getInt(_cursorIndexOfBpgrpId);
        }
        final int _tmpPriceLvlId;
        _tmpPriceLvlId = _cursor.getInt(_cursorIndexOfPriceLvlId);
        final boolean _tmpIsActive;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp_2 != 0;
        final Date _tmpCreatedAt;
        final Long _tmp_3;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp_3);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
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
        final boolean _tmpIsFavorit;
        final int _tmp_5;
        _tmp_5 = _cursor.getInt(_cursorIndexOfIsFavorit);
        _tmpIsFavorit = _tmp_5 != 0;
        _item = new BpEntity(_tmpId,_tmpCode,_tmpName,_tmpGreeting,_tmpAnniversary,_tmpIsTaxedOnSale,_tmpIsTaxIncOnSale,_tmpNote,_tmpBpgrpId,_tmpPriceLvlId,_tmpIsActive,_tmpCreatedAt,_tmpCreatedBy,_tmpUpdatedAt,_tmpUpdatedBy,_tmpIsFavorit);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public BpEntity getBpById(final int id) {
    final String _sql = "SELECT * FROM bp WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGreeting = CursorUtil.getColumnIndexOrThrow(_cursor, "greeting");
      final int _cursorIndexOfAnniversary = CursorUtil.getColumnIndexOrThrow(_cursor, "anniversary");
      final int _cursorIndexOfIsTaxedOnSale = CursorUtil.getColumnIndexOrThrow(_cursor, "taxedonsale");
      final int _cursorIndexOfIsTaxIncOnSale = CursorUtil.getColumnIndexOrThrow(_cursor, "taxinconsale");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfBpgrpId = CursorUtil.getColumnIndexOrThrow(_cursor, "bpgrp1_id");
      final int _cursorIndexOfPriceLvlId = CursorUtil.getColumnIndexOrThrow(_cursor, "pricelvl_id");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(_cursor, "isfavorit");
      final BpEntity _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
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
        final String _tmpGreeting;
        if (_cursor.isNull(_cursorIndexOfGreeting)) {
          _tmpGreeting = null;
        } else {
          _tmpGreeting = _cursor.getString(_cursorIndexOfGreeting);
        }
        final String _tmpAnniversary;
        if (_cursor.isNull(_cursorIndexOfAnniversary)) {
          _tmpAnniversary = null;
        } else {
          _tmpAnniversary = _cursor.getString(_cursorIndexOfAnniversary);
        }
        final boolean _tmpIsTaxedOnSale;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsTaxedOnSale);
        _tmpIsTaxedOnSale = _tmp != 0;
        final boolean _tmpIsTaxIncOnSale;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsTaxIncOnSale);
        _tmpIsTaxIncOnSale = _tmp_1 != 0;
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final Integer _tmpBpgrpId;
        if (_cursor.isNull(_cursorIndexOfBpgrpId)) {
          _tmpBpgrpId = null;
        } else {
          _tmpBpgrpId = _cursor.getInt(_cursorIndexOfBpgrpId);
        }
        final int _tmpPriceLvlId;
        _tmpPriceLvlId = _cursor.getInt(_cursorIndexOfPriceLvlId);
        final boolean _tmpIsActive;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp_2 != 0;
        final Date _tmpCreatedAt;
        final Long _tmp_3;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp_3);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
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
        final boolean _tmpIsFavorit;
        final int _tmp_5;
        _tmp_5 = _cursor.getInt(_cursorIndexOfIsFavorit);
        _tmpIsFavorit = _tmp_5 != 0;
        _result = new BpEntity(_tmpId,_tmpCode,_tmpName,_tmpGreeting,_tmpAnniversary,_tmpIsTaxedOnSale,_tmpIsTaxIncOnSale,_tmpNote,_tmpBpgrpId,_tmpPriceLvlId,_tmpIsActive,_tmpCreatedAt,_tmpCreatedBy,_tmpUpdatedAt,_tmpUpdatedBy,_tmpIsFavorit);
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
  public List<BpEntity> getFavoritBpList(final boolean isFav) {
    final String _sql = "SELECT * FROM bp Where isfavorit = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp = isFav ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGreeting = CursorUtil.getColumnIndexOrThrow(_cursor, "greeting");
      final int _cursorIndexOfAnniversary = CursorUtil.getColumnIndexOrThrow(_cursor, "anniversary");
      final int _cursorIndexOfIsTaxedOnSale = CursorUtil.getColumnIndexOrThrow(_cursor, "taxedonsale");
      final int _cursorIndexOfIsTaxIncOnSale = CursorUtil.getColumnIndexOrThrow(_cursor, "taxinconsale");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfBpgrpId = CursorUtil.getColumnIndexOrThrow(_cursor, "bpgrp1_id");
      final int _cursorIndexOfPriceLvlId = CursorUtil.getColumnIndexOrThrow(_cursor, "pricelvl_id");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(_cursor, "isfavorit");
      final List<BpEntity> _result = new ArrayList<BpEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BpEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
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
        final String _tmpGreeting;
        if (_cursor.isNull(_cursorIndexOfGreeting)) {
          _tmpGreeting = null;
        } else {
          _tmpGreeting = _cursor.getString(_cursorIndexOfGreeting);
        }
        final String _tmpAnniversary;
        if (_cursor.isNull(_cursorIndexOfAnniversary)) {
          _tmpAnniversary = null;
        } else {
          _tmpAnniversary = _cursor.getString(_cursorIndexOfAnniversary);
        }
        final boolean _tmpIsTaxedOnSale;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsTaxedOnSale);
        _tmpIsTaxedOnSale = _tmp_1 != 0;
        final boolean _tmpIsTaxIncOnSale;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsTaxIncOnSale);
        _tmpIsTaxIncOnSale = _tmp_2 != 0;
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final Integer _tmpBpgrpId;
        if (_cursor.isNull(_cursorIndexOfBpgrpId)) {
          _tmpBpgrpId = null;
        } else {
          _tmpBpgrpId = _cursor.getInt(_cursorIndexOfBpgrpId);
        }
        final int _tmpPriceLvlId;
        _tmpPriceLvlId = _cursor.getInt(_cursorIndexOfPriceLvlId);
        final boolean _tmpIsActive;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp_3 != 0;
        final Date _tmpCreatedAt;
        final Long _tmp_4;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp_4);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        final Date _tmpUpdatedAt;
        final Long _tmp_5;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getLong(_cursorIndexOfUpdatedAt);
        }
        _tmpUpdatedAt = __converters.longToDate(_tmp_5);
        final Integer _tmpUpdatedBy;
        if (_cursor.isNull(_cursorIndexOfUpdatedBy)) {
          _tmpUpdatedBy = null;
        } else {
          _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        }
        final boolean _tmpIsFavorit;
        final int _tmp_6;
        _tmp_6 = _cursor.getInt(_cursorIndexOfIsFavorit);
        _tmpIsFavorit = _tmp_6 != 0;
        _item = new BpEntity(_tmpId,_tmpCode,_tmpName,_tmpGreeting,_tmpAnniversary,_tmpIsTaxedOnSale,_tmpIsTaxIncOnSale,_tmpNote,_tmpBpgrpId,_tmpPriceLvlId,_tmpIsActive,_tmpCreatedAt,_tmpCreatedBy,_tmpUpdatedAt,_tmpUpdatedBy,_tmpIsFavorit);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public BpEntity getLastId() {
    final String _sql = "SELECT * FROM bp ORDER BY id DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGreeting = CursorUtil.getColumnIndexOrThrow(_cursor, "greeting");
      final int _cursorIndexOfAnniversary = CursorUtil.getColumnIndexOrThrow(_cursor, "anniversary");
      final int _cursorIndexOfIsTaxedOnSale = CursorUtil.getColumnIndexOrThrow(_cursor, "taxedonsale");
      final int _cursorIndexOfIsTaxIncOnSale = CursorUtil.getColumnIndexOrThrow(_cursor, "taxinconsale");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfBpgrpId = CursorUtil.getColumnIndexOrThrow(_cursor, "bpgrp1_id");
      final int _cursorIndexOfPriceLvlId = CursorUtil.getColumnIndexOrThrow(_cursor, "pricelvl_id");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(_cursor, "isfavorit");
      final BpEntity _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
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
        final String _tmpGreeting;
        if (_cursor.isNull(_cursorIndexOfGreeting)) {
          _tmpGreeting = null;
        } else {
          _tmpGreeting = _cursor.getString(_cursorIndexOfGreeting);
        }
        final String _tmpAnniversary;
        if (_cursor.isNull(_cursorIndexOfAnniversary)) {
          _tmpAnniversary = null;
        } else {
          _tmpAnniversary = _cursor.getString(_cursorIndexOfAnniversary);
        }
        final boolean _tmpIsTaxedOnSale;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsTaxedOnSale);
        _tmpIsTaxedOnSale = _tmp != 0;
        final boolean _tmpIsTaxIncOnSale;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsTaxIncOnSale);
        _tmpIsTaxIncOnSale = _tmp_1 != 0;
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final Integer _tmpBpgrpId;
        if (_cursor.isNull(_cursorIndexOfBpgrpId)) {
          _tmpBpgrpId = null;
        } else {
          _tmpBpgrpId = _cursor.getInt(_cursorIndexOfBpgrpId);
        }
        final int _tmpPriceLvlId;
        _tmpPriceLvlId = _cursor.getInt(_cursorIndexOfPriceLvlId);
        final boolean _tmpIsActive;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp_2 != 0;
        final Date _tmpCreatedAt;
        final Long _tmp_3;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp_3);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
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
        final boolean _tmpIsFavorit;
        final int _tmp_5;
        _tmp_5 = _cursor.getInt(_cursorIndexOfIsFavorit);
        _tmpIsFavorit = _tmp_5 != 0;
        _result = new BpEntity(_tmpId,_tmpCode,_tmpName,_tmpGreeting,_tmpAnniversary,_tmpIsTaxedOnSale,_tmpIsTaxIncOnSale,_tmpNote,_tmpBpgrpId,_tmpPriceLvlId,_tmpIsActive,_tmpCreatedAt,_tmpCreatedBy,_tmpUpdatedAt,_tmpUpdatedBy,_tmpIsFavorit);
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
  public List<BpEntity> searchBp(final String query) {
    final String _sql = "SELECT * FROM bp WHERE name LIKE '%'|| ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGreeting = CursorUtil.getColumnIndexOrThrow(_cursor, "greeting");
      final int _cursorIndexOfAnniversary = CursorUtil.getColumnIndexOrThrow(_cursor, "anniversary");
      final int _cursorIndexOfIsTaxedOnSale = CursorUtil.getColumnIndexOrThrow(_cursor, "taxedonsale");
      final int _cursorIndexOfIsTaxIncOnSale = CursorUtil.getColumnIndexOrThrow(_cursor, "taxinconsale");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfBpgrpId = CursorUtil.getColumnIndexOrThrow(_cursor, "bpgrp1_id");
      final int _cursorIndexOfPriceLvlId = CursorUtil.getColumnIndexOrThrow(_cursor, "pricelvl_id");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(_cursor, "isfavorit");
      final List<BpEntity> _result = new ArrayList<BpEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BpEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
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
        final String _tmpGreeting;
        if (_cursor.isNull(_cursorIndexOfGreeting)) {
          _tmpGreeting = null;
        } else {
          _tmpGreeting = _cursor.getString(_cursorIndexOfGreeting);
        }
        final String _tmpAnniversary;
        if (_cursor.isNull(_cursorIndexOfAnniversary)) {
          _tmpAnniversary = null;
        } else {
          _tmpAnniversary = _cursor.getString(_cursorIndexOfAnniversary);
        }
        final boolean _tmpIsTaxedOnSale;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsTaxedOnSale);
        _tmpIsTaxedOnSale = _tmp != 0;
        final boolean _tmpIsTaxIncOnSale;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsTaxIncOnSale);
        _tmpIsTaxIncOnSale = _tmp_1 != 0;
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final Integer _tmpBpgrpId;
        if (_cursor.isNull(_cursorIndexOfBpgrpId)) {
          _tmpBpgrpId = null;
        } else {
          _tmpBpgrpId = _cursor.getInt(_cursorIndexOfBpgrpId);
        }
        final int _tmpPriceLvlId;
        _tmpPriceLvlId = _cursor.getInt(_cursorIndexOfPriceLvlId);
        final boolean _tmpIsActive;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp_2 != 0;
        final Date _tmpCreatedAt;
        final Long _tmp_3;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp_3);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
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
        final boolean _tmpIsFavorit;
        final int _tmp_5;
        _tmp_5 = _cursor.getInt(_cursorIndexOfIsFavorit);
        _tmpIsFavorit = _tmp_5 != 0;
        _item = new BpEntity(_tmpId,_tmpCode,_tmpName,_tmpGreeting,_tmpAnniversary,_tmpIsTaxedOnSale,_tmpIsTaxIncOnSale,_tmpNote,_tmpBpgrpId,_tmpPriceLvlId,_tmpIsActive,_tmpCreatedAt,_tmpCreatedBy,_tmpUpdatedAt,_tmpUpdatedBy,_tmpIsFavorit);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<BpEntity> getBpByDate(final long startDate, final long endDate) {
    final String _sql = "SELECT * FROM bp WHERE created_at BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endDate);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGreeting = CursorUtil.getColumnIndexOrThrow(_cursor, "greeting");
      final int _cursorIndexOfAnniversary = CursorUtil.getColumnIndexOrThrow(_cursor, "anniversary");
      final int _cursorIndexOfIsTaxedOnSale = CursorUtil.getColumnIndexOrThrow(_cursor, "taxedonsale");
      final int _cursorIndexOfIsTaxIncOnSale = CursorUtil.getColumnIndexOrThrow(_cursor, "taxinconsale");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfBpgrpId = CursorUtil.getColumnIndexOrThrow(_cursor, "bpgrp1_id");
      final int _cursorIndexOfPriceLvlId = CursorUtil.getColumnIndexOrThrow(_cursor, "pricelvl_id");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(_cursor, "isfavorit");
      final List<BpEntity> _result = new ArrayList<BpEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BpEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
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
        final String _tmpGreeting;
        if (_cursor.isNull(_cursorIndexOfGreeting)) {
          _tmpGreeting = null;
        } else {
          _tmpGreeting = _cursor.getString(_cursorIndexOfGreeting);
        }
        final String _tmpAnniversary;
        if (_cursor.isNull(_cursorIndexOfAnniversary)) {
          _tmpAnniversary = null;
        } else {
          _tmpAnniversary = _cursor.getString(_cursorIndexOfAnniversary);
        }
        final boolean _tmpIsTaxedOnSale;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsTaxedOnSale);
        _tmpIsTaxedOnSale = _tmp != 0;
        final boolean _tmpIsTaxIncOnSale;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsTaxIncOnSale);
        _tmpIsTaxIncOnSale = _tmp_1 != 0;
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final Integer _tmpBpgrpId;
        if (_cursor.isNull(_cursorIndexOfBpgrpId)) {
          _tmpBpgrpId = null;
        } else {
          _tmpBpgrpId = _cursor.getInt(_cursorIndexOfBpgrpId);
        }
        final int _tmpPriceLvlId;
        _tmpPriceLvlId = _cursor.getInt(_cursorIndexOfPriceLvlId);
        final boolean _tmpIsActive;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp_2 != 0;
        final Date _tmpCreatedAt;
        final Long _tmp_3;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp_3);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
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
        final boolean _tmpIsFavorit;
        final int _tmp_5;
        _tmp_5 = _cursor.getInt(_cursorIndexOfIsFavorit);
        _tmpIsFavorit = _tmp_5 != 0;
        _item = new BpEntity(_tmpId,_tmpCode,_tmpName,_tmpGreeting,_tmpAnniversary,_tmpIsTaxedOnSale,_tmpIsTaxIncOnSale,_tmpNote,_tmpBpgrpId,_tmpPriceLvlId,_tmpIsActive,_tmpCreatedAt,_tmpCreatedBy,_tmpUpdatedAt,_tmpUpdatedBy,_tmpIsFavorit);
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
