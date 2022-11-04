package com.bits.bee.bpmc.di

import com.bits.bee.bpmc.data.data_source.local.dao.*
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.repository.*
import com.bits.bee.bpmc.domain.calc.PromoCalc
import com.bits.bee.bpmc.domain.calc.SaleCalc
import com.bits.bee.bpmc.domain.repository.*
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetPriceItemUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetRegUseCase
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
    fun proivdeBpRepository(apiUtils: ApiUtils, dao: BpDao, bpAddr : BpAddrDao, defaultDispatcher: CoroutineDispatcher) : BpRepository {
        return BpRepositoryImpl(apiUtils, dao, bpAddr, defaultDispatcher)
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
    fun proivdeItemRepository(apiUtils: ApiUtils, itemDao: ItemDao,  defaultDispatcher: CoroutineDispatcher ) : ItemRepository {
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
    fun providePrinterRepository(
        printerDao: PrinterDao,
        defaultDispatcher: CoroutineDispatcher
    ): PrinterRespository {
        return PrinterRepositoryImpl(printerDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun providePrinterKitchenRepository(
        printerKitchenDao: PrinterKitchenDao,
        defaultDispatcher: CoroutineDispatcher
    ): PrinterKitchenRepository {
        return PrinterKitchenRepositoryImpl(printerKitchenDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun providePrinterKitchenDRepository(
        printerKitchenDDao: PrinterKitchenDDao,
        defaultDispatcher: CoroutineDispatcher
    ): PrinterKitchenDRepository {
        return PrinterKitchenDRepositoryImpl(printerKitchenDDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun proivdeCityRepository(
        apiUtils: ApiUtils,
        dao: CityDao,
        defaultDispatcher: CoroutineDispatcher
    ): CityRepository {
        return CityRepositoryImpl(apiUtils, dao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun proivdeSaleRepository(
        dao: SaleDao,
        defaultDispatcher: CoroutineDispatcher
    ): SaleRepository {
        return SaleRepositoryImpl(defaultDispatcher, dao)
    }

    @Provides
    @Singleton
    fun proivdeSaledRepository(
        dao: SaledDao,
        defaultDispatcher: CoroutineDispatcher
    ): SaledRepository {
        return SaledRepositoryImpl(saledDao = dao, defaultDispatcher = defaultDispatcher)
    }

    @Provides
    @Singleton
    fun providePossesRepository(
        possesDao: PossesDao,
        dispatcher: CoroutineDispatcher
    ): PossesRepository {
        return PossesRepositoryImpl(possesDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideKitchenRepository(
        kitchenDao: KitchenDao,
        defaultDispatcher: CoroutineDispatcher
    ): KitchenRepository {
        return KitchenRepositoryImpl(kitchenDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        operatorDao: UserDao,
        defaultDispatcher: CoroutineDispatcher,
        apiUtils: ApiUtils
    ): UserRepository {
        return UserRepositoryImpl(operatorDao, defaultDispatcher, apiUtils)
    }

    @Provides
    @Singleton
    fun provideCityPopulerRespository(
        cityPopulerDao: CityPopulerDao,
        defaultDispatcher: CoroutineDispatcher
    ): CityPopulerRepository {
        return CityPopulerRepositoryImp(cityPopulerDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun provideCrcRepository(
        operatorDao: CrcDao,
        defaultDispatcher: CoroutineDispatcher,
        apiUtils: ApiUtils
    ): CrcRepository {
        return CrcRepositoryImpl(defaultDispatcher, operatorDao, apiUtils)
    }

    @Provides
    @Singleton
    fun provideBpaddrRepository(
        bpAddrDao: BpAddrDao,
        defaultDispatcher: CoroutineDispatcher
    ): BpAddrRepository {
        return BpAddrRepositoryImpl(bpAddrDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun provideCmpRepository(
        operatorDao: CmpDao,
        defaultDispatcher: CoroutineDispatcher,
        apiUtils: ApiUtils
    ): CmpRepository {
        return CmpRepositoryImpl(defaultDispatcher, operatorDao, apiUtils)
    }

    @Provides
    @Singleton
    fun provideProvinceRepository(
        apiUtils: ApiUtils,
        provinceDao: ProvinceDao,
        defaultDispatcher: CoroutineDispatcher
    ): ProvinceRepository {
        return ProvinceRepositoryImpl(apiUtils, provinceDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun provideRegencyRepository(
        apiUtils: ApiUtils,
        regencyDao: RegencyDao,
        defaultDispatcher: CoroutineDispatcher
    ): RegencyRepository {
        return RegencyRepositoryImpl(apiUtils, regencyDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun provideDistrictRepository(
        apiUtils: ApiUtils,
        districtDao: DistrictDao,
        defaultDispatcher: CoroutineDispatcher
    ): DistrictRepository {
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
        whDao: WhDao,
        srepDao : SrepDao,
    ): InitialRepository{
        return InitialRepositoryImpl(
            apiUtils,
            cmpDao,
            regDao,
            userDao,
            usrGrpDao,
            grpPrvDao,
            crcDao,
            whDao,
            srepDao
        )
    }

    @Provides
    @Singleton
    fun provideItemKitchenRepository(
        defaultDispatcher: CoroutineDispatcher,
        apiUtils: ApiUtils,
        itemKitchenDao: ItemKitchenDao
    ): ItemKitchenRepository {
        return ItemKitchenRepositoryImpl(
            defaultDispatcher,
            itemKitchenDao,
            apiUtils,
        )
    }

    @Provides
    @Singleton
    fun provideItemBranchRepository(
        defaultDispatcher: CoroutineDispatcher,
        apiUtils: ApiUtils,
        itemBranchDao: ItemBranchDao
    ): ItemBranchRepository {
        return ItemBranchRepositoryImpl(
            apiUtils,
            itemBranchDao,
            defaultDispatcher,
        )
    }

    @Provides
    @Singleton
    fun provideItemSaleTaxRepository(
        defaultDispatcher: CoroutineDispatcher,
        apiUtils: ApiUtils,
        itemBranchDao: ItemSaleTaxDao
    ): ItemSaleTaxRepository {
        return ItemSaleTaxRepositoryImpl(
            defaultDispatcher,
            itemBranchDao,
            apiUtils,
        )
    }

    @Provides
    @Singleton
    fun provideEdcRepository(
        defaultDispatcher: CoroutineDispatcher,
        apiUtils: ApiUtils,
        itemBranchDao: EdcDao
    ): EdcRepository {
        return EdcRepositoryImpl(
            apiUtils,
            itemBranchDao,
            defaultDispatcher,
        )
    }

    @Provides
    @Singleton
    fun provideEdcSurcRepository(
        defaultDispatcher: CoroutineDispatcher,
        apiUtils: ApiUtils,
        itemBranchDao: EdcSurcDao
    ): EdcSurcRepository {
        return EdcSurcRepositoryImpl(
            apiUtils,
            itemBranchDao,
            defaultDispatcher,
        )
    }

    @Provides
    @Singleton
    fun provideCcTypeRepository(
        defaultDispatcher: CoroutineDispatcher,
        apiUtils: ApiUtils,
        itemBranchDao: CcTypeDao
    ): CcTypeRepository {
        return CcTypeRepositoryImpl(
            apiUtils,
            itemBranchDao,
            defaultDispatcher,
        )
    }

    @Provides
    @Singleton
    fun provideCashRepository(cashDao: CashDao, dispatcher: CoroutineDispatcher): CashRepository {
        return CashRepositoryImpl(cashDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideCashARepository(
        cashADao: CashADao,
        dispatcher: CoroutineDispatcher
    ): CashARepository {
        return CashARepositoryImpl(cashADao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideCstrRepository(cstrDao: CstrDao, dispatcher: CoroutineDispatcher): CstrRepository {
        return CstrRepositoryImpl(cstrDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideSaleCrcvRepository(
        saleCrcvDao: SaleCrcvDao,
        dispatcher: CoroutineDispatcher
    ): SaleCrcvRepository {
        return SaleCrcvRepositoryImpl(saleCrcvDao, dispatcher)
    }

    @Provides
    @Singleton
    fun providePmtdRepository(
        apiUtils: ApiUtils,
        saleCrcvDao: PmtdDao,
        edcDao: EdcDao,
        edcSurcDao: EdcSurcDao,
        branchDao: BranchDao,
        dispatcher: CoroutineDispatcher
    ): PmtdRepository {
        return PmtdRepositoryImpl(apiUtils, saleCrcvDao, edcDao, edcSurcDao, branchDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideStockRepository(apiUtils: ApiUtils, saleCrcvDao: StockDao): StockRepository {
        return StockRepositoryImpl(apiUtils, saleCrcvDao)
    }

    @Provides
    @Singleton
    fun proivdeSyncRepository(
        apiUtils: ApiUtils,
        syncDao: SyncDao,
        defaultDispatcher: CoroutineDispatcher
    ): SyncRepository {
        return SyncRepositoryImpl(apiUtils, syncDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun provideWhRepository(
        apiUtils: ApiUtils,
        saleCrcvDao: WhDao,
        dispatcher: CoroutineDispatcher
    ): WhRepository {
        return WhRepositoryImpl(apiUtils, saleCrcvDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideUnitRepository(
        apiUtils: ApiUtils,
        saleCrcvDao: UnitDao,
        dispatcher: CoroutineDispatcher
    ): UnitRepository {
        return UnitRepositoryImpl(apiUtils, saleCrcvDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideAddOnRepository(
        apiUtils: ApiUtils,
        saleCrcvDao: AddOnDao,
        dispatcher: CoroutineDispatcher
    ): AddOnRepository {
        return AddOnRepositoryImpl(apiUtils, saleCrcvDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideAddOnDRepository(
        apiUtils: ApiUtils,
        saleCrcvDao: AddOnDDao,
        dispatcher: CoroutineDispatcher
    ): AddOnDRepository {
        return AddOnDRepositoryImpl(apiUtils, saleCrcvDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideItemAddOnRepository(
        apiUtils: ApiUtils,
        saleCrcvDao: ItemAddOnDao,
        dispatcher: CoroutineDispatcher
    ): ItemAddOnRepository {
        return ItemAddOnRepositoryImpl(apiUtils, saleCrcvDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideSelectionRepository(
        apiUtils: ApiUtils,
        saleCrcvDao: SelectionDao,
        dispatcher: CoroutineDispatcher
    ): SelectionRepository {
        return SelectionRepositoryImpl(apiUtils, saleCrcvDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideSelectionDRepository(
        apiUtils: ApiUtils,
        saleCrcvDao: SelectionDDao,
        dispatcher: CoroutineDispatcher
    ): SelectionDRepository {
        return SelectionDRepositoryImpl(apiUtils, saleCrcvDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideVariantRepository(
        apiUtils: ApiUtils,
        saleCrcvDao: VariantDao,
        itemDao: ItemDao,
        dispatcher: CoroutineDispatcher
    ): VariantRepository {
        return VariantRepositoryImpl(apiUtils, saleCrcvDao, itemDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideItemVariantRepository(
        apiUtils: ApiUtils,
        saleCrcvDao: ItemVariantDao,
        dispatcher: CoroutineDispatcher
    ): ItemVariantRepository {
        return ItemVariantRepositoryImpl(apiUtils, saleCrcvDao, dispatcher)
    }

    @Provides
    @Singleton
    fun providePromoRepository(
        apiUtils: ApiUtils,
        saleCrcvDao: PromoDao,
        dispatcher: CoroutineDispatcher
    ): PromoRepository {
        return PromoRepositoryImpl(apiUtils, saleCrcvDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideSignUpRepository(apiUtils: ApiUtils, ): SignUpRepository {
        return SignUpRepositoryImpl(apiUtils,)
    }

    @Provides
    @Singleton
    fun proivdeCadjRepository(
        apiUtils: ApiUtils,
        cadjDao: CadjDao,
        defaultDispatcher: CoroutineDispatcher
    ): CadjRepository {
        return CadjRepositoryImpl(apiUtils, cadjDao, defaultDispatcher)
    }

    @Provides
    @Singleton
    fun provideItemDummyRepository(
        saleCrcvDao: ItemDummyDao,
        dispatcher: CoroutineDispatcher,
        apiUtils: ApiUtils
    ): ItemDummyRepository {
        return ItemDummyRepositoryImpl(saleCrcvDao, dispatcher, apiUtils)
    }


    @Provides
    @Singleton
    fun provideUnitDummyRepository(
        saleCrcvDao: UnitDummyDao,
        dispatcher: CoroutineDispatcher
    ): UnitDummyRepository {
        return UnitDummyRepositoryImpl(saleCrcvDao, dispatcher,)
    }

    @Provides
    @Singleton
    fun provideSaleAddOnRepository(dispatcher: CoroutineDispatcher, saleAddOnDao: SaleAddOnDao) : SaleAddOnRepository {
        return SaleAddOnRepositoryImpl(dispatcher, saleAddOnDao)
    }

    @Provides
    @Singleton
    fun provideSaleAddOnDRepository(dispatcher: CoroutineDispatcher, saleAddOnDDao: SaleAddOnDDao) : SaleAddOnDRepository {
        return SaleAddOnDRepositoryImpl(dispatcher, saleAddOnDDao)
    }

    @Provides
    @Singleton
    fun provideSalePromoRepository(salePromoDao: SalePromoDao, dispatcher: CoroutineDispatcher) : SalePromoRepository {
        return SalePromoRepositoryImpl(salePromoDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideLicenseRepository(salePromoDao: LicenseDao, dispatcher: CoroutineDispatcher, apiUtils: ApiUtils) : LicenseRepository {
        return LicenseRepositoryImpl(apiUtils ,salePromoDao, dispatcher)
    }

    @Provides
    @Singleton
    fun providePromoMultiRepository(salePromoDao: PromoMultiDao, dispatcher: CoroutineDispatcher, apiUtils: ApiUtils) : PromoMultiRepository {
        return PromoMultiRepositoryImpl(apiUtils ,salePromoDao, dispatcher)
    }

    @Provides
    @Singleton
    fun providePromoCalc(getActiveCashierUseCase: GetActiveCashierUseCase, promoMultiRepository: PromoMultiRepository,
                         promoRepository: PromoRepository, getPriceItemUseCase: GetPriceItemUseCase, itemRepository: ItemRepository) : PromoCalc {
        return PromoCalc(
            getActiveCashierUseCase = getActiveCashierUseCase,
            promoMultiRepository = promoMultiRepository,
            promoRepository = promoRepository,
            getPriceItemUseCase = getPriceItemUseCase,
            itemRepository = itemRepository
        )
    }

    @Provides
    @Singleton
    fun provideSaleCalc(getRegUseCase: GetRegUseCase) : SaleCalc {
        return SaleCalc(getRegUseCase)
    }

    @Provides
    @Singleton
    fun provideSrepRepository(salePromoDao: SrepDao, dispatcher: CoroutineDispatcher, apiUtils: ApiUtils) : SrepRepository {
        return SrepRepositoryImpl(salePromoDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideRegRepository(salePromoDao: RegDao, dispatcher: CoroutineDispatcher, apiUtils: ApiUtils) : RegRepository {
        return RegRepositoryImpl(apiUtils, salePromoDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideGrpPrvRepository(salePromoDao: GrpPrvDao, dispatcher: CoroutineDispatcher, apiUtils: ApiUtils) : GrpPrvRepository {
        return GrpPrvRepositoryImpl(apiUtils, salePromoDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideUsrGrpRepository(salePromoDao: UsrGrpDao, dispatcher: CoroutineDispatcher, apiUtils: ApiUtils) : UsrGrpRepository {
        return UsrGrpRepositoryImpl(apiUtils, salePromoDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideGopayRepository(apiUtils: ApiUtils) : GopayRepository {
        return GopayRepositoryImpl(apiUtils)
    }

}