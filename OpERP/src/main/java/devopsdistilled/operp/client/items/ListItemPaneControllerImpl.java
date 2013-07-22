package devopsdistilled.operp.client.items;

import java.util.Vector;

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
		Vector<String> columns = new Vector<>();
		columns.add("Item ID");
		columns.add("Item Name");
		columns.add("Product");
		columns.add("Brand");
		columns.add("Price");
		model.setTableColumnNames(columns);
		model.setItems(itemService.findAll());
	}

}
