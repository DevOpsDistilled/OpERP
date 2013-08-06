package devopsdistilled.operp.client.stock.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.stock.models.observers.ItemWarehouseCatalogModelObserver;
import devopsdistilled.operp.server.data.entity.stock.ItemWarehouseCatalog;
import devopsdistilled.operp.server.data.service.stock.ItemWarehouseCatalogService;

public interface ItemWarehouseCatalogModel extends 
		EntityModel<ItemWarehouseCatalog, ItemWarehouseCatalogService, ItemWarehouseCatalogModelObserver>{

}
