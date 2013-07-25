package devopsdistilled.operp.client.items.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.items.models.ProductModel;
import devopsdistilled.operp.client.items.models.observers.ProductModelObserver;
import devopsdistilled.operp.server.data.entity.items.Product;
import devopsdistilled.operp.server.data.service.items.ProductService;

public class ProductModelImpl
		extends
		AbstractEntityModel<Product, ProductService, ProductModelObserver, Long>
		implements ProductModel {

	@Inject
	private ProductService service;

	@Override
	public ProductService getService() {
		return null;
	}

}
