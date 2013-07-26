package devopsdistilled.operp.client.stock.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.stock.controllers.UpdateStockPaneController;
import devopsdistilled.operp.client.stock.models.UpdateStockPaneModel;
import devopsdistilled.operp.client.stock.views.UpdateStockPane;

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
