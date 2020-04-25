package blacksmith.sullivanway.data.entity.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(
    primaryKeys = {
        "stn_id",
        "seq_num"
    },
    foreignKeys = {
        @ForeignKey(
            entity = Station.class,
            parentColumns = "id",
            childColumns = "stn_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Elevator {

    @Expose
    @SerializedName("stn_id")
    @ColumnInfo(name = "stn_id")
    public Long stnId; //역 ID

    @Expose
    @SerializedName("seq_num")
    @ColumnInfo(name = "seq_num")
    public Integer seqNum; //순번

    @Expose
    @SerializedName("in_out_type")
    @ColumnInfo(name = "in_out_type")
    public Integer inOutType; //내외부 유형 (1: 내부, 2: 외부)

    @Expose
    @SerializedName("top_floor")
    @ColumnInfo(name = "top_floor")
    public Integer topFloor; //최상층 층

    @Expose
    @SerializedName("top_floor_type")
    @ColumnInfo(name = "top_floor_type")
    public Integer topFloorType; //최상층 유형 (1: 승강장, 2: 대합실, 3: 지상, 4: 상가)

    @Expose
    @SerializedName("bottom_floor")
    @ColumnInfo(name = "bottom_floor")
    public Integer bottomFloor; //최하층 층

    @Expose
    @SerializedName("bottom_floor_type")
    @ColumnInfo(name = "bottom_floor_type")
    public Integer bottomFloorType; //최하층 유형 (1: 승강장, 2: 대합실, 3: 지상, 4: 상가)

    @Expose
    public String location; //상세위치 내용
}
