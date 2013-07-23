package devopsdistilled.operp.client.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.items.Product;

public class ItemPane extends SubTaskPane implements ItemModelObserver {

	private final ItemModel model;

	private final ItemPaneController controller;

	private JPanel pane;
	private JTextField textField;
	private JTextField textField_3;
	private JComboBox<Brand> comboBrands;
	private JComboBox<Product> comboProducts;

	public ItemPane(ItemPaneController itemPaneController, ItemModel itemModel) {

		this.model = itemModel;
		model.registerObserver(this);
		this.controller = itemPaneController;
	}

	@Override
	public void init() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][][grow][]", "[][][][][]"));

		JLabel lblProductName = new JLabel("Product Name");
		pane.add(lblProductName, "cell 0 0,alignx trailing");

		comboProducts = new JComboBox<Product>();
		pane.add(comboProducts, "flowx,cell 2 0,growx");

		JLabel lblBrandName = new JLabel("Brand Name");
		pane.add(lblBrandName, "cell 0 1,alignx trailing");

		comboBrands = new JComboBox<Brand>();

		pane.add(comboBrands, "flowx,cell 2 1,growx");

		JLabel lblItemId = new JLabel("Item Name");
		pane.add(lblItemId, "cell 0 2,alignx trailing");

		textField = new JTextField();

		pane.add(textField, "cell 2 2,growx");
		textField.setColumns(10);

		JLabel lblPrice = new JLabel("Price");
		pane.add(lblPrice, "cell 0 3,alignx trailing");

		textField_3 = new JTextField();
		pane.add(textField_3, "cell 2 3,growx");
		textField_3.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().setVisible(false);
			}
		});
		pane.add(btnCancel, "flowx,cell 2 4");
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Item item = new Item();
				Brand brand = (Brand) comboBrands.getSelectedItem();
				Product product = (Product) comboProducts.getSelectedItem();
				item.setBrand(brand);
				item.setProduct(product);

				if (controller.validate(item)) {
					controller.save(item);
				}
			}
		});
		pane.add(btnSave, "cell 2 4");

		JButton btnNewProduct = new JButton("New Product");
		pane.add(btnNewProduct, "cell 2 0");

		JButton btnNewBrand = new JButton("New Brand");
		btnNewBrand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		pane.add(btnNewBrand, "cell 2 1");

		controller.loadData();
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProducts() {
		List<Product> products = model.getProducts();
		for (Product product : products) {
			comboProducts.addItem(product);
		}
		comboProducts.setSelectedItem(null);
	}

	@Override
	public void updateBrands() {
		List<Brand> brands = model.getBrands();
		for (Brand brand : brands) {
			comboBrands.addItem(brand);
		}
		comboBrands.setSelectedItem(null);
	}

}
