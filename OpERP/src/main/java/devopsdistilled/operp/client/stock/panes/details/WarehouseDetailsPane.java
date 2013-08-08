package devopsdistilled.operp.client.stock.panes.details;

import javax.inject.Inject;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.client.stock.controllers.WarehouseController;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WarehouseDetailsPane extends
		AbstractEntityDetailsPane<Warehouse, WarehouseController> {

	@Inject
	private WarehouseController warehouseController;

	private Warehouse warehouse;

	private JPanel pane;
	private JTextField warehouseIdField;
	private JTextField warehouseNameField;

	public WarehouseDetailsPane() {
		dialog.setTitle("Warehouse Details");
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));

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

	}

	@Override
	public JPanel getPane() {
		return pane;
	}

	@Override
	public void show(Warehouse warehouse) {
		this.warehouse = warehouse;
		if (warehouse != null) {
			warehouseIdField.setText(warehouse.getWarehouseId().toString());
			warehouseNameField.setText(warehouse.getWarehouseName());
			showDetailsPane(getPane());
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

}
