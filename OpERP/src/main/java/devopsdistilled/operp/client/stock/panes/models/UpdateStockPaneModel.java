package devopsdistilled.operp.client.stock.panes.models;

import devopsdistilled.operp.client.abstracts.PaneModel;
import devopsdistilled.operp.client.stock.panes.models.observers.UpdateStockPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public interface UpdateStockPaneModel extends
		PaneModel<UpdateStockPaneModelObserver> {

	void setItem(Item item);

	Warehouse getWarehouse();

	void setWarehouse(Warehouse warehouse);

	Long getQuantity();

	void setQuantity(Long quantity);

	Item getItem();

	String getNote();

	void setNote(String note);

}
