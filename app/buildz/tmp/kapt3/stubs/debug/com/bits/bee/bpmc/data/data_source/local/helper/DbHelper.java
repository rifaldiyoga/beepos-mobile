package com.bits.bee.bpmc.data.data_source.local.helper;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.bits.bee.bpmc.data.data_source.local.converter.Converters.class})
@androidx.room.Database(entities = {com.bits.bee.bpmc.data.data_source.local.model.AddOnEntity.class, com.bits.bee.bpmc.data.data_source.local.model.AddOnDEntity.class, com.bits.bee.bpmc.data.data_source.local.model.BpEntity.class, com.bits.bee.bpmc.data.data_source.local.model.BranchEntity.class, com.bits.bee.bpmc.data.data_source.local.model.CadjEntity.class, com.bits.bee.bpmc.data.data_source.local.model.CashEntity.class, com.bits.bee.bpmc.data.data_source.local.model.CashAEntity.class, com.bits.bee.bpmc.data.data_source.local.model.CashierEntity.class, com.bits.bee.bpmc.data.data_source.local.model.CcTypeEntity.class, com.bits.bee.bpmc.data.data_source.local.model.ChannelEntity.class, com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity.class, com.bits.bee.bpmc.data.data_source.local.model.CstrEntity.class, com.bits.bee.bpmc.data.data_source.local.model.EdcEntity.class, com.bits.bee.bpmc.data.data_source.local.model.EdcSurcEntity.class, com.bits.bee.bpmc.data.data_source.local.model.GrpPrvEntity.class, com.bits.bee.bpmc.data.data_source.local.model.ItemEntity.class, com.bits.bee.bpmc.data.data_source.local.model.ItemAddOnEntity.class, com.bits.bee.bpmc.data.data_source.local.model.ItemBranchEntity.class, com.bits.bee.bpmc.data.data_source.local.model.ItemKitchenEntity.class, com.bits.bee.bpmc.data.data_source.local.model.ItemOnBoardingEntity.class, com.bits.bee.bpmc.data.data_source.local.model.PriceEntity.class, com.bits.bee.bpmc.data.data_source.local.model.ItemSaleTaxEntity.class, com.bits.bee.bpmc.data.data_source.local.model.ItemVariantEntity.class, com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity.class, com.bits.bee.bpmc.data.data_source.local.model.KitchenEntity.class, com.bits.bee.bpmc.data.data_source.local.model.LicenseEntity.class, com.bits.bee.bpmc.data.data_source.local.model.PossesEntity.class, com.bits.bee.bpmc.data.data_source.local.model.PriceLvlEntity.class, com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity.class, com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenEntity.class, com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenDEntity.class, com.bits.bee.bpmc.data.data_source.local.model.PromoEntity.class, com.bits.bee.bpmc.data.data_source.local.model.PromoMultiEntity.class, com.bits.bee.bpmc.data.data_source.local.model.RegEntity.class, com.bits.bee.bpmc.data.data_source.local.model.SaleEntity.class, com.bits.bee.bpmc.data.data_source.local.model.SaleCrcvEntity.class, com.bits.bee.bpmc.data.data_source.local.model.SalePromoEntity.class, com.bits.bee.bpmc.data.data_source.local.model.SelectionEntity.class, com.bits.bee.bpmc.data.data_source.local.model.SelectionDEntity.class, com.bits.bee.bpmc.data.data_source.local.model.SaledEntity.class, com.bits.bee.bpmc.data.data_source.local.model.SyncEntity.class, com.bits.bee.bpmc.data.data_source.local.model.TaxEntity.class, com.bits.bee.bpmc.data.data_source.local.model.UserEntity.class, com.bits.bee.bpmc.data.data_source.local.model.UsrGrpEntity.class, com.bits.bee.bpmc.data.data_source.local.model.VariantEntity.class, com.bits.bee.bpmc.data.data_source.local.model.CityEntity.class, com.bits.bee.bpmc.data.data_source.local.model.BpAddrEntity.class, com.bits.bee.bpmc.data.data_source.local.model.ProvinceEntity.class, com.bits.bee.bpmc.data.data_source.local.model.DistrictEntity.class, com.bits.bee.bpmc.data.data_source.local.model.PmtdEntity.class, com.bits.bee.bpmc.data.data_source.local.model.UnitEntity.class, com.bits.bee.bpmc.data.data_source.local.model.CmpEntity.class, com.bits.bee.bpmc.data.data_source.local.model.CrcEntity.class, com.bits.bee.bpmc.data.data_source.local.model.CityPopulerEntity.class, com.bits.bee.bpmc.data.data_source.local.model.StockEntity.class, com.bits.bee.bpmc.data.data_source.local.model.WhEntity.class, com.bits.bee.bpmc.data.data_source.local.model.SaleAddOnEntity.class, com.bits.bee.bpmc.data.data_source.local.model.SaleAddOnDEntity.class, com.bits.bee.bpmc.data.data_source.local.model.ItemDummyEntity.class, com.bits.bee.bpmc.data.data_source.local.model.UnitDummyEntity.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00bc\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000 \u00db\u00012\u00020\u0001:\u0002\u00db\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u001cX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020 X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020$X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0012\u0010\'\u001a\u00020(X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020,X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.R\u0012\u0010/\u001a\u000200X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u0012\u00103\u001a\u000204X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106R\u0012\u00107\u001a\u000208X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010:R\u0012\u0010;\u001a\u00020<X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010>R\u0012\u0010?\u001a\u00020@X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010BR\u0012\u0010C\u001a\u00020DX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010FR\u0012\u0010G\u001a\u00020HX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bI\u0010JR\u0012\u0010K\u001a\u00020LX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bM\u0010NR\u0012\u0010O\u001a\u00020PX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bQ\u0010RR\u0012\u0010S\u001a\u00020TX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bU\u0010VR\u0012\u0010W\u001a\u00020XX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bY\u0010ZR\u0012\u0010[\u001a\u00020\\X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b]\u0010^R\u0012\u0010_\u001a\u00020`X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\ba\u0010bR\u0012\u0010c\u001a\u00020dX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\be\u0010fR\u0012\u0010g\u001a\u00020hX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bi\u0010jR\u0012\u0010k\u001a\u00020lX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bm\u0010nR\u0012\u0010o\u001a\u00020pX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bq\u0010rR\u0012\u0010s\u001a\u00020tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bu\u0010vR\u0012\u0010w\u001a\u00020xX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\by\u0010zR\u0012\u0010{\u001a\u00020|X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b}\u0010~R\u0015\u0010\u007f\u001a\u00030\u0080\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\u0083\u0001\u001a\u00030\u0084\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0016\u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0016\u0010\u008b\u0001\u001a\u00030\u008c\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0016\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0016\u0010\u0093\u0001\u001a\u00030\u0094\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0016\u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0016\u0010\u009b\u0001\u001a\u00030\u009c\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0016\u0010\u009f\u0001\u001a\u00030\u00a0\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u0016\u0010\u00a3\u0001\u001a\u00030\u00a4\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u0016\u0010\u00a7\u0001\u001a\u00030\u00a8\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001R\u0016\u0010\u00ab\u0001\u001a\u00030\u00ac\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00ad\u0001\u0010\u00ae\u0001R\u0016\u0010\u00af\u0001\u001a\u00030\u00b0\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00b1\u0001\u0010\u00b2\u0001R\u0016\u0010\u00b3\u0001\u001a\u00030\u00b4\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00b5\u0001\u0010\u00b6\u0001R\u0016\u0010\u00b7\u0001\u001a\u00030\u00b8\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00b9\u0001\u0010\u00ba\u0001R\u0016\u0010\u00bb\u0001\u001a\u00030\u00bc\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00bd\u0001\u0010\u00be\u0001R\u0016\u0010\u00bf\u0001\u001a\u00030\u00c0\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00c1\u0001\u0010\u00c2\u0001R\u0016\u0010\u00c3\u0001\u001a\u00030\u00c4\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00c5\u0001\u0010\u00c6\u0001R\u0016\u0010\u00c7\u0001\u001a\u00030\u00c8\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00c9\u0001\u0010\u00ca\u0001R\u0016\u0010\u00cb\u0001\u001a\u00030\u00cc\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00cd\u0001\u0010\u00ce\u0001R\u0016\u0010\u00cf\u0001\u001a\u00030\u00d0\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00d1\u0001\u0010\u00d2\u0001R\u0016\u0010\u00d3\u0001\u001a\u00030\u00d4\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00d5\u0001\u0010\u00d6\u0001R\u0016\u0010\u00d7\u0001\u001a\u00030\u00d8\u0001X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00d9\u0001\u0010\u00da\u0001\u00a8\u0006\u00dc\u0001"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/helper/DbHelper;", "Landroidx/room/RoomDatabase;", "()V", "addOnDDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/AddOnDDao;", "getAddOnDDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/AddOnDDao;", "addOnDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/AddOnDao;", "getAddOnDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/AddOnDao;", "bpAddrDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/BpAddrDao;", "getBpAddrDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/BpAddrDao;", "bpDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/BpDao;", "getBpDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/BpDao;", "branchDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/BranchDao;", "getBranchDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/BranchDao;", "cashADao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CashADao;", "getCashADao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/CashADao;", "cashDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CashDao;", "getCashDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/CashDao;", "cashierDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CashierDao;", "getCashierDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/CashierDao;", "ccTypeDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CcTypeDao;", "getCcTypeDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/CcTypeDao;", "channelDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ChannelDao;", "getChannelDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/ChannelDao;", "cityDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CityDao;", "getCityDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/CityDao;", "cityPopulerDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CityPopulerDao;", "getCityPopulerDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/CityPopulerDao;", "cmpDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CmpDao;", "getCmpDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/CmpDao;", "crcDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CrcDao;", "getCrcDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/CrcDao;", "cstrDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CstrDao;", "getCstrDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/CstrDao;", "districtDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/DistrictDao;", "getDistrictDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/DistrictDao;", "edcDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/EdcDao;", "getEdcDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/EdcDao;", "edcSurcDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/EdcSurcDao;", "getEdcSurcDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/EdcSurcDao;", "grpPrvDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/GrpPrvDao;", "getGrpPrvDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/GrpPrvDao;", "itemAddOnDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemAddOnDao;", "getItemAddOnDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemAddOnDao;", "itemBranchDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemBranchDao;", "getItemBranchDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemBranchDao;", "itemDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemDao;", "getItemDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemDao;", "itemDummyDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemDummyDao;", "getItemDummyDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemDummyDao;", "itemGroupDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemGroupDao;", "getItemGroupDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemGroupDao;", "itemKitchenDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemKitchenDao;", "getItemKitchenDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemKitchenDao;", "itemSaleTaxDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemSaleTaxDao;", "getItemSaleTaxDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemSaleTaxDao;", "itemVariantDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemVariantDao;", "getItemVariantDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemVariantDao;", "kitchenDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/KitchenDao;", "getKitchenDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/KitchenDao;", "pmtdDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PmtdDao;", "getPmtdDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/PmtdDao;", "possesDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PossesDao;", "getPossesDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/PossesDao;", "priceDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PriceDao;", "getPriceDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/PriceDao;", "priceLvlDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PriceLvlDao;", "getPriceLvlDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/PriceLvlDao;", "printerDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PrinterDao;", "getPrinterDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/PrinterDao;", "printerKitchenDDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PrinterKitchenDDao;", "getPrinterKitchenDDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/PrinterKitchenDDao;", "printerKitchenDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PrinterKitchenDao;", "getPrinterKitchenDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/PrinterKitchenDao;", "promoDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PromoDao;", "getPromoDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/PromoDao;", "provinceDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ProvinceDao;", "getProvinceDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/ProvinceDao;", "regDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/RegDao;", "getRegDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/RegDao;", "regencyDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/RegencyDao;", "getRegencyDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/RegencyDao;", "saleAddOnDDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleAddOnDDao;", "getSaleAddOnDDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleAddOnDDao;", "saleAddOnDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleAddOnDao;", "getSaleAddOnDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleAddOnDao;", "saleCrcvDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleCrcvDao;", "getSaleCrcvDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleCrcvDao;", "saleDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleDao;", "getSaleDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleDao;", "saledDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaledDao;", "getSaledDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/SaledDao;", "selectionDDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SelectionDDao;", "getSelectionDDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/SelectionDDao;", "selectionDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SelectionDao;", "getSelectionDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/SelectionDao;", "stockDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/StockDao;", "getStockDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/StockDao;", "taxDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/TaxDao;", "getTaxDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/TaxDao;", "unitDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UnitDao;", "getUnitDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/UnitDao;", "unitDummyDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UnitDummyDao;", "getUnitDummyDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/UnitDummyDao;", "userDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UserDao;", "getUserDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/UserDao;", "usrGrpDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UsrGrpDao;", "getUsrGrpDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/UsrGrpDao;", "variantDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/VariantDao;", "getVariantDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/VariantDao;", "whDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/WhDao;", "getWhDao", "()Lcom/bits/bee/bpmc/data/data_source/local/dao/WhDao;", "Companion", "app_debug"})
public abstract class DbHelper extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.helper.DbHelper.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "bpmData.db";
    
    public DbHelper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.TaxDao getTaxDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.BranchDao getBranchDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.CashierDao getCashierDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.UserDao getUserDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.CityDao getCityDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.ItemGroupDao getItemGroupDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.BpDao getBpDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.BpAddrDao getBpAddrDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.PmtdDao getPmtdDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.ChannelDao getChannelDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.PriceLvlDao getPriceLvlDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.ItemDao getItemDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.UnitDao getUnitDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.PriceDao getPriceDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.SaleDao getSaleDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.SaledDao getSaledDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.PossesDao getPossesDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.CstrDao getCstrDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.PrinterDao getPrinterDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDao getPrinterKitchenDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDDao getPrinterKitchenDDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.KitchenDao getKitchenDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.CrcDao getCrcDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.CmpDao getCmpDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.ItemSaleTaxDao getItemSaleTaxDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.ItemKitchenDao getItemKitchenDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.ItemBranchDao getItemBranchDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.AddOnDao getAddOnDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.AddOnDDao getAddOnDDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.ItemAddOnDao getItemAddOnDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.SelectionDao getSelectionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.SelectionDDao getSelectionDDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.ItemVariantDao getItemVariantDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.VariantDao getVariantDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.RegDao getRegDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.PromoDao getPromoDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.EdcDao getEdcDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.EdcSurcDao getEdcSurcDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.CcTypeDao getCcTypeDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.GrpPrvDao getGrpPrvDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.UsrGrpDao getUsrGrpDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.CityPopulerDao getCityPopulerDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.ProvinceDao getProvinceDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.RegencyDao getRegencyDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.DistrictDao getDistrictDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.CashDao getCashDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.CashADao getCashADao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.SaleCrcvDao getSaleCrcvDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.StockDao getStockDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.WhDao getWhDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.SaleAddOnDao getSaleAddOnDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.SaleAddOnDDao getSaleAddOnDDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.ItemDummyDao getItemDummyDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bits.bee.bpmc.data.data_source.local.dao.UnitDummyDao getUnitDummyDao();
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/helper/DbHelper$Companion;", "", "()V", "DATABASE_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}