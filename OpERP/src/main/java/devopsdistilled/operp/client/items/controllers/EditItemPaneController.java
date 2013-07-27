package devopsdistilled.operp.client.items.controllers;

import devopsdistilled.operp.client.abstracts.SubTaskPaneController;
import devopsdistilled.operp.server.data.entity.items.Item;

public interface EditItemPaneController extends SubTaskPaneController {

	public void init(Item item);

	public Item save(Item item);

	public void validate(Item item);
}
