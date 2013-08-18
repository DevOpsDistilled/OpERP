package devopsdistilled.operp.client.commons.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.commons.panes.models.AddressPaneModel;
import devopsdistilled.operp.client.commons.panes.models.observers.AddressPaneModelObserver;
import devopsdistilled.operp.server.data.entity.commons.Address;

public class AddressPaneModelImpl extends
		AbstractEntityPaneModel<Address, AddressPaneModelObserver> implements
		AddressPaneModel {

	@Override
	public String getTitle() {
		return "Address";
	}

}
