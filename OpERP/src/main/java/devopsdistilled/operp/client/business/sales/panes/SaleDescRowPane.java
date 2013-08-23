package devopsdistilled.operp.client.business.sales.panes;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.business.sales.controllers.SaleDescRowController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescRowPaneController;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SaleDescRowPaneModelObserver;
import devopsdistilled.operp.client.items.models.observers.ItemModelObserver;
import devopsdistilled.operp.server.data.entity.business.SaleDescRow;
import devopsdistilled.operp.server.data.entity.items.Item;

public class SaleDescRowPane
		extends
		EntityPane<SaleDescRow, SaleDescRowController, SaleDescRowPaneController>
		implements SaleDescRowPaneModelObserver, ItemModelObserver {

	private final JPanel pane;
	private final JTextField priceField;
	private final JTextField quantityField;
	private final JTextField amountField;
	private final JComboBox<Item> itemCombo;

	public SaleDescRowPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));

		JLabel lblItem = new JLabel("Item");
		pane.add(lblItem, "cell 0 0,alignx trailing");

		itemCombo = new JComboBox<>();
		pane.add(itemCombo, "cell 1 0,growx");

		JLabel lblPrice = new JLabel("Price");
		pane.add(lblPrice, "cell 0 1,alignx trailing");

		priceField = new JTextField();
		pane.add(priceField, "cell 1 1,growx");
		priceField.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity");
		pane.add(lblQuantity, "cell 0 2,alignx trailing");

		quantityField = new JTextField();
		pane.add(quantityField, "cell 1 2,growx");
		quantityField.setColumns(10);

		JLabel lblAmount = new JLabel("Amount");
		pane.add(lblAmount, "cell 0 3,alignx trailing");

		amountField = new JTextField();
		amountField.setEditable(false);
		pane.add(amountField, "cell 1 3,growx");
		amountField.setColumns(10);

		JButton btnReset = new JButton("Reset");
		pane.add(btnReset, "flowx,cell 1 4");

		JButton btnOk = new JButton("OK");
		pane.add(btnOk, "cell 1 4");
	}

	@Override
	public void resetComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public SaleDescRowController getEntityController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(SaleDescRow entity, EntityOperation entityOperation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateItems(List<Item> items) {
		Item prevSelected = (Item) itemCombo.getSelectedItem();
		itemCombo.removeAllItems();

		for (Item item : items) {
			itemCombo.addItem(item);
			if (prevSelected != null)
				if (prevSelected.compareTo(item) == 0)
					itemCombo.setSelectedItem(item);
		}
	}

}
