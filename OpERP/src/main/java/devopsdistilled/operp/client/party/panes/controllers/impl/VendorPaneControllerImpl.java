package devopsdistilled.operp.client.party.panes.controllers.impl;

import javax.inject.Inject;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.commons.panes.controllers.ContactInfoPaneController;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.party.panes.VendorPane;
import devopsdistilled.operp.client.party.panes.controllers.VendorPaneController;
import devopsdistilled.operp.client.party.panes.models.VendorPaneModel;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public class VendorPaneControllerImpl implements VendorPaneController {

	@Inject
	private VendorPane view;

	@Inject
	private VendorPaneModel model;

	@Inject
	private ContactInfoPaneController contactInfoPaneController;

	@Override
	public VendorPaneModel getModel() {
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
	public VendorPane getView() {
		return view;
	}

	@Override
	public void init(Vendor vendor, EntityOperation entityOperation) {

		if (EntityOperation.Create == entityOperation) {

			ContactInfo contactInfo = new ContactInfo();
			vendor.setContactInfo(contactInfo);
			contactInfoPaneController.init(contactInfo, entityOperation);

		} else if (EntityOperation.Edit == entityOperation) {

			contactInfoPaneController.init(vendor.getContactInfo(),
					entityOperation);
		}

		view.setContactInfopanel((JPanel) contactInfoPaneController.getView()
				.getPane());
		view.setController(this);

		model.registerObserver(view);
		model.setEntityAndEntityOperation(vendor, entityOperation);

		view.init();
	}

}
