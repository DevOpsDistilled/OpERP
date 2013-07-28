package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.stock.panes.UpdateStockPane;
import devopsdistilled.operp.client.stock.panes.controllers.UpdateStockPaneController;
import devopsdistilled.operp.client.stock.panes.models.UpdateStockPaneModel;

public class UpdateStockPaneControllerImpl implements UpdateStockPaneController{
	
	@Inject 
	private UpdateStockPaneModel model;
	
	@Inject
	private UpdateStockPane view;
	
	
	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		
	}

}
