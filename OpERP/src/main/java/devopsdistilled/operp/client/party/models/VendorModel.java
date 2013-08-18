package devopsdistilled.operp.client.party.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.party.models.observers.VendorModelObserver;
import devopsdistilled.operp.server.data.entity.party.Vendor;
import devopsdistilled.operp.server.data.service.party.VendorService;

public interface VendorModel extends
		EntityModel<Vendor, VendorService, VendorModelObserver> {

}
