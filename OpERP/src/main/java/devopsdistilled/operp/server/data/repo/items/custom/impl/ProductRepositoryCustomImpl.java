package devopsdistilled.operp.server.data.repo.items.custom.impl;

import javax.inject.Inject;

import devopsdistilled.operp.server.data.repo.items.ProductRepository;
import devopsdistilled.operp.server.data.repo.items.custom.ProductRepositoryCustom;

public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
	@Inject
	private ProductRepository repo;

}
