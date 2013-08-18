package devopsdistilled.operp.client.commons.panes.controllers.impl;

import javax.inject.Inject;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.commons.panes.ContactInfoPane;
import devopsdistilled.operp.client.commons.panes.controllers.AddressPaneController;
import devopsdistilled.operp.client.commons.panes.controllers.ContactInfoPaneController;
import devopsdistilled.operp.client.commons.panes.models.ContactInfoPaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.commons.Address;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;

public class ContactInfoPaneControllerImpl implements ContactInfoPaneController {

	@Inject
	private ContactInfoPane view;

	@Inject
	private ContactInfoPaneModel model;

	@Inject
	private AddressPaneController addressPaneController;

	@Override
	public ContactInfoPaneModel getModel() {
		return model;
	}

	@Override
	public ContactInfoPane getView() {
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

	@Override
	public void init(ContactInfo contactInfo, EntityOperation op) {
		Address newAddress = new Address();
		addressPaneController.init(newAddress, op);
		view.setAddressPanel((JPanel) addressPaneController.getView().getPane());

		view.setController(this);
		contactInfo.setAddress(newAddress);
		model.setEntity(contactInfo);
		model.registerObserver(view);

	}

}
