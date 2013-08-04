package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.swing.JOptionPane;

import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.panes.CreateStockPane;
import devopsdistilled.operp.client.stock.panes.controllers.CreateStockPaneController;
import devopsdistilled.operp.client.stock.panes.models.CreateStockPaneModel;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public class CreateStockPaneControllerImpl implements CreateStockPaneController{
	
	@Inject 
	private CreateStockPaneModel model;
	
	@Inject
	private CreateStockPane view;
	
	@Inject 
	private WarehouseModel warehouseModel;
	
	@Inject
	private StockModel stockModel;
	
	
	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		warehouseModel.registerObserver(view);
		
	}


	@Override
	public void validate(Stock stock) throws NullFieldException {
		
		if (stock.getItem()==null || stock.getQuantity()==null || stock.getWarehouse()==null){
		
			throw new NullFieldException();
		}
		
		
	}


	@Override
	public Stock save(Stock stock) {
		// TODO Auto-generated method stub
		return null;
	}



}
