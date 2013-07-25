package devopsdistilled.operp.client.items.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityObserver;
import devopsdistilled.operp.server.data.entity.items.Brand;

public interface BrandModelObserver extends EntityObserver {

	public void updateBrands(List<Brand> brands);

}
