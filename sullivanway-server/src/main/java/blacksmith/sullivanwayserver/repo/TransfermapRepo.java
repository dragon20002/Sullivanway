package blacksmith.sullivanwayserver.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blacksmith.sullivanwayserver.model.TransferMap;

@Repository
public interface TransferMapRepo extends CrudRepository<TransferMap, Long> {

}
