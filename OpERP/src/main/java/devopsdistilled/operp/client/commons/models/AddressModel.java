package devopsdistilled.operp.client.commons.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.commons.models.observers.AddressModelObserver;
import devopsdistilled.operp.server.data.entity.commons.Address;
import devopsdistilled.operp.server.data.service.commons.AddressService;

public interface AddressModel extends
		EntityModel<Address, AddressService, AddressModelObserver> {

}
