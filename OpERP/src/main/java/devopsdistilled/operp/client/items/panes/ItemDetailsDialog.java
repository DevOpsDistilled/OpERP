package devopsdistilled.operp.client.items.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsDialog;
import devopsdistilled.operp.client.items.controllers.ItemController;
import devopsdistilled.operp.server.data.entity.items.Item;

public class ItemDetailsDialog extends AbstractEntityDetailsDialog<Item> {

	@Inject
	private ItemController itemController;

	private final JPanel pane;

	private Item item;

	private final JTextField itemIdField;
	private final JTextField itemNameField;
	private final JTextField brandField;
	private final JTextField priceField;
	private final JTextField productField;
	private final JButton btnDelete;
	private final JButton btnEdit;
	private final JButton btnOk;

	public ItemDetailsDialog() {
		dialog.setTitle("Item Details");
		dialog.setSize(400, 200);

		pane = new JPanel();

		pane.setLayout(new MigLayout("debug", "[][grow]", "[][][][][][][]"));

		JLabel lblItemId = new JLabel("Item ID:");
		pane.add(lblItemId, "cell 0 0,alignx trailing");

		itemIdField = new JTextField();
		itemIdField.setEditable(false);
		pane.add(itemIdField, "cell 1 0,growx");
		itemIdField.setColumns(10);

		JLabel lblItemName = new JLabel("Item Name:");
		pane.add(lblItemName, "cell 0 1,alignx trailing");

		itemNameField = new JTextField();
		itemNameField.setEditable(false);
		pane.add(itemNameField, "cell 1 1,growx");
		itemNameField.setColumns(10);

		JLabel lblProduct = new JLabel("Product:");
		pane.add(lblProduct, "cell 0 2,alignx trailing");

		productField = new JTextField();
		productField.setEditable(false);
		pane.add(productField, "cell 1 2,growx");
		productField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Brand:");
		pane.add(lblNewLabel, "cell 0 3,alignx trailing,aligny baseline");

		brandField = new JTextField();
		brandField.setEditable(false);
		pane.add(brandField, "cell 1 3,growx");
		brandField.setColumns(10);

		JLabel lblPrice = new JLabel("Price:");
		pane.add(lblPrice, "cell 0 4,alignx trailing");

		priceField = new JTextField();
		priceField.setEditable(false);
		pane.add(priceField, "cell 1 4,growx");
		priceField.setColumns(10);

		dialog.getContentPane().add(pane);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
				itemController.deleteItem(item);
			}
		});
		pane.add(btnDelete, "flowx,cell 1 6");

		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
				itemController.editItem(item);
			}
		});
		pane.add(btnEdit, "cell 1 6");

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnOk, "cell 1 6");

	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void show(Item item) {

		this.item = item;

		if (item != null) {
			itemIdField.setText(item.getItemId().toString());
			itemNameField.setText(item.getItemName());
			productField.setText(item.getProduct().getProductName());
			brandField.setText(item.getBrand().getBrandName());
			priceField.setText(item.getPrice().toString());

			getDialog().setVisible(true);

		} else {
			dialog.dispose();
			JOptionPane.showMessageDialog(getPane(), "null object produced");
		}

	}
}
