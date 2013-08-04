package devopsdistilled.operp.client.items.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.items.models.ManufacturerModel;
import devopsdistilled.operp.client.items.models.observers.ManufacturerModelObserver;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;
import devopsdistilled.operp.server.data.service.items.ManufacturerService;

public class ManufacturerModelImpl
		extends
		AbstractEntityModel<Manufacturer, ManufacturerService, ManufacturerModelObserver>
		implements ManufacturerModel {

	@Inject
	private ManufacturerService service;

	@Override
	public ManufacturerService getService() {
		return service;
	}

}
