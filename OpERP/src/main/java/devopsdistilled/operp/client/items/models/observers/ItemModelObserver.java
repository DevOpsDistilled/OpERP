package devopsdistilled.operp.client.items.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;

public interface ItemModelObserver extends EntityModelObserver {

	public void updateItems(List<Item> items);

}
