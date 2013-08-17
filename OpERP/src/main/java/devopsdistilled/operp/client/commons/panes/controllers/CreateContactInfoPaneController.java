package devopsdistilled.operp.client.commons.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.commons.panes.CreateContactInfoPane;
import devopsdistilled.operp.client.commons.panes.models.CreateContactInfoPaneModel;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;

public interface CreateContactInfoPaneController
		extends
		EntityPaneController<ContactInfo, CreateContactInfoPaneModel, CreateContactInfoPane> {

	@Override
	public CreateContactInfoPane getView();

	@Override
	public CreateContactInfoPaneModel getModel();

}
