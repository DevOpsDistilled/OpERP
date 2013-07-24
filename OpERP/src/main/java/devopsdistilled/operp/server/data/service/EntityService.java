package devopsdistilled.operp.server.data.service;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityService<T, ID extends Serializable> extends
		JpaRepository<T, ID>, Serializable {

}
