package devopsdistilled.operp.client.items.views;

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
import devopsdistilled.operp.client.items.controllers.CreateItemPaneController;
import devopsdistilled.operp.client.items.models.observers.ItemModelObserver;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.items.Product;

public class CreateItemPane extends SubTaskPane implements ItemModelObserver {

	@Inject
	private CreateItemPaneController controller;

	private final JPanel pane;
	private final JTextField itemNameField;
	private final JTextField priceField;
	private final JComboBox<Brand> comboBrands;
	private final JComboBox<Product> comboProducts;
	private final JComboBox<Item> comboItems;
	private final JTextField itemIdField;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void init() {
		super.init();
	}

	public CreateItemPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][][grow][]", "[][][][][][]"));

		JLabel lblItemId_1 = new JLabel("Item Id");
		pane.add(lblItemId_1, "cell 0 0,alignx trailing");

		itemIdField = new JTextField();
		pane.add(itemIdField, "cell 2 0,growx");
		itemIdField.setColumns(10);

		JLabel lblItemId = new JLabel("Item Name");
		pane.add(lblItemId, "cell 0 1,alignx trailing");

		itemNameField = new JTextField();

		pane.add(itemNameField, "cell 2 1,growx");
		itemNameField.setColumns(10);

		JLabel lblProductName = new JLabel("Product Name");
		pane.add(lblProductName, "cell 0 2,alignx trailing");

		comboProducts = new JComboBox<Product>();
		pane.add(comboProducts, "flowx,cell 2 2,growx");

		JLabel lblBrandName = new JLabel("Brand Name");
		pane.add(lblBrandName, "cell 0 3,alignx trailing");

		comboBrands = new JComboBox<Brand>();
		comboItems = new JComboBox<Item>();
		pane.add(comboItems, "flowx,cell 2 3,growx");

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
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Item item = new Item();
				Brand brand = (Brand) comboBrands.getSelectedItem();
				Product product = (Product) comboProducts.getSelectedItem();
				item.setBrand(brand);
				item.setProduct(product);

			}
		});
		pane.add(btnSave, "cell 2 5");

		JButton btnNewProduct = new JButton("New Product");
		pane.add(btnNewProduct, "cell 2 2");

		JButton btnNewBrand = new JButton("New Brand");
		btnNewBrand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		pane.add(btnNewBrand, "cell 2 3");

	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void update(List<Item> entities) {
		for (Item item : entities) {
			comboItems.addItem(item);
		}
	}

}
