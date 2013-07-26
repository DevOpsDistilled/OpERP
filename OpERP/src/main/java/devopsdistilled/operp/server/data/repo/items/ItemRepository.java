package devopsdistilled.operp.server.data.repo.items;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.items.Product;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findByProductAndBrand(Product product, Brand brand);

	List<Item> findByItemName(String itemName);

}
