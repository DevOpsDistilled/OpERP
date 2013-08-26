package devopsdistilled.operp.client.items.panes.details;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.client.items.controllers.ItemController;
import devopsdistilled.operp.server.data.entity.items.Item;

public class ItemDetailsPane extends
		AbstractEntityDetailsPane<Item, ItemController> {

	@Inject
	private ItemController itemController;

	private final JPanel pane;

	private Item item;

	private final JTextField itemIdField;
	private final JTextField itemNameField;
	private final JTextField brandField;
	private final JTextField priceField;
	private final JTextField productField;

	public ItemDetailsPane() {
		pane = new JPanel();

		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][]"));

		JLabel lblItemId = new JLabel("Item ID:");
		pane.add(lblItemId, "cell 0 0,alignx trailing");

		itemIdField = new JTextField();
		itemIdField.setEditable(false);
		pane.add(itemIdField, "cell 1 0,growx");
		itemIdField.setColumns(30);

		JLabel lblItemName = new JLabel("Item Name:");
		pane.add(lblItemName, "cell 0 1,alignx trailing");

		itemNameField = new JTextField();
		itemNameField.setEditable(false);
		pane.add(itemNameField, "cell 1 1,growx");
		itemNameField.setColumns(30);

		JLabel lblProduct = new JLabel("Product:");
		pane.add(lblProduct, "cell 0 2,alignx trailing");

		productField = new JTextField();
		productField.setEditable(false);
		pane.add(productField, "cell 1 2,growx");
		productField.setColumns(30);

		JLabel lblNewLabel = new JLabel("Brand:");
		pane.add(lblNewLabel, "cell 0 3,alignx trailing,aligny baseline");

		brandField = new JTextField();
		brandField.setEditable(false);
		pane.add(brandField, "cell 1 3,growx");
		brandField.setColumns(30);

		JLabel lblPrice = new JLabel("Price:");
		pane.add(lblPrice, "cell 0 4,alignx trailing");

		priceField = new JTextField();
		priceField.setEditable(false);
		pane.add(priceField, "cell 1 4,growx");
		priceField.setColumns(30);

	}

	@Override
	public JPanel getPane() {
		return pane;
	}

	@Override
	public void show(Item item, JComponent owner) {

		this.item = item;

		if (item != null) {
			itemIdField.setText(item.getItemId().toString());
			itemNameField.setText(item.getItemName());
			productField.setText(item.getProduct().getProductName());
			brandField.setText(item.getBrand().getBrandName());
			priceField.setText(item.getPrice().toString());

			showDetailsPane(getPane(), owner);
		} else {
			dialog.dispose();
			JOptionPane.showMessageDialog(getPane(), "null object produced");
		}

	}

	@Override
	public String getTitle() {
		return "Item Details";
	}

	@Override
	public ItemController getEntityController() {
		return itemController;
	}

	@Override
	protected Item getEntity() {
		return item;
	}
}
