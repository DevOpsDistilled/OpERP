package devopsdistilled.operp.server.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import devopsdistilled.operp.server.dao.GenericDao;

public abstract class GenericDaoImpl<E, PK extends Serializable> implements
	GenericDao<E, PK> {

    protected SessionFactory sessionFactory;

    private Session currentSession() {
	return this.sessionFactory.getCurrentSession();
    }

    public SessionFactory getSessionFactory() {
	return sessionFactory;
    }

    protected abstract Class<E> getEntityClass();

    @SuppressWarnings("unchecked")
    @Override
    public PK save(E newInstance) {
	return (PK) currentSession().save(newInstance);
    }

    @SuppressWarnings("unchecked")
    @Override
    public E findById(PK id) {
	return (E) currentSession().get(getEntityClass(), id);
    }

    @Override
    public void update(E transientObject) {
	currentSession().update(transientObject);
    }

    @Override
    public void saveOrUpdate(E transientObject) {
	currentSession().saveOrUpdate(transientObject);
    }

    @Override
    public void delete(E persistentObject) {
	currentSession().delete(persistentObject);
    }

}