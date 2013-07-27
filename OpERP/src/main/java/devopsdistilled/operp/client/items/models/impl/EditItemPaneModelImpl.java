package devopsdistilled.operp.client.items.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.models.EditItemPaneModel;
import devopsdistilled.operp.client.items.models.observers.EditItemPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;

public class EditItemPaneModelImpl extends
		AbstractPaneModel<EditItemPaneModelObserver> implements
		EditItemPaneModel {

	private Item item;

	public EditItemPaneModelImpl() {
		title = "Edit Item";
	}

	@Override
	public Item getItem() {
		return item;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setItem(Item item) {
		this.item = item;
		for (EditItemPaneModelObserver observer : observers) {
			observer.updateItem(this.item);
		}
	}

	/*
	 * Configure to "item" to notify observers along with pre-configured
	 * attributes in super.
	 */
	@Override
	public void update() {
		super.update();
		setItem(getItem());
	}
}
