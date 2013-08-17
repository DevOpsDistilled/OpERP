package devopsdistilled.operp.client.party.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.party.panes.models.VendorPaneModel;
import devopsdistilled.operp.client.party.panes.models.observers.VendorPaneModelObserver;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public class VendorPaneModelImpl extends
		AbstractEntityPaneModel<Vendor, VendorPaneModelObserver>
		implements VendorPaneModel {

	@Override
	public String getTitle() {
		return "Create Vendor";
	}

}
