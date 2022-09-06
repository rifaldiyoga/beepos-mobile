package com.bits.bee.bpmc.presentation.ui.analisis_sesi;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u00e3\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u001dJ\u000b\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\u0011\u0010S\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u0011\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u00c6\u0003J\u0011\u0010X\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u00c6\u0003J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bH\u00c6\u0003J\u0011\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\u00e7\u0001\u0010\\\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000bH\u00c6\u0001J\u0013\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010`\u001a\u00020aH\u00d6\u0001J\t\u0010b\u001a\u00020cH\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\'\"\u0004\b5\u0010)R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\'\"\u0004\b7\u0010)R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\'\"\u0004\b9\u0010)R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\'\"\u0004\b;\u0010)R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010+\"\u0004\bA\u0010-R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010+\"\u0004\bC\u0010-R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010+\"\u0004\bE\u0010-R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010+\"\u0004\bG\u0010-R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K\u00a8\u0006d"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/analisis_sesi/AnalisaSesiState;", "", "posses", "Lcom/bits/bee/bpmc/domain/model/Posses;", "activeBranch", "Lcom/bits/bee/bpmc/domain/model/Branch;", "activeCashier", "Lcom/bits/bee/bpmc/domain/model/Cashier;", "user", "Lcom/bits/bee/bpmc/domain/model/User;", "possesList", "", "saleList", "Lcom/bits/bee/bpmc/domain/model/Sale;", "bpDateList", "Lcom/bits/bee/bpmc/domain/model/Bp;", "saledList", "Lcom/bits/bee/bpmc/domain/model/Saled;", "setoranKasirData", "Lcom/bits/bee/bpmc/domain/model/SetoranKasirData;", "notaSucces", "Ljava/math/BigDecimal;", "notaVoid", "totalTunai", "totalDebit", "totalKredit", "totalGopay", "rankItem", "Lcom/bits/bee/bpmc/domain/model/RankItem;", "(Lcom/bits/bee/bpmc/domain/model/Posses;Lcom/bits/bee/bpmc/domain/model/Branch;Lcom/bits/bee/bpmc/domain/model/Cashier;Lcom/bits/bee/bpmc/domain/model/User;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/bits/bee/bpmc/domain/model/SetoranKasirData;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/util/List;)V", "getActiveBranch", "()Lcom/bits/bee/bpmc/domain/model/Branch;", "setActiveBranch", "(Lcom/bits/bee/bpmc/domain/model/Branch;)V", "getActiveCashier", "()Lcom/bits/bee/bpmc/domain/model/Cashier;", "setActiveCashier", "(Lcom/bits/bee/bpmc/domain/model/Cashier;)V", "getBpDateList", "()Ljava/util/List;", "setBpDateList", "(Ljava/util/List;)V", "getNotaSucces", "()Ljava/math/BigDecimal;", "setNotaSucces", "(Ljava/math/BigDecimal;)V", "getNotaVoid", "setNotaVoid", "getPosses", "()Lcom/bits/bee/bpmc/domain/model/Posses;", "setPosses", "(Lcom/bits/bee/bpmc/domain/model/Posses;)V", "getPossesList", "setPossesList", "getRankItem", "setRankItem", "getSaleList", "setSaleList", "getSaledList", "setSaledList", "getSetoranKasirData", "()Lcom/bits/bee/bpmc/domain/model/SetoranKasirData;", "setSetoranKasirData", "(Lcom/bits/bee/bpmc/domain/model/SetoranKasirData;)V", "getTotalDebit", "setTotalDebit", "getTotalGopay", "setTotalGopay", "getTotalKredit", "setTotalKredit", "getTotalTunai", "setTotalTunai", "getUser", "()Lcom/bits/bee/bpmc/domain/model/User;", "setUser", "(Lcom/bits/bee/bpmc/domain/model/User;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class AnalisaSesiState {
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Posses posses;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Branch activeBranch;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Cashier activeCashier;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.User user;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.bits.bee.bpmc.domain.model.Posses> possesList;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.bits.bee.bpmc.domain.model.Sale> saleList;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.bits.bee.bpmc.domain.model.Bp> bpDateList;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.bits.bee.bpmc.domain.model.Saled> saledList;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.SetoranKasirData setoranKasirData;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal notaSucces;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal notaVoid;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal totalTunai;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal totalDebit;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal totalKredit;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal totalGopay;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.bits.bee.bpmc.domain.model.RankItem> rankItem;
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.analisis_sesi.AnalisaSesiState copy(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Posses posses, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch activeBranch, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier activeCashier, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.User user, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Posses> possesList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Sale> saleList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Bp> bpDateList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> saledList, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.SetoranKasirData setoranKasirData, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal notaSucces, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal notaVoid, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal totalTunai, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal totalDebit, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal totalKredit, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal totalGopay, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.RankItem> rankItem) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public AnalisaSesiState() {
        super();
    }
    
    public AnalisaSesiState(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Posses posses, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch activeBranch, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier activeCashier, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.User user, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Posses> possesList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Sale> saleList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Bp> bpDateList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> saledList, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.SetoranKasirData setoranKasirData, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal notaSucces, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal notaVoid, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal totalTunai, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal totalDebit, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal totalKredit, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal totalGopay, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.RankItem> rankItem) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Posses component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Posses getPosses() {
        return null;
    }
    
    public final void setPosses(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Posses p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Branch component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Branch getActiveBranch() {
        return null;
    }
    
    public final void setActiveBranch(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Cashier component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Cashier getActiveCashier() {
        return null;
    }
    
    public final void setActiveCashier(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.User component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.User getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.User p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Posses> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Posses> getPossesList() {
        return null;
    }
    
    public final void setPossesList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Posses> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Sale> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Sale> getSaleList() {
        return null;
    }
    
    public final void setSaleList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Sale> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Bp> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Bp> getBpDateList() {
        return null;
    }
    
    public final void setBpDateList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Bp> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Saled> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Saled> getSaledList() {
        return null;
    }
    
    public final void setSaledList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.SetoranKasirData component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.SetoranKasirData getSetoranKasirData() {
        return null;
    }
    
    public final void setSetoranKasirData(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.SetoranKasirData p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getNotaSucces() {
        return null;
    }
    
    public final void setNotaSucces(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getNotaVoid() {
        return null;
    }
    
    public final void setNotaVoid(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getTotalTunai() {
        return null;
    }
    
    public final void setTotalTunai(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getTotalDebit() {
        return null;
    }
    
    public final void setTotalDebit(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getTotalKredit() {
        return null;
    }
    
    public final void setTotalKredit(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getTotalGopay() {
        return null;
    }
    
    public final void setTotalGopay(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.RankItem> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.RankItem> getRankItem() {
        return null;
    }
    
    public final void setRankItem(@org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.RankItem> p0) {
    }
}