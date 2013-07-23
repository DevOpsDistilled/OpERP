package devopsdistilled.operp.client.items;

import devopsdistilled.operp.server.data.entity.items.Item;

public interface ItemPaneController {

	void loadData();

	boolean validate(Item item);

	Item save(Item item);

	ItemModel getModel();

}
