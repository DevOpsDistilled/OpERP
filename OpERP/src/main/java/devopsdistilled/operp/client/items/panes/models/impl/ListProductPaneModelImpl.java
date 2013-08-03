package devopsdistilled.operp.client.items.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.panes.models.ListProductPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.ListProductPaneModelObserver;

public class ListProductPaneModelImpl extends
		AbstractPaneModel<ListProductPaneModelObserver> implements
		ListProductPaneModel {

	@Override
	public String getTitle() {
		return "Product List";
	}

}
