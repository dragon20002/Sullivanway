package blacksmith.sullivanwayserver.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public abstract class BaseService<T> {

	public abstract CrudRepository<T, Long> getRepo();

	public List<T> getAll() {
		List<T> list = new ArrayList<>();
		getRepo().findAll().forEach((row) -> {
			list.add(row);
		});
		return list;
	}
}
