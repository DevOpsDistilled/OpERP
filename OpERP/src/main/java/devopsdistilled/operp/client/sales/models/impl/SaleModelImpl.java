package devopsdistilled.operp.client.sales.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.sales.models.observers.SaleModelObserver;
import devopsdistilled.operp.server.data.entity.business.Sale;
import devopsdistilled.operp.server.data.service.sales.SaleService;

public class SaleModelImpl extends
		AbstractEntityModel<Sale, SaleService, SaleModelObserver> {

	@Inject
	private SaleService service;

	@Override
	public SaleService getService() {
		return service;
	}

}
