package devopsdistilled.operp.server.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import devopsdistilled.operp.server.dao.GenericDao;

public abstract class GenericDaoImpl<E, PK extends Serializable> implements
	GenericDao<E, PK> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected abstract Class<E> getEntityClass();

    @Override
    public E create(E newInstance) {
	this.entityManager.persist(newInstance);
	return newInstance;
    }

    @Override
    public void update(E transientObject) {
	this.entityManager.merge(transientObject);
    }

    @Override
    public void delete(E persistentObject) {
	this.entityManager.remove(persistentObject);
    }

    @Override
    public E findById(PK id) {
	return null;
    }

}