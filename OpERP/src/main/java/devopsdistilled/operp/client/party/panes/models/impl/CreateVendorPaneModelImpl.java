package devopsdistilled.operp.client.party.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.party.panes.models.CreateVendorPaneModel;
import devopsdistilled.operp.client.party.panes.models.observers.CreateVendorPaneModelObserver;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public class CreateVendorPaneModelImpl extends
		AbstractEntityPaneModel<Vendor, CreateVendorPaneModelObserver>
		implements CreateVendorPaneModel {

	@Override
	public String getTitle() {
		return "Create Vendor";
	}

}
