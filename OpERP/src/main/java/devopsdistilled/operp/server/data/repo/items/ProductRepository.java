package devopsdistilled.operp.server.data.repo.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devopsdistilled.operp.server.data.entity.items.Product;
import devopsdistilled.operp.server.data.repo.items.custom.ProductRepositoryCustom;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>,
		ProductRepositoryCustom {

	public Product findByProductName(String productName);

}
