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

package blacksmith.sullivanway.data.local.db;

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
import io.reactivex.Observable;

/**
 * Created by amitshekhar on 07/07/17.
 */

@Singleton
public class AppDbHelper implements DbHelper {

    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<List<Station>> getStations(SubwayNode subwayNode) {
        return mAppDatabase.stationDao().loadAllByNodeId(subwayNode.id)
                .toObservable();
    }

    @Override
    public Observable<SubwayLine> getSubwayLine(Station station) {
        return mAppDatabase.subwayLineDao().loadOneById(station.lineId)
                .toObservable();
    }

    @Override
    public Observable<StationDetail> getStationDetail(Station station) {
        return mAppDatabase.stationDetailDao().loadOneByStnId(station.id)
                .toObservable();
    }

    @Override
    public Observable<List<Elevator>> getElevators(Station station) {
        return mAppDatabase.elevatorDao().loadAllByStnId(station.id)
                .toObservable();
    }

    @Override
    public Observable<List<Congestion>> getCongestions(Station station) {
        return mAppDatabase.congestionDao().loadAllByStnId(station.id)
                .toObservable();
    }

    @Override
    public Observable<List<TimeTable>> getTimeTables(Station station) {
        return mAppDatabase.timeTableDao().loadAllByLineId(station.lineId)
                .toObservable();
    }

    @Override
    public Observable<List<TransferMap>> getTransferMaps(Station station) {
        return mAppDatabase.transferMapDao().loadAllByStartStnId(station.id)
                .toObservable();
    }
}
