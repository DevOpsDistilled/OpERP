package devopsdistilled.operp.client.items.controllers;

import devopsdistilled.operp.client.abstracts.SubTaskPaneController;
import devopsdistilled.operp.client.items.exceptions.ItemNameExistsException;
import devopsdistilled.operp.client.items.exceptions.ProductBrandPairExistsException;
import devopsdistilled.operp.server.data.entity.items.Item;

public interface CreateItemPaneController extends SubTaskPaneController {

	void validate(Item item) throws ProductBrandPairExistsException,
			ItemNameExistsException;

	Item save(Item item);

}
