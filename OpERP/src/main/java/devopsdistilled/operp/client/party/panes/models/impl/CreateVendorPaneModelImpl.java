package devopsdistilled.operp.client.party.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.party.panes.models.CreateVendorPaneModel;
import devopsdistilled.operp.client.party.panes.models.observers.CreateVendorPaneModelObserver;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public class CreateVendorPaneModelImpl extends
		AbstractPaneModel<CreateVendorPaneModelObserver> implements
		CreateVendorPaneModel {

	private final Vendor vendor = new Vendor();

	@Override
	public String getTitle() {
		return "Create Vendor";
	}

	@Override
	public Vendor getVendor() {
		return vendor;
	}

}
