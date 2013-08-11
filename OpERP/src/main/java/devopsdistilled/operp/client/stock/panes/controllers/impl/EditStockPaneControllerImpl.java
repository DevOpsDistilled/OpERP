package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.panes.EditStockPane;
import devopsdistilled.operp.client.stock.panes.controllers.EditStockPaneController;
import devopsdistilled.operp.client.stock.panes.models.EditStockPaneModel;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public class EditStockPaneControllerImpl implements 
		EditStockPaneController{
	
	@Inject 
	private EditStockPaneModel model;
	
	@Inject 
	private EditStockPane view;
	
	@Inject
	private StockModel stockModel;
	
	@Inject
	private WarehouseModel warehouseModel;
	
	@Inject
	private ItemModel itemModel;
	
	
	@Override
	public void init(Stock stock) {
		view.init();
		model.setEntity(stock);
		model.registerObserver(view);
		warehouseModel.registerObserver(view);
		itemModel.registerObserver(view);
	}

	@Override
	public void validate(Stock entity) throws EntityValidationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Stock save(Stock stock) {
		return stockModel.saveAndUpdateModel(stock);
	}

}
