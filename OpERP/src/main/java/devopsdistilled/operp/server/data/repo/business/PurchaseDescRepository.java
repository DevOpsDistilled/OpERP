package devopsdistilled.operp.server.data.repo.business;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.business.PurchaseDesc;

public interface PurchaseDescRepository extends
		JpaRepository<PurchaseDesc, Long> {

}
