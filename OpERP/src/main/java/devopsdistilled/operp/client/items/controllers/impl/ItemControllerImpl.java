package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;

import devopsdistilled.operp.client.items.controllers.ItemController;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.panes.controllers.CreateItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.EditItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.ListItemPaneController;
import devopsdistilled.operp.server.data.entity.items.Item;

public class ItemControllerImpl implements ItemController {

	@Inject
	private ApplicationContext context;

	@Inject
	private ItemModel itemModel;

	@Override
	public void createItem() {
		CreateItemPaneController createItemPaneController = context
				.getBean(CreateItemPaneController.class);
		createItemPaneController.init();
	}

	@Override
	public void listItems() {
		ListItemPaneController listItemPaneController = context
				.getBean(ListItemPaneController.class);
		listItemPaneController.init();
	}

	@Override
	public void editItem(Item item) {
		EditItemPaneController editItemPaneController = context
				.getBean(EditItemPaneController.class);
		editItemPaneController.init(item);
	}

	@Override
	public void deleteItem(Item item) {
		itemModel.deleteAndUpdateModel(item);
	}

}
