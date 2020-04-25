package blacksmith.sullivanway.data.entity.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(
    tableName = "time_table",
    primaryKeys = {
        "line_id",
        "start_stn_id",
        "end_stn_id",
        "up_down_type",
        "week_type",
        "seq_num"
    },
    foreignKeys = {
        @ForeignKey(
            entity = SubwayLine.class,
            parentColumns = "id",
            childColumns = "line_id",
            onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
            entity = Station.class,
            parentColumns = "id",
            childColumns = "start_stn_id",
            onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
            entity = Station.class,
            parentColumns = "id",
            childColumns = "end_stn_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)

public class TimeTable {

    @Expose
    @SerializedName("line_id")
    @ColumnInfo(name = "line_id")
    public Long lineId; //호선 ID

    @Expose
    @SerializedName("start_stn_id")
    @ColumnInfo(name = "start_stn_id")
    public Long startStnId; //운행 시작역 ID

    @Expose
    @SerializedName("end_stn_id")
    @ColumnInfo(name = "end_stn_id")
    public Long endStnId; //운행 종착역 ID

    @Expose
    @SerializedName("up_down_type")
    @ColumnInfo(name = "up_down_type")
    public Integer upDownType; //상하행 (1: 상/내, 2: 하/외)

    @Expose
    @SerializedName("week_type")
    @ColumnInfo(name = "week_type")
    public Integer weekType; //주중주말 (1: 평일, 2: 토, 3: 일/공)

    @Expose
    @SerializedName("seq_num")
    @ColumnInfo(name = "seq_num")
    public Integer seqNum; //순번

    @Expose
    @SerializedName("subway_type")
    @ColumnInfo(name = "subway_type")
    public Integer subwayType; //급행여부 (1: 일반, 2: 급행)

    @Expose
    public String time; //현재 역에서 출발하는 시간 (HHmmss)
}
