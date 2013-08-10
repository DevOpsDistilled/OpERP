package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.panes.EditWarehousePane;
import devopsdistilled.operp.client.stock.panes.controllers.EditWarehousePaneController;
import devopsdistilled.operp.client.stock.panes.models.EditWarehousePaneModel;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class EditWarehousePaneControllerImpl implements 
		EditWarehousePaneController {
	
	@Inject
	private EditWarehousePane view;
	
	@Inject
	private EditWarehousePaneModel model;
	
	@Inject
	private WarehouseModel warehouseModel;

	@Override
	public void init(Warehouse warehouse) {
		view.init();
		model.setEntity(warehouse);
		model.registerObserver(view);
	
		
	}
	@Override
	public void validate(Warehouse warehouse) throws NullFieldException,
			EntityNameExistsException {
		if(warehouse.getWarehouseName().equalsIgnoreCase("")){
			throw new NullFieldException();
		}
		
		if(!warehouseModel.getService().isWarehouseNameValidForWarehouse(
				warehouse.getWarehouseId(), warehouse.getWarehouseName())){
				
			throw new EntityNameExistsException();
			
		}
	}
	@Override
	public Warehouse save(Warehouse warehouse) {
		return warehouseModel.saveAndUpdateModel(warehouse);
	}

}
