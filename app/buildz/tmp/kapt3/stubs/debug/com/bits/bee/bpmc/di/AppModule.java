package com.bits.bee.bpmc.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00da\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u001bH\u0007J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020$H\u0007J \u0010%\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\'2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010(\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020*2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010+\u001a\u00020,2\u0006\u0010\u0007\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010.\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u000200H\u0007J \u00101\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\fH\u0007J \u00106\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00103\u001a\u0002082\u0006\u00105\u001a\u00020\fH\u0007J\u0018\u00109\u001a\u00020:2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u00105\u001a\u00020\fH\u0007J\u0018\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u00105\u001a\u00020\fH\u0007J \u0010C\u001a\u00020D2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010E\u001a\u00020FH\u0007J\u0018\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010O\u001a\u00020P2\u0006\u0010M\u001a\u00020Q2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u00105\u001a\u00020\fH\u0007J\b\u0010V\u001a\u00020\fH\u0007J \u0010W\u001a\u00020X2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020Z2\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010[\u001a\u00020\\2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010E\u001a\u00020]H\u0007J \u0010^\u001a\u00020_2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010E\u001a\u00020`H\u0007JH\u0010a\u001a\u00020b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010c\u001a\u00020N2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020Q2\u0006\u0010m\u001a\u00020nH\u0007J \u0010o\u001a\u00020p2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00103\u001a\u00020q2\u0006\u00105\u001a\u00020\fH\u0007J \u0010r\u001a\u00020s2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010E\u001a\u00020tH\u0007J\u0018\u0010u\u001a\u00020v2\u0006\u00103\u001a\u00020w2\u0006\u00105\u001a\u00020\fH\u0007J \u0010x\u001a\u00020y2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010z\u001a\u00020{H\u0007J \u0010|\u001a\u00020}2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010E\u001a\u00020~H\u0007J\"\u0010\u007f\u001a\u00030\u0080\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0007\u00103\u001a\u00030\u0081\u00012\u0006\u00105\u001a\u00020\fH\u0007J\u001c\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0007J>\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0007\u00103\u001a\u00030\u0088\u00012\u0007\u0010\u0089\u0001\u001a\u00020]2\u0007\u0010\u008a\u0001\u001a\u00020`2\u0007\u0010\u008b\u0001\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\fH\u0007J\u001c\u0010\u008c\u0001\u001a\u00030\u008d\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0006\u00105\u001a\u00020\fH\u0007J\u001c\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001c\u0010\u0094\u0001\u001a\u00030\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001c\u0010\u0098\u0001\u001a\u00030\u0099\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0007J#\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0007\u00103\u001a\u00030\u009e\u00012\u0006\u00105\u001a\u00020\fH\u0007J$\u0010\u009f\u0001\u001a\u00030\u00a0\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u00a1\u0001\u001a\u00030\u00a2\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0007J$\u0010\u00a3\u0001\u001a\u00030\u00a4\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u00a5\u0001\u001a\u00030\u00a6\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001b\u0010\u00a7\u0001\u001a\u00030\u00a8\u00012\u0007\u00103\u001a\u00030\u00a9\u00012\u0006\u00105\u001a\u00020\fH\u0007J#\u0010\u00aa\u0001\u001a\u00030\u00ab\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0007\u00103\u001a\u00030\u00ac\u00012\u0006\u00105\u001a\u00020\fH\u0007J#\u0010\u00ad\u0001\u001a\u00030\u00ae\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0007\u00103\u001a\u00030\u00af\u00012\u0006\u00105\u001a\u00020\fH\u0007J\u0012\u0010\u00b0\u0001\u001a\u00030\u00b1\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001b\u0010\u00b2\u0001\u001a\u00030\u00b3\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0007\u00103\u001a\u00030\u00b4\u0001H\u0007J\u001b\u0010\u00b5\u0001\u001a\u00030\u00b6\u00012\u0007\u00103\u001a\u00030\u00b7\u00012\u0006\u00105\u001a\u00020\fH\u0007J#\u0010\u00b8\u0001\u001a\u00030\u00b9\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0007\u00103\u001a\u00030\u00ba\u00012\u0006\u00105\u001a\u00020\fH\u0007J\u001a\u0010\u00bb\u0001\u001a\u00030\u00bc\u00012\u0006\u0010M\u001a\u00020g2\u0006\u0010\u000b\u001a\u00020\fH\u0007J+\u0010\u00bd\u0001\u001a\u00030\u00be\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0007\u00103\u001a\u00030\u00bf\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\fH\u0007J\"\u0010\u00c0\u0001\u001a\u00030\u00c1\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00103\u001a\u00020n2\u0006\u00105\u001a\u00020\fH\u0007\u00a8\u0006\u00c2\u0001"}, d2 = {"Lcom/bits/bee/bpmc/di/AppModule;", "", "()V", "proivdeBpRepository", "Lcom/bits/bee/bpmc/domain/repository/BpRepository;", "apiUtils", "Lcom/bits/bee/bpmc/data/data_source/remote/ApiUtils;", "dao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/BpDao;", "bpAddrDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/BpAddrDao;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "proivdeBranchRepository", "Lcom/bits/bee/bpmc/domain/repository/BranchRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/BranchDao;", "proivdeCashierRepository", "Lcom/bits/bee/bpmc/domain/repository/CashierRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CashierDao;", "proivdeChannelRepository", "Lcom/bits/bee/bpmc/domain/repository/ChannelRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ChannelDao;", "proivdeCityRepository", "Lcom/bits/bee/bpmc/domain/repository/CityRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CityDao;", "proivdeItemGroupRepository", "Lcom/bits/bee/bpmc/domain/repository/ItemGroupRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemGroupDao;", "proivdeItemRepository", "Lcom/bits/bee/bpmc/domain/repository/ItemRepository;", "itemDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemDao;", "proivdeLoginRepository", "Lcom/bits/bee/bpmc/domain/repository/LoginRepository;", "proivdePriceLvlRepository", "Lcom/bits/bee/bpmc/domain/repository/PriceLvlRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PriceLvlDao;", "proivdePriceRepository", "Lcom/bits/bee/bpmc/domain/repository/PriceRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PriceDao;", "proivdeSaleRepository", "Lcom/bits/bee/bpmc/domain/repository/SaleRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleDao;", "proivdeSaledRepository", "Lcom/bits/bee/bpmc/domain/repository/SaledRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaledDao;", "proivdeTaxRepository", "Lcom/bits/bee/bpmc/domain/repository/TaxRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/TaxDao;", "provideAddOnDRepository", "Lcom/bits/bee/bpmc/domain/repository/AddOnDRepository;", "saleCrcvDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/AddOnDDao;", "dispatcher", "provideAddOnRepository", "Lcom/bits/bee/bpmc/domain/repository/AddOnRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/AddOnDao;", "provideBpaddrRepository", "Lcom/bits/bee/bpmc/domain/repository/BpAddrRepository;", "provideCashARepository", "Lcom/bits/bee/bpmc/domain/repository/CashARepository;", "cashADao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CashADao;", "provideCashRepository", "Lcom/bits/bee/bpmc/domain/repository/CashRepository;", "cashDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CashDao;", "provideCcTypeRepository", "Lcom/bits/bee/bpmc/domain/repository/CcTypeRepository;", "itemBranchDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CcTypeDao;", "provideCityPopulerRespository", "Lcom/bits/bee/bpmc/domain/repository/CityPopulerRepository;", "cityPopulerDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CityPopulerDao;", "provideCmpRepository", "Lcom/bits/bee/bpmc/domain/repository/CmpRepository;", "operatorDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CmpDao;", "provideCrcRepository", "Lcom/bits/bee/bpmc/domain/repository/CrcRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CrcDao;", "provideCstrRepository", "Lcom/bits/bee/bpmc/domain/repository/CstrRepository;", "cstrDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CstrDao;", "provideDispatcher", "provideDistrictRepository", "Lcom/bits/bee/bpmc/domain/repository/DistrictRepository;", "districtDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/DistrictDao;", "provideEdcRepository", "Lcom/bits/bee/bpmc/domain/repository/EdcRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/EdcDao;", "provideEdcSurcRepository", "Lcom/bits/bee/bpmc/domain/repository/EdcSurcRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/EdcSurcDao;", "provideInitialRepository", "Lcom/bits/bee/bpmc/domain/repository/InitialRepository;", "cmpDao", "regDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/RegDao;", "userDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UserDao;", "usrGrpDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UsrGrpDao;", "grpPrvDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/GrpPrvDao;", "crcDao", "whDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/WhDao;", "provideItemAddOnRepository", "Lcom/bits/bee/bpmc/domain/repository/ItemAddOnRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemAddOnDao;", "provideItemBranchRepository", "Lcom/bits/bee/bpmc/domain/repository/ItemBranchRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemBranchDao;", "provideItemDummyRepository", "Lcom/bits/bee/bpmc/domain/repository/ItemDummyRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemDummyDao;", "provideItemKitchenRepository", "Lcom/bits/bee/bpmc/domain/repository/ItemKitchenRepository;", "itemKitchenDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemKitchenDao;", "provideItemSaleTaxRepository", "Lcom/bits/bee/bpmc/domain/repository/ItemSaleTaxRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemSaleTaxDao;", "provideItemVariantRepository", "Lcom/bits/bee/bpmc/domain/repository/ItemVariantRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemVariantDao;", "provideKitchenRepository", "Lcom/bits/bee/bpmc/domain/repository/KitchenRepository;", "kitchenDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/KitchenDao;", "providePmtdRepository", "Lcom/bits/bee/bpmc/domain/repository/PmtdRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PmtdDao;", "edcDao", "edcSurcDao", "branchDao", "providePossesRepository", "Lcom/bits/bee/bpmc/domain/repository/PossesRepository;", "possesDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PossesDao;", "providePrinterKitchenDRepository", "Lcom/bits/bee/bpmc/domain/repository/PrinterKitchenDRepository;", "printerKitchenDDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PrinterKitchenDDao;", "providePrinterKitchenRepository", "Lcom/bits/bee/bpmc/domain/repository/PrinterKitchenRepository;", "printerKitchenDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PrinterKitchenDao;", "providePrinterRepository", "Lcom/bits/bee/bpmc/domain/repository/PrinterRespository;", "printerDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PrinterDao;", "providePromoRepository", "Lcom/bits/bee/bpmc/domain/repository/PromoRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/PromoDao;", "provideProvinceRepository", "Lcom/bits/bee/bpmc/domain/repository/ProvinceRepository;", "provinceDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ProvinceDao;", "provideRegencyRepository", "Lcom/bits/bee/bpmc/domain/repository/RegencyRepository;", "regencyDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/RegencyDao;", "provideSaleCrcvRepository", "Lcom/bits/bee/bpmc/domain/repository/SaleCrcvRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleCrcvDao;", "provideSelectionDRepository", "Lcom/bits/bee/bpmc/domain/repository/SelectionDRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SelectionDDao;", "provideSelectionRepository", "Lcom/bits/bee/bpmc/domain/repository/SelectionRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SelectionDao;", "provideSignUpRepository", "Lcom/bits/bee/bpmc/domain/repository/SignUpRepository;", "provideStockRepository", "Lcom/bits/bee/bpmc/domain/repository/StockRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/StockDao;", "provideUnitDummyRepository", "Lcom/bits/bee/bpmc/domain/repository/UnitDummyRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UnitDummyDao;", "provideUnitRepository", "Lcom/bits/bee/bpmc/domain/repository/UnitRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/UnitDao;", "provideUserRepository", "Lcom/bits/bee/bpmc/domain/repository/UserRepository;", "provideVariantRepository", "Lcom/bits/bee/bpmc/domain/repository/VariantRepository;", "Lcom/bits/bee/bpmc/data/data_source/local/dao/VariantDao;", "provideWhRepository", "Lcom/bits/bee/bpmc/domain/repository/WhRepository;", "app_debug"})
@dagger.Module()
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final kotlinx.coroutines.CoroutineDispatcher provideDispatcher() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.BpRepository proivdeBpRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.BpDao dao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.BpAddrDao bpAddrDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.BranchRepository proivdeBranchRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.BranchDao dao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.CashierRepository proivdeCashierRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CashierDao dao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.ItemGroupRepository proivdeItemGroupRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.ItemGroupDao dao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.LoginRepository proivdeLoginRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.PriceLvlRepository proivdePriceLvlRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.PriceLvlDao dao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.TaxRepository proivdeTaxRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.TaxDao dao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.ChannelRepository proivdeChannelRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.ChannelDao dao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.ItemRepository proivdeItemRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.ItemDao itemDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.PriceRepository proivdePriceRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.PriceDao dao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.PrinterRespository providePrinterRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.PrinterDao printerDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository providePrinterKitchenRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDao printerKitchenDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository providePrinterKitchenDRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDDao printerKitchenDDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.CityRepository proivdeCityRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CityDao dao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.SaleRepository proivdeSaleRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.SaleDao dao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.SaledRepository proivdeSaledRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.SaledDao dao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.PossesRepository providePossesRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.PossesDao possesDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.KitchenRepository provideKitchenRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.KitchenDao kitchenDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.UserRepository provideUserRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.UserDao operatorDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.CityPopulerRepository provideCityPopulerRespository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CityPopulerDao cityPopulerDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.CrcRepository provideCrcRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CrcDao operatorDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.BpAddrRepository provideBpaddrRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.BpAddrDao bpAddrDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.CmpRepository provideCmpRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CmpDao operatorDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.ProvinceRepository provideProvinceRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.ProvinceDao provinceDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.RegencyRepository provideRegencyRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.RegencyDao regencyDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.DistrictRepository provideDistrictRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.DistrictDao districtDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.InitialRepository provideInitialRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CmpDao cmpDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.RegDao regDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.UsrGrpDao usrGrpDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.GrpPrvDao grpPrvDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CrcDao crcDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.WhDao whDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.ItemKitchenRepository provideItemKitchenRepository(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.ItemKitchenDao itemKitchenDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.ItemBranchRepository provideItemBranchRepository(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.ItemBranchDao itemBranchDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.ItemSaleTaxRepository provideItemSaleTaxRepository(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.ItemSaleTaxDao itemBranchDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.EdcRepository provideEdcRepository(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.EdcDao itemBranchDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.EdcSurcRepository provideEdcSurcRepository(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.EdcSurcDao itemBranchDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.CcTypeRepository provideCcTypeRepository(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CcTypeDao itemBranchDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.CashRepository provideCashRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CashDao cashDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.CashARepository provideCashARepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CashADao cashADao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.CstrRepository provideCstrRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CstrDao cstrDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.SaleCrcvRepository provideSaleCrcvRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.SaleCrcvDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.PmtdRepository providePmtdRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.PmtdDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.EdcDao edcDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.EdcSurcDao edcSurcDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.BranchDao branchDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.StockRepository provideStockRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.StockDao saleCrcvDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.WhRepository provideWhRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.WhDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.UnitRepository provideUnitRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.UnitDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.AddOnRepository provideAddOnRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.AddOnDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.AddOnDRepository provideAddOnDRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.AddOnDDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.ItemAddOnRepository provideItemAddOnRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.ItemAddOnDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.SelectionRepository provideSelectionRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.SelectionDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.SelectionDRepository provideSelectionDRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.SelectionDDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.VariantRepository provideVariantRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.VariantDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.ItemDao itemDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.ItemVariantRepository provideItemVariantRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.ItemVariantDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.PromoRepository providePromoRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.PromoDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.SignUpRepository provideSignUpRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.ItemDummyRepository provideItemDummyRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.ItemDummyDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.bits.bee.bpmc.domain.repository.UnitDummyRepository provideUnitDummyRepository(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.UnitDummyDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
}