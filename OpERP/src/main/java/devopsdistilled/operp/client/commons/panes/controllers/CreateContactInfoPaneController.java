package devopsdistilled.operp.client.commons.panes.controllers;

import devopsdistilled.operp.client.abstracts.CreateEntityPaneController;
import devopsdistilled.operp.client.commons.panes.CreateContactInfoPane;
import devopsdistilled.operp.client.commons.panes.models.CreateContactInfoPaneModel;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;

public interface CreateContactInfoPaneController extends
		CreateEntityPaneController<ContactInfo> {

	public CreateContactInfoPane getView();

	public CreateContactInfoPaneModel getModel();

}
