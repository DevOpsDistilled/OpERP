package devopsdistilled.operp.server.data.service.items;

import devopsdistilled.operp.server.data.entity.items.Product;
import devopsdistilled.operp.server.data.service.EntityService;

public interface ProductService extends EntityService<Product, Long> {

	boolean isProductNameExists(String productName);

}
