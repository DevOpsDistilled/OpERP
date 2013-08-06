package devopsdistilled.operp.client.stock.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.stock.models.ItemWarehouseCatalogModel;
import devopsdistilled.operp.client.stock.models.observers.ItemWarehouseCatalogModelObserver;
import devopsdistilled.operp.server.data.entity.stock.ItemWarehouseCatalog;
import devopsdistilled.operp.server.data.service.stock.ItemWarehouseCatalogService;

public class ItemWarehouseCatalogModelImpl extends 
		AbstractEntityModel<ItemWarehouseCatalog, ItemWarehouseCatalogService, ItemWarehouseCatalogModelObserver>
		implements ItemWarehouseCatalogModel{

	@Inject
	private ItemWarehouseCatalogService service;
	
	@Override
	public ItemWarehouseCatalogService getService() {
		return service;
	}

}
