package devopsdistilled.operp.client.stock.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.stock.controllers.StockController;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.panes.controllers.ListStockPaneController;
import devopsdistilled.operp.client.stock.panes.controllers.TransferStockPaneController;
import devopsdistilled.operp.client.stock.panes.controllers.UpdateStockPaneController;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public class StockControllerImpl implements StockController {

	@Inject
	private UpdateStockPaneController updateStockPaneController;

	@Inject
	private ListStockPaneController listStockPaneController;

	@Inject
	private TransferStockPaneController transferStockPaneController;

	@Inject
	private StockModel stockModel;

	@Override
	public void create() {
		updateStockPaneController.init();
	}

	@Override
	public void edit(Stock entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		listStockPaneController.init();
	}

	@Override
	public void delete(Stock stock) {
		stockModel.deleteAndUpdateModel(stock);
	}

	@Override
	public void transfer() {
		transferStockPaneController.init();
	}

}
