package devopsdistilled.operp.server.data.repo.commons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devopsdistilled.operp.server.data.entity.commons.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
