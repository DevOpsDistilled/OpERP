package devopsdistilled.operp.server.data.service.items;

import java.io.Serializable;

import devopsdistilled.operp.server.data.entity.items.Item;

public interface ItemService extends Serializable {
	public Item createItem();
}
