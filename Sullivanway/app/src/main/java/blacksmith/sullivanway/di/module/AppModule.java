/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package blacksmith.sullivanway.di.module;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import blacksmith.sullivanway.BuildConfig;
import blacksmith.sullivanway.data.AppDataManager;
import blacksmith.sullivanway.data.DataManager;
import blacksmith.sullivanway.data.local.db.AppDatabase;
import blacksmith.sullivanway.data.local.db.AppDbHelper;
import blacksmith.sullivanway.data.local.db.DbHelper;
import blacksmith.sullivanway.data.local.prefs.AppPreferencesHelper;
import blacksmith.sullivanway.data.local.prefs.PreferencesHelper;
import blacksmith.sullivanway.data.remote.ApiHeader;
import blacksmith.sullivanway.data.remote.ApiHelper;
import blacksmith.sullivanway.data.remote.AppApiHelper;
import blacksmith.sullivanway.di.ApiInfo;
import blacksmith.sullivanway.di.DatabaseInfo;
import blacksmith.sullivanway.di.PreferenceInfo;
import blacksmith.sullivanway.utils.AppConstants;
import blacksmith.sullivanway.utils.rx.AppSchedulerProvider;
import blacksmith.sullivanway.utils.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;

/**
 * Created by amitshekhar on 07/07/17.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                0L, //preferencesHelper.getCurrentUserId(),
                "" //preferencesHelper.getAccessToken()
        );
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
