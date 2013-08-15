package devopsdistilled.operp.client.party.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.party.controllers.VendorController;
import devopsdistilled.operp.client.party.panes.controllers.CreateVendorPaneController;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public class VendorControllerImpl implements VendorController {

	@Inject
	private CreateVendorPaneController createVendorPaneController;

	@Override
	public void create() {
		createVendorPaneController.init();
	}

	@Override
	public void edit(Vendor entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Vendor entity) {
		// TODO Auto-generated method stub

	}

}
