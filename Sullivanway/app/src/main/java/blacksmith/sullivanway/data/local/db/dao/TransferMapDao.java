package blacksmith.sullivanway.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import blacksmith.sullivanway.data.entity.db.TransferMap;
import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface TransferMapDao {

    @Query("SELECT * FROM transfer_map WHERE start_stn_id = :startStnId")
    Single<List<TransferMap>> loadAllByStartStnId(Long startStnId);
}
