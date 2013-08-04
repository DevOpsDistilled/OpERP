package devopsdistilled.operp.server.data.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.service.EntityService;

public abstract class AbstractEntityService<E extends Entiti<?>, ID extends Serializable, ER extends JpaRepository<E, ID>>
		implements EntityService<E, ID> {

	private static final long serialVersionUID = 4892118695516828793L;

	protected abstract ER getRepo();

	@Override
	public boolean isEntityNameExists(String entityName) {
		E entity = findByEntityName(entityName);
		if (entity != null)
			return true;

		return false;
	}

	@Override
	public boolean isEntityNameValidForTheEntity(ID id, String entityName) {
		E entity = findByEntityName(entityName);

		if (entity == null)
			return true;

		if (entity.id().equals(id))
			return true;

		return false;
	}

	protected abstract E findByEntityName(String entityName);

	@Override
	public List<E> findAll() {
		return getRepo().findAll();
	}

	@Override
	public List<E> findAll(Sort sort) {
		return getRepo().findAll(sort);
	}

	@Override
	public <S extends E> List<S> save(Iterable<S> entities) {
		return getRepo().save(entities);
	}

	@Override
	public void flush() {
		getRepo().flush();
	}

	@Override
	public E saveAndFlush(E entity) {
		return getRepo().saveAndFlush(entity);
	}

	@Override
	public void deleteInBatch(Iterable<E> entities) {
		getRepo().deleteInBatch(entities);
	}

	@Override
	public void deleteAllInBatch() {
		getRepo().deleteAllInBatch();
	}

	@Override
	public Page<E> findAll(Pageable pageable) {
		return getRepo().findAll(pageable);
	}

	@Override
	public <S extends E> S save(S entity) {
		return getRepo().save(entity);
	}

	@Override
	public E findOne(ID id) {
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
	public void delete(E entity) {
		getRepo().delete(entity);
	}

	@Override
	public void delete(Iterable<? extends E> entities) {
		getRepo().delete(entities);
	}

	@Override
	public void deleteAll() {
		getRepo().deleteAll();
	}

	@Override
	public Iterable<E> findAll(Iterable<ID> ids) {
		return getRepo().findAll(ids);
	}
}
