package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.paging.PagingSource;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.converter.Converters;
import com.bits.bee.bpmc.data.data_source.local.model.ItemEntity;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ItemDao_Impl implements ItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemEntity> __insertionAdapterOfItemEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<ItemEntity> __deletionAdapterOfItemEntity;

  private final EntityDeletionOrUpdateAdapter<ItemEntity> __updateAdapterOfItemEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ItemDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemEntity = new EntityInsertionAdapter<ItemEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `item` (`id`,`code`,`name1`,`brand_id`,`itemtype_code`,`usepid`,`uniquepid`,`itemgrp1_id`,`isstock`,`issale`,`unitdesc`,`note`,`active`,`saleunit`,`stockunit`,`itemqty`,`ispos`,`type`,`favorit`,`is_available`,`is_variant`,`vcode`,`vcolor`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCode());
        }
        if (value.getName1() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName1());
        }
        if (value.getBrandId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getBrandId());
        }
        if (value.getItemTypeCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getItemTypeCode());
        }
        final int _tmp = value.getUsePid() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        final int _tmp_1 = value.getUniquePid() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        if (value.getItemGrpId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getItemGrpId());
        }
        final int _tmp_2 = value.isStock() ? 1 : 0;
        stmt.bindLong(9, _tmp_2);
        final int _tmp_3 = value.isSale() ? 1 : 0;
        stmt.bindLong(10, _tmp_3);
        if (value.getUnitdesc() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getUnitdesc());
        }
        if (value.getNote() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getNote());
        }
        final int _tmp_4 = value.getActive() ? 1 : 0;
        stmt.bindLong(13, _tmp_4);
        if (value.getSaleUnit() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getSaleUnit());
        }
        if (value.getStockUnit() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.getStockUnit());
        }
        final String _tmp_5 = __converters.bigDecimalToString(value.getQty());
        if (_tmp_5 == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, _tmp_5);
        }
        final int _tmp_6 = value.isPos() ? 1 : 0;
        stmt.bindLong(17, _tmp_6);
        if (value.getType() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getType());
        }
        final int _tmp_7 = value.isFavorit() ? 1 : 0;
        stmt.bindLong(19, _tmp_7);
        final int _tmp_8 = value.isAvailable() ? 1 : 0;
        stmt.bindLong(20, _tmp_8);
        final int _tmp_9 = value.isVariant() ? 1 : 0;
        stmt.bindLong(21, _tmp_9);
        if (value.getVCode() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getVCode());
        }
        if (value.getVColor() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getVColor());
        }
      }
    };
    this.__deletionAdapterOfItemEntity = new EntityDeletionOrUpdateAdapter<ItemEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `item` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfItemEntity = new EntityDeletionOrUpdateAdapter<ItemEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `item` SET `id` = ?,`code` = ?,`name1` = ?,`brand_id` = ?,`itemtype_code` = ?,`usepid` = ?,`uniquepid` = ?,`itemgrp1_id` = ?,`isstock` = ?,`issale` = ?,`unitdesc` = ?,`note` = ?,`active` = ?,`saleunit` = ?,`stockunit` = ?,`itemqty` = ?,`ispos` = ?,`type` = ?,`favorit` = ?,`is_available` = ?,`is_variant` = ?,`vcode` = ?,`vcolor` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCode());
        }
        if (value.getName1() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName1());
        }
        if (value.getBrandId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getBrandId());
        }
        if (value.getItemTypeCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getItemTypeCode());
        }
        final int _tmp = value.getUsePid() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        final int _tmp_1 = value.getUniquePid() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        if (value.getItemGrpId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getItemGrpId());
        }
        final int _tmp_2 = value.isStock() ? 1 : 0;
        stmt.bindLong(9, _tmp_2);
        final int _tmp_3 = value.isSale() ? 1 : 0;
        stmt.bindLong(10, _tmp_3);
        if (value.getUnitdesc() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getUnitdesc());
        }
        if (value.getNote() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getNote());
        }
        final int _tmp_4 = value.getActive() ? 1 : 0;
        stmt.bindLong(13, _tmp_4);
        if (value.getSaleUnit() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getSaleUnit());
        }
        if (value.getStockUnit() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.getStockUnit());
        }
        final String _tmp_5 = __converters.bigDecimalToString(value.getQty());
        if (_tmp_5 == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, _tmp_5);
        }
        final int _tmp_6 = value.isPos() ? 1 : 0;
        stmt.bindLong(17, _tmp_6);
        if (value.getType() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getType());
        }
        final int _tmp_7 = value.isFavorit() ? 1 : 0;
        stmt.bindLong(19, _tmp_7);
        final int _tmp_8 = value.isAvailable() ? 1 : 0;
        stmt.bindLong(20, _tmp_8);
        final int _tmp_9 = value.isVariant() ? 1 : 0;
        stmt.bindLong(21, _tmp_9);
        if (value.getVCode() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getVCode());
        }
        if (value.getVColor() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getVColor());
        }
        stmt.bindLong(24, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM item";
        return _query;
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends ItemEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final ItemEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends ItemEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ItemEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ItemEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfItemEntity.handle(entity);
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
  public List<ItemEntity> getItemList() {
    final String _sql = "SELECT * FROM item";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName1 = CursorUtil.getColumnIndexOrThrow(_cursor, "name1");
      final int _cursorIndexOfBrandId = CursorUtil.getColumnIndexOrThrow(_cursor, "brand_id");
      final int _cursorIndexOfItemTypeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemtype_code");
      final int _cursorIndexOfUsePid = CursorUtil.getColumnIndexOrThrow(_cursor, "usepid");
      final int _cursorIndexOfUniquePid = CursorUtil.getColumnIndexOrThrow(_cursor, "uniquepid");
      final int _cursorIndexOfItemGrpId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemgrp1_id");
      final int _cursorIndexOfIsStock = CursorUtil.getColumnIndexOrThrow(_cursor, "isstock");
      final int _cursorIndexOfIsSale = CursorUtil.getColumnIndexOrThrow(_cursor, "issale");
      final int _cursorIndexOfUnitdesc = CursorUtil.getColumnIndexOrThrow(_cursor, "unitdesc");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfSaleUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "saleunit");
      final int _cursorIndexOfStockUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "stockunit");
      final int _cursorIndexOfQty = CursorUtil.getColumnIndexOrThrow(_cursor, "itemqty");
      final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(_cursor, "ispos");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(_cursor, "favorit");
      final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "is_available");
      final int _cursorIndexOfIsVariant = CursorUtil.getColumnIndexOrThrow(_cursor, "is_variant");
      final int _cursorIndexOfVCode = CursorUtil.getColumnIndexOrThrow(_cursor, "vcode");
      final int _cursorIndexOfVColor = CursorUtil.getColumnIndexOrThrow(_cursor, "vcolor");
      final List<ItemEntity> _result = new ArrayList<ItemEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpName1;
        if (_cursor.isNull(_cursorIndexOfName1)) {
          _tmpName1 = null;
        } else {
          _tmpName1 = _cursor.getString(_cursorIndexOfName1);
        }
        final Integer _tmpBrandId;
        if (_cursor.isNull(_cursorIndexOfBrandId)) {
          _tmpBrandId = null;
        } else {
          _tmpBrandId = _cursor.getInt(_cursorIndexOfBrandId);
        }
        final String _tmpItemTypeCode;
        if (_cursor.isNull(_cursorIndexOfItemTypeCode)) {
          _tmpItemTypeCode = null;
        } else {
          _tmpItemTypeCode = _cursor.getString(_cursorIndexOfItemTypeCode);
        }
        final boolean _tmpUsePid;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfUsePid);
        _tmpUsePid = _tmp != 0;
        final boolean _tmpUniquePid;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfUniquePid);
        _tmpUniquePid = _tmp_1 != 0;
        final Integer _tmpItemGrpId;
        if (_cursor.isNull(_cursorIndexOfItemGrpId)) {
          _tmpItemGrpId = null;
        } else {
          _tmpItemGrpId = _cursor.getInt(_cursorIndexOfItemGrpId);
        }
        final boolean _tmpIsStock;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsStock);
        _tmpIsStock = _tmp_2 != 0;
        final boolean _tmpIsSale;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfIsSale);
        _tmpIsSale = _tmp_3 != 0;
        final String _tmpUnitdesc;
        if (_cursor.isNull(_cursorIndexOfUnitdesc)) {
          _tmpUnitdesc = null;
        } else {
          _tmpUnitdesc = _cursor.getString(_cursorIndexOfUnitdesc);
        }
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final boolean _tmpActive;
        final int _tmp_4;
        _tmp_4 = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp_4 != 0;
        final Integer _tmpSaleUnit;
        if (_cursor.isNull(_cursorIndexOfSaleUnit)) {
          _tmpSaleUnit = null;
        } else {
          _tmpSaleUnit = _cursor.getInt(_cursorIndexOfSaleUnit);
        }
        final Integer _tmpStockUnit;
        if (_cursor.isNull(_cursorIndexOfStockUnit)) {
          _tmpStockUnit = null;
        } else {
          _tmpStockUnit = _cursor.getInt(_cursorIndexOfStockUnit);
        }
        final BigDecimal _tmpQty;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfQty)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfQty);
        }
        _tmpQty = __converters.stringToBigDecimal(_tmp_5);
        final boolean _tmpIsPos;
        final int _tmp_6;
        _tmp_6 = _cursor.getInt(_cursorIndexOfIsPos);
        _tmpIsPos = _tmp_6 != 0;
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        final boolean _tmpIsFavorit;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsFavorit);
        _tmpIsFavorit = _tmp_7 != 0;
        final boolean _tmpIsAvailable;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsAvailable);
        _tmpIsAvailable = _tmp_8 != 0;
        final boolean _tmpIsVariant;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsVariant);
        _tmpIsVariant = _tmp_9 != 0;
        final String _tmpVCode;
        if (_cursor.isNull(_cursorIndexOfVCode)) {
          _tmpVCode = null;
        } else {
          _tmpVCode = _cursor.getString(_cursorIndexOfVCode);
        }
        final String _tmpVColor;
        if (_cursor.isNull(_cursorIndexOfVColor)) {
          _tmpVColor = null;
        } else {
          _tmpVColor = _cursor.getString(_cursorIndexOfVColor);
        }
        _item = new ItemEntity(_tmpId,_tmpCode,_tmpName1,_tmpBrandId,_tmpItemTypeCode,_tmpUsePid,_tmpUniquePid,_tmpItemGrpId,_tmpIsStock,_tmpIsSale,_tmpUnitdesc,_tmpNote,_tmpActive,_tmpSaleUnit,_tmpStockUnit,_tmpQty,_tmpIsPos,_tmpType,_tmpIsFavorit,_tmpIsAvailable,_tmpIsVariant,_tmpVCode,_tmpVColor);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public PagingSource<Integer, ItemEntity> getActiveItemList(final String query,
      final boolean usePid) {
    final String _sql = "SELECT * FROM item WHERE ispos = 1 AND active = 1 AND name1 LIKE '%' || ? || '%' AND usepid = ? AND is_variant = 0 AND id NOT IN (SELECT item_id FROM item_variant) AND id NOT IN (SELECT item_id FROM item_branch) UNION SELECT id, code, name as name1, '' as brand_id, '' as itemtype_code, 0 as usepid, 0 as uniqepid, itgrp_id as itemgrp1_id, 0 as isstock, 1 as issale, '' as unitdesc, '' as note, 1 as active, 0 as saleunit, 0 as stockunit, 0 as itemqty, 1 as ispos, '' as type, 0 as favorit, isavailable as is_available, '1' as is_variant, '' as vcode, '' as vcolor from variant WHERE name1 LIKE '%' || ? || '%' ORDER BY name1 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    final int _tmp = usePid ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    _argIndex = 3;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return new LimitOffsetPagingSource<ItemEntity>(_statement, __db, "item", "item_variant", "item_branch", "variant") {
      @Override
      protected List<ItemEntity> convertRows(Cursor cursor) {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(cursor, "code");
        final int _cursorIndexOfName1 = CursorUtil.getColumnIndexOrThrow(cursor, "name1");
        final int _cursorIndexOfBrandId = CursorUtil.getColumnIndexOrThrow(cursor, "brand_id");
        final int _cursorIndexOfItemTypeCode = CursorUtil.getColumnIndexOrThrow(cursor, "itemtype_code");
        final int _cursorIndexOfUsePid = CursorUtil.getColumnIndexOrThrow(cursor, "usepid");
        final int _cursorIndexOfUniquePid = CursorUtil.getColumnIndexOrThrow(cursor, "uniquepid");
        final int _cursorIndexOfItemGrpId = CursorUtil.getColumnIndexOrThrow(cursor, "itemgrp1_id");
        final int _cursorIndexOfIsStock = CursorUtil.getColumnIndexOrThrow(cursor, "isstock");
        final int _cursorIndexOfIsSale = CursorUtil.getColumnIndexOrThrow(cursor, "issale");
        final int _cursorIndexOfUnitdesc = CursorUtil.getColumnIndexOrThrow(cursor, "unitdesc");
        final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(cursor, "note");
        final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(cursor, "active");
        final int _cursorIndexOfSaleUnit = CursorUtil.getColumnIndexOrThrow(cursor, "saleunit");
        final int _cursorIndexOfStockUnit = CursorUtil.getColumnIndexOrThrow(cursor, "stockunit");
        final int _cursorIndexOfQty = CursorUtil.getColumnIndexOrThrow(cursor, "itemqty");
        final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(cursor, "ispos");
        final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(cursor, "type");
        final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(cursor, "favorit");
        final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(cursor, "is_available");
        final int _cursorIndexOfIsVariant = CursorUtil.getColumnIndexOrThrow(cursor, "is_variant");
        final int _cursorIndexOfVCode = CursorUtil.getColumnIndexOrThrow(cursor, "vcode");
        final int _cursorIndexOfVColor = CursorUtil.getColumnIndexOrThrow(cursor, "vcolor");
        final List<ItemEntity> _result = new ArrayList<ItemEntity>(cursor.getCount());
        while(cursor.moveToNext()) {
          final ItemEntity _item;
          final int _tmpId;
          _tmpId = cursor.getInt(_cursorIndexOfId);
          final String _tmpCode;
          if (cursor.isNull(_cursorIndexOfCode)) {
            _tmpCode = null;
          } else {
            _tmpCode = cursor.getString(_cursorIndexOfCode);
          }
          final String _tmpName1;
          if (cursor.isNull(_cursorIndexOfName1)) {
            _tmpName1 = null;
          } else {
            _tmpName1 = cursor.getString(_cursorIndexOfName1);
          }
          final Integer _tmpBrandId;
          if (cursor.isNull(_cursorIndexOfBrandId)) {
            _tmpBrandId = null;
          } else {
            _tmpBrandId = cursor.getInt(_cursorIndexOfBrandId);
          }
          final String _tmpItemTypeCode;
          if (cursor.isNull(_cursorIndexOfItemTypeCode)) {
            _tmpItemTypeCode = null;
          } else {
            _tmpItemTypeCode = cursor.getString(_cursorIndexOfItemTypeCode);
          }
          final boolean _tmpUsePid;
          final int _tmp_1;
          _tmp_1 = cursor.getInt(_cursorIndexOfUsePid);
          _tmpUsePid = _tmp_1 != 0;
          final boolean _tmpUniquePid;
          final int _tmp_2;
          _tmp_2 = cursor.getInt(_cursorIndexOfUniquePid);
          _tmpUniquePid = _tmp_2 != 0;
          final Integer _tmpItemGrpId;
          if (cursor.isNull(_cursorIndexOfItemGrpId)) {
            _tmpItemGrpId = null;
          } else {
            _tmpItemGrpId = cursor.getInt(_cursorIndexOfItemGrpId);
          }
          final boolean _tmpIsStock;
          final int _tmp_3;
          _tmp_3 = cursor.getInt(_cursorIndexOfIsStock);
          _tmpIsStock = _tmp_3 != 0;
          final boolean _tmpIsSale;
          final int _tmp_4;
          _tmp_4 = cursor.getInt(_cursorIndexOfIsSale);
          _tmpIsSale = _tmp_4 != 0;
          final String _tmpUnitdesc;
          if (cursor.isNull(_cursorIndexOfUnitdesc)) {
            _tmpUnitdesc = null;
          } else {
            _tmpUnitdesc = cursor.getString(_cursorIndexOfUnitdesc);
          }
          final String _tmpNote;
          if (cursor.isNull(_cursorIndexOfNote)) {
            _tmpNote = null;
          } else {
            _tmpNote = cursor.getString(_cursorIndexOfNote);
          }
          final boolean _tmpActive;
          final int _tmp_5;
          _tmp_5 = cursor.getInt(_cursorIndexOfActive);
          _tmpActive = _tmp_5 != 0;
          final Integer _tmpSaleUnit;
          if (cursor.isNull(_cursorIndexOfSaleUnit)) {
            _tmpSaleUnit = null;
          } else {
            _tmpSaleUnit = cursor.getInt(_cursorIndexOfSaleUnit);
          }
          final Integer _tmpStockUnit;
          if (cursor.isNull(_cursorIndexOfStockUnit)) {
            _tmpStockUnit = null;
          } else {
            _tmpStockUnit = cursor.getInt(_cursorIndexOfStockUnit);
          }
          final BigDecimal _tmpQty;
          final String _tmp_6;
          if (cursor.isNull(_cursorIndexOfQty)) {
            _tmp_6 = null;
          } else {
            _tmp_6 = cursor.getString(_cursorIndexOfQty);
          }
          _tmpQty = __converters.stringToBigDecimal(_tmp_6);
          final boolean _tmpIsPos;
          final int _tmp_7;
          _tmp_7 = cursor.getInt(_cursorIndexOfIsPos);
          _tmpIsPos = _tmp_7 != 0;
          final String _tmpType;
          if (cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = cursor.getString(_cursorIndexOfType);
          }
          final boolean _tmpIsFavorit;
          final int _tmp_8;
          _tmp_8 = cursor.getInt(_cursorIndexOfIsFavorit);
          _tmpIsFavorit = _tmp_8 != 0;
          final boolean _tmpIsAvailable;
          final int _tmp_9;
          _tmp_9 = cursor.getInt(_cursorIndexOfIsAvailable);
          _tmpIsAvailable = _tmp_9 != 0;
          final boolean _tmpIsVariant;
          final int _tmp_10;
          _tmp_10 = cursor.getInt(_cursorIndexOfIsVariant);
          _tmpIsVariant = _tmp_10 != 0;
          final String _tmpVCode;
          if (cursor.isNull(_cursorIndexOfVCode)) {
            _tmpVCode = null;
          } else {
            _tmpVCode = cursor.getString(_cursorIndexOfVCode);
          }
          final String _tmpVColor;
          if (cursor.isNull(_cursorIndexOfVColor)) {
            _tmpVColor = null;
          } else {
            _tmpVColor = cursor.getString(_cursorIndexOfVColor);
          }
          _item = new ItemEntity(_tmpId,_tmpCode,_tmpName1,_tmpBrandId,_tmpItemTypeCode,_tmpUsePid,_tmpUniquePid,_tmpItemGrpId,_tmpIsStock,_tmpIsSale,_tmpUnitdesc,_tmpNote,_tmpActive,_tmpSaleUnit,_tmpStockUnit,_tmpQty,_tmpIsPos,_tmpType,_tmpIsFavorit,_tmpIsAvailable,_tmpIsVariant,_tmpVCode,_tmpVColor);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @Override
  public PagingSource<Integer, ItemEntity> getActiveItemListPid(final String query) {
    final String _sql = "SELECT * FROM item WHERE ispos = 1 AND active = 1 AND name1 LIKE '%' || ? || '%' AND is_variant = 0 AND id NOT IN (SELECT item_id FROM item_variant) AND id NOT IN (SELECT item_id FROM item_branch) UNION SELECT id, code, name as name1, '' as brand_id, '' as itemtype_code, 0 as usepid, 0 as uniqepid, itgrp_id as itemgrp1_id, 0 as isstock, 1 as issale, '' as unitdesc, '' as note, 1 as active, 0 as saleunit, 0 as stockunit, 0 as itemqty, 1 as ispos, '' as type, 0 as favorit, isavailable as is_available, '1' as is_variant, '' as vcode, '' as vcolor from variant WHERE name1 LIKE '%' || ? || '%' ORDER BY name1 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return new LimitOffsetPagingSource<ItemEntity>(_statement, __db, "item", "item_variant", "item_branch", "variant") {
      @Override
      protected List<ItemEntity> convertRows(Cursor cursor) {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(cursor, "code");
        final int _cursorIndexOfName1 = CursorUtil.getColumnIndexOrThrow(cursor, "name1");
        final int _cursorIndexOfBrandId = CursorUtil.getColumnIndexOrThrow(cursor, "brand_id");
        final int _cursorIndexOfItemTypeCode = CursorUtil.getColumnIndexOrThrow(cursor, "itemtype_code");
        final int _cursorIndexOfUsePid = CursorUtil.getColumnIndexOrThrow(cursor, "usepid");
        final int _cursorIndexOfUniquePid = CursorUtil.getColumnIndexOrThrow(cursor, "uniquepid");
        final int _cursorIndexOfItemGrpId = CursorUtil.getColumnIndexOrThrow(cursor, "itemgrp1_id");
        final int _cursorIndexOfIsStock = CursorUtil.getColumnIndexOrThrow(cursor, "isstock");
        final int _cursorIndexOfIsSale = CursorUtil.getColumnIndexOrThrow(cursor, "issale");
        final int _cursorIndexOfUnitdesc = CursorUtil.getColumnIndexOrThrow(cursor, "unitdesc");
        final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(cursor, "note");
        final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(cursor, "active");
        final int _cursorIndexOfSaleUnit = CursorUtil.getColumnIndexOrThrow(cursor, "saleunit");
        final int _cursorIndexOfStockUnit = CursorUtil.getColumnIndexOrThrow(cursor, "stockunit");
        final int _cursorIndexOfQty = CursorUtil.getColumnIndexOrThrow(cursor, "itemqty");
        final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(cursor, "ispos");
        final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(cursor, "type");
        final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(cursor, "favorit");
        final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(cursor, "is_available");
        final int _cursorIndexOfIsVariant = CursorUtil.getColumnIndexOrThrow(cursor, "is_variant");
        final int _cursorIndexOfVCode = CursorUtil.getColumnIndexOrThrow(cursor, "vcode");
        final int _cursorIndexOfVColor = CursorUtil.getColumnIndexOrThrow(cursor, "vcolor");
        final List<ItemEntity> _result = new ArrayList<ItemEntity>(cursor.getCount());
        while(cursor.moveToNext()) {
          final ItemEntity _item;
          final int _tmpId;
          _tmpId = cursor.getInt(_cursorIndexOfId);
          final String _tmpCode;
          if (cursor.isNull(_cursorIndexOfCode)) {
            _tmpCode = null;
          } else {
            _tmpCode = cursor.getString(_cursorIndexOfCode);
          }
          final String _tmpName1;
          if (cursor.isNull(_cursorIndexOfName1)) {
            _tmpName1 = null;
          } else {
            _tmpName1 = cursor.getString(_cursorIndexOfName1);
          }
          final Integer _tmpBrandId;
          if (cursor.isNull(_cursorIndexOfBrandId)) {
            _tmpBrandId = null;
          } else {
            _tmpBrandId = cursor.getInt(_cursorIndexOfBrandId);
          }
          final String _tmpItemTypeCode;
          if (cursor.isNull(_cursorIndexOfItemTypeCode)) {
            _tmpItemTypeCode = null;
          } else {
            _tmpItemTypeCode = cursor.getString(_cursorIndexOfItemTypeCode);
          }
          final boolean _tmpUsePid;
          final int _tmp;
          _tmp = cursor.getInt(_cursorIndexOfUsePid);
          _tmpUsePid = _tmp != 0;
          final boolean _tmpUniquePid;
          final int _tmp_1;
          _tmp_1 = cursor.getInt(_cursorIndexOfUniquePid);
          _tmpUniquePid = _tmp_1 != 0;
          final Integer _tmpItemGrpId;
          if (cursor.isNull(_cursorIndexOfItemGrpId)) {
            _tmpItemGrpId = null;
          } else {
            _tmpItemGrpId = cursor.getInt(_cursorIndexOfItemGrpId);
          }
          final boolean _tmpIsStock;
          final int _tmp_2;
          _tmp_2 = cursor.getInt(_cursorIndexOfIsStock);
          _tmpIsStock = _tmp_2 != 0;
          final boolean _tmpIsSale;
          final int _tmp_3;
          _tmp_3 = cursor.getInt(_cursorIndexOfIsSale);
          _tmpIsSale = _tmp_3 != 0;
          final String _tmpUnitdesc;
          if (cursor.isNull(_cursorIndexOfUnitdesc)) {
            _tmpUnitdesc = null;
          } else {
            _tmpUnitdesc = cursor.getString(_cursorIndexOfUnitdesc);
          }
          final String _tmpNote;
          if (cursor.isNull(_cursorIndexOfNote)) {
            _tmpNote = null;
          } else {
            _tmpNote = cursor.getString(_cursorIndexOfNote);
          }
          final boolean _tmpActive;
          final int _tmp_4;
          _tmp_4 = cursor.getInt(_cursorIndexOfActive);
          _tmpActive = _tmp_4 != 0;
          final Integer _tmpSaleUnit;
          if (cursor.isNull(_cursorIndexOfSaleUnit)) {
            _tmpSaleUnit = null;
          } else {
            _tmpSaleUnit = cursor.getInt(_cursorIndexOfSaleUnit);
          }
          final Integer _tmpStockUnit;
          if (cursor.isNull(_cursorIndexOfStockUnit)) {
            _tmpStockUnit = null;
          } else {
            _tmpStockUnit = cursor.getInt(_cursorIndexOfStockUnit);
          }
          final BigDecimal _tmpQty;
          final String _tmp_5;
          if (cursor.isNull(_cursorIndexOfQty)) {
            _tmp_5 = null;
          } else {
            _tmp_5 = cursor.getString(_cursorIndexOfQty);
          }
          _tmpQty = __converters.stringToBigDecimal(_tmp_5);
          final boolean _tmpIsPos;
          final int _tmp_6;
          _tmp_6 = cursor.getInt(_cursorIndexOfIsPos);
          _tmpIsPos = _tmp_6 != 0;
          final String _tmpType;
          if (cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = cursor.getString(_cursorIndexOfType);
          }
          final boolean _tmpIsFavorit;
          final int _tmp_7;
          _tmp_7 = cursor.getInt(_cursorIndexOfIsFavorit);
          _tmpIsFavorit = _tmp_7 != 0;
          final boolean _tmpIsAvailable;
          final int _tmp_8;
          _tmp_8 = cursor.getInt(_cursorIndexOfIsAvailable);
          _tmpIsAvailable = _tmp_8 != 0;
          final boolean _tmpIsVariant;
          final int _tmp_9;
          _tmp_9 = cursor.getInt(_cursorIndexOfIsVariant);
          _tmpIsVariant = _tmp_9 != 0;
          final String _tmpVCode;
          if (cursor.isNull(_cursorIndexOfVCode)) {
            _tmpVCode = null;
          } else {
            _tmpVCode = cursor.getString(_cursorIndexOfVCode);
          }
          final String _tmpVColor;
          if (cursor.isNull(_cursorIndexOfVColor)) {
            _tmpVColor = null;
          } else {
            _tmpVColor = cursor.getString(_cursorIndexOfVColor);
          }
          _item = new ItemEntity(_tmpId,_tmpCode,_tmpName1,_tmpBrandId,_tmpItemTypeCode,_tmpUsePid,_tmpUniquePid,_tmpItemGrpId,_tmpIsStock,_tmpIsSale,_tmpUnitdesc,_tmpNote,_tmpActive,_tmpSaleUnit,_tmpStockUnit,_tmpQty,_tmpIsPos,_tmpType,_tmpIsFavorit,_tmpIsAvailable,_tmpIsVariant,_tmpVCode,_tmpVColor);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @Override
  public PagingSource<Integer, ItemEntity> getItemByItemGrpPagedList(final int itemGrpId,
      final String query, final boolean usePid) {
    final String _sql = "SELECT * FROM item WHERE ispos = 1 AND active = 1 AND name1 LIKE '%' || ? || '%' AND itemgrp1_id = ? AND is_variant = 0 AND usepid = ? AND id NOT IN (SELECT item_id FROM item_variant) AND id NOT IN (SELECT item_id FROM item_branch) UNION SELECT id, code, name as name1, '' as brand_id, '' as itemtype_code, 0 as usepid, 0 as uniqepid, itgrp_id as itemgrp1_id, 0 as isstock, 1 as issale, '' as unitdesc, '' as note, 1 as active, 0 as saleunit, 0 as stockunit, 0 as itemqty, 1 as ispos, '' as type, 0 as favorit, isavailable as is_available, '1' as is_variant, '' as vcode, '' as vcolor from variant WHERE name1 LIKE '%' || ? || '%' AND itemgrp1_id = ? ORDER BY name1 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 5);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, itemGrpId);
    _argIndex = 3;
    final int _tmp = usePid ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    _argIndex = 4;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 5;
    _statement.bindLong(_argIndex, itemGrpId);
    return new LimitOffsetPagingSource<ItemEntity>(_statement, __db, "item", "item_variant", "item_branch", "variant") {
      @Override
      protected List<ItemEntity> convertRows(Cursor cursor) {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(cursor, "code");
        final int _cursorIndexOfName1 = CursorUtil.getColumnIndexOrThrow(cursor, "name1");
        final int _cursorIndexOfBrandId = CursorUtil.getColumnIndexOrThrow(cursor, "brand_id");
        final int _cursorIndexOfItemTypeCode = CursorUtil.getColumnIndexOrThrow(cursor, "itemtype_code");
        final int _cursorIndexOfUsePid = CursorUtil.getColumnIndexOrThrow(cursor, "usepid");
        final int _cursorIndexOfUniquePid = CursorUtil.getColumnIndexOrThrow(cursor, "uniquepid");
        final int _cursorIndexOfItemGrpId = CursorUtil.getColumnIndexOrThrow(cursor, "itemgrp1_id");
        final int _cursorIndexOfIsStock = CursorUtil.getColumnIndexOrThrow(cursor, "isstock");
        final int _cursorIndexOfIsSale = CursorUtil.getColumnIndexOrThrow(cursor, "issale");
        final int _cursorIndexOfUnitdesc = CursorUtil.getColumnIndexOrThrow(cursor, "unitdesc");
        final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(cursor, "note");
        final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(cursor, "active");
        final int _cursorIndexOfSaleUnit = CursorUtil.getColumnIndexOrThrow(cursor, "saleunit");
        final int _cursorIndexOfStockUnit = CursorUtil.getColumnIndexOrThrow(cursor, "stockunit");
        final int _cursorIndexOfQty = CursorUtil.getColumnIndexOrThrow(cursor, "itemqty");
        final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(cursor, "ispos");
        final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(cursor, "type");
        final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(cursor, "favorit");
        final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(cursor, "is_available");
        final int _cursorIndexOfIsVariant = CursorUtil.getColumnIndexOrThrow(cursor, "is_variant");
        final int _cursorIndexOfVCode = CursorUtil.getColumnIndexOrThrow(cursor, "vcode");
        final int _cursorIndexOfVColor = CursorUtil.getColumnIndexOrThrow(cursor, "vcolor");
        final List<ItemEntity> _result = new ArrayList<ItemEntity>(cursor.getCount());
        while(cursor.moveToNext()) {
          final ItemEntity _item;
          final int _tmpId;
          _tmpId = cursor.getInt(_cursorIndexOfId);
          final String _tmpCode;
          if (cursor.isNull(_cursorIndexOfCode)) {
            _tmpCode = null;
          } else {
            _tmpCode = cursor.getString(_cursorIndexOfCode);
          }
          final String _tmpName1;
          if (cursor.isNull(_cursorIndexOfName1)) {
            _tmpName1 = null;
          } else {
            _tmpName1 = cursor.getString(_cursorIndexOfName1);
          }
          final Integer _tmpBrandId;
          if (cursor.isNull(_cursorIndexOfBrandId)) {
            _tmpBrandId = null;
          } else {
            _tmpBrandId = cursor.getInt(_cursorIndexOfBrandId);
          }
          final String _tmpItemTypeCode;
          if (cursor.isNull(_cursorIndexOfItemTypeCode)) {
            _tmpItemTypeCode = null;
          } else {
            _tmpItemTypeCode = cursor.getString(_cursorIndexOfItemTypeCode);
          }
          final boolean _tmpUsePid;
          final int _tmp_1;
          _tmp_1 = cursor.getInt(_cursorIndexOfUsePid);
          _tmpUsePid = _tmp_1 != 0;
          final boolean _tmpUniquePid;
          final int _tmp_2;
          _tmp_2 = cursor.getInt(_cursorIndexOfUniquePid);
          _tmpUniquePid = _tmp_2 != 0;
          final Integer _tmpItemGrpId;
          if (cursor.isNull(_cursorIndexOfItemGrpId)) {
            _tmpItemGrpId = null;
          } else {
            _tmpItemGrpId = cursor.getInt(_cursorIndexOfItemGrpId);
          }
          final boolean _tmpIsStock;
          final int _tmp_3;
          _tmp_3 = cursor.getInt(_cursorIndexOfIsStock);
          _tmpIsStock = _tmp_3 != 0;
          final boolean _tmpIsSale;
          final int _tmp_4;
          _tmp_4 = cursor.getInt(_cursorIndexOfIsSale);
          _tmpIsSale = _tmp_4 != 0;
          final String _tmpUnitdesc;
          if (cursor.isNull(_cursorIndexOfUnitdesc)) {
            _tmpUnitdesc = null;
          } else {
            _tmpUnitdesc = cursor.getString(_cursorIndexOfUnitdesc);
          }
          final String _tmpNote;
          if (cursor.isNull(_cursorIndexOfNote)) {
            _tmpNote = null;
          } else {
            _tmpNote = cursor.getString(_cursorIndexOfNote);
          }
          final boolean _tmpActive;
          final int _tmp_5;
          _tmp_5 = cursor.getInt(_cursorIndexOfActive);
          _tmpActive = _tmp_5 != 0;
          final Integer _tmpSaleUnit;
          if (cursor.isNull(_cursorIndexOfSaleUnit)) {
            _tmpSaleUnit = null;
          } else {
            _tmpSaleUnit = cursor.getInt(_cursorIndexOfSaleUnit);
          }
          final Integer _tmpStockUnit;
          if (cursor.isNull(_cursorIndexOfStockUnit)) {
            _tmpStockUnit = null;
          } else {
            _tmpStockUnit = cursor.getInt(_cursorIndexOfStockUnit);
          }
          final BigDecimal _tmpQty;
          final String _tmp_6;
          if (cursor.isNull(_cursorIndexOfQty)) {
            _tmp_6 = null;
          } else {
            _tmp_6 = cursor.getString(_cursorIndexOfQty);
          }
          _tmpQty = __converters.stringToBigDecimal(_tmp_6);
          final boolean _tmpIsPos;
          final int _tmp_7;
          _tmp_7 = cursor.getInt(_cursorIndexOfIsPos);
          _tmpIsPos = _tmp_7 != 0;
          final String _tmpType;
          if (cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = cursor.getString(_cursorIndexOfType);
          }
          final boolean _tmpIsFavorit;
          final int _tmp_8;
          _tmp_8 = cursor.getInt(_cursorIndexOfIsFavorit);
          _tmpIsFavorit = _tmp_8 != 0;
          final boolean _tmpIsAvailable;
          final int _tmp_9;
          _tmp_9 = cursor.getInt(_cursorIndexOfIsAvailable);
          _tmpIsAvailable = _tmp_9 != 0;
          final boolean _tmpIsVariant;
          final int _tmp_10;
          _tmp_10 = cursor.getInt(_cursorIndexOfIsVariant);
          _tmpIsVariant = _tmp_10 != 0;
          final String _tmpVCode;
          if (cursor.isNull(_cursorIndexOfVCode)) {
            _tmpVCode = null;
          } else {
            _tmpVCode = cursor.getString(_cursorIndexOfVCode);
          }
          final String _tmpVColor;
          if (cursor.isNull(_cursorIndexOfVColor)) {
            _tmpVColor = null;
          } else {
            _tmpVColor = cursor.getString(_cursorIndexOfVColor);
          }
          _item = new ItemEntity(_tmpId,_tmpCode,_tmpName1,_tmpBrandId,_tmpItemTypeCode,_tmpUsePid,_tmpUniquePid,_tmpItemGrpId,_tmpIsStock,_tmpIsSale,_tmpUnitdesc,_tmpNote,_tmpActive,_tmpSaleUnit,_tmpStockUnit,_tmpQty,_tmpIsPos,_tmpType,_tmpIsFavorit,_tmpIsAvailable,_tmpIsVariant,_tmpVCode,_tmpVColor);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @Override
  public PagingSource<Integer, ItemEntity> getItemByItemGrpPagedListPid(final int itemGrpId,
      final String query) {
    final String _sql = "SELECT * FROM item WHERE ispos = 1 AND active = 1 AND name1 LIKE '%' || ? || '%' AND itemgrp1_id = ? AND is_variant = 0 AND id NOT IN (SELECT item_id FROM item_variant) AND id NOT IN (SELECT item_id FROM item_branch) UNION SELECT id, code, name as name1, '' as brand_id, '' as itemtype_code, 0 as usepid, 0 as uniqepid, itgrp_id as itemgrp1_id, 0 as isstock, 1 as issale, '' as unitdesc, '' as note, 1 as active, 0 as saleunit, 0 as stockunit, 0 as itemqty, 1 as ispos, '' as type, 0 as favorit, isavailable as is_available, '1' as is_variant, '' as vcode, '' as vcolor from variant WHERE name1 LIKE '%' || ? || '%' AND itemgrp1_id = ? ORDER BY name1 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, itemGrpId);
    _argIndex = 3;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 4;
    _statement.bindLong(_argIndex, itemGrpId);
    return new LimitOffsetPagingSource<ItemEntity>(_statement, __db, "item", "item_variant", "item_branch", "variant") {
      @Override
      protected List<ItemEntity> convertRows(Cursor cursor) {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(cursor, "code");
        final int _cursorIndexOfName1 = CursorUtil.getColumnIndexOrThrow(cursor, "name1");
        final int _cursorIndexOfBrandId = CursorUtil.getColumnIndexOrThrow(cursor, "brand_id");
        final int _cursorIndexOfItemTypeCode = CursorUtil.getColumnIndexOrThrow(cursor, "itemtype_code");
        final int _cursorIndexOfUsePid = CursorUtil.getColumnIndexOrThrow(cursor, "usepid");
        final int _cursorIndexOfUniquePid = CursorUtil.getColumnIndexOrThrow(cursor, "uniquepid");
        final int _cursorIndexOfItemGrpId = CursorUtil.getColumnIndexOrThrow(cursor, "itemgrp1_id");
        final int _cursorIndexOfIsStock = CursorUtil.getColumnIndexOrThrow(cursor, "isstock");
        final int _cursorIndexOfIsSale = CursorUtil.getColumnIndexOrThrow(cursor, "issale");
        final int _cursorIndexOfUnitdesc = CursorUtil.getColumnIndexOrThrow(cursor, "unitdesc");
        final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(cursor, "note");
        final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(cursor, "active");
        final int _cursorIndexOfSaleUnit = CursorUtil.getColumnIndexOrThrow(cursor, "saleunit");
        final int _cursorIndexOfStockUnit = CursorUtil.getColumnIndexOrThrow(cursor, "stockunit");
        final int _cursorIndexOfQty = CursorUtil.getColumnIndexOrThrow(cursor, "itemqty");
        final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(cursor, "ispos");
        final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(cursor, "type");
        final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(cursor, "favorit");
        final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(cursor, "is_available");
        final int _cursorIndexOfIsVariant = CursorUtil.getColumnIndexOrThrow(cursor, "is_variant");
        final int _cursorIndexOfVCode = CursorUtil.getColumnIndexOrThrow(cursor, "vcode");
        final int _cursorIndexOfVColor = CursorUtil.getColumnIndexOrThrow(cursor, "vcolor");
        final List<ItemEntity> _result = new ArrayList<ItemEntity>(cursor.getCount());
        while(cursor.moveToNext()) {
          final ItemEntity _item;
          final int _tmpId;
          _tmpId = cursor.getInt(_cursorIndexOfId);
          final String _tmpCode;
          if (cursor.isNull(_cursorIndexOfCode)) {
            _tmpCode = null;
          } else {
            _tmpCode = cursor.getString(_cursorIndexOfCode);
          }
          final String _tmpName1;
          if (cursor.isNull(_cursorIndexOfName1)) {
            _tmpName1 = null;
          } else {
            _tmpName1 = cursor.getString(_cursorIndexOfName1);
          }
          final Integer _tmpBrandId;
          if (cursor.isNull(_cursorIndexOfBrandId)) {
            _tmpBrandId = null;
          } else {
            _tmpBrandId = cursor.getInt(_cursorIndexOfBrandId);
          }
          final String _tmpItemTypeCode;
          if (cursor.isNull(_cursorIndexOfItemTypeCode)) {
            _tmpItemTypeCode = null;
          } else {
            _tmpItemTypeCode = cursor.getString(_cursorIndexOfItemTypeCode);
          }
          final boolean _tmpUsePid;
          final int _tmp;
          _tmp = cursor.getInt(_cursorIndexOfUsePid);
          _tmpUsePid = _tmp != 0;
          final boolean _tmpUniquePid;
          final int _tmp_1;
          _tmp_1 = cursor.getInt(_cursorIndexOfUniquePid);
          _tmpUniquePid = _tmp_1 != 0;
          final Integer _tmpItemGrpId;
          if (cursor.isNull(_cursorIndexOfItemGrpId)) {
            _tmpItemGrpId = null;
          } else {
            _tmpItemGrpId = cursor.getInt(_cursorIndexOfItemGrpId);
          }
          final boolean _tmpIsStock;
          final int _tmp_2;
          _tmp_2 = cursor.getInt(_cursorIndexOfIsStock);
          _tmpIsStock = _tmp_2 != 0;
          final boolean _tmpIsSale;
          final int _tmp_3;
          _tmp_3 = cursor.getInt(_cursorIndexOfIsSale);
          _tmpIsSale = _tmp_3 != 0;
          final String _tmpUnitdesc;
          if (cursor.isNull(_cursorIndexOfUnitdesc)) {
            _tmpUnitdesc = null;
          } else {
            _tmpUnitdesc = cursor.getString(_cursorIndexOfUnitdesc);
          }
          final String _tmpNote;
          if (cursor.isNull(_cursorIndexOfNote)) {
            _tmpNote = null;
          } else {
            _tmpNote = cursor.getString(_cursorIndexOfNote);
          }
          final boolean _tmpActive;
          final int _tmp_4;
          _tmp_4 = cursor.getInt(_cursorIndexOfActive);
          _tmpActive = _tmp_4 != 0;
          final Integer _tmpSaleUnit;
          if (cursor.isNull(_cursorIndexOfSaleUnit)) {
            _tmpSaleUnit = null;
          } else {
            _tmpSaleUnit = cursor.getInt(_cursorIndexOfSaleUnit);
          }
          final Integer _tmpStockUnit;
          if (cursor.isNull(_cursorIndexOfStockUnit)) {
            _tmpStockUnit = null;
          } else {
            _tmpStockUnit = cursor.getInt(_cursorIndexOfStockUnit);
          }
          final BigDecimal _tmpQty;
          final String _tmp_5;
          if (cursor.isNull(_cursorIndexOfQty)) {
            _tmp_5 = null;
          } else {
            _tmp_5 = cursor.getString(_cursorIndexOfQty);
          }
          _tmpQty = __converters.stringToBigDecimal(_tmp_5);
          final boolean _tmpIsPos;
          final int _tmp_6;
          _tmp_6 = cursor.getInt(_cursorIndexOfIsPos);
          _tmpIsPos = _tmp_6 != 0;
          final String _tmpType;
          if (cursor.isNull(_cursorIndexOfType)) {
            _tmpType = null;
          } else {
            _tmpType = cursor.getString(_cursorIndexOfType);
          }
          final boolean _tmpIsFavorit;
          final int _tmp_7;
          _tmp_7 = cursor.getInt(_cursorIndexOfIsFavorit);
          _tmpIsFavorit = _tmp_7 != 0;
          final boolean _tmpIsAvailable;
          final int _tmp_8;
          _tmp_8 = cursor.getInt(_cursorIndexOfIsAvailable);
          _tmpIsAvailable = _tmp_8 != 0;
          final boolean _tmpIsVariant;
          final int _tmp_9;
          _tmp_9 = cursor.getInt(_cursorIndexOfIsVariant);
          _tmpIsVariant = _tmp_9 != 0;
          final String _tmpVCode;
          if (cursor.isNull(_cursorIndexOfVCode)) {
            _tmpVCode = null;
          } else {
            _tmpVCode = cursor.getString(_cursorIndexOfVCode);
          }
          final String _tmpVColor;
          if (cursor.isNull(_cursorIndexOfVColor)) {
            _tmpVColor = null;
          } else {
            _tmpVColor = cursor.getString(_cursorIndexOfVColor);
          }
          _item = new ItemEntity(_tmpId,_tmpCode,_tmpName1,_tmpBrandId,_tmpItemTypeCode,_tmpUsePid,_tmpUniquePid,_tmpItemGrpId,_tmpIsStock,_tmpIsSale,_tmpUnitdesc,_tmpNote,_tmpActive,_tmpSaleUnit,_tmpStockUnit,_tmpQty,_tmpIsPos,_tmpType,_tmpIsFavorit,_tmpIsAvailable,_tmpIsVariant,_tmpVCode,_tmpVColor);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @Override
  public List<ItemEntity> getItemBySelection(final int selectionId) {
    final String _sql = "SELECT a.* FROM item a JOIN selectiond b ON b.item_id = a.id WHERE b.selection_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, selectionId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName1 = CursorUtil.getColumnIndexOrThrow(_cursor, "name1");
      final int _cursorIndexOfBrandId = CursorUtil.getColumnIndexOrThrow(_cursor, "brand_id");
      final int _cursorIndexOfItemTypeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemtype_code");
      final int _cursorIndexOfUsePid = CursorUtil.getColumnIndexOrThrow(_cursor, "usepid");
      final int _cursorIndexOfUniquePid = CursorUtil.getColumnIndexOrThrow(_cursor, "uniquepid");
      final int _cursorIndexOfItemGrpId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemgrp1_id");
      final int _cursorIndexOfIsStock = CursorUtil.getColumnIndexOrThrow(_cursor, "isstock");
      final int _cursorIndexOfIsSale = CursorUtil.getColumnIndexOrThrow(_cursor, "issale");
      final int _cursorIndexOfUnitdesc = CursorUtil.getColumnIndexOrThrow(_cursor, "unitdesc");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfSaleUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "saleunit");
      final int _cursorIndexOfStockUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "stockunit");
      final int _cursorIndexOfQty = CursorUtil.getColumnIndexOrThrow(_cursor, "itemqty");
      final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(_cursor, "ispos");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(_cursor, "favorit");
      final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "is_available");
      final int _cursorIndexOfIsVariant = CursorUtil.getColumnIndexOrThrow(_cursor, "is_variant");
      final int _cursorIndexOfVCode = CursorUtil.getColumnIndexOrThrow(_cursor, "vcode");
      final int _cursorIndexOfVColor = CursorUtil.getColumnIndexOrThrow(_cursor, "vcolor");
      final List<ItemEntity> _result = new ArrayList<ItemEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpName1;
        if (_cursor.isNull(_cursorIndexOfName1)) {
          _tmpName1 = null;
        } else {
          _tmpName1 = _cursor.getString(_cursorIndexOfName1);
        }
        final Integer _tmpBrandId;
        if (_cursor.isNull(_cursorIndexOfBrandId)) {
          _tmpBrandId = null;
        } else {
          _tmpBrandId = _cursor.getInt(_cursorIndexOfBrandId);
        }
        final String _tmpItemTypeCode;
        if (_cursor.isNull(_cursorIndexOfItemTypeCode)) {
          _tmpItemTypeCode = null;
        } else {
          _tmpItemTypeCode = _cursor.getString(_cursorIndexOfItemTypeCode);
        }
        final boolean _tmpUsePid;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfUsePid);
        _tmpUsePid = _tmp != 0;
        final boolean _tmpUniquePid;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfUniquePid);
        _tmpUniquePid = _tmp_1 != 0;
        final Integer _tmpItemGrpId;
        if (_cursor.isNull(_cursorIndexOfItemGrpId)) {
          _tmpItemGrpId = null;
        } else {
          _tmpItemGrpId = _cursor.getInt(_cursorIndexOfItemGrpId);
        }
        final boolean _tmpIsStock;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsStock);
        _tmpIsStock = _tmp_2 != 0;
        final boolean _tmpIsSale;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfIsSale);
        _tmpIsSale = _tmp_3 != 0;
        final String _tmpUnitdesc;
        if (_cursor.isNull(_cursorIndexOfUnitdesc)) {
          _tmpUnitdesc = null;
        } else {
          _tmpUnitdesc = _cursor.getString(_cursorIndexOfUnitdesc);
        }
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final boolean _tmpActive;
        final int _tmp_4;
        _tmp_4 = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp_4 != 0;
        final Integer _tmpSaleUnit;
        if (_cursor.isNull(_cursorIndexOfSaleUnit)) {
          _tmpSaleUnit = null;
        } else {
          _tmpSaleUnit = _cursor.getInt(_cursorIndexOfSaleUnit);
        }
        final Integer _tmpStockUnit;
        if (_cursor.isNull(_cursorIndexOfStockUnit)) {
          _tmpStockUnit = null;
        } else {
          _tmpStockUnit = _cursor.getInt(_cursorIndexOfStockUnit);
        }
        final BigDecimal _tmpQty;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfQty)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfQty);
        }
        _tmpQty = __converters.stringToBigDecimal(_tmp_5);
        final boolean _tmpIsPos;
        final int _tmp_6;
        _tmp_6 = _cursor.getInt(_cursorIndexOfIsPos);
        _tmpIsPos = _tmp_6 != 0;
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        final boolean _tmpIsFavorit;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsFavorit);
        _tmpIsFavorit = _tmp_7 != 0;
        final boolean _tmpIsAvailable;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsAvailable);
        _tmpIsAvailable = _tmp_8 != 0;
        final boolean _tmpIsVariant;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsVariant);
        _tmpIsVariant = _tmp_9 != 0;
        final String _tmpVCode;
        if (_cursor.isNull(_cursorIndexOfVCode)) {
          _tmpVCode = null;
        } else {
          _tmpVCode = _cursor.getString(_cursorIndexOfVCode);
        }
        final String _tmpVColor;
        if (_cursor.isNull(_cursorIndexOfVColor)) {
          _tmpVColor = null;
        } else {
          _tmpVColor = _cursor.getString(_cursorIndexOfVColor);
        }
        _item = new ItemEntity(_tmpId,_tmpCode,_tmpName1,_tmpBrandId,_tmpItemTypeCode,_tmpUsePid,_tmpUniquePid,_tmpItemGrpId,_tmpIsStock,_tmpIsSale,_tmpUnitdesc,_tmpNote,_tmpActive,_tmpSaleUnit,_tmpStockUnit,_tmpQty,_tmpIsPos,_tmpType,_tmpIsFavorit,_tmpIsAvailable,_tmpIsVariant,_tmpVCode,_tmpVColor);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemEntity> getItemByVariant(final int variantId) {
    final String _sql = "SELECT a.* FROM item a JOIN item_variant b ON b.item_id = a.id WHERE b.variant_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, variantId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName1 = CursorUtil.getColumnIndexOrThrow(_cursor, "name1");
      final int _cursorIndexOfBrandId = CursorUtil.getColumnIndexOrThrow(_cursor, "brand_id");
      final int _cursorIndexOfItemTypeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemtype_code");
      final int _cursorIndexOfUsePid = CursorUtil.getColumnIndexOrThrow(_cursor, "usepid");
      final int _cursorIndexOfUniquePid = CursorUtil.getColumnIndexOrThrow(_cursor, "uniquepid");
      final int _cursorIndexOfItemGrpId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemgrp1_id");
      final int _cursorIndexOfIsStock = CursorUtil.getColumnIndexOrThrow(_cursor, "isstock");
      final int _cursorIndexOfIsSale = CursorUtil.getColumnIndexOrThrow(_cursor, "issale");
      final int _cursorIndexOfUnitdesc = CursorUtil.getColumnIndexOrThrow(_cursor, "unitdesc");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfSaleUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "saleunit");
      final int _cursorIndexOfStockUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "stockunit");
      final int _cursorIndexOfQty = CursorUtil.getColumnIndexOrThrow(_cursor, "itemqty");
      final int _cursorIndexOfIsPos = CursorUtil.getColumnIndexOrThrow(_cursor, "ispos");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfIsFavorit = CursorUtil.getColumnIndexOrThrow(_cursor, "favorit");
      final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "is_available");
      final int _cursorIndexOfIsVariant = CursorUtil.getColumnIndexOrThrow(_cursor, "is_variant");
      final int _cursorIndexOfVCode = CursorUtil.getColumnIndexOrThrow(_cursor, "vcode");
      final int _cursorIndexOfVColor = CursorUtil.getColumnIndexOrThrow(_cursor, "vcolor");
      final List<ItemEntity> _result = new ArrayList<ItemEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpName1;
        if (_cursor.isNull(_cursorIndexOfName1)) {
          _tmpName1 = null;
        } else {
          _tmpName1 = _cursor.getString(_cursorIndexOfName1);
        }
        final Integer _tmpBrandId;
        if (_cursor.isNull(_cursorIndexOfBrandId)) {
          _tmpBrandId = null;
        } else {
          _tmpBrandId = _cursor.getInt(_cursorIndexOfBrandId);
        }
        final String _tmpItemTypeCode;
        if (_cursor.isNull(_cursorIndexOfItemTypeCode)) {
          _tmpItemTypeCode = null;
        } else {
          _tmpItemTypeCode = _cursor.getString(_cursorIndexOfItemTypeCode);
        }
        final boolean _tmpUsePid;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfUsePid);
        _tmpUsePid = _tmp != 0;
        final boolean _tmpUniquePid;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfUniquePid);
        _tmpUniquePid = _tmp_1 != 0;
        final Integer _tmpItemGrpId;
        if (_cursor.isNull(_cursorIndexOfItemGrpId)) {
          _tmpItemGrpId = null;
        } else {
          _tmpItemGrpId = _cursor.getInt(_cursorIndexOfItemGrpId);
        }
        final boolean _tmpIsStock;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsStock);
        _tmpIsStock = _tmp_2 != 0;
        final boolean _tmpIsSale;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfIsSale);
        _tmpIsSale = _tmp_3 != 0;
        final String _tmpUnitdesc;
        if (_cursor.isNull(_cursorIndexOfUnitdesc)) {
          _tmpUnitdesc = null;
        } else {
          _tmpUnitdesc = _cursor.getString(_cursorIndexOfUnitdesc);
        }
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final boolean _tmpActive;
        final int _tmp_4;
        _tmp_4 = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp_4 != 0;
        final Integer _tmpSaleUnit;
        if (_cursor.isNull(_cursorIndexOfSaleUnit)) {
          _tmpSaleUnit = null;
        } else {
          _tmpSaleUnit = _cursor.getInt(_cursorIndexOfSaleUnit);
        }
        final Integer _tmpStockUnit;
        if (_cursor.isNull(_cursorIndexOfStockUnit)) {
          _tmpStockUnit = null;
        } else {
          _tmpStockUnit = _cursor.getInt(_cursorIndexOfStockUnit);
        }
        final BigDecimal _tmpQty;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfQty)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfQty);
        }
        _tmpQty = __converters.stringToBigDecimal(_tmp_5);
        final boolean _tmpIsPos;
        final int _tmp_6;
        _tmp_6 = _cursor.getInt(_cursorIndexOfIsPos);
        _tmpIsPos = _tmp_6 != 0;
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        final boolean _tmpIsFavorit;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsFavorit);
        _tmpIsFavorit = _tmp_7 != 0;
        final boolean _tmpIsAvailable;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsAvailable);
        _tmpIsAvailable = _tmp_8 != 0;
        final boolean _tmpIsVariant;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsVariant);
        _tmpIsVariant = _tmp_9 != 0;
        final String _tmpVCode;
        if (_cursor.isNull(_cursorIndexOfVCode)) {
          _tmpVCode = null;
        } else {
          _tmpVCode = _cursor.getString(_cursorIndexOfVCode);
        }
        final String _tmpVColor;
        if (_cursor.isNull(_cursorIndexOfVColor)) {
          _tmpVColor = null;
        } else {
          _tmpVColor = _cursor.getString(_cursorIndexOfVColor);
        }
        _item = new ItemEntity(_tmpId,_tmpCode,_tmpName1,_tmpBrandId,_tmpItemTypeCode,_tmpUsePid,_tmpUniquePid,_tmpItemGrpId,_tmpIsStock,_tmpIsSale,_tmpUnitdesc,_tmpNote,_tmpActive,_tmpSaleUnit,_tmpStockUnit,_tmpQty,_tmpIsPos,_tmpType,_tmpIsFavorit,_tmpIsAvailable,_tmpIsVariant,_tmpVCode,_tmpVColor);
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
