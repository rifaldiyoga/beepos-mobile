package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "addond", foreignKeys = {@androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.AddOnEntity.class, childColumns = {"addon_id"}, onDelete = 5, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.SelectionEntity.class, childColumns = {"selection_id"}, onDelete = 5, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001*B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\tH\u00c6\u0003JL\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001\u00a2\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00d6\u0001J\t\u0010(\u001a\u00020)H\u00d6\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000e\u00a8\u0006+"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/AddOnDEntity;", "", "id", "", "addOnId", "selectionId", "idx", "upIdx", "isSkip", "", "(Ljava/lang/Integer;IIIIZ)V", "getAddOnId", "()I", "setAddOnId", "(I)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIdx", "setIdx", "()Z", "setSkip", "(Z)V", "getSelectionId", "setSelectionId", "getUpIdx", "setUpIdx", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;IIIIZ)Lcom/bits/bee/bpmc/data/data_source/local/model/AddOnDEntity;", "equals", "other", "hashCode", "toString", "", "Companion", "app_debug"})
public final class AddOnDEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = false)
    private java.lang.Integer id;
    @androidx.room.ColumnInfo(name = "addon_id", index = true)
    private int addOnId;
    @androidx.room.ColumnInfo(name = "selection_id", index = true)
    private int selectionId;
    @androidx.room.ColumnInfo(name = "idx")
    private int idx;
    @androidx.room.ColumnInfo(name = "addond")
    private int upIdx;
    @androidx.room.ColumnInfo(name = "isskip")
    private boolean isSkip;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.AddOnDEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "addond";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ADDON_ID = "addon_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SELECTION_ID = "selection_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IDX = "idx";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UPIDX = "addond";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ISSKIP = "isskip";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.AddOnDEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, int addOnId, int selectionId, int idx, int upIdx, boolean isSkip) {
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
    
    public AddOnDEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, int addOnId, int selectionId, int idx, int upIdx, boolean isSkip) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getAddOnId() {
        return 0;
    }
    
    public final void setAddOnId(int p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getSelectionId() {
        return 0;
    }
    
    public final void setSelectionId(int p0) {
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getIdx() {
        return 0;
    }
    
    public final void setIdx(int p0) {
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getUpIdx() {
        return 0;
    }
    
    public final void setUpIdx(int p0) {
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean isSkip() {
        return false;
    }
    
    public final void setSkip(boolean p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/AddOnDEntity$Companion;", "", "()V", "ADDON_ID", "", "ID", "IDX", "ISSKIP", "SELECTION_ID", "TBL_NAME", "UPIDX", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}