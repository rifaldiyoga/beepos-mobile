package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.paging.PagingSource;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.converter.Converters;
import com.bits.bee.bpmc.data.data_source.local.model.SaleEntity;
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
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SaleDao_Impl implements SaleDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SaleEntity> __insertionAdapterOfSaleEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<SaleEntity> __deletionAdapterOfSaleEntity;

  private final EntityDeletionOrUpdateAdapter<SaleEntity> __updateAdapterOfSaleEntity;

  public SaleDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSaleEntity = new EntityInsertionAdapter<SaleEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `sale` (`id`,`trx_ordernum`,`trx_no`,`draft`,`subtotal`,`total`,`opr_name`,`cashier_name`,`trx_date`,`paidamt`,`changeamt`,`taxamt`,`discamt`,`posses_id`,`kode_posses`,`discexp`,`user_id`,`cashier_id`,`bp_id`,`bp_name`,`termtype`,`isuploaded`,`isvoid`,`url_qrcode`,`transaction_id`,`gopay_paymentstatus`,`rounding`,`channel_id`,`void_note`,`created_at`,`created_by`,`updated_at`,`updated_by`,`crc_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaleEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getTrxOrderNum());
        if (value.getTrxNo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTrxNo());
        }
        final int _tmp = value.isDraft() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        final String _tmp_1 = __converters.bigDecimalToString(value.getSubtotal());
        if (_tmp_1 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_1);
        }
        final String _tmp_2 = __converters.bigDecimalToString(value.getTotal());
        if (_tmp_2 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_2);
        }
        if (value.getOprName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getOprName());
        }
        if (value.getCashiername() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCashiername());
        }
        final Long _tmp_3 = __converters.dateToLong(value.getTrxDate());
        if (_tmp_3 == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, _tmp_3);
        }
        final String _tmp_4 = __converters.bigDecimalToString(value.getTotPaid());
        if (_tmp_4 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, _tmp_4);
        }
        final String _tmp_5 = __converters.bigDecimalToString(value.getTotChange());
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
        final String _tmp_7 = __converters.bigDecimalToString(value.getDiscAmt());
        if (_tmp_7 == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, _tmp_7);
        }
        stmt.bindLong(14, value.getPossesId());
        if (value.getKodePosses() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getKodePosses());
        }
        if (value.getDiscExp() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getDiscExp());
        }
        stmt.bindLong(17, value.getUserId());
        stmt.bindLong(18, value.getCashierId());
        stmt.bindLong(19, value.getBpId());
        if (value.getBpName() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getBpName());
        }
        if (value.getTermType() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getTermType());
        }
        final int _tmp_8 = value.isUploaded() ? 1 : 0;
        stmt.bindLong(22, _tmp_8);
        final int _tmp_9 = value.isVoid() ? 1 : 0;
        stmt.bindLong(23, _tmp_9);
        if (value.getGopayUrl() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getGopayUrl());
        }
        if (value.getGopayTransactionId() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getGopayTransactionId());
        }
        if (value.getGopayPaymentStatus() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getGopayPaymentStatus());
        }
        final String _tmp_10 = __converters.bigDecimalToString(value.getRounding());
        if (_tmp_10 == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, _tmp_10);
        }
        stmt.bindLong(28, value.getChannelId());
        if (value.getVoidNote() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getVoidNote());
        }
        final Long _tmp_11 = __converters.dateToLong(value.getCreatedAt());
        if (_tmp_11 == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindLong(30, _tmp_11);
        }
        stmt.bindLong(31, value.getCreatedBy());
        final Long _tmp_12 = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp_12 == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindLong(32, _tmp_12);
        }
        stmt.bindLong(33, value.getUpdatedBy());
        if (value.getCrcId() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindLong(34, value.getCrcId());
        }
      }
    };
    this.__deletionAdapterOfSaleEntity = new EntityDeletionOrUpdateAdapter<SaleEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `sale` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaleEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfSaleEntity = new EntityDeletionOrUpdateAdapter<SaleEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `sale` SET `id` = ?,`trx_ordernum` = ?,`trx_no` = ?,`draft` = ?,`subtotal` = ?,`total` = ?,`opr_name` = ?,`cashier_name` = ?,`trx_date` = ?,`paidamt` = ?,`changeamt` = ?,`taxamt` = ?,`discamt` = ?,`posses_id` = ?,`kode_posses` = ?,`discexp` = ?,`user_id` = ?,`cashier_id` = ?,`bp_id` = ?,`bp_name` = ?,`termtype` = ?,`isuploaded` = ?,`isvoid` = ?,`url_qrcode` = ?,`transaction_id` = ?,`gopay_paymentstatus` = ?,`rounding` = ?,`channel_id` = ?,`void_note` = ?,`created_at` = ?,`created_by` = ?,`updated_at` = ?,`updated_by` = ?,`crc_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaleEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getTrxOrderNum());
        if (value.getTrxNo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTrxNo());
        }
        final int _tmp = value.isDraft() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        final String _tmp_1 = __converters.bigDecimalToString(value.getSubtotal());
        if (_tmp_1 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_1);
        }
        final String _tmp_2 = __converters.bigDecimalToString(value.getTotal());
        if (_tmp_2 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_2);
        }
        if (value.getOprName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getOprName());
        }
        if (value.getCashiername() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCashiername());
        }
        final Long _tmp_3 = __converters.dateToLong(value.getTrxDate());
        if (_tmp_3 == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, _tmp_3);
        }
        final String _tmp_4 = __converters.bigDecimalToString(value.getTotPaid());
        if (_tmp_4 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, _tmp_4);
        }
        final String _tmp_5 = __converters.bigDecimalToString(value.getTotChange());
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
        final String _tmp_7 = __converters.bigDecimalToString(value.getDiscAmt());
        if (_tmp_7 == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, _tmp_7);
        }
        stmt.bindLong(14, value.getPossesId());
        if (value.getKodePosses() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getKodePosses());
        }
        if (value.getDiscExp() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getDiscExp());
        }
        stmt.bindLong(17, value.getUserId());
        stmt.bindLong(18, value.getCashierId());
        stmt.bindLong(19, value.getBpId());
        if (value.getBpName() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getBpName());
        }
        if (value.getTermType() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getTermType());
        }
        final int _tmp_8 = value.isUploaded() ? 1 : 0;
        stmt.bindLong(22, _tmp_8);
        final int _tmp_9 = value.isVoid() ? 1 : 0;
        stmt.bindLong(23, _tmp_9);
        if (value.getGopayUrl() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getGopayUrl());
        }
        if (value.getGopayTransactionId() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getGopayTransactionId());
        }
        if (value.getGopayPaymentStatus() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getGopayPaymentStatus());
        }
        final String _tmp_10 = __converters.bigDecimalToString(value.getRounding());
        if (_tmp_10 == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, _tmp_10);
        }
        stmt.bindLong(28, value.getChannelId());
        if (value.getVoidNote() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getVoidNote());
        }
        final Long _tmp_11 = __converters.dateToLong(value.getCreatedAt());
        if (_tmp_11 == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindLong(30, _tmp_11);
        }
        stmt.bindLong(31, value.getCreatedBy());
        final Long _tmp_12 = __converters.dateToLong(value.getUpdatedAt());
        if (_tmp_12 == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindLong(32, _tmp_12);
        }
        stmt.bindLong(33, value.getUpdatedBy());
        if (value.getCrcId() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindLong(34, value.getCrcId());
        }
        if (value.getId() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindLong(35, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends SaleEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final SaleEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends SaleEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSaleEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final SaleEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSaleEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final SaleEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSaleEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public PagingSource<Integer, SaleEntity> getLatestSaleList(final String query,
      final boolean isDraft) {
    final String _sql = "SELECT * FROM sale WHERE draft = ? AND (trx_no LIKE '%' || ? || '%' OR bp_name LIKE '%' || ? || '%') ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    final int _tmp = isDraft ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 3;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return new LimitOffsetPagingSource<SaleEntity>(_statement, __db, "sale") {
      @Override
      protected List<SaleEntity> convertRows(Cursor cursor) {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfTrxOrderNum = CursorUtil.getColumnIndexOrThrow(cursor, "trx_ordernum");
        final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(cursor, "trx_no");
        final int _cursorIndexOfIsDraft = CursorUtil.getColumnIndexOrThrow(cursor, "draft");
        final int _cursorIndexOfSubtotal = CursorUtil.getColumnIndexOrThrow(cursor, "subtotal");
        final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(cursor, "total");
        final int _cursorIndexOfOprName = CursorUtil.getColumnIndexOrThrow(cursor, "opr_name");
        final int _cursorIndexOfCashiername = CursorUtil.getColumnIndexOrThrow(cursor, "cashier_name");
        final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(cursor, "trx_date");
        final int _cursorIndexOfTotPaid = CursorUtil.getColumnIndexOrThrow(cursor, "paidamt");
        final int _cursorIndexOfTotChange = CursorUtil.getColumnIndexOrThrow(cursor, "changeamt");
        final int _cursorIndexOfTaxAmt = CursorUtil.getColumnIndexOrThrow(cursor, "taxamt");
        final int _cursorIndexOfDiscAmt = CursorUtil.getColumnIndexOrThrow(cursor, "discamt");
        final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(cursor, "posses_id");
        final int _cursorIndexOfKodePosses = CursorUtil.getColumnIndexOrThrow(cursor, "kode_posses");
        final int _cursorIndexOfDiscExp = CursorUtil.getColumnIndexOrThrow(cursor, "discexp");
        final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(cursor, "user_id");
        final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(cursor, "cashier_id");
        final int _cursorIndexOfBpId = CursorUtil.getColumnIndexOrThrow(cursor, "bp_id");
        final int _cursorIndexOfBpName = CursorUtil.getColumnIndexOrThrow(cursor, "bp_name");
        final int _cursorIndexOfTermType = CursorUtil.getColumnIndexOrThrow(cursor, "termtype");
        final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(cursor, "isuploaded");
        final int _cursorIndexOfIsVoid = CursorUtil.getColumnIndexOrThrow(cursor, "isvoid");
        final int _cursorIndexOfGopayUrl = CursorUtil.getColumnIndexOrThrow(cursor, "url_qrcode");
        final int _cursorIndexOfGopayTransactionId = CursorUtil.getColumnIndexOrThrow(cursor, "transaction_id");
        final int _cursorIndexOfGopayPaymentStatus = CursorUtil.getColumnIndexOrThrow(cursor, "gopay_paymentstatus");
        final int _cursorIndexOfRounding = CursorUtil.getColumnIndexOrThrow(cursor, "rounding");
        final int _cursorIndexOfChannelId = CursorUtil.getColumnIndexOrThrow(cursor, "channel_id");
        final int _cursorIndexOfVoidNote = CursorUtil.getColumnIndexOrThrow(cursor, "void_note");
        final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(cursor, "created_at");
        final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "created_by");
        final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(cursor, "updated_at");
        final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "updated_by");
        final int _cursorIndexOfCrcId = CursorUtil.getColumnIndexOrThrow(cursor, "crc_id");
        final List<SaleEntity> _result = new ArrayList<SaleEntity>(cursor.getCount());
        while(cursor.moveToNext()) {
          final SaleEntity _item;
          _item = new SaleEntity();
          final Integer _tmpId;
          if (cursor.isNull(_cursorIndexOfId)) {
            _tmpId = null;
          } else {
            _tmpId = cursor.getInt(_cursorIndexOfId);
          }
          _item.setId(_tmpId);
          final int _tmpTrxOrderNum;
          _tmpTrxOrderNum = cursor.getInt(_cursorIndexOfTrxOrderNum);
          _item.setTrxOrderNum(_tmpTrxOrderNum);
          final String _tmpTrxNo;
          if (cursor.isNull(_cursorIndexOfTrxNo)) {
            _tmpTrxNo = null;
          } else {
            _tmpTrxNo = cursor.getString(_cursorIndexOfTrxNo);
          }
          _item.setTrxNo(_tmpTrxNo);
          final boolean _tmpIsDraft;
          final int _tmp_1;
          _tmp_1 = cursor.getInt(_cursorIndexOfIsDraft);
          _tmpIsDraft = _tmp_1 != 0;
          _item.setDraft(_tmpIsDraft);
          final BigDecimal _tmpSubtotal;
          final String _tmp_2;
          if (cursor.isNull(_cursorIndexOfSubtotal)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = cursor.getString(_cursorIndexOfSubtotal);
          }
          _tmpSubtotal = __converters.stringToBigDecimal(_tmp_2);
          _item.setSubtotal(_tmpSubtotal);
          final BigDecimal _tmpTotal;
          final String _tmp_3;
          if (cursor.isNull(_cursorIndexOfTotal)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = cursor.getString(_cursorIndexOfTotal);
          }
          _tmpTotal = __converters.stringToBigDecimal(_tmp_3);
          _item.setTotal(_tmpTotal);
          final String _tmpOprName;
          if (cursor.isNull(_cursorIndexOfOprName)) {
            _tmpOprName = null;
          } else {
            _tmpOprName = cursor.getString(_cursorIndexOfOprName);
          }
          _item.setOprName(_tmpOprName);
          final String _tmpCashiername;
          if (cursor.isNull(_cursorIndexOfCashiername)) {
            _tmpCashiername = null;
          } else {
            _tmpCashiername = cursor.getString(_cursorIndexOfCashiername);
          }
          _item.setCashiername(_tmpCashiername);
          final Date _tmpTrxDate;
          final Long _tmp_4;
          if (cursor.isNull(_cursorIndexOfTrxDate)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = cursor.getLong(_cursorIndexOfTrxDate);
          }
          _tmpTrxDate = __converters.longToDate(_tmp_4);
          _item.setTrxDate(_tmpTrxDate);
          final BigDecimal _tmpTotPaid;
          final String _tmp_5;
          if (cursor.isNull(_cursorIndexOfTotPaid)) {
            _tmp_5 = null;
          } else {
            _tmp_5 = cursor.getString(_cursorIndexOfTotPaid);
          }
          _tmpTotPaid = __converters.stringToBigDecimal(_tmp_5);
          _item.setTotPaid(_tmpTotPaid);
          final BigDecimal _tmpTotChange;
          final String _tmp_6;
          if (cursor.isNull(_cursorIndexOfTotChange)) {
            _tmp_6 = null;
          } else {
            _tmp_6 = cursor.getString(_cursorIndexOfTotChange);
          }
          _tmpTotChange = __converters.stringToBigDecimal(_tmp_6);
          _item.setTotChange(_tmpTotChange);
          final BigDecimal _tmpTaxAmt;
          final String _tmp_7;
          if (cursor.isNull(_cursorIndexOfTaxAmt)) {
            _tmp_7 = null;
          } else {
            _tmp_7 = cursor.getString(_cursorIndexOfTaxAmt);
          }
          _tmpTaxAmt = __converters.stringToBigDecimal(_tmp_7);
          _item.setTaxAmt(_tmpTaxAmt);
          final BigDecimal _tmpDiscAmt;
          final String _tmp_8;
          if (cursor.isNull(_cursorIndexOfDiscAmt)) {
            _tmp_8 = null;
          } else {
            _tmp_8 = cursor.getString(_cursorIndexOfDiscAmt);
          }
          _tmpDiscAmt = __converters.stringToBigDecimal(_tmp_8);
          _item.setDiscAmt(_tmpDiscAmt);
          final int _tmpPossesId;
          _tmpPossesId = cursor.getInt(_cursorIndexOfPossesId);
          _item.setPossesId(_tmpPossesId);
          final String _tmpKodePosses;
          if (cursor.isNull(_cursorIndexOfKodePosses)) {
            _tmpKodePosses = null;
          } else {
            _tmpKodePosses = cursor.getString(_cursorIndexOfKodePosses);
          }
          _item.setKodePosses(_tmpKodePosses);
          final String _tmpDiscExp;
          if (cursor.isNull(_cursorIndexOfDiscExp)) {
            _tmpDiscExp = null;
          } else {
            _tmpDiscExp = cursor.getString(_cursorIndexOfDiscExp);
          }
          _item.setDiscExp(_tmpDiscExp);
          final int _tmpUserId;
          _tmpUserId = cursor.getInt(_cursorIndexOfUserId);
          _item.setUserId(_tmpUserId);
          final int _tmpCashierId;
          _tmpCashierId = cursor.getInt(_cursorIndexOfCashierId);
          _item.setCashierId(_tmpCashierId);
          final int _tmpBpId;
          _tmpBpId = cursor.getInt(_cursorIndexOfBpId);
          _item.setBpId(_tmpBpId);
          final String _tmpBpName;
          if (cursor.isNull(_cursorIndexOfBpName)) {
            _tmpBpName = null;
          } else {
            _tmpBpName = cursor.getString(_cursorIndexOfBpName);
          }
          _item.setBpName(_tmpBpName);
          final String _tmpTermType;
          if (cursor.isNull(_cursorIndexOfTermType)) {
            _tmpTermType = null;
          } else {
            _tmpTermType = cursor.getString(_cursorIndexOfTermType);
          }
          _item.setTermType(_tmpTermType);
          final boolean _tmpIsUploaded;
          final int _tmp_9;
          _tmp_9 = cursor.getInt(_cursorIndexOfIsUploaded);
          _tmpIsUploaded = _tmp_9 != 0;
          _item.setUploaded(_tmpIsUploaded);
          final boolean _tmpIsVoid;
          final int _tmp_10;
          _tmp_10 = cursor.getInt(_cursorIndexOfIsVoid);
          _tmpIsVoid = _tmp_10 != 0;
          _item.setVoid(_tmpIsVoid);
          final String _tmpGopayUrl;
          if (cursor.isNull(_cursorIndexOfGopayUrl)) {
            _tmpGopayUrl = null;
          } else {
            _tmpGopayUrl = cursor.getString(_cursorIndexOfGopayUrl);
          }
          _item.setGopayUrl(_tmpGopayUrl);
          final String _tmpGopayTransactionId;
          if (cursor.isNull(_cursorIndexOfGopayTransactionId)) {
            _tmpGopayTransactionId = null;
          } else {
            _tmpGopayTransactionId = cursor.getString(_cursorIndexOfGopayTransactionId);
          }
          _item.setGopayTransactionId(_tmpGopayTransactionId);
          final String _tmpGopayPaymentStatus;
          if (cursor.isNull(_cursorIndexOfGopayPaymentStatus)) {
            _tmpGopayPaymentStatus = null;
          } else {
            _tmpGopayPaymentStatus = cursor.getString(_cursorIndexOfGopayPaymentStatus);
          }
          _item.setGopayPaymentStatus(_tmpGopayPaymentStatus);
          final BigDecimal _tmpRounding;
          final String _tmp_11;
          if (cursor.isNull(_cursorIndexOfRounding)) {
            _tmp_11 = null;
          } else {
            _tmp_11 = cursor.getString(_cursorIndexOfRounding);
          }
          _tmpRounding = __converters.stringToBigDecimal(_tmp_11);
          _item.setRounding(_tmpRounding);
          final int _tmpChannelId;
          _tmpChannelId = cursor.getInt(_cursorIndexOfChannelId);
          _item.setChannelId(_tmpChannelId);
          final String _tmpVoidNote;
          if (cursor.isNull(_cursorIndexOfVoidNote)) {
            _tmpVoidNote = null;
          } else {
            _tmpVoidNote = cursor.getString(_cursorIndexOfVoidNote);
          }
          _item.setVoidNote(_tmpVoidNote);
          final Date _tmpCreatedAt;
          final Long _tmp_12;
          if (cursor.isNull(_cursorIndexOfCreatedAt)) {
            _tmp_12 = null;
          } else {
            _tmp_12 = cursor.getLong(_cursorIndexOfCreatedAt);
          }
          _tmpCreatedAt = __converters.longToDate(_tmp_12);
          _item.setCreatedAt(_tmpCreatedAt);
          final int _tmpCreatedBy;
          _tmpCreatedBy = cursor.getInt(_cursorIndexOfCreatedBy);
          _item.setCreatedBy(_tmpCreatedBy);
          final Date _tmpUpdatedAt;
          final Long _tmp_13;
          if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
            _tmp_13 = null;
          } else {
            _tmp_13 = cursor.getLong(_cursorIndexOfUpdatedAt);
          }
          _tmpUpdatedAt = __converters.longToDate(_tmp_13);
          _item.setUpdatedAt(_tmpUpdatedAt);
          final int _tmpUpdatedBy;
          _tmpUpdatedBy = cursor.getInt(_cursorIndexOfUpdatedBy);
          _item.setUpdatedBy(_tmpUpdatedBy);
          final Integer _tmpCrcId;
          if (cursor.isNull(_cursorIndexOfCrcId)) {
            _tmpCrcId = null;
          } else {
            _tmpCrcId = cursor.getInt(_cursorIndexOfCrcId);
          }
          _item.setCrcId(_tmpCrcId);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @Override
  public List<SaleEntity> getLatestDraftList() {
    final String _sql = "SELECT * FROM sale WHERE draft = 1 ORDER BY id DESC LIMIT 5";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxOrderNum = CursorUtil.getColumnIndexOrThrow(_cursor, "trx_ordernum");
      final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(_cursor, "trx_no");
      final int _cursorIndexOfIsDraft = CursorUtil.getColumnIndexOrThrow(_cursor, "draft");
      final int _cursorIndexOfSubtotal = CursorUtil.getColumnIndexOrThrow(_cursor, "subtotal");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfOprName = CursorUtil.getColumnIndexOrThrow(_cursor, "opr_name");
      final int _cursorIndexOfCashiername = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_name");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trx_date");
      final int _cursorIndexOfTotPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "paidamt");
      final int _cursorIndexOfTotChange = CursorUtil.getColumnIndexOrThrow(_cursor, "changeamt");
      final int _cursorIndexOfTaxAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "taxamt");
      final int _cursorIndexOfDiscAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "discamt");
      final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(_cursor, "posses_id");
      final int _cursorIndexOfKodePosses = CursorUtil.getColumnIndexOrThrow(_cursor, "kode_posses");
      final int _cursorIndexOfDiscExp = CursorUtil.getColumnIndexOrThrow(_cursor, "discexp");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfBpId = CursorUtil.getColumnIndexOrThrow(_cursor, "bp_id");
      final int _cursorIndexOfBpName = CursorUtil.getColumnIndexOrThrow(_cursor, "bp_name");
      final int _cursorIndexOfTermType = CursorUtil.getColumnIndexOrThrow(_cursor, "termtype");
      final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isuploaded");
      final int _cursorIndexOfIsVoid = CursorUtil.getColumnIndexOrThrow(_cursor, "isvoid");
      final int _cursorIndexOfGopayUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url_qrcode");
      final int _cursorIndexOfGopayTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transaction_id");
      final int _cursorIndexOfGopayPaymentStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "gopay_paymentstatus");
      final int _cursorIndexOfRounding = CursorUtil.getColumnIndexOrThrow(_cursor, "rounding");
      final int _cursorIndexOfChannelId = CursorUtil.getColumnIndexOrThrow(_cursor, "channel_id");
      final int _cursorIndexOfVoidNote = CursorUtil.getColumnIndexOrThrow(_cursor, "void_note");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final int _cursorIndexOfCrcId = CursorUtil.getColumnIndexOrThrow(_cursor, "crc_id");
      final List<SaleEntity> _result = new ArrayList<SaleEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SaleEntity _item;
        _item = new SaleEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final int _tmpTrxOrderNum;
        _tmpTrxOrderNum = _cursor.getInt(_cursorIndexOfTrxOrderNum);
        _item.setTrxOrderNum(_tmpTrxOrderNum);
        final String _tmpTrxNo;
        if (_cursor.isNull(_cursorIndexOfTrxNo)) {
          _tmpTrxNo = null;
        } else {
          _tmpTrxNo = _cursor.getString(_cursorIndexOfTrxNo);
        }
        _item.setTrxNo(_tmpTrxNo);
        final boolean _tmpIsDraft;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsDraft);
        _tmpIsDraft = _tmp != 0;
        _item.setDraft(_tmpIsDraft);
        final BigDecimal _tmpSubtotal;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfSubtotal)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfSubtotal);
        }
        _tmpSubtotal = __converters.stringToBigDecimal(_tmp_1);
        _item.setSubtotal(_tmpSubtotal);
        final BigDecimal _tmpTotal;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfTotal)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfTotal);
        }
        _tmpTotal = __converters.stringToBigDecimal(_tmp_2);
        _item.setTotal(_tmpTotal);
        final String _tmpOprName;
        if (_cursor.isNull(_cursorIndexOfOprName)) {
          _tmpOprName = null;
        } else {
          _tmpOprName = _cursor.getString(_cursorIndexOfOprName);
        }
        _item.setOprName(_tmpOprName);
        final String _tmpCashiername;
        if (_cursor.isNull(_cursorIndexOfCashiername)) {
          _tmpCashiername = null;
        } else {
          _tmpCashiername = _cursor.getString(_cursorIndexOfCashiername);
        }
        _item.setCashiername(_tmpCashiername);
        final Date _tmpTrxDate;
        final Long _tmp_3;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getLong(_cursorIndexOfTrxDate);
        }
        _tmpTrxDate = __converters.longToDate(_tmp_3);
        _item.setTrxDate(_tmpTrxDate);
        final BigDecimal _tmpTotPaid;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfTotPaid)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfTotPaid);
        }
        _tmpTotPaid = __converters.stringToBigDecimal(_tmp_4);
        _item.setTotPaid(_tmpTotPaid);
        final BigDecimal _tmpTotChange;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfTotChange)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfTotChange);
        }
        _tmpTotChange = __converters.stringToBigDecimal(_tmp_5);
        _item.setTotChange(_tmpTotChange);
        final BigDecimal _tmpTaxAmt;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfTaxAmt)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfTaxAmt);
        }
        _tmpTaxAmt = __converters.stringToBigDecimal(_tmp_6);
        _item.setTaxAmt(_tmpTaxAmt);
        final BigDecimal _tmpDiscAmt;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfDiscAmt)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfDiscAmt);
        }
        _tmpDiscAmt = __converters.stringToBigDecimal(_tmp_7);
        _item.setDiscAmt(_tmpDiscAmt);
        final int _tmpPossesId;
        _tmpPossesId = _cursor.getInt(_cursorIndexOfPossesId);
        _item.setPossesId(_tmpPossesId);
        final String _tmpKodePosses;
        if (_cursor.isNull(_cursorIndexOfKodePosses)) {
          _tmpKodePosses = null;
        } else {
          _tmpKodePosses = _cursor.getString(_cursorIndexOfKodePosses);
        }
        _item.setKodePosses(_tmpKodePosses);
        final String _tmpDiscExp;
        if (_cursor.isNull(_cursorIndexOfDiscExp)) {
          _tmpDiscExp = null;
        } else {
          _tmpDiscExp = _cursor.getString(_cursorIndexOfDiscExp);
        }
        _item.setDiscExp(_tmpDiscExp);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        _item.setUserId(_tmpUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        _item.setCashierId(_tmpCashierId);
        final int _tmpBpId;
        _tmpBpId = _cursor.getInt(_cursorIndexOfBpId);
        _item.setBpId(_tmpBpId);
        final String _tmpBpName;
        if (_cursor.isNull(_cursorIndexOfBpName)) {
          _tmpBpName = null;
        } else {
          _tmpBpName = _cursor.getString(_cursorIndexOfBpName);
        }
        _item.setBpName(_tmpBpName);
        final String _tmpTermType;
        if (_cursor.isNull(_cursorIndexOfTermType)) {
          _tmpTermType = null;
        } else {
          _tmpTermType = _cursor.getString(_cursorIndexOfTermType);
        }
        _item.setTermType(_tmpTermType);
        final boolean _tmpIsUploaded;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsUploaded);
        _tmpIsUploaded = _tmp_8 != 0;
        _item.setUploaded(_tmpIsUploaded);
        final boolean _tmpIsVoid;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsVoid);
        _tmpIsVoid = _tmp_9 != 0;
        _item.setVoid(_tmpIsVoid);
        final String _tmpGopayUrl;
        if (_cursor.isNull(_cursorIndexOfGopayUrl)) {
          _tmpGopayUrl = null;
        } else {
          _tmpGopayUrl = _cursor.getString(_cursorIndexOfGopayUrl);
        }
        _item.setGopayUrl(_tmpGopayUrl);
        final String _tmpGopayTransactionId;
        if (_cursor.isNull(_cursorIndexOfGopayTransactionId)) {
          _tmpGopayTransactionId = null;
        } else {
          _tmpGopayTransactionId = _cursor.getString(_cursorIndexOfGopayTransactionId);
        }
        _item.setGopayTransactionId(_tmpGopayTransactionId);
        final String _tmpGopayPaymentStatus;
        if (_cursor.isNull(_cursorIndexOfGopayPaymentStatus)) {
          _tmpGopayPaymentStatus = null;
        } else {
          _tmpGopayPaymentStatus = _cursor.getString(_cursorIndexOfGopayPaymentStatus);
        }
        _item.setGopayPaymentStatus(_tmpGopayPaymentStatus);
        final BigDecimal _tmpRounding;
        final String _tmp_10;
        if (_cursor.isNull(_cursorIndexOfRounding)) {
          _tmp_10 = null;
        } else {
          _tmp_10 = _cursor.getString(_cursorIndexOfRounding);
        }
        _tmpRounding = __converters.stringToBigDecimal(_tmp_10);
        _item.setRounding(_tmpRounding);
        final int _tmpChannelId;
        _tmpChannelId = _cursor.getInt(_cursorIndexOfChannelId);
        _item.setChannelId(_tmpChannelId);
        final String _tmpVoidNote;
        if (_cursor.isNull(_cursorIndexOfVoidNote)) {
          _tmpVoidNote = null;
        } else {
          _tmpVoidNote = _cursor.getString(_cursorIndexOfVoidNote);
        }
        _item.setVoidNote(_tmpVoidNote);
        final Date _tmpCreatedAt;
        final Long _tmp_11;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_11 = null;
        } else {
          _tmp_11 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp_11);
        _item.setCreatedAt(_tmpCreatedAt);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        _item.setCreatedBy(_tmpCreatedBy);
        final Date _tmpUpdatedAt;
        final Long _tmp_12;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmp_12 = null;
        } else {
          _tmp_12 = _cursor.getLong(_cursorIndexOfUpdatedAt);
        }
        _tmpUpdatedAt = __converters.longToDate(_tmp_12);
        _item.setUpdatedAt(_tmpUpdatedAt);
        final int _tmpUpdatedBy;
        _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        _item.setUpdatedBy(_tmpUpdatedBy);
        final Integer _tmpCrcId;
        if (_cursor.isNull(_cursorIndexOfCrcId)) {
          _tmpCrcId = null;
        } else {
          _tmpCrcId = _cursor.getInt(_cursorIndexOfCrcId);
        }
        _item.setCrcId(_tmpCrcId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<SaleEntity> getSaleByPosses(final int id) {
    final String _sql = "SELECT * FROM sale WHERE posses_id = ? AND draft = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxOrderNum = CursorUtil.getColumnIndexOrThrow(_cursor, "trx_ordernum");
      final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(_cursor, "trx_no");
      final int _cursorIndexOfIsDraft = CursorUtil.getColumnIndexOrThrow(_cursor, "draft");
      final int _cursorIndexOfSubtotal = CursorUtil.getColumnIndexOrThrow(_cursor, "subtotal");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfOprName = CursorUtil.getColumnIndexOrThrow(_cursor, "opr_name");
      final int _cursorIndexOfCashiername = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_name");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trx_date");
      final int _cursorIndexOfTotPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "paidamt");
      final int _cursorIndexOfTotChange = CursorUtil.getColumnIndexOrThrow(_cursor, "changeamt");
      final int _cursorIndexOfTaxAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "taxamt");
      final int _cursorIndexOfDiscAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "discamt");
      final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(_cursor, "posses_id");
      final int _cursorIndexOfKodePosses = CursorUtil.getColumnIndexOrThrow(_cursor, "kode_posses");
      final int _cursorIndexOfDiscExp = CursorUtil.getColumnIndexOrThrow(_cursor, "discexp");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfBpId = CursorUtil.getColumnIndexOrThrow(_cursor, "bp_id");
      final int _cursorIndexOfBpName = CursorUtil.getColumnIndexOrThrow(_cursor, "bp_name");
      final int _cursorIndexOfTermType = CursorUtil.getColumnIndexOrThrow(_cursor, "termtype");
      final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isuploaded");
      final int _cursorIndexOfIsVoid = CursorUtil.getColumnIndexOrThrow(_cursor, "isvoid");
      final int _cursorIndexOfGopayUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url_qrcode");
      final int _cursorIndexOfGopayTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transaction_id");
      final int _cursorIndexOfGopayPaymentStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "gopay_paymentstatus");
      final int _cursorIndexOfRounding = CursorUtil.getColumnIndexOrThrow(_cursor, "rounding");
      final int _cursorIndexOfChannelId = CursorUtil.getColumnIndexOrThrow(_cursor, "channel_id");
      final int _cursorIndexOfVoidNote = CursorUtil.getColumnIndexOrThrow(_cursor, "void_note");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "created_by");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_by");
      final int _cursorIndexOfCrcId = CursorUtil.getColumnIndexOrThrow(_cursor, "crc_id");
      final List<SaleEntity> _result = new ArrayList<SaleEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SaleEntity _item;
        _item = new SaleEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final int _tmpTrxOrderNum;
        _tmpTrxOrderNum = _cursor.getInt(_cursorIndexOfTrxOrderNum);
        _item.setTrxOrderNum(_tmpTrxOrderNum);
        final String _tmpTrxNo;
        if (_cursor.isNull(_cursorIndexOfTrxNo)) {
          _tmpTrxNo = null;
        } else {
          _tmpTrxNo = _cursor.getString(_cursorIndexOfTrxNo);
        }
        _item.setTrxNo(_tmpTrxNo);
        final boolean _tmpIsDraft;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsDraft);
        _tmpIsDraft = _tmp != 0;
        _item.setDraft(_tmpIsDraft);
        final BigDecimal _tmpSubtotal;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfSubtotal)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfSubtotal);
        }
        _tmpSubtotal = __converters.stringToBigDecimal(_tmp_1);
        _item.setSubtotal(_tmpSubtotal);
        final BigDecimal _tmpTotal;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfTotal)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfTotal);
        }
        _tmpTotal = __converters.stringToBigDecimal(_tmp_2);
        _item.setTotal(_tmpTotal);
        final String _tmpOprName;
        if (_cursor.isNull(_cursorIndexOfOprName)) {
          _tmpOprName = null;
        } else {
          _tmpOprName = _cursor.getString(_cursorIndexOfOprName);
        }
        _item.setOprName(_tmpOprName);
        final String _tmpCashiername;
        if (_cursor.isNull(_cursorIndexOfCashiername)) {
          _tmpCashiername = null;
        } else {
          _tmpCashiername = _cursor.getString(_cursorIndexOfCashiername);
        }
        _item.setCashiername(_tmpCashiername);
        final Date _tmpTrxDate;
        final Long _tmp_3;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getLong(_cursorIndexOfTrxDate);
        }
        _tmpTrxDate = __converters.longToDate(_tmp_3);
        _item.setTrxDate(_tmpTrxDate);
        final BigDecimal _tmpTotPaid;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfTotPaid)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfTotPaid);
        }
        _tmpTotPaid = __converters.stringToBigDecimal(_tmp_4);
        _item.setTotPaid(_tmpTotPaid);
        final BigDecimal _tmpTotChange;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfTotChange)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfTotChange);
        }
        _tmpTotChange = __converters.stringToBigDecimal(_tmp_5);
        _item.setTotChange(_tmpTotChange);
        final BigDecimal _tmpTaxAmt;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfTaxAmt)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfTaxAmt);
        }
        _tmpTaxAmt = __converters.stringToBigDecimal(_tmp_6);
        _item.setTaxAmt(_tmpTaxAmt);
        final BigDecimal _tmpDiscAmt;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfDiscAmt)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfDiscAmt);
        }
        _tmpDiscAmt = __converters.stringToBigDecimal(_tmp_7);
        _item.setDiscAmt(_tmpDiscAmt);
        final int _tmpPossesId;
        _tmpPossesId = _cursor.getInt(_cursorIndexOfPossesId);
        _item.setPossesId(_tmpPossesId);
        final String _tmpKodePosses;
        if (_cursor.isNull(_cursorIndexOfKodePosses)) {
          _tmpKodePosses = null;
        } else {
          _tmpKodePosses = _cursor.getString(_cursorIndexOfKodePosses);
        }
        _item.setKodePosses(_tmpKodePosses);
        final String _tmpDiscExp;
        if (_cursor.isNull(_cursorIndexOfDiscExp)) {
          _tmpDiscExp = null;
        } else {
          _tmpDiscExp = _cursor.getString(_cursorIndexOfDiscExp);
        }
        _item.setDiscExp(_tmpDiscExp);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        _item.setUserId(_tmpUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        _item.setCashierId(_tmpCashierId);
        final int _tmpBpId;
        _tmpBpId = _cursor.getInt(_cursorIndexOfBpId);
        _item.setBpId(_tmpBpId);
        final String _tmpBpName;
        if (_cursor.isNull(_cursorIndexOfBpName)) {
          _tmpBpName = null;
        } else {
          _tmpBpName = _cursor.getString(_cursorIndexOfBpName);
        }
        _item.setBpName(_tmpBpName);
        final String _tmpTermType;
        if (_cursor.isNull(_cursorIndexOfTermType)) {
          _tmpTermType = null;
        } else {
          _tmpTermType = _cursor.getString(_cursorIndexOfTermType);
        }
        _item.setTermType(_tmpTermType);
        final boolean _tmpIsUploaded;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfIsUploaded);
        _tmpIsUploaded = _tmp_8 != 0;
        _item.setUploaded(_tmpIsUploaded);
        final boolean _tmpIsVoid;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfIsVoid);
        _tmpIsVoid = _tmp_9 != 0;
        _item.setVoid(_tmpIsVoid);
        final String _tmpGopayUrl;
        if (_cursor.isNull(_cursorIndexOfGopayUrl)) {
          _tmpGopayUrl = null;
        } else {
          _tmpGopayUrl = _cursor.getString(_cursorIndexOfGopayUrl);
        }
        _item.setGopayUrl(_tmpGopayUrl);
        final String _tmpGopayTransactionId;
        if (_cursor.isNull(_cursorIndexOfGopayTransactionId)) {
          _tmpGopayTransactionId = null;
        } else {
          _tmpGopayTransactionId = _cursor.getString(_cursorIndexOfGopayTransactionId);
        }
        _item.setGopayTransactionId(_tmpGopayTransactionId);
        final String _tmpGopayPaymentStatus;
        if (_cursor.isNull(_cursorIndexOfGopayPaymentStatus)) {
          _tmpGopayPaymentStatus = null;
        } else {
          _tmpGopayPaymentStatus = _cursor.getString(_cursorIndexOfGopayPaymentStatus);
        }
        _item.setGopayPaymentStatus(_tmpGopayPaymentStatus);
        final BigDecimal _tmpRounding;
        final String _tmp_10;
        if (_cursor.isNull(_cursorIndexOfRounding)) {
          _tmp_10 = null;
        } else {
          _tmp_10 = _cursor.getString(_cursorIndexOfRounding);
        }
        _tmpRounding = __converters.stringToBigDecimal(_tmp_10);
        _item.setRounding(_tmpRounding);
        final int _tmpChannelId;
        _tmpChannelId = _cursor.getInt(_cursorIndexOfChannelId);
        _item.setChannelId(_tmpChannelId);
        final String _tmpVoidNote;
        if (_cursor.isNull(_cursorIndexOfVoidNote)) {
          _tmpVoidNote = null;
        } else {
          _tmpVoidNote = _cursor.getString(_cursorIndexOfVoidNote);
        }
        _item.setVoidNote(_tmpVoidNote);
        final Date _tmpCreatedAt;
        final Long _tmp_11;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_11 = null;
        } else {
          _tmp_11 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converters.longToDate(_tmp_11);
        _item.setCreatedAt(_tmpCreatedAt);
        final int _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getInt(_cursorIndexOfCreatedBy);
        _item.setCreatedBy(_tmpCreatedBy);
        final Date _tmpUpdatedAt;
        final Long _tmp_12;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmp_12 = null;
        } else {
          _tmp_12 = _cursor.getLong(_cursorIndexOfUpdatedAt);
        }
        _tmpUpdatedAt = __converters.longToDate(_tmp_12);
        _item.setUpdatedAt(_tmpUpdatedAt);
        final int _tmpUpdatedBy;
        _tmpUpdatedBy = _cursor.getInt(_cursorIndexOfUpdatedBy);
        _item.setUpdatedBy(_tmpUpdatedBy);
        final Integer _tmpCrcId;
        if (_cursor.isNull(_cursorIndexOfCrcId)) {
          _tmpCrcId = null;
        } else {
          _tmpCrcId = _cursor.getInt(_cursorIndexOfCrcId);
        }
        _item.setCrcId(_tmpCrcId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public BigDecimal getTotalNota(final int id) {
    final String _sql = "SELECT COUNT(*) FROM sale WHERE posses_id = ? and isvoid = 0 and draft = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final BigDecimal _result;
      if(_cursor.moveToFirst()) {
        final String _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(0);
        }
        _result = __converters.stringToBigDecimal(_tmp);
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
  public BigDecimal getTotalNotaVoid(final int id) {
    final String _sql = "SELECT COUNT(*) FROM sale WHERE posses_id = ? and isvoid = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final BigDecimal _result;
      if(_cursor.moveToFirst()) {
        final String _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(0);
        }
        _result = __converters.stringToBigDecimal(_tmp);
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
  public BigDecimal getTotalPaidTunai(final int id) {
    final String _sql = "SELECT SUM(total) FROM sale WHERE posses_id = ? and termtype = 'TUNAI' and isvoid = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final BigDecimal _result;
      if(_cursor.moveToFirst()) {
        final String _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(0);
        }
        _result = __converters.stringToBigDecimal(_tmp);
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
  public BigDecimal getTotalPaidDebit(final int id) {
    final String _sql = "SELECT SUM(total) FROM sale WHERE posses_id = ? and termtype = 'Debit Card' and isvoid = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final BigDecimal _result;
      if(_cursor.moveToFirst()) {
        final String _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(0);
        }
        _result = __converters.stringToBigDecimal(_tmp);
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
  public BigDecimal getTotalPaidKredit(final int id) {
    final String _sql = "SELECT SUM(total) FROM sale WHERE posses_id = ? and termtype = 'Credit Card' and isvoid = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final BigDecimal _result;
      if(_cursor.moveToFirst()) {
        final String _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(0);
        }
        _result = __converters.stringToBigDecimal(_tmp);
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
  public BigDecimal getTotalPaidGopay(final int id) {
    final String _sql = "SELECT SUM(total) FROM sale WHERE posses_id = ? and termtype = 'GOPAY' and isvoid = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final BigDecimal _result;
      if(_cursor.moveToFirst()) {
        final String _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(0);
        }
        _result = __converters.stringToBigDecimal(_tmp);
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
