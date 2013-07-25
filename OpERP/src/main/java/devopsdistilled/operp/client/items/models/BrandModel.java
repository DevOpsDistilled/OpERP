package devopsdistilled.operp.client.items.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.items.models.observers.BrandModelObserver;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.service.items.BrandService;

public interface BrandModel extends
		EntityModel<Brand, BrandService, BrandModelObserver, Long> {

}
