package devopsdistilled.operp.client.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.TaskPane;
import devopsdistilled.operp.client.items.controllers.CategoryController;
import devopsdistilled.operp.client.items.controllers.ItemController;
import devopsdistilled.operp.client.items.controllers.ManufacturerController;
import devopsdistilled.operp.client.items.controllers.ProductController;

public final class ItemMgmtPane extends TaskPane {

	@Inject
	private ItemController itemController;

	@Inject
	private CategoryController categoryController;

	@Inject
	private ProductController productController;

	@Inject
	private ManufacturerController manufacturerController;

	@Override
	public String toString() {
		return new String("Items");
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][]", "[][][][][][][][]"));

		JLabel lblitemManagement = new JLabel("Item Management");
		pane.add(lblitemManagement, "cell 0 0");

		JButton btnNewItemButton = new JButton("New Item Button");
		btnNewItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemController.createItem();
			}
		});
		pane.add(btnNewItemButton, "cell 0 1");

		JButton btnCreateCategory = new JButton("Create Category");
		btnCreateCategory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				categoryController.create();
			}
		});

		JButton btnListItems = new JButton("List Items");
		btnListItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemController.listItems();
			}
		});
		pane.add(btnListItems, "cell 1 1");
		pane.add(btnCreateCategory, "cell 0 3");

		JButton btnCreateProduct = new JButton("Create Product");
		btnCreateProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productController.create();
			}
		});

		JButton btnListCategories = new JButton("List Categories");
		btnListCategories.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				categoryController.list();
			}
		});
		pane.add(btnListCategories, "cell 1 3");
		pane.add(btnCreateProduct, "cell 0 5");

		JButton btnListProducts = new JButton("List Products");
		btnListProducts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productController.list();
			}
		});
		pane.add(btnListProducts, "cell 1 5");

		JButton btnCreateManufacturer = new JButton("Create Manufacturer");
		btnCreateManufacturer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manufacturerController.create();
			}
		});
		pane.add(btnCreateManufacturer, "cell 0 7");

		JButton btnListManufacturers = new JButton("List Manufacturers");
		btnListManufacturers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manufacturerController.list();
			}
		});
		pane.add(btnListManufacturers, "cell 1 7");

		return pane;
	}
}
