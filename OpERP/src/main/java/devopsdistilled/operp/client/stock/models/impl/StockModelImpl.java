package devopsdistilled.operp.client.stock.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.models.observers.StockModelObserver;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.service.stock.StockService;

public class StockModelImpl extends 
		AbstractEntityModel<Stock, StockService, StockModelObserver, Long>
		implements StockModel{

	@Override
	public StockService getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<StockModelObserver> getObserverClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
