package devopsdistilled.operp.server.data.service.stock;

import java.util.List;

import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;
import devopsdistilled.operp.server.data.service.EntityService;

public interface StockService extends EntityService<Stock, Long> {

	boolean isItemWarehousePairExists(Item itemName, Warehouse warehouseName);

	List<Item> getItemsInWarehouse(Long warehouseId);

	Long getQuantityOfItemInWarehouse(Long itemId, Long warehouseId);

}
