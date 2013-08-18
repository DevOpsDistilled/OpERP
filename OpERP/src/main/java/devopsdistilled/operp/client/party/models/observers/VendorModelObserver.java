package devopsdistilled.operp.client.party.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public interface VendorModelObserver extends EntityModelObserver {

	public void updateVendors(List<Vendor> vendors);

}
