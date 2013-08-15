package devopsdistilled.operp.client.party.panes.controllers.impl;

import javax.inject.Inject;
import javax.swing.JPanel;

import devopsdistilled.operp.client.commons.panes.controllers.CreateContactInfoPaneController;
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

	@Inject
	private CreateContactInfoPaneController createContactInfoPaneController;

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
		createContactInfoPaneController.getView().setController(
				createContactInfoPaneController);
		view.setContactInfopanel((JPanel) createContactInfoPaneController
				.getView().getPane());
		view.init();
		model.registerObserver(view);
	}

}
