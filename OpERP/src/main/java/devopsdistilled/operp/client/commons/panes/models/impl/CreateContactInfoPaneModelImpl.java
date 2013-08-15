package devopsdistilled.operp.client.commons.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.commons.panes.models.CreateContactInfoPaneModel;
import devopsdistilled.operp.client.commons.panes.models.observers.CreateContactInfoPaneModelObserver;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;

public class CreateContactInfoPaneModelImpl extends
		AbstractPaneModel<CreateContactInfoPaneModelObserver> implements
		CreateContactInfoPaneModel {

	private ContactInfo contactInfo;

	@Override
	public String getTitle() {
		return "Create Contact Info";
	}

	@Override
	public ContactInfo getContactInfo() {
		return contactInfo;
	}

}
