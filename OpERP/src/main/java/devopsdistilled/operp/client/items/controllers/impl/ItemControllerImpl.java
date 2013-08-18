package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.controllers.ItemController;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.panes.controllers.CreateItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.EditItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.ListItemPaneController;
import devopsdistilled.operp.server.data.entity.items.Item;

public class ItemControllerImpl implements ItemController {

	@Inject
	private CreateItemPaneController createItemPaneController;

	@Inject
	private ListItemPaneController listItemPaneController;

	@Inject
	private EditItemPaneController editItemPaneController;

	@Inject
	private ItemModel itemModel;

	@Override
	public void create() {
		createItemPaneController.init();
	}

	@Override
	public void edit(Item item) {
		editItemPaneController.init(item);
	}

	@Override
	public void list() {
		listItemPaneController.init();
	}

	@Override
	public void delete(Item item) {
		itemModel.deleteAndUpdateModel(item);
	}

	@Override
	public void showDetails(Item entity) {
		// TODO Auto-generated method stub
		
	}

}
