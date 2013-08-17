package devopsdistilled.operp.client.commons.panes.controllers.impl;

import javax.inject.Inject;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.commons.panes.CreateContactInfoPane;
import devopsdistilled.operp.client.commons.panes.controllers.CreateAddressPaneController;
import devopsdistilled.operp.client.commons.panes.controllers.CreateContactInfoPaneController;
import devopsdistilled.operp.client.commons.panes.models.CreateContactInfoPaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.commons.Address;
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
	public CreateContactInfoPaneModel getModel() {
		return model;
	}

	@Override
	public CreateContactInfoPane getView() {
		return view;
	}

	@Override
	public void validate() throws EntityValidationException {
		// TODO Auto-generated method stub

	}

	@Override
	public ContactInfo save() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void init() {

		view.setController(this);
		createAddressPaneController.init();

		view.setAddressPanel((JPanel) createAddressPaneController.getView()
				.getPane());
		model.registerObserver(view);
	}

	@Override
	public void init(ContactInfo contactInfo, EntityOperation op) {
		Address newAddress = new Address();
		createAddressPaneController.init(newAddress, op);
		view.setAddressPanel((JPanel) createAddressPaneController.getView()
				.getPane());

		view.setController(this);
		contactInfo.setAddress(newAddress);
		model.setEntity(contactInfo);
		model.registerObserver(view);

	}

}
