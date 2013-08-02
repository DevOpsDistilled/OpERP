package devopsdistilled.operp.client.items.panes.models.observers;

import devopsdistilled.operp.client.abstracts.PaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;

public interface EditItemPaneModelObserver extends PaneModelObserver {

	void updateItem(Item item);

}
