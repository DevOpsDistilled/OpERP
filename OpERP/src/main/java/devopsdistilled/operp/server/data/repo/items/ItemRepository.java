package devopsdistilled.operp.server.data.repo.items;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devopsdistilled.operp.server.data.entity.items.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findByProductNameAndBrandName(String productName,
			String brandName);

	List<Item> findByItemName(String itemName);

}
