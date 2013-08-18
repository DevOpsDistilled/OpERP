package devopsdistilled.operp.client.party.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.party.panes.models.ListVendorPaneModel;
import devopsdistilled.operp.client.party.panes.models.observers.ListVendorPaneModelObserver;

public class ListVendorPaneModelImpl extends
		AbstractPaneModel<ListVendorPaneModelObserver> implements
		ListVendorPaneModel {

	@Override
	public String getTitle() {
		return "Vendor List";
	}

}
