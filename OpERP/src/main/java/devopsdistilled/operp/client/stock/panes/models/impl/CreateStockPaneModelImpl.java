package devopsdistilled.operp.client.stock.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.stock.models.observers.CreateStockPaneModelObserver;
import devopsdistilled.operp.client.stock.panes.models.CreateStockPaneModel;

public class CreateStockPaneModelImpl extends 
		AbstractPaneModel<CreateStockPaneModelObserver>  
		implements CreateStockPaneModel{

	@Override
	public String getTitle() {
		return "Create Stock";
	}
	
}

	