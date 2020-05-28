package blacksmith.sullivanwayserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import blacksmith.sullivanwayserver.model.SubwayLine;
import blacksmith.sullivanwayserver.repo.SubwayLineRepo;

@Service
public class SubwayLineService extends BaseService<SubwayLine> {

	@Autowired
	SubwayLineRepo repo;
	
	@Override
	public CrudRepository<SubwayLine, Long> getRepo() {
		return repo;
	}
	
}
