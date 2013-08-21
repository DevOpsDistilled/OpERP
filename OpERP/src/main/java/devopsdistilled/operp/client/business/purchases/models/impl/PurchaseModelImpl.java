package devopsdistilled.operp.client.business.purchases.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.business.purchases.models.observers.PurchaseModelObserver;
import devopsdistilled.operp.server.data.entity.business.Purchase;
import devopsdistilled.operp.server.data.service.sales.PurchaseService;

public class PurchaseModelImpl extends
		AbstractEntityModel<Purchase, PurchaseService, PurchaseModelObserver> {

	@Inject
	private PurchaseService service;

	@Override
	public PurchaseService getService() {
		return service;
	}

}
