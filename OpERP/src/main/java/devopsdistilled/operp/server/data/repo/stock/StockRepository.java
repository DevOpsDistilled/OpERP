package devopsdistilled.operp.server.data.repo.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

@Repository
public interface StockRepository extends JpaRepository<StockKeeper, Long> {

	StockKeeper findByItemAndWarehouse(Item item, Warehouse warehouse);

}
