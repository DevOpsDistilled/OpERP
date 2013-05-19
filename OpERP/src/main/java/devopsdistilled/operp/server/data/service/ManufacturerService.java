package devopsdistilled.operp.server.data.service;

import devopsdistilled.operp.server.data.entity.Manufacturer;

public interface ManufacturerService extends
		AbstractService<Manufacturer, Long> {
	public Manufacturer createManufacturer();

}
