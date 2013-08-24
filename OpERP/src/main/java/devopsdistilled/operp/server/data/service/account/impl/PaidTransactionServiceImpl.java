package devopsdistilled.operp.server.data.service.account.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.account.PaidTransaction;
import devopsdistilled.operp.server.data.repo.account.PaidTransactionRepository;
import devopsdistilled.operp.server.data.service.account.PaidTransactionService;

@Service
public class PaidTransactionServiceImpl extends
		TransactionServiceImpl<PaidTransaction, PaidTransactionRepository>
		implements PaidTransactionService {

	private static final long serialVersionUID = 8946536638729817665L;

	@Inject
	private PaidTransactionRepository repo;

	@Override
	protected PaidTransactionRepository getRepo() {
		return repo;
	}

}
