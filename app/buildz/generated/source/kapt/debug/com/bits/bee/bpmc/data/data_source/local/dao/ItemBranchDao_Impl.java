package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.ItemBranchEntity;
import java.lang.Class;
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
public final class ItemBranchDao_Impl implements ItemBranchDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemBranchEntity> __insertionAdapterOfItemBranchEntity;

  private final EntityDeletionOrUpdateAdapter<ItemBranchEntity> __deletionAdapterOfItemBranchEntity;

  private final EntityDeletionOrUpdateAdapter<ItemBranchEntity> __updateAdapterOfItemBranchEntity;

  public ItemBranchDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemBranchEntity = new EntityInsertionAdapter<ItemBranchEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `item_branch` (`id`,`branch_id`,`item_id`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemBranchEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getBranchId());
        stmt.bindLong(3, value.getItemId());
      }
    };
    this.__deletionAdapterOfItemBranchEntity = new EntityDeletionOrUpdateAdapter<ItemBranchEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `item_branch` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemBranchEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfItemBranchEntity = new EntityDeletionOrUpdateAdapter<ItemBranchEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `item_branch` SET `id` = ?,`branch_id` = ?,`item_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemBranchEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getBranchId());
        stmt.bindLong(3, value.getItemId());
        stmt.bindLong(4, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends ItemBranchEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final ItemBranchEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends ItemBranchEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemBranchEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ItemBranchEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemBranchEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ItemBranchEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfItemBranchEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ItemBranchEntity> getItemBranchList() {
    final String _sql = "SELECT * FROM item_branch";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfBranchId = CursorUtil.getColumnIndexOrThrow(_cursor, "branch_id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final List<ItemBranchEntity> _result = new ArrayList<ItemBranchEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemBranchEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpBranchId;
        _tmpBranchId = _cursor.getInt(_cursorIndexOfBranchId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _item = new ItemBranchEntity(_tmpId,_tmpBranchId,_tmpItemId);
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
