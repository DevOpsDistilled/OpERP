package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.panes.CreateWarehousePane;
import devopsdistilled.operp.client.stock.panes.controllers.CreateWarehousePaneController;
import devopsdistilled.operp.client.stock.panes.models.CreateWarehousePaneModel;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class CreateWareHousePaneControllerImpl implements
		CreateWarehousePaneController {

	@Inject
	private CreateWarehousePaneModel model;

	@Inject
	private CreateWarehousePane view;

	@Inject
	private WarehouseModel warehouseModel;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);

	}

	@Override
	public void validate(Warehouse warehouse) throws NullFieldException,
			EntityNameExistsException {
		if (warehouse.getWarehouseName().equals(new String(""))) {
			throw new NullFieldException();
		}

		if (warehouseModel.getService().isWarehouseNameExists(
				warehouse.getWarehouseName()))
			throw new EntityNameExistsException();

	}

	@Override
	public Warehouse save(Warehouse warehouse) {
		Warehouse savedWarehouse = warehouseModel.saveAndUpdateModel(warehouse);
		return savedWarehouse;

	}

}
