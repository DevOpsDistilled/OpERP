package devopsdistilled.operp.server.data.service;

import java.io.Serializable;

import devopsdistilled.operp.server.data.entity.Item;

public interface ItemService extends Serializable {
	public Item createItem();
}
