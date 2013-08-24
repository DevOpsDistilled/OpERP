package devopsdistilled.operp.server.data.repo.party;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.party.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
