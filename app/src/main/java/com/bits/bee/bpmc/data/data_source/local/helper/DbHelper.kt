package com.bits.bee.bpmc.data.data_source.local.helper

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bits.bee.bpmc.data.data_source.local.dao.*
import com.bits.bee.bpmc.data.data_source.local.model.*


@Database(entities = [
    AddOn::class, AddOnD::class,
    BpEntity::class, BranchEntity::class, Cadj::class, Cash::class,
    CashA::class, Cashier::class, Cctype::class,
    ChannelEntity::class, Regency::class, Cstr::class, Edc::class,
    EdcSurc::class, GrpPrv::class, Item::class, ItemAddOn::class,
    ItemBranch::class, ItemKitchen::class, ItemOnBoarding::class,
    ItemPrice::class, ItemTax::class, ItemVariant::class,
    ItemGroupEntity::class, Kitchen::class, License::class, Operator::class,
    Posses::class, PriceLvlEntity::class, Printer::class,
    PrinterKitchen::class, PrinterKitchenD::class,
    Promo::class, PromoMulti::class, Reg::class,
    Sale::class, Salecrcvs::class, SalePromo::class, Selection::class,
    SelectionD::class, Saled::class, Sync::class, Tax::class,
    User::class, Usrgrp::class, Variant::class, City::class, BpAddrEntity::class,
    Province::class, District::class, Pmtd::class], version = 1, exportSchema = false)
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

    companion object {
        const val DATABASE_NAME = "bpmData.db"

    }
}