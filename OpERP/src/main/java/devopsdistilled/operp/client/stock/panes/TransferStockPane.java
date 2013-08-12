package devopsdistilled.operp.client.stock.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.stock.controllers.WarehouseController;
import devopsdistilled.operp.client.stock.models.observers.WarehouseModelObserver;
import devopsdistilled.operp.client.stock.panes.controllers.TransferStockPaneController;
import devopsdistilled.operp.client.stock.panes.models.observers.TransferStockPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class TransferStockPane extends SubTaskPane implements
		TransferStockPaneModelObserver, WarehouseModelObserver {

	@Inject
	private TransferStockPaneController controller;

	@Inject
	private WarehouseController warehouseController;

	private final JPanel pane;
	private final JTextField quantityField;
	private final JComboBox<Warehouse> toWarehouseCombo;
	private final JComboBox<Warehouse> fromWarehouseCombo;
	private final JComboBox<Item> itemsCombo;

	public TransferStockPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));

		JLabel lblFromWarehouse = new JLabel("From Warehouse");
		pane.add(lblFromWarehouse, "cell 0 0,alignx trailing");

		fromWarehouseCombo = new JComboBox<>();
		fromWarehouseCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					Warehouse fromWarehouse = (Warehouse) event.getItem();
					controller.getModel().setFromWarehouse(fromWarehouse);
				}

			}
		});
		pane.add(fromWarehouseCombo, "cell 1 0,growx");

		JLabel lblItem = new JLabel("Item");
		pane.add(lblItem, "cell 0 1,alignx trailing");

		itemsCombo = new JComboBox<>();
		itemsCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					controller.getModel().setItemToTransfer((Item) e.getItem());
			}
		});
		pane.add(itemsCombo, "cell 1 1,growx");

		JLabel lblToWarehouse = new JLabel("To Warehouse");
		pane.add(lblToWarehouse, "cell 0 2,alignx trailing");

		toWarehouseCombo = new JComboBox<>();
		toWarehouseCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Warehouse toWarehouse = (Warehouse) e.getItem();
				controller.getModel().setToWarehouse(toWarehouse);
			}
		});
		pane.add(toWarehouseCombo, "flowx,cell 1 2,growx");

		JLabel lblQuantity = new JLabel("Quantity");
		pane.add(lblQuantity, "cell 0 3,alignx trailing");

		JButton btnNewWarehouse = new JButton("New Warehouse");
		btnNewWarehouse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				warehouseController.create();
			}
		});
		pane.add(btnNewWarehouse, "cell 1 2");

		quantityField = new JTextField();
		quantityField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Long quantity = Long.parseLong(quantityField.getText()
							.trim());
					controller.getModel().setQuantity(quantity);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(getPane(),
							"Quantity Field must be numeric value");
				}
			}
		});
		pane.add(quantityField, "cell 1 3,growx");
		quantityField.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnCancel, "flowx,cell 1 5");

		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.validate();
					controller.transfer();

				} catch (EntityValidationException e1) {
					JOptionPane.showMessageDialog(getPane(), e1.getMessage());
				}
			}
		});
		pane.add(btnTransfer, "cell 1 5");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateWarehouses(List<Warehouse> warehouses) {
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
				if (prevSelectedFrom.compareTo(warehouse) == 0) {
					fromWarehouseCombo.setSelectedItem(warehouse);
					toWarehouseCombo.removeItem(warehouse);
				}

			if (prevSelectedTo != null)
				if (prevSelectedTo.compareTo(warehouse) == 0)
					toWarehouseCombo.setSelectedItem(warehouse);
		}

	}

	@Override
	public void updateItems(List<Item> fromWarehouseItems) {
		Item prevSelectedItem = (Item) itemsCombo.getSelectedItem();
		itemsCombo.removeAllItems();

		for (Item item : fromWarehouseItems) {
			itemsCombo.addItem(item);
			if (prevSelectedItem != null)
				if (prevSelectedItem.compareTo(item) == 0)
					itemsCombo.setSelectedItem(item);
		}
	}

}
