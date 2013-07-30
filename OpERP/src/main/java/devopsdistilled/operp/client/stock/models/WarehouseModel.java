package devopsdistilled.operp.client.stock.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.stock.models.observers.WarehouseModelObserver;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;
import devopsdistilled.operp.server.data.service.stock.WarehouseService;

public interface WarehouseModel extends 
		EntityModel<Warehouse, WarehouseService, WarehouseModelObserver, Long>{

}
