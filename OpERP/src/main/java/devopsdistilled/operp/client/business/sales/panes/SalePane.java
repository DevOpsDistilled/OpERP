package devopsdistilled.operp.client.business.sales.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.business.sales.controllers.SaleController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SalePaneController;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SalePaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.Sale;

public class SalePane extends
		EntityPane<Sale, SaleController, SalePaneController> implements
		SalePaneModelObserver {

	@Inject
	private SaleController saleController;

	private final JPanel pane;
	private final JTextField saleIdField;
	private final JTextField priceField;
	private final JTextField quantityField;
	private final JTable saleDescTable;
	private final JTextField discountField;
	private final JTextField totalField;

	public SalePane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[117.00][grow]",
				"[][][][][][][][][grow]"));

		JLabel lblSaleId = new JLabel("Sale Id");
		pane.add(lblSaleId, "cell 0 0,alignx trailing");

		saleIdField = new JTextField();
		saleIdField.setEditable(false);
		pane.add(saleIdField, "cell 1 0,growx");
		saleIdField.setColumns(10);

		JLabel lblCustomer = new JLabel("Customer");
		pane.add(lblCustomer, "cell 0 1,alignx trailing");

		JComboBox comboBox = new JComboBox();
		pane.add(comboBox, "flowx,cell 1 1,growx");

		JButton btnNewCustomer = new JButton("New Customer");
		btnNewCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		pane.add(btnNewCustomer, "cell 1 1");

		JLabel lblItem = new JLabel("Item");
		pane.add(lblItem, "flowx,cell 0 3");

		JComboBox itemCombo = new JComboBox();
		pane.add(itemCombo, "cell 0 3");

		saleDescTable = new JTable();
		pane.add(saleDescTable, "cell 1 3,grow");

		JLabel lblPrice = new JLabel("Price");
		pane.add(lblPrice, "flowx,cell 0 4");

		priceField = new JTextField();
		pane.add(priceField, "cell 0 4,aligny center");
		priceField.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity");
		pane.add(lblQuantity, "flowx,cell 0 5");

		quantityField = new JTextField();
		pane.add(quantityField, "cell 0 5");
		quantityField.setColumns(10);

		JLabel lblDiscount = new JLabel("Discount");
		pane.add(lblDiscount, "flowx,cell 1 6");

		discountField = new JTextField();
		pane.add(discountField, "cell 1 6");
		discountField.setColumns(10);

		JLabel lblTotal = new JLabel("Total");
		pane.add(lblTotal, "flowx,cell 1 7");

		totalField = new JTextField();
		pane.add(totalField, "cell 1 7");
		totalField.setColumns(10);

		JPanel opBtnPanel = new JPanel();
		pane.add(opBtnPanel, "cell 1 8,grow");
		opBtnPanel.setLayout(new MigLayout("", "[]", "[]"));
	}

	@Override
	public void resetComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public SaleController getEntityController() {
		return saleController;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(Sale sale, EntityOperation entityOperation) {
		// TODO Auto-generated method stub

	}
}
