package com.bits.bee.bpmc.data.data_source.local.helper

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bits.bee.bpmc.data.data_source.local.dao.*
import com.bits.bee.bpmc.data.data_source.local.model.*


@Database(entities = [
    AddOn::class, AddOnD::class,
    BpEntity::class, BranchEntity::class, Cadj::class, Cash::class,
    CashA::class, CashierEntity::class, Cctype::class,
    ChannelEntity::class, RegencyEntity::class, CstrEntity::class, Edc::class,
    EdcSurc::class, GrpPrv::class, ItemEntity::class, ItemAddOn::class,
    ItemBranch::class, ItemKitchen::class, ItemOnBoarding::class,
    PriceEntity::class, ItemTax::class, ItemVariant::class,
    ItemGroupEntity::class, KitchenEntity::class, License::class, Operator::class,
    PossesEntity::class, PriceLvlEntity::class, PrinterEntity::class,
    PrinterKitchenEntity::class, PrinterKitchenDEntity::class,
    Promo::class, PromoMulti::class, Reg::class,
    SaleEntity::class, Salecrcvs::class, SalePromo::class, Selection::class,
    SelectionD::class, SaledEntity::class, Sync::class, Tax::class,
    User::class, Usrgrp::class, Variant::class, CityEntity::class, BpAddrEntity::class,
    ProvinceEntity::class, DistrictEntity::class, Pmtd::class, UnitEntity::class, CityPopulerEntity::class], version = 1, exportSchema = false)
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

    abstract val cityPopulerDao: CityPopulerDao

    abstract val provinceDao: ProvinceDao

    abstract val regencyDao: RegencyDao

    abstract val districtDao: DistrictDao

    companion object {
        const val DATABASE_NAME = "bpmData.db"

    }
}