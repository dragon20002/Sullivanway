package blacksmith.sullivanway.data.entity.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("NullableProblems")
@Entity(
    tableName = "search_history",
    primaryKeys = {
        "start_node_id",
        "end_node_id"
    },
    foreignKeys = {
        @ForeignKey(
            entity = SubwayNode.class,
            parentColumns = "id",
            childColumns = "start_node_id",
            onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
            entity = SubwayNode.class,
            parentColumns = "id",
            childColumns = "end_node_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)

public class SearchHistory {

    @NonNull
    @Expose
    @SerializedName("start_node_id")
    @ColumnInfo(name = "start_node_id", index = true)
    public Long startNodeId; //출발역 노드 ID

    @NonNull
    @Expose
    @SerializedName("end_node_id")
    @ColumnInfo(name = "end_node_id", index = true)
    public Long endNodeId; //도착역 노드 ID

    @Expose
    public Integer type; //기록유형 (1: History, 2: Favorite)

    @Expose
    @SerializedName("req_timestamp")
    @ColumnInfo(name = "req_timestamp")
    public Long regTimestamp; //등록 시간 (millisecond)
}
