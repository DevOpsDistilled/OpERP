package devopsdistilled.operp.client.party.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.party.Customer;

public interface CustomerModelObserver extends EntityModelObserver {

	public void updateCustomers(List<Customer> customers);

}
