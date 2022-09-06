package com.bits.bee.bpmc.presentation.ui.pembayaran_kartu;

import java.lang.System;

/**
 * Created by aldi on 02/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0002\u0010\fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\nH\u00c6\u0003J\t\u0010\'\u001a\u00020\nH\u00c6\u0003JQ\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u00c6\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020-H\u00d6\u0001J\t\u0010.\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010\u00a8\u0006/"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran_kartu/PembayaranKartuState;", "", "pmtd", "Lcom/bits/bee/bpmc/domain/model/Pmtd;", "type", "", "trackNo", "nomorkartu", "keterangan", "nominalSurc", "Ljava/math/BigDecimal;", "total", "(Lcom/bits/bee/bpmc/domain/model/Pmtd;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;)V", "getKeterangan", "()Ljava/lang/String;", "setKeterangan", "(Ljava/lang/String;)V", "getNominalSurc", "()Ljava/math/BigDecimal;", "setNominalSurc", "(Ljava/math/BigDecimal;)V", "getNomorkartu", "setNomorkartu", "getPmtd", "()Lcom/bits/bee/bpmc/domain/model/Pmtd;", "setPmtd", "(Lcom/bits/bee/bpmc/domain/model/Pmtd;)V", "getTotal", "setTotal", "getTrackNo", "setTrackNo", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class PembayaranKartuState {
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Pmtd pmtd;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String type;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String trackNo;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String nomorkartu;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String keterangan;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal nominalSurc;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal total;
    
    /**
     * Created by aldi on 02/06/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.pembayaran_kartu.PembayaranKartuState copy(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Pmtd pmtd, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String trackNo, @org.jetbrains.annotations.NotNull()
    java.lang.String nomorkartu, @org.jetbrains.annotations.NotNull()
    java.lang.String keterangan, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal nominalSurc, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal total) {
        return null;
    }
    
    /**
     * Created by aldi on 02/06/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 02/06/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 02/06/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public PembayaranKartuState() {
        super();
    }
    
    public PembayaranKartuState(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Pmtd pmtd, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String trackNo, @org.jetbrains.annotations.NotNull()
    java.lang.String nomorkartu, @org.jetbrains.annotations.NotNull()
    java.lang.String keterangan, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal nominalSurc, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal total) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Pmtd component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Pmtd getPmtd() {
        return null;
    }
    
    public final void setPmtd(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Pmtd p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTrackNo() {
        return null;
    }
    
    public final void setTrackNo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNomorkartu() {
        return null;
    }
    
    public final void setNomorkartu(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKeterangan() {
        return null;
    }
    
    public final void setKeterangan(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getNominalSurc() {
        return null;
    }
    
    public final void setNominalSurc(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotal() {
        return null;
    }
    
    public final void setTotal(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
}