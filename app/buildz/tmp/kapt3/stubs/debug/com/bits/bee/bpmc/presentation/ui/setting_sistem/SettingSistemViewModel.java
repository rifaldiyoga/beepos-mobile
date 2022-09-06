package com.bits.bee.bpmc.presentation.ui.setting_sistem;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0011\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemState;", "Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent;", "application", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getApplication", "()Landroid/content/Context;", "onClickAboutCloudDapur", "Lkotlinx/coroutines/Job;", "onClickAturPrinter", "onClickPeriodeUploadOtomatis", "onClickSistemBatchUpload", "onClickSistemPenyimpanan", "UIEvent", "app_debug"})
public final class SettingSistemViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemState, com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemViewModel.UIEvent> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context application = null;
    
    @javax.inject.Inject()
    public SettingSistemViewModel(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context application) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getApplication() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickSistemPenyimpanan() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickSistemBatchUpload() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickPeriodeUploadOtomatis() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickAboutCloudDapur() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickAturPrinter() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent;", "", "()V", "RequestAboutCloudDapur", "RequestPeriodeUploadOtomatis", "RequestSettingPritner", "RequestSistemBatchUpload", "RequestSistemPenyimpanan", "Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent$RequestAboutCloudDapur;", "Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent$RequestPeriodeUploadOtomatis;", "Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent$RequestSettingPritner;", "Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent$RequestSistemBatchUpload;", "Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent$RequestSistemPenyimpanan;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent$RequestSistemPenyimpanan;", "Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestSistemPenyimpanan extends com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemViewModel.UIEvent.RequestSistemPenyimpanan INSTANCE = null;
            
            private RequestSistemPenyimpanan() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent$RequestSistemBatchUpload;", "Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestSistemBatchUpload extends com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemViewModel.UIEvent.RequestSistemBatchUpload INSTANCE = null;
            
            private RequestSistemBatchUpload() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent$RequestPeriodeUploadOtomatis;", "Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestPeriodeUploadOtomatis extends com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemViewModel.UIEvent.RequestPeriodeUploadOtomatis INSTANCE = null;
            
            private RequestPeriodeUploadOtomatis() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent$RequestAboutCloudDapur;", "Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestAboutCloudDapur extends com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemViewModel.UIEvent.RequestAboutCloudDapur INSTANCE = null;
            
            private RequestAboutCloudDapur() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent$RequestSettingPritner;", "Lcom/bits/bee/bpmc/presentation/ui/setting_sistem/SettingSistemViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestSettingPritner extends com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemViewModel.UIEvent.RequestSettingPritner INSTANCE = null;
            
            private RequestSettingPritner() {
                super();
            }
        }
    }
}