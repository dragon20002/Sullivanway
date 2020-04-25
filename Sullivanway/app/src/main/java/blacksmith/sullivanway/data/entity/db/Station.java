package blacksmith.sullivanway.data.entity.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(
    tableName = "station",
    foreignKeys = {
        @ForeignKey(entity = SubwayNode.class,
            parentColumns = "id",
            childColumns = "node_id"
        ),
        @ForeignKey(entity = SubwayLine.class,
            parentColumns = "id",
            childColumns = "line_id"
        )
    }
)

public class Station {

    @Expose
    @PrimaryKey(autoGenerate = true)
    public Long id;

    @Expose
    @SerializedName("line_id")
    @ColumnInfo(name = "line_id", index = true)
    public Long lineId; //호선 ID

    @Expose
    @SerializedName("node_id")
    @ColumnInfo(name = "node_id", index = true)
    public Long nodeId; //역 노드 ID

    @Expose
    public String name; //역 이름
}
