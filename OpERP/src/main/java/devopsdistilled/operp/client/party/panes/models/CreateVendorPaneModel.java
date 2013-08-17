package devopsdistilled.operp.client.party.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.party.panes.models.observers.CreateVendorPaneModelObserver;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public interface CreateVendorPaneModel extends
		EntityPaneModel<Vendor, CreateVendorPaneModelObserver> {

}
