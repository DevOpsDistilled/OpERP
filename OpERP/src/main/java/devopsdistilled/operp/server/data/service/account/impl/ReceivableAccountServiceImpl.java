package devopsdistilled.operp.server.data.service.account.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.account.ReceivableAccount;
import devopsdistilled.operp.server.data.repo.account.ReceivableAccountRepository;
import devopsdistilled.operp.server.data.service.account.ReceivableAccountService;

@Service
public class ReceivableAccountServiceImpl extends
		AccountServiceImpl<ReceivableAccount, ReceivableAccountRepository>
		implements ReceivableAccountService {

	private static final long serialVersionUID = -2228578598359971560L;

	@Inject
	private ReceivableAccountRepository repo;

	@Override
	protected ReceivableAccountRepository getRepo() {
		return repo;
	}

}
