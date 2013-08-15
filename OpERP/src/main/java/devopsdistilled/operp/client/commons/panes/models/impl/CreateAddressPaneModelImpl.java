package devopsdistilled.operp.client.commons.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.commons.panes.models.CreateAddressPaneModel;
import devopsdistilled.operp.client.commons.panes.models.observers.CreateAddressPaneModelObserver;
import devopsdistilled.operp.server.data.entity.commons.Address;

public class CreateAddressPaneModelImpl extends
		AbstractPaneModel<CreateAddressPaneModelObserver> implements
		CreateAddressPaneModel {

	private final Address address = new Address();

	@Override
	public String getTitle() {
		return "Create Address";
	}

	@Override
	public Address getAddress() {
		return address;
	}

}
