package devopsdistilled.operp.client.commons.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.commons.panes.CreateAddressPane;
import devopsdistilled.operp.client.commons.panes.models.CreateAddressPaneModel;
import devopsdistilled.operp.server.data.entity.commons.Address;

public interface CreateAddressPaneController
		extends
		EntityPaneController<Address, CreateAddressPaneModel, CreateAddressPane> {

	@Override
	public CreateAddressPaneModel getModel();

	@Override
	public CreateAddressPane getView();

}
