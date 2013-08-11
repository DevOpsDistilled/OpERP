package devopsdistilled.operp.server.data.service.stock;

import java.util.List;

import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.service.EntityService;

public interface StockService extends EntityService<Stock, Long> {

	List<Item> getItemsInWarehouse(Long warehouseId);

	Long getQuantityOfItemInWarehouse(Long itemId, Long warehouseId);

	boolean isItemExistsInWarehouse(Long itemId, Long warehouseId);

}
