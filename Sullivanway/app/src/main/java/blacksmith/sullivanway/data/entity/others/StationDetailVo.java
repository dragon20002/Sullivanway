package blacksmith.sullivanway.data.entity.others;

import java.util.List;

import blacksmith.sullivanway.data.entity.db.Elevator;
import blacksmith.sullivanway.data.entity.db.Station;
import blacksmith.sullivanway.data.entity.db.StationDetail;
import blacksmith.sullivanway.data.entity.db.SubwayLine;
import blacksmith.sullivanway.data.entity.db.SubwayNode;

public class StationDetailVo {

    public Station station;

    public StationDetail stationDetail;

    public List<Elevator> elevators;

    public StationDetailVo(Station station, StationDetail stationDetail, List<Elevator> elevators) {
        this.station = station;
        this.stationDetail = stationDetail;
        this.elevators = elevators;
    }

}
