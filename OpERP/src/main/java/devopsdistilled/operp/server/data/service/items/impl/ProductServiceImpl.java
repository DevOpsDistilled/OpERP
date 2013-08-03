package devopsdistilled.operp.server.data.service.items.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.items.Product;
import devopsdistilled.operp.server.data.repo.items.ProductRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.items.ProductService;

@Service
public class ProductServiceImpl extends
		AbstractEntityService<Product, Long, ProductRepository> implements
		ProductService {

	private static final long serialVersionUID = 8517308443607933958L;

	@Inject
	private ProductRepository productRepository;

	@Override
	protected ProductRepository getRepo() {
		return productRepository;
	}

	@Override
	public boolean isProductNameExists(String productName) {
		Product product = productRepository.findByProductName(productName);

		if (product != null)
			return true;

		return false;
	}

}
