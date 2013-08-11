package devopsdistilled.operp.client.stock.panes.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.PaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;

public interface TransferStockPaneModelObserver extends PaneModelObserver {

	void updateItems(List<Item> fromWarehouseItems);

}
