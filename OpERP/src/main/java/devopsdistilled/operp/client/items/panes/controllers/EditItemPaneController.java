package devopsdistilled.operp.client.items.panes.controllers;

import devopsdistilled.operp.client.abstracts.SubTaskPaneController;
import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.exceptions.ProductBrandPairExistsException;
import devopsdistilled.operp.server.data.entity.items.Item;

public interface EditItemPaneController extends SubTaskPaneController {

	public void init(Item item);

	public Item save(Item item);

	public void validate(Item item) throws NullFieldException,
			ProductBrandPairExistsException, EntityNameExistsException;
}
