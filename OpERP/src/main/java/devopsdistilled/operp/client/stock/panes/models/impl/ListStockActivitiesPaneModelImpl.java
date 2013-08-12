package devopsdistilled.operp.client.stock.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.stock.panes.models.ListStockActivitiesPaneModel;
import devopsdistilled.operp.client.stock.panes.models.observers.ListStockActivitiesPaneModelObserver;

public class ListStockActivitiesPaneModelImpl extends
		AbstractPaneModel<ListStockActivitiesPaneModelObserver> implements
		ListStockActivitiesPaneModel {

	@Override
	public String getTitle() {

		return "Stock Activities List";
	}

}