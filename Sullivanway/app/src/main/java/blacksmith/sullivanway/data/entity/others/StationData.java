package blacksmith.sullivanway.data.entity.others;

import java.util.List;

import blacksmith.sullivanway.data.entity.db.Congestion;
import blacksmith.sullivanway.data.entity.db.Elevator;
import blacksmith.sullivanway.data.entity.db.Station;
import blacksmith.sullivanway.data.entity.db.StationDetail;
import blacksmith.sullivanway.data.entity.db.SubwayLine;
import blacksmith.sullivanway.data.entity.db.TimeTable;
import blacksmith.sullivanway.data.entity.db.TransferMap;

public class StationData {

    public SubwayLine subwayLine;

    public Station station;

    public StationDetail stationDetail;

    public List<Elevator> elevators;

    public List<Congestion> congestions;

    public List<TimeTable> timeTables;

    public List<TransferMap> transferMaps;

    public StationData(SubwayLine subwayLine, Station station, StationDetail stationDetail, List<Elevator> elevators, List<Congestion> congestions, List<TimeTable> timeTables, List<TransferMap> transferMaps) {
        this.subwayLine = subwayLine;
        this.station = station;
        this.stationDetail = stationDetail;
        this.elevators = elevators;
        this.congestions = congestions;
        this.timeTables = timeTables;
        this.transferMaps = transferMaps;
    }

}
