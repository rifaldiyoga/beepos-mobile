package com.bits.bee.bpmc.di

import android.content.Context
import androidx.room.Room
import com.bits.bee.bpmc.data.data_source.local.dao.*
import com.bits.bee.bpmc.data.data_source.local.helper.DbHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDbHelper(@ApplicationContext context : Context) : DbHelper {
        return Room.databaseBuilder(
            context,
            DbHelper::class.java,
            DbHelper.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideBranchDao(dbHelper: DbHelper) : BranchDao {
        return dbHelper.branchDao
    }

    @Provides
    @Singleton
    fun provideCashierDao(dbHelper: DbHelper) : CashierDao {
        return dbHelper.cashierDao
    }

    @Provides
    @Singleton
    fun provideUserDao(dbHelper: DbHelper) : UserDao {
        return dbHelper.userDao
    }

    @Provides
    @Singleton
    fun provideCityDao(dbHelper: DbHelper) : CityDao {
        return dbHelper.cityDao
    }

    @Provides
    @Singleton
    fun provideBpDao(dbHelper: DbHelper) : BpDao {
        return dbHelper.bpDao
    }

    @Provides
    @Singleton
    fun provideBpAddrDao(dbHelper: DbHelper) : BpAddrDao {
        return dbHelper.bpAddrDao
    }

    @Provides
    @Singleton
    fun provideItemGroupDao(dbHelper: DbHelper) : ItemGroupDao {
        return dbHelper.itemGroupDao
    }

    @Provides
    @Singleton
    fun providePmtdDao(dbHelper: DbHelper) : PmtdDao {
        return dbHelper.pmtdDao
    }

    @Provides
    @Singleton
    fun provideChannelDao(dbHelper: DbHelper) : ChannelDao {
        return dbHelper.channelDao
    }

    @Provides
    @Singleton
    fun providePriceLvlDao(dbHelper: DbHelper) : PriceLvlDao {
        return dbHelper.priceLvlDao
    }

    @Provides
    @Singleton
    fun provideItemDao(dbHelper: DbHelper) : ItemDao {
        return dbHelper.itemDao
    }

}