package devopsdistilled.operp.client.commons.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.commons.panes.models.observers.ContactInfoPaneModelObserver;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;

public interface ContactInfoPaneModel extends
		EntityPaneModel<ContactInfo, ContactInfoPaneModelObserver> {

}
