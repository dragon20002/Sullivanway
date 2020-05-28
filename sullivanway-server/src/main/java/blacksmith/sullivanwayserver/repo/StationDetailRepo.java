package blacksmith.sullivanwayserver.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blacksmith.sullivanwayserver.model.StationDetail;

@Repository
public interface StationDetailRepo extends CrudRepository<StationDetail, Long> {

}
