package devopsdistilled.operp.client.party.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.party.panes.CreateVendorPane;
import devopsdistilled.operp.client.party.panes.models.CreateVendorPaneModel;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public interface CreateVendorPaneController extends
		EntityPaneController<Vendor, CreateVendorPaneModel, CreateVendorPane> {

}
