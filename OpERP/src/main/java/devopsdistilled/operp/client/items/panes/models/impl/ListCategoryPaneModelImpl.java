package devopsdistilled.operp.client.items.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.panes.models.ListCategoryPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.ListCategoryPaneModelObserver;

public class ListCategoryPaneModelImpl extends
		AbstractPaneModel<ListCategoryPaneModelObserver> implements
		ListCategoryPaneModel {

	@Override
	public String getTitle() {
		return "Category List";
	}

}
