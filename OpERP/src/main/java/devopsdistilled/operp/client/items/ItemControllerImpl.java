package devopsdistilled.operp.client.items;

import devopsdistilled.operp.client.ClientApp;
import devopsdistilled.operp.server.data.entity.items.Item;

public class ItemControllerImpl implements ItemController {

	@Override
	public void createItem() {
		ItemPane itemPane = ClientApp.getApplicationContext().getBean(
				ItemPane.class);
		itemPane.init();
		//itemPane.setOwner(getPane());
		itemPane.getDialog();
	}

	@Override
	public void editItem(Item item) {
		
	}

}
