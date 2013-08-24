package devopsdistilled.operp.server.data.service.account.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import devopsdistilled.operp.server.data.entity.account.PaidTransaction;
import devopsdistilled.operp.server.data.repo.account.PaidTransactionRepository;
import devopsdistilled.operp.server.data.service.account.PaidTransactionService;
import devopsdistilled.operp.server.data.service.account.PayableAccountService;

@Service
public class PaidTransactionServiceImpl extends
		TransactionServiceImpl<PaidTransaction, PaidTransactionRepository>
		implements PaidTransactionService {

	private static final long serialVersionUID = 8946536638729817665L;

	@Inject
	private PaidTransactionRepository repo;

	@Inject
	private PayableAccountService payableAccountService;

	@Override
	protected PaidTransactionRepository getRepo() {
		return repo;
	}

	@Override
	@Transactional
	public <S extends PaidTransaction> S save(S transaction) {
		transaction.setTransactionDate(new Date());
		transaction = super.save(transaction);

		Double initBalance = transaction.getAccount().getBalance();
		Double afterTranBalance = initBalance - transaction.getAmount();
		transaction.getAccount().setBalance(afterTranBalance);
		payableAccountService.save(transaction.getAccount());
		return transaction;
	}

}
