package com.bits.bee.bpmc.data.data_source.local.model;

import java.lang.System;

@androidx.room.Entity(tableName = "selectiond", foreignKeys = {@androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.SelectionEntity.class, childColumns = {"selection_id"}, onDelete = 5, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.bits.bee.bpmc.data.data_source.local.model.ItemEntity.class, childColumns = {"item_id"}, onDelete = 5, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B\'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J8\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b\u00a8\u0006\""}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/SelectionDEntity;", "", "id", "", "selectionId", "dno", "itemId", "(Ljava/lang/Integer;III)V", "getDno", "()I", "setDno", "(I)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getItemId", "setItemId", "getSelectionId", "setSelectionId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;III)Lcom/bits/bee/bpmc/data/data_source/local/model/SelectionDEntity;", "equals", "", "other", "hashCode", "toString", "", "Companion", "app_debug"})
public final class SelectionDEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = false)
    private java.lang.Integer id;
    @androidx.room.ColumnInfo(name = "selection_id", index = true)
    private int selectionId;
    @androidx.room.ColumnInfo(name = "dno")
    private int dno;
    @androidx.room.ColumnInfo(name = "item_id", index = true)
    private int itemId;
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.data.data_source.local.model.SelectionDEntity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TBL_NAME = "selectiond";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SELECTION_ID = "selection_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DNO = "dno";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ITEM_ID = "item_id";
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.data.data_source.local.model.SelectionDEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, int selectionId, int dno, int itemId) {
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
    
    public SelectionDEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, int selectionId, int dno, int itemId) {
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
    
    public final int getSelectionId() {
        return 0;
    }
    
    public final void setSelectionId(int p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getDno() {
        return 0;
    }
    
    public final void setDno(int p0) {
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getItemId() {
        return 0;
    }
    
    public final void setItemId(int p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/model/SelectionDEntity$Companion;", "", "()V", "DNO", "", "ID", "ITEM_ID", "SELECTION_ID", "TBL_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}