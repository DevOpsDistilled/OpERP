package devopsdistilled.operp.server.data.service;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.Entiti;

public interface EntityService<E extends Entiti<ID>, ID extends Serializable & Comparable<ID>>
		extends JpaRepository<E, ID>, Serializable {

}
