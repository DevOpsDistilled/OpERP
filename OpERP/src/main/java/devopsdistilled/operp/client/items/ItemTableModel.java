package devopsdistilled.operp.client.items;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import devopsdistilled.operp.server.data.entity.items.Item;

public class ItemTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 637464853861264641L;

	private final Vector<String> columnNames;
	List<Item> items;

	public ItemTableModel() {
		items = new LinkedList<>();
		columnNames = new Vector<>();
		columnNames.add("Item ID");
		columnNames.add("Item Name");
		columnNames.add("Product");
		columnNames.add("Brand");
		columnNames.add("Price");
	}

	@Override
	public int getRowCount() {
		return items.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Item selectedItem = items.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return selectedItem.getItemId();
		case 1:
			return selectedItem.getItemName();
		case 2:
			return selectedItem.getProduct();
		case 3:
			return selectedItem.getBrand();
		case 4:
			return selectedItem.getPrice();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		String columnName = null;

		if (column < columnNames.size() && (column >= 0)) {
			columnName = columnNames.elementAt(column);
		}

		return columnName;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public void setItems(List<Item> items) {
		this.items = items;
		fireTableDataChanged();
	}

	public Item getItemAt(int rowIndex) {
		return items.get(rowIndex);
	}

}
