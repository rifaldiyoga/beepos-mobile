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
import com.bits.bee.bpmc.data.data_source.local.model.PromoEntity;
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
public final class PromoDao_Impl implements PromoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PromoEntity> __insertionAdapterOfPromoEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<PromoEntity> __deletionAdapterOfPromoEntity;

  private final EntityDeletionOrUpdateAdapter<PromoEntity> __updateAdapterOfPromoEntity;

  public PromoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPromoEntity = new EntityInsertionAdapter<PromoEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `promo` (`id`,`isactive`,`isbranch`,`branchid`,`isperiode`,`startdate`,`enddate`,`istime`,`starttime`,`endtime`,`isdow`,`dowexp`,`isbpgrp`,`offertype`,`minamt`,`istargetitem`,`itemid`,`istargetitgrp`,`itgrpid`,`istargetbrand`,`brandid`,`istargetvendor`,`vendorid`,`isminqty`,`minqty`,`priority`,`isminamt`,`note`,`code`,`promotype`,`name`,`itemdiscexp`,`promo_cat`,`ispriceoveride`,`deal_itemid`,`itemprice`,`isminqtymultiply`,`ismaxqty`,`maxqty`,`isused`,`ison`,`ismulti`,`deal_qty`,`isdealsameitem`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PromoEntity value) {
        stmt.bindLong(1, value.getId());
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(2, _tmp);
        final int _tmp_1 = value.isBranch() ? 1 : 0;
        stmt.bindLong(3, _tmp_1);
        if (value.getBranchId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getBranchId());
        }
        final int _tmp_2 = value.isPeriod() ? 1 : 0;
        stmt.bindLong(5, _tmp_2);
        if (value.getStartDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStartDate());
        }
        if (value.getEndDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEndDate());
        }
        final int _tmp_3 = value.isTime() ? 1 : 0;
        stmt.bindLong(8, _tmp_3);
        if (value.getStartTime() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStartTime());
        }
        if (value.getEndTime() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getEndTime());
        }
        final int _tmp_4 = value.isDow() ? 1 : 0;
        stmt.bindLong(11, _tmp_4);
        if (value.getDowExp() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getDowExp());
        }
        final int _tmp_5 = value.isBpgrp() ? 1 : 0;
        stmt.bindLong(13, _tmp_5);
        if (value.getOfferType() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getOfferType());
        }
        final String _tmp_6 = __converters.bigDecimalToString(value.getMinAmt());
        if (_tmp_6 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, _tmp_6);
        }
        final int _tmp_7 = value.isTargetItem() ? 1 : 0;
        stmt.bindLong(16, _tmp_7);
        if (value.getItemId() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, value.getItemId());
        }
        final int _tmp_8 = value.isTargetItgrp() ? 1 : 0;
        stmt.bindLong(18, _tmp_8);
        if (value.getItgrpId() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, value.getItgrpId());
        }
        final int _tmp_9 = value.isTargetBrand() ? 1 : 0;
        stmt.bindLong(20, _tmp_9);
        if (value.getBrandId() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindLong(21, value.getBrandId());
        }
        final int _tmp_10 = value.isTargetVendor() ? 1 : 0;
        stmt.bindLong(22, _tmp_10);
        if (value.getVendorId() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindLong(23, value.getVendorId());
        }
        final int _tmp_11 = value.isMinQty() ? 1 : 0;
        stmt.bindLong(24, _tmp_11);
        final String _tmp_12 = __converters.bigDecimalToString(value.getMinQty());
        if (_tmp_12 == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, _tmp_12);
        }
        stmt.bindLong(26, value.getPriority());
        final int _tmp_13 = value.isMinAmt() ? 1 : 0;
        stmt.bindLong(27, _tmp_13);
        if (value.getNote() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getNote());
        }
        if (value.getCode() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getCode());
        }
        if (value.getPromoType() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getPromoType());
        }
        if (value.getPromoName() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getPromoName());
        }
        if (value.getItemDiscExp() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getItemDiscExp());
        }
        if (value.getPromoCat() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getPromoCat());
        }
        final int _tmp_14 = value.isPriceOveride() ? 1 : 0;
        stmt.bindLong(34, _tmp_14);
        if (value.getDealItemId() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindLong(35, value.getDealItemId());
        }
        final String _tmp_15 = __converters.bigDecimalToString(value.getItemPrice());
        if (_tmp_15 == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, _tmp_15);
        }
        final int _tmp_16 = value.isMinQtyMultiply() ? 1 : 0;
        stmt.bindLong(37, _tmp_16);
        final int _tmp_17 = value.isMaxQty() ? 1 : 0;
        stmt.bindLong(38, _tmp_17);
        final String _tmp_18 = __converters.bigDecimalToString(value.getMaxQty());
        if (_tmp_18 == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindString(39, _tmp_18);
        }
        final int _tmp_19 = value.isUsed() ? 1 : 0;
        stmt.bindLong(40, _tmp_19);
        final int _tmp_20 = value.isOn() ? 1 : 0;
        stmt.bindLong(41, _tmp_20);
        final int _tmp_21 = value.isMulti() ? 1 : 0;
        stmt.bindLong(42, _tmp_21);
        final String _tmp_22 = __converters.bigDecimalToString(value.getDealQty());
        if (_tmp_22 == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindString(43, _tmp_22);
        }
        final int _tmp_23 = value.isDealSameItem() ? 1 : 0;
        stmt.bindLong(44, _tmp_23);
      }
    };
    this.__deletionAdapterOfPromoEntity = new EntityDeletionOrUpdateAdapter<PromoEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `promo` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PromoEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPromoEntity = new EntityDeletionOrUpdateAdapter<PromoEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `promo` SET `id` = ?,`isactive` = ?,`isbranch` = ?,`branchid` = ?,`isperiode` = ?,`startdate` = ?,`enddate` = ?,`istime` = ?,`starttime` = ?,`endtime` = ?,`isdow` = ?,`dowexp` = ?,`isbpgrp` = ?,`offertype` = ?,`minamt` = ?,`istargetitem` = ?,`itemid` = ?,`istargetitgrp` = ?,`itgrpid` = ?,`istargetbrand` = ?,`brandid` = ?,`istargetvendor` = ?,`vendorid` = ?,`isminqty` = ?,`minqty` = ?,`priority` = ?,`isminamt` = ?,`note` = ?,`code` = ?,`promotype` = ?,`name` = ?,`itemdiscexp` = ?,`promo_cat` = ?,`ispriceoveride` = ?,`deal_itemid` = ?,`itemprice` = ?,`isminqtymultiply` = ?,`ismaxqty` = ?,`maxqty` = ?,`isused` = ?,`ison` = ?,`ismulti` = ?,`deal_qty` = ?,`isdealsameitem` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PromoEntity value) {
        stmt.bindLong(1, value.getId());
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(2, _tmp);
        final int _tmp_1 = value.isBranch() ? 1 : 0;
        stmt.bindLong(3, _tmp_1);
        if (value.getBranchId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getBranchId());
        }
        final int _tmp_2 = value.isPeriod() ? 1 : 0;
        stmt.bindLong(5, _tmp_2);
        if (value.getStartDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStartDate());
        }
        if (value.getEndDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEndDate());
        }
        final int _tmp_3 = value.isTime() ? 1 : 0;
        stmt.bindLong(8, _tmp_3);
        if (value.getStartTime() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStartTime());
        }
        if (value.getEndTime() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getEndTime());
        }
        final int _tmp_4 = value.isDow() ? 1 : 0;
        stmt.bindLong(11, _tmp_4);
        if (value.getDowExp() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getDowExp());
        }
        final int _tmp_5 = value.isBpgrp() ? 1 : 0;
        stmt.bindLong(13, _tmp_5);
        if (value.getOfferType() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getOfferType());
        }
        final String _tmp_6 = __converters.bigDecimalToString(value.getMinAmt());
        if (_tmp_6 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, _tmp_6);
        }
        final int _tmp_7 = value.isTargetItem() ? 1 : 0;
        stmt.bindLong(16, _tmp_7);
        if (value.getItemId() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, value.getItemId());
        }
        final int _tmp_8 = value.isTargetItgrp() ? 1 : 0;
        stmt.bindLong(18, _tmp_8);
        if (value.getItgrpId() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, value.getItgrpId());
        }
        final int _tmp_9 = value.isTargetBrand() ? 1 : 0;
        stmt.bindLong(20, _tmp_9);
        if (value.getBrandId() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindLong(21, value.getBrandId());
        }
        final int _tmp_10 = value.isTargetVendor() ? 1 : 0;
        stmt.bindLong(22, _tmp_10);
        if (value.getVendorId() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindLong(23, value.getVendorId());
        }
        final int _tmp_11 = value.isMinQty() ? 1 : 0;
        stmt.bindLong(24, _tmp_11);
        final String _tmp_12 = __converters.bigDecimalToString(value.getMinQty());
        if (_tmp_12 == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, _tmp_12);
        }
        stmt.bindLong(26, value.getPriority());
        final int _tmp_13 = value.isMinAmt() ? 1 : 0;
        stmt.bindLong(27, _tmp_13);
        if (value.getNote() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getNote());
        }
        if (value.getCode() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getCode());
        }
        if (value.getPromoType() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getPromoType());
        }
        if (value.getPromoName() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getPromoName());
        }
        if (value.getItemDiscExp() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getItemDiscExp());
        }
        if (value.getPromoCat() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getPromoCat());
        }
        final int _tmp_14 = value.isPriceOveride() ? 1 : 0;
        stmt.bindLong(34, _tmp_14);
        if (value.getDealItemId() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindLong(35, value.getDealItemId());
        }
        final String _tmp_15 = __converters.bigDecimalToString(value.getItemPrice());
        if (_tmp_15 == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, _tmp_15);
        }
        final int _tmp_16 = value.isMinQtyMultiply() ? 1 : 0;
        stmt.bindLong(37, _tmp_16);
        final int _tmp_17 = value.isMaxQty() ? 1 : 0;
        stmt.bindLong(38, _tmp_17);
        final String _tmp_18 = __converters.bigDecimalToString(value.getMaxQty());
        if (_tmp_18 == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindString(39, _tmp_18);
        }
        final int _tmp_19 = value.isUsed() ? 1 : 0;
        stmt.bindLong(40, _tmp_19);
        final int _tmp_20 = value.isOn() ? 1 : 0;
        stmt.bindLong(41, _tmp_20);
        final int _tmp_21 = value.isMulti() ? 1 : 0;
        stmt.bindLong(42, _tmp_21);
        final String _tmp_22 = __converters.bigDecimalToString(value.getDealQty());
        if (_tmp_22 == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindString(43, _tmp_22);
        }
        final int _tmp_23 = value.isDealSameItem() ? 1 : 0;
        stmt.bindLong(44, _tmp_23);
        stmt.bindLong(45, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends PromoEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final PromoEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends PromoEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPromoEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final PromoEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPromoEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final PromoEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPromoEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<PromoEntity> getPromoList() {
    final String _sql = "SELECT * FROM promo WH";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isactive");
      final int _cursorIndexOfIsBranch = CursorUtil.getColumnIndexOrThrow(_cursor, "isbranch");
      final int _cursorIndexOfBranchId = CursorUtil.getColumnIndexOrThrow(_cursor, "branchid");
      final int _cursorIndexOfIsPeriod = CursorUtil.getColumnIndexOrThrow(_cursor, "isperiode");
      final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "startdate");
      final int _cursorIndexOfEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "enddate");
      final int _cursorIndexOfIsTime = CursorUtil.getColumnIndexOrThrow(_cursor, "istime");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "starttime");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endtime");
      final int _cursorIndexOfIsDow = CursorUtil.getColumnIndexOrThrow(_cursor, "isdow");
      final int _cursorIndexOfDowExp = CursorUtil.getColumnIndexOrThrow(_cursor, "dowexp");
      final int _cursorIndexOfIsBpgrp = CursorUtil.getColumnIndexOrThrow(_cursor, "isbpgrp");
      final int _cursorIndexOfOfferType = CursorUtil.getColumnIndexOrThrow(_cursor, "offertype");
      final int _cursorIndexOfMinAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "minamt");
      final int _cursorIndexOfIsTargetItem = CursorUtil.getColumnIndexOrThrow(_cursor, "istargetitem");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemid");
      final int _cursorIndexOfIsTargetItgrp = CursorUtil.getColumnIndexOrThrow(_cursor, "istargetitgrp");
      final int _cursorIndexOfItgrpId = CursorUtil.getColumnIndexOrThrow(_cursor, "itgrpid");
      final int _cursorIndexOfIsTargetBrand = CursorUtil.getColumnIndexOrThrow(_cursor, "istargetbrand");
      final int _cursorIndexOfBrandId = CursorUtil.getColumnIndexOrThrow(_cursor, "brandid");
      final int _cursorIndexOfIsTargetVendor = CursorUtil.getColumnIndexOrThrow(_cursor, "istargetvendor");
      final int _cursorIndexOfVendorId = CursorUtil.getColumnIndexOrThrow(_cursor, "vendorid");
      final int _cursorIndexOfIsMinQty = CursorUtil.getColumnIndexOrThrow(_cursor, "isminqty");
      final int _cursorIndexOfMinQty = CursorUtil.getColumnIndexOrThrow(_cursor, "minqty");
      final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
      final int _cursorIndexOfIsMinAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "isminamt");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfPromoType = CursorUtil.getColumnIndexOrThrow(_cursor, "promotype");
      final int _cursorIndexOfPromoName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfItemDiscExp = CursorUtil.getColumnIndexOrThrow(_cursor, "itemdiscexp");
      final int _cursorIndexOfPromoCat = CursorUtil.getColumnIndexOrThrow(_cursor, "promo_cat");
      final int _cursorIndexOfIsPriceOveride = CursorUtil.getColumnIndexOrThrow(_cursor, "ispriceoveride");
      final int _cursorIndexOfDealItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "deal_itemid");
      final int _cursorIndexOfItemPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "itemprice");
      final int _cursorIndexOfIsMinQtyMultiply = CursorUtil.getColumnIndexOrThrow(_cursor, "isminqtymultiply");
      final int _cursorIndexOfIsMaxQty = CursorUtil.getColumnIndexOrThrow(_cursor, "ismaxqty");
      final int _cursorIndexOfMaxQty = CursorUtil.getColumnIndexOrThrow(_cursor, "maxqty");
      final int _cursorIndexOfIsUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "isused");
      final int _cursorIndexOfIsOn = CursorUtil.getColumnIndexOrThrow(_cursor, "ison");
      final int _cursorIndexOfIsMulti = CursorUtil.getColumnIndexOrThrow(_cursor, "ismulti");
      final int _cursorIndexOfDealQty = CursorUtil.getColumnIndexOrThrow(_cursor, "deal_qty");
      final int _cursorIndexOfIsDealSameItem = CursorUtil.getColumnIndexOrThrow(_cursor, "isdealsameitem");
      final List<PromoEntity> _result = new ArrayList<PromoEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PromoEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        final boolean _tmpIsBranch;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsBranch);
        _tmpIsBranch = _tmp_1 != 0;
        final Integer _tmpBranchId;
        if (_cursor.isNull(_cursorIndexOfBranchId)) {
          _tmpBranchId = null;
        } else {
          _tmpBranchId = _cursor.getInt(_cursorIndexOfBranchId);
        }
        final boolean _tmpIsPeriod;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsPeriod);
        _tmpIsPeriod = _tmp_2 != 0;
        final String _tmpStartDate;
        if (_cursor.isNull(_cursorIndexOfStartDate)) {
          _tmpStartDate = null;
        } else {
          _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
        }
        final String _tmpEndDate;
        if (_cursor.isNull(_cursorIndexOfEndDate)) {
          _tmpEndDate = null;
        } else {
          _tmpEndDate = _cursor.getString(_cursorIndexOfEndDate);
        }
        final boolean _tmpIsTime;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfIsTime);
        _tmpIsTime = _tmp_3 != 0;
        final String _tmpStartTime;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmpStartTime = null;
        } else {
          _tmpStartTime = _cursor.getString(_cursorIndexOfStartTime);
        }
        final String _tmpEndTime;
        if (_cursor.isNull(_cursorIndexOfEndTime)) {
          _tmpEndTime = null;
        } else {
          _tmpEndTime = _cursor.getString(_cursorIndexOfEndTime);
        }
        final boolean _tmpIsDow;
        final int _tmp_4;
        _tmp_4 = _cursor.getInt(_cursorIndexOfIsDow);
        _tmpIsDow = _tmp_4 != 0;
        final String _tmpDowExp;
        if (_cursor.isNull(_cursorIndexOfDowExp)) {
          _tmpDowExp = null;
        } else {
          _tmpDowExp = _cursor.getString(_cursorIndexOfDowExp);
        }
        final boolean _tmpIsBpgrp;
        final int _tmp_5;
        _tmp_5 = _cursor.getInt(_cursorIndexOfIsBpgrp);
        _tmpIsBpgrp = _tmp_5 != 0;
        final String _tmpOfferType;
        if (_cursor.isNull(_cursorIndexOfOfferType)) {
          _tmpOfferType = null;
        } else {
          _tmpOfferType = _cursor.getString(_cursorIndexOfOfferType);
        }
        final BigDecimal _tmpMinAmt;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfMinAmt)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfMinAmt);
        }
        _tmpMinAmt = __converters.stringToBigDecimal(_tmp_6);
        final boolean _tmpIsTargetItem;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsTargetItem);
        _tmpIsTargetItem = _tmp_7 != 0;
        final Integer _tmpItemId;
        if (_cursor.isNull(_cursorIndexOfItemId)) {
          _tmpItemId = null;
        } else {
          _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        }
        final boolean _tmpIsTargetItgrp;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsTargetItgrp);
        _tmpIsTargetItgrp = _tmp_8 != 0;
        final Integer _tmpItgrpId;
        if (_cursor.isNull(_cursorIndexOfItgrpId)) {
          _tmpItgrpId = null;
        } else {
          _tmpItgrpId = _cursor.getInt(_cursorIndexOfItgrpId);
        }
        final boolean _tmpIsTargetBrand;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsTargetBrand);
        _tmpIsTargetBrand = _tmp_9 != 0;
        final Integer _tmpBrandId;
        if (_cursor.isNull(_cursorIndexOfBrandId)) {
          _tmpBrandId = null;
        } else {
          _tmpBrandId = _cursor.getInt(_cursorIndexOfBrandId);
        }
        final boolean _tmpIsTargetVendor;
        final int _tmp_10;
        _tmp_10 = _cursor.getInt(_cursorIndexOfIsTargetVendor);
        _tmpIsTargetVendor = _tmp_10 != 0;
        final Integer _tmpVendorId;
        if (_cursor.isNull(_cursorIndexOfVendorId)) {
          _tmpVendorId = null;
        } else {
          _tmpVendorId = _cursor.getInt(_cursorIndexOfVendorId);
        }
        final boolean _tmpIsMinQty;
        final int _tmp_11;
        _tmp_11 = _cursor.getInt(_cursorIndexOfIsMinQty);
        _tmpIsMinQty = _tmp_11 != 0;
        final BigDecimal _tmpMinQty;
        final String _tmp_12;
        if (_cursor.isNull(_cursorIndexOfMinQty)) {
          _tmp_12 = null;
        } else {
          _tmp_12 = _cursor.getString(_cursorIndexOfMinQty);
        }
        _tmpMinQty = __converters.stringToBigDecimal(_tmp_12);
        final int _tmpPriority;
        _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
        final boolean _tmpIsMinAmt;
        final int _tmp_13;
        _tmp_13 = _cursor.getInt(_cursorIndexOfIsMinAmt);
        _tmpIsMinAmt = _tmp_13 != 0;
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpPromoType;
        if (_cursor.isNull(_cursorIndexOfPromoType)) {
          _tmpPromoType = null;
        } else {
          _tmpPromoType = _cursor.getString(_cursorIndexOfPromoType);
        }
        final String _tmpPromoName;
        if (_cursor.isNull(_cursorIndexOfPromoName)) {
          _tmpPromoName = null;
        } else {
          _tmpPromoName = _cursor.getString(_cursorIndexOfPromoName);
        }
        final String _tmpItemDiscExp;
        if (_cursor.isNull(_cursorIndexOfItemDiscExp)) {
          _tmpItemDiscExp = null;
        } else {
          _tmpItemDiscExp = _cursor.getString(_cursorIndexOfItemDiscExp);
        }
        final String _tmpPromoCat;
        if (_cursor.isNull(_cursorIndexOfPromoCat)) {
          _tmpPromoCat = null;
        } else {
          _tmpPromoCat = _cursor.getString(_cursorIndexOfPromoCat);
        }
        final boolean _tmpIsPriceOveride;
        final int _tmp_14;
        _tmp_14 = _cursor.getInt(_cursorIndexOfIsPriceOveride);
        _tmpIsPriceOveride = _tmp_14 != 0;
        final Integer _tmpDealItemId;
        if (_cursor.isNull(_cursorIndexOfDealItemId)) {
          _tmpDealItemId = null;
        } else {
          _tmpDealItemId = _cursor.getInt(_cursorIndexOfDealItemId);
        }
        final BigDecimal _tmpItemPrice;
        final String _tmp_15;
        if (_cursor.isNull(_cursorIndexOfItemPrice)) {
          _tmp_15 = null;
        } else {
          _tmp_15 = _cursor.getString(_cursorIndexOfItemPrice);
        }
        _tmpItemPrice = __converters.stringToBigDecimal(_tmp_15);
        final boolean _tmpIsMinQtyMultiply;
        final int _tmp_16;
        _tmp_16 = _cursor.getInt(_cursorIndexOfIsMinQtyMultiply);
        _tmpIsMinQtyMultiply = _tmp_16 != 0;
        final boolean _tmpIsMaxQty;
        final int _tmp_17;
        _tmp_17 = _cursor.getInt(_cursorIndexOfIsMaxQty);
        _tmpIsMaxQty = _tmp_17 != 0;
        final BigDecimal _tmpMaxQty;
        final String _tmp_18;
        if (_cursor.isNull(_cursorIndexOfMaxQty)) {
          _tmp_18 = null;
        } else {
          _tmp_18 = _cursor.getString(_cursorIndexOfMaxQty);
        }
        _tmpMaxQty = __converters.stringToBigDecimal(_tmp_18);
        final boolean _tmpIsUsed;
        final int _tmp_19;
        _tmp_19 = _cursor.getInt(_cursorIndexOfIsUsed);
        _tmpIsUsed = _tmp_19 != 0;
        final boolean _tmpIsOn;
        final int _tmp_20;
        _tmp_20 = _cursor.getInt(_cursorIndexOfIsOn);
        _tmpIsOn = _tmp_20 != 0;
        final boolean _tmpIsMulti;
        final int _tmp_21;
        _tmp_21 = _cursor.getInt(_cursorIndexOfIsMulti);
        _tmpIsMulti = _tmp_21 != 0;
        final BigDecimal _tmpDealQty;
        final String _tmp_22;
        if (_cursor.isNull(_cursorIndexOfDealQty)) {
          _tmp_22 = null;
        } else {
          _tmp_22 = _cursor.getString(_cursorIndexOfDealQty);
        }
        _tmpDealQty = __converters.stringToBigDecimal(_tmp_22);
        final boolean _tmpIsDealSameItem;
        final int _tmp_23;
        _tmp_23 = _cursor.getInt(_cursorIndexOfIsDealSameItem);
        _tmpIsDealSameItem = _tmp_23 != 0;
        _item = new PromoEntity(_tmpId,_tmpIsActive,_tmpIsBranch,_tmpBranchId,_tmpIsPeriod,_tmpStartDate,_tmpEndDate,_tmpIsTime,_tmpStartTime,_tmpEndTime,_tmpIsDow,_tmpDowExp,_tmpIsBpgrp,_tmpOfferType,_tmpMinAmt,_tmpIsTargetItem,_tmpItemId,_tmpIsTargetItgrp,_tmpItgrpId,_tmpIsTargetBrand,_tmpBrandId,_tmpIsTargetVendor,_tmpVendorId,_tmpIsMinQty,_tmpMinQty,_tmpPriority,_tmpIsMinAmt,_tmpNote,_tmpCode,_tmpPromoType,_tmpPromoName,_tmpItemDiscExp,_tmpPromoCat,_tmpIsPriceOveride,_tmpDealItemId,_tmpItemPrice,_tmpIsMinQtyMultiply,_tmpIsMaxQty,_tmpMaxQty,_tmpIsUsed,_tmpIsOn,_tmpIsMulti,_tmpDealQty,_tmpIsDealSameItem);
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
