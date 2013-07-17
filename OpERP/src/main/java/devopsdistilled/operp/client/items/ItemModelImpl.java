package devopsdistilled.operp.client.items;

import devopsdistilled.operp.client.abstracts.AbstractModel;
import devopsdistilled.operp.server.data.entity.items.Item;

public class ItemModelImpl extends AbstractModel<ItemModelObserver> implements
		ItemModel {

	private Item item;

	public ItemModelImpl() {
	}

	public ItemModelImpl(Item item) {
		this.item = item;
	}

	@Override
	public Item getItem() {
		return item;
	}
}
