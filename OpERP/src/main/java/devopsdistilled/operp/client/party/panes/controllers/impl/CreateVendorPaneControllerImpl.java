package devopsdistilled.operp.client.party.panes.controllers.impl;

import javax.inject.Inject;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.commons.panes.controllers.ContactInfoPaneController;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.party.panes.CreateVendorPane;
import devopsdistilled.operp.client.party.panes.controllers.CreateVendorPaneController;
import devopsdistilled.operp.client.party.panes.models.CreateVendorPaneModel;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public class CreateVendorPaneControllerImpl implements
		CreateVendorPaneController {

	@Inject
	private CreateVendorPane view;

	@Inject
	private CreateVendorPaneModel model;

	@Inject
	private ContactInfoPaneController contactInfoPaneController;

	@Override
	public void init() {
		ContactInfo newContactInfo = new ContactInfo();
		contactInfoPaneController.init(newContactInfo,
				EntityOperation.Create);
		view.setContactInfopanel((JPanel) contactInfoPaneController
				.getView().getPane());
		view.init();
		model.getEntity().setContactInfo(newContactInfo);
		model.registerObserver(view);
	}

	@Override
	public CreateVendorPaneModel getModel() {
		return model;
	}

	@Override
	public void validate() throws EntityValidationException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vendor save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateVendorPane getView() {
		return view;
	}

	@Override
	public void init(Vendor entity, EntityOperation op) {
		// TODO Auto-generated method stub

	}

}
