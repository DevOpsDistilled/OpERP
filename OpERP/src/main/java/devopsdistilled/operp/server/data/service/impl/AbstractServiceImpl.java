package devopsdistilled.operp.server.data.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public class AbstractServiceImpl<T> implements JpaRepository<T, Serializable> {

	protected JpaRepository<T, Serializable> repo;

	@Override
	public Page<T> findAll(Pageable pageable) {

		return repo.findAll(pageable);
	}

	@Override
	public <S extends T> S save(S entity) {
		return repo.save(entity);
	}

	@Override
	public T findOne(Serializable id) {
		return repo.findOne(id);
	}

	@Override
	public boolean exists(Serializable id) {
		return exists(id);
	}

	@Override
	public Iterable<T> findAll(Iterable<Serializable> ids) {
		return findAll(ids);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public void delete(Serializable id) {
		repo.delete(id);
	}

	@Override
	public void delete(T entity) {
		repo.delete(entity);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		repo.delete(entities);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	@Override
	public List<T> findAll() {
		return repo.findAll();
	}

	@Override
	public List<T> findAll(Sort sort) {
		return repo.findAll(sort);
	}

	@Override
	public <S extends T> List<S> save(Iterable<S> entities) {
		return repo.save(entities);
	}

	@Override
	public void flush() {
		repo.flush();
	}

	@Override
	public T saveAndFlush(T entity) {
		return saveAndFlush(entity);
	}

	@Override
	public void deleteInBatch(Iterable<T> entities) {
		repo.deleteInBatch(entities);
	}

	@Override
	public void deleteAllInBatch() {
		repo.deleteAllInBatch();
	}

}
