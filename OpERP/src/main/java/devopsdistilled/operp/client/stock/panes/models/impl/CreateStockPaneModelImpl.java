package devopsdistilled.operp.client.stock.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.stock.panes.models.CreateStockPaneModel;
import devopsdistilled.operp.client.stock.panes.models.observers.CreateStockPaneModelObserver;

public class CreateStockPaneModelImpl extends 
		AbstractPaneModel<CreateStockPaneModelObserver>  
		implements CreateStockPaneModel{

	@Override
	public String getTitle() {
		return "Create Stock";
	}
	
}

	