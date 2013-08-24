package devopsdistilled.operp.client.business.purchases.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.business.purchases.models.PurchaseModel;
import devopsdistilled.operp.client.business.purchases.models.observers.PurchaseModelObserver;
import devopsdistilled.operp.server.data.entity.business.Purchase;
import devopsdistilled.operp.server.data.service.business.PurchaseService;

public class PurchaseModelImpl extends
		AbstractEntityModel<Purchase, PurchaseService, PurchaseModelObserver>
		implements PurchaseModel {

	@Inject
	private PurchaseService service;

	@Override
	public PurchaseService getService() {
		return service;
	}

}
