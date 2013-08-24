package devopsdistilled.operp.server.data.repo.account;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.account.ReceivableAccount;

public interface ReceivableAccountRepository extends
		JpaRepository<ReceivableAccount, Long> {

}
