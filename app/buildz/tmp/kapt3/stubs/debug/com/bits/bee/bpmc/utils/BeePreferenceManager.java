package com.bits.bee.bpmc.utils;

import java.lang.System;

/**
 * Created by aldi on 01/04/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/bits/bee/bpmc/utils/BeePreferenceManager;", "", "()V", "Companion", "app_debug"})
public final class BeePreferenceManager {
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.utils.BeePreferenceManager.Companion Companion = null;
    private static android.content.SharedPreferences sharedPreferences;
    private static android.content.SharedPreferences.Editor sharedPreferencesEditor;
    
    public BeePreferenceManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u0011\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001J\u001e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/bits/bee/bpmc/utils/BeePreferenceManager$Companion;", "", "()V", "sharedPreferences", "Landroid/content/SharedPreferences;", "sharedPreferencesEditor", "Landroid/content/SharedPreferences$Editor;", "getDataFromPreferences", "context", "Landroid/content/Context;", "key", "", "value", "initPreferences", "", "removeAllSharedPreferences", "", "removeSomeKey", "saveToPreferences", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final void initPreferences(android.content.Context context) {
        }
        
        public final boolean saveToPreferences(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String key, @org.jetbrains.annotations.NotNull()
        java.lang.Object value) {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Object getDataFromPreferences(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String key, @org.jetbrains.annotations.NotNull()
        java.lang.Object value) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Object removeSomeKey(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String key, @org.jetbrains.annotations.NotNull()
        java.lang.Object value) {
            return null;
        }
        
        public final boolean removeAllSharedPreferences(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return false;
        }
    }
}