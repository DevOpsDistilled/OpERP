package devopsdistilled.operp.client.items.panes.details;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.client.items.controllers.ProductController;
import devopsdistilled.operp.server.data.entity.items.Category;
import devopsdistilled.operp.server.data.entity.items.Product;

public class ProductDetailsPane extends AbstractEntityDetailsPane<Product> {

	@Inject
	private ProductController productController;

	private Product product;

	private final JPanel pane;
	private final JTextField productIdField;
	private final JTextField productNameField;
	private final JList<Category> productCategoryList;

	public ProductDetailsPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][grow][]"));

		JLabel lblProductId = new JLabel("Product ID");
		pane.add(lblProductId, "cell 0 0,alignx trailing");

		productIdField = new JTextField();
		productIdField.setEditable(false);
		pane.add(productIdField, "cell 1 0,growx");
		productIdField.setColumns(10);

		JLabel lblProductName = new JLabel("Product Name");
		pane.add(lblProductName, "cell 0 1,alignx trailing");

		productNameField = new JTextField();
		productNameField.setEditable(false);
		pane.add(productNameField, "cell 1 1,growx");
		productNameField.setColumns(10);

		JLabel lblProductCategory = new JLabel("Product Category");
		pane.add(lblProductCategory, "cell 0 2");

		productCategoryList = new JList();
		pane.add(productCategoryList, "cell 1 2,grow");

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
				productController.delete(product);
			}
		});
		pane.add(btnDelete, "flowx,cell 1 3");

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
				productController.edit(product);
			}
		});
		pane.add(btnEdit, "cell 1 3");

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		btnOk.setSelected(true);
		pane.add(btnOk, "cell 1 3");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void show(Product product) {
		this.product = product;
		if (product != null) {
			productIdField.setText(product.getProductId().toString());
			productNameField.setText(product.getProductName());
			productCategoryList.setListData((Category[]) product
					.getCategories().toArray());

			getDialog().setVisible(true);
		}
	}

	@Override
	public String getTitle() {
		return "Product Details";
	}

}
