package devopsdistilled.operp.client.party.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.party.controllers.VendorController;
import devopsdistilled.operp.client.party.panes.controllers.VendorPaneController;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public class VendorControllerImpl implements VendorController {

	@Inject
	private VendorPaneController vendorPaneController;

	@SuppressWarnings("deprecation")
	@Override
	public void create() {
		vendorPaneController.init();
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
