package devopsdistilled.operp.server.dao;

import java.io.Serializable;

public interface GenericDao<E, PK extends Serializable> {

    PK save(E newInstance);

    void update(E transientObject);

    void saveOrUpdate(E transientObject);

    void delete(E persistentObject);

    E findById(PK id);
}