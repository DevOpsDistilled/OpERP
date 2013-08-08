package devopsdistilled.operp.client.stock.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.stock.panes.models.UpdateStockPaneModel;
import devopsdistilled.operp.client.stock.panes.models.observers.UpdateStockPaneModelObserver;

public class UpdateStockPaneModelImpl extends 
		AbstractPaneModel<UpdateStockPaneModelObserver>  
		implements UpdateStockPaneModel{

	@Override
	public String getTitle() {
		return "Update Stock";
	}
	
}

	