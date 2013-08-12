package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.stock.panes.ListStockPane;
import devopsdistilled.operp.client.stock.panes.controllers.ListStockPaneController;
import devopsdistilled.operp.client.stock.panes.models.ListStockPaneModel;

public class ListStockPaneControllerImpl implements ListStockPaneController {

	@Inject
	private ListStockPane view;

	@Inject
	private ListStockPaneModel model;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
	}

}
