package blacksmith.sullivanwayserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import blacksmith.sullivanwayserver.model.TransferMap;
import blacksmith.sullivanwayserver.repo.TransferMapRepo;

@Service
public class TransferMapService extends BaseService<TransferMap> {

	@Autowired
	TransferMapRepo repo;
	
	@Override
	public CrudRepository<TransferMap, Long> getRepo() {
		return repo;
	}
}
