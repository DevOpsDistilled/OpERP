package devopsdistilled.operp.client.items.panes.controllers;

import devopsdistilled.operp.client.abstracts.SubTaskPaneController;
import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.exceptions.ProductBrandPairExistsException;
import devopsdistilled.operp.server.data.entity.items.Item;

public interface CreateItemPaneController extends SubTaskPaneController {

	void validate(Item item) throws ProductBrandPairExistsException,
			EntityNameExistsException, NullFieldException;

	Item save(Item item);

}
