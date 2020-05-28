package blacksmith.sullivanwayserver.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blacksmith.sullivanwayserver.model.SearchHistory;

@Repository
public interface SearchHistoryRepo extends CrudRepository<SearchHistory, Long> {

}
