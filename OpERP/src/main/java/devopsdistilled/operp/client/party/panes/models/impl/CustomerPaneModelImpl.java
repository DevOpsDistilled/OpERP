package devopsdistilled.operp.client.party.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.party.panes.models.CustomerPaneModel;
import devopsdistilled.operp.client.party.panes.models.observers.CustomerPaneModelObserver;
import devopsdistilled.operp.server.data.entity.party.Customer;

public class CustomerPaneModelImpl extends
		AbstractEntityPaneModel<Customer, CustomerPaneModelObserver> implements
		CustomerPaneModel {

	@Override
	public String getTitle() {
		return "Customer";
	}

}
