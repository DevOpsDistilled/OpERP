package devopsdistilled.operp.server.data.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.service.AbstractService;

public abstract class AbstractServiceImpl<T, ID extends Serializable>
		implements AbstractService<T, ID> {

	private static final long serialVersionUID = 4892118695516828793L;

	protected abstract JpaRepository<T, ID> getRepo();

	@Override
	public List<T> findAll() {
		return getRepo().findAll();
	}

	@Override
	public List<T> findAll(Sort sort) {
		return getRepo().findAll(sort);
	}

	@Override
	public <S extends T> List<S> save(Iterable<S> entities) {
		return getRepo().save(entities);
	}

	@Override
	public void flush() {
		getRepo().flush();
	}

	@Override
	public T saveAndFlush(T entity) {
		return getRepo().saveAndFlush(entity);
	}

	@Override
	public void deleteInBatch(Iterable<T> entities) {
		getRepo().deleteInBatch(entities);
	}

	@Override
	public void deleteAllInBatch() {
		getRepo().deleteAllInBatch();
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return getRepo().findAll(pageable);
	}

	@Override
	public <S extends T> S save(S entity) {
		return getRepo().save(entity);
	}

	@Override
	public T findOne(ID id) {
		return getRepo().findOne(id);
	}

	@Override
	public boolean exists(ID id) {
		return getRepo().exists(id);
	}

	@Override
	public long count() {
		return getRepo().count();
	}

	@Override
	public void delete(ID id) {
		getRepo().delete(id);
	}

	@Override
	public void delete(T entity) {
		getRepo().delete(entity);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		getRepo().delete(entities);
	}

	@Override
	public void deleteAll() {
		getRepo().deleteAll();
	}

	@Override
	public Iterable<T> findAll(Iterable<ID> ids) {
		return getRepo().findAll(ids);
	}
}
