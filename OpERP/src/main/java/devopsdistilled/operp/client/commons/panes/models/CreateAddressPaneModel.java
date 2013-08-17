package devopsdistilled.operp.client.commons.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.commons.panes.models.observers.CreateAddressPaneModelObserver;
import devopsdistilled.operp.server.data.entity.commons.Address;

public interface CreateAddressPaneModel extends
		EntityPaneModel<Address, CreateAddressPaneModelObserver> {

	public Address getAddress();

}
