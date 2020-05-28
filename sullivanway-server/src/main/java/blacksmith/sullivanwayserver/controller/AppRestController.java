package blacksmith.sullivanwayserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blacksmith.sullivanwayserver.model.Congestion;
import blacksmith.sullivanwayserver.model.Elevator;
import blacksmith.sullivanwayserver.model.SearchHistory;
import blacksmith.sullivanwayserver.model.Station;
import blacksmith.sullivanwayserver.model.StationDetail;
import blacksmith.sullivanwayserver.model.SubwayLine;
import blacksmith.sullivanwayserver.model.SubwayNode;
import blacksmith.sullivanwayserver.model.TimeTable;
import blacksmith.sullivanwayserver.model.TransferMap;
import blacksmith.sullivanwayserver.service.CongestionService;
import blacksmith.sullivanwayserver.service.ElevatorService;
import blacksmith.sullivanwayserver.service.SearchHistoryService;
import blacksmith.sullivanwayserver.service.StationDetailService;
import blacksmith.sullivanwayserver.service.StationService;
import blacksmith.sullivanwayserver.service.SubwayLineService;
import blacksmith.sullivanwayserver.service.SubwayNodeService;
import blacksmith.sullivanwayserver.service.TimeTableService;
import blacksmith.sullivanwayserver.service.TransferMapService;

@RestController
@RequestMapping("/api/subway")
public class AppRestController {

	@Autowired
	private CongestionService congestionService;

	@Autowired
	private ElevatorService elevatorService;

	@Autowired
	private SearchHistoryService searchHistoryService;

	@Autowired
	private StationService stationService;

	@Autowired
	private StationDetailService stationDetailService;

	@Autowired
	private SubwayLineService subwayLineService;

	@Autowired
	private SubwayNodeService subwayNodeService;

	@Autowired
	private TimeTableService timeTableService;

	@Autowired
	private TransferMapService transferMapService;

	@GetMapping(value = "/congestions")
	public ResponseEntity<List<Congestion>> getCongestion() {
	    return new ResponseEntity<>(congestionService.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/elevators")
	public ResponseEntity<List<Elevator>> getElevator() {
	    return new ResponseEntity<>(elevatorService.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/searchhistorys")
	public ResponseEntity<List<SearchHistory>> getSearchHistory() {
	    return new ResponseEntity<>(searchHistoryService.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/stations")
	public ResponseEntity<List<Station>> getStation() {
	    return new ResponseEntity<>(stationService.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/stationdetails")
	public ResponseEntity<List<StationDetail>> getStationDetail() {
	    return new ResponseEntity<>(stationDetailService.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/subwaylines")
	public ResponseEntity<List<SubwayLine>> getSubwayLine() {
	    return new ResponseEntity<>(subwayLineService.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/subwaynodes")
	public ResponseEntity<List<SubwayNode>> getSubwayNode() {
	    return new ResponseEntity<>(subwayNodeService.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/timetables")
	public ResponseEntity<List<TimeTable>> getTimeTable() {
	    return new ResponseEntity<>(timeTableService.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/transfermaps")
	public ResponseEntity<List<TransferMap>> getTransferMap() {
	    return new ResponseEntity<>(transferMapService.getAll(), HttpStatus.OK);
	}

}
