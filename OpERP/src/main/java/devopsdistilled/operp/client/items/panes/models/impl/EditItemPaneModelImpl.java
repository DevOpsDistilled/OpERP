package devopsdistilled.operp.client.items.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEditEntityPaneModel;
import devopsdistilled.operp.client.items.panes.models.EditItemPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.EditItemPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;

public class EditItemPaneModelImpl extends
		AbstractEditEntityPaneModel<Item, EditItemPaneModelObserver> implements
		EditItemPaneModel {

	@Override
	public String getTitle() {
		return "Edit Item";
	}

}