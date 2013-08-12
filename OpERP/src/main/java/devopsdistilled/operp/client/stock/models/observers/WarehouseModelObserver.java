package devopsdistilled.operp.client.stock.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public interface WarehouseModelObserver extends EntityModelObserver {

	public void updateWarehouses(List<Warehouse> warehouses);

}
