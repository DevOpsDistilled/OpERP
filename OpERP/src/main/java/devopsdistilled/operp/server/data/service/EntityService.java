package devopsdistilled.operp.server.data.service;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.Entiti;

public interface EntityService<E extends Entiti<?>, ID extends Serializable>
		extends JpaRepository<E, ID>, Serializable {

	public boolean isEntityNameExists(String entityName);

	public boolean isEntityNameValidForTheEntity(ID id, String entityName);

}
