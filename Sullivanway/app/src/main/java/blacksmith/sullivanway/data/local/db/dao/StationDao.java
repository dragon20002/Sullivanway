package blacksmith.sullivanway.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import blacksmith.sullivanway.data.entity.db.Station;
import io.reactivex.Single;

@Dao
public interface StationDao {

    @Query("SELECT * FROM station WHERE node_id = :nodeId")
    Single<List<Station>> loadAllByNodeId(Long nodeId);
}
