package devopsdistilled.operp.client.party.panes.models;

import devopsdistilled.operp.client.abstracts.PaneModel;
import devopsdistilled.operp.client.party.panes.models.observers.CreateVendorPaneModelObserver;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public interface CreateVendorPaneModel extends
		PaneModel<CreateVendorPaneModelObserver> {

	public Vendor getVendor();

}
