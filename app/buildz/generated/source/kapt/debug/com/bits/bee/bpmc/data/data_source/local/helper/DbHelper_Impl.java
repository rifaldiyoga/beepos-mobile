package com.bits.bee.bpmc.data.data_source.local.helper;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.bits.bee.bpmc.data.data_source.local.dao.AddOnDDao;
import com.bits.bee.bpmc.data.data_source.local.dao.AddOnDDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.AddOnDao;
import com.bits.bee.bpmc.data.data_source.local.dao.AddOnDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.BpAddrDao;
import com.bits.bee.bpmc.data.data_source.local.dao.BpAddrDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.BpDao;
import com.bits.bee.bpmc.data.data_source.local.dao.BpDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.BranchDao;
import com.bits.bee.bpmc.data.data_source.local.dao.BranchDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.CashADao;
import com.bits.bee.bpmc.data.data_source.local.dao.CashADao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.CashDao;
import com.bits.bee.bpmc.data.data_source.local.dao.CashDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.CashierDao;
import com.bits.bee.bpmc.data.data_source.local.dao.CashierDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.CcTypeDao;
import com.bits.bee.bpmc.data.data_source.local.dao.CcTypeDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.ChannelDao;
import com.bits.bee.bpmc.data.data_source.local.dao.ChannelDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.CityDao;
import com.bits.bee.bpmc.data.data_source.local.dao.CityDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.CityPopulerDao;
import com.bits.bee.bpmc.data.data_source.local.dao.CityPopulerDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.CmpDao;
import com.bits.bee.bpmc.data.data_source.local.dao.CmpDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.CrcDao;
import com.bits.bee.bpmc.data.data_source.local.dao.CrcDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.CstrDao;
import com.bits.bee.bpmc.data.data_source.local.dao.CstrDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.DistrictDao;
import com.bits.bee.bpmc.data.data_source.local.dao.DistrictDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.EdcDao;
import com.bits.bee.bpmc.data.data_source.local.dao.EdcDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.EdcSurcDao;
import com.bits.bee.bpmc.data.data_source.local.dao.EdcSurcDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.GrpPrvDao;
import com.bits.bee.bpmc.data.data_source.local.dao.GrpPrvDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemAddOnDao;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemAddOnDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemBranchDao;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemBranchDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemDao;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemDummyDao;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemDummyDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemGroupDao;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemGroupDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemKitchenDao;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemKitchenDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemSaleTaxDao;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemSaleTaxDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemVariantDao;
import com.bits.bee.bpmc.data.data_source.local.dao.ItemVariantDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.KitchenDao;
import com.bits.bee.bpmc.data.data_source.local.dao.KitchenDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.PmtdDao;
import com.bits.bee.bpmc.data.data_source.local.dao.PmtdDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.PossesDao;
import com.bits.bee.bpmc.data.data_source.local.dao.PossesDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.PriceDao;
import com.bits.bee.bpmc.data.data_source.local.dao.PriceDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.PriceLvlDao;
import com.bits.bee.bpmc.data.data_source.local.dao.PriceLvlDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.PrinterDao;
import com.bits.bee.bpmc.data.data_source.local.dao.PrinterDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDDao;
import com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDao;
import com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.PromoDao;
import com.bits.bee.bpmc.data.data_source.local.dao.PromoDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.ProvinceDao;
import com.bits.bee.bpmc.data.data_source.local.dao.ProvinceDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.RegDao;
import com.bits.bee.bpmc.data.data_source.local.dao.RegDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.RegencyDao;
import com.bits.bee.bpmc.data.data_source.local.dao.RegencyDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.SaleAddOnDDao;
import com.bits.bee.bpmc.data.data_source.local.dao.SaleAddOnDDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.SaleAddOnDao;
import com.bits.bee.bpmc.data.data_source.local.dao.SaleAddOnDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.SaleCrcvDao;
import com.bits.bee.bpmc.data.data_source.local.dao.SaleCrcvDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.SaleDao;
import com.bits.bee.bpmc.data.data_source.local.dao.SaleDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.SaledDao;
import com.bits.bee.bpmc.data.data_source.local.dao.SaledDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.SelectionDDao;
import com.bits.bee.bpmc.data.data_source.local.dao.SelectionDDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.SelectionDao;
import com.bits.bee.bpmc.data.data_source.local.dao.SelectionDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.StockDao;
import com.bits.bee.bpmc.data.data_source.local.dao.StockDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.TaxDao;
import com.bits.bee.bpmc.data.data_source.local.dao.TaxDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.UnitDao;
import com.bits.bee.bpmc.data.data_source.local.dao.UnitDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.UnitDummyDao;
import com.bits.bee.bpmc.data.data_source.local.dao.UnitDummyDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.UserDao;
import com.bits.bee.bpmc.data.data_source.local.dao.UserDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.UsrGrpDao;
import com.bits.bee.bpmc.data.data_source.local.dao.UsrGrpDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.VariantDao;
import com.bits.bee.bpmc.data.data_source.local.dao.VariantDao_Impl;
import com.bits.bee.bpmc.data.data_source.local.dao.WhDao;
import com.bits.bee.bpmc.data.data_source.local.dao.WhDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DbHelper_Impl extends DbHelper {
  private volatile TaxDao _taxDao;

  private volatile BranchDao _branchDao;

  private volatile CashierDao _cashierDao;

  private volatile UserDao _userDao;

  private volatile CityDao _cityDao;

  private volatile ItemGroupDao _itemGroupDao;

  private volatile BpDao _bpDao;

  private volatile BpAddrDao _bpAddrDao;

  private volatile PmtdDao _pmtdDao;

  private volatile ChannelDao _channelDao;

  private volatile PriceLvlDao _priceLvlDao;

  private volatile ItemDao _itemDao;

  private volatile UnitDao _unitDao;

  private volatile PriceDao _priceDao;

  private volatile SaleDao _saleDao;

  private volatile SaledDao _saledDao;

  private volatile PossesDao _possesDao;

  private volatile CstrDao _cstrDao;

  private volatile PrinterDao _printerDao;

  private volatile PrinterKitchenDao _printerKitchenDao;

  private volatile PrinterKitchenDDao _printerKitchenDDao;

  private volatile KitchenDao _kitchenDao;

  private volatile CrcDao _crcDao;

  private volatile CmpDao _cmpDao;

  private volatile ItemSaleTaxDao _itemSaleTaxDao;

  private volatile ItemKitchenDao _itemKitchenDao;

  private volatile ItemBranchDao _itemBranchDao;

  private volatile AddOnDao _addOnDao;

  private volatile AddOnDDao _addOnDDao;

  private volatile ItemAddOnDao _itemAddOnDao;

  private volatile SelectionDao _selectionDao;

  private volatile SelectionDDao _selectionDDao;

  private volatile ItemVariantDao _itemVariantDao;

  private volatile VariantDao _variantDao;

  private volatile RegDao _regDao;

  private volatile PromoDao _promoDao;

  private volatile EdcDao _edcDao;

  private volatile EdcSurcDao _edcSurcDao;

  private volatile CcTypeDao _ccTypeDao;

  private volatile GrpPrvDao _grpPrvDao;

  private volatile UsrGrpDao _usrGrpDao;

  private volatile CityPopulerDao _cityPopulerDao;

  private volatile ProvinceDao _provinceDao;

  private volatile RegencyDao _regencyDao;

  private volatile DistrictDao _districtDao;

  private volatile CashDao _cashDao;

  private volatile CashADao _cashADao;

  private volatile SaleCrcvDao _saleCrcvDao;

  private volatile StockDao _stockDao;

  private volatile WhDao _whDao;

  private volatile SaleAddOnDao _saleAddOnDao;

  private volatile SaleAddOnDDao _saleAddOnDDao;

  private volatile ItemDummyDao _itemDummyDao;

  private volatile UnitDummyDao _unitDummyDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `addon` (`id` INTEGER NOT NULL, `code` TEXT NOT NULL, `name` TEXT NOT NULL, `is_active` INTEGER NOT NULL, `created_at` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `addond` (`id` INTEGER, `addon_id` INTEGER NOT NULL, `selection_id` INTEGER NOT NULL, `idx` INTEGER NOT NULL, `addond` INTEGER NOT NULL, `isskip` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`addon_id`) REFERENCES `addon`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`selection_id`) REFERENCES `selection`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_addond_addon_id` ON `addond` (`addon_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_addond_selection_id` ON `addond` (`selection_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `bp` (`id` INTEGER, `code` TEXT NOT NULL, `name` TEXT NOT NULL, `greeting` TEXT NOT NULL, `anniversary` TEXT NOT NULL, `taxedonsale` INTEGER NOT NULL, `taxinconsale` INTEGER NOT NULL, `note` TEXT NOT NULL, `bpgrp1_id` INTEGER, `pricelvl_id` INTEGER NOT NULL, `active` INTEGER NOT NULL, `created_at` INTEGER NOT NULL, `created_by` INTEGER NOT NULL, `updated_at` INTEGER, `updated_by` INTEGER, `isfavorit` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`pricelvl_id`) REFERENCES `price_lvl`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_bp_pricelvl_id` ON `bp` (`pricelvl_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `branch` (`id` INTEGER NOT NULL, `code` TEXT NOT NULL, `name` TEXT NOT NULL, `version` INTEGER NOT NULL, `cmp_name` TEXT NOT NULL, `cmp_phone` TEXT NOT NULL, `active` INTEGER NOT NULL, `cmp_address` TEXT NOT NULL, `cmp_fax` TEXT NOT NULL, `custdeft_id` INTEGER, `created_at` INTEGER NOT NULL, `created_by` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, `updated_by` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `cadj` (`id` INTEGER NOT NULL, `trxdate` INTEGER NOT NULL, `amount` TEXT NOT NULL, `note` TEXT NOT NULL, `inout` INTEGER NOT NULL, `reftype` TEXT NOT NULL, `autogen` TEXT NOT NULL, `cash_id` INTEGER NOT NULL, `user_id` INTEGER NOT NULL, `cashier_id` INTEGER NOT NULL, `isuploaded` INTEGER NOT NULL, `kode_cadj` TEXT NOT NULL, `refno` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `created_by` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, `updated_by` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`cash_id`) REFERENCES `cash`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`user_id`) REFERENCES `user`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`cashier_id`) REFERENCES `cashier`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_cadj_cash_id` ON `cadj` (`cash_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_cadj_user_id` ON `cadj` (`user_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_cadj_cashier_id` ON `cadj` (`cashier_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `cash` (`id` INTEGER, `code` TEXT NOT NULL, `name` TEXT NOT NULL, `balance` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `casha` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `trxdate` TEXT NOT NULL, `amount` TEXT NOT NULL, `note` TEXT NOT NULL, `inout` TEXT NOT NULL, `reftype` TEXT NOT NULL, `refid` INTEGER NOT NULL, `autogen` INTEGER NOT NULL, `cash_id` INTEGER NOT NULL, `user_id` INTEGER NOT NULL, `cashier_id` INTEGER NOT NULL, `isuploaded` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `cashier` (`id` INTEGER NOT NULL, `code` TEXT NOT NULL, `cashier_name` TEXT NOT NULL, `branch_id` INTEGER NOT NULL, `cashbranch_id` INTEGER NOT NULL, `wh_id` INTEGER NOT NULL, `cash_id` INTEGER NOT NULL, `active` INTEGER NOT NULL, `status` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`branch_id`) REFERENCES `branch`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_cashier_branch_id` ON `cashier` (`branch_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `cc_type` (`id` INTEGER, `cctype` TEXT NOT NULL, `cctypedesc` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `channel` (`id` INTEGER NOT NULL, `code` TEXT NOT NULL, `name` TEXT NOT NULL, `active` INTEGER NOT NULL, `ispos` INTEGER NOT NULL, `created_by` INTEGER, `created_at` INTEGER, `updated_by` INTEGER, `updated_at` INTEGER, `color` TEXT, `pricelvl_id` INTEGER, PRIMARY KEY(`id`), FOREIGN KEY(`pricelvl_id`) REFERENCES `price_lvl`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_channel_pricelvl_id` ON `channel` (`pricelvl_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `regency` (`code` TEXT NOT NULL, `name` TEXT NOT NULL, `province_code` TEXT NOT NULL, `active` INTEGER NOT NULL, PRIMARY KEY(`code`), FOREIGN KEY(`province_code`) REFERENCES `province`(`code`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_regency_province_code` ON `regency` (`province_code`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `cstr` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `trxdate` INTEGER NOT NULL, `amount1` TEXT NOT NULL, `amount2` TEXT NOT NULL, `exrate1` TEXT NOT NULL, `exrate2` TEXT NOT NULL, `note` INTEGER NOT NULL, `reftype` TEXT NOT NULL, `refno` TEXT NOT NULL, `autogen` TEXT NOT NULL, `cash_id1` INTEGER NOT NULL, `cash_id2` INTEGER NOT NULL, `isuploaded` INTEGER NOT NULL, `kode_cstr` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `created_by` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, `updated_by` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `edc` (`id` INTEGER NOT NULL, `code` TEXT NOT NULL, `name` TEXT NOT NULL, `cash_id` INTEGER NOT NULL, `note` TEXT NOT NULL, `surcpayto` TEXT, `branch_id` INTEGER, `active` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`branch_id`) REFERENCES `branch`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `edcsurc` (`id` INTEGER NOT NULL, `edcsurcno` TEXT NOT NULL, `edc_id` INTEGER NOT NULL, `cctype` TEXT NOT NULL, `cctypedesc` TEXT NOT NULL, `surcexp` TEXT NOT NULL, `mdrexp` TEXT NOT NULL, `surcacc_id` INTEGER NOT NULL, `mdracc_id` INTEGER NOT NULL, `edcsurctype` TEXT NOT NULL, `active` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`edc_id`) REFERENCES `edc`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_edcsurc_edc_id` ON `edcsurc` (`edc_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `grpprv` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `updated_at` INTEGER NOT NULL, `obj_code` TEXT NOT NULL, `acstype` TEXT NOT NULL, `enabled` INTEGER NOT NULL, `acsval` TEXT, `grp_id` INTEGER NOT NULL, `code` TEXT NOT NULL, `up_code` TEXT NOT NULL, `modul_code` TEXT NOT NULL, `name` TEXT NOT NULL, `mnemonic` TEXT NOT NULL, `level` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `item` (`id` INTEGER NOT NULL, `code` TEXT NOT NULL, `name1` TEXT NOT NULL, `brand_id` INTEGER, `itemtype_code` TEXT NOT NULL, `usepid` INTEGER NOT NULL, `uniquepid` INTEGER NOT NULL, `itemgrp1_id` INTEGER, `isstock` INTEGER NOT NULL, `issale` INTEGER NOT NULL, `unitdesc` TEXT NOT NULL, `note` TEXT, `active` INTEGER NOT NULL, `saleunit` INTEGER, `stockunit` INTEGER, `itemqty` TEXT NOT NULL, `ispos` INTEGER NOT NULL, `type` TEXT NOT NULL, `favorit` INTEGER NOT NULL, `is_available` INTEGER NOT NULL, `is_variant` INTEGER NOT NULL, `vcode` TEXT, `vcolor` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `itemaddon` (`id` INTEGER NOT NULL, `addon` INTEGER NOT NULL, `code` TEXT NOT NULL, `item_id` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`item_id`) REFERENCES `item`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`addon`) REFERENCES `addon`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_itemaddon_addon` ON `itemaddon` (`addon`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_itemaddon_item_id` ON `itemaddon` (`item_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `item_branch` (`id` INTEGER NOT NULL, `branch_id` INTEGER NOT NULL, `item_id` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`branch_id`) REFERENCES `branch`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`item_id`) REFERENCES `item`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_item_branch_branch_id` ON `item_branch` (`branch_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_item_branch_item_id` ON `item_branch` (`item_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `item_kitchen` (`id` INTEGER NOT NULL, `item_id` INTEGER NOT NULL, `kitchen_id` INTEGER NOT NULL, `created_by` INTEGER, `created_at` INTEGER, `updated_by` INTEGER, `updated_at` INTEGER, PRIMARY KEY(`id`), FOREIGN KEY(`item_id`) REFERENCES `item`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`item_id`) REFERENCES `item`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_item_kitchen_item_id` ON `item_kitchen` (`item_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_item_kitchen_kitchen_id` ON `item_kitchen` (`kitchen_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `dummy_item` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `itemtype_code` TEXT NOT NULL, `itemgroup` TEXT NOT NULL, `price` TEXT NOT NULL, `unit` TEXT NOT NULL, `picpath` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `price` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `itemid` INTEGER NOT NULL, `pricelvl_id` INTEGER NOT NULL, `price1` TEXT NOT NULL, `discexp1` TEXT, `crc_id` INTEGER NOT NULL, `crc_symbol` TEXT NOT NULL, FOREIGN KEY(`pricelvl_id`) REFERENCES `price_lvl`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_price_itemid` ON `price` (`itemid`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_price_pricelvl_id` ON `price` (`pricelvl_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `item_tax` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `item_code` TEXT, `tax_code` TEXT, `calcmtd` TEXT NOT NULL, `expr` TEXT NOT NULL, `expr_noreg` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `item_variant` (`id` INTEGER NOT NULL, `variant_id` INTEGER NOT NULL, `item_id` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`variant_id`) REFERENCES `variant`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`item_id`) REFERENCES `item`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_item_variant_variant_id` ON `item_variant` (`variant_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_item_variant_item_id` ON `item_variant` (`item_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `itemgrp` (`id` INTEGER NOT NULL, `code` TEXT NOT NULL, `name` TEXT NOT NULL, `level` INTEGER NOT NULL, `up_id` INTEGER NOT NULL, `ispos` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `kitchen` (`id` INTEGER NOT NULL, `code` TEXT, `name` TEXT NOT NULL, `branch_id` INTEGER NOT NULL, `created_by` INTEGER NOT NULL, `created_at` INTEGER NOT NULL, `updated_by` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, `is_used` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`branch_id`) REFERENCES `branch`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_kitchen_branch_id` ON `kitchen` (`branch_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `license` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `serial_number` TEXT NOT NULL, `item` TEXT NOT NULL, `expdate` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `posses` (`id` INTEGER, `trxdate` INTEGER NOT NULL, `starttime` INTEGER NOT NULL, `endtime` INTEGER, `startbal` TEXT NOT NULL, `endbal` TEXT, `total` TEXT NOT NULL, `credit` TEXT NOT NULL, `shift` INTEGER NOT NULL, `user_id` INTEGER NOT NULL, `cashier_id` INTEGER NOT NULL, `trxno` TEXT NOT NULL, `totin` TEXT, `totout` TEXT, `endcash` TEXT NOT NULL, `totactualcash` TEXT NOT NULL, `totdiffcash` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`user_id`) REFERENCES `user`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`cashier_id`) REFERENCES `cashier`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_posses_user_id` ON `posses` (`user_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_posses_cashier_id` ON `posses` (`cashier_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `price_lvl` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `code` TEXT NOT NULL, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `printer` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `printername` TEXT NOT NULL, `address` TEXT NOT NULL, `tipe` INTEGER NOT NULL, `size` TEXT NOT NULL, `is_receipt` INTEGER NOT NULL, `is_kitchen` INTEGER NOT NULL, `is_report` INTEGER NOT NULL, `is_checker` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `printer_kitchen` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `kitchen_name` TEXT NOT NULL, `printer_id` INTEGER NOT NULL, FOREIGN KEY(`printer_id`) REFERENCES `printer`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_printer_kitchen_printer_id` ON `printer_kitchen` (`printer_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `printer_kitchend` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `printer_kitchen_id` INTEGER NOT NULL, `kitchen_id` INTEGER NOT NULL, FOREIGN KEY(`printer_kitchen_id`) REFERENCES `printer_kitchen`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`kitchen_id`) REFERENCES `kitchen`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_printer_kitchend_printer_kitchen_id` ON `printer_kitchend` (`printer_kitchen_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_printer_kitchend_kitchen_id` ON `printer_kitchend` (`kitchen_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `promo` (`id` INTEGER NOT NULL, `isactive` INTEGER NOT NULL, `isbranch` INTEGER NOT NULL, `branchid` INTEGER, `isperiode` INTEGER NOT NULL, `startdate` TEXT, `enddate` TEXT, `istime` INTEGER NOT NULL, `starttime` TEXT, `endtime` TEXT, `isdow` INTEGER NOT NULL, `dowexp` TEXT, `isbpgrp` INTEGER NOT NULL, `offertype` TEXT NOT NULL, `minamt` TEXT NOT NULL, `istargetitem` INTEGER NOT NULL, `itemid` INTEGER, `istargetitgrp` INTEGER NOT NULL, `itgrpid` INTEGER, `istargetbrand` INTEGER NOT NULL, `brandid` INTEGER, `istargetvendor` INTEGER NOT NULL, `vendorid` INTEGER, `isminqty` INTEGER NOT NULL, `minqty` TEXT, `priority` INTEGER NOT NULL, `isminamt` INTEGER NOT NULL, `note` TEXT NOT NULL, `code` TEXT NOT NULL, `promotype` TEXT NOT NULL, `name` TEXT NOT NULL, `itemdiscexp` TEXT, `promo_cat` TEXT NOT NULL, `ispriceoveride` INTEGER NOT NULL, `deal_itemid` INTEGER, `itemprice` TEXT, `isminqtymultiply` INTEGER NOT NULL, `ismaxqty` INTEGER NOT NULL, `maxqty` TEXT, `isused` INTEGER NOT NULL, `ison` INTEGER NOT NULL, `ismulti` INTEGER NOT NULL, `deal_qty` TEXT, `isdealsameitem` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `promomulti` (`id` INTEGER NOT NULL, `promo_id` INTEGER NOT NULL, `type` TEXT NOT NULL, `value` TEXT NOT NULL, `isreq` INTEGER NOT NULL, `isdeal` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`promo_id`) REFERENCES `promo`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_promomulti_promo_id` ON `promomulti` (`promo_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `reg` (`code` TEXT NOT NULL, `name` TEXT NOT NULL, `value` TEXT NOT NULL, `isvisible` INTEGER NOT NULL, `modul_code` TEXT NOT NULL, `validator` TEXT, PRIMARY KEY(`code`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `sale` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `trx_ordernum` INTEGER NOT NULL, `trx_no` TEXT NOT NULL, `draft` INTEGER NOT NULL, `subtotal` TEXT NOT NULL, `total` TEXT NOT NULL, `opr_name` TEXT NOT NULL, `cashier_name` TEXT NOT NULL, `trx_date` INTEGER NOT NULL, `paidamt` TEXT NOT NULL, `changeamt` TEXT NOT NULL, `taxamt` TEXT NOT NULL, `discamt` TEXT NOT NULL, `posses_id` INTEGER NOT NULL, `kode_posses` TEXT NOT NULL, `discexp` TEXT NOT NULL, `user_id` INTEGER NOT NULL, `cashier_id` INTEGER NOT NULL, `bp_id` INTEGER NOT NULL, `bp_name` TEXT NOT NULL, `termtype` TEXT NOT NULL, `isuploaded` INTEGER NOT NULL, `isvoid` INTEGER NOT NULL, `url_qrcode` TEXT NOT NULL, `transaction_id` TEXT NOT NULL, `gopay_paymentstatus` TEXT NOT NULL, `rounding` TEXT NOT NULL, `channel_id` INTEGER NOT NULL, `void_note` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `created_by` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, `updated_by` INTEGER NOT NULL, `crc_id` INTEGER, FOREIGN KEY(`posses_id`) REFERENCES `posses`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_sale_posses_id` ON `sale` (`posses_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_sale_user_id` ON `sale` (`user_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_sale_cashier_id` ON `sale` (`cashier_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_sale_bp_id` ON `sale` (`bp_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_sale_channel_id` ON `sale` (`channel_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_sale_crc_id` ON `sale` (`crc_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `salecrcvs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `rcvtype_code` TEXT NOT NULL, `sale` INTEGER NOT NULL, `rcvamt` TEXT, `note` TEXT NOT NULL, `edc_id` INTEGER, `cash_id` INTEGER, `card_no` TEXT, `cctype_code` TEXT, `mdrexp` TEXT, `mdramt` TEXT, `surcexp` TEXT, `surcamt` TEXT, `mdracc_id` TEXT, `surcacc_id` TEXT, `ref_id` TEXT, `track_no` TEXT, FOREIGN KEY(`sale`) REFERENCES `sale`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_salecrcvs_sale` ON `salecrcvs` (`sale`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `salepromo` (`id` INTEGER NOT NULL, `sale_id` INTEGER NOT NULL, `saleno` TEXT NOT NULL, `saled_id` INTEGER NOT NULL, `promo_id` INTEGER NOT NULL, `bp_id` INTEGER NOT NULL, `promoqty` TEXT NOT NULL, `promorole` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`sale_id`) REFERENCES `sale`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`saled_id`) REFERENCES `saled`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`promo_id`) REFERENCES `promo`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`bp_id`) REFERENCES `bp`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_salepromo_sale_id` ON `salepromo` (`sale_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_salepromo_saled_id` ON `salepromo` (`saled_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_salepromo_promo_id` ON `salepromo` (`promo_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_salepromo_bp_id` ON `salepromo` (`bp_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `selection` (`id` INTEGER NOT NULL, `code` TEXT NOT NULL, `name` TEXT NOT NULL, `note` TEXT NOT NULL, `isactive` INTEGER NOT NULL, `ismultiselect` INTEGER NOT NULL, `ismultiqty` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `selectiond` (`id` INTEGER, `selection_id` INTEGER NOT NULL, `dno` INTEGER NOT NULL, `item_id` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`selection_id`) REFERENCES `selection`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`item_id`) REFERENCES `item`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_selectiond_selection_id` ON `selectiond` (`selection_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_selectiond_item_id` ON `selectiond` (`item_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `saled` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `item_id` INTEGER NOT NULL, `item_code` TEXT NOT NULL, `name` TEXT NOT NULL, `qty` TEXT NOT NULL, `listprice` TEXT NOT NULL, `disc` TEXT NOT NULL, `tax` TEXT NOT NULL, `discexp` TEXT NOT NULL, `discamt` TEXT NOT NULL, `disc2amt` TEXT NOT NULL, `taxamt` TEXT NOT NULL, `baseprice` TEXT NOT NULL, `taxableamt` TEXT NOT NULL, `subtotal` TEXT NOT NULL, `sale_id` INTEGER NOT NULL, `dno` INTEGER NOT NULL, `totaldiscamt` TEXT NOT NULL, `totaldisc2amt` TEXT NOT NULL, `totaltaxamt` TEXT NOT NULL, `dnote` TEXT NOT NULL, `crc_id` INTEGER, `unit_id` INTEGER, `conv` TEXT, `pid` TEXT, `tax_code` TEXT, FOREIGN KEY(`item_id`) REFERENCES `item`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`sale_id`) REFERENCES `sale`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_saled_item_id` ON `saled` (`item_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_saled_sale_id` ON `saled` (`sale_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `sync` (`id` INTEGER NOT NULL, `trx_no` TEXT NOT NULL, `trxdate` INTEGER NOT NULL, `bp_id` INTEGER NOT NULL, `bp_name` TEXT NOT NULL, `isuploaded` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tax` (`id` INTEGER, `code` TEXT NOT NULL, `name` TEXT NOT NULL, `expr` TEXT NOT NULL, `active` INTEGER NOT NULL, `isdefault` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `username` TEXT NOT NULL, `auth_key` TEXT, `pin` TEXT, `active` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `usrgrp` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `usr_code` TEXT NOT NULL, `disabled` INTEGER NOT NULL, `grp_id` INTEGER NOT NULL, `usr_id` TEXT NOT NULL, `updated_at` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `variant` (`id` INTEGER NOT NULL, `code` TEXT NOT NULL, `name` TEXT NOT NULL, `itgrp_id` INTEGER NOT NULL, `picpath` TEXT NOT NULL, `isfavorit` INTEGER NOT NULL, `isavailable` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`itgrp_id`) REFERENCES `itemgrp`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_variant_itgrp_id` ON `variant` (`itgrp_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `city` (`code` TEXT NOT NULL, `name` TEXT NOT NULL, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`code`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `bpaddr` (`id` INTEGER, `bp_id` INTEGER, `name` TEXT NOT NULL, `greeting` TEXT NOT NULL, `address` TEXT NOT NULL, `phone` TEXT NOT NULL, `zipcode` TEXT NOT NULL, `email` TEXT NOT NULL, `note` TEXT NOT NULL, `isbilladdr` INTEGER NOT NULL, `isshipaddr` INTEGER NOT NULL, `ismainaddr` INTEGER NOT NULL, `province_code` TEXT NOT NULL, `regency_code` TEXT NOT NULL, `city_code` INTEGER NOT NULL, `district_code` TEXT NOT NULL, `created_at` INTEGER, `created_by` INTEGER, `updated_at` INTEGER, `updated_by` INTEGER, PRIMARY KEY(`id`), FOREIGN KEY(`bp_id`) REFERENCES `bp`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_bpaddr_bp_id` ON `bpaddr` (`bp_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_bpaddr_province_code` ON `bpaddr` (`province_code`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_bpaddr_regency_code` ON `bpaddr` (`regency_code`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_bpaddr_city_code` ON `bpaddr` (`city_code`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_bpaddr_district_code` ON `bpaddr` (`district_code`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `province` (`code` TEXT NOT NULL, `name` TEXT NOT NULL, `active` INTEGER NOT NULL, PRIMARY KEY(`code`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `district` (`code` TEXT NOT NULL, `name` TEXT NOT NULL, `regency_code` TEXT NOT NULL, `active` INTEGER NOT NULL, PRIMARY KEY(`code`), FOREIGN KEY(`regency_code`) REFERENCES `regency`(`code`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_district_regency_code` ON `district` (`regency_code`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `pmtd` (`id` INTEGER, `idx` INTEGER, `code` TEXT NOT NULL, `name` TEXT NOT NULL, `cash_id` INTEGER, `mdrexp` TEXT, `mdracc` INTEGER NOT NULL, `surcexp` TEXT, `surcacc` INTEGER NOT NULL, `branch_id` INTEGER, `settledays` INTEGER, `cash_name` TEXT, `branch_name` TEXT, `cctype` TEXT NOT NULL, `edcsurctype` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `unit` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `item_id` INTEGER NOT NULL, `idx` INTEGER NOT NULL, `unit` TEXT NOT NULL, `conv` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `cmp` (`id` INTEGER, `city_code` TEXT NOT NULL, `crc_id` INTEGER NOT NULL, `name` TEXT NOT NULL, `address` TEXT NOT NULL, `phone` TEXT NOT NULL, `fax` TEXT NOT NULL, `zipcode` TEXT NOT NULL, `startdate` TEXT NOT NULL, `fiscalyear` TEXT NOT NULL, `ownername` TEXT, `ownertaxregno` TEXT, `formserno` TEXT NOT NULL, `taxregno` TEXT NOT NULL, `vatregno` TEXT NOT NULL, `cosstype` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `crc` (`id` INTEGER, `code` TEXT NOT NULL, `name` TEXT NOT NULL, `symbol` TEXT NOT NULL, `isdefault` INTEGER NOT NULL, `excrate` TEXT NOT NULL, `fisrate` TEXT NOT NULL, `ratetype` TEXT NOT NULL, `active` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `city_populer` (`id` INTEGER, `name_city` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `stock` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `item_id` INTEGER NOT NULL, `wh_id` INTEGER NOT NULL, `item_code` TEXT NOT NULL, `wh_code` TEXT, `pid` TEXT NOT NULL, `qty` TEXT NOT NULL, `qtyx` TEXT NOT NULL, `active` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `wh` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `code` TEXT NOT NULL, `name` TEXT NOT NULL, `active` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `saleaddon` (`id` INTEGER NOT NULL, `sale_id` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`sale_id`) REFERENCES `sale`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `saleaddond` (`id` INTEGER NOT NULL, `saledaddon_id` INTEGER NOT NULL, `up_saled_id` INTEGER NOT NULL, `saled_id` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`saledaddon_id`) REFERENCES `saleaddon`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`up_saled_id`) REFERENCES `saled`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`saled_id`) REFERENCES `saled`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_saleaddond_saledaddon_id` ON `saleaddond` (`saledaddon_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_saleaddond_up_saled_id` ON `saleaddond` (`up_saled_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_saleaddond_saled_id` ON `saleaddond` (`saled_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `item_dummy` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT NOT NULL, `itemtype_code` TEXT NOT NULL, `itemgroup` TEXT NOT NULL, `price` TEXT NOT NULL, `unit` TEXT NOT NULL, `picpath` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `unit_dummy` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `item_id` INTEGER NOT NULL, `idx` INTEGER NOT NULL, `unit` TEXT NOT NULL, `conv` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '73e8532c21a8d469c4d1d43d89a9c783')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `addon`");
        _db.execSQL("DROP TABLE IF EXISTS `addond`");
        _db.execSQL("DROP TABLE IF EXISTS `bp`");
        _db.execSQL("DROP TABLE IF EXISTS `branch`");
        _db.execSQL("DROP TABLE IF EXISTS `cadj`");
        _db.execSQL("DROP TABLE IF EXISTS `cash`");
        _db.execSQL("DROP TABLE IF EXISTS `casha`");
        _db.execSQL("DROP TABLE IF EXISTS `cashier`");
        _db.execSQL("DROP TABLE IF EXISTS `cc_type`");
        _db.execSQL("DROP TABLE IF EXISTS `channel`");
        _db.execSQL("DROP TABLE IF EXISTS `regency`");
        _db.execSQL("DROP TABLE IF EXISTS `cstr`");
        _db.execSQL("DROP TABLE IF EXISTS `edc`");
        _db.execSQL("DROP TABLE IF EXISTS `edcsurc`");
        _db.execSQL("DROP TABLE IF EXISTS `grpprv`");
        _db.execSQL("DROP TABLE IF EXISTS `item`");
        _db.execSQL("DROP TABLE IF EXISTS `itemaddon`");
        _db.execSQL("DROP TABLE IF EXISTS `item_branch`");
        _db.execSQL("DROP TABLE IF EXISTS `item_kitchen`");
        _db.execSQL("DROP TABLE IF EXISTS `dummy_item`");
        _db.execSQL("DROP TABLE IF EXISTS `price`");
        _db.execSQL("DROP TABLE IF EXISTS `item_tax`");
        _db.execSQL("DROP TABLE IF EXISTS `item_variant`");
        _db.execSQL("DROP TABLE IF EXISTS `itemgrp`");
        _db.execSQL("DROP TABLE IF EXISTS `kitchen`");
        _db.execSQL("DROP TABLE IF EXISTS `license`");
        _db.execSQL("DROP TABLE IF EXISTS `posses`");
        _db.execSQL("DROP TABLE IF EXISTS `price_lvl`");
        _db.execSQL("DROP TABLE IF EXISTS `printer`");
        _db.execSQL("DROP TABLE IF EXISTS `printer_kitchen`");
        _db.execSQL("DROP TABLE IF EXISTS `printer_kitchend`");
        _db.execSQL("DROP TABLE IF EXISTS `promo`");
        _db.execSQL("DROP TABLE IF EXISTS `promomulti`");
        _db.execSQL("DROP TABLE IF EXISTS `reg`");
        _db.execSQL("DROP TABLE IF EXISTS `sale`");
        _db.execSQL("DROP TABLE IF EXISTS `salecrcvs`");
        _db.execSQL("DROP TABLE IF EXISTS `salepromo`");
        _db.execSQL("DROP TABLE IF EXISTS `selection`");
        _db.execSQL("DROP TABLE IF EXISTS `selectiond`");
        _db.execSQL("DROP TABLE IF EXISTS `saled`");
        _db.execSQL("DROP TABLE IF EXISTS `sync`");
        _db.execSQL("DROP TABLE IF EXISTS `tax`");
        _db.execSQL("DROP TABLE IF EXISTS `user`");
        _db.execSQL("DROP TABLE IF EXISTS `usrgrp`");
        _db.execSQL("DROP TABLE IF EXISTS `variant`");
        _db.execSQL("DROP TABLE IF EXISTS `city`");
        _db.execSQL("DROP TABLE IF EXISTS `bpaddr`");
        _db.execSQL("DROP TABLE IF EXISTS `province`");
        _db.execSQL("DROP TABLE IF EXISTS `district`");
        _db.execSQL("DROP TABLE IF EXISTS `pmtd`");
        _db.execSQL("DROP TABLE IF EXISTS `unit`");
        _db.execSQL("DROP TABLE IF EXISTS `cmp`");
        _db.execSQL("DROP TABLE IF EXISTS `crc`");
        _db.execSQL("DROP TABLE IF EXISTS `city_populer`");
        _db.execSQL("DROP TABLE IF EXISTS `stock`");
        _db.execSQL("DROP TABLE IF EXISTS `wh`");
        _db.execSQL("DROP TABLE IF EXISTS `saleaddon`");
        _db.execSQL("DROP TABLE IF EXISTS `saleaddond`");
        _db.execSQL("DROP TABLE IF EXISTS `item_dummy`");
        _db.execSQL("DROP TABLE IF EXISTS `unit_dummy`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAddon = new HashMap<String, TableInfo.Column>(5);
        _columnsAddon.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddon.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddon.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddon.put("is_active", new TableInfo.Column("is_active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddon.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddon = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddon = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddon = new TableInfo("addon", _columnsAddon, _foreignKeysAddon, _indicesAddon);
        final TableInfo _existingAddon = TableInfo.read(_db, "addon");
        if (! _infoAddon.equals(_existingAddon)) {
          return new RoomOpenHelper.ValidationResult(false, "addon(com.bits.bee.bpmc.data.data_source.local.model.AddOnEntity).\n"
                  + " Expected:\n" + _infoAddon + "\n"
                  + " Found:\n" + _existingAddon);
        }
        final HashMap<String, TableInfo.Column> _columnsAddond = new HashMap<String, TableInfo.Column>(6);
        _columnsAddond.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddond.put("addon_id", new TableInfo.Column("addon_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddond.put("selection_id", new TableInfo.Column("selection_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddond.put("idx", new TableInfo.Column("idx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddond.put("addond", new TableInfo.Column("addond", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddond.put("isskip", new TableInfo.Column("isskip", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddond = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysAddond.add(new TableInfo.ForeignKey("addon", "CASCADE", "NO ACTION",Arrays.asList("addon_id"), Arrays.asList("id")));
        _foreignKeysAddond.add(new TableInfo.ForeignKey("selection", "CASCADE", "NO ACTION",Arrays.asList("selection_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesAddond = new HashSet<TableInfo.Index>(2);
        _indicesAddond.add(new TableInfo.Index("index_addond_addon_id", false, Arrays.asList("addon_id"), Arrays.asList("ASC")));
        _indicesAddond.add(new TableInfo.Index("index_addond_selection_id", false, Arrays.asList("selection_id"), Arrays.asList("ASC")));
        final TableInfo _infoAddond = new TableInfo("addond", _columnsAddond, _foreignKeysAddond, _indicesAddond);
        final TableInfo _existingAddond = TableInfo.read(_db, "addond");
        if (! _infoAddond.equals(_existingAddond)) {
          return new RoomOpenHelper.ValidationResult(false, "addond(com.bits.bee.bpmc.data.data_source.local.model.AddOnDEntity).\n"
                  + " Expected:\n" + _infoAddond + "\n"
                  + " Found:\n" + _existingAddond);
        }
        final HashMap<String, TableInfo.Column> _columnsBp = new HashMap<String, TableInfo.Column>(16);
        _columnsBp.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("greeting", new TableInfo.Column("greeting", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("anniversary", new TableInfo.Column("anniversary", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("taxedonsale", new TableInfo.Column("taxedonsale", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("taxinconsale", new TableInfo.Column("taxinconsale", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("note", new TableInfo.Column("note", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("bpgrp1_id", new TableInfo.Column("bpgrp1_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("pricelvl_id", new TableInfo.Column("pricelvl_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("created_by", new TableInfo.Column("created_by", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("updated_by", new TableInfo.Column("updated_by", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBp.put("isfavorit", new TableInfo.Column("isfavorit", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBp = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysBp.add(new TableInfo.ForeignKey("price_lvl", "NO ACTION", "NO ACTION",Arrays.asList("pricelvl_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesBp = new HashSet<TableInfo.Index>(1);
        _indicesBp.add(new TableInfo.Index("index_bp_pricelvl_id", false, Arrays.asList("pricelvl_id"), Arrays.asList("ASC")));
        final TableInfo _infoBp = new TableInfo("bp", _columnsBp, _foreignKeysBp, _indicesBp);
        final TableInfo _existingBp = TableInfo.read(_db, "bp");
        if (! _infoBp.equals(_existingBp)) {
          return new RoomOpenHelper.ValidationResult(false, "bp(com.bits.bee.bpmc.data.data_source.local.model.BpEntity).\n"
                  + " Expected:\n" + _infoBp + "\n"
                  + " Found:\n" + _existingBp);
        }
        final HashMap<String, TableInfo.Column> _columnsBranch = new HashMap<String, TableInfo.Column>(14);
        _columnsBranch.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranch.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranch.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranch.put("version", new TableInfo.Column("version", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranch.put("cmp_name", new TableInfo.Column("cmp_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranch.put("cmp_phone", new TableInfo.Column("cmp_phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranch.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranch.put("cmp_address", new TableInfo.Column("cmp_address", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranch.put("cmp_fax", new TableInfo.Column("cmp_fax", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranch.put("custdeft_id", new TableInfo.Column("custdeft_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranch.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranch.put("created_by", new TableInfo.Column("created_by", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranch.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranch.put("updated_by", new TableInfo.Column("updated_by", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBranch = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBranch = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBranch = new TableInfo("branch", _columnsBranch, _foreignKeysBranch, _indicesBranch);
        final TableInfo _existingBranch = TableInfo.read(_db, "branch");
        if (! _infoBranch.equals(_existingBranch)) {
          return new RoomOpenHelper.ValidationResult(false, "branch(com.bits.bee.bpmc.data.data_source.local.model.BranchEntity).\n"
                  + " Expected:\n" + _infoBranch + "\n"
                  + " Found:\n" + _existingBranch);
        }
        final HashMap<String, TableInfo.Column> _columnsCadj = new HashMap<String, TableInfo.Column>(17);
        _columnsCadj.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("trxdate", new TableInfo.Column("trxdate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("amount", new TableInfo.Column("amount", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("note", new TableInfo.Column("note", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("inout", new TableInfo.Column("inout", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("reftype", new TableInfo.Column("reftype", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("autogen", new TableInfo.Column("autogen", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("cash_id", new TableInfo.Column("cash_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("cashier_id", new TableInfo.Column("cashier_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("isuploaded", new TableInfo.Column("isuploaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("kode_cadj", new TableInfo.Column("kode_cadj", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("refno", new TableInfo.Column("refno", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("created_by", new TableInfo.Column("created_by", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCadj.put("updated_by", new TableInfo.Column("updated_by", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCadj = new HashSet<TableInfo.ForeignKey>(3);
        _foreignKeysCadj.add(new TableInfo.ForeignKey("cash", "CASCADE", "NO ACTION",Arrays.asList("cash_id"), Arrays.asList("id")));
        _foreignKeysCadj.add(new TableInfo.ForeignKey("user", "CASCADE", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysCadj.add(new TableInfo.ForeignKey("cashier", "NO ACTION", "NO ACTION",Arrays.asList("cashier_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesCadj = new HashSet<TableInfo.Index>(3);
        _indicesCadj.add(new TableInfo.Index("index_cadj_cash_id", false, Arrays.asList("cash_id"), Arrays.asList("ASC")));
        _indicesCadj.add(new TableInfo.Index("index_cadj_user_id", false, Arrays.asList("user_id"), Arrays.asList("ASC")));
        _indicesCadj.add(new TableInfo.Index("index_cadj_cashier_id", false, Arrays.asList("cashier_id"), Arrays.asList("ASC")));
        final TableInfo _infoCadj = new TableInfo("cadj", _columnsCadj, _foreignKeysCadj, _indicesCadj);
        final TableInfo _existingCadj = TableInfo.read(_db, "cadj");
        if (! _infoCadj.equals(_existingCadj)) {
          return new RoomOpenHelper.ValidationResult(false, "cadj(com.bits.bee.bpmc.data.data_source.local.model.CadjEntity).\n"
                  + " Expected:\n" + _infoCadj + "\n"
                  + " Found:\n" + _existingCadj);
        }
        final HashMap<String, TableInfo.Column> _columnsCash = new HashMap<String, TableInfo.Column>(4);
        _columnsCash.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCash.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCash.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCash.put("balance", new TableInfo.Column("balance", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCash = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCash = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCash = new TableInfo("cash", _columnsCash, _foreignKeysCash, _indicesCash);
        final TableInfo _existingCash = TableInfo.read(_db, "cash");
        if (! _infoCash.equals(_existingCash)) {
          return new RoomOpenHelper.ValidationResult(false, "cash(com.bits.bee.bpmc.data.data_source.local.model.CashEntity).\n"
                  + " Expected:\n" + _infoCash + "\n"
                  + " Found:\n" + _existingCash);
        }
        final HashMap<String, TableInfo.Column> _columnsCasha = new HashMap<String, TableInfo.Column>(12);
        _columnsCasha.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCasha.put("trxdate", new TableInfo.Column("trxdate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCasha.put("amount", new TableInfo.Column("amount", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCasha.put("note", new TableInfo.Column("note", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCasha.put("inout", new TableInfo.Column("inout", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCasha.put("reftype", new TableInfo.Column("reftype", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCasha.put("refid", new TableInfo.Column("refid", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCasha.put("autogen", new TableInfo.Column("autogen", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCasha.put("cash_id", new TableInfo.Column("cash_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCasha.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCasha.put("cashier_id", new TableInfo.Column("cashier_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCasha.put("isuploaded", new TableInfo.Column("isuploaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCasha = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCasha = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCasha = new TableInfo("casha", _columnsCasha, _foreignKeysCasha, _indicesCasha);
        final TableInfo _existingCasha = TableInfo.read(_db, "casha");
        if (! _infoCasha.equals(_existingCasha)) {
          return new RoomOpenHelper.ValidationResult(false, "casha(com.bits.bee.bpmc.data.data_source.local.model.CashAEntity).\n"
                  + " Expected:\n" + _infoCasha + "\n"
                  + " Found:\n" + _existingCasha);
        }
        final HashMap<String, TableInfo.Column> _columnsCashier = new HashMap<String, TableInfo.Column>(9);
        _columnsCashier.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashier.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashier.put("cashier_name", new TableInfo.Column("cashier_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashier.put("branch_id", new TableInfo.Column("branch_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashier.put("cashbranch_id", new TableInfo.Column("cashbranch_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashier.put("wh_id", new TableInfo.Column("wh_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashier.put("cash_id", new TableInfo.Column("cash_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashier.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashier.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCashier = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysCashier.add(new TableInfo.ForeignKey("branch", "CASCADE", "NO ACTION",Arrays.asList("branch_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesCashier = new HashSet<TableInfo.Index>(1);
        _indicesCashier.add(new TableInfo.Index("index_cashier_branch_id", false, Arrays.asList("branch_id"), Arrays.asList("ASC")));
        final TableInfo _infoCashier = new TableInfo("cashier", _columnsCashier, _foreignKeysCashier, _indicesCashier);
        final TableInfo _existingCashier = TableInfo.read(_db, "cashier");
        if (! _infoCashier.equals(_existingCashier)) {
          return new RoomOpenHelper.ValidationResult(false, "cashier(com.bits.bee.bpmc.data.data_source.local.model.CashierEntity).\n"
                  + " Expected:\n" + _infoCashier + "\n"
                  + " Found:\n" + _existingCashier);
        }
        final HashMap<String, TableInfo.Column> _columnsCcType = new HashMap<String, TableInfo.Column>(3);
        _columnsCcType.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCcType.put("cctype", new TableInfo.Column("cctype", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCcType.put("cctypedesc", new TableInfo.Column("cctypedesc", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCcType = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCcType = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCcType = new TableInfo("cc_type", _columnsCcType, _foreignKeysCcType, _indicesCcType);
        final TableInfo _existingCcType = TableInfo.read(_db, "cc_type");
        if (! _infoCcType.equals(_existingCcType)) {
          return new RoomOpenHelper.ValidationResult(false, "cc_type(com.bits.bee.bpmc.data.data_source.local.model.CcTypeEntity).\n"
                  + " Expected:\n" + _infoCcType + "\n"
                  + " Found:\n" + _existingCcType);
        }
        final HashMap<String, TableInfo.Column> _columnsChannel = new HashMap<String, TableInfo.Column>(11);
        _columnsChannel.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChannel.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChannel.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChannel.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChannel.put("ispos", new TableInfo.Column("ispos", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChannel.put("created_by", new TableInfo.Column("created_by", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChannel.put("created_at", new TableInfo.Column("created_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChannel.put("updated_by", new TableInfo.Column("updated_by", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChannel.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChannel.put("color", new TableInfo.Column("color", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChannel.put("pricelvl_id", new TableInfo.Column("pricelvl_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChannel = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysChannel.add(new TableInfo.ForeignKey("price_lvl", "NO ACTION", "NO ACTION",Arrays.asList("pricelvl_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesChannel = new HashSet<TableInfo.Index>(1);
        _indicesChannel.add(new TableInfo.Index("index_channel_pricelvl_id", false, Arrays.asList("pricelvl_id"), Arrays.asList("ASC")));
        final TableInfo _infoChannel = new TableInfo("channel", _columnsChannel, _foreignKeysChannel, _indicesChannel);
        final TableInfo _existingChannel = TableInfo.read(_db, "channel");
        if (! _infoChannel.equals(_existingChannel)) {
          return new RoomOpenHelper.ValidationResult(false, "channel(com.bits.bee.bpmc.data.data_source.local.model.ChannelEntity).\n"
                  + " Expected:\n" + _infoChannel + "\n"
                  + " Found:\n" + _existingChannel);
        }
        final HashMap<String, TableInfo.Column> _columnsRegency = new HashMap<String, TableInfo.Column>(4);
        _columnsRegency.put("code", new TableInfo.Column("code", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRegency.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRegency.put("province_code", new TableInfo.Column("province_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRegency.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRegency = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysRegency.add(new TableInfo.ForeignKey("province", "CASCADE", "NO ACTION",Arrays.asList("province_code"), Arrays.asList("code")));
        final HashSet<TableInfo.Index> _indicesRegency = new HashSet<TableInfo.Index>(1);
        _indicesRegency.add(new TableInfo.Index("index_regency_province_code", false, Arrays.asList("province_code"), Arrays.asList("ASC")));
        final TableInfo _infoRegency = new TableInfo("regency", _columnsRegency, _foreignKeysRegency, _indicesRegency);
        final TableInfo _existingRegency = TableInfo.read(_db, "regency");
        if (! _infoRegency.equals(_existingRegency)) {
          return new RoomOpenHelper.ValidationResult(false, "regency(com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity).\n"
                  + " Expected:\n" + _infoRegency + "\n"
                  + " Found:\n" + _existingRegency);
        }
        final HashMap<String, TableInfo.Column> _columnsCstr = new HashMap<String, TableInfo.Column>(18);
        _columnsCstr.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("trxdate", new TableInfo.Column("trxdate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("amount1", new TableInfo.Column("amount1", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("amount2", new TableInfo.Column("amount2", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("exrate1", new TableInfo.Column("exrate1", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("exrate2", new TableInfo.Column("exrate2", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("note", new TableInfo.Column("note", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("reftype", new TableInfo.Column("reftype", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("refno", new TableInfo.Column("refno", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("autogen", new TableInfo.Column("autogen", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("cash_id1", new TableInfo.Column("cash_id1", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("cash_id2", new TableInfo.Column("cash_id2", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("isuploaded", new TableInfo.Column("isuploaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("kode_cstr", new TableInfo.Column("kode_cstr", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("created_by", new TableInfo.Column("created_by", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCstr.put("updated_by", new TableInfo.Column("updated_by", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCstr = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCstr = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCstr = new TableInfo("cstr", _columnsCstr, _foreignKeysCstr, _indicesCstr);
        final TableInfo _existingCstr = TableInfo.read(_db, "cstr");
        if (! _infoCstr.equals(_existingCstr)) {
          return new RoomOpenHelper.ValidationResult(false, "cstr(com.bits.bee.bpmc.data.data_source.local.model.CstrEntity).\n"
                  + " Expected:\n" + _infoCstr + "\n"
                  + " Found:\n" + _existingCstr);
        }
        final HashMap<String, TableInfo.Column> _columnsEdc = new HashMap<String, TableInfo.Column>(8);
        _columnsEdc.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdc.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdc.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdc.put("cash_id", new TableInfo.Column("cash_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdc.put("note", new TableInfo.Column("note", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdc.put("surcpayto", new TableInfo.Column("surcpayto", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdc.put("branch_id", new TableInfo.Column("branch_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdc.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEdc = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysEdc.add(new TableInfo.ForeignKey("branch", "CASCADE", "NO ACTION",Arrays.asList("branch_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesEdc = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEdc = new TableInfo("edc", _columnsEdc, _foreignKeysEdc, _indicesEdc);
        final TableInfo _existingEdc = TableInfo.read(_db, "edc");
        if (! _infoEdc.equals(_existingEdc)) {
          return new RoomOpenHelper.ValidationResult(false, "edc(com.bits.bee.bpmc.data.data_source.local.model.EdcEntity).\n"
                  + " Expected:\n" + _infoEdc + "\n"
                  + " Found:\n" + _existingEdc);
        }
        final HashMap<String, TableInfo.Column> _columnsEdcsurc = new HashMap<String, TableInfo.Column>(11);
        _columnsEdcsurc.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdcsurc.put("edcsurcno", new TableInfo.Column("edcsurcno", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdcsurc.put("edc_id", new TableInfo.Column("edc_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdcsurc.put("cctype", new TableInfo.Column("cctype", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdcsurc.put("cctypedesc", new TableInfo.Column("cctypedesc", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdcsurc.put("surcexp", new TableInfo.Column("surcexp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdcsurc.put("mdrexp", new TableInfo.Column("mdrexp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdcsurc.put("surcacc_id", new TableInfo.Column("surcacc_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdcsurc.put("mdracc_id", new TableInfo.Column("mdracc_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdcsurc.put("edcsurctype", new TableInfo.Column("edcsurctype", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdcsurc.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEdcsurc = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysEdcsurc.add(new TableInfo.ForeignKey("edc", "CASCADE", "NO ACTION",Arrays.asList("edc_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesEdcsurc = new HashSet<TableInfo.Index>(1);
        _indicesEdcsurc.add(new TableInfo.Index("index_edcsurc_edc_id", false, Arrays.asList("edc_id"), Arrays.asList("ASC")));
        final TableInfo _infoEdcsurc = new TableInfo("edcsurc", _columnsEdcsurc, _foreignKeysEdcsurc, _indicesEdcsurc);
        final TableInfo _existingEdcsurc = TableInfo.read(_db, "edcsurc");
        if (! _infoEdcsurc.equals(_existingEdcsurc)) {
          return new RoomOpenHelper.ValidationResult(false, "edcsurc(com.bits.bee.bpmc.data.data_source.local.model.EdcSurcEntity).\n"
                  + " Expected:\n" + _infoEdcsurc + "\n"
                  + " Found:\n" + _existingEdcsurc);
        }
        final HashMap<String, TableInfo.Column> _columnsGrpprv = new HashMap<String, TableInfo.Column>(13);
        _columnsGrpprv.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGrpprv.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGrpprv.put("obj_code", new TableInfo.Column("obj_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGrpprv.put("acstype", new TableInfo.Column("acstype", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGrpprv.put("enabled", new TableInfo.Column("enabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGrpprv.put("acsval", new TableInfo.Column("acsval", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGrpprv.put("grp_id", new TableInfo.Column("grp_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGrpprv.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGrpprv.put("up_code", new TableInfo.Column("up_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGrpprv.put("modul_code", new TableInfo.Column("modul_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGrpprv.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGrpprv.put("mnemonic", new TableInfo.Column("mnemonic", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGrpprv.put("level", new TableInfo.Column("level", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGrpprv = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGrpprv = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGrpprv = new TableInfo("grpprv", _columnsGrpprv, _foreignKeysGrpprv, _indicesGrpprv);
        final TableInfo _existingGrpprv = TableInfo.read(_db, "grpprv");
        if (! _infoGrpprv.equals(_existingGrpprv)) {
          return new RoomOpenHelper.ValidationResult(false, "grpprv(com.bits.bee.bpmc.data.data_source.local.model.GrpPrvEntity).\n"
                  + " Expected:\n" + _infoGrpprv + "\n"
                  + " Found:\n" + _existingGrpprv);
        }
        final HashMap<String, TableInfo.Column> _columnsItem = new HashMap<String, TableInfo.Column>(23);
        _columnsItem.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("name1", new TableInfo.Column("name1", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("brand_id", new TableInfo.Column("brand_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("itemtype_code", new TableInfo.Column("itemtype_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("usepid", new TableInfo.Column("usepid", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("uniquepid", new TableInfo.Column("uniquepid", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("itemgrp1_id", new TableInfo.Column("itemgrp1_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("isstock", new TableInfo.Column("isstock", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("issale", new TableInfo.Column("issale", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("unitdesc", new TableInfo.Column("unitdesc", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("note", new TableInfo.Column("note", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("saleunit", new TableInfo.Column("saleunit", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("stockunit", new TableInfo.Column("stockunit", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("itemqty", new TableInfo.Column("itemqty", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("ispos", new TableInfo.Column("ispos", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("favorit", new TableInfo.Column("favorit", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("is_available", new TableInfo.Column("is_available", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("is_variant", new TableInfo.Column("is_variant", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("vcode", new TableInfo.Column("vcode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("vcolor", new TableInfo.Column("vcolor", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItem = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesItem = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoItem = new TableInfo("item", _columnsItem, _foreignKeysItem, _indicesItem);
        final TableInfo _existingItem = TableInfo.read(_db, "item");
        if (! _infoItem.equals(_existingItem)) {
          return new RoomOpenHelper.ValidationResult(false, "item(com.bits.bee.bpmc.data.data_source.local.model.ItemEntity).\n"
                  + " Expected:\n" + _infoItem + "\n"
                  + " Found:\n" + _existingItem);
        }
        final HashMap<String, TableInfo.Column> _columnsItemaddon = new HashMap<String, TableInfo.Column>(4);
        _columnsItemaddon.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemaddon.put("addon", new TableInfo.Column("addon", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemaddon.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemaddon.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItemaddon = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysItemaddon.add(new TableInfo.ForeignKey("item", "NO ACTION", "NO ACTION",Arrays.asList("item_id"), Arrays.asList("id")));
        _foreignKeysItemaddon.add(new TableInfo.ForeignKey("addon", "NO ACTION", "NO ACTION",Arrays.asList("addon"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesItemaddon = new HashSet<TableInfo.Index>(2);
        _indicesItemaddon.add(new TableInfo.Index("index_itemaddon_addon", false, Arrays.asList("addon"), Arrays.asList("ASC")));
        _indicesItemaddon.add(new TableInfo.Index("index_itemaddon_item_id", false, Arrays.asList("item_id"), Arrays.asList("ASC")));
        final TableInfo _infoItemaddon = new TableInfo("itemaddon", _columnsItemaddon, _foreignKeysItemaddon, _indicesItemaddon);
        final TableInfo _existingItemaddon = TableInfo.read(_db, "itemaddon");
        if (! _infoItemaddon.equals(_existingItemaddon)) {
          return new RoomOpenHelper.ValidationResult(false, "itemaddon(com.bits.bee.bpmc.data.data_source.local.model.ItemAddOnEntity).\n"
                  + " Expected:\n" + _infoItemaddon + "\n"
                  + " Found:\n" + _existingItemaddon);
        }
        final HashMap<String, TableInfo.Column> _columnsItemBranch = new HashMap<String, TableInfo.Column>(3);
        _columnsItemBranch.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemBranch.put("branch_id", new TableInfo.Column("branch_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemBranch.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItemBranch = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysItemBranch.add(new TableInfo.ForeignKey("branch", "CASCADE", "NO ACTION",Arrays.asList("branch_id"), Arrays.asList("id")));
        _foreignKeysItemBranch.add(new TableInfo.ForeignKey("item", "CASCADE", "NO ACTION",Arrays.asList("item_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesItemBranch = new HashSet<TableInfo.Index>(2);
        _indicesItemBranch.add(new TableInfo.Index("index_item_branch_branch_id", false, Arrays.asList("branch_id"), Arrays.asList("ASC")));
        _indicesItemBranch.add(new TableInfo.Index("index_item_branch_item_id", false, Arrays.asList("item_id"), Arrays.asList("ASC")));
        final TableInfo _infoItemBranch = new TableInfo("item_branch", _columnsItemBranch, _foreignKeysItemBranch, _indicesItemBranch);
        final TableInfo _existingItemBranch = TableInfo.read(_db, "item_branch");
        if (! _infoItemBranch.equals(_existingItemBranch)) {
          return new RoomOpenHelper.ValidationResult(false, "item_branch(com.bits.bee.bpmc.data.data_source.local.model.ItemBranchEntity).\n"
                  + " Expected:\n" + _infoItemBranch + "\n"
                  + " Found:\n" + _existingItemBranch);
        }
        final HashMap<String, TableInfo.Column> _columnsItemKitchen = new HashMap<String, TableInfo.Column>(7);
        _columnsItemKitchen.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemKitchen.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemKitchen.put("kitchen_id", new TableInfo.Column("kitchen_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemKitchen.put("created_by", new TableInfo.Column("created_by", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemKitchen.put("created_at", new TableInfo.Column("created_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemKitchen.put("updated_by", new TableInfo.Column("updated_by", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemKitchen.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItemKitchen = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysItemKitchen.add(new TableInfo.ForeignKey("item", "CASCADE", "NO ACTION",Arrays.asList("item_id"), Arrays.asList("id")));
        _foreignKeysItemKitchen.add(new TableInfo.ForeignKey("item", "CASCADE", "NO ACTION",Arrays.asList("item_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesItemKitchen = new HashSet<TableInfo.Index>(2);
        _indicesItemKitchen.add(new TableInfo.Index("index_item_kitchen_item_id", false, Arrays.asList("item_id"), Arrays.asList("ASC")));
        _indicesItemKitchen.add(new TableInfo.Index("index_item_kitchen_kitchen_id", false, Arrays.asList("kitchen_id"), Arrays.asList("ASC")));
        final TableInfo _infoItemKitchen = new TableInfo("item_kitchen", _columnsItemKitchen, _foreignKeysItemKitchen, _indicesItemKitchen);
        final TableInfo _existingItemKitchen = TableInfo.read(_db, "item_kitchen");
        if (! _infoItemKitchen.equals(_existingItemKitchen)) {
          return new RoomOpenHelper.ValidationResult(false, "item_kitchen(com.bits.bee.bpmc.data.data_source.local.model.ItemKitchenEntity).\n"
                  + " Expected:\n" + _infoItemKitchen + "\n"
                  + " Found:\n" + _existingItemKitchen);
        }
        final HashMap<String, TableInfo.Column> _columnsDummyItem = new HashMap<String, TableInfo.Column>(7);
        _columnsDummyItem.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDummyItem.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDummyItem.put("itemtype_code", new TableInfo.Column("itemtype_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDummyItem.put("itemgroup", new TableInfo.Column("itemgroup", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDummyItem.put("price", new TableInfo.Column("price", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDummyItem.put("unit", new TableInfo.Column("unit", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDummyItem.put("picpath", new TableInfo.Column("picpath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDummyItem = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDummyItem = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDummyItem = new TableInfo("dummy_item", _columnsDummyItem, _foreignKeysDummyItem, _indicesDummyItem);
        final TableInfo _existingDummyItem = TableInfo.read(_db, "dummy_item");
        if (! _infoDummyItem.equals(_existingDummyItem)) {
          return new RoomOpenHelper.ValidationResult(false, "dummy_item(com.bits.bee.bpmc.data.data_source.local.model.ItemOnBoardingEntity).\n"
                  + " Expected:\n" + _infoDummyItem + "\n"
                  + " Found:\n" + _existingDummyItem);
        }
        final HashMap<String, TableInfo.Column> _columnsPrice = new HashMap<String, TableInfo.Column>(7);
        _columnsPrice.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrice.put("itemid", new TableInfo.Column("itemid", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrice.put("pricelvl_id", new TableInfo.Column("pricelvl_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrice.put("price1", new TableInfo.Column("price1", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrice.put("discexp1", new TableInfo.Column("discexp1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrice.put("crc_id", new TableInfo.Column("crc_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrice.put("crc_symbol", new TableInfo.Column("crc_symbol", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPrice = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysPrice.add(new TableInfo.ForeignKey("price_lvl", "NO ACTION", "NO ACTION",Arrays.asList("pricelvl_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPrice = new HashSet<TableInfo.Index>(2);
        _indicesPrice.add(new TableInfo.Index("index_price_itemid", false, Arrays.asList("itemid"), Arrays.asList("ASC")));
        _indicesPrice.add(new TableInfo.Index("index_price_pricelvl_id", false, Arrays.asList("pricelvl_id"), Arrays.asList("ASC")));
        final TableInfo _infoPrice = new TableInfo("price", _columnsPrice, _foreignKeysPrice, _indicesPrice);
        final TableInfo _existingPrice = TableInfo.read(_db, "price");
        if (! _infoPrice.equals(_existingPrice)) {
          return new RoomOpenHelper.ValidationResult(false, "price(com.bits.bee.bpmc.data.data_source.local.model.PriceEntity).\n"
                  + " Expected:\n" + _infoPrice + "\n"
                  + " Found:\n" + _existingPrice);
        }
        final HashMap<String, TableInfo.Column> _columnsItemTax = new HashMap<String, TableInfo.Column>(6);
        _columnsItemTax.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemTax.put("item_code", new TableInfo.Column("item_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemTax.put("tax_code", new TableInfo.Column("tax_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemTax.put("calcmtd", new TableInfo.Column("calcmtd", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemTax.put("expr", new TableInfo.Column("expr", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemTax.put("expr_noreg", new TableInfo.Column("expr_noreg", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItemTax = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesItemTax = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoItemTax = new TableInfo("item_tax", _columnsItemTax, _foreignKeysItemTax, _indicesItemTax);
        final TableInfo _existingItemTax = TableInfo.read(_db, "item_tax");
        if (! _infoItemTax.equals(_existingItemTax)) {
          return new RoomOpenHelper.ValidationResult(false, "item_tax(com.bits.bee.bpmc.data.data_source.local.model.ItemSaleTaxEntity).\n"
                  + " Expected:\n" + _infoItemTax + "\n"
                  + " Found:\n" + _existingItemTax);
        }
        final HashMap<String, TableInfo.Column> _columnsItemVariant = new HashMap<String, TableInfo.Column>(3);
        _columnsItemVariant.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemVariant.put("variant_id", new TableInfo.Column("variant_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemVariant.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItemVariant = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysItemVariant.add(new TableInfo.ForeignKey("variant", "CASCADE", "NO ACTION",Arrays.asList("variant_id"), Arrays.asList("id")));
        _foreignKeysItemVariant.add(new TableInfo.ForeignKey("item", "CASCADE", "NO ACTION",Arrays.asList("item_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesItemVariant = new HashSet<TableInfo.Index>(2);
        _indicesItemVariant.add(new TableInfo.Index("index_item_variant_variant_id", false, Arrays.asList("variant_id"), Arrays.asList("ASC")));
        _indicesItemVariant.add(new TableInfo.Index("index_item_variant_item_id", false, Arrays.asList("item_id"), Arrays.asList("ASC")));
        final TableInfo _infoItemVariant = new TableInfo("item_variant", _columnsItemVariant, _foreignKeysItemVariant, _indicesItemVariant);
        final TableInfo _existingItemVariant = TableInfo.read(_db, "item_variant");
        if (! _infoItemVariant.equals(_existingItemVariant)) {
          return new RoomOpenHelper.ValidationResult(false, "item_variant(com.bits.bee.bpmc.data.data_source.local.model.ItemVariantEntity).\n"
                  + " Expected:\n" + _infoItemVariant + "\n"
                  + " Found:\n" + _existingItemVariant);
        }
        final HashMap<String, TableInfo.Column> _columnsItemgrp = new HashMap<String, TableInfo.Column>(6);
        _columnsItemgrp.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemgrp.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemgrp.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemgrp.put("level", new TableInfo.Column("level", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemgrp.put("up_id", new TableInfo.Column("up_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemgrp.put("ispos", new TableInfo.Column("ispos", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItemgrp = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesItemgrp = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoItemgrp = new TableInfo("itemgrp", _columnsItemgrp, _foreignKeysItemgrp, _indicesItemgrp);
        final TableInfo _existingItemgrp = TableInfo.read(_db, "itemgrp");
        if (! _infoItemgrp.equals(_existingItemgrp)) {
          return new RoomOpenHelper.ValidationResult(false, "itemgrp(com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity).\n"
                  + " Expected:\n" + _infoItemgrp + "\n"
                  + " Found:\n" + _existingItemgrp);
        }
        final HashMap<String, TableInfo.Column> _columnsKitchen = new HashMap<String, TableInfo.Column>(9);
        _columnsKitchen.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKitchen.put("code", new TableInfo.Column("code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKitchen.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKitchen.put("branch_id", new TableInfo.Column("branch_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKitchen.put("created_by", new TableInfo.Column("created_by", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKitchen.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKitchen.put("updated_by", new TableInfo.Column("updated_by", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKitchen.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKitchen.put("is_used", new TableInfo.Column("is_used", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKitchen = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysKitchen.add(new TableInfo.ForeignKey("branch", "CASCADE", "NO ACTION",Arrays.asList("branch_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesKitchen = new HashSet<TableInfo.Index>(1);
        _indicesKitchen.add(new TableInfo.Index("index_kitchen_branch_id", false, Arrays.asList("branch_id"), Arrays.asList("ASC")));
        final TableInfo _infoKitchen = new TableInfo("kitchen", _columnsKitchen, _foreignKeysKitchen, _indicesKitchen);
        final TableInfo _existingKitchen = TableInfo.read(_db, "kitchen");
        if (! _infoKitchen.equals(_existingKitchen)) {
          return new RoomOpenHelper.ValidationResult(false, "kitchen(com.bits.bee.bpmc.data.data_source.local.model.KitchenEntity).\n"
                  + " Expected:\n" + _infoKitchen + "\n"
                  + " Found:\n" + _existingKitchen);
        }
        final HashMap<String, TableInfo.Column> _columnsLicense = new HashMap<String, TableInfo.Column>(5);
        _columnsLicense.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLicense.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLicense.put("serial_number", new TableInfo.Column("serial_number", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLicense.put("item", new TableInfo.Column("item", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLicense.put("expdate", new TableInfo.Column("expdate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLicense = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLicense = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLicense = new TableInfo("license", _columnsLicense, _foreignKeysLicense, _indicesLicense);
        final TableInfo _existingLicense = TableInfo.read(_db, "license");
        if (! _infoLicense.equals(_existingLicense)) {
          return new RoomOpenHelper.ValidationResult(false, "license(com.bits.bee.bpmc.data.data_source.local.model.LicenseEntity).\n"
                  + " Expected:\n" + _infoLicense + "\n"
                  + " Found:\n" + _existingLicense);
        }
        final HashMap<String, TableInfo.Column> _columnsPosses = new HashMap<String, TableInfo.Column>(17);
        _columnsPosses.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("trxdate", new TableInfo.Column("trxdate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("starttime", new TableInfo.Column("starttime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("endtime", new TableInfo.Column("endtime", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("startbal", new TableInfo.Column("startbal", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("endbal", new TableInfo.Column("endbal", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("total", new TableInfo.Column("total", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("credit", new TableInfo.Column("credit", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("shift", new TableInfo.Column("shift", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("cashier_id", new TableInfo.Column("cashier_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("trxno", new TableInfo.Column("trxno", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("totin", new TableInfo.Column("totin", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("totout", new TableInfo.Column("totout", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("endcash", new TableInfo.Column("endcash", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("totactualcash", new TableInfo.Column("totactualcash", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPosses.put("totdiffcash", new TableInfo.Column("totdiffcash", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPosses = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysPosses.add(new TableInfo.ForeignKey("user", "CASCADE", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysPosses.add(new TableInfo.ForeignKey("cashier", "NO ACTION", "NO ACTION",Arrays.asList("cashier_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPosses = new HashSet<TableInfo.Index>(2);
        _indicesPosses.add(new TableInfo.Index("index_posses_user_id", false, Arrays.asList("user_id"), Arrays.asList("ASC")));
        _indicesPosses.add(new TableInfo.Index("index_posses_cashier_id", false, Arrays.asList("cashier_id"), Arrays.asList("ASC")));
        final TableInfo _infoPosses = new TableInfo("posses", _columnsPosses, _foreignKeysPosses, _indicesPosses);
        final TableInfo _existingPosses = TableInfo.read(_db, "posses");
        if (! _infoPosses.equals(_existingPosses)) {
          return new RoomOpenHelper.ValidationResult(false, "posses(com.bits.bee.bpmc.data.data_source.local.model.PossesEntity).\n"
                  + " Expected:\n" + _infoPosses + "\n"
                  + " Found:\n" + _existingPosses);
        }
        final HashMap<String, TableInfo.Column> _columnsPriceLvl = new HashMap<String, TableInfo.Column>(4);
        _columnsPriceLvl.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPriceLvl.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPriceLvl.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPriceLvl.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPriceLvl = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPriceLvl = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPriceLvl = new TableInfo("price_lvl", _columnsPriceLvl, _foreignKeysPriceLvl, _indicesPriceLvl);
        final TableInfo _existingPriceLvl = TableInfo.read(_db, "price_lvl");
        if (! _infoPriceLvl.equals(_existingPriceLvl)) {
          return new RoomOpenHelper.ValidationResult(false, "price_lvl(com.bits.bee.bpmc.data.data_source.local.model.PriceLvlEntity).\n"
                  + " Expected:\n" + _infoPriceLvl + "\n"
                  + " Found:\n" + _existingPriceLvl);
        }
        final HashMap<String, TableInfo.Column> _columnsPrinter = new HashMap<String, TableInfo.Column>(9);
        _columnsPrinter.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrinter.put("printername", new TableInfo.Column("printername", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrinter.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrinter.put("tipe", new TableInfo.Column("tipe", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrinter.put("size", new TableInfo.Column("size", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrinter.put("is_receipt", new TableInfo.Column("is_receipt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrinter.put("is_kitchen", new TableInfo.Column("is_kitchen", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrinter.put("is_report", new TableInfo.Column("is_report", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrinter.put("is_checker", new TableInfo.Column("is_checker", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPrinter = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPrinter = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPrinter = new TableInfo("printer", _columnsPrinter, _foreignKeysPrinter, _indicesPrinter);
        final TableInfo _existingPrinter = TableInfo.read(_db, "printer");
        if (! _infoPrinter.equals(_existingPrinter)) {
          return new RoomOpenHelper.ValidationResult(false, "printer(com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity).\n"
                  + " Expected:\n" + _infoPrinter + "\n"
                  + " Found:\n" + _existingPrinter);
        }
        final HashMap<String, TableInfo.Column> _columnsPrinterKitchen = new HashMap<String, TableInfo.Column>(3);
        _columnsPrinterKitchen.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrinterKitchen.put("kitchen_name", new TableInfo.Column("kitchen_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrinterKitchen.put("printer_id", new TableInfo.Column("printer_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPrinterKitchen = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysPrinterKitchen.add(new TableInfo.ForeignKey("printer", "CASCADE", "NO ACTION",Arrays.asList("printer_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPrinterKitchen = new HashSet<TableInfo.Index>(1);
        _indicesPrinterKitchen.add(new TableInfo.Index("index_printer_kitchen_printer_id", false, Arrays.asList("printer_id"), Arrays.asList("ASC")));
        final TableInfo _infoPrinterKitchen = new TableInfo("printer_kitchen", _columnsPrinterKitchen, _foreignKeysPrinterKitchen, _indicesPrinterKitchen);
        final TableInfo _existingPrinterKitchen = TableInfo.read(_db, "printer_kitchen");
        if (! _infoPrinterKitchen.equals(_existingPrinterKitchen)) {
          return new RoomOpenHelper.ValidationResult(false, "printer_kitchen(com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenEntity).\n"
                  + " Expected:\n" + _infoPrinterKitchen + "\n"
                  + " Found:\n" + _existingPrinterKitchen);
        }
        final HashMap<String, TableInfo.Column> _columnsPrinterKitchend = new HashMap<String, TableInfo.Column>(3);
        _columnsPrinterKitchend.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrinterKitchend.put("printer_kitchen_id", new TableInfo.Column("printer_kitchen_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrinterKitchend.put("kitchen_id", new TableInfo.Column("kitchen_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPrinterKitchend = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysPrinterKitchend.add(new TableInfo.ForeignKey("printer_kitchen", "CASCADE", "NO ACTION",Arrays.asList("printer_kitchen_id"), Arrays.asList("id")));
        _foreignKeysPrinterKitchend.add(new TableInfo.ForeignKey("kitchen", "CASCADE", "NO ACTION",Arrays.asList("kitchen_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPrinterKitchend = new HashSet<TableInfo.Index>(2);
        _indicesPrinterKitchend.add(new TableInfo.Index("index_printer_kitchend_printer_kitchen_id", false, Arrays.asList("printer_kitchen_id"), Arrays.asList("ASC")));
        _indicesPrinterKitchend.add(new TableInfo.Index("index_printer_kitchend_kitchen_id", false, Arrays.asList("kitchen_id"), Arrays.asList("ASC")));
        final TableInfo _infoPrinterKitchend = new TableInfo("printer_kitchend", _columnsPrinterKitchend, _foreignKeysPrinterKitchend, _indicesPrinterKitchend);
        final TableInfo _existingPrinterKitchend = TableInfo.read(_db, "printer_kitchend");
        if (! _infoPrinterKitchend.equals(_existingPrinterKitchend)) {
          return new RoomOpenHelper.ValidationResult(false, "printer_kitchend(com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenDEntity).\n"
                  + " Expected:\n" + _infoPrinterKitchend + "\n"
                  + " Found:\n" + _existingPrinterKitchend);
        }
        final HashMap<String, TableInfo.Column> _columnsPromo = new HashMap<String, TableInfo.Column>(44);
        _columnsPromo.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("isactive", new TableInfo.Column("isactive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("isbranch", new TableInfo.Column("isbranch", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("branchid", new TableInfo.Column("branchid", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("isperiode", new TableInfo.Column("isperiode", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("startdate", new TableInfo.Column("startdate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("enddate", new TableInfo.Column("enddate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("istime", new TableInfo.Column("istime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("starttime", new TableInfo.Column("starttime", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("endtime", new TableInfo.Column("endtime", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("isdow", new TableInfo.Column("isdow", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("dowexp", new TableInfo.Column("dowexp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("isbpgrp", new TableInfo.Column("isbpgrp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("offertype", new TableInfo.Column("offertype", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("minamt", new TableInfo.Column("minamt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("istargetitem", new TableInfo.Column("istargetitem", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("itemid", new TableInfo.Column("itemid", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("istargetitgrp", new TableInfo.Column("istargetitgrp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("itgrpid", new TableInfo.Column("itgrpid", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("istargetbrand", new TableInfo.Column("istargetbrand", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("brandid", new TableInfo.Column("brandid", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("istargetvendor", new TableInfo.Column("istargetvendor", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("vendorid", new TableInfo.Column("vendorid", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("isminqty", new TableInfo.Column("isminqty", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("minqty", new TableInfo.Column("minqty", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("priority", new TableInfo.Column("priority", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("isminamt", new TableInfo.Column("isminamt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("note", new TableInfo.Column("note", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("promotype", new TableInfo.Column("promotype", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("itemdiscexp", new TableInfo.Column("itemdiscexp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("promo_cat", new TableInfo.Column("promo_cat", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("ispriceoveride", new TableInfo.Column("ispriceoveride", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("deal_itemid", new TableInfo.Column("deal_itemid", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("itemprice", new TableInfo.Column("itemprice", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("isminqtymultiply", new TableInfo.Column("isminqtymultiply", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("ismaxqty", new TableInfo.Column("ismaxqty", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("maxqty", new TableInfo.Column("maxqty", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("isused", new TableInfo.Column("isused", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("ison", new TableInfo.Column("ison", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("ismulti", new TableInfo.Column("ismulti", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("deal_qty", new TableInfo.Column("deal_qty", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromo.put("isdealsameitem", new TableInfo.Column("isdealsameitem", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPromo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPromo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPromo = new TableInfo("promo", _columnsPromo, _foreignKeysPromo, _indicesPromo);
        final TableInfo _existingPromo = TableInfo.read(_db, "promo");
        if (! _infoPromo.equals(_existingPromo)) {
          return new RoomOpenHelper.ValidationResult(false, "promo(com.bits.bee.bpmc.data.data_source.local.model.PromoEntity).\n"
                  + " Expected:\n" + _infoPromo + "\n"
                  + " Found:\n" + _existingPromo);
        }
        final HashMap<String, TableInfo.Column> _columnsPromomulti = new HashMap<String, TableInfo.Column>(6);
        _columnsPromomulti.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromomulti.put("promo_id", new TableInfo.Column("promo_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromomulti.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromomulti.put("value", new TableInfo.Column("value", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromomulti.put("isreq", new TableInfo.Column("isreq", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromomulti.put("isdeal", new TableInfo.Column("isdeal", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPromomulti = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysPromomulti.add(new TableInfo.ForeignKey("promo", "CASCADE", "NO ACTION",Arrays.asList("promo_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPromomulti = new HashSet<TableInfo.Index>(1);
        _indicesPromomulti.add(new TableInfo.Index("index_promomulti_promo_id", false, Arrays.asList("promo_id"), Arrays.asList("ASC")));
        final TableInfo _infoPromomulti = new TableInfo("promomulti", _columnsPromomulti, _foreignKeysPromomulti, _indicesPromomulti);
        final TableInfo _existingPromomulti = TableInfo.read(_db, "promomulti");
        if (! _infoPromomulti.equals(_existingPromomulti)) {
          return new RoomOpenHelper.ValidationResult(false, "promomulti(com.bits.bee.bpmc.data.data_source.local.model.PromoMultiEntity).\n"
                  + " Expected:\n" + _infoPromomulti + "\n"
                  + " Found:\n" + _existingPromomulti);
        }
        final HashMap<String, TableInfo.Column> _columnsReg = new HashMap<String, TableInfo.Column>(6);
        _columnsReg.put("code", new TableInfo.Column("code", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReg.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReg.put("value", new TableInfo.Column("value", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReg.put("isvisible", new TableInfo.Column("isvisible", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReg.put("modul_code", new TableInfo.Column("modul_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReg.put("validator", new TableInfo.Column("validator", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReg = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesReg = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoReg = new TableInfo("reg", _columnsReg, _foreignKeysReg, _indicesReg);
        final TableInfo _existingReg = TableInfo.read(_db, "reg");
        if (! _infoReg.equals(_existingReg)) {
          return new RoomOpenHelper.ValidationResult(false, "reg(com.bits.bee.bpmc.data.data_source.local.model.RegEntity).\n"
                  + " Expected:\n" + _infoReg + "\n"
                  + " Found:\n" + _existingReg);
        }
        final HashMap<String, TableInfo.Column> _columnsSale = new HashMap<String, TableInfo.Column>(34);
        _columnsSale.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("trx_ordernum", new TableInfo.Column("trx_ordernum", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("trx_no", new TableInfo.Column("trx_no", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("draft", new TableInfo.Column("draft", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("subtotal", new TableInfo.Column("subtotal", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("total", new TableInfo.Column("total", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("opr_name", new TableInfo.Column("opr_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("cashier_name", new TableInfo.Column("cashier_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("trx_date", new TableInfo.Column("trx_date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("paidamt", new TableInfo.Column("paidamt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("changeamt", new TableInfo.Column("changeamt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("taxamt", new TableInfo.Column("taxamt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("discamt", new TableInfo.Column("discamt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("posses_id", new TableInfo.Column("posses_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("kode_posses", new TableInfo.Column("kode_posses", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("discexp", new TableInfo.Column("discexp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("cashier_id", new TableInfo.Column("cashier_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("bp_id", new TableInfo.Column("bp_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("bp_name", new TableInfo.Column("bp_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("termtype", new TableInfo.Column("termtype", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("isuploaded", new TableInfo.Column("isuploaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("isvoid", new TableInfo.Column("isvoid", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("url_qrcode", new TableInfo.Column("url_qrcode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("transaction_id", new TableInfo.Column("transaction_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("gopay_paymentstatus", new TableInfo.Column("gopay_paymentstatus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("rounding", new TableInfo.Column("rounding", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("channel_id", new TableInfo.Column("channel_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("void_note", new TableInfo.Column("void_note", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("created_by", new TableInfo.Column("created_by", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("updated_by", new TableInfo.Column("updated_by", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSale.put("crc_id", new TableInfo.Column("crc_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSale = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysSale.add(new TableInfo.ForeignKey("posses", "NO ACTION", "NO ACTION",Arrays.asList("posses_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesSale = new HashSet<TableInfo.Index>(6);
        _indicesSale.add(new TableInfo.Index("index_sale_posses_id", false, Arrays.asList("posses_id"), Arrays.asList("ASC")));
        _indicesSale.add(new TableInfo.Index("index_sale_user_id", false, Arrays.asList("user_id"), Arrays.asList("ASC")));
        _indicesSale.add(new TableInfo.Index("index_sale_cashier_id", false, Arrays.asList("cashier_id"), Arrays.asList("ASC")));
        _indicesSale.add(new TableInfo.Index("index_sale_bp_id", false, Arrays.asList("bp_id"), Arrays.asList("ASC")));
        _indicesSale.add(new TableInfo.Index("index_sale_channel_id", false, Arrays.asList("channel_id"), Arrays.asList("ASC")));
        _indicesSale.add(new TableInfo.Index("index_sale_crc_id", false, Arrays.asList("crc_id"), Arrays.asList("ASC")));
        final TableInfo _infoSale = new TableInfo("sale", _columnsSale, _foreignKeysSale, _indicesSale);
        final TableInfo _existingSale = TableInfo.read(_db, "sale");
        if (! _infoSale.equals(_existingSale)) {
          return new RoomOpenHelper.ValidationResult(false, "sale(com.bits.bee.bpmc.data.data_source.local.model.SaleEntity).\n"
                  + " Expected:\n" + _infoSale + "\n"
                  + " Found:\n" + _existingSale);
        }
        final HashMap<String, TableInfo.Column> _columnsSalecrcvs = new HashMap<String, TableInfo.Column>(17);
        _columnsSalecrcvs.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("rcvtype_code", new TableInfo.Column("rcvtype_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("sale", new TableInfo.Column("sale", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("rcvamt", new TableInfo.Column("rcvamt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("note", new TableInfo.Column("note", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("edc_id", new TableInfo.Column("edc_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("cash_id", new TableInfo.Column("cash_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("card_no", new TableInfo.Column("card_no", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("cctype_code", new TableInfo.Column("cctype_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("mdrexp", new TableInfo.Column("mdrexp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("mdramt", new TableInfo.Column("mdramt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("surcexp", new TableInfo.Column("surcexp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("surcamt", new TableInfo.Column("surcamt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("mdracc_id", new TableInfo.Column("mdracc_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("surcacc_id", new TableInfo.Column("surcacc_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("ref_id", new TableInfo.Column("ref_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalecrcvs.put("track_no", new TableInfo.Column("track_no", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSalecrcvs = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysSalecrcvs.add(new TableInfo.ForeignKey("sale", "CASCADE", "NO ACTION",Arrays.asList("sale"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesSalecrcvs = new HashSet<TableInfo.Index>(1);
        _indicesSalecrcvs.add(new TableInfo.Index("index_salecrcvs_sale", false, Arrays.asList("sale"), Arrays.asList("ASC")));
        final TableInfo _infoSalecrcvs = new TableInfo("salecrcvs", _columnsSalecrcvs, _foreignKeysSalecrcvs, _indicesSalecrcvs);
        final TableInfo _existingSalecrcvs = TableInfo.read(_db, "salecrcvs");
        if (! _infoSalecrcvs.equals(_existingSalecrcvs)) {
          return new RoomOpenHelper.ValidationResult(false, "salecrcvs(com.bits.bee.bpmc.data.data_source.local.model.SaleCrcvEntity).\n"
                  + " Expected:\n" + _infoSalecrcvs + "\n"
                  + " Found:\n" + _existingSalecrcvs);
        }
        final HashMap<String, TableInfo.Column> _columnsSalepromo = new HashMap<String, TableInfo.Column>(8);
        _columnsSalepromo.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalepromo.put("sale_id", new TableInfo.Column("sale_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalepromo.put("saleno", new TableInfo.Column("saleno", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalepromo.put("saled_id", new TableInfo.Column("saled_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalepromo.put("promo_id", new TableInfo.Column("promo_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalepromo.put("bp_id", new TableInfo.Column("bp_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalepromo.put("promoqty", new TableInfo.Column("promoqty", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalepromo.put("promorole", new TableInfo.Column("promorole", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSalepromo = new HashSet<TableInfo.ForeignKey>(4);
        _foreignKeysSalepromo.add(new TableInfo.ForeignKey("sale", "CASCADE", "NO ACTION",Arrays.asList("sale_id"), Arrays.asList("id")));
        _foreignKeysSalepromo.add(new TableInfo.ForeignKey("saled", "CASCADE", "NO ACTION",Arrays.asList("saled_id"), Arrays.asList("id")));
        _foreignKeysSalepromo.add(new TableInfo.ForeignKey("promo", "NO ACTION", "NO ACTION",Arrays.asList("promo_id"), Arrays.asList("id")));
        _foreignKeysSalepromo.add(new TableInfo.ForeignKey("bp", "NO ACTION", "NO ACTION",Arrays.asList("bp_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesSalepromo = new HashSet<TableInfo.Index>(4);
        _indicesSalepromo.add(new TableInfo.Index("index_salepromo_sale_id", false, Arrays.asList("sale_id"), Arrays.asList("ASC")));
        _indicesSalepromo.add(new TableInfo.Index("index_salepromo_saled_id", false, Arrays.asList("saled_id"), Arrays.asList("ASC")));
        _indicesSalepromo.add(new TableInfo.Index("index_salepromo_promo_id", false, Arrays.asList("promo_id"), Arrays.asList("ASC")));
        _indicesSalepromo.add(new TableInfo.Index("index_salepromo_bp_id", false, Arrays.asList("bp_id"), Arrays.asList("ASC")));
        final TableInfo _infoSalepromo = new TableInfo("salepromo", _columnsSalepromo, _foreignKeysSalepromo, _indicesSalepromo);
        final TableInfo _existingSalepromo = TableInfo.read(_db, "salepromo");
        if (! _infoSalepromo.equals(_existingSalepromo)) {
          return new RoomOpenHelper.ValidationResult(false, "salepromo(com.bits.bee.bpmc.data.data_source.local.model.SalePromoEntity).\n"
                  + " Expected:\n" + _infoSalepromo + "\n"
                  + " Found:\n" + _existingSalepromo);
        }
        final HashMap<String, TableInfo.Column> _columnsSelection = new HashMap<String, TableInfo.Column>(7);
        _columnsSelection.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSelection.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSelection.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSelection.put("note", new TableInfo.Column("note", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSelection.put("isactive", new TableInfo.Column("isactive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSelection.put("ismultiselect", new TableInfo.Column("ismultiselect", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSelection.put("ismultiqty", new TableInfo.Column("ismultiqty", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSelection = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSelection = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSelection = new TableInfo("selection", _columnsSelection, _foreignKeysSelection, _indicesSelection);
        final TableInfo _existingSelection = TableInfo.read(_db, "selection");
        if (! _infoSelection.equals(_existingSelection)) {
          return new RoomOpenHelper.ValidationResult(false, "selection(com.bits.bee.bpmc.data.data_source.local.model.SelectionEntity).\n"
                  + " Expected:\n" + _infoSelection + "\n"
                  + " Found:\n" + _existingSelection);
        }
        final HashMap<String, TableInfo.Column> _columnsSelectiond = new HashMap<String, TableInfo.Column>(4);
        _columnsSelectiond.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSelectiond.put("selection_id", new TableInfo.Column("selection_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSelectiond.put("dno", new TableInfo.Column("dno", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSelectiond.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSelectiond = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysSelectiond.add(new TableInfo.ForeignKey("selection", "CASCADE", "NO ACTION",Arrays.asList("selection_id"), Arrays.asList("id")));
        _foreignKeysSelectiond.add(new TableInfo.ForeignKey("item", "CASCADE", "NO ACTION",Arrays.asList("item_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesSelectiond = new HashSet<TableInfo.Index>(2);
        _indicesSelectiond.add(new TableInfo.Index("index_selectiond_selection_id", false, Arrays.asList("selection_id"), Arrays.asList("ASC")));
        _indicesSelectiond.add(new TableInfo.Index("index_selectiond_item_id", false, Arrays.asList("item_id"), Arrays.asList("ASC")));
        final TableInfo _infoSelectiond = new TableInfo("selectiond", _columnsSelectiond, _foreignKeysSelectiond, _indicesSelectiond);
        final TableInfo _existingSelectiond = TableInfo.read(_db, "selectiond");
        if (! _infoSelectiond.equals(_existingSelectiond)) {
          return new RoomOpenHelper.ValidationResult(false, "selectiond(com.bits.bee.bpmc.data.data_source.local.model.SelectionDEntity).\n"
                  + " Expected:\n" + _infoSelectiond + "\n"
                  + " Found:\n" + _existingSelectiond);
        }
        final HashMap<String, TableInfo.Column> _columnsSaled = new HashMap<String, TableInfo.Column>(26);
        _columnsSaled.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("item_code", new TableInfo.Column("item_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("qty", new TableInfo.Column("qty", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("listprice", new TableInfo.Column("listprice", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("disc", new TableInfo.Column("disc", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("tax", new TableInfo.Column("tax", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("discexp", new TableInfo.Column("discexp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("discamt", new TableInfo.Column("discamt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("disc2amt", new TableInfo.Column("disc2amt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("taxamt", new TableInfo.Column("taxamt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("baseprice", new TableInfo.Column("baseprice", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("taxableamt", new TableInfo.Column("taxableamt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("subtotal", new TableInfo.Column("subtotal", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("sale_id", new TableInfo.Column("sale_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("dno", new TableInfo.Column("dno", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("totaldiscamt", new TableInfo.Column("totaldiscamt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("totaldisc2amt", new TableInfo.Column("totaldisc2amt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("totaltaxamt", new TableInfo.Column("totaltaxamt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("dnote", new TableInfo.Column("dnote", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("crc_id", new TableInfo.Column("crc_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("unit_id", new TableInfo.Column("unit_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("conv", new TableInfo.Column("conv", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("pid", new TableInfo.Column("pid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaled.put("tax_code", new TableInfo.Column("tax_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSaled = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysSaled.add(new TableInfo.ForeignKey("item", "NO ACTION", "NO ACTION",Arrays.asList("item_id"), Arrays.asList("id")));
        _foreignKeysSaled.add(new TableInfo.ForeignKey("sale", "CASCADE", "NO ACTION",Arrays.asList("sale_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesSaled = new HashSet<TableInfo.Index>(2);
        _indicesSaled.add(new TableInfo.Index("index_saled_item_id", false, Arrays.asList("item_id"), Arrays.asList("ASC")));
        _indicesSaled.add(new TableInfo.Index("index_saled_sale_id", false, Arrays.asList("sale_id"), Arrays.asList("ASC")));
        final TableInfo _infoSaled = new TableInfo("saled", _columnsSaled, _foreignKeysSaled, _indicesSaled);
        final TableInfo _existingSaled = TableInfo.read(_db, "saled");
        if (! _infoSaled.equals(_existingSaled)) {
          return new RoomOpenHelper.ValidationResult(false, "saled(com.bits.bee.bpmc.data.data_source.local.model.SaledEntity).\n"
                  + " Expected:\n" + _infoSaled + "\n"
                  + " Found:\n" + _existingSaled);
        }
        final HashMap<String, TableInfo.Column> _columnsSync = new HashMap<String, TableInfo.Column>(6);
        _columnsSync.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSync.put("trx_no", new TableInfo.Column("trx_no", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSync.put("trxdate", new TableInfo.Column("trxdate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSync.put("bp_id", new TableInfo.Column("bp_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSync.put("bp_name", new TableInfo.Column("bp_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSync.put("isuploaded", new TableInfo.Column("isuploaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSync = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSync = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSync = new TableInfo("sync", _columnsSync, _foreignKeysSync, _indicesSync);
        final TableInfo _existingSync = TableInfo.read(_db, "sync");
        if (! _infoSync.equals(_existingSync)) {
          return new RoomOpenHelper.ValidationResult(false, "sync(com.bits.bee.bpmc.data.data_source.local.model.SyncEntity).\n"
                  + " Expected:\n" + _infoSync + "\n"
                  + " Found:\n" + _existingSync);
        }
        final HashMap<String, TableInfo.Column> _columnsTax = new HashMap<String, TableInfo.Column>(6);
        _columnsTax.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTax.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTax.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTax.put("expr", new TableInfo.Column("expr", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTax.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTax.put("isdefault", new TableInfo.Column("isdefault", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTax = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTax = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTax = new TableInfo("tax", _columnsTax, _foreignKeysTax, _indicesTax);
        final TableInfo _existingTax = TableInfo.read(_db, "tax");
        if (! _infoTax.equals(_existingTax)) {
          return new RoomOpenHelper.ValidationResult(false, "tax(com.bits.bee.bpmc.data.data_source.local.model.TaxEntity).\n"
                  + " Expected:\n" + _infoTax + "\n"
                  + " Found:\n" + _existingTax);
        }
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(6);
        _columnsUser.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("auth_key", new TableInfo.Column("auth_key", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("pin", new TableInfo.Column("pin", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("user", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(_db, "user");
        if (! _infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "user(com.bits.bee.bpmc.data.data_source.local.model.UserEntity).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsUsrgrp = new HashMap<String, TableInfo.Column>(6);
        _columnsUsrgrp.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsrgrp.put("usr_code", new TableInfo.Column("usr_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsrgrp.put("disabled", new TableInfo.Column("disabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsrgrp.put("grp_id", new TableInfo.Column("grp_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsrgrp.put("usr_id", new TableInfo.Column("usr_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsrgrp.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsrgrp = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsrgrp = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsrgrp = new TableInfo("usrgrp", _columnsUsrgrp, _foreignKeysUsrgrp, _indicesUsrgrp);
        final TableInfo _existingUsrgrp = TableInfo.read(_db, "usrgrp");
        if (! _infoUsrgrp.equals(_existingUsrgrp)) {
          return new RoomOpenHelper.ValidationResult(false, "usrgrp(com.bits.bee.bpmc.data.data_source.local.model.UsrGrpEntity).\n"
                  + " Expected:\n" + _infoUsrgrp + "\n"
                  + " Found:\n" + _existingUsrgrp);
        }
        final HashMap<String, TableInfo.Column> _columnsVariant = new HashMap<String, TableInfo.Column>(7);
        _columnsVariant.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVariant.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVariant.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVariant.put("itgrp_id", new TableInfo.Column("itgrp_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVariant.put("picpath", new TableInfo.Column("picpath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVariant.put("isfavorit", new TableInfo.Column("isfavorit", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVariant.put("isavailable", new TableInfo.Column("isavailable", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVariant = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysVariant.add(new TableInfo.ForeignKey("itemgrp", "CASCADE", "NO ACTION",Arrays.asList("itgrp_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesVariant = new HashSet<TableInfo.Index>(1);
        _indicesVariant.add(new TableInfo.Index("index_variant_itgrp_id", false, Arrays.asList("itgrp_id"), Arrays.asList("ASC")));
        final TableInfo _infoVariant = new TableInfo("variant", _columnsVariant, _foreignKeysVariant, _indicesVariant);
        final TableInfo _existingVariant = TableInfo.read(_db, "variant");
        if (! _infoVariant.equals(_existingVariant)) {
          return new RoomOpenHelper.ValidationResult(false, "variant(com.bits.bee.bpmc.data.data_source.local.model.VariantEntity).\n"
                  + " Expected:\n" + _infoVariant + "\n"
                  + " Found:\n" + _existingVariant);
        }
        final HashMap<String, TableInfo.Column> _columnsCity = new HashMap<String, TableInfo.Column>(3);
        _columnsCity.put("code", new TableInfo.Column("code", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCity.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCity.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCity = new TableInfo("city", _columnsCity, _foreignKeysCity, _indicesCity);
        final TableInfo _existingCity = TableInfo.read(_db, "city");
        if (! _infoCity.equals(_existingCity)) {
          return new RoomOpenHelper.ValidationResult(false, "city(com.bits.bee.bpmc.data.data_source.local.model.CityEntity).\n"
                  + " Expected:\n" + _infoCity + "\n"
                  + " Found:\n" + _existingCity);
        }
        final HashMap<String, TableInfo.Column> _columnsBpaddr = new HashMap<String, TableInfo.Column>(20);
        _columnsBpaddr.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("bp_id", new TableInfo.Column("bp_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("greeting", new TableInfo.Column("greeting", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("zipcode", new TableInfo.Column("zipcode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("note", new TableInfo.Column("note", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("isbilladdr", new TableInfo.Column("isbilladdr", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("isshipaddr", new TableInfo.Column("isshipaddr", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("ismainaddr", new TableInfo.Column("ismainaddr", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("province_code", new TableInfo.Column("province_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("regency_code", new TableInfo.Column("regency_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("city_code", new TableInfo.Column("city_code", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("district_code", new TableInfo.Column("district_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("created_at", new TableInfo.Column("created_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("created_by", new TableInfo.Column("created_by", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBpaddr.put("updated_by", new TableInfo.Column("updated_by", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBpaddr = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysBpaddr.add(new TableInfo.ForeignKey("bp", "CASCADE", "NO ACTION",Arrays.asList("bp_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesBpaddr = new HashSet<TableInfo.Index>(5);
        _indicesBpaddr.add(new TableInfo.Index("index_bpaddr_bp_id", false, Arrays.asList("bp_id"), Arrays.asList("ASC")));
        _indicesBpaddr.add(new TableInfo.Index("index_bpaddr_province_code", false, Arrays.asList("province_code"), Arrays.asList("ASC")));
        _indicesBpaddr.add(new TableInfo.Index("index_bpaddr_regency_code", false, Arrays.asList("regency_code"), Arrays.asList("ASC")));
        _indicesBpaddr.add(new TableInfo.Index("index_bpaddr_city_code", false, Arrays.asList("city_code"), Arrays.asList("ASC")));
        _indicesBpaddr.add(new TableInfo.Index("index_bpaddr_district_code", false, Arrays.asList("district_code"), Arrays.asList("ASC")));
        final TableInfo _infoBpaddr = new TableInfo("bpaddr", _columnsBpaddr, _foreignKeysBpaddr, _indicesBpaddr);
        final TableInfo _existingBpaddr = TableInfo.read(_db, "bpaddr");
        if (! _infoBpaddr.equals(_existingBpaddr)) {
          return new RoomOpenHelper.ValidationResult(false, "bpaddr(com.bits.bee.bpmc.data.data_source.local.model.BpAddrEntity).\n"
                  + " Expected:\n" + _infoBpaddr + "\n"
                  + " Found:\n" + _existingBpaddr);
        }
        final HashMap<String, TableInfo.Column> _columnsProvince = new HashMap<String, TableInfo.Column>(3);
        _columnsProvince.put("code", new TableInfo.Column("code", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProvince.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProvince.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProvince = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProvince = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProvince = new TableInfo("province", _columnsProvince, _foreignKeysProvince, _indicesProvince);
        final TableInfo _existingProvince = TableInfo.read(_db, "province");
        if (! _infoProvince.equals(_existingProvince)) {
          return new RoomOpenHelper.ValidationResult(false, "province(com.bits.bee.bpmc.data.data_source.local.model.ProvinceEntity).\n"
                  + " Expected:\n" + _infoProvince + "\n"
                  + " Found:\n" + _existingProvince);
        }
        final HashMap<String, TableInfo.Column> _columnsDistrict = new HashMap<String, TableInfo.Column>(4);
        _columnsDistrict.put("code", new TableInfo.Column("code", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDistrict.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDistrict.put("regency_code", new TableInfo.Column("regency_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDistrict.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDistrict = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysDistrict.add(new TableInfo.ForeignKey("regency", "CASCADE", "NO ACTION",Arrays.asList("regency_code"), Arrays.asList("code")));
        final HashSet<TableInfo.Index> _indicesDistrict = new HashSet<TableInfo.Index>(1);
        _indicesDistrict.add(new TableInfo.Index("index_district_regency_code", false, Arrays.asList("regency_code"), Arrays.asList("ASC")));
        final TableInfo _infoDistrict = new TableInfo("district", _columnsDistrict, _foreignKeysDistrict, _indicesDistrict);
        final TableInfo _existingDistrict = TableInfo.read(_db, "district");
        if (! _infoDistrict.equals(_existingDistrict)) {
          return new RoomOpenHelper.ValidationResult(false, "district(com.bits.bee.bpmc.data.data_source.local.model.DistrictEntity).\n"
                  + " Expected:\n" + _infoDistrict + "\n"
                  + " Found:\n" + _existingDistrict);
        }
        final HashMap<String, TableInfo.Column> _columnsPmtd = new HashMap<String, TableInfo.Column>(15);
        _columnsPmtd.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmtd.put("idx", new TableInfo.Column("idx", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmtd.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmtd.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmtd.put("cash_id", new TableInfo.Column("cash_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmtd.put("mdrexp", new TableInfo.Column("mdrexp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmtd.put("mdracc", new TableInfo.Column("mdracc", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmtd.put("surcexp", new TableInfo.Column("surcexp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmtd.put("surcacc", new TableInfo.Column("surcacc", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmtd.put("branch_id", new TableInfo.Column("branch_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmtd.put("settledays", new TableInfo.Column("settledays", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmtd.put("cash_name", new TableInfo.Column("cash_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmtd.put("branch_name", new TableInfo.Column("branch_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmtd.put("cctype", new TableInfo.Column("cctype", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmtd.put("edcsurctype", new TableInfo.Column("edcsurctype", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPmtd = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPmtd = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPmtd = new TableInfo("pmtd", _columnsPmtd, _foreignKeysPmtd, _indicesPmtd);
        final TableInfo _existingPmtd = TableInfo.read(_db, "pmtd");
        if (! _infoPmtd.equals(_existingPmtd)) {
          return new RoomOpenHelper.ValidationResult(false, "pmtd(com.bits.bee.bpmc.data.data_source.local.model.PmtdEntity).\n"
                  + " Expected:\n" + _infoPmtd + "\n"
                  + " Found:\n" + _existingPmtd);
        }
        final HashMap<String, TableInfo.Column> _columnsUnit = new HashMap<String, TableInfo.Column>(5);
        _columnsUnit.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnit.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnit.put("idx", new TableInfo.Column("idx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnit.put("unit", new TableInfo.Column("unit", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnit.put("conv", new TableInfo.Column("conv", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUnit = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUnit = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUnit = new TableInfo("unit", _columnsUnit, _foreignKeysUnit, _indicesUnit);
        final TableInfo _existingUnit = TableInfo.read(_db, "unit");
        if (! _infoUnit.equals(_existingUnit)) {
          return new RoomOpenHelper.ValidationResult(false, "unit(com.bits.bee.bpmc.data.data_source.local.model.UnitEntity).\n"
                  + " Expected:\n" + _infoUnit + "\n"
                  + " Found:\n" + _existingUnit);
        }
        final HashMap<String, TableInfo.Column> _columnsCmp = new HashMap<String, TableInfo.Column>(16);
        _columnsCmp.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("city_code", new TableInfo.Column("city_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("crc_id", new TableInfo.Column("crc_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("fax", new TableInfo.Column("fax", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("zipcode", new TableInfo.Column("zipcode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("startdate", new TableInfo.Column("startdate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("fiscalyear", new TableInfo.Column("fiscalyear", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("ownername", new TableInfo.Column("ownername", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("ownertaxregno", new TableInfo.Column("ownertaxregno", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("formserno", new TableInfo.Column("formserno", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("taxregno", new TableInfo.Column("taxregno", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("vatregno", new TableInfo.Column("vatregno", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCmp.put("cosstype", new TableInfo.Column("cosstype", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCmp = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCmp = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCmp = new TableInfo("cmp", _columnsCmp, _foreignKeysCmp, _indicesCmp);
        final TableInfo _existingCmp = TableInfo.read(_db, "cmp");
        if (! _infoCmp.equals(_existingCmp)) {
          return new RoomOpenHelper.ValidationResult(false, "cmp(com.bits.bee.bpmc.data.data_source.local.model.CmpEntity).\n"
                  + " Expected:\n" + _infoCmp + "\n"
                  + " Found:\n" + _existingCmp);
        }
        final HashMap<String, TableInfo.Column> _columnsCrc = new HashMap<String, TableInfo.Column>(9);
        _columnsCrc.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrc.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrc.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrc.put("symbol", new TableInfo.Column("symbol", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrc.put("isdefault", new TableInfo.Column("isdefault", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrc.put("excrate", new TableInfo.Column("excrate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrc.put("fisrate", new TableInfo.Column("fisrate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrc.put("ratetype", new TableInfo.Column("ratetype", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrc.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCrc = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCrc = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCrc = new TableInfo("crc", _columnsCrc, _foreignKeysCrc, _indicesCrc);
        final TableInfo _existingCrc = TableInfo.read(_db, "crc");
        if (! _infoCrc.equals(_existingCrc)) {
          return new RoomOpenHelper.ValidationResult(false, "crc(com.bits.bee.bpmc.data.data_source.local.model.CrcEntity).\n"
                  + " Expected:\n" + _infoCrc + "\n"
                  + " Found:\n" + _existingCrc);
        }
        final HashMap<String, TableInfo.Column> _columnsCityPopuler = new HashMap<String, TableInfo.Column>(2);
        _columnsCityPopuler.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityPopuler.put("name_city", new TableInfo.Column("name_city", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCityPopuler = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCityPopuler = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCityPopuler = new TableInfo("city_populer", _columnsCityPopuler, _foreignKeysCityPopuler, _indicesCityPopuler);
        final TableInfo _existingCityPopuler = TableInfo.read(_db, "city_populer");
        if (! _infoCityPopuler.equals(_existingCityPopuler)) {
          return new RoomOpenHelper.ValidationResult(false, "city_populer(com.bits.bee.bpmc.data.data_source.local.model.CityPopulerEntity).\n"
                  + " Expected:\n" + _infoCityPopuler + "\n"
                  + " Found:\n" + _existingCityPopuler);
        }
        final HashMap<String, TableInfo.Column> _columnsStock = new HashMap<String, TableInfo.Column>(9);
        _columnsStock.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStock.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStock.put("wh_id", new TableInfo.Column("wh_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStock.put("item_code", new TableInfo.Column("item_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStock.put("wh_code", new TableInfo.Column("wh_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStock.put("pid", new TableInfo.Column("pid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStock.put("qty", new TableInfo.Column("qty", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStock.put("qtyx", new TableInfo.Column("qtyx", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStock.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStock = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStock = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStock = new TableInfo("stock", _columnsStock, _foreignKeysStock, _indicesStock);
        final TableInfo _existingStock = TableInfo.read(_db, "stock");
        if (! _infoStock.equals(_existingStock)) {
          return new RoomOpenHelper.ValidationResult(false, "stock(com.bits.bee.bpmc.data.data_source.local.model.StockEntity).\n"
                  + " Expected:\n" + _infoStock + "\n"
                  + " Found:\n" + _existingStock);
        }
        RoomOpenHelper.ValidationResult _result;
        _result = onValidateSchema2(_db);
        if (!_result.isValid) {
          return _result;
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }

      private RoomOpenHelper.ValidationResult onValidateSchema2(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsWh = new HashMap<String, TableInfo.Column>(4);
        _columnsWh.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWh.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWh.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWh.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWh = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWh = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWh = new TableInfo("wh", _columnsWh, _foreignKeysWh, _indicesWh);
        final TableInfo _existingWh = TableInfo.read(_db, "wh");
        if (! _infoWh.equals(_existingWh)) {
          return new RoomOpenHelper.ValidationResult(false, "wh(com.bits.bee.bpmc.data.data_source.local.model.WhEntity).\n"
                  + " Expected:\n" + _infoWh + "\n"
                  + " Found:\n" + _existingWh);
        }
        final HashMap<String, TableInfo.Column> _columnsSaleaddon = new HashMap<String, TableInfo.Column>(2);
        _columnsSaleaddon.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaleaddon.put("sale_id", new TableInfo.Column("sale_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSaleaddon = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysSaleaddon.add(new TableInfo.ForeignKey("sale", "CASCADE", "NO ACTION",Arrays.asList("sale_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesSaleaddon = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSaleaddon = new TableInfo("saleaddon", _columnsSaleaddon, _foreignKeysSaleaddon, _indicesSaleaddon);
        final TableInfo _existingSaleaddon = TableInfo.read(_db, "saleaddon");
        if (! _infoSaleaddon.equals(_existingSaleaddon)) {
          return new RoomOpenHelper.ValidationResult(false, "saleaddon(com.bits.bee.bpmc.data.data_source.local.model.SaleAddOnEntity).\n"
                  + " Expected:\n" + _infoSaleaddon + "\n"
                  + " Found:\n" + _existingSaleaddon);
        }
        final HashMap<String, TableInfo.Column> _columnsSaleaddond = new HashMap<String, TableInfo.Column>(4);
        _columnsSaleaddond.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaleaddond.put("saledaddon_id", new TableInfo.Column("saledaddon_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaleaddond.put("up_saled_id", new TableInfo.Column("up_saled_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSaleaddond.put("saled_id", new TableInfo.Column("saled_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSaleaddond = new HashSet<TableInfo.ForeignKey>(3);
        _foreignKeysSaleaddond.add(new TableInfo.ForeignKey("saleaddon", "CASCADE", "NO ACTION",Arrays.asList("saledaddon_id"), Arrays.asList("id")));
        _foreignKeysSaleaddond.add(new TableInfo.ForeignKey("saled", "CASCADE", "NO ACTION",Arrays.asList("up_saled_id"), Arrays.asList("id")));
        _foreignKeysSaleaddond.add(new TableInfo.ForeignKey("saled", "CASCADE", "NO ACTION",Arrays.asList("saled_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesSaleaddond = new HashSet<TableInfo.Index>(3);
        _indicesSaleaddond.add(new TableInfo.Index("index_saleaddond_saledaddon_id", false, Arrays.asList("saledaddon_id"), Arrays.asList("ASC")));
        _indicesSaleaddond.add(new TableInfo.Index("index_saleaddond_up_saled_id", false, Arrays.asList("up_saled_id"), Arrays.asList("ASC")));
        _indicesSaleaddond.add(new TableInfo.Index("index_saleaddond_saled_id", false, Arrays.asList("saled_id"), Arrays.asList("ASC")));
        final TableInfo _infoSaleaddond = new TableInfo("saleaddond", _columnsSaleaddond, _foreignKeysSaleaddond, _indicesSaleaddond);
        final TableInfo _existingSaleaddond = TableInfo.read(_db, "saleaddond");
        if (! _infoSaleaddond.equals(_existingSaleaddond)) {
          return new RoomOpenHelper.ValidationResult(false, "saleaddond(com.bits.bee.bpmc.data.data_source.local.model.SaleAddOnDEntity).\n"
                  + " Expected:\n" + _infoSaleaddond + "\n"
                  + " Found:\n" + _existingSaleaddond);
        }
        final HashMap<String, TableInfo.Column> _columnsItemDummy = new HashMap<String, TableInfo.Column>(7);
        _columnsItemDummy.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemDummy.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemDummy.put("itemtype_code", new TableInfo.Column("itemtype_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemDummy.put("itemgroup", new TableInfo.Column("itemgroup", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemDummy.put("price", new TableInfo.Column("price", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemDummy.put("unit", new TableInfo.Column("unit", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemDummy.put("picpath", new TableInfo.Column("picpath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItemDummy = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesItemDummy = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoItemDummy = new TableInfo("item_dummy", _columnsItemDummy, _foreignKeysItemDummy, _indicesItemDummy);
        final TableInfo _existingItemDummy = TableInfo.read(_db, "item_dummy");
        if (! _infoItemDummy.equals(_existingItemDummy)) {
          return new RoomOpenHelper.ValidationResult(false, "item_dummy(com.bits.bee.bpmc.data.data_source.local.model.ItemDummyEntity).\n"
                  + " Expected:\n" + _infoItemDummy + "\n"
                  + " Found:\n" + _existingItemDummy);
        }
        final HashMap<String, TableInfo.Column> _columnsUnitDummy = new HashMap<String, TableInfo.Column>(5);
        _columnsUnitDummy.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnitDummy.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnitDummy.put("idx", new TableInfo.Column("idx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnitDummy.put("unit", new TableInfo.Column("unit", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnitDummy.put("conv", new TableInfo.Column("conv", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUnitDummy = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUnitDummy = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUnitDummy = new TableInfo("unit_dummy", _columnsUnitDummy, _foreignKeysUnitDummy, _indicesUnitDummy);
        final TableInfo _existingUnitDummy = TableInfo.read(_db, "unit_dummy");
        if (! _infoUnitDummy.equals(_existingUnitDummy)) {
          return new RoomOpenHelper.ValidationResult(false, "unit_dummy(com.bits.bee.bpmc.data.data_source.local.model.UnitDummyEntity).\n"
                  + " Expected:\n" + _infoUnitDummy + "\n"
                  + " Found:\n" + _existingUnitDummy);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "73e8532c21a8d469c4d1d43d89a9c783", "c19f01f287fa597cf5d246a34f531996");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "addon","addond","bp","branch","cadj","cash","casha","cashier","cc_type","channel","regency","cstr","edc","edcsurc","grpprv","item","itemaddon","item_branch","item_kitchen","dummy_item","price","item_tax","item_variant","itemgrp","kitchen","license","posses","price_lvl","printer","printer_kitchen","printer_kitchend","promo","promomulti","reg","sale","salecrcvs","salepromo","selection","selectiond","saled","sync","tax","user","usrgrp","variant","city","bpaddr","province","district","pmtd","unit","cmp","crc","city_populer","stock","wh","saleaddon","saleaddond","item_dummy","unit_dummy");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `addon`");
      _db.execSQL("DELETE FROM `addond`");
      _db.execSQL("DELETE FROM `bp`");
      _db.execSQL("DELETE FROM `branch`");
      _db.execSQL("DELETE FROM `cadj`");
      _db.execSQL("DELETE FROM `cash`");
      _db.execSQL("DELETE FROM `casha`");
      _db.execSQL("DELETE FROM `cashier`");
      _db.execSQL("DELETE FROM `cc_type`");
      _db.execSQL("DELETE FROM `channel`");
      _db.execSQL("DELETE FROM `regency`");
      _db.execSQL("DELETE FROM `cstr`");
      _db.execSQL("DELETE FROM `edc`");
      _db.execSQL("DELETE FROM `edcsurc`");
      _db.execSQL("DELETE FROM `grpprv`");
      _db.execSQL("DELETE FROM `itemaddon`");
      _db.execSQL("DELETE FROM `item`");
      _db.execSQL("DELETE FROM `item_branch`");
      _db.execSQL("DELETE FROM `item_kitchen`");
      _db.execSQL("DELETE FROM `dummy_item`");
      _db.execSQL("DELETE FROM `price`");
      _db.execSQL("DELETE FROM `item_tax`");
      _db.execSQL("DELETE FROM `item_variant`");
      _db.execSQL("DELETE FROM `itemgrp`");
      _db.execSQL("DELETE FROM `kitchen`");
      _db.execSQL("DELETE FROM `license`");
      _db.execSQL("DELETE FROM `posses`");
      _db.execSQL("DELETE FROM `price_lvl`");
      _db.execSQL("DELETE FROM `printer`");
      _db.execSQL("DELETE FROM `printer_kitchen`");
      _db.execSQL("DELETE FROM `printer_kitchend`");
      _db.execSQL("DELETE FROM `promo`");
      _db.execSQL("DELETE FROM `promomulti`");
      _db.execSQL("DELETE FROM `reg`");
      _db.execSQL("DELETE FROM `sale`");
      _db.execSQL("DELETE FROM `salecrcvs`");
      _db.execSQL("DELETE FROM `salepromo`");
      _db.execSQL("DELETE FROM `selection`");
      _db.execSQL("DELETE FROM `selectiond`");
      _db.execSQL("DELETE FROM `saled`");
      _db.execSQL("DELETE FROM `sync`");
      _db.execSQL("DELETE FROM `tax`");
      _db.execSQL("DELETE FROM `user`");
      _db.execSQL("DELETE FROM `usrgrp`");
      _db.execSQL("DELETE FROM `variant`");
      _db.execSQL("DELETE FROM `city`");
      _db.execSQL("DELETE FROM `bpaddr`");
      _db.execSQL("DELETE FROM `province`");
      _db.execSQL("DELETE FROM `district`");
      _db.execSQL("DELETE FROM `pmtd`");
      _db.execSQL("DELETE FROM `unit`");
      _db.execSQL("DELETE FROM `cmp`");
      _db.execSQL("DELETE FROM `crc`");
      _db.execSQL("DELETE FROM `city_populer`");
      _db.execSQL("DELETE FROM `stock`");
      _db.execSQL("DELETE FROM `wh`");
      _db.execSQL("DELETE FROM `saleaddon`");
      _db.execSQL("DELETE FROM `saleaddond`");
      _db.execSQL("DELETE FROM `item_dummy`");
      _db.execSQL("DELETE FROM `unit_dummy`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(TaxDao.class, TaxDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(BranchDao.class, BranchDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CashierDao.class, CashierDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CityDao.class, CityDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ItemGroupDao.class, ItemGroupDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(BpDao.class, BpDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(BpAddrDao.class, BpAddrDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PmtdDao.class, PmtdDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ChannelDao.class, ChannelDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PriceLvlDao.class, PriceLvlDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ItemDao.class, ItemDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UnitDao.class, UnitDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PriceDao.class, PriceDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SaleDao.class, SaleDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SaledDao.class, SaledDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PossesDao.class, PossesDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CstrDao.class, CstrDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PrinterDao.class, PrinterDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PrinterKitchenDao.class, PrinterKitchenDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PrinterKitchenDDao.class, PrinterKitchenDDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(KitchenDao.class, KitchenDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CrcDao.class, CrcDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CmpDao.class, CmpDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ItemSaleTaxDao.class, ItemSaleTaxDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ItemKitchenDao.class, ItemKitchenDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ItemBranchDao.class, ItemBranchDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AddOnDao.class, AddOnDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AddOnDDao.class, AddOnDDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ItemAddOnDao.class, ItemAddOnDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SelectionDao.class, SelectionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SelectionDDao.class, SelectionDDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ItemVariantDao.class, ItemVariantDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(VariantDao.class, VariantDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(RegDao.class, RegDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PromoDao.class, PromoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EdcDao.class, EdcDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EdcSurcDao.class, EdcSurcDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CcTypeDao.class, CcTypeDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(GrpPrvDao.class, GrpPrvDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UsrGrpDao.class, UsrGrpDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CityPopulerDao.class, CityPopulerDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ProvinceDao.class, ProvinceDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(RegencyDao.class, RegencyDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DistrictDao.class, DistrictDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CashDao.class, CashDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CashADao.class, CashADao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SaleCrcvDao.class, SaleCrcvDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(StockDao.class, StockDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(WhDao.class, WhDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SaleAddOnDao.class, SaleAddOnDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SaleAddOnDDao.class, SaleAddOnDDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ItemDummyDao.class, ItemDummyDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UnitDummyDao.class, UnitDummyDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public TaxDao getTaxDao() {
    if (_taxDao != null) {
      return _taxDao;
    } else {
      synchronized(this) {
        if(_taxDao == null) {
          _taxDao = new TaxDao_Impl(this);
        }
        return _taxDao;
      }
    }
  }

  @Override
  public BranchDao getBranchDao() {
    if (_branchDao != null) {
      return _branchDao;
    } else {
      synchronized(this) {
        if(_branchDao == null) {
          _branchDao = new BranchDao_Impl(this);
        }
        return _branchDao;
      }
    }
  }

  @Override
  public CashierDao getCashierDao() {
    if (_cashierDao != null) {
      return _cashierDao;
    } else {
      synchronized(this) {
        if(_cashierDao == null) {
          _cashierDao = new CashierDao_Impl(this);
        }
        return _cashierDao;
      }
    }
  }

  @Override
  public UserDao getUserDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public CityDao getCityDao() {
    if (_cityDao != null) {
      return _cityDao;
    } else {
      synchronized(this) {
        if(_cityDao == null) {
          _cityDao = new CityDao_Impl(this);
        }
        return _cityDao;
      }
    }
  }

  @Override
  public ItemGroupDao getItemGroupDao() {
    if (_itemGroupDao != null) {
      return _itemGroupDao;
    } else {
      synchronized(this) {
        if(_itemGroupDao == null) {
          _itemGroupDao = new ItemGroupDao_Impl(this);
        }
        return _itemGroupDao;
      }
    }
  }

  @Override
  public BpDao getBpDao() {
    if (_bpDao != null) {
      return _bpDao;
    } else {
      synchronized(this) {
        if(_bpDao == null) {
          _bpDao = new BpDao_Impl(this);
        }
        return _bpDao;
      }
    }
  }

  @Override
  public BpAddrDao getBpAddrDao() {
    if (_bpAddrDao != null) {
      return _bpAddrDao;
    } else {
      synchronized(this) {
        if(_bpAddrDao == null) {
          _bpAddrDao = new BpAddrDao_Impl(this);
        }
        return _bpAddrDao;
      }
    }
  }

  @Override
  public PmtdDao getPmtdDao() {
    if (_pmtdDao != null) {
      return _pmtdDao;
    } else {
      synchronized(this) {
        if(_pmtdDao == null) {
          _pmtdDao = new PmtdDao_Impl(this);
        }
        return _pmtdDao;
      }
    }
  }

  @Override
  public ChannelDao getChannelDao() {
    if (_channelDao != null) {
      return _channelDao;
    } else {
      synchronized(this) {
        if(_channelDao == null) {
          _channelDao = new ChannelDao_Impl(this);
        }
        return _channelDao;
      }
    }
  }

  @Override
  public PriceLvlDao getPriceLvlDao() {
    if (_priceLvlDao != null) {
      return _priceLvlDao;
    } else {
      synchronized(this) {
        if(_priceLvlDao == null) {
          _priceLvlDao = new PriceLvlDao_Impl(this);
        }
        return _priceLvlDao;
      }
    }
  }

  @Override
  public ItemDao getItemDao() {
    if (_itemDao != null) {
      return _itemDao;
    } else {
      synchronized(this) {
        if(_itemDao == null) {
          _itemDao = new ItemDao_Impl(this);
        }
        return _itemDao;
      }
    }
  }

  @Override
  public UnitDao getUnitDao() {
    if (_unitDao != null) {
      return _unitDao;
    } else {
      synchronized(this) {
        if(_unitDao == null) {
          _unitDao = new UnitDao_Impl(this);
        }
        return _unitDao;
      }
    }
  }

  @Override
  public PriceDao getPriceDao() {
    if (_priceDao != null) {
      return _priceDao;
    } else {
      synchronized(this) {
        if(_priceDao == null) {
          _priceDao = new PriceDao_Impl(this);
        }
        return _priceDao;
      }
    }
  }

  @Override
  public SaleDao getSaleDao() {
    if (_saleDao != null) {
      return _saleDao;
    } else {
      synchronized(this) {
        if(_saleDao == null) {
          _saleDao = new SaleDao_Impl(this);
        }
        return _saleDao;
      }
    }
  }

  @Override
  public SaledDao getSaledDao() {
    if (_saledDao != null) {
      return _saledDao;
    } else {
      synchronized(this) {
        if(_saledDao == null) {
          _saledDao = new SaledDao_Impl(this);
        }
        return _saledDao;
      }
    }
  }

  @Override
  public PossesDao getPossesDao() {
    if (_possesDao != null) {
      return _possesDao;
    } else {
      synchronized(this) {
        if(_possesDao == null) {
          _possesDao = new PossesDao_Impl(this);
        }
        return _possesDao;
      }
    }
  }

  @Override
  public CstrDao getCstrDao() {
    if (_cstrDao != null) {
      return _cstrDao;
    } else {
      synchronized(this) {
        if(_cstrDao == null) {
          _cstrDao = new CstrDao_Impl(this);
        }
        return _cstrDao;
      }
    }
  }

  @Override
  public PrinterDao getPrinterDao() {
    if (_printerDao != null) {
      return _printerDao;
    } else {
      synchronized(this) {
        if(_printerDao == null) {
          _printerDao = new PrinterDao_Impl(this);
        }
        return _printerDao;
      }
    }
  }

  @Override
  public PrinterKitchenDao getPrinterKitchenDao() {
    if (_printerKitchenDao != null) {
      return _printerKitchenDao;
    } else {
      synchronized(this) {
        if(_printerKitchenDao == null) {
          _printerKitchenDao = new PrinterKitchenDao_Impl(this);
        }
        return _printerKitchenDao;
      }
    }
  }

  @Override
  public PrinterKitchenDDao getPrinterKitchenDDao() {
    if (_printerKitchenDDao != null) {
      return _printerKitchenDDao;
    } else {
      synchronized(this) {
        if(_printerKitchenDDao == null) {
          _printerKitchenDDao = new PrinterKitchenDDao_Impl(this);
        }
        return _printerKitchenDDao;
      }
    }
  }

  @Override
  public KitchenDao getKitchenDao() {
    if (_kitchenDao != null) {
      return _kitchenDao;
    } else {
      synchronized(this) {
        if(_kitchenDao == null) {
          _kitchenDao = new KitchenDao_Impl(this);
        }
        return _kitchenDao;
      }
    }
  }

  @Override
  public CrcDao getCrcDao() {
    if (_crcDao != null) {
      return _crcDao;
    } else {
      synchronized(this) {
        if(_crcDao == null) {
          _crcDao = new CrcDao_Impl(this);
        }
        return _crcDao;
      }
    }
  }

  @Override
  public CmpDao getCmpDao() {
    if (_cmpDao != null) {
      return _cmpDao;
    } else {
      synchronized(this) {
        if(_cmpDao == null) {
          _cmpDao = new CmpDao_Impl(this);
        }
        return _cmpDao;
      }
    }
  }

  @Override
  public ItemSaleTaxDao getItemSaleTaxDao() {
    if (_itemSaleTaxDao != null) {
      return _itemSaleTaxDao;
    } else {
      synchronized(this) {
        if(_itemSaleTaxDao == null) {
          _itemSaleTaxDao = new ItemSaleTaxDao_Impl(this);
        }
        return _itemSaleTaxDao;
      }
    }
  }

  @Override
  public ItemKitchenDao getItemKitchenDao() {
    if (_itemKitchenDao != null) {
      return _itemKitchenDao;
    } else {
      synchronized(this) {
        if(_itemKitchenDao == null) {
          _itemKitchenDao = new ItemKitchenDao_Impl(this);
        }
        return _itemKitchenDao;
      }
    }
  }

  @Override
  public ItemBranchDao getItemBranchDao() {
    if (_itemBranchDao != null) {
      return _itemBranchDao;
    } else {
      synchronized(this) {
        if(_itemBranchDao == null) {
          _itemBranchDao = new ItemBranchDao_Impl(this);
        }
        return _itemBranchDao;
      }
    }
  }

  @Override
  public AddOnDao getAddOnDao() {
    if (_addOnDao != null) {
      return _addOnDao;
    } else {
      synchronized(this) {
        if(_addOnDao == null) {
          _addOnDao = new AddOnDao_Impl(this);
        }
        return _addOnDao;
      }
    }
  }

  @Override
  public AddOnDDao getAddOnDDao() {
    if (_addOnDDao != null) {
      return _addOnDDao;
    } else {
      synchronized(this) {
        if(_addOnDDao == null) {
          _addOnDDao = new AddOnDDao_Impl(this);
        }
        return _addOnDDao;
      }
    }
  }

  @Override
  public ItemAddOnDao getItemAddOnDao() {
    if (_itemAddOnDao != null) {
      return _itemAddOnDao;
    } else {
      synchronized(this) {
        if(_itemAddOnDao == null) {
          _itemAddOnDao = new ItemAddOnDao_Impl(this);
        }
        return _itemAddOnDao;
      }
    }
  }

  @Override
  public SelectionDao getSelectionDao() {
    if (_selectionDao != null) {
      return _selectionDao;
    } else {
      synchronized(this) {
        if(_selectionDao == null) {
          _selectionDao = new SelectionDao_Impl(this);
        }
        return _selectionDao;
      }
    }
  }

  @Override
  public SelectionDDao getSelectionDDao() {
    if (_selectionDDao != null) {
      return _selectionDDao;
    } else {
      synchronized(this) {
        if(_selectionDDao == null) {
          _selectionDDao = new SelectionDDao_Impl(this);
        }
        return _selectionDDao;
      }
    }
  }

  @Override
  public ItemVariantDao getItemVariantDao() {
    if (_itemVariantDao != null) {
      return _itemVariantDao;
    } else {
      synchronized(this) {
        if(_itemVariantDao == null) {
          _itemVariantDao = new ItemVariantDao_Impl(this);
        }
        return _itemVariantDao;
      }
    }
  }

  @Override
  public VariantDao getVariantDao() {
    if (_variantDao != null) {
      return _variantDao;
    } else {
      synchronized(this) {
        if(_variantDao == null) {
          _variantDao = new VariantDao_Impl(this);
        }
        return _variantDao;
      }
    }
  }

  @Override
  public RegDao getRegDao() {
    if (_regDao != null) {
      return _regDao;
    } else {
      synchronized(this) {
        if(_regDao == null) {
          _regDao = new RegDao_Impl(this);
        }
        return _regDao;
      }
    }
  }

  @Override
  public PromoDao getPromoDao() {
    if (_promoDao != null) {
      return _promoDao;
    } else {
      synchronized(this) {
        if(_promoDao == null) {
          _promoDao = new PromoDao_Impl(this);
        }
        return _promoDao;
      }
    }
  }

  @Override
  public EdcDao getEdcDao() {
    if (_edcDao != null) {
      return _edcDao;
    } else {
      synchronized(this) {
        if(_edcDao == null) {
          _edcDao = new EdcDao_Impl(this);
        }
        return _edcDao;
      }
    }
  }

  @Override
  public EdcSurcDao getEdcSurcDao() {
    if (_edcSurcDao != null) {
      return _edcSurcDao;
    } else {
      synchronized(this) {
        if(_edcSurcDao == null) {
          _edcSurcDao = new EdcSurcDao_Impl(this);
        }
        return _edcSurcDao;
      }
    }
  }

  @Override
  public CcTypeDao getCcTypeDao() {
    if (_ccTypeDao != null) {
      return _ccTypeDao;
    } else {
      synchronized(this) {
        if(_ccTypeDao == null) {
          _ccTypeDao = new CcTypeDao_Impl(this);
        }
        return _ccTypeDao;
      }
    }
  }

  @Override
  public GrpPrvDao getGrpPrvDao() {
    if (_grpPrvDao != null) {
      return _grpPrvDao;
    } else {
      synchronized(this) {
        if(_grpPrvDao == null) {
          _grpPrvDao = new GrpPrvDao_Impl(this);
        }
        return _grpPrvDao;
      }
    }
  }

  @Override
  public UsrGrpDao getUsrGrpDao() {
    if (_usrGrpDao != null) {
      return _usrGrpDao;
    } else {
      synchronized(this) {
        if(_usrGrpDao == null) {
          _usrGrpDao = new UsrGrpDao_Impl(this);
        }
        return _usrGrpDao;
      }
    }
  }

  @Override
  public CityPopulerDao getCityPopulerDao() {
    if (_cityPopulerDao != null) {
      return _cityPopulerDao;
    } else {
      synchronized(this) {
        if(_cityPopulerDao == null) {
          _cityPopulerDao = new CityPopulerDao_Impl(this);
        }
        return _cityPopulerDao;
      }
    }
  }

  @Override
  public ProvinceDao getProvinceDao() {
    if (_provinceDao != null) {
      return _provinceDao;
    } else {
      synchronized(this) {
        if(_provinceDao == null) {
          _provinceDao = new ProvinceDao_Impl(this);
        }
        return _provinceDao;
      }
    }
  }

  @Override
  public RegencyDao getRegencyDao() {
    if (_regencyDao != null) {
      return _regencyDao;
    } else {
      synchronized(this) {
        if(_regencyDao == null) {
          _regencyDao = new RegencyDao_Impl(this);
        }
        return _regencyDao;
      }
    }
  }

  @Override
  public DistrictDao getDistrictDao() {
    if (_districtDao != null) {
      return _districtDao;
    } else {
      synchronized(this) {
        if(_districtDao == null) {
          _districtDao = new DistrictDao_Impl(this);
        }
        return _districtDao;
      }
    }
  }

  @Override
  public CashDao getCashDao() {
    if (_cashDao != null) {
      return _cashDao;
    } else {
      synchronized(this) {
        if(_cashDao == null) {
          _cashDao = new CashDao_Impl(this);
        }
        return _cashDao;
      }
    }
  }

  @Override
  public CashADao getCashADao() {
    if (_cashADao != null) {
      return _cashADao;
    } else {
      synchronized(this) {
        if(_cashADao == null) {
          _cashADao = new CashADao_Impl(this);
        }
        return _cashADao;
      }
    }
  }

  @Override
  public SaleCrcvDao getSaleCrcvDao() {
    if (_saleCrcvDao != null) {
      return _saleCrcvDao;
    } else {
      synchronized(this) {
        if(_saleCrcvDao == null) {
          _saleCrcvDao = new SaleCrcvDao_Impl(this);
        }
        return _saleCrcvDao;
      }
    }
  }

  @Override
  public StockDao getStockDao() {
    if (_stockDao != null) {
      return _stockDao;
    } else {
      synchronized(this) {
        if(_stockDao == null) {
          _stockDao = new StockDao_Impl(this);
        }
        return _stockDao;
      }
    }
  }

  @Override
  public WhDao getWhDao() {
    if (_whDao != null) {
      return _whDao;
    } else {
      synchronized(this) {
        if(_whDao == null) {
          _whDao = new WhDao_Impl(this);
        }
        return _whDao;
      }
    }
  }

  @Override
  public SaleAddOnDao getSaleAddOnDao() {
    if (_saleAddOnDao != null) {
      return _saleAddOnDao;
    } else {
      synchronized(this) {
        if(_saleAddOnDao == null) {
          _saleAddOnDao = new SaleAddOnDao_Impl(this);
        }
        return _saleAddOnDao;
      }
    }
  }

  @Override
  public SaleAddOnDDao getSaleAddOnDDao() {
    if (_saleAddOnDDao != null) {
      return _saleAddOnDDao;
    } else {
      synchronized(this) {
        if(_saleAddOnDDao == null) {
          _saleAddOnDDao = new SaleAddOnDDao_Impl(this);
        }
        return _saleAddOnDDao;
      }
    }
  }

  @Override
  public ItemDummyDao getItemDummyDao() {
    if (_itemDummyDao != null) {
      return _itemDummyDao;
    } else {
      synchronized(this) {
        if(_itemDummyDao == null) {
          _itemDummyDao = new ItemDummyDao_Impl(this);
        }
        return _itemDummyDao;
      }
    }
  }

  @Override
  public UnitDummyDao getUnitDummyDao() {
    if (_unitDummyDao != null) {
      return _unitDummyDao;
    } else {
      synchronized(this) {
        if(_unitDummyDao == null) {
          _unitDummyDao = new UnitDummyDao_Impl(this);
        }
        return _unitDummyDao;
      }
    }
  }
}
