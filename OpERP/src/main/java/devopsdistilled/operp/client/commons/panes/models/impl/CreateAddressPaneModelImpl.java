package devopsdistilled.operp.client.commons.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.commons.panes.models.CreateAddressPaneModel;
import devopsdistilled.operp.client.commons.panes.models.observers.CreateAddressPaneModelObserver;
import devopsdistilled.operp.server.data.entity.commons.Address;

public class CreateAddressPaneModelImpl extends
		AbstractEntityPaneModel<Address, CreateAddressPaneModelObserver>
		implements CreateAddressPaneModel {

	@Override
	public String getTitle() {
		return "Create Address";
	}

}
