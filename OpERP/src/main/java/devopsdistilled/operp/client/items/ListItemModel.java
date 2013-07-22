package devopsdistilled.operp.client.items;

import java.util.List;
import java.util.Vector;

import devopsdistilled.operp.client.abstracts.Model;
import devopsdistilled.operp.server.data.entity.items.Item;

public interface ListItemModel extends Model {

	void setItems(List<Item> items);

	List<Item> getItems();

	void setTableColumnNames(Vector<String> columns);

	Vector<String> getTableColumnNames();

}
