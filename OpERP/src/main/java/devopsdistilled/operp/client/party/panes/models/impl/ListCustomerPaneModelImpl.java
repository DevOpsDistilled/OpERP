package devopsdistilled.operp.client.party.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.party.panes.models.ListCustomerPaneModel;
import devopsdistilled.operp.client.party.panes.models.observers.ListCustomerPaneModelObserver;

public class ListCustomerPaneModelImpl extends
		AbstractPaneModel<ListCustomerPaneModelObserver> implements
		ListCustomerPaneModel {

	@Override
	public String getTitle() {
		return "Customers List";
	}

}
