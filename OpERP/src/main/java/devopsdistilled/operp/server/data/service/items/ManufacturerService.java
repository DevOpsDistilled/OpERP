package devopsdistilled.operp.server.data.service.items;

import devopsdistilled.operp.server.data.entity.items.Manufacturer;
import devopsdistilled.operp.server.data.service.AbstractService;

public interface ManufacturerService extends
		AbstractService<Manufacturer, Long> {
	public Manufacturer createManufacturer();

}
