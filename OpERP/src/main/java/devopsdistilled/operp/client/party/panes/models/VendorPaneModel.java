package devopsdistilled.operp.client.party.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.party.panes.models.observers.VendorPaneModelObserver;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public interface VendorPaneModel extends
		EntityPaneModel<Vendor, VendorPaneModelObserver> {

}
