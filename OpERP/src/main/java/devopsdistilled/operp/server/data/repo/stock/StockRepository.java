package devopsdistilled.operp.server.data.repo.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	Stock findByItemAndWarehouse(Item item, Warehouse warehouse);

}
