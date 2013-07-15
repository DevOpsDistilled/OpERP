package devopsdistilled.operp.server.data.repo.custom.impl;

import javax.inject.Inject;

import devopsdistilled.operp.server.data.entity.items.Product;
import devopsdistilled.operp.server.data.repo.ProductRepository;
import devopsdistilled.operp.server.data.repo.custom.ProductRepositoryCustom;

public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
	@Inject
	private ProductRepository repo;

	@Override
	public Product saveCustom(Product product) {
		System.out.println("From saveCustom");
		return repo.save(product);
	}

}
