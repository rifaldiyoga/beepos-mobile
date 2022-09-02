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
    fun provideItemKitchenDao(dbHelper: DbHelper): ItemKitchenDao{
        return dbHelper.itemKitchenDao
    }

    @Provides
    @Singleton
    fun provideDistrictDao(dbHelper: DbHelper): DistrictDao{
        return dbHelper.districtDao
    }

    @Provides
    @Singleton
    fun provideUsrGrpDao(dbHelper: DbHelper): UsrGrpDao{
        return dbHelper.usrGrpDao
    }

    @Provides
    @Singleton
    fun provideGrpPrvDao(dbHelper: DbHelper): GrpPrvDao{
        return dbHelper.grpPrvDao
    }

    @Provides
    @Singleton
    fun provideRegDao(dbHelper: DbHelper): RegDao{
        return dbHelper.regDao
    }

    @Provides
    @Singleton
    fun provideItemBranchDao(dbHelper: DbHelper): ItemBranchDao {
        return dbHelper.itemBranchDao
    }


    @Provides
    @Singleton
    fun provideCashDao(dbHelper: DbHelper): CashDao{
        return dbHelper.cashDao
    }

    @Provides
    @Singleton
    fun provideTaxDao(dbHelper: DbHelper): TaxDao{
        return dbHelper.taxDao
    }

    @Provides
    @Singleton
    fun provideEdcDao(dbHelper: DbHelper): EdcDao{
        return dbHelper.edcDao
    }

    @Provides
    @Singleton
    fun provideEdcSurcDao(dbHelper: DbHelper): EdcSurcDao{
        return dbHelper.edcSurcDao
    }

    @Provides
    @Singleton
    fun provideCcTypeDao(dbHelper: DbHelper): CcTypeDao {
        return dbHelper.ccTypeDao
    }

    @Provides
    @Singleton
    fun provideCashADao(dbHelper: DbHelper): CashADao{
        return dbHelper.cashADao
    }

    @Provides
    @Singleton
    fun provideSaleCrcvDao(dbHelper: DbHelper): SaleCrcvDao{
        return dbHelper.saleCrcvDao
    }

    @Provides
    @Singleton
    fun provideStockDao(dbHelper: DbHelper): StockDao {
        return dbHelper.stockDao
    }

    @Provides
    @Singleton
    fun provideSyncDao(dbHelper: DbHelper): SyncDao{
        return dbHelper.syncDao
    }

    @Provides
    @Singleton
    fun provideWhDao(dbHelper: DbHelper): WhDao{
        return dbHelper.whDao
    }

    @Provides
    @Singleton
    fun provideAddOnDao(dbHelper: DbHelper): AddOnDao{
        return dbHelper.addOnDao
    }

    @Provides
    @Singleton
    fun provideAddOnDDao(dbHelper: DbHelper): AddOnDDao{
        return dbHelper.addOnDDao
    }

    @Provides
    @Singleton
    fun provideItemAddOnDao(dbHelper: DbHelper): ItemAddOnDao{
        return dbHelper.itemAddOnDao
    }

    @Provides
    @Singleton
    fun provideSelectionDao(dbHelper: DbHelper): SelectionDao{
        return dbHelper.selectionDao
    }

    @Provides
    @Singleton
    fun provideCadjDao(dbHelper: DbHelper): CadjDao{
        return dbHelper.cadjDao
    }

    @Provides
    @Singleton
    fun provideSelectionDDao(dbHelper: DbHelper): SelectionDDao{
        return dbHelper.selectionDDao
    }

    @Provides
    @Singleton
    fun provideVariantDao(dbHelper: DbHelper): VariantDao{
        return dbHelper.variantDao
    }

    @Provides
    @Singleton
    fun provideItemVariantDao(dbHelper: DbHelper): ItemVariantDao{
        return dbHelper.itemVariantDao
    }

    @Provides
    @Singleton
    fun providePromoDao(dbHelper: DbHelper): PromoDao{
        return dbHelper.promoDao
    }

    @Provides
    @Singleton
    fun provideSaleAddOnDao(dbHelper: DbHelper): SaleAddOnDao{
        return dbHelper.saleAddOnDao
    }

    @Provides
    @Singleton
    fun provideSaleAddOnDDao(dbHelper: DbHelper): SaleAddOnDDao{
        return dbHelper.saleAddOnDDao
    }

    @Provides
    @Singleton
    fun provideSalePromoDao(dbHelper: DbHelper): SalePromoDao{
        return dbHelper.salePromoDao
    }
}