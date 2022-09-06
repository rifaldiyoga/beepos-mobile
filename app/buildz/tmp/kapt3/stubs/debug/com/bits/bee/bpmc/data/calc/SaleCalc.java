package com.bits.bee.bpmc.data.calc;

import java.lang.System;

/**
 * Created by aldi on 19/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/bits/bee/bpmc/data/calc/SaleCalc;", "", "()V", "Companion", "app_debug"})
public final class SaleCalc {
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.calc.SaleCalc.Companion Companion = null;
    
    public SaleCalc() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\r\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0002\u00a8\u0006\u0018"}, d2 = {"Lcom/bits/bee/bpmc/data/calc/SaleCalc$Companion;", "", "()V", "calculate", "", "sale", "Lcom/bits/bee/bpmc/domain/model/Sale;", "saledList", "", "Lcom/bits/bee/bpmc/domain/model/Saled;", "bp", "Lcom/bits/bee/bpmc/domain/model/Bp;", "calculateSubtotal", "clearCalculate", "", "intToString", "", "digits", "", "roundingTotal", "Ljava/math/BigDecimal;", "total", "roundDigits", "minRound", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void calculate(@org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.domain.model.Saled> saledList, @org.jetbrains.annotations.NotNull()
        com.bits.bee.bpmc.domain.model.Bp bp) {
        }
        
        private final void calculateSubtotal(com.bits.bee.bpmc.domain.model.Sale sale, java.util.List<com.bits.bee.bpmc.domain.model.Saled> saledList, com.bits.bee.bpmc.domain.model.Bp bp) {
        }
        
        public final void clearCalculate(@org.jetbrains.annotations.NotNull()
        java.util.List<com.bits.bee.bpmc.domain.model.Saled> saledList) {
        }
        
        /**
         * @param total = Total Sale sebelum rounding
         * @param roundDigits
         * @param minRound = Rounding down below
         * @return
         */
        private final java.math.BigDecimal roundingTotal(java.math.BigDecimal total, int roundDigits, int minRound) {
            return null;
        }
        
        private final java.lang.String intToString(int digits) {
            return null;
        }
    }
}