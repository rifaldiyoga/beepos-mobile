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
import com.bits.bee.bpmc.data.data_source.local.model.RankItemEntity;
import com.bits.bee.bpmc.data.data_source.local.model.SaledEntity;
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
public final class SaledDao_Impl implements SaledDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SaledEntity> __insertionAdapterOfSaledEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<SaledEntity> __deletionAdapterOfSaledEntity;

  private final EntityDeletionOrUpdateAdapter<SaledEntity> __updateAdapterOfSaledEntity;

  public SaledDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSaledEntity = new EntityInsertionAdapter<SaledEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `saled` (`id`,`item_id`,`item_code`,`name`,`qty`,`listprice`,`disc`,`tax`,`discexp`,`discamt`,`disc2amt`,`taxamt`,`baseprice`,`taxableamt`,`subtotal`,`sale_id`,`dno`,`totaldiscamt`,`totaldisc2amt`,`totaltaxamt`,`dnote`,`crc_id`,`unit_id`,`conv`,`pid`,`tax_code`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaledEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getItemId());
        if (value.getItemCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getItemCode());
        }
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        final String _tmp = __converters.bigDecimalToString(value.getQty());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp);
        }
        final String _tmp_1 = __converters.bigDecimalToString(value.getListPrice());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_1);
        }
        final String _tmp_2 = __converters.bigDecimalToString(value.getDisc());
        if (_tmp_2 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_2);
        }
        final String _tmp_3 = __converters.bigDecimalToString(value.getTax());
        if (_tmp_3 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_3);
        }
        if (value.getDiscExp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDiscExp());
        }
        final String _tmp_4 = __converters.bigDecimalToString(value.getDiscAmt());
        if (_tmp_4 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, _tmp_4);
        }
        final String _tmp_5 = __converters.bigDecimalToString(value.getDisc2Amt());
        if (_tmp_5 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp_5);
        }
        final String _tmp_6 = __converters.bigDecimalToString(value.getTaxAmt());
        if (_tmp_6 == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, _tmp_6);
        }
        final String _tmp_7 = __converters.bigDecimalToString(value.getBasePrice());
        if (_tmp_7 == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, _tmp_7);
        }
        final String _tmp_8 = __converters.bigDecimalToString(value.getTaxableAmt());
        if (_tmp_8 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, _tmp_8);
        }
        final String _tmp_9 = __converters.bigDecimalToString(value.getSubtotal());
        if (_tmp_9 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, _tmp_9);
        }
        stmt.bindLong(16, value.getSaleId());
        stmt.bindLong(17, value.getDno());
        final String _tmp_10 = __converters.bigDecimalToString(value.getTotalDiscAmt());
        if (_tmp_10 == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, _tmp_10);
        }
        final String _tmp_11 = __converters.bigDecimalToString(value.getTotalDisc2Amt());
        if (_tmp_11 == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, _tmp_11);
        }
        final String _tmp_12 = __converters.bigDecimalToString(value.getTotalTaxAmt());
        if (_tmp_12 == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, _tmp_12);
        }
        if (value.getDNotes() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getDNotes());
        }
        if (value.getCrcId() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindLong(22, value.getCrcId());
        }
        if (value.getUnitId() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindLong(23, value.getUnitId());
        }
        final String _tmp_13 = __converters.bigDecimalToString(value.getConv());
        if (_tmp_13 == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, _tmp_13);
        }
        if (value.getPid() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getPid());
        }
        if (value.getTaxCode() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getTaxCode());
        }
      }
    };
    this.__deletionAdapterOfSaledEntity = new EntityDeletionOrUpdateAdapter<SaledEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `saled` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaledEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfSaledEntity = new EntityDeletionOrUpdateAdapter<SaledEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `saled` SET `id` = ?,`item_id` = ?,`item_code` = ?,`name` = ?,`qty` = ?,`listprice` = ?,`disc` = ?,`tax` = ?,`discexp` = ?,`discamt` = ?,`disc2amt` = ?,`taxamt` = ?,`baseprice` = ?,`taxableamt` = ?,`subtotal` = ?,`sale_id` = ?,`dno` = ?,`totaldiscamt` = ?,`totaldisc2amt` = ?,`totaltaxamt` = ?,`dnote` = ?,`crc_id` = ?,`unit_id` = ?,`conv` = ?,`pid` = ?,`tax_code` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaledEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getItemId());
        if (value.getItemCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getItemCode());
        }
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        final String _tmp = __converters.bigDecimalToString(value.getQty());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp);
        }
        final String _tmp_1 = __converters.bigDecimalToString(value.getListPrice());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_1);
        }
        final String _tmp_2 = __converters.bigDecimalToString(value.getDisc());
        if (_tmp_2 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_2);
        }
        final String _tmp_3 = __converters.bigDecimalToString(value.getTax());
        if (_tmp_3 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_3);
        }
        if (value.getDiscExp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDiscExp());
        }
        final String _tmp_4 = __converters.bigDecimalToString(value.getDiscAmt());
        if (_tmp_4 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, _tmp_4);
        }
        final String _tmp_5 = __converters.bigDecimalToString(value.getDisc2Amt());
        if (_tmp_5 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp_5);
        }
        final String _tmp_6 = __converters.bigDecimalToString(value.getTaxAmt());
        if (_tmp_6 == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, _tmp_6);
        }
        final String _tmp_7 = __converters.bigDecimalToString(value.getBasePrice());
        if (_tmp_7 == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, _tmp_7);
        }
        final String _tmp_8 = __converters.bigDecimalToString(value.getTaxableAmt());
        if (_tmp_8 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, _tmp_8);
        }
        final String _tmp_9 = __converters.bigDecimalToString(value.getSubtotal());
        if (_tmp_9 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, _tmp_9);
        }
        stmt.bindLong(16, value.getSaleId());
        stmt.bindLong(17, value.getDno());
        final String _tmp_10 = __converters.bigDecimalToString(value.getTotalDiscAmt());
        if (_tmp_10 == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, _tmp_10);
        }
        final String _tmp_11 = __converters.bigDecimalToString(value.getTotalDisc2Amt());
        if (_tmp_11 == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, _tmp_11);
        }
        final String _tmp_12 = __converters.bigDecimalToString(value.getTotalTaxAmt());
        if (_tmp_12 == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, _tmp_12);
        }
        if (value.getDNotes() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getDNotes());
        }
        if (value.getCrcId() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindLong(22, value.getCrcId());
        }
        if (value.getUnitId() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindLong(23, value.getUnitId());
        }
        final String _tmp_13 = __converters.bigDecimalToString(value.getConv());
        if (_tmp_13 == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, _tmp_13);
        }
        if (value.getPid() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getPid());
        }
        if (value.getTaxCode() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getTaxCode());
        }
        if (value.getId() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindLong(27, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends SaledEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final SaledEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends SaledEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSaledEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final SaledEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSaledEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final SaledEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSaledEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<SaledEntity> getSaledList(final int id) {
    final String _sql = "SELECT * FROM saled WHERE sale_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "item_code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfQty = CursorUtil.getColumnIndexOrThrow(_cursor, "qty");
      final int _cursorIndexOfListPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "listprice");
      final int _cursorIndexOfDisc = CursorUtil.getColumnIndexOrThrow(_cursor, "disc");
      final int _cursorIndexOfTax = CursorUtil.getColumnIndexOrThrow(_cursor, "tax");
      final int _cursorIndexOfDiscExp = CursorUtil.getColumnIndexOrThrow(_cursor, "discexp");
      final int _cursorIndexOfDiscAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "discamt");
      final int _cursorIndexOfDisc2Amt = CursorUtil.getColumnIndexOrThrow(_cursor, "disc2amt");
      final int _cursorIndexOfTaxAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "taxamt");
      final int _cursorIndexOfBasePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "baseprice");
      final int _cursorIndexOfTaxableAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "taxableamt");
      final int _cursorIndexOfSubtotal = CursorUtil.getColumnIndexOrThrow(_cursor, "subtotal");
      final int _cursorIndexOfSaleId = CursorUtil.getColumnIndexOrThrow(_cursor, "sale_id");
      final int _cursorIndexOfDno = CursorUtil.getColumnIndexOrThrow(_cursor, "dno");
      final int _cursorIndexOfTotalDiscAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "totaldiscamt");
      final int _cursorIndexOfTotalDisc2Amt = CursorUtil.getColumnIndexOrThrow(_cursor, "totaldisc2amt");
      final int _cursorIndexOfTotalTaxAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "totaltaxamt");
      final int _cursorIndexOfDNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "dnote");
      final int _cursorIndexOfCrcId = CursorUtil.getColumnIndexOrThrow(_cursor, "crc_id");
      final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unit_id");
      final int _cursorIndexOfConv = CursorUtil.getColumnIndexOrThrow(_cursor, "conv");
      final int _cursorIndexOfPid = CursorUtil.getColumnIndexOrThrow(_cursor, "pid");
      final int _cursorIndexOfTaxCode = CursorUtil.getColumnIndexOrThrow(_cursor, "tax_code");
      final List<SaledEntity> _result = new ArrayList<SaledEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SaledEntity _item;
        _item = new SaledEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _item.setItemId(_tmpItemId);
        final String _tmpItemCode;
        if (_cursor.isNull(_cursorIndexOfItemCode)) {
          _tmpItemCode = null;
        } else {
          _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
        }
        _item.setItemCode(_tmpItemCode);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final BigDecimal _tmpQty;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfQty)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfQty);
        }
        _tmpQty = __converters.stringToBigDecimal(_tmp);
        _item.setQty(_tmpQty);
        final BigDecimal _tmpListPrice;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfListPrice)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfListPrice);
        }
        _tmpListPrice = __converters.stringToBigDecimal(_tmp_1);
        _item.setListPrice(_tmpListPrice);
        final BigDecimal _tmpDisc;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDisc)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfDisc);
        }
        _tmpDisc = __converters.stringToBigDecimal(_tmp_2);
        _item.setDisc(_tmpDisc);
        final BigDecimal _tmpTax;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfTax)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfTax);
        }
        _tmpTax = __converters.stringToBigDecimal(_tmp_3);
        _item.setTax(_tmpTax);
        final String _tmpDiscExp;
        if (_cursor.isNull(_cursorIndexOfDiscExp)) {
          _tmpDiscExp = null;
        } else {
          _tmpDiscExp = _cursor.getString(_cursorIndexOfDiscExp);
        }
        _item.setDiscExp(_tmpDiscExp);
        final BigDecimal _tmpDiscAmt;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfDiscAmt)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfDiscAmt);
        }
        _tmpDiscAmt = __converters.stringToBigDecimal(_tmp_4);
        _item.setDiscAmt(_tmpDiscAmt);
        final BigDecimal _tmpDisc2Amt;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfDisc2Amt)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfDisc2Amt);
        }
        _tmpDisc2Amt = __converters.stringToBigDecimal(_tmp_5);
        _item.setDisc2Amt(_tmpDisc2Amt);
        final BigDecimal _tmpTaxAmt;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfTaxAmt)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfTaxAmt);
        }
        _tmpTaxAmt = __converters.stringToBigDecimal(_tmp_6);
        _item.setTaxAmt(_tmpTaxAmt);
        final BigDecimal _tmpBasePrice;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfBasePrice)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfBasePrice);
        }
        _tmpBasePrice = __converters.stringToBigDecimal(_tmp_7);
        _item.setBasePrice(_tmpBasePrice);
        final BigDecimal _tmpTaxableAmt;
        final String _tmp_8;
        if (_cursor.isNull(_cursorIndexOfTaxableAmt)) {
          _tmp_8 = null;
        } else {
          _tmp_8 = _cursor.getString(_cursorIndexOfTaxableAmt);
        }
        _tmpTaxableAmt = __converters.stringToBigDecimal(_tmp_8);
        _item.setTaxableAmt(_tmpTaxableAmt);
        final BigDecimal _tmpSubtotal;
        final String _tmp_9;
        if (_cursor.isNull(_cursorIndexOfSubtotal)) {
          _tmp_9 = null;
        } else {
          _tmp_9 = _cursor.getString(_cursorIndexOfSubtotal);
        }
        _tmpSubtotal = __converters.stringToBigDecimal(_tmp_9);
        _item.setSubtotal(_tmpSubtotal);
        final int _tmpSaleId;
        _tmpSaleId = _cursor.getInt(_cursorIndexOfSaleId);
        _item.setSaleId(_tmpSaleId);
        final int _tmpDno;
        _tmpDno = _cursor.getInt(_cursorIndexOfDno);
        _item.setDno(_tmpDno);
        final BigDecimal _tmpTotalDiscAmt;
        final String _tmp_10;
        if (_cursor.isNull(_cursorIndexOfTotalDiscAmt)) {
          _tmp_10 = null;
        } else {
          _tmp_10 = _cursor.getString(_cursorIndexOfTotalDiscAmt);
        }
        _tmpTotalDiscAmt = __converters.stringToBigDecimal(_tmp_10);
        _item.setTotalDiscAmt(_tmpTotalDiscAmt);
        final BigDecimal _tmpTotalDisc2Amt;
        final String _tmp_11;
        if (_cursor.isNull(_cursorIndexOfTotalDisc2Amt)) {
          _tmp_11 = null;
        } else {
          _tmp_11 = _cursor.getString(_cursorIndexOfTotalDisc2Amt);
        }
        _tmpTotalDisc2Amt = __converters.stringToBigDecimal(_tmp_11);
        _item.setTotalDisc2Amt(_tmpTotalDisc2Amt);
        final BigDecimal _tmpTotalTaxAmt;
        final String _tmp_12;
        if (_cursor.isNull(_cursorIndexOfTotalTaxAmt)) {
          _tmp_12 = null;
        } else {
          _tmp_12 = _cursor.getString(_cursorIndexOfTotalTaxAmt);
        }
        _tmpTotalTaxAmt = __converters.stringToBigDecimal(_tmp_12);
        _item.setTotalTaxAmt(_tmpTotalTaxAmt);
        final String _tmpDNotes;
        if (_cursor.isNull(_cursorIndexOfDNotes)) {
          _tmpDNotes = null;
        } else {
          _tmpDNotes = _cursor.getString(_cursorIndexOfDNotes);
        }
        _item.setDNotes(_tmpDNotes);
        final Integer _tmpCrcId;
        if (_cursor.isNull(_cursorIndexOfCrcId)) {
          _tmpCrcId = null;
        } else {
          _tmpCrcId = _cursor.getInt(_cursorIndexOfCrcId);
        }
        _item.setCrcId(_tmpCrcId);
        final Integer _tmpUnitId;
        if (_cursor.isNull(_cursorIndexOfUnitId)) {
          _tmpUnitId = null;
        } else {
          _tmpUnitId = _cursor.getInt(_cursorIndexOfUnitId);
        }
        _item.setUnitId(_tmpUnitId);
        final BigDecimal _tmpConv;
        final String _tmp_13;
        if (_cursor.isNull(_cursorIndexOfConv)) {
          _tmp_13 = null;
        } else {
          _tmp_13 = _cursor.getString(_cursorIndexOfConv);
        }
        _tmpConv = __converters.stringToBigDecimal(_tmp_13);
        _item.setConv(_tmpConv);
        final String _tmpPid;
        if (_cursor.isNull(_cursorIndexOfPid)) {
          _tmpPid = null;
        } else {
          _tmpPid = _cursor.getString(_cursorIndexOfPid);
        }
        _item.setPid(_tmpPid);
        final String _tmpTaxCode;
        if (_cursor.isNull(_cursorIndexOfTaxCode)) {
          _tmpTaxCode = null;
        } else {
          _tmpTaxCode = _cursor.getString(_cursorIndexOfTaxCode);
        }
        _item.setTaxCode(_tmpTaxCode);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<RankItemEntity> getRankItem(final int possesId) {
    final String _sql = "select a.name, sum(qty) qty, sum(a.subtotal) total from saled a JOIN sale d ON d.id = a.sale_id WHERE d.posses_id = ? AND d.isvoid = 0 group by item_id order by qty DESC LIMIT 10";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, possesId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfName = 0;
      final int _cursorIndexOfQty = 1;
      final int _cursorIndexOfTotal = 2;
      final List<RankItemEntity> _result = new ArrayList<RankItemEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final RankItemEntity _item;
        _item = new RankItemEntity();
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final BigDecimal _tmpQty;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfQty)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfQty);
        }
        _tmpQty = __converters.stringToBigDecimal(_tmp);
        _item.setQty(_tmpQty);
        final BigDecimal _tmpTotal;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfTotal)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfTotal);
        }
        _tmpTotal = __converters.stringToBigDecimal(_tmp_1);
        _item.setTotal(_tmpTotal);
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
