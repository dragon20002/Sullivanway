package blacksmith.sullivanwayserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import blacksmith.sullivanwayserver.model.StationDetail;
import blacksmith.sullivanwayserver.repo.StationDetailRepo;

@Service
public class StationDetailService extends BaseService<StationDetail> {

	@Autowired
	StationDetailRepo repo;
	
	@Override
	public CrudRepository<StationDetail, Long> getRepo() {
		return repo;
	}
	
}
