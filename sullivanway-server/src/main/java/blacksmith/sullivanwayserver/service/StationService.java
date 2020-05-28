package blacksmith.sullivanwayserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import blacksmith.sullivanwayserver.model.Station;
import blacksmith.sullivanwayserver.repo.StationRepo;

@Service
public class StationService extends BaseService<Station> {

	@Autowired
	StationRepo repo;
	
	@Override
	public CrudRepository<Station, Long> getRepo() {
		return repo;
	}
}
