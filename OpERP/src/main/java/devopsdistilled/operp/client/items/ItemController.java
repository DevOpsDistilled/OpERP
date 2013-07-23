package devopsdistilled.operp.client.items;

import devopsdistilled.operp.server.data.entity.items.Item;

public interface ItemController {

	public void createItem();

	public void editItem(Item item);
	
	public void listItems();

}
