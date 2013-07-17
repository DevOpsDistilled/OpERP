package devopsdistilled.operp.client.items;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class ItemPane implements ItemModelObserver {

	private final ItemModel model;
	private final ItemPaneController controller;

	private final JPanel pane;
	private JComponent owner;
	private final JTextField textField;
	private final JTextField textField_3;

	public ItemPane(ItemModel itemModel, ItemPaneController itemPaneController) {

		this.model = itemModel;
		this.controller = itemPaneController;

		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][][grow]", "[][][][][]"));

		JLabel lblItemId = new JLabel("Item ID");
		pane.add(lblItemId, "cell 0 0,alignx trailing");

		textField = new JTextField();
		pane.add(textField, "cell 2 0,growx");
		textField.setColumns(10);

		JLabel lblProductName = new JLabel("Product Name");
		pane.add(lblProductName, "cell 0 1,alignx trailing");

		JComboBox comboBox = new JComboBox();
		pane.add(comboBox, "cell 2 1,growx");

		JLabel lblBrandName = new JLabel("Brand Name");
		pane.add(lblBrandName, "cell 0 2,alignx trailing");

		JComboBox comboBox_1 = new JComboBox();
		pane.add(comboBox_1, "cell 2 2,growx");

		JLabel lblPrice = new JLabel("Price");
		pane.add(lblPrice, "cell 0 3,alignx trailing");

		textField_3 = new JTextField();
		pane.add(textField_3, "cell 2 3,growx");
		textField_3.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		pane.add(btnCancel, "flowx,cell 2 4");

		JButton btnReset = new JButton("Reset");
		pane.add(btnReset, "cell 2 4");

		JButton btnSave = new JButton("Save");
		pane.add(btnSave, "cell 2 4");
	}

	public JComponent getPane() {
		return pane;
	}

	public JDialog getDialog() {
		JDialog dialog = new JDialog();
		dialog.add(getPane());
		dialog.setSize(640, 800);
		dialog.setVisible(true);
		return dialog;
	}

	@Override
	public void updateAll() {
		// TODO Auto-generated method stub

	}
}
