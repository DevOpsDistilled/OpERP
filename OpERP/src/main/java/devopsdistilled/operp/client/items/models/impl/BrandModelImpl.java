package devopsdistilled.operp.client.items.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.models.observers.BrandModelObserver;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.service.items.BrandService;

public class BrandModelImpl extends
		AbstractEntityModel<Brand, BrandService, BrandModelObserver>
		implements BrandModel {

	@Inject
	private BrandService service;

	@Override
	public BrandService getService() {
		return service;
	}

}
