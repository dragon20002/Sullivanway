package blacksmith.sullivanwayserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import blacksmith.sullivanwayserver.model.TimeTable;
import blacksmith.sullivanwayserver.repo.TimeTableRepo;

@Service
public class TimeTableService extends BaseService<TimeTable> {

	@Autowired
	TimeTableRepo repo;

	@Override
	public CrudRepository<TimeTable, Long> getRepo() {
		return repo;
	}
}
