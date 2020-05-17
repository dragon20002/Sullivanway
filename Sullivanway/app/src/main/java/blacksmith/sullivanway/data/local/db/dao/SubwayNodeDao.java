package blacksmith.sullivanway.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import blacksmith.sullivanway.data.entity.db.SubwayNode;
import io.reactivex.Single;

@Dao
public interface SubwayNodeDao {

    @Query("SELECT * FROM subway_node")
    Single<List<SubwayNode>> loadAll();

    @Query("SELECT * FROM subway_node WHERE id = :id")
    Single<SubwayNode> loadOneById(Long id);
}
