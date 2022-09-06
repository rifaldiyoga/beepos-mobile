package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.CcTypeEntity;
import com.bits.bee.bpmc.data.data_source.local.model.EdcSurcEntity;
import com.bits.bee.bpmc.data.data_source.local.model.EdcSurcWithCcTypeEntity;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EdcSurcDao_Impl implements EdcSurcDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EdcSurcEntity> __insertionAdapterOfEdcSurcEntity;

  private final EntityDeletionOrUpdateAdapter<EdcSurcEntity> __deletionAdapterOfEdcSurcEntity;

  private final EntityDeletionOrUpdateAdapter<EdcSurcEntity> __updateAdapterOfEdcSurcEntity;

  public EdcSurcDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEdcSurcEntity = new EntityInsertionAdapter<EdcSurcEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `edcsurc` (`id`,`edcsurcno`,`edc_id`,`cctype`,`cctypedesc`,`surcexp`,`mdrexp`,`surcacc_id`,`mdracc_id`,`edcsurctype`,`active`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EdcSurcEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getEdcSurcNo() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEdcSurcNo());
        }
        stmt.bindLong(3, value.getEdcId());
        if (value.getCcType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCcType());
        }
        if (value.getCcTypeDesc() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCcTypeDesc());
        }
        if (value.getSurcExp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSurcExp());
        }
        if (value.getMdrExp() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMdrExp());
        }
        stmt.bindLong(8, value.getSurcAccId());
        stmt.bindLong(9, value.getMdrAccId());
        if (value.getEdcSurcType() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getEdcSurcType());
        }
        final int _tmp = value.getActive() ? 1 : 0;
        stmt.bindLong(11, _tmp);
      }
    };
    this.__deletionAdapterOfEdcSurcEntity = new EntityDeletionOrUpdateAdapter<EdcSurcEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `edcsurc` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EdcSurcEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfEdcSurcEntity = new EntityDeletionOrUpdateAdapter<EdcSurcEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `edcsurc` SET `id` = ?,`edcsurcno` = ?,`edc_id` = ?,`cctype` = ?,`cctypedesc` = ?,`surcexp` = ?,`mdrexp` = ?,`surcacc_id` = ?,`mdracc_id` = ?,`edcsurctype` = ?,`active` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EdcSurcEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getEdcSurcNo() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEdcSurcNo());
        }
        stmt.bindLong(3, value.getEdcId());
        if (value.getCcType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCcType());
        }
        if (value.getCcTypeDesc() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCcTypeDesc());
        }
        if (value.getSurcExp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSurcExp());
        }
        if (value.getMdrExp() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMdrExp());
        }
        stmt.bindLong(8, value.getSurcAccId());
        stmt.bindLong(9, value.getMdrAccId());
        if (value.getEdcSurcType() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getEdcSurcType());
        }
        final int _tmp = value.getActive() ? 1 : 0;
        stmt.bindLong(11, _tmp);
        stmt.bindLong(12, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends EdcSurcEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final EdcSurcEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends EdcSurcEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEdcSurcEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final EdcSurcEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEdcSurcEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EdcSurcEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEdcSurcEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<EdcSurcEntity> getEdcSurcList() {
    final String _sql = "SELECT  * FROM edcsurc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfEdcSurcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "edcsurcno");
      final int _cursorIndexOfEdcId = CursorUtil.getColumnIndexOrThrow(_cursor, "edc_id");
      final int _cursorIndexOfCcType = CursorUtil.getColumnIndexOrThrow(_cursor, "cctype");
      final int _cursorIndexOfCcTypeDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "cctypedesc");
      final int _cursorIndexOfSurcExp = CursorUtil.getColumnIndexOrThrow(_cursor, "surcexp");
      final int _cursorIndexOfMdrExp = CursorUtil.getColumnIndexOrThrow(_cursor, "mdrexp");
      final int _cursorIndexOfSurcAccId = CursorUtil.getColumnIndexOrThrow(_cursor, "surcacc_id");
      final int _cursorIndexOfMdrAccId = CursorUtil.getColumnIndexOrThrow(_cursor, "mdracc_id");
      final int _cursorIndexOfEdcSurcType = CursorUtil.getColumnIndexOrThrow(_cursor, "edcsurctype");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final List<EdcSurcEntity> _result = new ArrayList<EdcSurcEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EdcSurcEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpEdcSurcNo;
        if (_cursor.isNull(_cursorIndexOfEdcSurcNo)) {
          _tmpEdcSurcNo = null;
        } else {
          _tmpEdcSurcNo = _cursor.getString(_cursorIndexOfEdcSurcNo);
        }
        final int _tmpEdcId;
        _tmpEdcId = _cursor.getInt(_cursorIndexOfEdcId);
        final String _tmpCcType;
        if (_cursor.isNull(_cursorIndexOfCcType)) {
          _tmpCcType = null;
        } else {
          _tmpCcType = _cursor.getString(_cursorIndexOfCcType);
        }
        final String _tmpCcTypeDesc;
        if (_cursor.isNull(_cursorIndexOfCcTypeDesc)) {
          _tmpCcTypeDesc = null;
        } else {
          _tmpCcTypeDesc = _cursor.getString(_cursorIndexOfCcTypeDesc);
        }
        final String _tmpSurcExp;
        if (_cursor.isNull(_cursorIndexOfSurcExp)) {
          _tmpSurcExp = null;
        } else {
          _tmpSurcExp = _cursor.getString(_cursorIndexOfSurcExp);
        }
        final String _tmpMdrExp;
        if (_cursor.isNull(_cursorIndexOfMdrExp)) {
          _tmpMdrExp = null;
        } else {
          _tmpMdrExp = _cursor.getString(_cursorIndexOfMdrExp);
        }
        final int _tmpSurcAccId;
        _tmpSurcAccId = _cursor.getInt(_cursorIndexOfSurcAccId);
        final int _tmpMdrAccId;
        _tmpMdrAccId = _cursor.getInt(_cursorIndexOfMdrAccId);
        final String _tmpEdcSurcType;
        if (_cursor.isNull(_cursorIndexOfEdcSurcType)) {
          _tmpEdcSurcType = null;
        } else {
          _tmpEdcSurcType = _cursor.getString(_cursorIndexOfEdcSurcType);
        }
        final boolean _tmpActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp != 0;
        _item = new EdcSurcEntity(_tmpId,_tmpEdcSurcNo,_tmpEdcId,_tmpCcType,_tmpCcTypeDesc,_tmpSurcExp,_tmpMdrExp,_tmpSurcAccId,_tmpMdrAccId,_tmpEdcSurcType,_tmpActive);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<EdcSurcWithCcTypeEntity> getActiveEdcSurc(final int edcId, final String type) {
    final String _sql = "SELECT * FROM edcsurc WHERE edc_id = ? AND edcsurctype = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, edcId);
    _argIndex = 2;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfEdcSurcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "edcsurcno");
      final int _cursorIndexOfEdcId = CursorUtil.getColumnIndexOrThrow(_cursor, "edc_id");
      final int _cursorIndexOfCcType = CursorUtil.getColumnIndexOrThrow(_cursor, "cctype");
      final int _cursorIndexOfCcTypeDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "cctypedesc");
      final int _cursorIndexOfSurcExp = CursorUtil.getColumnIndexOrThrow(_cursor, "surcexp");
      final int _cursorIndexOfMdrExp = CursorUtil.getColumnIndexOrThrow(_cursor, "mdrexp");
      final int _cursorIndexOfSurcAccId = CursorUtil.getColumnIndexOrThrow(_cursor, "surcacc_id");
      final int _cursorIndexOfMdrAccId = CursorUtil.getColumnIndexOrThrow(_cursor, "mdracc_id");
      final int _cursorIndexOfEdcSurcType = CursorUtil.getColumnIndexOrThrow(_cursor, "edcsurctype");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final ArrayMap<String, CcTypeEntity> _collectionCcType = new ArrayMap<String, CcTypeEntity>();
      while (_cursor.moveToNext()) {
        final String _tmpKey = _cursor.getString(_cursorIndexOfCcType);
        _collectionCcType.put(_tmpKey, null);
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshipccTypeAscomBitsBeeBpmcDataDataSourceLocalModelCcTypeEntity(_collectionCcType);
      final List<EdcSurcWithCcTypeEntity> _result = new ArrayList<EdcSurcWithCcTypeEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EdcSurcWithCcTypeEntity _item;
        final EdcSurcEntity _tmpEdcSurc;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfEdcSurcNo) && _cursor.isNull(_cursorIndexOfEdcId) && _cursor.isNull(_cursorIndexOfCcType) && _cursor.isNull(_cursorIndexOfCcTypeDesc) && _cursor.isNull(_cursorIndexOfSurcExp) && _cursor.isNull(_cursorIndexOfMdrExp) && _cursor.isNull(_cursorIndexOfSurcAccId) && _cursor.isNull(_cursorIndexOfMdrAccId) && _cursor.isNull(_cursorIndexOfEdcSurcType) && _cursor.isNull(_cursorIndexOfActive))) {
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          final String _tmpEdcSurcNo;
          if (_cursor.isNull(_cursorIndexOfEdcSurcNo)) {
            _tmpEdcSurcNo = null;
          } else {
            _tmpEdcSurcNo = _cursor.getString(_cursorIndexOfEdcSurcNo);
          }
          final int _tmpEdcId;
          _tmpEdcId = _cursor.getInt(_cursorIndexOfEdcId);
          final String _tmpCcType;
          if (_cursor.isNull(_cursorIndexOfCcType)) {
            _tmpCcType = null;
          } else {
            _tmpCcType = _cursor.getString(_cursorIndexOfCcType);
          }
          final String _tmpCcTypeDesc;
          if (_cursor.isNull(_cursorIndexOfCcTypeDesc)) {
            _tmpCcTypeDesc = null;
          } else {
            _tmpCcTypeDesc = _cursor.getString(_cursorIndexOfCcTypeDesc);
          }
          final String _tmpSurcExp;
          if (_cursor.isNull(_cursorIndexOfSurcExp)) {
            _tmpSurcExp = null;
          } else {
            _tmpSurcExp = _cursor.getString(_cursorIndexOfSurcExp);
          }
          final String _tmpMdrExp;
          if (_cursor.isNull(_cursorIndexOfMdrExp)) {
            _tmpMdrExp = null;
          } else {
            _tmpMdrExp = _cursor.getString(_cursorIndexOfMdrExp);
          }
          final int _tmpSurcAccId;
          _tmpSurcAccId = _cursor.getInt(_cursorIndexOfSurcAccId);
          final int _tmpMdrAccId;
          _tmpMdrAccId = _cursor.getInt(_cursorIndexOfMdrAccId);
          final String _tmpEdcSurcType;
          if (_cursor.isNull(_cursorIndexOfEdcSurcType)) {
            _tmpEdcSurcType = null;
          } else {
            _tmpEdcSurcType = _cursor.getString(_cursorIndexOfEdcSurcType);
          }
          final boolean _tmpActive;
          final int _tmp;
          _tmp = _cursor.getInt(_cursorIndexOfActive);
          _tmpActive = _tmp != 0;
          _tmpEdcSurc = new EdcSurcEntity(_tmpId,_tmpEdcSurcNo,_tmpEdcId,_tmpCcType,_tmpCcTypeDesc,_tmpSurcExp,_tmpMdrExp,_tmpSurcAccId,_tmpMdrAccId,_tmpEdcSurcType,_tmpActive);
        }  else  {
          _tmpEdcSurc = null;
        }
        CcTypeEntity _tmpCcType_1 = null;
        final String _tmpKey_1 = _cursor.getString(_cursorIndexOfCcType);
        _tmpCcType_1 = _collectionCcType.get(_tmpKey_1);
        _item = new EdcSurcWithCcTypeEntity(_tmpEdcSurc,_tmpCcType_1);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<EdcSurcEntity> getEdcSurcByEdc(final int edcId) {
    final String _sql = "SELECT * FROM edcsurc WHERE edc_id = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, edcId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfEdcSurcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "edcsurcno");
      final int _cursorIndexOfEdcId = CursorUtil.getColumnIndexOrThrow(_cursor, "edc_id");
      final int _cursorIndexOfCcType = CursorUtil.getColumnIndexOrThrow(_cursor, "cctype");
      final int _cursorIndexOfCcTypeDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "cctypedesc");
      final int _cursorIndexOfSurcExp = CursorUtil.getColumnIndexOrThrow(_cursor, "surcexp");
      final int _cursorIndexOfMdrExp = CursorUtil.getColumnIndexOrThrow(_cursor, "mdrexp");
      final int _cursorIndexOfSurcAccId = CursorUtil.getColumnIndexOrThrow(_cursor, "surcacc_id");
      final int _cursorIndexOfMdrAccId = CursorUtil.getColumnIndexOrThrow(_cursor, "mdracc_id");
      final int _cursorIndexOfEdcSurcType = CursorUtil.getColumnIndexOrThrow(_cursor, "edcsurctype");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final List<EdcSurcEntity> _result = new ArrayList<EdcSurcEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EdcSurcEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpEdcSurcNo;
        if (_cursor.isNull(_cursorIndexOfEdcSurcNo)) {
          _tmpEdcSurcNo = null;
        } else {
          _tmpEdcSurcNo = _cursor.getString(_cursorIndexOfEdcSurcNo);
        }
        final int _tmpEdcId;
        _tmpEdcId = _cursor.getInt(_cursorIndexOfEdcId);
        final String _tmpCcType;
        if (_cursor.isNull(_cursorIndexOfCcType)) {
          _tmpCcType = null;
        } else {
          _tmpCcType = _cursor.getString(_cursorIndexOfCcType);
        }
        final String _tmpCcTypeDesc;
        if (_cursor.isNull(_cursorIndexOfCcTypeDesc)) {
          _tmpCcTypeDesc = null;
        } else {
          _tmpCcTypeDesc = _cursor.getString(_cursorIndexOfCcTypeDesc);
        }
        final String _tmpSurcExp;
        if (_cursor.isNull(_cursorIndexOfSurcExp)) {
          _tmpSurcExp = null;
        } else {
          _tmpSurcExp = _cursor.getString(_cursorIndexOfSurcExp);
        }
        final String _tmpMdrExp;
        if (_cursor.isNull(_cursorIndexOfMdrExp)) {
          _tmpMdrExp = null;
        } else {
          _tmpMdrExp = _cursor.getString(_cursorIndexOfMdrExp);
        }
        final int _tmpSurcAccId;
        _tmpSurcAccId = _cursor.getInt(_cursorIndexOfSurcAccId);
        final int _tmpMdrAccId;
        _tmpMdrAccId = _cursor.getInt(_cursorIndexOfMdrAccId);
        final String _tmpEdcSurcType;
        if (_cursor.isNull(_cursorIndexOfEdcSurcType)) {
          _tmpEdcSurcType = null;
        } else {
          _tmpEdcSurcType = _cursor.getString(_cursorIndexOfEdcSurcType);
        }
        final boolean _tmpActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfActive);
        _tmpActive = _tmp != 0;
        _item = new EdcSurcEntity(_tmpId,_tmpEdcSurcNo,_tmpEdcId,_tmpCcType,_tmpCcTypeDesc,_tmpSurcExp,_tmpMdrExp,_tmpSurcAccId,_tmpMdrAccId,_tmpEdcSurcType,_tmpActive);
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

  private void __fetchRelationshipccTypeAscomBitsBeeBpmcDataDataSourceLocalModelCcTypeEntity(
      final ArrayMap<String, CcTypeEntity> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      ArrayMap<String, CcTypeEntity> _tmpInnerMap = new ArrayMap<String, CcTypeEntity>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), null);
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipccTypeAscomBitsBeeBpmcDataDataSourceLocalModelCcTypeEntity(_tmpInnerMap);
          _map.putAll((Map<String, CcTypeEntity>) _tmpInnerMap);
          _tmpInnerMap = new ArrayMap<String, CcTypeEntity>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipccTypeAscomBitsBeeBpmcDataDataSourceLocalModelCcTypeEntity(_tmpInnerMap);
        _map.putAll((Map<String, CcTypeEntity>) _tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`cctype`,`cctypedesc` FROM `cc_type` WHERE `cctype` IN (");
    final int _inputSize = __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : __mapKeySet) {
      if (_item == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "cctype");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfCctype = 1;
      final int _cursorIndexOfCctypeDesc = 2;
      while(_cursor.moveToNext()) {
        final String _tmpKey = _cursor.getString(_itemKeyIndex);
        if (_map.containsKey(_tmpKey)) {
          final CcTypeEntity _item_1;
          final Integer _tmpId;
          if (_cursor.isNull(_cursorIndexOfId)) {
            _tmpId = null;
          } else {
            _tmpId = _cursor.getInt(_cursorIndexOfId);
          }
          final String _tmpCctype;
          if (_cursor.isNull(_cursorIndexOfCctype)) {
            _tmpCctype = null;
          } else {
            _tmpCctype = _cursor.getString(_cursorIndexOfCctype);
          }
          final String _tmpCctypeDesc;
          if (_cursor.isNull(_cursorIndexOfCctypeDesc)) {
            _tmpCctypeDesc = null;
          } else {
            _tmpCctypeDesc = _cursor.getString(_cursorIndexOfCctypeDesc);
          }
          _item_1 = new CcTypeEntity(_tmpId,_tmpCctype,_tmpCctypeDesc);
          _map.put(_tmpKey, _item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
