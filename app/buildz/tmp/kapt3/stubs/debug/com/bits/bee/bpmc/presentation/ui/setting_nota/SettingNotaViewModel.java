package com.bits.bee.bpmc.presentation.ui.setting_nota;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0011\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_nota/SettingNotaViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/setting_nota/SettingNotaState;", "Lcom/bits/bee/bpmc/presentation/ui/setting_nota/SettingNotaViewModel$UIEvent;", "application", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getApplication", "()Landroid/content/Context;", "onClickAturFooter", "Lkotlinx/coroutines/Job;", "onClickAturHeader", "UIEvent", "app_debug"})
public final class SettingNotaViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.setting_nota.SettingNotaState, com.bits.bee.bpmc.presentation.ui.setting_nota.SettingNotaViewModel.UIEvent> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context application = null;
    
    @javax.inject.Inject()
    public SettingNotaViewModel(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context application) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getApplication() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickAturHeader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickAturFooter() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_nota/SettingNotaViewModel$UIEvent;", "", "()V", "RequestAturFooter", "RequestAturHeader", "Lcom/bits/bee/bpmc/presentation/ui/setting_nota/SettingNotaViewModel$UIEvent$RequestAturFooter;", "Lcom/bits/bee/bpmc/presentation/ui/setting_nota/SettingNotaViewModel$UIEvent$RequestAturHeader;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_nota/SettingNotaViewModel$UIEvent$RequestAturHeader;", "Lcom/bits/bee/bpmc/presentation/ui/setting_nota/SettingNotaViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestAturHeader extends com.bits.bee.bpmc.presentation.ui.setting_nota.SettingNotaViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_nota.SettingNotaViewModel.UIEvent.RequestAturHeader INSTANCE = null;
            
            private RequestAturHeader() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_nota/SettingNotaViewModel$UIEvent$RequestAturFooter;", "Lcom/bits/bee/bpmc/presentation/ui/setting_nota/SettingNotaViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestAturFooter extends com.bits.bee.bpmc.presentation.ui.setting_nota.SettingNotaViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_nota.SettingNotaViewModel.UIEvent.RequestAturFooter INSTANCE = null;
            
            private RequestAturFooter() {
                super();
            }
        }
    }
}