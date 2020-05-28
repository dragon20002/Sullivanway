package blacksmith.sullivanwayserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import blacksmith.sullivanwayserver.model.SearchHistory;
import blacksmith.sullivanwayserver.repo.SearchHistoryRepo;

@Service
public class SearchHistoryService extends BaseService<SearchHistory> {

	@Autowired
	SearchHistoryRepo repo;
	
	@Override
	public CrudRepository<SearchHistory, Long> getRepo() {
		return repo;
	}
}
