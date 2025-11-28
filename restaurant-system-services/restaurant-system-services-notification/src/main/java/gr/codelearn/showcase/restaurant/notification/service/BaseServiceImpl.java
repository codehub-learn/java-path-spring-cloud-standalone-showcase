package gr.codelearn.showcase.restaurant.notification.service;

import gr.codelearn.showcase.restaurant.notification.component.BaseComponent;
import gr.codelearn.showcase.restaurant.notification.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T, K> extends BaseComponent implements BaseService<T, K> {
	public abstract JpaRepository<T, K> getRepository();

	@Override
	public List<T> createAll(final List<T> items) {
		return getRepository().saveAll(items);
	}

	@Override
	public T create(final T item) {
		logger.trace("Creating {}.", item);
		return getRepository().save(item);
	}

	@Override
	public void update(final T item) {
		logger.trace("Updating {}.", item);
		getRepository().save(item);
	}

	@Override
	public void deleteById(final K id) {
		final T itemFound = getRepository().getReferenceById(id);
		logger.trace("Deleting {}.", itemFound);
		getRepository().deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public T get(final K id) {
		T item = getRepository().findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource #%s not found".formatted(id)));
		logger.trace("Item found matching id:{}.", id);
		return item;
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> findAll() {
		logger.trace("Retrieving all items.");
		return getRepository().findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return getRepository().count();
	}
}