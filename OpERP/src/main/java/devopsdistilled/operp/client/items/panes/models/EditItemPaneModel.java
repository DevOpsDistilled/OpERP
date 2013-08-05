package devopsdistilled.operp.client.items.panes.models;

import devopsdistilled.operp.client.abstracts.EditEntityPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.EditItemPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;

public interface EditItemPaneModel extends
		EditEntityPaneModel<Item, EditItemPaneModelObserver> {

}