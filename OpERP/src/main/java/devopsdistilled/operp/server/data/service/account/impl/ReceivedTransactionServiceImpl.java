package devopsdistilled.operp.server.data.service.account.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;
import devopsdistilled.operp.server.data.repo.account.ReceivedTransactionRepository;
import devopsdistilled.operp.server.data.service.account.ReceivableAccountService;
import devopsdistilled.operp.server.data.service.account.ReceivedTransactionService;

@Service
public class ReceivedTransactionServiceImpl
		extends
		TransactionServiceImpl<ReceivedTransaction, ReceivedTransactionRepository>
		implements ReceivedTransactionService {

	private static final long serialVersionUID = -8134555856017276841L;

	@Inject
	private ReceivedTransactionRepository repo;

	@Inject
	private ReceivableAccountService receivableAccountService;

	@Override
	protected ReceivedTransactionRepository getRepo() {
		return repo;
	}

	@Override
	@Transactional
	public <S extends ReceivedTransaction> S save(S transaction) {
		transaction.setTransactionDate(new Date());
		transaction = super.save(transaction);

		Double initBalance = transaction.getAccount().getBalance();
		Double afterTranBalance = initBalance - transaction.getAmount();
		transaction.getAccount().setBalance(afterTranBalance);
		receivableAccountService.save(transaction.getAccount());
		return transaction;
	}

}
