package devopsdistilled.operp.client.stock.controllers.impl;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;

import devopsdistilled.operp.client.stock.controllers.StockController;
import devopsdistilled.operp.client.stock.panes.controllers.UpdateStockPaneController;
import devopsdistilled.operp.client.stock.panes.models.UpdateStockPaneModel;
import devopsdistilled.operp.server.data.service.stock.StockService;

public class StockControllerImpl implements StockController{

	@Inject
	private ApplicationContext context;
	
	@Inject 
	private UpdateStockPaneModel model;
	
	@Inject
	private StockService stockservice;
	
	@Override
	public void updateStock() {
		UpdateStockPaneController updateStockPaneController=context
					.getBean(UpdateStockPaneController.class);
		updateStockPaneController.init();
		
	}
	

}
