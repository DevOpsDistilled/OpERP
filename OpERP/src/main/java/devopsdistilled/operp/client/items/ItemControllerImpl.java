package devopsdistilled.operp.client.items;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;

import devopsdistilled.operp.client.items.controllers.CreateItemPaneController;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.service.items.ItemService;

public class ItemControllerImpl implements ItemController {

	@Inject
	private ApplicationContext context;

	@Inject
	private ItemService itemService;

	@Override
	public void createItem() {
		CreateItemPaneController createItemPaneController = context
				.getBean(CreateItemPaneController.class);
		createItemPaneController.init();
	}

	@Override
	public void editItem(Item item) {

	}

	@Override
	public void listItems() {
		ListItemPane listItemPane = context.getBean(ListItemPane.class);
		listItemPane.init();
		listItemPane.getDialog();
	}

	@Override
	public void deleteItem(Item item) {
		itemService.delete(item);
	}

}
