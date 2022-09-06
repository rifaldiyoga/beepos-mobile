package com.bits.bee.bpmc.utils;

import java.lang.System;

/**
 * Created by aldi on 01/03/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/utils/BPMConstants;", "", "Companion", "app_debug"})
public abstract interface BPMConstants {
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.utils.BPMConstants.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BPM_DEFAULT_TYPE_POSSES = "POSSES";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BPM_DEFAULT_TYPE_SALE = "SALE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BPM_DEFAULT_TYPE_CASH = "CASH";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BPM_DEFAULT_TYPE_CADJ = "CADJ";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BPM_DEFAULT_TYPE_CSTR = "CADJ";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BPM_DEFAULT_TYPE_TUNAI = "TUNAI";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BPM_DEFAULT_TYPE_CHG = "CHG";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BPM_DEFAULT_TYPE_DEBIT = "DC";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BPM_DEFAULT_TYPE_KREDIT = "CC";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CADJ = "CADJ";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SALE = "SALE";
    public static final int BPM_LIMIT_PAGINATION = 10;
    public static final int BPM_MAX_PAGINATION = 30;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BPM_DEFAULT_TYPE_CASH_POSSES = "POSSES";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CREDIT_CARD_CODE = "CC";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DEBIT_CARD_CODE = "DC";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BPM_DEFAULT_TYPE_CASH_GOPAY = "GOPAY";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SCREEN_POTRAIT = "Portrait";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SCREEN_LANDSCAPE = "Landscape";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSSSSS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NEW_DATE_FORMAT = "dd/MM/yyyy";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MODE_FOOD_BEVERAGES = "MODE_FOOD_AND_BEVERAGES";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MODE_RETAIL = "MODE_RETAIL";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTASETTING_LOGOPATH = "NOTASETTING_LOGOPATH";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INIT_DEFAULT_LOGO = "bpm_logo1";
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/bits/bee/bpmc/utils/BPMConstants$Companion;", "", "()V", "BPM_DEFAULT_TYPE_CADJ", "", "BPM_DEFAULT_TYPE_CASH", "BPM_DEFAULT_TYPE_CASH_GOPAY", "BPM_DEFAULT_TYPE_CASH_POSSES", "BPM_DEFAULT_TYPE_CHG", "BPM_DEFAULT_TYPE_CSTR", "BPM_DEFAULT_TYPE_DEBIT", "BPM_DEFAULT_TYPE_KREDIT", "BPM_DEFAULT_TYPE_POSSES", "BPM_DEFAULT_TYPE_SALE", "BPM_DEFAULT_TYPE_TUNAI", "BPM_LIMIT_PAGINATION", "", "BPM_MAX_PAGINATION", "CADJ", "CREDIT_CARD_CODE", "DEBIT_CARD_CODE", "DEFAULT_DATE_FORMAT", "INIT_DEFAULT_LOGO", "MC_FOUR", "Ljava/math/MathContext;", "getMC_FOUR", "()Ljava/math/MathContext;", "MODE_FOOD_BEVERAGES", "MODE_RETAIL", "NEW_DATE_FORMAT", "NOTASETTING_LOGOPATH", "SALE", "SCREEN_LANDSCAPE", "SCREEN_POTRAIT", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BPM_DEFAULT_TYPE_POSSES = "POSSES";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BPM_DEFAULT_TYPE_SALE = "SALE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BPM_DEFAULT_TYPE_CASH = "CASH";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BPM_DEFAULT_TYPE_CADJ = "CADJ";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BPM_DEFAULT_TYPE_CSTR = "CADJ";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BPM_DEFAULT_TYPE_TUNAI = "TUNAI";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BPM_DEFAULT_TYPE_CHG = "CHG";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BPM_DEFAULT_TYPE_DEBIT = "DC";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BPM_DEFAULT_TYPE_KREDIT = "CC";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String CADJ = "CADJ";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String SALE = "SALE";
        public static final int BPM_LIMIT_PAGINATION = 10;
        public static final int BPM_MAX_PAGINATION = 30;
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BPM_DEFAULT_TYPE_CASH_POSSES = "POSSES";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String CREDIT_CARD_CODE = "CC";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String DEBIT_CARD_CODE = "DC";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BPM_DEFAULT_TYPE_CASH_GOPAY = "GOPAY";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String SCREEN_POTRAIT = "Portrait";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String SCREEN_LANDSCAPE = "Landscape";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSSSSS";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NEW_DATE_FORMAT = "dd/MM/yyyy";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String MODE_FOOD_BEVERAGES = "MODE_FOOD_AND_BEVERAGES";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String MODE_RETAIL = "MODE_RETAIL";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTASETTING_LOGOPATH = "NOTASETTING_LOGOPATH";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String INIT_DEFAULT_LOGO = "bpm_logo1";
        @org.jetbrains.annotations.NotNull()
        private static final java.math.MathContext MC_FOUR = null;
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.math.MathContext getMC_FOUR() {
            return null;
        }
    }
}