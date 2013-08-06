package devopsdistilled.operp.client.stock.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.stock.panes.models.ListItemWarehouseCatalogPaneModel;
import devopsdistilled.operp.client.stock.panes.models.observers.ListItemWarehouseCatalogPaneModelObserver;

public class ListItemWarehouseCatalogPaneModelImpl extends
		AbstractPaneModel<ListItemWarehouseCatalogPaneModelObserver>
		implements ListItemWarehouseCatalogPaneModel{

	@Override
	public String getTitle() {
		return "Item Warehouse List";
	}

}
