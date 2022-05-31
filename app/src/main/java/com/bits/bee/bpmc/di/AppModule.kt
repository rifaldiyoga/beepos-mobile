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
    fun proivdeBranchRepository(apiUtils: ApiUtils, dao: BranchDao) : BranchRepository {
        return BranchRepositoryImpl(apiUtils, dao)
    }


    @Provides
    @Singleton
    fun proivdeCashierRepository(apiUtils: ApiUtils, dao: CashierDao) : CashierRepository {
        return CashierRepositoryImpl(apiUtils, dao)
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
    fun providePrinterKitchenRepository(printerKitchenDao: PrinterKitchenDao): PrinterKitchenRepository{
        return PrinterKitchenRepositoryImpl(printerKitchenDao)
    }

    @Provides
    @Singleton
    fun providePrinterKitchenDRepository(printerKitchenDDao: PrinterKitchenDDao): PrinterKitchenDRepository{
        return PrinterKitchenDRepositoryImpl(printerKitchenDDao)
    }

    @Provides
    @Singleton
    fun provideKitchenRepository(kitchenDao: KitchenDao): KitchenRepository{
        return KitchenRepositoryImpl(kitchenDao)
    }

}