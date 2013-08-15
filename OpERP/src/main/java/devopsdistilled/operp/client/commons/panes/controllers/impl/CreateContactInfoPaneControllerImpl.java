package devopsdistilled.operp.client.commons.panes.controllers.impl;

import javax.inject.Inject;
import javax.swing.JPanel;

import devopsdistilled.operp.client.commons.panes.CreateContactInfoPane;
import devopsdistilled.operp.client.commons.panes.controllers.CreateAddressPaneController;
import devopsdistilled.operp.client.commons.panes.controllers.CreateContactInfoPaneController;
import devopsdistilled.operp.client.commons.panes.models.CreateContactInfoPaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;

public class CreateContactInfoPaneControllerImpl implements
		CreateContactInfoPaneController {

	@Inject
	private CreateContactInfoPane view;

	@Inject
	private CreateContactInfoPaneModel model;

	@Inject
	private CreateAddressPaneController createAddressPaneController;

	@Override
	public void validate(ContactInfo entity) throws EntityValidationException {
		createAddressPaneController.validate(createAddressPaneController
				.getModel().getAddress());
		model.getContactInfo().setAddress(
				createAddressPaneController.getModel().getAddress());
	}

	@Override
	public ContactInfo save(ContactInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateContactInfoPaneModel getModel() {
		return model;
	}

	@Override
	public void init() {
		// view.init();

		view.setController(this);
		createAddressPaneController.init();

		view.setAddressPanel((JPanel) createAddressPaneController.getView()
				.getPane());
		model.registerObserver(view);
	}

	@Override
	public CreateContactInfoPane getView() {
		return view;
	}

}
