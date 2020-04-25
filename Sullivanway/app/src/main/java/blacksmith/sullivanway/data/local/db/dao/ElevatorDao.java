package blacksmith.sullivanway.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import blacksmith.sullivanway.data.entity.db.Elevator;
import io.reactivex.Single;

@Dao
public interface ElevatorDao {

    @Query("SELECT * FROM elevator WHERE stn_id = :stnId")
    Single<List<Elevator>> loadAllByStnId(Long stnId);
}
