package devopsdistilled.operp.client.party.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.exceptions.EntityValidationException;
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

	@Override
	public void validate(Vendor entity) throws EntityValidationException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vendor save(Vendor entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
	}

}
