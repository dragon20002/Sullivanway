package blacksmith.sullivanway.data.entity.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("NullableProblems")
@Entity(
    tableName = "congestion",
    primaryKeys = {
        "stn_id",
        "date",
        "time"
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

public class Congestion {

    @NonNull
    @Expose
    @SerializedName("stn_id")
    @ColumnInfo(name = "stn_id")
    public Long stnId; //역 ID

    @NonNull
    @Expose
    public String date; //측정날짜

    @NonNull
    @Expose
    public Integer time; //측정시간대 (4: 04시 - 05시)

    @Expose
    public Integer count; //인구유동량(명)
}
