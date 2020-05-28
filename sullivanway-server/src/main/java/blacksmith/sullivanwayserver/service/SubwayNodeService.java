package blacksmith.sullivanwayserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import blacksmith.sullivanwayserver.model.SubwayNode;
import blacksmith.sullivanwayserver.repo.SubwayNodeRepo;

@Service
public class SubwayNodeService extends BaseService<SubwayNode> {

	@Autowired
	SubwayNodeRepo repo;
	
	@Override
	public CrudRepository<SubwayNode, Long> getRepo() {
		return repo;
	}
	
}
