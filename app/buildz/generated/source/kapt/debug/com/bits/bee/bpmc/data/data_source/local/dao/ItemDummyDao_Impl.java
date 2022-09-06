package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.ItemDummyEntity;
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
public final class ItemDummyDao_Impl implements ItemDummyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemDummyEntity> __insertionAdapterOfItemDummyEntity;

  private final EntityDeletionOrUpdateAdapter<ItemDummyEntity> __deletionAdapterOfItemDummyEntity;

  private final EntityDeletionOrUpdateAdapter<ItemDummyEntity> __updateAdapterOfItemDummyEntity;

  public ItemDummyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemDummyEntity = new EntityInsertionAdapter<ItemDummyEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `item_dummy` (`id`,`name`,`itemtype_code`,`itemgroup`,`price`,`unit`,`picpath`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemDummyEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getItemTypeCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getItemTypeCode());
        }
        if (value.getItemGroup() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getItemGroup());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPrice());
        }
        if (value.getUnit() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUnit());
        }
        if (value.getPicPath() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPicPath());
        }
      }
    };
    this.__deletionAdapterOfItemDummyEntity = new EntityDeletionOrUpdateAdapter<ItemDummyEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `item_dummy` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemDummyEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfItemDummyEntity = new EntityDeletionOrUpdateAdapter<ItemDummyEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `item_dummy` SET `id` = ?,`name` = ?,`itemtype_code` = ?,`itemgroup` = ?,`price` = ?,`unit` = ?,`picpath` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemDummyEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getItemTypeCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getItemTypeCode());
        }
        if (value.getItemGroup() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getItemGroup());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPrice());
        }
        if (value.getUnit() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUnit());
        }
        if (value.getPicPath() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPicPath());
        }
        if (value.getId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends ItemDummyEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final ItemDummyEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends ItemDummyEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemDummyEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ItemDummyEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemDummyEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ItemDummyEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfItemDummyEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ItemDummyEntity> getItemList() {
    final String _sql = "SELECT * FROM item_dummy";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfItemTypeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemtype_code");
      final int _cursorIndexOfItemGroup = CursorUtil.getColumnIndexOrThrow(_cursor, "itemgroup");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "unit");
      final int _cursorIndexOfPicPath = CursorUtil.getColumnIndexOrThrow(_cursor, "picpath");
      final List<ItemDummyEntity> _result = new ArrayList<ItemDummyEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemDummyEntity _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpItemTypeCode;
        if (_cursor.isNull(_cursorIndexOfItemTypeCode)) {
          _tmpItemTypeCode = null;
        } else {
          _tmpItemTypeCode = _cursor.getString(_cursorIndexOfItemTypeCode);
        }
        final String _tmpItemGroup;
        if (_cursor.isNull(_cursorIndexOfItemGroup)) {
          _tmpItemGroup = null;
        } else {
          _tmpItemGroup = _cursor.getString(_cursorIndexOfItemGroup);
        }
        final String _tmpPrice;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmpPrice = null;
        } else {
          _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
        }
        final String _tmpUnit;
        if (_cursor.isNull(_cursorIndexOfUnit)) {
          _tmpUnit = null;
        } else {
          _tmpUnit = _cursor.getString(_cursorIndexOfUnit);
        }
        final String _tmpPicPath;
        if (_cursor.isNull(_cursorIndexOfPicPath)) {
          _tmpPicPath = null;
        } else {
          _tmpPicPath = _cursor.getString(_cursorIndexOfPicPath);
        }
        _item = new ItemDummyEntity(_tmpId,_tmpName,_tmpItemTypeCode,_tmpItemGroup,_tmpPrice,_tmpUnit,_tmpPicPath);
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
