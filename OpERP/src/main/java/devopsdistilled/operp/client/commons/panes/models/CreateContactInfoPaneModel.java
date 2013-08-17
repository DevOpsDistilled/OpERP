package devopsdistilled.operp.client.commons.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.commons.panes.models.observers.CreateContactInfoPaneModelObserver;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;

public interface CreateContactInfoPaneModel extends
		EntityPaneModel<ContactInfo, CreateContactInfoPaneModelObserver> {

}
