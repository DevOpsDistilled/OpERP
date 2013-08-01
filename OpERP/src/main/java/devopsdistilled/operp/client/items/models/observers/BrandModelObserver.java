package devopsdistilled.operp.client.items.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.items.Brand;

public interface BrandModelObserver extends EntityModelObserver {

	public void updateBrands(List<Brand> brands);

}
