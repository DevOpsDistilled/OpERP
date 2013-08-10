package devopsdistilled.operp.client.stock.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.stock.controllers.WarehouseController;
import devopsdistilled.operp.client.stock.models.observers.WarehouseModelObserver;
import devopsdistilled.operp.client.stock.panes.models.observers.TransferStockPaneModelObserver;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class TransferStockPane extends SubTaskPane implements
		TransferStockPaneModelObserver, WarehouseModelObserver {

	@Inject
	private WarehouseController warehouseController;

	private final JPanel pane;
	private final JTextField quantityField;
	private final JComboBox<Warehouse> toWarehouseCombo;
	private final JComboBox<Warehouse> fromWarehouseCombo;

	public TransferStockPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));

		JLabel lblFromWarehouse = new JLabel("From Warehouse");
		pane.add(lblFromWarehouse, "cell 0 0,alignx trailing");

		fromWarehouseCombo = new JComboBox<>();
		pane.add(fromWarehouseCombo, "cell 1 0,growx");

		JLabel lblToWarehouse = new JLabel("To Warehouse");
		pane.add(lblToWarehouse, "cell 0 1,alignx trailing");

		toWarehouseCombo = new JComboBox<>();
		pane.add(toWarehouseCombo, "flowx,cell 1 1,growx");

		JLabel lblQuantity = new JLabel("Quantity");
		pane.add(lblQuantity, "cell 0 2,alignx trailing");

		JButton btnNewWarehouse = new JButton("New Warehouse");
		btnNewWarehouse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				warehouseController.create();
			}
		});
		pane.add(btnNewWarehouse, "cell 1 1");

		quantityField = new JTextField();
		pane.add(quantityField, "cell 1 2,growx");
		quantityField.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnCancel, "flowx,cell 1 4");

		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		pane.add(btnTransfer, "cell 1 4");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateWarehouse(List<Warehouse> warehouses) {
		Warehouse prevSelectedFrom = (Warehouse) fromWarehouseCombo
				.getSelectedItem();
		Warehouse prevSelectedTo = (Warehouse) toWarehouseCombo
				.getSelectedItem();

		fromWarehouseCombo.removeAllItems();
		toWarehouseCombo.removeAllItems();

		for (Warehouse warehouse : warehouses) {
			fromWarehouseCombo.addItem(warehouse);
			toWarehouseCombo.addItem(warehouse);

			if (prevSelectedFrom != null)
				if (prevSelectedFrom.compareTo(warehouse) == 0)
					fromWarehouseCombo.setSelectedItem(warehouse);

			if (prevSelectedTo != null)
				if (prevSelectedTo.compareTo(warehouse) == 0)
					toWarehouseCombo.setSelectedItem(warehouse);
		}
	}

}
