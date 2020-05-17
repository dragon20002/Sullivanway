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

package blacksmith.sullivanway.data;

import android.content.Context;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import blacksmith.sullivanway.data.entity.db.Congestion;
import blacksmith.sullivanway.data.entity.db.Elevator;
import blacksmith.sullivanway.data.entity.db.Station;
import blacksmith.sullivanway.data.entity.db.StationDetail;
import blacksmith.sullivanway.data.entity.db.SubwayLine;
import blacksmith.sullivanway.data.entity.db.SubwayNode;
import blacksmith.sullivanway.data.entity.db.TimeTable;
import blacksmith.sullivanway.data.entity.db.TransferMap;
import blacksmith.sullivanway.data.entity.others.StationDetailVo;
import blacksmith.sullivanway.data.entity.others.StationVo;
import blacksmith.sullivanway.data.local.db.DbHelper;
import blacksmith.sullivanway.data.local.prefs.PreferencesHelper;
import blacksmith.sullivanway.data.remote.ApiHelper;
import io.reactivex.Observable;

/**
 * Created by amitshekhar on 07/07/17.
 */
@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = AppDataManager.class.getName();

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final DbHelper mDbHelper;

    private final Gson mGson;

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper, PreferencesHelper preferencesHelper, ApiHelper apiHelper, Gson gson) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mGson = gson;
    }

    /***
     * Override from DataManager
     */

    @Override
    public Observable<SubwayNode> getSubwayNode(SubwayNode subwayNode) {
        return mDbHelper.getSubwayNode(subwayNode);
    }

    @Override
    public Observable<List<StationVo>> getStationVos(SubwayNode subwayNode) {
        return mDbHelper.getStations(subwayNode)
                .flatMap(Observable::fromIterable)
                .flatMap(station -> Observable.zip(
                        Observable.just(station),
                        mDbHelper.getSubwayLine(station),
                        StationVo::new))
                .toList()
                .toObservable();
    }

    @Override
    public Observable<StationDetailVo> getStationDetailVo(Station station) {
        return mDbHelper.getStation(station)
                .map(_station -> Observable.zip(
                    mDbHelper.getStationDetail(_station),
                    mDbHelper.getElevators(_station),
                    (stationDetail, elevators) ->
                            new StationDetailVo(_station, stationDetail, elevators)
                ))
                .blockingFirst();
    }

    /***
     * Override from DbHelper
     */

    @Override
    public Observable<List<SubwayNode>> getSubwayNodes() {
        return mDbHelper.getSubwayNodes();
    }

    @Override
    public Observable<Station> getStation(Station station) {
        return mDbHelper.getStation(station);
    }

    @Override
    public Observable<List<Station>> getStations(SubwayNode subwayNode) {
        return mDbHelper.getStations(subwayNode);
    }

    @Override
    public Observable<SubwayLine> getSubwayLine(Station station) {
        return mDbHelper.getSubwayLine(station);
    }

    @Override
    public Observable<StationDetail> getStationDetail(Station station) {
        return mDbHelper.getStationDetail(station);
    }

    @Override
    public Observable<List<Elevator>> getElevators(Station station) {
        return mDbHelper.getElevators(station);
    }

    @Override
    public Observable<List<Congestion>> getCongestions(Station station) {
        return mDbHelper.getCongestions(station);
    }

    @Override
    public Observable<List<TimeTable>> getTimeTables(Station station) {
        return mDbHelper.getTimeTables(station);
    }

    @Override
    public Observable<List<TransferMap>> getTransferMaps(Station station) {
        return mDbHelper.getTransferMaps(station);
    }

}
