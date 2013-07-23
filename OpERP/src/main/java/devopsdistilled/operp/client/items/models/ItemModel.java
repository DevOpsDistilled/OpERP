package devopsdistilled.operp.client.items.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.items.models.observers.ItemModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.service.items.ItemService;

public interface ItemModel extends
		EntityModel<Item, ItemService, ItemModelObserver, Long> {

}
