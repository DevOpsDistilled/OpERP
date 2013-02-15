package devopsdistilled.operp.server.service.impl;

import java.io.Serializable;

import devopsdistilled.operp.server.dao.GenericDao;
import devopsdistilled.operp.server.service.GenericService;

public abstract class GenericServiceImpl<E, PK extends Serializable> implements
	GenericService<E, PK> {

    protected abstract GenericDao<E, PK> getDao();

    @Override
    public PK save(E newInstance) {
	return getDao().save(newInstance);
    }

    @Override
    public E findById(PK id) {
	return getDao().findById(id);
    }

    @Override
    public void update(E transientObject) {
	getDao().update(transientObject);
    }

    @Override
    public void saveOrUpdate(E transientObject) {
	getDao().saveOrUpdate(transientObject);
    }

    @Override
    public void delete(E persistentObject) {
	getDao().delete(persistentObject);
    }

}
