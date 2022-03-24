package com.bits.bee.bpmc.di

import android.content.Context
import androidx.room.Room
import com.bits.bee.bpmc.data.source.local.dao.BranchDao
import com.bits.bee.bpmc.data.source.local.dao.CashierDao
import com.bits.bee.bpmc.data.source.local.helper.DbHelper
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


}