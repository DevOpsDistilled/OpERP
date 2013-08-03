package devopsdistilled.operp.server.data.service.stock;

import devopsdistilled.operp.server.data.entity.stock.Warehouse;
import devopsdistilled.operp.server.data.service.EntityService;

public interface WarehouseService extends EntityService<Warehouse, Long>{

	boolean isWarehouseNameExists(String warehouseName);
	boolean isWarehouseNameValidForWarehouse(Long warehouseId, String warehouseName);

}
