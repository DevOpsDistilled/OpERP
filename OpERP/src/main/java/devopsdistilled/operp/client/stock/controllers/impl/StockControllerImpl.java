package devopsdistilled.operp.client.stock.controllers.impl;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;

import devopsdistilled.operp.client.stock.controllers.StockController;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.panes.controllers.UpdateStockPaneController;
import devopsdistilled.operp.client.stock.panes.controllers.ListStockPaneController;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public class StockControllerImpl implements StockController{

	@Inject
	private ApplicationContext context;
	
	
	@Inject
	private StockModel stockModel;
	
	
	


	@Override
	public void create() {
		UpdateStockPaneController createStockPaneController=context.
			getBean(UpdateStockPaneController.class);
		createStockPaneController.init();
		
	}

	@Override
	public void edit(Stock entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void list() {
		ListStockPaneController listStockPaneController=context.
				getBean(ListStockPaneController.class);
		listStockPaneController.init();
	}

	@Override
	public void delete(Stock stock) {
		stockModel.deleteAndUpdateModel(stock);
		
	}
	

}
