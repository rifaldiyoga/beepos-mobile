package com.bits.bee.bpmc.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00de\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010#\u001a\u00020\u00062\b\b\u0001\u0010$\u001a\u00020%H\u0007J\u0010\u0010&\u001a\u00020\'2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010.\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u00100\u001a\u0002012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u00102\u001a\u0002032\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u00104\u001a\u0002052\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u00106\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u00108\u001a\u0002092\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010:\u001a\u00020;2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010<\u001a\u00020=2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010>\u001a\u00020?2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010@\u001a\u00020A2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010B\u001a\u00020C2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010D\u001a\u00020E2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010F\u001a\u00020G2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010H\u001a\u00020I2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010J\u001a\u00020K2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010L\u001a\u00020M2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010N\u001a\u00020O2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010P\u001a\u00020Q2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010R\u001a\u00020S2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010T\u001a\u00020U2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010V\u001a\u00020W2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010X\u001a\u00020Y2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010Z\u001a\u00020[2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\\\u001a\u00020]2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010^\u001a\u00020_2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010`\u001a\u00020a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010b\u001a\u00020c2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010d\u001a\u00020e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010f\u001a\u00020g2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010h\u001a\u00020i2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010j\u001a\u00020k2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010l\u001a\u00020m2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010n\u001a\u00020o2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010p\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010r\u001a\u00020s2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006t"}, d2 = {"Lcom/bits/bee/bpmc/di/DatabaseModule;", "", "()V", "provideAddOnDDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/AddOnDDao;", "dbHelper", "Lcom/bits/bee/bpmc/data/data_source/local/helper/DbHelper;", "provideAddOnDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/AddOnDao;", "provideBpAddrDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/BpAddrDao;", "provideBpDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/BpDao;", "provideBranchDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/BranchDao;", "provideCashADao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CashADao;", "provideCashDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CashDao;", "provideCashierDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CashierDao;", "provideCcTypeDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CcTypeDao;", "provideChannelDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ChannelDao;", "provideCityDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CityDao;", "provideCityPopulerDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CityPopulerDao;", "provideCmpDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CmpDao;", "provideCrcDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CrcDao;", "provideCstrDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CstrDao;", "provideDbHelper", "context", "Landroid/content/Context;", "provideDistrictDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/DistrictDao;", "provideEdcDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/EdcDao;", "provideEdcSurcDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/EdcSurcDao;", "provideGrpPrvDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/GrpPrvDao;", "provideItemAddOnDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemAddOnDao;", "provideItemBranchDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemBranchDao;", "provideItemDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemDao;", "provideItemDummyDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemDummyDao;", "provideItemGroupDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemGroupDao;", "provideItemKitchenDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemKitchenDao;", "provideItemTaxDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemSaleTaxDao;", "provideItemVariantDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemVariantDao;", "provideKitchenDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/KitchenDao;", "providePmtdDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PmtdDao;", "providePossesDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PossesDao;", "providePriceDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PriceDao;", "providePriceLvlDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PriceLvlDao;", "providePrinterDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PrinterDao;", "providePrinterKitchenDDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PrinterKitchenDDao;", "providePrinterKitchenDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PrinterKitchenDao;", "providePromoDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PromoDao;", "provideProvinceDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ProvinceDao;", "provideRegDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/RegDao;", "provideRegencyDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/RegencyDao;", "provideSaleAddOnDDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleAddOnDDao;", "provideSaleAddOnDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleAddOnDao;", "provideSaleCrcvDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleCrcvDao;", "provideSaleDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleDao;", "provideSaledDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaledDao;", "provideSelectionDDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SelectionDDao;", "provideSelectionDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SelectionDao;", "provideStockDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/StockDao;", "provideTaxDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/TaxDao;", "provideUnitDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UnitDao;", "provideUnitDummyDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UnitDummyDao;", "provideUserDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UserDao;", "provideUsrGrpDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UsrGrpDao;", "provideVariantDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/VariantDao;", "provideWhDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/WhDao;", "app_debug"})
@dagger.Module()
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.helper.DbHelper provideDbHelper(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.BranchDao provideBranchDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.CashierDao provideCashierDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.CityDao provideCityDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.BpDao provideBpDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.BpAddrDao provideBpAddrDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.ItemGroupDao provideItemGroupDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.PmtdDao providePmtdDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.ChannelDao provideChannelDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.PriceLvlDao providePriceLvlDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.ItemDao provideItemDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.UnitDao provideUnitDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.PriceDao providePriceDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.PossesDao providePossesDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.PrinterDao providePrinterDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.CstrDao provideCstrDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDao providePrinterKitchenDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDDao providePrinterKitchenDDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.KitchenDao provideKitchenDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.SaleDao provideSaleDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.CityPopulerDao provideCityPopulerDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.SaledDao provideSaledDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.ProvinceDao provideProvinceDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.UserDao provideUserDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.RegencyDao provideRegencyDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.CrcDao provideCrcDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.CmpDao provideCmpDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.ItemSaleTaxDao provideItemTaxDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.ItemKitchenDao provideItemKitchenDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.DistrictDao provideDistrictDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.UsrGrpDao provideUsrGrpDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.GrpPrvDao provideGrpPrvDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.RegDao provideRegDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.ItemBranchDao provideItemBranchDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.CashDao provideCashDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.TaxDao provideTaxDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.EdcDao provideEdcDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.EdcSurcDao provideEdcSurcDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.CcTypeDao provideCcTypeDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.CashADao provideCashADao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.SaleCrcvDao provideSaleCrcvDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.StockDao provideStockDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.WhDao provideWhDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.AddOnDao provideAddOnDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.AddOnDDao provideAddOnDDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.ItemAddOnDao provideItemAddOnDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.SelectionDao provideSelectionDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.SelectionDDao provideSelectionDDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.VariantDao provideVariantDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.ItemVariantDao provideItemVariantDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.PromoDao providePromoDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.SaleAddOnDao provideSaleAddOnDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.SaleAddOnDDao provideSaleAddOnDDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.ItemDummyDao provideItemDummyDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.data.data_source.local.dao.UnitDummyDao provideUnitDummyDao(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.helper.DbHelper dbHelper) {
        return null;
    }
}