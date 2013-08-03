package devopsdistilled.operp.client.stock.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.stock.models.observers.ListWarehousePaneObserver;
import devopsdistilled.operp.client.stock.panes.models.ListWarehousePaneModel;

public class ListWarehousePaneModelImpl extends 
		AbstractPaneModel<ListWarehousePaneObserver>
		implements ListWarehousePaneModel{
	
	public ListWarehousePaneModelImpl(){
		title="List Warehouse";
	}

	@Override
	public String getTitle() {
		return title;
	}

}
