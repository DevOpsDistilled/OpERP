package devopsdistilled.operp.server.dao;

import java.io.Serializable;

public interface GenericDao<E, PK extends Serializable> {

    E create(E newInstance);

    void update(E transientObject);

    void delete(E persistentObject);

    E findById(PK id);
}