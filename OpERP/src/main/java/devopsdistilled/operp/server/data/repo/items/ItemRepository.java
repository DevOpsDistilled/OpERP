package devopsdistilled.operp.server.data.repo.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.items.Product;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	Item findByProductAndBrand(Product product, Brand brand);

	Item findByItemName(String itemName);

}
