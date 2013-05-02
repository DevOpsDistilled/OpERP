package devopsdistilled.operp.server.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devopsdistilled.operp.server.data.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product> findByProductName(String productName);

}
