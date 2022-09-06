package com.bits.bee.bpmc.presentation.ui.pos;

import java.lang.System;

/**
 * Created by aldi on 22/04/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u00c6\u0003J\t\u0010B\u001a\u00020\tH\u00c6\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003J\u0087\u0001\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00c6\u0001J\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010L\u001a\u00020MH\u00d6\u0001J\t\u0010N\u001a\u00020OH\u00d6\u0001R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010-\"\u0004\b=\u0010/\u00a8\u0006P"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/MainState;", "", "bp", "Lcom/bits/bee/bpmc/domain/model/Bp;", "channel", "Lcom/bits/bee/bpmc/domain/model/Channel;", "channelList", "", "sale", "Lcom/bits/bee/bpmc/domain/model/Sale;", "saledList", "", "Lcom/bits/bee/bpmc/domain/model/Saled;", "activeCashier", "Lcom/bits/bee/bpmc/domain/model/Cashier;", "activeBranch", "Lcom/bits/bee/bpmc/domain/model/Branch;", "activePosses", "Lcom/bits/bee/bpmc/domain/model/Posses;", "crc", "Lcom/bits/bee/bpmc/domain/model/Crc;", "itgrpAddOn", "Lcom/bits/bee/bpmc/domain/model/ItemGroup;", "(Lcom/bits/bee/bpmc/domain/model/Bp;Lcom/bits/bee/bpmc/domain/model/Channel;Ljava/util/List;Lcom/bits/bee/bpmc/domain/model/Sale;Ljava/util/List;Lcom/bits/bee/bpmc/domain/model/Cashier;Lcom/bits/bee/bpmc/domain/model/Branch;Lcom/bits/bee/bpmc/domain/model/Posses;Lcom/bits/bee/bpmc/domain/model/Crc;Lcom/bits/bee/bpmc/domain/model/ItemGroup;)V", "getActiveBranch", "()Lcom/bits/bee/bpmc/domain/model/Branch;", "setActiveBranch", "(Lcom/bits/bee/bpmc/domain/model/Branch;)V", "getActiveCashier", "()Lcom/bits/bee/bpmc/domain/model/Cashier;", "setActiveCashier", "(Lcom/bits/bee/bpmc/domain/model/Cashier;)V", "getActivePosses", "()Lcom/bits/bee/bpmc/domain/model/Posses;", "setActivePosses", "(Lcom/bits/bee/bpmc/domain/model/Posses;)V", "getBp", "()Lcom/bits/bee/bpmc/domain/model/Bp;", "setBp", "(Lcom/bits/bee/bpmc/domain/model/Bp;)V", "getChannel", "()Lcom/bits/bee/bpmc/domain/model/Channel;", "setChannel", "(Lcom/bits/bee/bpmc/domain/model/Channel;)V", "getChannelList", "()Ljava/util/List;", "setChannelList", "(Ljava/util/List;)V", "getCrc", "()Lcom/bits/bee/bpmc/domain/model/Crc;", "setCrc", "(Lcom/bits/bee/bpmc/domain/model/Crc;)V", "getItgrpAddOn", "()Lcom/bits/bee/bpmc/domain/model/ItemGroup;", "setItgrpAddOn", "(Lcom/bits/bee/bpmc/domain/model/ItemGroup;)V", "getSale", "()Lcom/bits/bee/bpmc/domain/model/Sale;", "setSale", "(Lcom/bits/bee/bpmc/domain/model/Sale;)V", "getSaledList", "setSaledList", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class MainState {
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Bp bp;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Channel channel;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.bits.bee.bpmc.domain.model.Channel> channelList;
    @org.jetbrains.annotations.NotNull()
    private com.bits.bee.bpmc.domain.model.Sale sale;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.bits.bee.bpmc.domain.model.Saled> saledList;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Cashier activeCashier;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Branch activeBranch;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Posses activePosses;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Crc crc;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.ItemGroup itgrpAddOn;
    
    /**
     * Created by aldi on 22/04/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.pos.MainState copy(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Bp bp, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Channel channel, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Channel> channelList, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> saledList, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier activeCashier, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch activeBranch, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Posses activePosses, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Crc crc, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.ItemGroup itgrpAddOn) {
        return null;
    }
    
    /**
     * Created by aldi on 22/04/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 22/04/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 22/04/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public MainState() {
        super();
    }
    
    public MainState(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Bp bp, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Channel channel, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Channel> channelList, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> saledList, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier activeCashier, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch activeBranch, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Posses activePosses, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Crc crc, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.ItemGroup itgrpAddOn) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Bp component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Bp getBp() {
        return null;
    }
    
    public final void setBp(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Bp p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Channel component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Channel getChannel() {
        return null;
    }
    
    public final void setChannel(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Channel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Channel> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Channel> getChannelList() {
        return null;
    }
    
    public final void setChannelList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Channel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.model.Sale component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.model.Sale getSale() {
        return null;
    }
    
    public final void setSale(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Saled> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Saled> getSaledList() {
        return null;
    }
    
    public final void setSaledList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Cashier component6() {
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
    public final com.bits.bee.bpmc.domain.model.Branch component7() {
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
    public final com.bits.bee.bpmc.domain.model.Posses component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Posses getActivePosses() {
        return null;
    }
    
    public final void setActivePosses(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Posses p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Crc component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Crc getCrc() {
        return null;
    }
    
    public final void setCrc(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Crc p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.ItemGroup component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.ItemGroup getItgrpAddOn() {
        return null;
    }
    
    public final void setItgrpAddOn(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.ItemGroup p0) {
    }
}