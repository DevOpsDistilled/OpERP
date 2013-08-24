package devopsdistilled.operp.server.data.repo.business;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.business.PurchaseDescRow;

public interface PurchaseDescRowRepository extends
		JpaRepository<PurchaseDescRow, Long> {

}
