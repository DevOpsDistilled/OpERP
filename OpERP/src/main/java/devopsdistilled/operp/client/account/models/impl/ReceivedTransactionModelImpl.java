package devopsdistilled.operp.client.account.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.account.models.ReceivedTransactionModel;
import devopsdistilled.operp.client.account.models.observers.ReceivedTransactionModelObserver;
import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;
import devopsdistilled.operp.server.data.service.account.ReceivedTransactionService;

public class ReceivedTransactionModelImpl
		extends
		AbstractEntityModel<ReceivedTransaction, ReceivedTransactionService, ReceivedTransactionModelObserver>
		implements ReceivedTransactionModel {

	@Inject
	private ReceivedTransactionService service;

	@Override
	public ReceivedTransactionService getService() {
		return service;
	}

}
