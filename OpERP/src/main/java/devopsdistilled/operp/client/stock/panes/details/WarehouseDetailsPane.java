package devopsdistilled.operp.client.stock.panes.details;

import java.awt.Dimension;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.client.abstracts.libs.BeanTableModel;
import devopsdistilled.operp.client.stock.controllers.WarehouseController;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.models.observers.StockModelObserver;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class WarehouseDetailsPane extends
		AbstractEntityDetailsPane<Warehouse, WarehouseController> implements
		StockModelObserver {

	@Inject
	private WarehouseController warehouseController;

	@Inject
	private StockModel stockModel;

	private Warehouse warehouse;

	private final JPanel pane;
	private final JTextField warehouseIdField;
	private final JTextField warehouseNameField;

	private final JTable table;
	BeanTableModel<Stock> tableModel;
	private final JLabel lblItemsInThis;

	public WarehouseDetailsPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow,center]", "[][][][grow]"));

		JLabel lblWarehouseId = new JLabel("Warehouse Id");
		pane.add(lblWarehouseId, "cell 0 0,alignx trailing");

		warehouseIdField = new JTextField();
		warehouseIdField.setColumns(10);
		warehouseIdField.setEditable(false);
		pane.add(warehouseIdField, "cell 1 0,growx");

		JLabel lblWarehouseName = new JLabel("Warehouse Name");
		pane.add(lblWarehouseName, "cell 0 1,alignx trailing");

		warehouseNameField = new JTextField();
		pane.add(warehouseNameField, "cell 1 1,growx");
		warehouseNameField.setEditable(false);
		warehouseNameField.setColumns(10);

		lblItemsInThis = new JLabel("Items In this Warehouse");
		pane.add(lblItemsInThis, "cell 1 2");

		table = new JTable(tableModel);
		final JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(456, 200));
		pane.add(scrollPane, "cell 1 3,grow");

	}

	@Override
	public JPanel getPane() {
		return pane;
	}

	@Override
	public void show(Warehouse warehouse, JComponent owner) {
		this.warehouse = warehouse;

		stockModel.registerObserver(this);

		if (warehouse != null) {
			warehouseIdField.setText(warehouse.getWarehouseId().toString());
			warehouseNameField.setText(warehouse.getWarehouseName());
			showDetailsPane(getPane(), owner);
		} else {
			dialog.dispose();
			JOptionPane.showMessageDialog(getPane(), "Null Warehouse");
		}

	}

	@Override
	public String getTitle() {
		return "Warehouse Details";
	}

	@Override
	public WarehouseController getEntityController() {
		return warehouseController;
	}

	@Override
	protected Warehouse getEntity() {
		return warehouse;
	}

	@Override
	public void updateStock(List<Stock> stocks) {

		List<Stock> warehouseStock = new LinkedList<>();
		for (Stock stock : stocks) {
			if (stock.getWarehouse().compareTo(getEntity()) == 0) {
				warehouseStock.add(stock);
			}
		}

		tableModel = null;
		tableModel = new BeanTableModel<>(Stock.class, warehouseStock);

		for (int i = 0; i < table.getColumnCount(); i++) {
			tableModel.setColumnEditable(i, false);
		}
		tableModel.setModelEditable(false);
		table.setModel(tableModel);

		JTableHeader tableHeader = table.getTableHeader();
		Enumeration<TableColumn> columns = tableHeader.getColumnModel()
				.getColumns();
		while (columns.hasMoreElements()) {
			final TableColumn column = columns.nextElement();
			String columnName = (String) column.getHeaderValue();
			if (columnName.equalsIgnoreCase("Stock Id")
					|| columnName.equalsIgnoreCase("Warehouse")) {

				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						table.removeColumn(column);
					}
				});
			}

		}
	}

}
