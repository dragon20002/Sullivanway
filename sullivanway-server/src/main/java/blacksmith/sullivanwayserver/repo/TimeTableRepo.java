package blacksmith.sullivanwayserver.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blacksmith.sullivanwayserver.model.TimeTable;

@Repository
public interface TimeTableRepo extends CrudRepository<TimeTable, Long> {

}
