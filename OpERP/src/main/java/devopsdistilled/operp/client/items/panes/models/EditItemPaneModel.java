package devopsdistilled.operp.client.items.panes.model;

import devopsdistilled.operp.client.abstracts.PaneModel;
import devopsdistilled.operp.client.items.models.observers.EditItemPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;

public interface EditItemPaneModel extends PaneModel<EditItemPaneModelObserver> {

	void setItem(Item item);

	Item getItem();
}
