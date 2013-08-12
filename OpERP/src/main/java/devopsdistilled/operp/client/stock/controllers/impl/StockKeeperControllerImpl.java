package devopsdistilled.operp.client.stock.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.stock.controllers.StockKeeperController;
import devopsdistilled.operp.client.stock.models.StockKeeperModel;
import devopsdistilled.operp.client.stock.panes.controllers.ListStockActivitiesPaneController;
import devopsdistilled.operp.client.stock.panes.controllers.TransferStockPaneController;
import devopsdistilled.operp.client.stock.panes.controllers.UpdateStockPaneController;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;

public class StockKeeperControllerImpl implements StockKeeperController {

	@Inject
	private UpdateStockPaneController updateStockPaneController;

	@Inject
	private ListStockActivitiesPaneController listStockActivitiesPaneController;

	@Inject
	private TransferStockPaneController transferStockPaneController;

	@Inject
	private StockKeeperModel stockKeeperModel;

	@Override
	public void create() {
		updateStockPaneController.init();
	}

	@Override
	public void edit(StockKeeper entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		listStockActivitiesPaneController.init();
	}

	@Override
	public void transfer() {
		transferStockPaneController.init();
	}

	@Override
	public void delete(StockKeeper entity) {
		stockKeeperModel.deleteAndUpdateModel(entity);
	}
}
