package com.bits.bee.bpmc.di

import com.bits.bee.bpmc.data.data_source.local.dao.*
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.repository.*
import com.bits.bee.bpmc.domain.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun proivdeBpRepository(apiUtils: ApiUtils, dao: BpDao, bpAddrDao: BpAddrDao, defaultDispatcher: CoroutineDispatcher) : BpRepository {
        return BpRepositoryImpl(apiUtils, dao, bpAddrDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun proivdeBranchRepository(apiUtils: ApiUtils, dao: BranchDao, defaultDispatcher: CoroutineDispatcher) : BranchRepository {
        return BranchRepositoryImpl(apiUtils, dao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun proivdeCashierRepository(apiUtils: ApiUtils, dao: CashierDao, defaultDispatcher: CoroutineDispatcher) : CashierRepository {
        return CashierRepositoryImpl(apiUtils, dao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun proivdeItemGroupRepository(apiUtils: ApiUtils, dao: ItemGroupDao) : ItemGroupRepository {
        return ItemGroupRepositoryImpl(apiUtils, dao)
    }

    @Provides
    @Singleton
    fun proivdeLoginRepository(apiUtils: ApiUtils) : LoginRepository {
        return LoginRepositoryImpl(apiUtils)
    }

    @Provides
    @Singleton
    fun proivdePriceLvlRepository(apiUtils: ApiUtils, dao: PriceLvlDao) : PriceLvlRepository {
        return PriceLvlRepositoryImpl(apiUtils, dao)
    }

    @Provides
    @Singleton
    fun proivdeTaxRepository(apiUtils: ApiUtils, dao: TaxDao) : TaxRepository {
        return TaxRepositoryImpl(apiUtils, dao)
    }

    @Provides
    @Singleton
    fun proivdeChannelRepository(apiUtils: ApiUtils, dao: ChannelDao, defaultDispatcher: CoroutineDispatcher) : ChannelRepository {
        return ChannelRepositoryImpl(apiUtils, dao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun proivdeItemRepository(apiUtils: ApiUtils, itemDao: ItemDao, unitDao: UnitDao, priceDao: PriceDao, defaultDispatcher: CoroutineDispatcher, itemGroupDao: ItemGroupDao, priceLvlDao: PriceLvlDao, itemSaleTaxDao: ItemSaleTaxDao) : ItemRepository {
        return ItemRepositoryImpl(
            apiUtils =  apiUtils,
            itemDao = itemDao,
            defaultDispatcher = defaultDispatcher,
        )
    }

    @Provides
    @Singleton
    fun proivdePriceRepository(dao: PriceDao, apiUtils: ApiUtils, defaultDispatcher: CoroutineDispatcher) : PriceRepository {
        return PriceRepositoryImpl(dao, apiUtils, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun providePrinterRepository(printerDao: PrinterDao, defaultDispatcher: CoroutineDispatcher): PrinterRespository{
        return PrinterRepositoryImpl(printerDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun providePrinterKitchenRepository(printerKitchenDao: PrinterKitchenDao, defaultDispatcher: CoroutineDispatcher): PrinterKitchenRepository{
        return PrinterKitchenRepositoryImpl(printerKitchenDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun providePrinterKitchenDRepository(printerKitchenDDao: PrinterKitchenDDao, defaultDispatcher: CoroutineDispatcher): PrinterKitchenDRepository{
        return PrinterKitchenDRepositoryImpl(printerKitchenDDao,defaultDispatcher)
    }

    @Provides
    @Singleton
    fun proivdeCityRepository(apiUtils: ApiUtils,dao: CityDao, defaultDispatcher: CoroutineDispatcher) : CityRepository {
        return CityRepositoryImpl( apiUtils, dao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun proivdeSaleRepository(apiUtils: ApiUtils,dao: SaleDao, defaultDispatcher: CoroutineDispatcher) : SaleRepository {
        return SaleRepositoryImpl(defaultDispatcher, dao)
    }

    @Provides
    @Singleton
    fun proivdeSaledRepository(apiUtils: ApiUtils,dao: SaledDao, defaultDispatcher: CoroutineDispatcher) : SaledRepository {
        return SaledRepositoryImpl(saledDao = dao, defaultDispatcher = defaultDispatcher)
    }

    @Provides
    @Singleton
    fun providePossesRepository(possesDao: PossesDao, dispatcher: CoroutineDispatcher) : PossesRepository {
        return PossesRepositoryImpl(possesDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideKitchenRepository(kitchenDao: KitchenDao, defaultDispatcher: CoroutineDispatcher): KitchenRepository{
        return KitchenRepositoryImpl(kitchenDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun provideUserRepository(operatorDao: UserDao, defaultDispatcher: CoroutineDispatcher): UserRepository {
        return UserRepositoryImpl(operatorDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun provideCityPopulerRespository(cityPopulerDao: CityPopulerDao, defaultDispatcher: CoroutineDispatcher): CityPopulerRepository{
        return CityPopulerRepositoryImp(cityPopulerDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun provideCrcRepository(operatorDao: CrcDao, defaultDispatcher: CoroutineDispatcher, apiUtils: ApiUtils): CrcRepository {
        return CrcRepositoryImpl(defaultDispatcher, operatorDao, apiUtils)
    }

    @Provides
    @Singleton
    fun provideBpaddrRepository(bpAddrDao: BpAddrDao, defaultDispatcher: CoroutineDispatcher): BpAddrRepository{
        return BpAddrRepositoryImpl(bpAddrDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun provideCmpRepository(operatorDao: CmpDao, defaultDispatcher: CoroutineDispatcher, apiUtils: ApiUtils): CmpRepository {
        return CmpRepositoryImpl(defaultDispatcher, operatorDao, apiUtils)
    }

    @Provides
    @Singleton
    fun provideProvinceRepository(apiUtils: ApiUtils, provinceDao: ProvinceDao, defaultDispatcher: CoroutineDispatcher): ProvinceRepository{
        return ProvinceRepositoryImpl(apiUtils, provinceDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun provideRegencyRepository(apiUtils: ApiUtils, regencyDao: RegencyDao, defaultDispatcher: CoroutineDispatcher): RegencyRepository{
        return RegencyRepositoryImpl(apiUtils, regencyDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun provideDistrictRepository(apiUtils: ApiUtils, districtDao: DistrictDao, defaultDispatcher: CoroutineDispatcher): DistrictRepository{
        return DistrictRepositoryImpl(apiUtils, districtDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun provideInitialRepository(
        apiUtils: ApiUtils,
        cmpDao: CmpDao,
        regDao: RegDao,
        userDao: UserDao,
        usrGrpDao: UsrGrpDao,
        grpPrvDao: GrpPrvDao,
        crcDao: CrcDao,
    ): InitialRepository{
        return InitialRepositoryImpl(
            apiUtils,
            cmpDao,
            regDao,
            userDao,
            usrGrpDao,
            grpPrvDao,
            crcDao
        )
    }

    @Provides
    @Singleton
    fun provideItemKitchenRepository(defaultDispatcher: CoroutineDispatcher, apiUtils: ApiUtils, itemKitchenDao: ItemKitchenDao): ItemKitchenRepository{
        return ItemKitchenRepositoryImpl(
            defaultDispatcher,
            itemKitchenDao,
            apiUtils,
        )
    }

    @Provides
    @Singleton
    fun provideItemBranchRepository(defaultDispatcher: CoroutineDispatcher, apiUtils: ApiUtils, itemBranchDao: ItemBranchDao): ItemBranchRepository{
        return ItemBranchRepositoryImpl(
            apiUtils,
            itemBranchDao,
            defaultDispatcher,
        )
    }

    @Provides
    @Singleton
    fun provideItemSaleTaxRepository(defaultDispatcher: CoroutineDispatcher, apiUtils: ApiUtils, itemBranchDao: ItemSaleTaxDao): ItemSaleTaxRepository{
        return ItemSaleTaxRepositoryImpl(
            defaultDispatcher,
            itemBranchDao,
            apiUtils,
        )
    }

    @Provides
    @Singleton
    fun provideEdcRepository(defaultDispatcher: CoroutineDispatcher, apiUtils: ApiUtils, itemBranchDao: EdcDao): EdcRepository{
        return EdcRepositoryImpl(
            apiUtils,
            itemBranchDao,
            defaultDispatcher,
        )
    }

    @Provides
    @Singleton
    fun provideEdcSurcRepository(defaultDispatcher: CoroutineDispatcher, apiUtils: ApiUtils, itemBranchDao: EdcSurcDao): EdcSurcRepository{
        return EdcSurcRepositoryImpl(
            apiUtils,
            itemBranchDao,
            defaultDispatcher,
        )
    }

    @Provides
    @Singleton
    fun provideCcTypeRepository(defaultDispatcher: CoroutineDispatcher, apiUtils: ApiUtils, itemBranchDao: CcTypeDao): CcTypeRepository{
        return CcTypeRepositoryImpl(
            apiUtils,
            itemBranchDao,
            defaultDispatcher,
        )
    }

    @Provides
    @Singleton
    fun provideCashRepository(cashDao: CashDao, dispatcher: CoroutineDispatcher) : CashRepository {
        return CashRepositoryImpl(cashDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideCashARepository(cashADao: CashADao, dispatcher: CoroutineDispatcher) : CashARepository {
        return CashARepositoryImpl(cashADao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideCstrRepository(cstrDao: CstrDao, dispatcher: CoroutineDispatcher) : CstrRepository {
        return CstrRepositoryImpl(cstrDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideSaleCrcvRepository() : SaleCrcvRepository {
        return SaleCrcvRepositoryImpl()
    }

}