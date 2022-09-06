package com.bits.bee.bpmc.utils;

import java.lang.System;

/**
 * Created by aldi on 10/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/utils/TrxNoGeneratorUtils;", "", "context", "Landroid/content/Context;", "getActiveBranchUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;", "getActiveCashierUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveCashierUseCase;", "(Landroid/content/Context;Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveCashierUseCase;)V", "Companion", "app_debug"})
@javax.inject.Singleton()
public final class TrxNoGeneratorUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.utils.TrxNoGeneratorUtils.Companion Companion = null;
    private static final java.text.SimpleDateFormat dateFormat = null;
    private static final java.text.SimpleDateFormat hourFormat = null;
    private static final java.text.SimpleDateFormat minuteFormat = null;
    
    @javax.inject.Inject()
    public TrxNoGeneratorUtils(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase getActiveCashierUseCase) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/bits/bee/bpmc/utils/TrxNoGeneratorUtils$Companion;", "", "()V", "dateFormat", "Ljava/text/SimpleDateFormat;", "hourFormat", "minuteFormat", "counterNoTrx", "", "mCounterNoTrx", "", "branch", "Lcom/bits/bee/bpmc/domain/model/Branch;", "cashier", "Lcom/bits/bee/bpmc/domain/model/Cashier;", "counterNoTrxCadj", "id_cashA", "", "counterNoTrxCstr", "id_cstr", "generatePossesTrxNo", "mCounterShift", "mBranch", "mCashier", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String generatePossesTrxNo(int mCounterShift, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Branch mBranch, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Cashier mCashier) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String counterNoTrx(int mCounterNoTrx, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Branch branch, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Cashier cashier) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String counterNoTrxCadj(long id_cashA, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Branch branch, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Cashier cashier) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String counterNoTrxCstr(int id_cstr, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Branch branch, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Cashier cashier) {
            return null;
        }
    }
}