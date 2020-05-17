package blacksmith.sullivanway.data.entity.others;

import blacksmith.sullivanway.data.entity.db.Station;
import blacksmith.sullivanway.data.entity.db.SubwayLine;

public class StationVo {

    public Station station;

    public SubwayLine subwayLine;

    public StationVo(Station station, SubwayLine subwayLine) {
        this.station = station;
        this.subwayLine = subwayLine;
    }

}
