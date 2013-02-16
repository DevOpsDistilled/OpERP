package devopsdistilled.operp.server.service;

import java.io.Serializable;

public interface GenericService<E, PK extends Serializable> {

    PK save(E newInstance);

    void update(E transientObject);


    void delete(E persistentObject);

    E findById(PK id);
}