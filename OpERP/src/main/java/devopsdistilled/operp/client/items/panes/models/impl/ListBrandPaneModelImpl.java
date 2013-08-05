package devopsdistilled.operp.client.items.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.panes.models.ListBrandPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.ListBrandPaneModelObserver;

public class ListBrandPaneModelImpl extends
		AbstractPaneModel<ListBrandPaneModelObserver> implements
		ListBrandPaneModel {

	@Override
	public String getTitle() {
		return "Brands List";
	}

}
