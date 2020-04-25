package blacksmith.sullivanway.data.entity.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(
    tableName = "station_detail",
    foreignKeys = {
        @ForeignKey(
            entity = Station.class,
            parentColumns = "id",
            childColumns = "stn_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)

public class StationDetail {

    @Expose
    @SerializedName("stn_id")
    @PrimaryKey
    @ColumnInfo(name = "stn_id")
    public Long stnId; //역 ID

    @Expose
    public Double distance; //다음 역까지 거리(KM)

    @Expose
    @SerializedName("wgs_x")
    @ColumnInfo(name = "wgs_x")
    public Double wgsX; //WGS-X 좌표

    @Expose
    @SerializedName("wgs_y")
    @ColumnInfo(name = "wgs_y")
    public Double wgsY; //WGS-Y 좌표

    @Expose
    public Integer door; //문 방향 (1: 왼쪽, 2: 오른쪽)

    @Expose
    public String contact; //연락처

    @Expose
    public Integer toilet; //화장실 위치 (1: 안쪽, 2: 바깥쪽)

    @Expose
    public Integer elevator; //엘리베이터 여부 (1: Yes, 2: No)

    @Expose
    public Integer escalator; //에스컬레이터 여부 (1: Yes, 2: No)

    @Expose
    @SerializedName("wheel_lift")
    @ColumnInfo(name = "wheel_lift")
    public Integer wheelLift; //휠체어리프트 여부 (1: Yes, 2: No)
}
