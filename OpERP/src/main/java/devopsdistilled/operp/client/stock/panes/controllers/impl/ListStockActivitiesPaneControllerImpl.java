package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.stock.models.StockKeeperModel;
import devopsdistilled.operp.client.stock.panes.ListStockActivitiesPane;
import devopsdistilled.operp.client.stock.panes.controllers.ListStockActivitiesPaneController;
import devopsdistilled.operp.client.stock.panes.models.ListStockActivitiesPaneModel;

public class ListStockActivitiesPaneControllerImpl implements
		ListStockActivitiesPaneController {

	@Inject
	private ListStockActivitiesPane view;

	@Inject
	private ListStockActivitiesPaneModel model;

	@Inject
	private StockKeeperModel stockKeeperModel;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		stockKeeperModel.registerObserver(view);
	}

}
