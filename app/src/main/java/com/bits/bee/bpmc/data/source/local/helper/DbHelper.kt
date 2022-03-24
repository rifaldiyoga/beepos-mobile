package com.bits.bee.bpmc.data.source.local.helper

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bits.bee.bpmc.data.source.local.dao.BranchDao
import com.bits.bee.bpmc.data.source.local.dao.CashierDao
import com.bits.bee.bpmc.data.source.local.dao.TaxDao
import com.bits.bee.bpmc.data.source.local.model.*


@Database(entities = [
    AddOn::class, AddOnD::class,
    Bp::class, BranchEntitiy::class, Cadj::class, Cash::class,
    CashA::class, Cashier::class, Cctype::class,
    Channel::class, Regency::class, Cstr::class, Edc::class,
    EdcSurc::class, GrpPrv::class, Item::class, ItemAddOn::class,
    ItemBranch::class, ItemKitchen::class, ItemOnBoarding::class,
    ItemPrice::class, ItemTax::class, ItemVariant::class,
    Itemgrp::class, Kitchen::class, License::class, Operator::class,
    Posses::class, PriceLvl::class, Printer::class,
    PrinterKitchen::class, PrinterKitchenD::class,
    Promo::class, PromoMulti::class, Reg::class,
    Sale::class, Salecrcvs::class, SalePromo::class, Selection::class,
    SelectionD::class, Saled::class, Sync::class, Tax::class,
    User::class, Usrgrp::class, Variant::class, City::class, BpAddr::class, Province::class, District::class], version = 1, exportSchema = false)
@TypeConverters(com.bits.bee.bpmc.data.source.local.converter.Converters::class)
abstract class DbHelper : RoomDatabase() {

    abstract val taxDao : TaxDao
    abstract val branchDao : BranchDao
    abstract val cashierDao : CashierDao

    companion object {
        const val DATABASE_NAME = "bpmData.db"

    }
}