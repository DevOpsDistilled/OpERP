package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;
import javax.swing.JOptionPane;

import devopsdistilled.operp.client.items.exceptions.NullFieldException;
import devopsdistilled.operp.client.stock.panes.UpdateStockPane;
import devopsdistilled.operp.client.stock.panes.controllers.UpdateStockPaneController;
import devopsdistilled.operp.client.stock.panes.models.StockModel;
import devopsdistilled.operp.client.stock.panes.models.UpdateStockPaneModel;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public class UpdateStockPaneControllerImpl implements UpdateStockPaneController{
	
	@Inject 
	private UpdateStockPaneModel model;
	
	@Inject
	private UpdateStockPane view;
	
	@Inject
	private StockModel stockModel;
	
	
	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		
	}


	@Override
	public void validateStock(Stock stock) throws NullFieldException {
		
		if (stock.getItem()==null || stock.getQuantity()==null || stock.getWarehouse()==null){
			
			throw new NullFieldException();
		}
		
	}


	@Override
	public Stock update(Stock stock) {
		JOptionPane.showMessageDialog(null, "OK");
		//Stock updatedStock=stockModel.saveAndUpdateModel(stock);
		//return updatedStock;
		return null;
	}

}
