package devopsdistilled.operp.client.commons.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.commons.panes.models.CreateContactInfoPaneModel;
import devopsdistilled.operp.client.commons.panes.models.observers.CreateContactInfoPaneModelObserver;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;

public class CreateContactInfoPaneModelImpl
		extends
		AbstractEntityPaneModel<ContactInfo, CreateContactInfoPaneModelObserver>
		implements CreateContactInfoPaneModel {

	@Override
	public String getTitle() {
		return "Contact Info";
	}

}
