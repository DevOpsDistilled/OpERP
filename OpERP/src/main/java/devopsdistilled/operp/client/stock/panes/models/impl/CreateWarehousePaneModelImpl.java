package devopsdistilled.operp.client.stock.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.stock.panes.models.CreateWarehousePaneModel;
import devopsdistilled.operp.client.stock.panes.models.observers.CreateWarehousePaneModelObserver;

public class CreateWarehousePaneModelImpl extends
		AbstractPaneModel<CreateWarehousePaneModelObserver> implements
		CreateWarehousePaneModel {

	public CreateWarehousePaneModelImpl() {
		title = "Create Warehouse";
	}

	@Override
	public String getTitle() {
		return title;
	}

}
