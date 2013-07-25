package devopsdistilled.operp.client.items.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityObserver;
import devopsdistilled.operp.server.data.entity.items.Item;

public interface ItemModelObserver extends EntityObserver {

	public void updateItems(List<Item> items);

}
