package devopsdistilled.operp.client.party.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.party.panes.models.observers.CustomerPaneModelObserver;
import devopsdistilled.operp.server.data.entity.party.Customer;

public interface CustomerPaneModel extends
		EntityPaneModel<Customer, CustomerPaneModelObserver> {

}
