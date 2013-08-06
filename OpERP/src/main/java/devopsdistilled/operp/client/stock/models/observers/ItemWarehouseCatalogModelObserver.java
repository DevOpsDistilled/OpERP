package devopsdistilled.operp.client.stock.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.stock.ItemWarehouseCatalog;

public interface ItemWarehouseCatalogModelObserver extends
		EntityModelObserver{
	public void updateItemWarehouseCatalog(List<ItemWarehouseCatalog> itemWarehouses);

}
