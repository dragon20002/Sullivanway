package blacksmith.sullivanway.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import blacksmith.sullivanway.data.entity.db.Congestion;
import io.reactivex.Single;

@Dao
public interface CongestionDao {

    @Query("SELECT * FROM congestion WHERE stn_id = :stnId")
    Single<List<Congestion>> loadAllByStnId(Long stnId);
}
