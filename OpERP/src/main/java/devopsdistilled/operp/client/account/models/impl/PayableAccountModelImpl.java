package devopsdistilled.operp.client.account.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.account.models.PayableAccountModel;
import devopsdistilled.operp.client.account.models.observers.PayableAccountModelObserver;
import devopsdistilled.operp.server.data.entity.account.PayableAccount;
import devopsdistilled.operp.server.data.service.account.PayableAccountService;

public class PayableAccountModelImpl
		extends
		AbstractEntityModel<PayableAccount, PayableAccountService, PayableAccountModelObserver>
		implements PayableAccountModel {

	@Inject
	private PayableAccountService service;

	@Override
	public PayableAccountService getService() {
		return service;
	}

}
