package devopsdistilled.operp.server.data.service.items.impl;

import javax.inject.Inject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.items.Product;
import devopsdistilled.operp.server.data.repo.items.ProductRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.items.ProductService;

@Service
public class ProductServiceImpl extends AbstractEntityService<Product, Long>
		implements ProductService {

	private static final long serialVersionUID = 8517308443607933958L;

	@Inject
	private ProductRepository productRepository;

	@Override
	protected JpaRepository<Product, Long> getRepo() {
		return productRepository;
	}

}
