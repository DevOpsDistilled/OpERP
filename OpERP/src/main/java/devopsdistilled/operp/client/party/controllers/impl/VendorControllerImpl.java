package devopsdistilled.operp.client.party.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.party.controllers.VendorController;
import devopsdistilled.operp.client.party.models.VendorModel;
import devopsdistilled.operp.client.party.panes.controllers.VendorPaneController;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public class VendorControllerImpl implements VendorController {

	@Inject
	private VendorPaneController vendorPaneController;

	@Inject
	private VendorModel vendorModel;

	@Override
	public void create() {
		vendorPaneController.init(new Vendor(), EntityOperation.Create);
	}

	@Override
	public void edit(Vendor vendor) {
		vendorPaneController.init(vendor, EntityOperation.Edit);
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Vendor vendor) {
		vendorModel.deleteAndUpdateModel(vendor);
	}

	@Override
	public void showDetails(Vendor entity) {
		// TODO Auto-generated method stub

	}

}
