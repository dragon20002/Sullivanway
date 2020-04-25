package blacksmith.sullivanway.data.entity.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "subway_line")
public class SubwayLine {

    @Expose
    @PrimaryKey(autoGenerate = true)
    public Long id;

    @Expose
    public String name; //호선명

    @Expose
    @SerializedName("symbol_res_id")
    @ColumnInfo(name = "symbol_res_id")
    public Long symbolResId; //호선 심볼 리소스 ID

    @Expose
    @SerializedName("color_res_id")
    @ColumnInfo(name = "color_res_id")
    public Long colorResId; //호선 색 리소스 ID

    @Expose
    @SerializedName("icon_res_id")
    @ColumnInfo(name = "icon_res_id")
    public Long iconResId; //호선 아이콘 리소스 ID

    @Expose
    @SerializedName("bg_res_id")
    @ColumnInfo(name = "bg_res_id")
    public Long bgResId; //호선 아이콘 배경 리소스 ID
}
