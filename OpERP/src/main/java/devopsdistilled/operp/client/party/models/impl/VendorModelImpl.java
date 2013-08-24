package devopsdistilled.operp.client.party.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.party.models.VendorModel;
import devopsdistilled.operp.client.party.models.observers.VendorModelObserver;
import devopsdistilled.operp.server.data.entity.party.Vendor;
import devopsdistilled.operp.server.data.service.party.VendorService;

public class VendorModelImpl extends
		AbstractEntityModel<Vendor, VendorService, VendorModelObserver>
		implements VendorModel {

	@Inject
	private VendorService service;

	@Override
	public VendorService getService() {
		return service;
	}

}
