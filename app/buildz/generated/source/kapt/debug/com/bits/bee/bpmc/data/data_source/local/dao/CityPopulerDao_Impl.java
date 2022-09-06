package com.bits.bee.bpmc.data.data_source.local.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bits.bee.bpmc.data.data_source.local.model.CityPopulerEntity;
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
public final class CityPopulerDao_Impl implements CityPopulerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CityPopulerEntity> __insertionAdapterOfCityPopulerEntity;

  private final EntityDeletionOrUpdateAdapter<CityPopulerEntity> __deletionAdapterOfCityPopulerEntity;

  private final EntityDeletionOrUpdateAdapter<CityPopulerEntity> __updateAdapterOfCityPopulerEntity;

  public CityPopulerDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCityPopulerEntity = new EntityInsertionAdapter<CityPopulerEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `city_populer` (`id`,`name_city`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CityPopulerEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getName_city() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName_city());
        }
      }
    };
    this.__deletionAdapterOfCityPopulerEntity = new EntityDeletionOrUpdateAdapter<CityPopulerEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `city_populer` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CityPopulerEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfCityPopulerEntity = new EntityDeletionOrUpdateAdapter<CityPopulerEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `city_populer` SET `id` = ?,`name_city` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CityPopulerEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getName_city() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName_city());
        }
        if (value.getId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertBulk(final List<? extends CityPopulerEntity> listEntity,
      final Continuation<? super Unit> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertSingle(final CityPopulerEntity entity,
      final Continuation<? super Long> continuation) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public void deleteBulk(final List<? extends CityPopulerEntity> listEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCityPopulerEntity.handleMultiple(listEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final CityPopulerEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCityPopulerEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final CityPopulerEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCityPopulerEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<CityPopulerEntity> getCityPopuler() {
    final String _sql = "SELECT name_city, COUNT(*) AS Jml\n"
            + "FROM city_populer \n"
            + "GROUP BY name_city\n"
            + "ORDER BY Jml DESC\n"
            + "LIMIT 8";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfNameCity = 0;
      final List<CityPopulerEntity> _result = new ArrayList<CityPopulerEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CityPopulerEntity _item;
        final String _tmpName_city;
        if (_cursor.isNull(_cursorIndexOfNameCity)) {
          _tmpName_city = null;
        } else {
          _tmpName_city = _cursor.getString(_cursorIndexOfNameCity);
        }
        _item = new CityPopulerEntity(null,_tmpName_city);
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
