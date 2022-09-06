package com.bits.bee.bpmc.presentation.ui.cari_kecamatan;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u00c6\u0003J=\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\'"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/cari_kecamatan/CariKecamatanState;", "", "ff", "", "cityPopuler", "Lcom/bits/bee/bpmc/domain/model/CityPopuler;", "regency", "Lcom/bits/bee/bpmc/domain/model/Regency;", "listDistrict", "", "Lcom/bits/bee/bpmc/domain/model/District;", "(Ljava/lang/String;Lcom/bits/bee/bpmc/domain/model/CityPopuler;Lcom/bits/bee/bpmc/domain/model/Regency;Ljava/util/List;)V", "getCityPopuler", "()Lcom/bits/bee/bpmc/domain/model/CityPopuler;", "setCityPopuler", "(Lcom/bits/bee/bpmc/domain/model/CityPopuler;)V", "getFf", "()Ljava/lang/String;", "setFf", "(Ljava/lang/String;)V", "getListDistrict", "()Ljava/util/List;", "setListDistrict", "(Ljava/util/List;)V", "getRegency", "()Lcom/bits/bee/bpmc/domain/model/Regency;", "setRegency", "(Lcom/bits/bee/bpmc/domain/model/Regency;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class CariKecamatanState {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String ff;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.CityPopuler cityPopuler;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Regency regency;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.bits.bee.bpmc.domain.model.District> listDistrict;
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.cari_kecamatan.CariKecamatanState copy(@org.jetbrains.annotations.NotNull()
    java.lang.String ff, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.CityPopuler cityPopuler, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Regency regency, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.District> listDistrict) {
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
    
    public CariKecamatanState() {
        super();
    }
    
    public CariKecamatanState(@org.jetbrains.annotations.NotNull()
    java.lang.String ff, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.CityPopuler cityPopuler, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Regency regency, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.District> listDistrict) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFf() {
        return null;
    }
    
    public final void setFf(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.CityPopuler component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.CityPopuler getCityPopuler() {
        return null;
    }
    
    public final void setCityPopuler(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.CityPopuler p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Regency component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Regency getRegency() {
        return null;
    }
    
    public final void setRegency(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Regency p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.District> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.District> getListDistrict() {
        return null;
    }
    
    public final void setListDistrict(@org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.District> p0) {
    }
}