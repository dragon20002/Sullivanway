package blacksmith.sullivanwayserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import blacksmith.sullivanwayserver.model.Congestion;
import blacksmith.sullivanwayserver.repo.CongestionRepo;

@Service
public class CongestionService extends BaseService<Congestion> {

	@Autowired
	CongestionRepo repo;

	@Override
	public CrudRepository<Congestion, Long> getRepo() {
		return repo;
	}
	
}
