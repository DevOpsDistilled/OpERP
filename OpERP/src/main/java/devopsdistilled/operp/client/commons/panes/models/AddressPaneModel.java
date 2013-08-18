package devopsdistilled.operp.client.commons.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.commons.panes.models.observers.AddressPaneModelObserver;
import devopsdistilled.operp.server.data.entity.commons.Address;

public interface AddressPaneModel extends
		EntityPaneModel<Address, AddressPaneModelObserver> {

}
