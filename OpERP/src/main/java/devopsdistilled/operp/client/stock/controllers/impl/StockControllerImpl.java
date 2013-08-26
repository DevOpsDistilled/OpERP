package devopsdistilled.operp.client.stock.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.stock.controllers.StockController;
import devopsdistilled.operp.client.stock.panes.controllers.ListStockPaneController;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public class StockControllerImpl implements StockController {

	@Inject
	private ListStockPaneController listStockPaneController;

	@Override
	public void create() {

	}
	
	@Override
	public void edit(Stock entity) {

	}

	@Override
	public void list() {
		listStockPaneController.init();
	}

	@Override
	public void delete(Stock entity) {

	}

	@Override
	public void showDetails(Stock entity) {
		// TODO Auto-generated method stub

	}

}
