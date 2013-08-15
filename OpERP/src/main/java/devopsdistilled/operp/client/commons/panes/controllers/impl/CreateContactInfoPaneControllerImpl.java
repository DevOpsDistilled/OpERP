package devopsdistilled.operp.client.commons.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.commons.panes.CreateContactInfoPane;
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

	@Override
	public void validate(ContactInfo entity) throws EntityValidationException {
		// TODO Auto-generated method stub

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
		view.init();
		model.registerObserver(view);
	}

}
