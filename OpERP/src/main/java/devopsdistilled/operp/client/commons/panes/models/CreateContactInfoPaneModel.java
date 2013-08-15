package devopsdistilled.operp.client.commons.panes.models;

import devopsdistilled.operp.client.abstracts.PaneModel;
import devopsdistilled.operp.client.commons.panes.models.observers.CreateContactInfoPaneModelObserver;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;

public interface CreateContactInfoPaneModel extends
		PaneModel<CreateContactInfoPaneModelObserver> {

	ContactInfo getContactInfo();

}
