package devopsdistilled.operp.client.items;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;

import devopsdistilled.operp.server.data.entity.items.Item;

public class ItemControllerImpl implements ItemController {

	@Inject
	ApplicationContext context;

	@Override
	public void createItem() {
		ItemPane itemPane = context.getBean(ItemPane.class);
		itemPane.init();
		// itemPane.setOwner(getPane());
		itemPane.getDialog();
	}

	@Override
	public void editItem(Item item) {

	}

	@Override
	public void listItems() {
		ListItemPane listItemPane = context.getBean(ListItemPane.class);
		listItemPane.init();
		// listItemPane.setOwner(getPane());
		listItemPane.getDialog();
	}

}
