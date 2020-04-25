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

import androidx.room.Database;
import androidx.room.RoomDatabase;

import blacksmith.sullivanway.data.entity.db.Congestion;
import blacksmith.sullivanway.data.entity.db.Elevator;
import blacksmith.sullivanway.data.entity.db.SearchHistory;
import blacksmith.sullivanway.data.entity.db.Station;
import blacksmith.sullivanway.data.entity.db.StationDetail;
import blacksmith.sullivanway.data.entity.db.SubwayLine;
import blacksmith.sullivanway.data.entity.db.SubwayNode;
import blacksmith.sullivanway.data.entity.db.TimeTable;
import blacksmith.sullivanway.data.entity.db.TransferMap;
import blacksmith.sullivanway.data.local.db.dao.CongestionDao;
import blacksmith.sullivanway.data.local.db.dao.ElevatorDao;
import blacksmith.sullivanway.data.local.db.dao.SearchHistoryDao;
import blacksmith.sullivanway.data.local.db.dao.StationDao;
import blacksmith.sullivanway.data.local.db.dao.StationDetailDao;
import blacksmith.sullivanway.data.local.db.dao.SubwayLineDao;
import blacksmith.sullivanway.data.local.db.dao.SubwayNodeDao;
import blacksmith.sullivanway.data.local.db.dao.TimeTableDao;
import blacksmith.sullivanway.data.local.db.dao.TransferMapDao;

/**
 * Created by amitshekhar on 07/07/17.
 */

@Database(entities = {
        SubwayNode.class,
        SubwayLine.class,
        Station.class,
        StationDetail.class,
        Elevator.class,
        Congestion.class,
        TimeTable.class,
        TransferMap.class,
        SearchHistory.class,
    }, version = 2
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SubwayNodeDao subwayNodeDao();
    public abstract SubwayLineDao subwayLineDao();
    public abstract StationDao stationDao();
    public abstract StationDetailDao stationDetailDao();
    public abstract ElevatorDao elevatorDao();
    public abstract CongestionDao congestionDao();
    public abstract TimeTableDao timeTableDao();
    public abstract TransferMapDao transferMapDao();
    public abstract SearchHistoryDao searchHistoryDao();
}
