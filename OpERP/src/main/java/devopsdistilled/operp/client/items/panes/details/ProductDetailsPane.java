package devopsdistilled.operp.client.items.panes.details;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.server.data.entity.items.Product;

public class ProductDetailsPane extends AbstractEntityDetailsPane<Product> {

	private JPanel pane;

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void show(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTitle() {
		return "Product Details";
	}

}
