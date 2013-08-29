package devopsdistilled.operp.client.stock.panes;

import java.awt.Dimension;
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
import devopsdistilled.operp.client.items.controllers.ItemController;
import devopsdistilled.operp.client.items.models.observers.ItemModelObserver;
import devopsdistilled.operp.client.stock.controllers.WarehouseController;
import devopsdistilled.operp.client.stock.models.observers.WarehouseModelObserver;
import devopsdistilled.operp.client.stock.panes.controllers.UpdateStockPaneController;
import devopsdistilled.operp.client.stock.panes.details.StockKeepingDetailsPane;
import devopsdistilled.operp.client.stock.panes.models.observers.UpdateStockPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class UpdateStockPane extends SubTaskPane implements
		UpdateStockPaneModelObserver, ItemModelObserver, WarehouseModelObserver {

	@Inject
	private UpdateStockPaneController controller;

	@Inject
	private WarehouseController warehouseController;

	@Inject
	private ItemController itemController;

	@Inject
	private StockKeepingDetailsPane stockKeepingDetailsPane;

	private final JPanel pane;
	private final JTextField quantityField;
	private final JComboBox<Item> comboItems;
	private final JComboBox<Warehouse> comboWarehouses;
	private final JTextField noteField;

	public UpdateStockPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[]25[grow]", "[][]"));

		JLabel lblItemName = new JLabel("Item Name");
		pane.add(lblItemName, "cell 0 0,alignx trailing");

		comboItems = new JComboBox<Item>();
		comboItems.setMinimumSize(new Dimension(100, 24));
		comboItems.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					getDialog().pack();
					controller.getModel().setItem((Item) e.getItem());
				}
			}
		});
		comboItems.setSelectedItem(null);
		pane.add(comboItems, "flowx,cell 1 0,growx");

		JButton btnNewItem = new JButton("New Item");
		btnNewItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemController.create();
			}
		});
		pane.add(btnNewItem, "cell 1 0");

		JLabel lblWarehouseName = new JLabel("Warehouse Name");
		pane.add(lblWarehouseName, "cell 0 1,alignx trailing");

		comboWarehouses = new JComboBox<Warehouse>();
		comboWarehouses.setMinimumSize(new Dimension(100, 24));
		comboWarehouses.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					getDialog().pack();
					controller.getModel().setWarehouse((Warehouse) e.getItem());
				}
			}
		});
		comboWarehouses.setSelectedItem(null);
		pane.add(comboWarehouses, "flowx,cell 1 1,growx");

		JButton btnNewWarehouse = new JButton("New Warehouse");
		btnNewWarehouse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				warehouseController.create();
			}
		});

		pane.add(btnNewWarehouse, "cell 1 1");

		JLabel lblQuantity = new JLabel("Quantity");
		pane.add(lblQuantity, "cell 0 2,alignx trailing");

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
							"Quantity field must be numeric value");
				}
			}
		});
		pane.add(quantityField, "cell 1 2,growx");
		quantityField.setColumns(15);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});

		JLabel lblNote = new JLabel("Note");
		pane.add(lblNote, "cell 0 3,alignx trailing");

		noteField = new JTextField();
		noteField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.getModel().setNote(noteField.getText().trim());
			}
		});
		pane.add(noteField, "cell 1 3,growx");
		noteField.setColumns(20);
		pane.add(btnCancel, "flowx,cell 1 5");

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.validate();
					StockKeeper stockKeeper = controller.save();
					getDialog().dispose();
					stockKeepingDetailsPane.show(stockKeeper, getPane());

				} catch (EntityValidationException e1) {
					JOptionPane.showMessageDialog(getPane(), e1.getMessage());
				}

			}
		});
		pane.add(btnUpdate, "cell 1 5");

	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateItems(List<Item> items) {
		Item prevSelected = (Item) comboItems.getSelectedItem();
		comboItems.removeAllItems();

		for (Item item : items) {
			comboItems.addItem(item);
			if (prevSelected != null)
				if (prevSelected.compareTo(item) == 0)
					comboItems.setSelectedItem(item);
		}
	}

	@Override
	public void updateWarehouses(List<Warehouse> warehouses) {
		Warehouse prevSelected = (Warehouse) comboWarehouses.getSelectedItem();
		comboWarehouses.removeAllItems();

		for (Warehouse warehouse : warehouses) {
			comboWarehouses.addItem(warehouse);
			if (prevSelected != null)
				if (prevSelected.compareTo(warehouse) == 0)
					comboWarehouses.setSelectedItem(warehouse);
		}
	}

}
