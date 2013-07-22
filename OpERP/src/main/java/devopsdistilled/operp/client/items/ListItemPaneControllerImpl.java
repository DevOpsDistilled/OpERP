package devopsdistilled.operp.client.items;

import javax.inject.Inject;

import devopsdistilled.operp.server.data.service.items.ItemService;

public class ListItemPaneControllerImpl implements ListItemPaneController {

	@Inject
	private ListItemModel model;

	@Inject
	private ItemService itemService;

	@Override
	public ListItemModel getModel() {
		return model;
	}

	@Override
	public void loadData() {
		model.setItems(itemService.findAll());
	}

}
