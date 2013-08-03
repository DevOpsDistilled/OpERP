package devopsdistilled.operp.client.stock.models.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;
public class WarehouseTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 6296106647425765883L;
	
	private final Vector<String> columnNames;
	List<Warehouse> warehouse;
	
	public WarehouseTableModel(){
		warehouse=new LinkedList<>();
		columnNames=new Vector<>();
		columnNames.add("Warehouse Id");
		columnNames.add("Warehouse Name");
		
	}
	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		return warehouse.size();
	}

	@Override
	public Object getValueAt(int rowindex, int columnindex) {
		Warehouse selectedWarehouse=warehouse.get(rowindex);
		switch(columnindex){
		case 0:
			return selectedWarehouse.getWarehouseId();
	
		case 1:
			return selectedWarehouse.getWarehouseName();
			
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
	
	public void setWarehouse(List<Warehouse>warehouse){
		this.warehouse=warehouse;
		fireTableDataChanged();
	}
	public Warehouse getWarehouseAt(int rowindex){
		return warehouse.get(rowindex);
	}
}
