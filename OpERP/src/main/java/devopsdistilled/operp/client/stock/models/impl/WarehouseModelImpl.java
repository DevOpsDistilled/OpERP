package devopsdistilled.operp.client.stock.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.models.observers.WarehouseModelObserver;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;
import devopsdistilled.operp.server.data.service.stock.WarehouseService;

public class WarehouseModelImpl extends 
		AbstractEntityModel<Warehouse, WarehouseService, WarehouseModelObserver, Long>
		implements WarehouseModel{
	
	@Inject
	private  WarehouseService service;
	
	@Override
	public WarehouseService getService() {
		return service ;
	}

	@Override
	protected Class<WarehouseModelObserver> getObserverClass() {
		return WarehouseModelObserver.class;
	}

}
