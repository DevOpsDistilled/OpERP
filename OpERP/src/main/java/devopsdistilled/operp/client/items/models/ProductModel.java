package devopsdistilled.operp.client.items.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.items.models.observers.ProductModelObserver;
import devopsdistilled.operp.server.data.entity.items.Product;
import devopsdistilled.operp.server.data.service.items.ProductService;

public interface ProductModel extends
		EntityModel<Product, ProductService, ProductModelObserver> {

}
