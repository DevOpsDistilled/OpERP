package devopsdistilled.operp.client.commons.panes.controllers;

import devopsdistilled.operp.client.abstracts.CreateEntityPaneController;
import devopsdistilled.operp.client.commons.panes.models.CreateAddressPaneModel;
import devopsdistilled.operp.server.data.entity.commons.Address;

public interface CreateAddressPaneController extends
		CreateEntityPaneController<Address> {

	public CreateAddressPaneModel getModel();

}
