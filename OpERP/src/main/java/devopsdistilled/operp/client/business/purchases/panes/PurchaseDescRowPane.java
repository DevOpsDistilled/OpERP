package devopsdistilled.operp.client.business.purchases.panes;

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
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.business.purchases.controllers.PurchaseDescRowController;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchaseDescRowPaneController;
import devopsdistilled.operp.client.business.purchases.panes.models.observers.PurchaseDescRowPaneModelObserver;
import devopsdistilled.operp.client.items.controllers.ItemController;
import devopsdistilled.operp.client.items.models.observers.ItemModelObserver;
import devopsdistilled.operp.client.stock.controllers.WarehouseController;
import devopsdistilled.operp.client.stock.models.observers.WarehouseModelObserver;
import devopsdistilled.operp.server.data.entity.business.PurchaseDescRow;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class PurchaseDescRowPane
		extends
		EntityPane<PurchaseDescRow, PurchaseDescRowController, PurchaseDescRowPaneController>
		implements PurchaseDescRowPaneModelObserver, ItemModelObserver,
		WarehouseModelObserver {

	@Inject
	private ItemController itemController;

	@Inject
	private WarehouseController warehouseController;

	private final JPanel pane;
	private final JTextField priceField;
	private final JTextField quantityField;
	private final JComboBox<Item> itemCombo;
	private final JButton btnNewItem;
	private final JLabel lblToWarehouse;
	private final JComboBox<Warehouse> warehouseCombo;
	private final JButton btnNewWarehouse;

	public PurchaseDescRowPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));

		JLabel lblItem = new JLabel("Item");
		pane.add(lblItem, "cell 0 0,alignx trailing");

		itemCombo = new JComboBox<>();
		itemCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Item selItem = (Item) e.getItem();
					getController().getModel().getEntity().setItem(selItem);
				}
			}
		});
		pane.add(itemCombo, "cell 1 0,growx");

		btnNewItem = new JButton("New Item");
		btnNewItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemController.create();
			}
		});
		pane.add(btnNewItem, "cell 1 1,alignx right");

		lblToWarehouse = new JLabel("To Warehouse");
		pane.add(lblToWarehouse, "cell 0 2,alignx trailing");

		warehouseCombo = new JComboBox<>();
		warehouseCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Warehouse warehouse = (Warehouse) e.getItem();
					getController().getModel().getEntity()
							.setWarehouse(warehouse);
				}
			}
		});
		pane.add(warehouseCombo, "cell 1 2,growx");

		btnNewWarehouse = new JButton("New Warehouse");
		btnNewWarehouse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				warehouseController.create();
			}
		});
		pane.add(btnNewWarehouse, "cell 1 3,alignx right");

		JLabel lblPrice = new JLabel("Price");
		pane.add(lblPrice, "cell 0 4,alignx trailing");

		priceField = new JTextField();
		priceField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Double price = Double.parseDouble(priceField.getText()
							.trim());
					getController().getModel().getEntity().setRate(price);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(getPane(),
							"Price Field must be numeric value");
					priceField.setText("0");
					getController().getModel().getEntity().setRate(0.0);
				}
			}
		});
		pane.add(priceField, "cell 1 4,growx");
		priceField.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity");
		pane.add(lblQuantity, "cell 0 5,alignx trailing");

		quantityField = new JTextField();
		quantityField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Long quantity = Long.parseLong(quantityField.getText()
							.trim());
					getController().getModel().getEntity()
							.setQuantity(quantity);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(getPane(),
							"Quantity Field must be numeric value");

					quantityField.setText("0");
					getController().getModel().getEntity().setQuantity(0L);
				}
			}
		});
		pane.add(quantityField, "cell 1 5,growx");
		quantityField.setColumns(10);
	}

	@Override
	public void resetComponents() {
		// TODO Auto-generated method stub
		itemCombo.setSelectedItem(null);
		quantityField.setText("");
		priceField.setText("");
	}

	@Override
	public PurchaseDescRowController getEntityController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(PurchaseDescRow purchaseDescRow,
			EntityOperation entityOperation) {

		if (EntityOperation.Create == entityOperation) {

		} else if (EntityOperation.Edit == entityOperation) {
			itemCombo.addItem(purchaseDescRow.getItem());
			priceField.setText(purchaseDescRow.getRate().toString());
			quantityField.setText(purchaseDescRow.getQuantity().toString());
		}
	}

	@Override
	public void updateItems(List<Item> items) {
		Item prevSelected = (Item) itemCombo.getSelectedItem();
		itemCombo.removeAllItems();

		for (Item item : items) {
			itemCombo.addItem(item);
			if (prevSelected != null)
				if (prevSelected.compareTo(item) == 0)
					itemCombo.setSelectedItem(item);
		}
	}

	@Override
	public void updateWarehouses(List<Warehouse> warehouses) {
		Warehouse prevSelected = (Warehouse) warehouseCombo.getSelectedItem();
		warehouseCombo.removeAllItems();

		for (Warehouse warehouse : warehouses) {
			warehouseCombo.addItem(warehouse);
			if (prevSelected != null)
				if (prevSelected.compareTo(warehouse) == 0)
					warehouseCombo.setSelectedItem(warehouse);
		}
	}

}
