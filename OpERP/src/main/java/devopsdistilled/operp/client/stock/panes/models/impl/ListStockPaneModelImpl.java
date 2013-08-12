package devopsdistilled.operp.client.stock.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.stock.panes.models.ListStockPaneModel;
import devopsdistilled.operp.client.stock.panes.models.observers.ListStockPaneModelObserver;

public class ListStockPaneModelImpl extends
		AbstractPaneModel<ListStockPaneModelObserver> implements
		ListStockPaneModel {

	@Override
	public String getTitle() {
		return "Stock List";
	}

}
