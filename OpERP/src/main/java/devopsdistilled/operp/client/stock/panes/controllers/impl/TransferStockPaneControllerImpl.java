package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.panes.TransferStockPane;
import devopsdistilled.operp.client.stock.panes.controllers.TransferStockPaneController;
import devopsdistilled.operp.client.stock.panes.models.TransferStockPaneModel;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class TransferStockPaneControllerImpl implements
		TransferStockPaneController {

	@Inject
	private TransferStockPane view;

	@Inject
	private WarehouseModel warehouseModel;

	@Inject
	private TransferStockPaneModel model;

	@Override
	public void init() {
		view.init();
		warehouseModel.registerObserver(view);
		model.registerObserver(view);
	}

	@Override
	public void validate(Warehouse fromWarehouse, Warehouse toWarehouse,
			Long quantity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transfer(Warehouse fromWarehouse, Warehouse toWarehouse,
			Long quantity) {
		// TODO Auto-generated method stub

	}

}
