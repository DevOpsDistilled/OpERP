package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.panes.UpdateStockPane;
import devopsdistilled.operp.client.stock.panes.controllers.UpdateStockPaneController;
import devopsdistilled.operp.client.stock.panes.models.UpdateStockPaneModel;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.repo.stock.StockRepository;

public class UpdateStockPaneControllerImpl implements UpdateStockPaneController{
	
	@Inject 
	private UpdateStockPaneModel model;
	
	@Inject
	private UpdateStockPane view;
	
	@Inject 
	private WarehouseModel warehouseModel;
	
	@Inject
	private StockModel stockModel;
	
	@Inject
	private ItemModel itemModel;
	
	
	
	
	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		warehouseModel.registerObserver(view);
		itemModel.registerObserver(view);
		
	}


	@Override
	public void validate(Stock stock) throws NullFieldException{
		
		if (stock.getQuantity()==null)
			throw new NullFieldException("Quantity cant't be empty");
		
		if(stock.getItem()==null)
			throw new NullFieldException("Stock must be associated with Item");
		
		if(stock.getWarehouse()==null)
			throw new NullFieldException("Stock must be associated with Warehouse");
		
		if(stockModel.getService().isItemWarehousePairExists(stock.getItem(),stock.getWarehouse())){
			//TODO
		}
		
}


	@Override
	public Stock save(Stock stock) {
		Stock savedStock=stockModel.saveAndUpdateModel(stock);
		return savedStock;
	
	
	}


	



}
