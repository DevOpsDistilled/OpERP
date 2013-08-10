package devopsdistilled.operp.client.stock.panes.controllers;

import javax.inject.Inject;

import devopsdistilled.operp.client.stock.panes.TransferStockPane;
import devopsdistilled.operp.client.stock.panes.models.TransferStockPaneModel;

public class TransferStockPaneControllerImpl implements
		TransferStockPaneController {

	@Inject
	private TransferStockPane view;

	@Inject
	private TransferStockPaneModel model;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
	}

}
