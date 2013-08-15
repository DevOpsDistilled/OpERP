package devopsdistilled.operp.client.party.panes.controllers;

import devopsdistilled.operp.client.abstracts.CreateEntityPaneController;
import devopsdistilled.operp.client.party.panes.models.CreateVendorPaneModel;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public interface CreateVendorPaneController extends
		CreateEntityPaneController<Vendor> {

	public CreateVendorPaneModel getModel();

}
