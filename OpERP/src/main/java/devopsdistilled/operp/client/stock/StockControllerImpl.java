package devopsdistilled.operp.client.stock;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;

import devopsdistilled.operp.client.stock.controllers.UpdateStockPaneController;
import devopsdistilled.operp.server.data.service.stock.StockService;

public class StockControllerImpl implements StockController{

	@Inject
	private ApplicationContext context;
	
	@Inject
	private StockService stockservice;
	
	@Override
	public void updateStock() {
		UpdateStockPaneController updateStockPaneController=context
					.getBean(UpdateStockPaneController.class);
		updateStockPaneController.init();
		
	}
	

}
