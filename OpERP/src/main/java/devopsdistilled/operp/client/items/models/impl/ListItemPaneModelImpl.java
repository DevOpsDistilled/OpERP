package devopsdistilled.operp.client.items.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.models.ListItemPaneModel;
import devopsdistilled.operp.client.items.models.observers.ListItemPaneModelObserver;

public class ListItemPaneModelImpl extends
		AbstractPaneModel<ListItemPaneModelObserver> implements
		ListItemPaneModel {

	public ListItemPaneModelImpl() {
		title = "Items List";
	}

	@Override
	public String getTitle() {
		return title;
	}

}
