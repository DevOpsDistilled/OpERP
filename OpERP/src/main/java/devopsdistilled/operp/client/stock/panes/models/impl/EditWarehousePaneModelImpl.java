package devopsdistilled.operp.client.stock.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEditEntityPaneModel;
import devopsdistilled.operp.client.stock.models.observers.EditWarehousePaneModelObserver;
import devopsdistilled.operp.client.stock.panes.models.EditWarehousePaneModel;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class EditWarehousePaneModelImpl extends 
		AbstractEditEntityPaneModel<Warehouse, EditWarehousePaneModelObserver>
		implements EditWarehousePaneModel{

	@Override
	public String getTitle() {
		return "Edit Warehouse";
	}

}
