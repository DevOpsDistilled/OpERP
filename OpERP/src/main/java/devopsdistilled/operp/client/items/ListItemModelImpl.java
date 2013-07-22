package devopsdistilled.operp.client.items;

import java.util.List;
import java.util.Vector;

import devopsdistilled.operp.client.abstracts.AbstractModel;
import devopsdistilled.operp.server.data.entity.items.Item;

public class ListItemModelImpl extends AbstractModel<ListItemModelObserver>
		implements ListItemModel {

	private List<Item> items;
	private Vector<String> tableColumnNames;

	@Override
	public void setItems(List<Item> items) {
		this.items = items;

		for (ListItemModelObserver observer : observers) {
			observer.updateItemList();
		}
	}

	@Override
	public List<Item> getItems() {
		return items;
	}

	@Override
	public void setTableColumnNames(Vector<String> columns) {
		this.tableColumnNames = columns;

		for (ListItemModelObserver observer : observers) {
			observer.updateColumnNames();
		}
	}

	@Override
	public Vector<String> getTableColumnNames() {
		return tableColumnNames;
	}

}
