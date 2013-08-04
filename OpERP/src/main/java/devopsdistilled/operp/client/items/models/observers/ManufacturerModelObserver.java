package devopsdistilled.operp.client.items.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public interface ManufacturerModelObserver extends EntityModelObserver {

	public void updateManufacturers(List<Manufacturer> manufacturers);

}
