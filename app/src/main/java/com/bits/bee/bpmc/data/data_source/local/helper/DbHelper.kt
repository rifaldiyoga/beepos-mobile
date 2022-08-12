package com.bits.bee.bpmc.data.data_source.local.helper

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bits.bee.bpmc.data.data_source.local.dao.*
import com.bits.bee.bpmc.data.data_source.local.model.*


@Database(entities = [
    AddOnEntity::class, AddOnDEntity::class,
    BpEntity::class, BranchEntity::class, CadjEntity::class, CashEntity::class,
    CashAEntity::class, CashierEntity::class, CcTypeEntity::class,
    ChannelEntity::class, RegencyEntity::class, CstrEntity::class, EdcEntity::class,
    EdcSurcEntity::class, GrpPrvEntity::class, ItemEntity::class, ItemAddOnEntity::class,
    ItemBranchEntity::class, ItemKitchenEntity::class, ItemOnBoardingEntity::class,
    PriceEntity::class, ItemSaleTaxEntity::class, ItemVariantEntity::class,
    ItemGroupEntity::class, KitchenEntity::class, LicenseEntity::class,
    PossesEntity::class, PriceLvlEntity::class, PrinterEntity::class,
    PrinterKitchenEntity::class, PrinterKitchenDEntity::class,
    PromoEntity::class, PromoMultiEntity::class, RegEntity::class,
    SaleEntity::class, SaleCrcvEntity::class, SalePromoEntity::class, SelectionEntity::class,
    SelectionDEntity::class, SaledEntity::class, SyncEntity::class, TaxEntity::class,
    UserEntity::class, UsrGrpEntity::class, VariantEntity::class, CityEntity::class, BpAddrEntity::class,
    ProvinceEntity::class, DistrictEntity::class, PmtdEntity::class, UnitEntity::class, CmpEntity::class,
    CrcEntity::class, CityPopulerEntity::class, StockEntity::class, WhEntity::class], version = 1, exportSchema = false)
@TypeConverters(com.bits.bee.bpmc.data.data_source.local.converter.Converters::class)
abstract class DbHelper : RoomDatabase() {

    abstract val taxDao : TaxDao

    abstract val branchDao : BranchDao

    abstract val cashierDao : CashierDao

    abstract val userDao : UserDao

    abstract val cityDao : CityDao

    abstract val itemGroupDao : ItemGroupDao

    abstract val bpDao : BpDao

    abstract val bpAddrDao : BpAddrDao

    abstract val pmtdDao : PmtdDao

    abstract val channelDao : ChannelDao

    abstract val priceLvlDao : PriceLvlDao

    abstract val itemDao : ItemDao

    abstract val unitDao : UnitDao

    abstract val priceDao : PriceDao

    abstract val saleDao : SaleDao

    abstract val saledDao : SaledDao

    abstract val possesDao : PossesDao

    abstract val cstrDao : CstrDao

    abstract val printerDao: PrinterDao

    abstract val printerKitchenDao: PrinterKitchenDao

    abstract val printerKitchenDDao: PrinterKitchenDDao

    abstract val kitchenDao: KitchenDao

    abstract val crcDao : CrcDao

    abstract val cmpDao : CmpDao

    abstract val itemSaleTaxDao : ItemSaleTaxDao

    abstract val itemKitchenDao : ItemKitchenDao

    abstract val itemBranchDao : ItemBranchDao

    abstract val addOnDao : AddOnDao

    abstract val addOnDDao : AddOnDDao

    abstract val itemAddOnDao : ItemAddOnDao

    abstract val selectionDao : SelectionDao

    abstract val selectionDDao : SelectionDDao

    abstract val itemVariantDao : ItemVariantDao

    abstract val variantDao : VariantDao

    abstract val regDao : RegDao

    abstract val promoDao : PromoDao

    abstract val edcDao : EdcDao

    abstract val edcSurcDao : EdcSurcDao

    abstract val ccTypeDao : CcTypeDao

    abstract val grpPrvDao : GrpPrvDao

    abstract val usrGrpDao : UsrGrpDao

    abstract val cityPopulerDao: CityPopulerDao

    abstract val provinceDao: ProvinceDao

    abstract val regencyDao: RegencyDao

    abstract val districtDao: DistrictDao

    abstract val cashDao: CashDao

    abstract val cashADao: CashADao

    abstract val saleCrcvDao : SaleCrcvDao

    abstract val stockDao : StockDao

    abstract val whDao : WhDao

    companion object {
        const val DATABASE_NAME = "bpmData.db"

    }
}