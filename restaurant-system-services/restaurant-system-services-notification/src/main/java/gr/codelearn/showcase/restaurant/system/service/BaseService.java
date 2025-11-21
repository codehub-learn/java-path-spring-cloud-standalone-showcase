package gr.codelearn.showcase.restaurant.system.service;

import java.util.List;

public interface BaseService<T, K> {
	T create(final T item);

	List<T> createAll(final List<T> items);

	void update(T item);

	void deleteById(K id);

	T get(K id);

	List<T> findAll();

	Long count();
}