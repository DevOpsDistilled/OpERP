package devopsdistilled.operp.client.stock.panes.controllers;

import javax.inject.Inject;

import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.panes.TransferStockPane;
import devopsdistilled.operp.client.stock.panes.models.TransferStockPaneModel;

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

}
