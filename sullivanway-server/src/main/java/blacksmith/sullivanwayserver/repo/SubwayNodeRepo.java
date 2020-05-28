package blacksmith.sullivanwayserver.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blacksmith.sullivanwayserver.model.SubwayNode;

@Repository
public interface SubwayNodeRepo extends CrudRepository<SubwayNode, Long> {

}
