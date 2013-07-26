package devopsdistilled.operp.client.stock.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.models.observers.WarehouseModelObserver;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;
import devopsdistilled.operp.server.data.service.stock.WarehouseService;

public class WarehouseModelImpl extends 
		AbstractEntityModel<Warehouse, WarehouseService, WarehouseModelObserver, Long> 
		implements WarehouseModel{

	@Override
	public WarehouseService getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<WarehouseModelObserver> getObserverClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
