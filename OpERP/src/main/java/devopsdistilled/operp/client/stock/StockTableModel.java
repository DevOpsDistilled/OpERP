package devopsdistilled.operp.client.stock;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class StockTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	private final Vector<String> columnNames;
	
	public StockTableModel(){
		columnNames=new Vector<>();
		columnNames.add("Stock Id");
		columnNames.add("Item Id");
		columnNames.add("WareHouse Id");
		columnNames.add("Item Name");
		columnNames.add("WareHouseName");
		columnNames.add("Quantity");
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnName(int column) {
		String columnName = null;

		if (column < columnNames.size() && (column >= 0)) {
			columnName = columnNames.elementAt(column);
		}

		return columnName;
	}
}
