package devopsdistilled.operp.client.items.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.server.data.entity.items.Item;

public class ItemDetailDialog {

	private final JDialog dialog;
	private final JTextField itemIdField;
	private final JTextField itemNameField;
	private final JTextField brandField;
	private final JTextField priceField;
	private final JTextField productField;
	private final JButton okButton;

	public ItemDetailDialog(Item item) {
		dialog = new JDialog();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.getContentPane().setLayout(
				new MigLayout("", "[][grow]", "[][][][][][][]"));

		JLabel lblItemId = new JLabel("Item ID:");
		dialog.getContentPane().add(lblItemId, "cell 0 0,alignx trailing");

		itemIdField = new JTextField(item.getItemId().toString());
		itemIdField.setEditable(false);
		dialog.getContentPane().add(itemIdField, "cell 1 0,growx");
		itemIdField.setColumns(10);

		JLabel lblItemName = new JLabel("Item Name:");
		dialog.getContentPane().add(lblItemName, "cell 0 1,alignx trailing");

		itemNameField = new JTextField(item.getItemName().toString());
		itemNameField.setEditable(false);
		dialog.getContentPane().add(itemNameField, "cell 1 1,growx");
		itemNameField.setColumns(10);

		JLabel lblProduct = new JLabel("Product:");
		dialog.getContentPane().add(lblProduct, "cell 0 2,alignx trailing");

		productField = new JTextField(item.getProduct().toString());
		productField.setEditable(false);
		dialog.getContentPane().add(productField, "cell 1 2,growx");
		productField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Brand:");
		dialog.getContentPane().add(lblNewLabel,
				"cell 0 3,alignx trailing,aligny baseline");

		brandField = new JTextField(item.getBrand().toString());
		brandField.setEditable(false);
		dialog.getContentPane().add(brandField, "cell 1 3,growx");
		brandField.setColumns(10);

		JLabel lblPrice = new JLabel("Price:");
		dialog.getContentPane().add(lblPrice, "cell 0 4,alignx trailing");

		priceField = new JTextField(item.getPrice().toString());
		priceField.setEditable(false);
		dialog.getContentPane().add(priceField, "cell 1 4,growx");
		priceField.setColumns(10);

		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		dialog.getContentPane().add(okButton, "cell 1 6,alignx center");

		dialog.setVisible(true);

	}
}
