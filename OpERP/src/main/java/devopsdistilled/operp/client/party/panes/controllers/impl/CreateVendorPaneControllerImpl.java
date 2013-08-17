package devopsdistilled.operp.client.party.panes.controllers.impl;

import javax.inject.Inject;
import javax.swing.JPanel;

import devopsdistilled.operp.client.commons.panes.controllers.CreateContactInfoPaneController;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.party.models.VendorModel;
import devopsdistilled.operp.client.party.panes.CreateVendorPane;
import devopsdistilled.operp.client.party.panes.controllers.CreateVendorPaneController;
import devopsdistilled.operp.client.party.panes.models.CreateVendorPaneModel;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public class CreateVendorPaneControllerImpl implements
		CreateVendorPaneController {

	@Inject
	private CreateVendorPane view;

	@Inject
	private CreateVendorPaneModel model;

	@Inject
	private CreateContactInfoPaneController createContactInfoPaneController;

	@Inject
	private VendorModel vendorModel;

	@Override
	public void validate(Vendor vendor) throws EntityValidationException {
		createContactInfoPaneController.validate();
		model.getVendor().setContactInfo(
				createContactInfoPaneController.getModel().getEntity());

		if (vendor.getPartyName().equalsIgnoreCase(""))
			throw new EntityValidationException("Vendor Name can't be empty");

	}

	@Override
	public Vendor save(Vendor vendor) {
		return vendorModel.saveAndUpdateModel(vendor);
	}

	@Override
	public void init() {
		createContactInfoPaneController.init();
		createContactInfoPaneController.getView().setController(
				createContactInfoPaneController);
		view.setContactInfopanel((JPanel) createContactInfoPaneController
				.getView().getPane());
		view.init();
		model.registerObserver(view);
	}

	@Override
	public CreateVendorPaneModel getModel() {
		return model;
	}

}
