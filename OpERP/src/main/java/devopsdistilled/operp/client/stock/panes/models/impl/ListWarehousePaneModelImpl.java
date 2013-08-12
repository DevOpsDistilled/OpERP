package devopsdistilled.operp.client.stock.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.stock.panes.models.ListWarehousePaneModel;
import devopsdistilled.operp.client.stock.panes.models.observers.ListWarehousePaneModelObserver;

public class ListWarehousePaneModelImpl extends
		AbstractPaneModel<ListWarehousePaneModelObserver> implements
		ListWarehousePaneModel {

	public ListWarehousePaneModelImpl() {
		title = "Warehouse List";
	}

	@Override
	public String getTitle() {
		return title;
	}

}
