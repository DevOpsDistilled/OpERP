package devopsdistilled.operp.client.stock.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEditEntityPaneModel;
import devopsdistilled.operp.client.stock.models.observers.EditStockPaneModelObserver;
import devopsdistilled.operp.client.stock.panes.models.EditStockPaneModel;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public class EditStockPaneModelImpl extends 
		AbstractEditEntityPaneModel<Stock, EditStockPaneModelObserver>implements
		EditStockPaneModel{

	@Override
	public String getTitle() {
		return "Edit Stock";
	}

}
