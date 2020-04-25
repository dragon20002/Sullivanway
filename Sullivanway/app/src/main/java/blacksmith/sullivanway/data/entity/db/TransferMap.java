package blacksmith.sullivanway.data.entity.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("NullableProblems")
@Entity(
    tableName = "transfer_map",
    primaryKeys = {
        "start_stn_id",
        "end_stn_id",
        "start_up_down_type",
        "end_up_down_type",
        "floor"
    },
    foreignKeys = {
        @ForeignKey(
            entity = Station.class,
            childColumns = "start_stn_id",
            parentColumns = "id",
            onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Station.class,
                childColumns = "end_stn_id",
                parentColumns = "id",
                onDelete = ForeignKey.CASCADE
        )
    }
)

public class TransferMap {

    @NonNull
    @Expose
    @SerializedName("start_stn_id")
    @ColumnInfo(name = "start_stn_id", index = true)
    public Long startStnId; //출발역 ID

    @NonNull
    @Expose
    @SerializedName("end_stn_id")
    @ColumnInfo(name = "end_stn_id", index = true)
    public Long endStnId; //도착역 ID

    @NonNull
    @Expose
    @SerializedName("start_up_down_type")
    @ColumnInfo(name = "start_up_down_type")
    public Integer startUpDownType; //출발역 상하행 유형

    @NonNull
    @Expose
    @SerializedName("end_up_down_type")
    @ColumnInfo(name = "end_up_down_type")
    public Integer endUpDownType; //도착역 상하행 유형

    @NonNull
    @Expose
    public Integer floor; //현재 층

    @Expose
    @SerializedName("res_id")
    @ColumnInfo(name = "res_id")
    public Long resId; //환승지도 리소스 ID

    @Expose
    public Integer time; //소요시간(분)
}
