package devopsdistilled.operp.client.stock.controllers.impl;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;

import devopsdistilled.operp.client.stock.controllers.WarehouseController;
import devopsdistilled.operp.client.stock.panes.controllers.CreateWarehousePaneController;
import devopsdistilled.operp.client.stock.panes.models.CreateWarehousePaneModel;
import devopsdistilled.operp.server.data.service.stock.WarehouseService;

public class WarehouseControllerImpl implements WarehouseController{
	
	@Inject
	private ApplicationContext context;
	
	@Inject
	private CreateWarehousePaneModel model;
	
	
	@Override
	public void createWarehouse() {
		CreateWarehousePaneController createWarehousePaneController=context
				.getBean(CreateWarehousePaneController.class);
		createWarehousePaneController.init();
		
	}

}
