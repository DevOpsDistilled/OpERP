package devopsdistilled.operp.client.stock.panes.models;

import devopsdistilled.operp.client.abstracts.PaneModel;
import devopsdistilled.operp.client.stock.panes.models.observers.TransferStockPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public interface TransferStockPaneModel extends
		PaneModel<TransferStockPaneModelObserver> {

	void setFromWarehouse(Warehouse fromWarehouse);

	void setItemToTransfer(Item itemtoTransfer);

	void setToWarehouse(Warehouse toWarehouse);

	Long getQuantity();

	void setQuantity(Long quantity);

	Warehouse getFromWarehouse();

	Item getItemToTransfer();

	Warehouse getToWarehouse();

}
