package devopsdistilled.operp.server.data.service.account.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;
import devopsdistilled.operp.server.data.repo.account.ReceivedTransactionRepository;
import devopsdistilled.operp.server.data.service.account.ReceivedTransactionService;

@Service
public class ReceivedTransactionServiceImpl
		extends
		TransactionServiceImpl<ReceivedTransaction, ReceivedTransactionRepository>
		implements ReceivedTransactionService {

	private static final long serialVersionUID = -8134555856017276841L;

	@Inject
	private ReceivedTransactionRepository repo;

	@Override
	protected ReceivedTransactionRepository getRepo() {
		return repo;
	}

}
