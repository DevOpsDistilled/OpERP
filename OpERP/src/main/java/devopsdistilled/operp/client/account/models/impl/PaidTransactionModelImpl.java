package devopsdistilled.operp.client.account.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.account.models.PaidTransactionModel;
import devopsdistilled.operp.client.account.models.observers.PaidTransactionModelObserver;
import devopsdistilled.operp.server.data.entity.account.PaidTransaction;
import devopsdistilled.operp.server.data.service.account.PaidTransactionService;

public class PaidTransactionModelImpl
		extends
		AbstractEntityModel<PaidTransaction, PaidTransactionService, PaidTransactionModelObserver>
		implements PaidTransactionModel {

	@Inject
	private PaidTransactionService service;

	@Override
	public PaidTransactionService getService() {
		return service;
	}

}
