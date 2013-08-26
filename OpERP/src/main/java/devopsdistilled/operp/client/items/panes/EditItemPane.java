package devopsdistilled.operp.client.items.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import devopsdistilled.operp.client.items.controllers.BrandController;
import devopsdistilled.operp.client.items.controllers.ProductController;
import devopsdistilled.operp.client.items.models.observers.BrandModelObserver;
import devopsdistilled.operp.client.items.models.observers.ProductModelObserver;
import devopsdistilled.operp.client.items.panes.controllers.EditItemPaneController;
import devopsdistilled.operp.client.items.panes.details.ItemDetailsPane;
import devopsdistilled.operp.client.items.panes.models.observers.EditItemPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.items.Product;

public class EditItemPane extends SubTaskPane implements
		EditItemPaneModelObserver, ProductModelObserver, BrandModelObserver {

	@Inject
	private EditItemPaneController controller;

	@Inject
	private ItemDetailsPane itemDetailsPane;

	@Inject
	private ProductController productController;

	@Inject
	private BrandController brandController;

	private final JPanel pane;
	private final JTextField itemNameField;
	private final JTextField priceField;
	private final JComboBox<Brand> comboBrands;
	private final JComboBox<Product> comboProducts;
	private final JTextField itemIdField;

	private Item item;
	
	public EditItemPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][][][]",
				"[][][][][][]"));

		JLabel lblItemId_1 = new JLabel("Item ID");
		pane.add(lblItemId_1, "cell 0 0,alignx right");

		itemIdField = new JTextField();
		itemIdField.setEditable(false);
		pane.add(itemIdField, "cell 2 0,growx");
		itemIdField.setColumns(10);

		JLabel lblProductName = new JLabel("Product Name");
		pane.add(lblProductName, "cell 0 1,alignx trailing");

		comboProducts = new JComboBox<>();
		comboProducts.addItemListener(new  ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
					getDialog().pack();
			}
		});
		comboProducts.setSelectedItem(null);
		pane.add(comboProducts, "flowx,cell 2 1,growx");

		JLabel lblBrandName = new JLabel("Brand Name");
		pane.add(lblBrandName, "cell 0 2,alignx trailing");

		comboBrands = new JComboBox<>();
		comboBrands.addItemListener(new  ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
					getDialog().pack();
			}
		});
		comboBrands.setSelectedItem(null);
		pane.add(comboBrands, "flowx,cell 2 2,growx");

		JLabel lblItemId = new JLabel("Item Name");
		pane.add(lblItemId, "cell 0 3,alignx trailing");

		itemNameField = new JTextField();

		pane.add(itemNameField, "cell 2 3,growx");
		itemNameField.setColumns(10);

		JLabel lblPrice = new JLabel("Price");
		pane.add(lblPrice, "cell 0 4,alignx trailing");

		priceField = new JTextField();
		pane.add(priceField, "cell 2 4,growx");
		priceField.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnCancel, "flowx,cell 2 5");
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Long itemId = item.getItemId();
				Item item = new Item();
				item.setItemId(itemId);
				Brand brand = (Brand) comboBrands.getSelectedItem();
				item.setBrand(brand);
				Product product = (Product) comboProducts.getSelectedItem();
				item.setProduct(product);
				String itemName = itemNameField.getText().trim();
				item.setItemName(itemName);
				String itemPrice = priceField.getText().trim();

				try {

					Double price = Double.parseDouble(itemPrice);
					item.setPrice(price);

					try {
						controller.validate(item);

						// validated

						item = controller.save(item);

						getDialog().dispose();

						itemDetailsPane.show(item, getPane());

					} catch (EntityValidationException e1) {
						JOptionPane.showMessageDialog(getPane(),
								e1.getMessage());
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(getPane(),
							"Price must be a Numeric value");
				}

			}
		});

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateEntity(item);
			}
		});
		pane.add(btnReset, "cell 2 5");
		pane.add(btnUpdate, "cell 2 5");

		JButton btnNewProduct = new JButton("New Product");
		btnNewProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productController.create();
			}
		});
		pane.add(btnNewProduct, "cell 2 1");

		JButton btnNewBrand = new JButton("New Brand");
		btnNewBrand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				brandController.create();
			}
		});
		pane.add(btnNewBrand, "cell 2 2");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateProducts(List<Product> products) {
		Product prevSelected = (Product) comboProducts.getSelectedItem();
		comboProducts.removeAllItems();

		for (Product product : products) {
			comboProducts.addItem(product);
			if (prevSelected != null)
				if (prevSelected.compareTo(product) == 0)
					comboProducts.setSelectedItem(product);
		}
	}

	@Override
	public void updateBrands(List<Brand> brands) {
		Brand prevSelected = (Brand) comboBrands.getSelectedItem();
		comboBrands.removeAllItems();

		for (Brand brand : brands) {
			comboBrands.addItem(brand);
			if (prevSelected != null)
				if (prevSelected.compareTo(brand) == 0)
					comboBrands.setSelectedItem(brand);
		}
		getDialog().pack();
	}

	@Override
	public void updateEntity(Item item) {
		this.item = item;
		itemIdField.setText(item.getItemId().toString());
		itemNameField.setText(item.getItemName());
		priceField.setText(item.getPrice().toString());
		comboProducts.setSelectedItem(item.getProduct());
		comboBrands.setSelectedItem(item.getBrand());
	}
}
