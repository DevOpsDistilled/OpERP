package devopsdistilled.operp.server.data.repo.account;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.account.PayableAccount;

public interface PayableAccountRepository extends
		JpaRepository<PayableAccount, Long> {

}
