package devopsdistilled.operp.client.commons.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.commons.panes.ContactInfoPane;
import devopsdistilled.operp.client.commons.panes.models.ContactInfoPaneModel;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;

public interface ContactInfoPaneController
		extends
		EntityPaneController<ContactInfo, ContactInfoPaneModel, ContactInfoPane> {

	@Override
	public ContactInfoPane getView();

	@Override
	public ContactInfoPaneModel getModel();

}
