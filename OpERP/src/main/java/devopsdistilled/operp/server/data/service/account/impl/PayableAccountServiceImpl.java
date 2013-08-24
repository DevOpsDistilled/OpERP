package devopsdistilled.operp.server.data.service.account.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.account.PayableAccount;
import devopsdistilled.operp.server.data.repo.account.PayableAccountRepository;
import devopsdistilled.operp.server.data.service.account.PayableAccountService;

@Service
public class PayableAccountServiceImpl extends
		AccountServiceImpl<PayableAccount, PayableAccountRepository> implements
		PayableAccountService {

	private static final long serialVersionUID = -2228578598359971560L;

	@Inject
	private PayableAccountRepository repo;

	@Override
	protected PayableAccountRepository getRepo() {
		return repo;
	}

}
