package devopsdistilled.operp.client.stock.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.models.observers.StockModelObserver;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;
import devopsdistilled.operp.server.data.service.stock.StockService;

public class StockModelImpl extends
		AbstractEntityModel<StockKeeper, StockService, StockModelObserver> implements
		StockModel {

	@Inject
	private StockService service;

	@Override
	public StockService getService() {
		return service;
	}

	@Override
	protected Class<StockModelObserver> getObserverClass() {
		return StockModelObserver.class;
	}

}
