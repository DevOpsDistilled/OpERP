package devopsdistilled.operp.client.items.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityObserver;
import devopsdistilled.operp.server.data.entity.items.Product;

public interface ProductModelObserver extends EntityObserver {

	public void updateProducts(List<Product> products);

}
