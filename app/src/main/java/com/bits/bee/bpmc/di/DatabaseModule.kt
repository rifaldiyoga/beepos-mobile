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

    @Provides
    @Singleton
    fun provideUnitDao(dbHelper: DbHelper) : UnitDao {
        return dbHelper.unitDao
    }

    @Provides
    @Singleton
    fun providePriceDao(dbHelper: DbHelper) : PriceDao {
        return dbHelper.priceDao
    }

    @Provides
    @Singleton
    fun providePossesDao(dbHelper: DbHelper) : PossesDao {
        return dbHelper.possesDao
    }

    @Provides
    @Singleton
    fun providePrinterDao(dbHelper: DbHelper): PrinterDao{
        return dbHelper.printerDao
    }

    @Provides
    @Singleton
    fun provideCstrDao(dbHelper: DbHelper) : CstrDao {
        return dbHelper.cstrDao
    }

    @Provides
    @Singleton
    fun providePrinterKitchenDao(dbHelper: DbHelper): PrinterKitchenDao{
        return dbHelper.printerKitchenDao
    }

    @Provides
    @Singleton
    fun providePrinterKitchenDDao(dbHelper: DbHelper): PrinterKitchenDDao{
        return dbHelper.printerKitchenDDao
    }

    @Provides
    @Singleton
    fun provideKitchenDao(dbHelper: DbHelper): KitchenDao{
        return dbHelper.kitchenDao
    }

    @Provides
    @Singleton
    fun provideSaleDao(dbHelper: DbHelper): SaleDao {
        return dbHelper.saleDao
    }

    @Provides
    @Singleton
    fun provideCityPopulerDao(dbHelper: DbHelper): CityPopulerDao{
        return dbHelper.cityPopulerDao
    }

    @Provides
    @Singleton
    fun provideSaledDao(dbHelper: DbHelper): SaledDao {
        return dbHelper.saledDao
    }

    @Provides
    @Singleton
    fun provideProvinceDao(dbHelper: DbHelper): ProvinceDao{
        return dbHelper.provinceDao
    }

    @Provides
    @Singleton
    fun provideUserDao(dbHelper: DbHelper): UserDao {
        return dbHelper.userDao
    }

    @Provides
    @Singleton
    fun provideRegencyDao(dbHelper: DbHelper): RegencyDao{
        return dbHelper.regencyDao
    }

    @Provides
    @Singleton
    fun provideCrcDao(dbHelper: DbHelper): CrcDao{
        return dbHelper.crcDao
    }

    @Provides
    @Singleton
    fun provideCmpDao(dbHelper: DbHelper): CmpDao{
        return dbHelper.cmpDao
    }

    @Provides
    @Singleton
    fun provideItemTaxDao(dbHelper: DbHelper): ItemSaleTaxDao{
        return dbHelper.itemSaleTaxDao
    }

    @Provides
    @Singleton
    fun provideDistrictDao(dbHelper: DbHelper): DistrictDao{
        return dbHelper.districtDao
    }
}