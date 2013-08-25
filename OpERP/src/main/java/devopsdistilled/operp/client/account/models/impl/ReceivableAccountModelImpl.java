package devopsdistilled.operp.client.account.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.account.models.ReceivableAccountModel;
import devopsdistilled.operp.client.account.models.observers.ReceivableAccountModelObserver;
import devopsdistilled.operp.server.data.entity.account.ReceivableAccount;
import devopsdistilled.operp.server.data.service.account.ReceivableAccountService;

public class ReceivableAccountModelImpl
		extends
		AbstractEntityModel<ReceivableAccount, ReceivableAccountService, ReceivableAccountModelObserver>
		implements ReceivableAccountModel {

	@Inject
	private ReceivableAccountService service;

	@Override
	public ReceivableAccountService getService() {
		return service;
	}

}
