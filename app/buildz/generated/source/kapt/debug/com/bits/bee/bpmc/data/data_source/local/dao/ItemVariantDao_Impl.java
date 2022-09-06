package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.ItemVariantEntity;
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
public final class ItemVariantDao_Impl implements ItemVariantDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemVariantEntity> __insertionAdapterOfItemVariantEntity;

  private final EntityDeletionOrUpdateAdapter<ItemVariantEntity> __deletionAdapterOfItemVariantEntity;

  private final EntityDeletionOrUpdateAdapter<ItemVariantEntity> __updateAdapterOfItemVariantEntity;

  public ItemVariantDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemVariantEntity = new EntityInsertionAdapter<ItemVariantEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `item_variant` (`id`,`variant_id`,`item_id`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemVariantEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getVariantId());
        stmt.bindLong(3, value.getItemId());
      }
    };
    this.__deletionAdapterOfItemVariantEntity = new EntityDeletionOrUpdateAdapter<ItemVariantEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `item_variant` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemVariantEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfItemVariantEntity = new EntityDeletionOrUpdateAdapter<ItemVariantEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `item_variant` SET `id` = ?,`variant_id` = ?,`item_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemVariantEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getVariantId());
        stmt.bindLong(3, value.getItemId());
        stmt.bindLong(4, value.getId());
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends ItemVariantEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final ItemVariantEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends ItemVariantEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemVariantEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ItemVariantEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfItemVariantEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ItemVariantEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfItemVariantEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ItemVariantEntity> getItemVariantList() {
    final String _sql = "SELECT * FROM item_variant";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfVariantId = CursorUtil.getColumnIndexOrThrow(_cursor, "variant_id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final List<ItemVariantEntity> _result = new ArrayList<ItemVariantEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemVariantEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpVariantId;
        _tmpVariantId = _cursor.getInt(_cursorIndexOfVariantId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _item = new ItemVariantEntity(_tmpId,_tmpVariantId,_tmpItemId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemVariantEntity> getItemVariantByVariant(final int variantId) {
    final String _sql = "SELECT * FROM item_variant WHERE variant_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, variantId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfVariantId = CursorUtil.getColumnIndexOrThrow(_cursor, "variant_id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final List<ItemVariantEntity> _result = new ArrayList<ItemVariantEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemVariantEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpVariantId;
        _tmpVariantId = _cursor.getInt(_cursorIndexOfVariantId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _item = new ItemVariantEntity(_tmpId,_tmpVariantId,_tmpItemId);
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
