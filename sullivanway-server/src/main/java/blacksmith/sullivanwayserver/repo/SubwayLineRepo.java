package blacksmith.sullivanwayserver.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blacksmith.sullivanwayserver.model.SubwayLine;

@Repository
public interface SubwayLineRepo extends CrudRepository<SubwayLine, Long> {

}
