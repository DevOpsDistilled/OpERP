package devopsdistilled.operp.client.business.sales.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.ListSalePaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.observers.ListSalePaneModelObserver;

public class ListSalePaneModelImpl extends
		AbstractPaneModel<ListSalePaneModelObserver> implements
		ListSalePaneModel {

	@Override
	public String getTitle() {
		return "Sale List";
	}

}
