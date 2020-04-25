package blacksmith.sullivanway.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import blacksmith.sullivanway.data.entity.db.SubwayLine;
import io.reactivex.Single;

@Dao
public interface SubwayLineDao {

    @Query("SELECT * FROM subway_line WHERE id = :id")
    Single<SubwayLine> loadOneById(Long id);
}
