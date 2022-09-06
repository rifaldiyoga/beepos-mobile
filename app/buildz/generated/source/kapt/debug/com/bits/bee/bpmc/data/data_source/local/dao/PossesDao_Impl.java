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
import com.bits.bee.bpmc.data.data_source.local.model.PossesEntity;
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
public final class PossesDao_Impl implements PossesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PossesEntity> __insertionAdapterOfPossesEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<PossesEntity> __deletionAdapterOfPossesEntity;

  private final EntityDeletionOrUpdateAdapter<PossesEntity> __updateAdapterOfPossesEntity;

  public PossesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPossesEntity = new EntityInsertionAdapter<PossesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `posses` (`id`,`trxdate`,`starttime`,`endtime`,`startbal`,`endbal`,`total`,`credit`,`shift`,`user_id`,`cashier_id`,`trxno`,`totin`,`totout`,`endcash`,`totactualcash`,`totdiffcash`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PossesEntity value) {
        if (value.getPossesId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getPossesId());
        }
        final Long _tmp = __converters.dateToLong(value.getTrxDate());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, _tmp);
        }
        final Long _tmp_1 = __converters.dateToLong(value.getStartTime());
        if (_tmp_1 == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp_1);
        }
        final Long _tmp_2 = __converters.dateToLong(value.getEndTime());
        if (_tmp_2 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp_2);
        }
        final String _tmp_3 = __converters.bigDecimalToString(value.getStartBal());
        if (_tmp_3 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_3);
        }
        final String _tmp_4 = __converters.bigDecimalToString(value.getEndBal());
        if (_tmp_4 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_4);
        }
        final String _tmp_5 = __converters.bigDecimalToString(value.getTotal());
        if (_tmp_5 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_5);
        }
        final String _tmp_6 = __converters.bigDecimalToString(value.getCredit());
        if (_tmp_6 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_6);
        }
        stmt.bindLong(9, value.getShift());
        stmt.bindLong(10, value.getUserId());
        stmt.bindLong(11, value.getCashierId());
        if (value.getTrxNo() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getTrxNo());
        }
        final String _tmp_7 = __converters.bigDecimalToString(value.getTotIn());
        if (_tmp_7 == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, _tmp_7);
        }
        final String _tmp_8 = __converters.bigDecimalToString(value.getTotOut());
        if (_tmp_8 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, _tmp_8);
        }
        final String _tmp_9 = __converters.bigDecimalToString(value.getEndCash());
        if (_tmp_9 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, _tmp_9);
        }
        final String _tmp_10 = __converters.bigDecimalToString(value.getTotalActualCash());
        if (_tmp_10 == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, _tmp_10);
        }
        final String _tmp_11 = __converters.bigDecimalToString(value.getTotalDiffCash());
        if (_tmp_11 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, _tmp_11);
        }
      }
    };
    this.__deletionAdapterOfPossesEntity = new EntityDeletionOrUpdateAdapter<PossesEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `posses` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PossesEntity value) {
        if (value.getPossesId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getPossesId());
        }
      }
    };
    this.__updateAdapterOfPossesEntity = new EntityDeletionOrUpdateAdapter<PossesEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `posses` SET `id` = ?,`trxdate` = ?,`starttime` = ?,`endtime` = ?,`startbal` = ?,`endbal` = ?,`total` = ?,`credit` = ?,`shift` = ?,`user_id` = ?,`cashier_id` = ?,`trxno` = ?,`totin` = ?,`totout` = ?,`endcash` = ?,`totactualcash` = ?,`totdiffcash` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PossesEntity value) {
        if (value.getPossesId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getPossesId());
        }
        final Long _tmp = __converters.dateToLong(value.getTrxDate());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, _tmp);
        }
        final Long _tmp_1 = __converters.dateToLong(value.getStartTime());
        if (_tmp_1 == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp_1);
        }
        final Long _tmp_2 = __converters.dateToLong(value.getEndTime());
        if (_tmp_2 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp_2);
        }
        final String _tmp_3 = __converters.bigDecimalToString(value.getStartBal());
        if (_tmp_3 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_3);
        }
        final String _tmp_4 = __converters.bigDecimalToString(value.getEndBal());
        if (_tmp_4 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_4);
        }
        final String _tmp_5 = __converters.bigDecimalToString(value.getTotal());
        if (_tmp_5 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_5);
        }
        final String _tmp_6 = __converters.bigDecimalToString(value.getCredit());
        if (_tmp_6 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_6);
        }
        stmt.bindLong(9, value.getShift());
        stmt.bindLong(10, value.getUserId());
        stmt.bindLong(11, value.getCashierId());
        if (value.getTrxNo() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getTrxNo());
        }
        final String _tmp_7 = __converters.bigDecimalToString(value.getTotIn());
        if (_tmp_7 == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, _tmp_7);
        }
        final String _tmp_8 = __converters.bigDecimalToString(value.getTotOut());
        if (_tmp_8 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, _tmp_8);
        }
        final String _tmp_9 = __converters.bigDecimalToString(value.getEndCash());
        if (_tmp_9 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, _tmp_9);
        }
        final String _tmp_10 = __converters.bigDecimalToString(value.getTotalActualCash());
        if (_tmp_10 == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, _tmp_10);
        }
        final String _tmp_11 = __converters.bigDecimalToString(value.getTotalDiffCash());
        if (_tmp_11 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, _tmp_11);
        }
        if (value.getPossesId() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindLong(18, value.getPossesId());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends PossesEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final PossesEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends PossesEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPossesEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final PossesEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPossesEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final PossesEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPossesEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public PossesEntity getActivePosses() {
    final String _sql = "SELECT * FROM posses WHERE endbal is null";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trxdate");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "starttime");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endtime");
      final int _cursorIndexOfStartBal = CursorUtil.getColumnIndexOrThrow(_cursor, "startbal");
      final int _cursorIndexOfEndBal = CursorUtil.getColumnIndexOrThrow(_cursor, "endbal");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfCredit = CursorUtil.getColumnIndexOrThrow(_cursor, "credit");
      final int _cursorIndexOfShift = CursorUtil.getColumnIndexOrThrow(_cursor, "shift");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(_cursor, "trxno");
      final int _cursorIndexOfTotIn = CursorUtil.getColumnIndexOrThrow(_cursor, "totin");
      final int _cursorIndexOfTotOut = CursorUtil.getColumnIndexOrThrow(_cursor, "totout");
      final int _cursorIndexOfEndCash = CursorUtil.getColumnIndexOrThrow(_cursor, "endcash");
      final int _cursorIndexOfTotalActualCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totactualcash");
      final int _cursorIndexOfTotalDiffCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totdiffcash");
      final PossesEntity _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmpPossesId;
        if (_cursor.isNull(_cursorIndexOfPossesId)) {
          _tmpPossesId = null;
        } else {
          _tmpPossesId = _cursor.getInt(_cursorIndexOfPossesId);
        }
        final Date _tmpTrxDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfTrxDate);
        }
        _tmpTrxDate = __converters.longToDate(_tmp);
        final Date _tmpStartTime;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfStartTime);
        }
        _tmpStartTime = __converters.longToDate(_tmp_1);
        final Date _tmpEndTime;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfEndTime)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfEndTime);
        }
        _tmpEndTime = __converters.longToDate(_tmp_2);
        final BigDecimal _tmpStartBal;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfStartBal)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfStartBal);
        }
        _tmpStartBal = __converters.stringToBigDecimal(_tmp_3);
        final BigDecimal _tmpEndBal;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfEndBal)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfEndBal);
        }
        _tmpEndBal = __converters.stringToBigDecimal(_tmp_4);
        final BigDecimal _tmpTotal;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfTotal)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfTotal);
        }
        _tmpTotal = __converters.stringToBigDecimal(_tmp_5);
        final BigDecimal _tmpCredit;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfCredit)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfCredit);
        }
        _tmpCredit = __converters.stringToBigDecimal(_tmp_6);
        final int _tmpShift;
        _tmpShift = _cursor.getInt(_cursorIndexOfShift);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        final String _tmpTrxNo;
        if (_cursor.isNull(_cursorIndexOfTrxNo)) {
          _tmpTrxNo = null;
        } else {
          _tmpTrxNo = _cursor.getString(_cursorIndexOfTrxNo);
        }
        final BigDecimal _tmpTotIn;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfTotIn)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfTotIn);
        }
        _tmpTotIn = __converters.stringToBigDecimal(_tmp_7);
        final BigDecimal _tmpTotOut;
        final String _tmp_8;
        if (_cursor.isNull(_cursorIndexOfTotOut)) {
          _tmp_8 = null;
        } else {
          _tmp_8 = _cursor.getString(_cursorIndexOfTotOut);
        }
        _tmpTotOut = __converters.stringToBigDecimal(_tmp_8);
        final BigDecimal _tmpEndCash;
        final String _tmp_9;
        if (_cursor.isNull(_cursorIndexOfEndCash)) {
          _tmp_9 = null;
        } else {
          _tmp_9 = _cursor.getString(_cursorIndexOfEndCash);
        }
        _tmpEndCash = __converters.stringToBigDecimal(_tmp_9);
        final BigDecimal _tmpTotalActualCash;
        final String _tmp_10;
        if (_cursor.isNull(_cursorIndexOfTotalActualCash)) {
          _tmp_10 = null;
        } else {
          _tmp_10 = _cursor.getString(_cursorIndexOfTotalActualCash);
        }
        _tmpTotalActualCash = __converters.stringToBigDecimal(_tmp_10);
        final BigDecimal _tmpTotalDiffCash;
        final String _tmp_11;
        if (_cursor.isNull(_cursorIndexOfTotalDiffCash)) {
          _tmp_11 = null;
        } else {
          _tmp_11 = _cursor.getString(_cursorIndexOfTotalDiffCash);
        }
        _tmpTotalDiffCash = __converters.stringToBigDecimal(_tmp_11);
        _result = new PossesEntity(_tmpPossesId,_tmpTrxDate,_tmpStartTime,_tmpEndTime,_tmpStartBal,_tmpEndBal,_tmpTotal,_tmpCredit,_tmpShift,_tmpUserId,_tmpCashierId,_tmpTrxNo,_tmpTotIn,_tmpTotOut,_tmpEndCash,_tmpTotalActualCash,_tmpTotalDiffCash);
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
  public PagingSource<Integer, PossesEntity> getListPosses() {
    final String _sql = "SELECT * FROM posses WHERE endbal is null";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new LimitOffsetPagingSource<PossesEntity>(_statement, __db, "posses") {
      @Override
      protected List<PossesEntity> convertRows(Cursor cursor) {
        final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(cursor, "trxdate");
        final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(cursor, "starttime");
        final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(cursor, "endtime");
        final int _cursorIndexOfStartBal = CursorUtil.getColumnIndexOrThrow(cursor, "startbal");
        final int _cursorIndexOfEndBal = CursorUtil.getColumnIndexOrThrow(cursor, "endbal");
        final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(cursor, "total");
        final int _cursorIndexOfCredit = CursorUtil.getColumnIndexOrThrow(cursor, "credit");
        final int _cursorIndexOfShift = CursorUtil.getColumnIndexOrThrow(cursor, "shift");
        final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(cursor, "user_id");
        final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(cursor, "cashier_id");
        final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(cursor, "trxno");
        final int _cursorIndexOfTotIn = CursorUtil.getColumnIndexOrThrow(cursor, "totin");
        final int _cursorIndexOfTotOut = CursorUtil.getColumnIndexOrThrow(cursor, "totout");
        final int _cursorIndexOfEndCash = CursorUtil.getColumnIndexOrThrow(cursor, "endcash");
        final int _cursorIndexOfTotalActualCash = CursorUtil.getColumnIndexOrThrow(cursor, "totactualcash");
        final int _cursorIndexOfTotalDiffCash = CursorUtil.getColumnIndexOrThrow(cursor, "totdiffcash");
        final List<PossesEntity> _result = new ArrayList<PossesEntity>(cursor.getCount());
        while(cursor.moveToNext()) {
          final PossesEntity _item;
          final Integer _tmpPossesId;
          if (cursor.isNull(_cursorIndexOfPossesId)) {
            _tmpPossesId = null;
          } else {
            _tmpPossesId = cursor.getInt(_cursorIndexOfPossesId);
          }
          final Date _tmpTrxDate;
          final Long _tmp;
          if (cursor.isNull(_cursorIndexOfTrxDate)) {
            _tmp = null;
          } else {
            _tmp = cursor.getLong(_cursorIndexOfTrxDate);
          }
          _tmpTrxDate = __converters.longToDate(_tmp);
          final Date _tmpStartTime;
          final Long _tmp_1;
          if (cursor.isNull(_cursorIndexOfStartTime)) {
            _tmp_1 = null;
          } else {
            _tmp_1 = cursor.getLong(_cursorIndexOfStartTime);
          }
          _tmpStartTime = __converters.longToDate(_tmp_1);
          final Date _tmpEndTime;
          final Long _tmp_2;
          if (cursor.isNull(_cursorIndexOfEndTime)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = cursor.getLong(_cursorIndexOfEndTime);
          }
          _tmpEndTime = __converters.longToDate(_tmp_2);
          final BigDecimal _tmpStartBal;
          final String _tmp_3;
          if (cursor.isNull(_cursorIndexOfStartBal)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = cursor.getString(_cursorIndexOfStartBal);
          }
          _tmpStartBal = __converters.stringToBigDecimal(_tmp_3);
          final BigDecimal _tmpEndBal;
          final String _tmp_4;
          if (cursor.isNull(_cursorIndexOfEndBal)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = cursor.getString(_cursorIndexOfEndBal);
          }
          _tmpEndBal = __converters.stringToBigDecimal(_tmp_4);
          final BigDecimal _tmpTotal;
          final String _tmp_5;
          if (cursor.isNull(_cursorIndexOfTotal)) {
            _tmp_5 = null;
          } else {
            _tmp_5 = cursor.getString(_cursorIndexOfTotal);
          }
          _tmpTotal = __converters.stringToBigDecimal(_tmp_5);
          final BigDecimal _tmpCredit;
          final String _tmp_6;
          if (cursor.isNull(_cursorIndexOfCredit)) {
            _tmp_6 = null;
          } else {
            _tmp_6 = cursor.getString(_cursorIndexOfCredit);
          }
          _tmpCredit = __converters.stringToBigDecimal(_tmp_6);
          final int _tmpShift;
          _tmpShift = cursor.getInt(_cursorIndexOfShift);
          final int _tmpUserId;
          _tmpUserId = cursor.getInt(_cursorIndexOfUserId);
          final int _tmpCashierId;
          _tmpCashierId = cursor.getInt(_cursorIndexOfCashierId);
          final String _tmpTrxNo;
          if (cursor.isNull(_cursorIndexOfTrxNo)) {
            _tmpTrxNo = null;
          } else {
            _tmpTrxNo = cursor.getString(_cursorIndexOfTrxNo);
          }
          final BigDecimal _tmpTotIn;
          final String _tmp_7;
          if (cursor.isNull(_cursorIndexOfTotIn)) {
            _tmp_7 = null;
          } else {
            _tmp_7 = cursor.getString(_cursorIndexOfTotIn);
          }
          _tmpTotIn = __converters.stringToBigDecimal(_tmp_7);
          final BigDecimal _tmpTotOut;
          final String _tmp_8;
          if (cursor.isNull(_cursorIndexOfTotOut)) {
            _tmp_8 = null;
          } else {
            _tmp_8 = cursor.getString(_cursorIndexOfTotOut);
          }
          _tmpTotOut = __converters.stringToBigDecimal(_tmp_8);
          final BigDecimal _tmpEndCash;
          final String _tmp_9;
          if (cursor.isNull(_cursorIndexOfEndCash)) {
            _tmp_9 = null;
          } else {
            _tmp_9 = cursor.getString(_cursorIndexOfEndCash);
          }
          _tmpEndCash = __converters.stringToBigDecimal(_tmp_9);
          final BigDecimal _tmpTotalActualCash;
          final String _tmp_10;
          if (cursor.isNull(_cursorIndexOfTotalActualCash)) {
            _tmp_10 = null;
          } else {
            _tmp_10 = cursor.getString(_cursorIndexOfTotalActualCash);
          }
          _tmpTotalActualCash = __converters.stringToBigDecimal(_tmp_10);
          final BigDecimal _tmpTotalDiffCash;
          final String _tmp_11;
          if (cursor.isNull(_cursorIndexOfTotalDiffCash)) {
            _tmp_11 = null;
          } else {
            _tmp_11 = cursor.getString(_cursorIndexOfTotalDiffCash);
          }
          _tmpTotalDiffCash = __converters.stringToBigDecimal(_tmp_11);
          _item = new PossesEntity(_tmpPossesId,_tmpTrxDate,_tmpStartTime,_tmpEndTime,_tmpStartBal,_tmpEndBal,_tmpTotal,_tmpCredit,_tmpShift,_tmpUserId,_tmpCashierId,_tmpTrxNo,_tmpTotIn,_tmpTotOut,_tmpEndCash,_tmpTotalActualCash,_tmpTotalDiffCash);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @Override
  public PossesEntity getPossesById(final int id) {
    final String _sql = "SELECT * FROM posses WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trxdate");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "starttime");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endtime");
      final int _cursorIndexOfStartBal = CursorUtil.getColumnIndexOrThrow(_cursor, "startbal");
      final int _cursorIndexOfEndBal = CursorUtil.getColumnIndexOrThrow(_cursor, "endbal");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfCredit = CursorUtil.getColumnIndexOrThrow(_cursor, "credit");
      final int _cursorIndexOfShift = CursorUtil.getColumnIndexOrThrow(_cursor, "shift");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(_cursor, "trxno");
      final int _cursorIndexOfTotIn = CursorUtil.getColumnIndexOrThrow(_cursor, "totin");
      final int _cursorIndexOfTotOut = CursorUtil.getColumnIndexOrThrow(_cursor, "totout");
      final int _cursorIndexOfEndCash = CursorUtil.getColumnIndexOrThrow(_cursor, "endcash");
      final int _cursorIndexOfTotalActualCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totactualcash");
      final int _cursorIndexOfTotalDiffCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totdiffcash");
      final PossesEntity _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmpPossesId;
        if (_cursor.isNull(_cursorIndexOfPossesId)) {
          _tmpPossesId = null;
        } else {
          _tmpPossesId = _cursor.getInt(_cursorIndexOfPossesId);
        }
        final Date _tmpTrxDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfTrxDate);
        }
        _tmpTrxDate = __converters.longToDate(_tmp);
        final Date _tmpStartTime;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfStartTime);
        }
        _tmpStartTime = __converters.longToDate(_tmp_1);
        final Date _tmpEndTime;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfEndTime)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfEndTime);
        }
        _tmpEndTime = __converters.longToDate(_tmp_2);
        final BigDecimal _tmpStartBal;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfStartBal)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfStartBal);
        }
        _tmpStartBal = __converters.stringToBigDecimal(_tmp_3);
        final BigDecimal _tmpEndBal;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfEndBal)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfEndBal);
        }
        _tmpEndBal = __converters.stringToBigDecimal(_tmp_4);
        final BigDecimal _tmpTotal;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfTotal)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfTotal);
        }
        _tmpTotal = __converters.stringToBigDecimal(_tmp_5);
        final BigDecimal _tmpCredit;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfCredit)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfCredit);
        }
        _tmpCredit = __converters.stringToBigDecimal(_tmp_6);
        final int _tmpShift;
        _tmpShift = _cursor.getInt(_cursorIndexOfShift);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        final String _tmpTrxNo;
        if (_cursor.isNull(_cursorIndexOfTrxNo)) {
          _tmpTrxNo = null;
        } else {
          _tmpTrxNo = _cursor.getString(_cursorIndexOfTrxNo);
        }
        final BigDecimal _tmpTotIn;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfTotIn)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfTotIn);
        }
        _tmpTotIn = __converters.stringToBigDecimal(_tmp_7);
        final BigDecimal _tmpTotOut;
        final String _tmp_8;
        if (_cursor.isNull(_cursorIndexOfTotOut)) {
          _tmp_8 = null;
        } else {
          _tmp_8 = _cursor.getString(_cursorIndexOfTotOut);
        }
        _tmpTotOut = __converters.stringToBigDecimal(_tmp_8);
        final BigDecimal _tmpEndCash;
        final String _tmp_9;
        if (_cursor.isNull(_cursorIndexOfEndCash)) {
          _tmp_9 = null;
        } else {
          _tmp_9 = _cursor.getString(_cursorIndexOfEndCash);
        }
        _tmpEndCash = __converters.stringToBigDecimal(_tmp_9);
        final BigDecimal _tmpTotalActualCash;
        final String _tmp_10;
        if (_cursor.isNull(_cursorIndexOfTotalActualCash)) {
          _tmp_10 = null;
        } else {
          _tmp_10 = _cursor.getString(_cursorIndexOfTotalActualCash);
        }
        _tmpTotalActualCash = __converters.stringToBigDecimal(_tmp_10);
        final BigDecimal _tmpTotalDiffCash;
        final String _tmp_11;
        if (_cursor.isNull(_cursorIndexOfTotalDiffCash)) {
          _tmp_11 = null;
        } else {
          _tmp_11 = _cursor.getString(_cursorIndexOfTotalDiffCash);
        }
        _tmpTotalDiffCash = __converters.stringToBigDecimal(_tmp_11);
        _result = new PossesEntity(_tmpPossesId,_tmpTrxDate,_tmpStartTime,_tmpEndTime,_tmpStartBal,_tmpEndBal,_tmpTotal,_tmpCredit,_tmpShift,_tmpUserId,_tmpCashierId,_tmpTrxNo,_tmpTotIn,_tmpTotOut,_tmpEndCash,_tmpTotalActualCash,_tmpTotalDiffCash);
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
  public PagingSource<Integer, PossesEntity> getPossesHistory() {
    final String _sql = "SELECT * FROM posses WHERE endbal is not null";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new LimitOffsetPagingSource<PossesEntity>(_statement, __db, "posses") {
      @Override
      protected List<PossesEntity> convertRows(Cursor cursor) {
        final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(cursor, "trxdate");
        final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(cursor, "starttime");
        final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(cursor, "endtime");
        final int _cursorIndexOfStartBal = CursorUtil.getColumnIndexOrThrow(cursor, "startbal");
        final int _cursorIndexOfEndBal = CursorUtil.getColumnIndexOrThrow(cursor, "endbal");
        final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(cursor, "total");
        final int _cursorIndexOfCredit = CursorUtil.getColumnIndexOrThrow(cursor, "credit");
        final int _cursorIndexOfShift = CursorUtil.getColumnIndexOrThrow(cursor, "shift");
        final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(cursor, "user_id");
        final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(cursor, "cashier_id");
        final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(cursor, "trxno");
        final int _cursorIndexOfTotIn = CursorUtil.getColumnIndexOrThrow(cursor, "totin");
        final int _cursorIndexOfTotOut = CursorUtil.getColumnIndexOrThrow(cursor, "totout");
        final int _cursorIndexOfEndCash = CursorUtil.getColumnIndexOrThrow(cursor, "endcash");
        final int _cursorIndexOfTotalActualCash = CursorUtil.getColumnIndexOrThrow(cursor, "totactualcash");
        final int _cursorIndexOfTotalDiffCash = CursorUtil.getColumnIndexOrThrow(cursor, "totdiffcash");
        final List<PossesEntity> _result = new ArrayList<PossesEntity>(cursor.getCount());
        while(cursor.moveToNext()) {
          final PossesEntity _item;
          final Integer _tmpPossesId;
          if (cursor.isNull(_cursorIndexOfPossesId)) {
            _tmpPossesId = null;
          } else {
            _tmpPossesId = cursor.getInt(_cursorIndexOfPossesId);
          }
          final Date _tmpTrxDate;
          final Long _tmp;
          if (cursor.isNull(_cursorIndexOfTrxDate)) {
            _tmp = null;
          } else {
            _tmp = cursor.getLong(_cursorIndexOfTrxDate);
          }
          _tmpTrxDate = __converters.longToDate(_tmp);
          final Date _tmpStartTime;
          final Long _tmp_1;
          if (cursor.isNull(_cursorIndexOfStartTime)) {
            _tmp_1 = null;
          } else {
            _tmp_1 = cursor.getLong(_cursorIndexOfStartTime);
          }
          _tmpStartTime = __converters.longToDate(_tmp_1);
          final Date _tmpEndTime;
          final Long _tmp_2;
          if (cursor.isNull(_cursorIndexOfEndTime)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = cursor.getLong(_cursorIndexOfEndTime);
          }
          _tmpEndTime = __converters.longToDate(_tmp_2);
          final BigDecimal _tmpStartBal;
          final String _tmp_3;
          if (cursor.isNull(_cursorIndexOfStartBal)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = cursor.getString(_cursorIndexOfStartBal);
          }
          _tmpStartBal = __converters.stringToBigDecimal(_tmp_3);
          final BigDecimal _tmpEndBal;
          final String _tmp_4;
          if (cursor.isNull(_cursorIndexOfEndBal)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = cursor.getString(_cursorIndexOfEndBal);
          }
          _tmpEndBal = __converters.stringToBigDecimal(_tmp_4);
          final BigDecimal _tmpTotal;
          final String _tmp_5;
          if (cursor.isNull(_cursorIndexOfTotal)) {
            _tmp_5 = null;
          } else {
            _tmp_5 = cursor.getString(_cursorIndexOfTotal);
          }
          _tmpTotal = __converters.stringToBigDecimal(_tmp_5);
          final BigDecimal _tmpCredit;
          final String _tmp_6;
          if (cursor.isNull(_cursorIndexOfCredit)) {
            _tmp_6 = null;
          } else {
            _tmp_6 = cursor.getString(_cursorIndexOfCredit);
          }
          _tmpCredit = __converters.stringToBigDecimal(_tmp_6);
          final int _tmpShift;
          _tmpShift = cursor.getInt(_cursorIndexOfShift);
          final int _tmpUserId;
          _tmpUserId = cursor.getInt(_cursorIndexOfUserId);
          final int _tmpCashierId;
          _tmpCashierId = cursor.getInt(_cursorIndexOfCashierId);
          final String _tmpTrxNo;
          if (cursor.isNull(_cursorIndexOfTrxNo)) {
            _tmpTrxNo = null;
          } else {
            _tmpTrxNo = cursor.getString(_cursorIndexOfTrxNo);
          }
          final BigDecimal _tmpTotIn;
          final String _tmp_7;
          if (cursor.isNull(_cursorIndexOfTotIn)) {
            _tmp_7 = null;
          } else {
            _tmp_7 = cursor.getString(_cursorIndexOfTotIn);
          }
          _tmpTotIn = __converters.stringToBigDecimal(_tmp_7);
          final BigDecimal _tmpTotOut;
          final String _tmp_8;
          if (cursor.isNull(_cursorIndexOfTotOut)) {
            _tmp_8 = null;
          } else {
            _tmp_8 = cursor.getString(_cursorIndexOfTotOut);
          }
          _tmpTotOut = __converters.stringToBigDecimal(_tmp_8);
          final BigDecimal _tmpEndCash;
          final String _tmp_9;
          if (cursor.isNull(_cursorIndexOfEndCash)) {
            _tmp_9 = null;
          } else {
            _tmp_9 = cursor.getString(_cursorIndexOfEndCash);
          }
          _tmpEndCash = __converters.stringToBigDecimal(_tmp_9);
          final BigDecimal _tmpTotalActualCash;
          final String _tmp_10;
          if (cursor.isNull(_cursorIndexOfTotalActualCash)) {
            _tmp_10 = null;
          } else {
            _tmp_10 = cursor.getString(_cursorIndexOfTotalActualCash);
          }
          _tmpTotalActualCash = __converters.stringToBigDecimal(_tmp_10);
          final BigDecimal _tmpTotalDiffCash;
          final String _tmp_11;
          if (cursor.isNull(_cursorIndexOfTotalDiffCash)) {
            _tmp_11 = null;
          } else {
            _tmp_11 = cursor.getString(_cursorIndexOfTotalDiffCash);
          }
          _tmpTotalDiffCash = __converters.stringToBigDecimal(_tmp_11);
          _item = new PossesEntity(_tmpPossesId,_tmpTrxDate,_tmpStartTime,_tmpEndTime,_tmpStartBal,_tmpEndBal,_tmpTotal,_tmpCredit,_tmpShift,_tmpUserId,_tmpCashierId,_tmpTrxNo,_tmpTotIn,_tmpTotOut,_tmpEndCash,_tmpTotalActualCash,_tmpTotalDiffCash);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @Override
  public List<PossesEntity> getActivePossesList() {
    final String _sql = "SELECT * FROM posses WHERE endbal is null";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trxdate");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "starttime");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endtime");
      final int _cursorIndexOfStartBal = CursorUtil.getColumnIndexOrThrow(_cursor, "startbal");
      final int _cursorIndexOfEndBal = CursorUtil.getColumnIndexOrThrow(_cursor, "endbal");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfCredit = CursorUtil.getColumnIndexOrThrow(_cursor, "credit");
      final int _cursorIndexOfShift = CursorUtil.getColumnIndexOrThrow(_cursor, "shift");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(_cursor, "trxno");
      final int _cursorIndexOfTotIn = CursorUtil.getColumnIndexOrThrow(_cursor, "totin");
      final int _cursorIndexOfTotOut = CursorUtil.getColumnIndexOrThrow(_cursor, "totout");
      final int _cursorIndexOfEndCash = CursorUtil.getColumnIndexOrThrow(_cursor, "endcash");
      final int _cursorIndexOfTotalActualCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totactualcash");
      final int _cursorIndexOfTotalDiffCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totdiffcash");
      final List<PossesEntity> _result = new ArrayList<PossesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PossesEntity _item;
        final Integer _tmpPossesId;
        if (_cursor.isNull(_cursorIndexOfPossesId)) {
          _tmpPossesId = null;
        } else {
          _tmpPossesId = _cursor.getInt(_cursorIndexOfPossesId);
        }
        final Date _tmpTrxDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfTrxDate);
        }
        _tmpTrxDate = __converters.longToDate(_tmp);
        final Date _tmpStartTime;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfStartTime);
        }
        _tmpStartTime = __converters.longToDate(_tmp_1);
        final Date _tmpEndTime;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfEndTime)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfEndTime);
        }
        _tmpEndTime = __converters.longToDate(_tmp_2);
        final BigDecimal _tmpStartBal;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfStartBal)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfStartBal);
        }
        _tmpStartBal = __converters.stringToBigDecimal(_tmp_3);
        final BigDecimal _tmpEndBal;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfEndBal)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfEndBal);
        }
        _tmpEndBal = __converters.stringToBigDecimal(_tmp_4);
        final BigDecimal _tmpTotal;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfTotal)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfTotal);
        }
        _tmpTotal = __converters.stringToBigDecimal(_tmp_5);
        final BigDecimal _tmpCredit;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfCredit)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfCredit);
        }
        _tmpCredit = __converters.stringToBigDecimal(_tmp_6);
        final int _tmpShift;
        _tmpShift = _cursor.getInt(_cursorIndexOfShift);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        final String _tmpTrxNo;
        if (_cursor.isNull(_cursorIndexOfTrxNo)) {
          _tmpTrxNo = null;
        } else {
          _tmpTrxNo = _cursor.getString(_cursorIndexOfTrxNo);
        }
        final BigDecimal _tmpTotIn;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfTotIn)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfTotIn);
        }
        _tmpTotIn = __converters.stringToBigDecimal(_tmp_7);
        final BigDecimal _tmpTotOut;
        final String _tmp_8;
        if (_cursor.isNull(_cursorIndexOfTotOut)) {
          _tmp_8 = null;
        } else {
          _tmp_8 = _cursor.getString(_cursorIndexOfTotOut);
        }
        _tmpTotOut = __converters.stringToBigDecimal(_tmp_8);
        final BigDecimal _tmpEndCash;
        final String _tmp_9;
        if (_cursor.isNull(_cursorIndexOfEndCash)) {
          _tmp_9 = null;
        } else {
          _tmp_9 = _cursor.getString(_cursorIndexOfEndCash);
        }
        _tmpEndCash = __converters.stringToBigDecimal(_tmp_9);
        final BigDecimal _tmpTotalActualCash;
        final String _tmp_10;
        if (_cursor.isNull(_cursorIndexOfTotalActualCash)) {
          _tmp_10 = null;
        } else {
          _tmp_10 = _cursor.getString(_cursorIndexOfTotalActualCash);
        }
        _tmpTotalActualCash = __converters.stringToBigDecimal(_tmp_10);
        final BigDecimal _tmpTotalDiffCash;
        final String _tmp_11;
        if (_cursor.isNull(_cursorIndexOfTotalDiffCash)) {
          _tmp_11 = null;
        } else {
          _tmp_11 = _cursor.getString(_cursorIndexOfTotalDiffCash);
        }
        _tmpTotalDiffCash = __converters.stringToBigDecimal(_tmp_11);
        _item = new PossesEntity(_tmpPossesId,_tmpTrxDate,_tmpStartTime,_tmpEndTime,_tmpStartBal,_tmpEndBal,_tmpTotal,_tmpCredit,_tmpShift,_tmpUserId,_tmpCashierId,_tmpTrxNo,_tmpTotIn,_tmpTotOut,_tmpEndCash,_tmpTotalActualCash,_tmpTotalDiffCash);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public PagingSource<Integer, PossesEntity> searchSesi(final String query) {
    final String _sql = "SELECT * FROM posses WHERE shift LIKE '%'|| ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return new LimitOffsetPagingSource<PossesEntity>(_statement, __db, "posses") {
      @Override
      protected List<PossesEntity> convertRows(Cursor cursor) {
        final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(cursor, "trxdate");
        final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(cursor, "starttime");
        final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(cursor, "endtime");
        final int _cursorIndexOfStartBal = CursorUtil.getColumnIndexOrThrow(cursor, "startbal");
        final int _cursorIndexOfEndBal = CursorUtil.getColumnIndexOrThrow(cursor, "endbal");
        final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(cursor, "total");
        final int _cursorIndexOfCredit = CursorUtil.getColumnIndexOrThrow(cursor, "credit");
        final int _cursorIndexOfShift = CursorUtil.getColumnIndexOrThrow(cursor, "shift");
        final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(cursor, "user_id");
        final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(cursor, "cashier_id");
        final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(cursor, "trxno");
        final int _cursorIndexOfTotIn = CursorUtil.getColumnIndexOrThrow(cursor, "totin");
        final int _cursorIndexOfTotOut = CursorUtil.getColumnIndexOrThrow(cursor, "totout");
        final int _cursorIndexOfEndCash = CursorUtil.getColumnIndexOrThrow(cursor, "endcash");
        final int _cursorIndexOfTotalActualCash = CursorUtil.getColumnIndexOrThrow(cursor, "totactualcash");
        final int _cursorIndexOfTotalDiffCash = CursorUtil.getColumnIndexOrThrow(cursor, "totdiffcash");
        final List<PossesEntity> _result = new ArrayList<PossesEntity>(cursor.getCount());
        while(cursor.moveToNext()) {
          final PossesEntity _item;
          final Integer _tmpPossesId;
          if (cursor.isNull(_cursorIndexOfPossesId)) {
            _tmpPossesId = null;
          } else {
            _tmpPossesId = cursor.getInt(_cursorIndexOfPossesId);
          }
          final Date _tmpTrxDate;
          final Long _tmp;
          if (cursor.isNull(_cursorIndexOfTrxDate)) {
            _tmp = null;
          } else {
            _tmp = cursor.getLong(_cursorIndexOfTrxDate);
          }
          _tmpTrxDate = __converters.longToDate(_tmp);
          final Date _tmpStartTime;
          final Long _tmp_1;
          if (cursor.isNull(_cursorIndexOfStartTime)) {
            _tmp_1 = null;
          } else {
            _tmp_1 = cursor.getLong(_cursorIndexOfStartTime);
          }
          _tmpStartTime = __converters.longToDate(_tmp_1);
          final Date _tmpEndTime;
          final Long _tmp_2;
          if (cursor.isNull(_cursorIndexOfEndTime)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = cursor.getLong(_cursorIndexOfEndTime);
          }
          _tmpEndTime = __converters.longToDate(_tmp_2);
          final BigDecimal _tmpStartBal;
          final String _tmp_3;
          if (cursor.isNull(_cursorIndexOfStartBal)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = cursor.getString(_cursorIndexOfStartBal);
          }
          _tmpStartBal = __converters.stringToBigDecimal(_tmp_3);
          final BigDecimal _tmpEndBal;
          final String _tmp_4;
          if (cursor.isNull(_cursorIndexOfEndBal)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = cursor.getString(_cursorIndexOfEndBal);
          }
          _tmpEndBal = __converters.stringToBigDecimal(_tmp_4);
          final BigDecimal _tmpTotal;
          final String _tmp_5;
          if (cursor.isNull(_cursorIndexOfTotal)) {
            _tmp_5 = null;
          } else {
            _tmp_5 = cursor.getString(_cursorIndexOfTotal);
          }
          _tmpTotal = __converters.stringToBigDecimal(_tmp_5);
          final BigDecimal _tmpCredit;
          final String _tmp_6;
          if (cursor.isNull(_cursorIndexOfCredit)) {
            _tmp_6 = null;
          } else {
            _tmp_6 = cursor.getString(_cursorIndexOfCredit);
          }
          _tmpCredit = __converters.stringToBigDecimal(_tmp_6);
          final int _tmpShift;
          _tmpShift = cursor.getInt(_cursorIndexOfShift);
          final int _tmpUserId;
          _tmpUserId = cursor.getInt(_cursorIndexOfUserId);
          final int _tmpCashierId;
          _tmpCashierId = cursor.getInt(_cursorIndexOfCashierId);
          final String _tmpTrxNo;
          if (cursor.isNull(_cursorIndexOfTrxNo)) {
            _tmpTrxNo = null;
          } else {
            _tmpTrxNo = cursor.getString(_cursorIndexOfTrxNo);
          }
          final BigDecimal _tmpTotIn;
          final String _tmp_7;
          if (cursor.isNull(_cursorIndexOfTotIn)) {
            _tmp_7 = null;
          } else {
            _tmp_7 = cursor.getString(_cursorIndexOfTotIn);
          }
          _tmpTotIn = __converters.stringToBigDecimal(_tmp_7);
          final BigDecimal _tmpTotOut;
          final String _tmp_8;
          if (cursor.isNull(_cursorIndexOfTotOut)) {
            _tmp_8 = null;
          } else {
            _tmp_8 = cursor.getString(_cursorIndexOfTotOut);
          }
          _tmpTotOut = __converters.stringToBigDecimal(_tmp_8);
          final BigDecimal _tmpEndCash;
          final String _tmp_9;
          if (cursor.isNull(_cursorIndexOfEndCash)) {
            _tmp_9 = null;
          } else {
            _tmp_9 = cursor.getString(_cursorIndexOfEndCash);
          }
          _tmpEndCash = __converters.stringToBigDecimal(_tmp_9);
          final BigDecimal _tmpTotalActualCash;
          final String _tmp_10;
          if (cursor.isNull(_cursorIndexOfTotalActualCash)) {
            _tmp_10 = null;
          } else {
            _tmp_10 = cursor.getString(_cursorIndexOfTotalActualCash);
          }
          _tmpTotalActualCash = __converters.stringToBigDecimal(_tmp_10);
          final BigDecimal _tmpTotalDiffCash;
          final String _tmp_11;
          if (cursor.isNull(_cursorIndexOfTotalDiffCash)) {
            _tmp_11 = null;
          } else {
            _tmp_11 = cursor.getString(_cursorIndexOfTotalDiffCash);
          }
          _tmpTotalDiffCash = __converters.stringToBigDecimal(_tmp_11);
          _item = new PossesEntity(_tmpPossesId,_tmpTrxDate,_tmpStartTime,_tmpEndTime,_tmpStartBal,_tmpEndBal,_tmpTotal,_tmpCredit,_tmpShift,_tmpUserId,_tmpCashierId,_tmpTrxNo,_tmpTotIn,_tmpTotOut,_tmpEndCash,_tmpTotalActualCash,_tmpTotalDiffCash);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @Override
  public List<PossesEntity> getSortDesc() {
    final String _sql = "SELECT * FROM posses WHERE endbal is not null ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trxdate");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "starttime");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endtime");
      final int _cursorIndexOfStartBal = CursorUtil.getColumnIndexOrThrow(_cursor, "startbal");
      final int _cursorIndexOfEndBal = CursorUtil.getColumnIndexOrThrow(_cursor, "endbal");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfCredit = CursorUtil.getColumnIndexOrThrow(_cursor, "credit");
      final int _cursorIndexOfShift = CursorUtil.getColumnIndexOrThrow(_cursor, "shift");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(_cursor, "trxno");
      final int _cursorIndexOfTotIn = CursorUtil.getColumnIndexOrThrow(_cursor, "totin");
      final int _cursorIndexOfTotOut = CursorUtil.getColumnIndexOrThrow(_cursor, "totout");
      final int _cursorIndexOfEndCash = CursorUtil.getColumnIndexOrThrow(_cursor, "endcash");
      final int _cursorIndexOfTotalActualCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totactualcash");
      final int _cursorIndexOfTotalDiffCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totdiffcash");
      final List<PossesEntity> _result = new ArrayList<PossesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PossesEntity _item;
        final Integer _tmpPossesId;
        if (_cursor.isNull(_cursorIndexOfPossesId)) {
          _tmpPossesId = null;
        } else {
          _tmpPossesId = _cursor.getInt(_cursorIndexOfPossesId);
        }
        final Date _tmpTrxDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfTrxDate);
        }
        _tmpTrxDate = __converters.longToDate(_tmp);
        final Date _tmpStartTime;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfStartTime);
        }
        _tmpStartTime = __converters.longToDate(_tmp_1);
        final Date _tmpEndTime;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfEndTime)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfEndTime);
        }
        _tmpEndTime = __converters.longToDate(_tmp_2);
        final BigDecimal _tmpStartBal;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfStartBal)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfStartBal);
        }
        _tmpStartBal = __converters.stringToBigDecimal(_tmp_3);
        final BigDecimal _tmpEndBal;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfEndBal)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfEndBal);
        }
        _tmpEndBal = __converters.stringToBigDecimal(_tmp_4);
        final BigDecimal _tmpTotal;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfTotal)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfTotal);
        }
        _tmpTotal = __converters.stringToBigDecimal(_tmp_5);
        final BigDecimal _tmpCredit;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfCredit)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfCredit);
        }
        _tmpCredit = __converters.stringToBigDecimal(_tmp_6);
        final int _tmpShift;
        _tmpShift = _cursor.getInt(_cursorIndexOfShift);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        final String _tmpTrxNo;
        if (_cursor.isNull(_cursorIndexOfTrxNo)) {
          _tmpTrxNo = null;
        } else {
          _tmpTrxNo = _cursor.getString(_cursorIndexOfTrxNo);
        }
        final BigDecimal _tmpTotIn;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfTotIn)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfTotIn);
        }
        _tmpTotIn = __converters.stringToBigDecimal(_tmp_7);
        final BigDecimal _tmpTotOut;
        final String _tmp_8;
        if (_cursor.isNull(_cursorIndexOfTotOut)) {
          _tmp_8 = null;
        } else {
          _tmp_8 = _cursor.getString(_cursorIndexOfTotOut);
        }
        _tmpTotOut = __converters.stringToBigDecimal(_tmp_8);
        final BigDecimal _tmpEndCash;
        final String _tmp_9;
        if (_cursor.isNull(_cursorIndexOfEndCash)) {
          _tmp_9 = null;
        } else {
          _tmp_9 = _cursor.getString(_cursorIndexOfEndCash);
        }
        _tmpEndCash = __converters.stringToBigDecimal(_tmp_9);
        final BigDecimal _tmpTotalActualCash;
        final String _tmp_10;
        if (_cursor.isNull(_cursorIndexOfTotalActualCash)) {
          _tmp_10 = null;
        } else {
          _tmp_10 = _cursor.getString(_cursorIndexOfTotalActualCash);
        }
        _tmpTotalActualCash = __converters.stringToBigDecimal(_tmp_10);
        final BigDecimal _tmpTotalDiffCash;
        final String _tmp_11;
        if (_cursor.isNull(_cursorIndexOfTotalDiffCash)) {
          _tmp_11 = null;
        } else {
          _tmp_11 = _cursor.getString(_cursorIndexOfTotalDiffCash);
        }
        _tmpTotalDiffCash = __converters.stringToBigDecimal(_tmp_11);
        _item = new PossesEntity(_tmpPossesId,_tmpTrxDate,_tmpStartTime,_tmpEndTime,_tmpStartBal,_tmpEndBal,_tmpTotal,_tmpCredit,_tmpShift,_tmpUserId,_tmpCashierId,_tmpTrxNo,_tmpTotIn,_tmpTotOut,_tmpEndCash,_tmpTotalActualCash,_tmpTotalDiffCash);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PossesEntity> getSortAsc() {
    final String _sql = "SELECT * FROM posses WHERE endbal is not null ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trxdate");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "starttime");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endtime");
      final int _cursorIndexOfStartBal = CursorUtil.getColumnIndexOrThrow(_cursor, "startbal");
      final int _cursorIndexOfEndBal = CursorUtil.getColumnIndexOrThrow(_cursor, "endbal");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfCredit = CursorUtil.getColumnIndexOrThrow(_cursor, "credit");
      final int _cursorIndexOfShift = CursorUtil.getColumnIndexOrThrow(_cursor, "shift");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(_cursor, "trxno");
      final int _cursorIndexOfTotIn = CursorUtil.getColumnIndexOrThrow(_cursor, "totin");
      final int _cursorIndexOfTotOut = CursorUtil.getColumnIndexOrThrow(_cursor, "totout");
      final int _cursorIndexOfEndCash = CursorUtil.getColumnIndexOrThrow(_cursor, "endcash");
      final int _cursorIndexOfTotalActualCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totactualcash");
      final int _cursorIndexOfTotalDiffCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totdiffcash");
      final List<PossesEntity> _result = new ArrayList<PossesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PossesEntity _item;
        final Integer _tmpPossesId;
        if (_cursor.isNull(_cursorIndexOfPossesId)) {
          _tmpPossesId = null;
        } else {
          _tmpPossesId = _cursor.getInt(_cursorIndexOfPossesId);
        }
        final Date _tmpTrxDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfTrxDate);
        }
        _tmpTrxDate = __converters.longToDate(_tmp);
        final Date _tmpStartTime;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfStartTime);
        }
        _tmpStartTime = __converters.longToDate(_tmp_1);
        final Date _tmpEndTime;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfEndTime)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfEndTime);
        }
        _tmpEndTime = __converters.longToDate(_tmp_2);
        final BigDecimal _tmpStartBal;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfStartBal)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfStartBal);
        }
        _tmpStartBal = __converters.stringToBigDecimal(_tmp_3);
        final BigDecimal _tmpEndBal;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfEndBal)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfEndBal);
        }
        _tmpEndBal = __converters.stringToBigDecimal(_tmp_4);
        final BigDecimal _tmpTotal;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfTotal)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfTotal);
        }
        _tmpTotal = __converters.stringToBigDecimal(_tmp_5);
        final BigDecimal _tmpCredit;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfCredit)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfCredit);
        }
        _tmpCredit = __converters.stringToBigDecimal(_tmp_6);
        final int _tmpShift;
        _tmpShift = _cursor.getInt(_cursorIndexOfShift);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        final String _tmpTrxNo;
        if (_cursor.isNull(_cursorIndexOfTrxNo)) {
          _tmpTrxNo = null;
        } else {
          _tmpTrxNo = _cursor.getString(_cursorIndexOfTrxNo);
        }
        final BigDecimal _tmpTotIn;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfTotIn)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfTotIn);
        }
        _tmpTotIn = __converters.stringToBigDecimal(_tmp_7);
        final BigDecimal _tmpTotOut;
        final String _tmp_8;
        if (_cursor.isNull(_cursorIndexOfTotOut)) {
          _tmp_8 = null;
        } else {
          _tmp_8 = _cursor.getString(_cursorIndexOfTotOut);
        }
        _tmpTotOut = __converters.stringToBigDecimal(_tmp_8);
        final BigDecimal _tmpEndCash;
        final String _tmp_9;
        if (_cursor.isNull(_cursorIndexOfEndCash)) {
          _tmp_9 = null;
        } else {
          _tmp_9 = _cursor.getString(_cursorIndexOfEndCash);
        }
        _tmpEndCash = __converters.stringToBigDecimal(_tmp_9);
        final BigDecimal _tmpTotalActualCash;
        final String _tmp_10;
        if (_cursor.isNull(_cursorIndexOfTotalActualCash)) {
          _tmp_10 = null;
        } else {
          _tmp_10 = _cursor.getString(_cursorIndexOfTotalActualCash);
        }
        _tmpTotalActualCash = __converters.stringToBigDecimal(_tmp_10);
        final BigDecimal _tmpTotalDiffCash;
        final String _tmp_11;
        if (_cursor.isNull(_cursorIndexOfTotalDiffCash)) {
          _tmp_11 = null;
        } else {
          _tmp_11 = _cursor.getString(_cursorIndexOfTotalDiffCash);
        }
        _tmpTotalDiffCash = __converters.stringToBigDecimal(_tmp_11);
        _item = new PossesEntity(_tmpPossesId,_tmpTrxDate,_tmpStartTime,_tmpEndTime,_tmpStartBal,_tmpEndBal,_tmpTotal,_tmpCredit,_tmpShift,_tmpUserId,_tmpCashierId,_tmpTrxNo,_tmpTotIn,_tmpTotOut,_tmpEndCash,_tmpTotalActualCash,_tmpTotalDiffCash);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PossesEntity> getFilter(final long current, final long end) {
    final String _sql = "SELECT * FROM posses WHERE trxdate BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, current);
    _argIndex = 2;
    _statement.bindLong(_argIndex, end);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trxdate");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "starttime");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endtime");
      final int _cursorIndexOfStartBal = CursorUtil.getColumnIndexOrThrow(_cursor, "startbal");
      final int _cursorIndexOfEndBal = CursorUtil.getColumnIndexOrThrow(_cursor, "endbal");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfCredit = CursorUtil.getColumnIndexOrThrow(_cursor, "credit");
      final int _cursorIndexOfShift = CursorUtil.getColumnIndexOrThrow(_cursor, "shift");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(_cursor, "trxno");
      final int _cursorIndexOfTotIn = CursorUtil.getColumnIndexOrThrow(_cursor, "totin");
      final int _cursorIndexOfTotOut = CursorUtil.getColumnIndexOrThrow(_cursor, "totout");
      final int _cursorIndexOfEndCash = CursorUtil.getColumnIndexOrThrow(_cursor, "endcash");
      final int _cursorIndexOfTotalActualCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totactualcash");
      final int _cursorIndexOfTotalDiffCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totdiffcash");
      final List<PossesEntity> _result = new ArrayList<PossesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PossesEntity _item;
        final Integer _tmpPossesId;
        if (_cursor.isNull(_cursorIndexOfPossesId)) {
          _tmpPossesId = null;
        } else {
          _tmpPossesId = _cursor.getInt(_cursorIndexOfPossesId);
        }
        final Date _tmpTrxDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfTrxDate);
        }
        _tmpTrxDate = __converters.longToDate(_tmp);
        final Date _tmpStartTime;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfStartTime);
        }
        _tmpStartTime = __converters.longToDate(_tmp_1);
        final Date _tmpEndTime;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfEndTime)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfEndTime);
        }
        _tmpEndTime = __converters.longToDate(_tmp_2);
        final BigDecimal _tmpStartBal;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfStartBal)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfStartBal);
        }
        _tmpStartBal = __converters.stringToBigDecimal(_tmp_3);
        final BigDecimal _tmpEndBal;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfEndBal)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfEndBal);
        }
        _tmpEndBal = __converters.stringToBigDecimal(_tmp_4);
        final BigDecimal _tmpTotal;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfTotal)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfTotal);
        }
        _tmpTotal = __converters.stringToBigDecimal(_tmp_5);
        final BigDecimal _tmpCredit;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfCredit)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfCredit);
        }
        _tmpCredit = __converters.stringToBigDecimal(_tmp_6);
        final int _tmpShift;
        _tmpShift = _cursor.getInt(_cursorIndexOfShift);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        final String _tmpTrxNo;
        if (_cursor.isNull(_cursorIndexOfTrxNo)) {
          _tmpTrxNo = null;
        } else {
          _tmpTrxNo = _cursor.getString(_cursorIndexOfTrxNo);
        }
        final BigDecimal _tmpTotIn;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfTotIn)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfTotIn);
        }
        _tmpTotIn = __converters.stringToBigDecimal(_tmp_7);
        final BigDecimal _tmpTotOut;
        final String _tmp_8;
        if (_cursor.isNull(_cursorIndexOfTotOut)) {
          _tmp_8 = null;
        } else {
          _tmp_8 = _cursor.getString(_cursorIndexOfTotOut);
        }
        _tmpTotOut = __converters.stringToBigDecimal(_tmp_8);
        final BigDecimal _tmpEndCash;
        final String _tmp_9;
        if (_cursor.isNull(_cursorIndexOfEndCash)) {
          _tmp_9 = null;
        } else {
          _tmp_9 = _cursor.getString(_cursorIndexOfEndCash);
        }
        _tmpEndCash = __converters.stringToBigDecimal(_tmp_9);
        final BigDecimal _tmpTotalActualCash;
        final String _tmp_10;
        if (_cursor.isNull(_cursorIndexOfTotalActualCash)) {
          _tmp_10 = null;
        } else {
          _tmp_10 = _cursor.getString(_cursorIndexOfTotalActualCash);
        }
        _tmpTotalActualCash = __converters.stringToBigDecimal(_tmp_10);
        final BigDecimal _tmpTotalDiffCash;
        final String _tmp_11;
        if (_cursor.isNull(_cursorIndexOfTotalDiffCash)) {
          _tmp_11 = null;
        } else {
          _tmp_11 = _cursor.getString(_cursorIndexOfTotalDiffCash);
        }
        _tmpTotalDiffCash = __converters.stringToBigDecimal(_tmp_11);
        _item = new PossesEntity(_tmpPossesId,_tmpTrxDate,_tmpStartTime,_tmpEndTime,_tmpStartBal,_tmpEndBal,_tmpTotal,_tmpCredit,_tmpShift,_tmpUserId,_tmpCashierId,_tmpTrxNo,_tmpTotIn,_tmpTotOut,_tmpEndCash,_tmpTotalActualCash,_tmpTotalDiffCash);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PossesEntity> getJmlPossesByDate(final long startDate, final long endDate) {
    final String _sql = "SELECT * FROM posses WHERE endbal is not null and trxdate between ? and ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endDate);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trxdate");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "starttime");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endtime");
      final int _cursorIndexOfStartBal = CursorUtil.getColumnIndexOrThrow(_cursor, "startbal");
      final int _cursorIndexOfEndBal = CursorUtil.getColumnIndexOrThrow(_cursor, "endbal");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfCredit = CursorUtil.getColumnIndexOrThrow(_cursor, "credit");
      final int _cursorIndexOfShift = CursorUtil.getColumnIndexOrThrow(_cursor, "shift");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(_cursor, "trxno");
      final int _cursorIndexOfTotIn = CursorUtil.getColumnIndexOrThrow(_cursor, "totin");
      final int _cursorIndexOfTotOut = CursorUtil.getColumnIndexOrThrow(_cursor, "totout");
      final int _cursorIndexOfEndCash = CursorUtil.getColumnIndexOrThrow(_cursor, "endcash");
      final int _cursorIndexOfTotalActualCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totactualcash");
      final int _cursorIndexOfTotalDiffCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totdiffcash");
      final List<PossesEntity> _result = new ArrayList<PossesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PossesEntity _item;
        final Integer _tmpPossesId;
        if (_cursor.isNull(_cursorIndexOfPossesId)) {
          _tmpPossesId = null;
        } else {
          _tmpPossesId = _cursor.getInt(_cursorIndexOfPossesId);
        }
        final Date _tmpTrxDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfTrxDate);
        }
        _tmpTrxDate = __converters.longToDate(_tmp);
        final Date _tmpStartTime;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfStartTime);
        }
        _tmpStartTime = __converters.longToDate(_tmp_1);
        final Date _tmpEndTime;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfEndTime)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfEndTime);
        }
        _tmpEndTime = __converters.longToDate(_tmp_2);
        final BigDecimal _tmpStartBal;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfStartBal)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfStartBal);
        }
        _tmpStartBal = __converters.stringToBigDecimal(_tmp_3);
        final BigDecimal _tmpEndBal;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfEndBal)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfEndBal);
        }
        _tmpEndBal = __converters.stringToBigDecimal(_tmp_4);
        final BigDecimal _tmpTotal;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfTotal)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfTotal);
        }
        _tmpTotal = __converters.stringToBigDecimal(_tmp_5);
        final BigDecimal _tmpCredit;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfCredit)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfCredit);
        }
        _tmpCredit = __converters.stringToBigDecimal(_tmp_6);
        final int _tmpShift;
        _tmpShift = _cursor.getInt(_cursorIndexOfShift);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        final String _tmpTrxNo;
        if (_cursor.isNull(_cursorIndexOfTrxNo)) {
          _tmpTrxNo = null;
        } else {
          _tmpTrxNo = _cursor.getString(_cursorIndexOfTrxNo);
        }
        final BigDecimal _tmpTotIn;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfTotIn)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfTotIn);
        }
        _tmpTotIn = __converters.stringToBigDecimal(_tmp_7);
        final BigDecimal _tmpTotOut;
        final String _tmp_8;
        if (_cursor.isNull(_cursorIndexOfTotOut)) {
          _tmp_8 = null;
        } else {
          _tmp_8 = _cursor.getString(_cursorIndexOfTotOut);
        }
        _tmpTotOut = __converters.stringToBigDecimal(_tmp_8);
        final BigDecimal _tmpEndCash;
        final String _tmp_9;
        if (_cursor.isNull(_cursorIndexOfEndCash)) {
          _tmp_9 = null;
        } else {
          _tmp_9 = _cursor.getString(_cursorIndexOfEndCash);
        }
        _tmpEndCash = __converters.stringToBigDecimal(_tmp_9);
        final BigDecimal _tmpTotalActualCash;
        final String _tmp_10;
        if (_cursor.isNull(_cursorIndexOfTotalActualCash)) {
          _tmp_10 = null;
        } else {
          _tmp_10 = _cursor.getString(_cursorIndexOfTotalActualCash);
        }
        _tmpTotalActualCash = __converters.stringToBigDecimal(_tmp_10);
        final BigDecimal _tmpTotalDiffCash;
        final String _tmp_11;
        if (_cursor.isNull(_cursorIndexOfTotalDiffCash)) {
          _tmp_11 = null;
        } else {
          _tmp_11 = _cursor.getString(_cursorIndexOfTotalDiffCash);
        }
        _tmpTotalDiffCash = __converters.stringToBigDecimal(_tmp_11);
        _item = new PossesEntity(_tmpPossesId,_tmpTrxDate,_tmpStartTime,_tmpEndTime,_tmpStartBal,_tmpEndBal,_tmpTotal,_tmpCredit,_tmpShift,_tmpUserId,_tmpCashierId,_tmpTrxNo,_tmpTotIn,_tmpTotOut,_tmpEndCash,_tmpTotalActualCash,_tmpTotalDiffCash);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PossesEntity> getListPossesHistory() {
    final String _sql = "SELECT * FROM posses WHERE endbal is not null";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trxdate");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "starttime");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endtime");
      final int _cursorIndexOfStartBal = CursorUtil.getColumnIndexOrThrow(_cursor, "startbal");
      final int _cursorIndexOfEndBal = CursorUtil.getColumnIndexOrThrow(_cursor, "endbal");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfCredit = CursorUtil.getColumnIndexOrThrow(_cursor, "credit");
      final int _cursorIndexOfShift = CursorUtil.getColumnIndexOrThrow(_cursor, "shift");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(_cursor, "trxno");
      final int _cursorIndexOfTotIn = CursorUtil.getColumnIndexOrThrow(_cursor, "totin");
      final int _cursorIndexOfTotOut = CursorUtil.getColumnIndexOrThrow(_cursor, "totout");
      final int _cursorIndexOfEndCash = CursorUtil.getColumnIndexOrThrow(_cursor, "endcash");
      final int _cursorIndexOfTotalActualCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totactualcash");
      final int _cursorIndexOfTotalDiffCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totdiffcash");
      final List<PossesEntity> _result = new ArrayList<PossesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PossesEntity _item;
        final Integer _tmpPossesId;
        if (_cursor.isNull(_cursorIndexOfPossesId)) {
          _tmpPossesId = null;
        } else {
          _tmpPossesId = _cursor.getInt(_cursorIndexOfPossesId);
        }
        final Date _tmpTrxDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfTrxDate);
        }
        _tmpTrxDate = __converters.longToDate(_tmp);
        final Date _tmpStartTime;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfStartTime);
        }
        _tmpStartTime = __converters.longToDate(_tmp_1);
        final Date _tmpEndTime;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfEndTime)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfEndTime);
        }
        _tmpEndTime = __converters.longToDate(_tmp_2);
        final BigDecimal _tmpStartBal;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfStartBal)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfStartBal);
        }
        _tmpStartBal = __converters.stringToBigDecimal(_tmp_3);
        final BigDecimal _tmpEndBal;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfEndBal)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfEndBal);
        }
        _tmpEndBal = __converters.stringToBigDecimal(_tmp_4);
        final BigDecimal _tmpTotal;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfTotal)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfTotal);
        }
        _tmpTotal = __converters.stringToBigDecimal(_tmp_5);
        final BigDecimal _tmpCredit;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfCredit)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfCredit);
        }
        _tmpCredit = __converters.stringToBigDecimal(_tmp_6);
        final int _tmpShift;
        _tmpShift = _cursor.getInt(_cursorIndexOfShift);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        final String _tmpTrxNo;
        if (_cursor.isNull(_cursorIndexOfTrxNo)) {
          _tmpTrxNo = null;
        } else {
          _tmpTrxNo = _cursor.getString(_cursorIndexOfTrxNo);
        }
        final BigDecimal _tmpTotIn;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfTotIn)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfTotIn);
        }
        _tmpTotIn = __converters.stringToBigDecimal(_tmp_7);
        final BigDecimal _tmpTotOut;
        final String _tmp_8;
        if (_cursor.isNull(_cursorIndexOfTotOut)) {
          _tmp_8 = null;
        } else {
          _tmp_8 = _cursor.getString(_cursorIndexOfTotOut);
        }
        _tmpTotOut = __converters.stringToBigDecimal(_tmp_8);
        final BigDecimal _tmpEndCash;
        final String _tmp_9;
        if (_cursor.isNull(_cursorIndexOfEndCash)) {
          _tmp_9 = null;
        } else {
          _tmp_9 = _cursor.getString(_cursorIndexOfEndCash);
        }
        _tmpEndCash = __converters.stringToBigDecimal(_tmp_9);
        final BigDecimal _tmpTotalActualCash;
        final String _tmp_10;
        if (_cursor.isNull(_cursorIndexOfTotalActualCash)) {
          _tmp_10 = null;
        } else {
          _tmp_10 = _cursor.getString(_cursorIndexOfTotalActualCash);
        }
        _tmpTotalActualCash = __converters.stringToBigDecimal(_tmp_10);
        final BigDecimal _tmpTotalDiffCash;
        final String _tmp_11;
        if (_cursor.isNull(_cursorIndexOfTotalDiffCash)) {
          _tmp_11 = null;
        } else {
          _tmp_11 = _cursor.getString(_cursorIndexOfTotalDiffCash);
        }
        _tmpTotalDiffCash = __converters.stringToBigDecimal(_tmp_11);
        _item = new PossesEntity(_tmpPossesId,_tmpTrxDate,_tmpStartTime,_tmpEndTime,_tmpStartBal,_tmpEndBal,_tmpTotal,_tmpCredit,_tmpShift,_tmpUserId,_tmpCashierId,_tmpTrxNo,_tmpTotIn,_tmpTotOut,_tmpEndCash,_tmpTotalActualCash,_tmpTotalDiffCash);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PossesEntity> getFilterAsc(final long current, final long end) {
    final String _sql = "SELECT * FROM posses WHERE endbal is not null and trxdate BETWEEN ? AND ? ORDER BY id asc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, current);
    _argIndex = 2;
    _statement.bindLong(_argIndex, end);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trxdate");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "starttime");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endtime");
      final int _cursorIndexOfStartBal = CursorUtil.getColumnIndexOrThrow(_cursor, "startbal");
      final int _cursorIndexOfEndBal = CursorUtil.getColumnIndexOrThrow(_cursor, "endbal");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfCredit = CursorUtil.getColumnIndexOrThrow(_cursor, "credit");
      final int _cursorIndexOfShift = CursorUtil.getColumnIndexOrThrow(_cursor, "shift");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(_cursor, "trxno");
      final int _cursorIndexOfTotIn = CursorUtil.getColumnIndexOrThrow(_cursor, "totin");
      final int _cursorIndexOfTotOut = CursorUtil.getColumnIndexOrThrow(_cursor, "totout");
      final int _cursorIndexOfEndCash = CursorUtil.getColumnIndexOrThrow(_cursor, "endcash");
      final int _cursorIndexOfTotalActualCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totactualcash");
      final int _cursorIndexOfTotalDiffCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totdiffcash");
      final List<PossesEntity> _result = new ArrayList<PossesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PossesEntity _item;
        final Integer _tmpPossesId;
        if (_cursor.isNull(_cursorIndexOfPossesId)) {
          _tmpPossesId = null;
        } else {
          _tmpPossesId = _cursor.getInt(_cursorIndexOfPossesId);
        }
        final Date _tmpTrxDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfTrxDate);
        }
        _tmpTrxDate = __converters.longToDate(_tmp);
        final Date _tmpStartTime;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfStartTime);
        }
        _tmpStartTime = __converters.longToDate(_tmp_1);
        final Date _tmpEndTime;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfEndTime)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfEndTime);
        }
        _tmpEndTime = __converters.longToDate(_tmp_2);
        final BigDecimal _tmpStartBal;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfStartBal)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfStartBal);
        }
        _tmpStartBal = __converters.stringToBigDecimal(_tmp_3);
        final BigDecimal _tmpEndBal;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfEndBal)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfEndBal);
        }
        _tmpEndBal = __converters.stringToBigDecimal(_tmp_4);
        final BigDecimal _tmpTotal;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfTotal)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfTotal);
        }
        _tmpTotal = __converters.stringToBigDecimal(_tmp_5);
        final BigDecimal _tmpCredit;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfCredit)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfCredit);
        }
        _tmpCredit = __converters.stringToBigDecimal(_tmp_6);
        final int _tmpShift;
        _tmpShift = _cursor.getInt(_cursorIndexOfShift);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        final String _tmpTrxNo;
        if (_cursor.isNull(_cursorIndexOfTrxNo)) {
          _tmpTrxNo = null;
        } else {
          _tmpTrxNo = _cursor.getString(_cursorIndexOfTrxNo);
        }
        final BigDecimal _tmpTotIn;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfTotIn)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfTotIn);
        }
        _tmpTotIn = __converters.stringToBigDecimal(_tmp_7);
        final BigDecimal _tmpTotOut;
        final String _tmp_8;
        if (_cursor.isNull(_cursorIndexOfTotOut)) {
          _tmp_8 = null;
        } else {
          _tmp_8 = _cursor.getString(_cursorIndexOfTotOut);
        }
        _tmpTotOut = __converters.stringToBigDecimal(_tmp_8);
        final BigDecimal _tmpEndCash;
        final String _tmp_9;
        if (_cursor.isNull(_cursorIndexOfEndCash)) {
          _tmp_9 = null;
        } else {
          _tmp_9 = _cursor.getString(_cursorIndexOfEndCash);
        }
        _tmpEndCash = __converters.stringToBigDecimal(_tmp_9);
        final BigDecimal _tmpTotalActualCash;
        final String _tmp_10;
        if (_cursor.isNull(_cursorIndexOfTotalActualCash)) {
          _tmp_10 = null;
        } else {
          _tmp_10 = _cursor.getString(_cursorIndexOfTotalActualCash);
        }
        _tmpTotalActualCash = __converters.stringToBigDecimal(_tmp_10);
        final BigDecimal _tmpTotalDiffCash;
        final String _tmp_11;
        if (_cursor.isNull(_cursorIndexOfTotalDiffCash)) {
          _tmp_11 = null;
        } else {
          _tmp_11 = _cursor.getString(_cursorIndexOfTotalDiffCash);
        }
        _tmpTotalDiffCash = __converters.stringToBigDecimal(_tmp_11);
        _item = new PossesEntity(_tmpPossesId,_tmpTrxDate,_tmpStartTime,_tmpEndTime,_tmpStartBal,_tmpEndBal,_tmpTotal,_tmpCredit,_tmpShift,_tmpUserId,_tmpCashierId,_tmpTrxNo,_tmpTotIn,_tmpTotOut,_tmpEndCash,_tmpTotalActualCash,_tmpTotalDiffCash);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PossesEntity> getFilterDesc(final long current, final long end) {
    final String _sql = "SELECT * FROM posses WHERE endbal is not null and trxdate BETWEEN ? AND ? ORDER BY id desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, current);
    _argIndex = 2;
    _statement.bindLong(_argIndex, end);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPossesId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrxDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trxdate");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "starttime");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endtime");
      final int _cursorIndexOfStartBal = CursorUtil.getColumnIndexOrThrow(_cursor, "startbal");
      final int _cursorIndexOfEndBal = CursorUtil.getColumnIndexOrThrow(_cursor, "endbal");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfCredit = CursorUtil.getColumnIndexOrThrow(_cursor, "credit");
      final int _cursorIndexOfShift = CursorUtil.getColumnIndexOrThrow(_cursor, "shift");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfCashierId = CursorUtil.getColumnIndexOrThrow(_cursor, "cashier_id");
      final int _cursorIndexOfTrxNo = CursorUtil.getColumnIndexOrThrow(_cursor, "trxno");
      final int _cursorIndexOfTotIn = CursorUtil.getColumnIndexOrThrow(_cursor, "totin");
      final int _cursorIndexOfTotOut = CursorUtil.getColumnIndexOrThrow(_cursor, "totout");
      final int _cursorIndexOfEndCash = CursorUtil.getColumnIndexOrThrow(_cursor, "endcash");
      final int _cursorIndexOfTotalActualCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totactualcash");
      final int _cursorIndexOfTotalDiffCash = CursorUtil.getColumnIndexOrThrow(_cursor, "totdiffcash");
      final List<PossesEntity> _result = new ArrayList<PossesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PossesEntity _item;
        final Integer _tmpPossesId;
        if (_cursor.isNull(_cursorIndexOfPossesId)) {
          _tmpPossesId = null;
        } else {
          _tmpPossesId = _cursor.getInt(_cursorIndexOfPossesId);
        }
        final Date _tmpTrxDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfTrxDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfTrxDate);
        }
        _tmpTrxDate = __converters.longToDate(_tmp);
        final Date _tmpStartTime;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfStartTime);
        }
        _tmpStartTime = __converters.longToDate(_tmp_1);
        final Date _tmpEndTime;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfEndTime)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfEndTime);
        }
        _tmpEndTime = __converters.longToDate(_tmp_2);
        final BigDecimal _tmpStartBal;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfStartBal)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfStartBal);
        }
        _tmpStartBal = __converters.stringToBigDecimal(_tmp_3);
        final BigDecimal _tmpEndBal;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfEndBal)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfEndBal);
        }
        _tmpEndBal = __converters.stringToBigDecimal(_tmp_4);
        final BigDecimal _tmpTotal;
        final String _tmp_5;
        if (_cursor.isNull(_cursorIndexOfTotal)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getString(_cursorIndexOfTotal);
        }
        _tmpTotal = __converters.stringToBigDecimal(_tmp_5);
        final BigDecimal _tmpCredit;
        final String _tmp_6;
        if (_cursor.isNull(_cursorIndexOfCredit)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getString(_cursorIndexOfCredit);
        }
        _tmpCredit = __converters.stringToBigDecimal(_tmp_6);
        final int _tmpShift;
        _tmpShift = _cursor.getInt(_cursorIndexOfShift);
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        final int _tmpCashierId;
        _tmpCashierId = _cursor.getInt(_cursorIndexOfCashierId);
        final String _tmpTrxNo;
        if (_cursor.isNull(_cursorIndexOfTrxNo)) {
          _tmpTrxNo = null;
        } else {
          _tmpTrxNo = _cursor.getString(_cursorIndexOfTrxNo);
        }
        final BigDecimal _tmpTotIn;
        final String _tmp_7;
        if (_cursor.isNull(_cursorIndexOfTotIn)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getString(_cursorIndexOfTotIn);
        }
        _tmpTotIn = __converters.stringToBigDecimal(_tmp_7);
        final BigDecimal _tmpTotOut;
        final String _tmp_8;
        if (_cursor.isNull(_cursorIndexOfTotOut)) {
          _tmp_8 = null;
        } else {
          _tmp_8 = _cursor.getString(_cursorIndexOfTotOut);
        }
        _tmpTotOut = __converters.stringToBigDecimal(_tmp_8);
        final BigDecimal _tmpEndCash;
        final String _tmp_9;
        if (_cursor.isNull(_cursorIndexOfEndCash)) {
          _tmp_9 = null;
        } else {
          _tmp_9 = _cursor.getString(_cursorIndexOfEndCash);
        }
        _tmpEndCash = __converters.stringToBigDecimal(_tmp_9);
        final BigDecimal _tmpTotalActualCash;
        final String _tmp_10;
        if (_cursor.isNull(_cursorIndexOfTotalActualCash)) {
          _tmp_10 = null;
        } else {
          _tmp_10 = _cursor.getString(_cursorIndexOfTotalActualCash);
        }
        _tmpTotalActualCash = __converters.stringToBigDecimal(_tmp_10);
        final BigDecimal _tmpTotalDiffCash;
        final String _tmp_11;
        if (_cursor.isNull(_cursorIndexOfTotalDiffCash)) {
          _tmp_11 = null;
        } else {
          _tmp_11 = _cursor.getString(_cursorIndexOfTotalDiffCash);
        }
        _tmpTotalDiffCash = __converters.stringToBigDecimal(_tmp_11);
        _item = new PossesEntity(_tmpPossesId,_tmpTrxDate,_tmpStartTime,_tmpEndTime,_tmpStartBal,_tmpEndBal,_tmpTotal,_tmpCredit,_tmpShift,_tmpUserId,_tmpCashierId,_tmpTrxNo,_tmpTotIn,_tmpTotOut,_tmpEndCash,_tmpTotalActualCash,_tmpTotalDiffCash);
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
