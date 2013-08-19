package devopsdistilled.operp.client.party.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.party.panes.CustomerPane;
import devopsdistilled.operp.client.party.panes.models.CustomerPaneModel;
import devopsdistilled.operp.server.data.entity.party.Customer;

public interface CustomerPaneController extends
		EntityPaneController<Customer, CustomerPaneModel, CustomerPane> {

}
