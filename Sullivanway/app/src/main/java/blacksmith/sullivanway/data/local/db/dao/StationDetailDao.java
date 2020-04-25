package blacksmith.sullivanway.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import blacksmith.sullivanway.data.entity.db.StationDetail;
import io.reactivex.Single;

@Dao
public interface StationDetailDao {

    @Query("SELECT * FROM station_detail WHERE stn_id = :stnId")
    Single<StationDetail> loadOneByStnId(Long stnId);
}
