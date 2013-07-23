package devopsdistilled.operp.client.items;

import devopsdistilled.operp.client.abstracts.SubTaskPaneController;
import devopsdistilled.operp.server.data.entity.items.Item;

public interface ItemPaneController extends SubTaskPaneController<ItemModel> {

	boolean validate(Item item);

	Item save(Item item);

}
