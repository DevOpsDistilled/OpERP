package devopsdistilled.operp.client.party.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.party.panes.VendorPane;
import devopsdistilled.operp.client.party.panes.models.VendorPaneModel;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public interface VendorPaneController extends
		EntityPaneController<Vendor, VendorPaneModel, VendorPane> {

}
