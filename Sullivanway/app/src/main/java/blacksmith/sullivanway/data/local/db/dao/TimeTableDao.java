package blacksmith.sullivanway.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import blacksmith.sullivanway.data.entity.db.TimeTable;
import io.reactivex.Single;

@Dao
public interface TimeTableDao {

    @Query("SELECT * FROM time_table WHERE line_id = :lineId")
    Single<List<TimeTable>> loadAllByLineId(Long lineId);
}
