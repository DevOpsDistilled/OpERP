package devopsdistilled.operp.client.business.sales.panes;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.business.sales.controllers.SaleDescRowController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescRowPaneController;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SaleDescRowPaneModelObserver;
import devopsdistilled.operp.client.stock.models.observers.StockModelObserver;
import devopsdistilled.operp.server.data.entity.business.SaleDescRow;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class SaleDescRowPane
		extends
		EntityPane<SaleDescRow, SaleDescRowController, SaleDescRowPaneController>
		implements SaleDescRowPaneModelObserver, StockModelObserver {

	private final JPanel pane;
	private final JTextField priceField;
	private final JTextField quantityField;
	private final JComboBox<Item> itemCombo;
	private final JComboBox<Warehouse> warehouseCombo;
	private final JLabel lblFromWarehouse;

	public SaleDescRowPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));

		warehouseCombo = new JComboBox<>();
		warehouseCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Warehouse selWarehouse = (Warehouse) e.getItem();

					updateItems(getController().getItemsInWarehouse(
							selWarehouse));
				}

			}
		});

		lblFromWarehouse = new JLabel("From Warehouse");
		pane.add(lblFromWarehouse, "cell 0 0,alignx trailing");
		pane.add(warehouseCombo, "cell 1 0,growx");

		JLabel lblItem = new JLabel("Item");
		pane.add(lblItem, "cell 0 1,alignx trailing");

		itemCombo = new JComboBox<>();
		itemCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Item selItem = (Item) e.getItem();
					getController().getModel().getEntity().setItem(selItem);

					Double price = selItem.getPrice();
					priceField.setText(price.toString());
					getController().getModel().getEntity().setRate(price);

					Long quantity = getController().getQuantityOfItem(selItem);
					quantityField.setText(quantity.toString());
				}
			}
		});
		pane.add(itemCombo, "cell 1 1,growx");

		JLabel lblPrice = new JLabel("Price");
		pane.add(lblPrice, "cell 0 2,alignx trailing");

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
		pane.add(priceField, "cell 1 2,growx");
		priceField.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity");
		pane.add(lblQuantity, "cell 0 3,alignx trailing");

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
		pane.add(quantityField, "cell 1 3,growx");
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
	public SaleDescRowController getEntityController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(SaleDescRow saleDescRow,
			EntityOperation entityOperation) {

		if (EntityOperation.Create == entityOperation) {

		} else if (EntityOperation.Edit == entityOperation) {
			itemCombo.addItem(saleDescRow.getItem());
			priceField.setText(saleDescRow.getRate().toString());
			quantityField.setText(saleDescRow.getQuantity().toString());
		}
	}

	private void updateItems(List<Item> items) {
		Item prevSelected = (Item) itemCombo.getSelectedItem();
		itemCombo.removeAllItems();

		for (Item item : items) {
			itemCombo.addItem(item);
			if (prevSelected != null)
				if (prevSelected.compareTo(item) == 0)
					itemCombo.setSelectedItem(item);
		}
	}

	private void updateWarehouses(List<Warehouse> warehouses) {
		Warehouse prevSelected = (Warehouse) warehouseCombo.getSelectedItem();
		warehouseCombo.removeAllItems();

		for (Warehouse warehouse : warehouses) {
			warehouseCombo.addItem(warehouse);
			if (prevSelected != null)
				if (prevSelected.compareTo(warehouse) == 0)
					itemCombo.setSelectedItem(warehouse);
		}
	}

	@Override
	public void updateStock(List<Stock> stocks) {
		Set<Warehouse> warehouseSet = new HashSet<>();

		for (Stock stock : stocks)
			if (stock.getQuantity().compareTo(0L) > 0)
				warehouseSet.add(stock.getWarehouse());

		List<Warehouse> warehouses = new LinkedList<>(warehouseSet);
		updateWarehouses(warehouses);
	}
}
