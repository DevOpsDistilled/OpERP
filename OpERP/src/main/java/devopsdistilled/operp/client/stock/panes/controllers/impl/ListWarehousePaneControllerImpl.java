package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.panes.ListWarehousePane;
import devopsdistilled.operp.client.stock.panes.controllers.ListWarehousePaneController;
import devopsdistilled.operp.client.stock.panes.models.ListWarehousePaneModel;

public class ListWarehousePaneControllerImpl implements
		ListWarehousePaneController {

	@Inject
	private ListWarehousePaneModel model;

	@Inject
	private ListWarehousePane view;

	@Inject
	private WarehouseModel warehouseModel;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		warehouseModel.registerObserver(view);

	}

}
