package devopsdistilled.operp.client.items.panes.details;

import java.util.Vector;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.client.items.controllers.ProductController;
import devopsdistilled.operp.server.data.entity.items.Category;
import devopsdistilled.operp.server.data.entity.items.Product;

public class ProductDetailsPane extends
		AbstractEntityDetailsPane<Product, ProductController> {

	@Inject
	private ProductController productController;

	private Product product;

	private final JPanel pane;
	private final JTextField productIdField;
	private final JTextField productNameField;
	private final JList<Category> productCategoryList;

	public ProductDetailsPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));

		JLabel lblProductId = new JLabel("Product ID");
		pane.add(lblProductId, "cell 0 0,alignx trailing");

		productIdField = new JTextField();
		productIdField.setEditable(false);
		pane.add(productIdField, "cell 1 0,growx");
		productIdField.setColumns(30);

		JLabel lblProductName = new JLabel("Product Name");
		pane.add(lblProductName, "cell 0 1,alignx trailing");

		productNameField = new JTextField();
		productNameField.setEditable(false);
		pane.add(productNameField, "cell 1 1,growx");
		productNameField.setColumns(30);

		JLabel lblProductCategory = new JLabel("Product Category");
		pane.add(lblProductCategory, "cell 0 2");

		productCategoryList = new JList<>();
		pane.add(productCategoryList, "cell 1 2,grow");

	}

	@Override
	public JPanel getPane() {
		return pane;
	}

	@Override
	public void show(Product product, JComponent owner) {
		this.product = product;
		if (product != null) {
			productIdField.setText(product.getProductId().toString());
			productNameField.setText(product.getProductName());

			productCategoryList.setListData(new Vector<Category>(product
					.getCategories()));

			showDetailsPane(getPane(), owner);

		} else {

			getDialog().dispose();
			JOptionPane.showMessageDialog(getPane(), "Got Null Product");
		}
	}

	@Override
	public String getTitle() {
		return "Product Details";
	}

	@Override
	public ProductController getEntityController() {
		return productController;
	}

	@Override
	protected Product getEntity() {
		return product;
	}

}
