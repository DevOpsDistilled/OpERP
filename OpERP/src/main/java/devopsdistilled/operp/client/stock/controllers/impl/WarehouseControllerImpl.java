package devopsdistilled.operp.client.stock.controllers.impl;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;

import devopsdistilled.operp.client.stock.controllers.WarehouseController;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.panes.controllers.CreateWarehousePaneController;
import devopsdistilled.operp.client.stock.panes.controllers.EditWarehousePaneController;
import devopsdistilled.operp.client.stock.panes.controllers.ListWarehousePaneController;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class WarehouseControllerImpl implements WarehouseController{
	
	@Inject
	private ApplicationContext context;
	
	@Inject
	private WarehouseModel warehouseModel;
	
	
	@Override
	public void create() {
		CreateWarehousePaneController createWarehousePaneController=context
				.getBean(CreateWarehousePaneController.class);
		createWarehousePaneController.init();
		
	}


	@Override
	public void list() {
		ListWarehousePaneController listWarehousePaneController=context
				.getBean(ListWarehousePaneController.class);
		listWarehousePaneController.init();
		
		
	}

	@Override
	public void edit(Warehouse warehouse) {
		EditWarehousePaneController editWarehousePaneController=context.
				getBean(EditWarehousePaneController.class);
		editWarehousePaneController.init(warehouse);
		
	}
	
	@Override
	public void delete(Warehouse warehouse) {
		warehouseModel.deleteAndUpdateModel(warehouse);
		
	}





	

}
