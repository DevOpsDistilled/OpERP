package devopsdistilled.operp.client.commons.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.commons.panes.models.ContactInfoPaneModel;
import devopsdistilled.operp.client.commons.panes.models.observers.ContactInfoPaneModelObserver;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;

public class ContactInfoPaneModelImpl
		extends
		AbstractEntityPaneModel<ContactInfo, ContactInfoPaneModelObserver>
		implements ContactInfoPaneModel {

	@Override
	public String getTitle() {
		return "Contact Info";
	}

}
