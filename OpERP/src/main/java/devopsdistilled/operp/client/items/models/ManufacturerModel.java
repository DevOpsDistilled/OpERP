package devopsdistilled.operp.client.items.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.items.models.observers.ManufacturerModelObserver;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;
import devopsdistilled.operp.server.data.service.items.ManufacturerService;

public interface ManufacturerModel
		extends
		EntityModel<Manufacturer, ManufacturerService, ManufacturerModelObserver> {

}
