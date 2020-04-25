package blacksmith.sullivanway.data.entity.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

@Entity(
    tableName = "subway_node",
    primaryKeys = {
        "id"
    }
)

public class SubwayNode {

    @Expose
    @PrimaryKey(autoGenerate = true)
    public Long id;

    @Expose
    public Integer x; //가로 터치 위치

    @Expose
    public Integer y; //세로 터치 위치
}