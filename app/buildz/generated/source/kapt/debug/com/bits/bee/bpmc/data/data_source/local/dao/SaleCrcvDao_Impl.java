package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.SaleCrcvEntity;
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
public final class SaleCrcvDao_Impl implements SaleCrcvDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SaleCrcvEntity> __insertionAdapterOfSaleCrcvEntity;

  private final EntityDeletionOrUpdateAdapter<SaleCrcvEntity> __deletionAdapterOfSaleCrcvEntity;

  private final EntityDeletionOrUpdateAdapter<SaleCrcvEntity> __updateAdapterOfSaleCrcvEntity;

  public SaleCrcvDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSaleCrcvEntity = new EntityInsertionAdapter<SaleCrcvEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `salecrcvs` (`id`,`rcvtype_code`,`sale`,`rcvamt`,`note`,`edc_id`,`cash_id`,`card_no`,`cctype_code`,`mdrexp`,`mdramt`,`surcexp`,`surcamt`,`mdracc_id`,`surcacc_id`,`ref_id`,`track_no`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaleCrcvEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getRcvTypeCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRcvTypeCode());
        }
        stmt.bindLong(3, value.getSaleInt());
        if (value.getRcvAmt() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRcvAmt());
        }
        if (value.getNote() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNote());
        }
        if (value.getEdcId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getEdcId());
        }
        if (value.getCashId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getCashId());
        }
        if (value.getCardNo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCardNo());
        }
        if (value.getCctypeCode() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCctypeCode());
        }
        if (value.getMdrExp() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getMdrExp());
        }
        if (value.getMdrAmt() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getMdrAmt());
        }
        if (value.getSurcExp() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getSurcExp());
        }
        if (value.getSurcAmt() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getSurcAmt());
        }
        if (value.getMdrAccId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getMdrAccId());
        }
        if (value.getSurAccId() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getSurAccId());
        }
        if (value.getRefId() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getRefId());
        }
        if (value.getTrackNo() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getTrackNo());
        }
      }
    };
    this.__deletionAdapterOfSaleCrcvEntity = new EntityDeletionOrUpdateAdapter<SaleCrcvEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `salecrcvs` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaleCrcvEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfSaleCrcvEntity = new EntityDeletionOrUpdateAdapter<SaleCrcvEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `salecrcvs` SET `id` = ?,`rcvtype_code` = ?,`sale` = ?,`rcvamt` = ?,`note` = ?,`edc_id` = ?,`cash_id` = ?,`card_no` = ?,`cctype_code` = ?,`mdrexp` = ?,`mdramt` = ?,`surcexp` = ?,`surcamt` = ?,`mdracc_id` = ?,`surcacc_id` = ?,`ref_id` = ?,`track_no` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SaleCrcvEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getRcvTypeCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRcvTypeCode());
        }
        stmt.bindLong(3, value.getSaleInt());
        if (value.getRcvAmt() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRcvAmt());
        }
        if (value.getNote() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNote());
        }
        if (value.getEdcId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getEdcId());
        }
        if (value.getCashId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getCashId());
        }
        if (value.getCardNo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCardNo());
        }
        if (value.getCctypeCode() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCctypeCode());
        }
        if (value.getMdrExp() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getMdrExp());
        }
        if (value.getMdrAmt() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getMdrAmt());
        }
        if (value.getSurcExp() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getSurcExp());
        }
        if (value.getSurcAmt() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getSurcAmt());
        }
        if (value.getMdrAccId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getMdrAccId());
        }
        if (value.getSurAccId() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getSurAccId());
        }
        if (value.getRefId() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getRefId());
        }
        if (value.getTrackNo() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getTrackNo());
        }
        if (value.getId() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindLong(18, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends SaleCrcvEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final SaleCrcvEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends SaleCrcvEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSaleCrcvEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final SaleCrcvEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSaleCrcvEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final SaleCrcvEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSaleCrcvEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<SaleCrcvEntity> getSaleCrcvList() {
    final String _sql = "SELECT * FROM salecrcvs";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfRcvTypeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "rcvtype_code");
      final int _cursorIndexOfSaleInt = CursorUtil.getColumnIndexOrThrow(_cursor, "sale");
      final int _cursorIndexOfRcvAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "rcvamt");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfEdcId = CursorUtil.getColumnIndexOrThrow(_cursor, "edc_id");
      final int _cursorIndexOfCashId = CursorUtil.getColumnIndexOrThrow(_cursor, "cash_id");
      final int _cursorIndexOfCardNo = CursorUtil.getColumnIndexOrThrow(_cursor, "card_no");
      final int _cursorIndexOfCctypeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "cctype_code");
      final int _cursorIndexOfMdrExp = CursorUtil.getColumnIndexOrThrow(_cursor, "mdrexp");
      final int _cursorIndexOfMdrAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "mdramt");
      final int _cursorIndexOfSurcExp = CursorUtil.getColumnIndexOrThrow(_cursor, "surcexp");
      final int _cursorIndexOfSurcAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "surcamt");
      final int _cursorIndexOfMdrAccId = CursorUtil.getColumnIndexOrThrow(_cursor, "mdracc_id");
      final int _cursorIndexOfSurAccId = CursorUtil.getColumnIndexOrThrow(_cursor, "surcacc_id");
      final int _cursorIndexOfRefId = CursorUtil.getColumnIndexOrThrow(_cursor, "ref_id");
      final int _cursorIndexOfTrackNo = CursorUtil.getColumnIndexOrThrow(_cursor, "track_no");
      final List<SaleCrcvEntity> _result = new ArrayList<SaleCrcvEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SaleCrcvEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpRcvTypeCode;
        if (_cursor.isNull(_cursorIndexOfRcvTypeCode)) {
          _tmpRcvTypeCode = null;
        } else {
          _tmpRcvTypeCode = _cursor.getString(_cursorIndexOfRcvTypeCode);
        }
        final int _tmpSaleInt;
        _tmpSaleInt = _cursor.getInt(_cursorIndexOfSaleInt);
        final String _tmpRcvAmt;
        if (_cursor.isNull(_cursorIndexOfRcvAmt)) {
          _tmpRcvAmt = null;
        } else {
          _tmpRcvAmt = _cursor.getString(_cursorIndexOfRcvAmt);
        }
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final Integer _tmpEdcId;
        if (_cursor.isNull(_cursorIndexOfEdcId)) {
          _tmpEdcId = null;
        } else {
          _tmpEdcId = _cursor.getInt(_cursorIndexOfEdcId);
        }
        final Integer _tmpCashId;
        if (_cursor.isNull(_cursorIndexOfCashId)) {
          _tmpCashId = null;
        } else {
          _tmpCashId = _cursor.getInt(_cursorIndexOfCashId);
        }
        final String _tmpCardNo;
        if (_cursor.isNull(_cursorIndexOfCardNo)) {
          _tmpCardNo = null;
        } else {
          _tmpCardNo = _cursor.getString(_cursorIndexOfCardNo);
        }
        final String _tmpCctypeCode;
        if (_cursor.isNull(_cursorIndexOfCctypeCode)) {
          _tmpCctypeCode = null;
        } else {
          _tmpCctypeCode = _cursor.getString(_cursorIndexOfCctypeCode);
        }
        final String _tmpMdrExp;
        if (_cursor.isNull(_cursorIndexOfMdrExp)) {
          _tmpMdrExp = null;
        } else {
          _tmpMdrExp = _cursor.getString(_cursorIndexOfMdrExp);
        }
        final String _tmpMdrAmt;
        if (_cursor.isNull(_cursorIndexOfMdrAmt)) {
          _tmpMdrAmt = null;
        } else {
          _tmpMdrAmt = _cursor.getString(_cursorIndexOfMdrAmt);
        }
        final String _tmpSurcExp;
        if (_cursor.isNull(_cursorIndexOfSurcExp)) {
          _tmpSurcExp = null;
        } else {
          _tmpSurcExp = _cursor.getString(_cursorIndexOfSurcExp);
        }
        final String _tmpSurcAmt;
        if (_cursor.isNull(_cursorIndexOfSurcAmt)) {
          _tmpSurcAmt = null;
        } else {
          _tmpSurcAmt = _cursor.getString(_cursorIndexOfSurcAmt);
        }
        final String _tmpMdrAccId;
        if (_cursor.isNull(_cursorIndexOfMdrAccId)) {
          _tmpMdrAccId = null;
        } else {
          _tmpMdrAccId = _cursor.getString(_cursorIndexOfMdrAccId);
        }
        final String _tmpSurAccId;
        if (_cursor.isNull(_cursorIndexOfSurAccId)) {
          _tmpSurAccId = null;
        } else {
          _tmpSurAccId = _cursor.getString(_cursorIndexOfSurAccId);
        }
        final String _tmpRefId;
        if (_cursor.isNull(_cursorIndexOfRefId)) {
          _tmpRefId = null;
        } else {
          _tmpRefId = _cursor.getString(_cursorIndexOfRefId);
        }
        final String _tmpTrackNo;
        if (_cursor.isNull(_cursorIndexOfTrackNo)) {
          _tmpTrackNo = null;
        } else {
          _tmpTrackNo = _cursor.getString(_cursorIndexOfTrackNo);
        }
        _item = new SaleCrcvEntity(_tmpId,_tmpRcvTypeCode,_tmpSaleInt,_tmpRcvAmt,_tmpNote,_tmpEdcId,_tmpCashId,_tmpCardNo,_tmpCctypeCode,_tmpMdrExp,_tmpMdrAmt,_tmpSurcExp,_tmpSurcAmt,_tmpMdrAccId,_tmpSurAccId,_tmpRefId,_tmpTrackNo);
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
