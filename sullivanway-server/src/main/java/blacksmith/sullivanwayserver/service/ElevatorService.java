package blacksmith.sullivanwayserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import blacksmith.sullivanwayserver.model.Elevator;
import blacksmith.sullivanwayserver.repo.ElevatorRepo;

@Service
public class ElevatorService extends BaseService<Elevator> {

	@Autowired
	ElevatorRepo repo;

	@Override
	public CrudRepository<Elevator, Long> getRepo() {
		return repo;
	}
}
