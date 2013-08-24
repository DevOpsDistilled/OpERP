package devopsdistilled.operp.client.commons.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.commons.panes.AddressPane;
import devopsdistilled.operp.client.commons.panes.models.AddressPaneModel;
import devopsdistilled.operp.server.data.entity.commons.Address;

public interface AddressPaneController
		extends
		EntityPaneController<Address, AddressPaneModel, AddressPane> {

	@Override
	public AddressPaneModel getModel();

	@Override
	public AddressPane getView();

}
