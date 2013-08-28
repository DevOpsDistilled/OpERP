package devopsdistilled.operp.client.business.purchases.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.abstracts.libs.BeanTableModel;
import devopsdistilled.operp.client.account.panes.controllers.PaidTransactionPaneController;
import devopsdistilled.operp.client.business.purchases.controllers.PurchaseController;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchaseDetailsPaneController;
import devopsdistilled.operp.client.business.purchases.panes.models.observers.PurchaseDetailsPaneModelObserver;
import devopsdistilled.operp.server.data.entity.account.PaidTransaction;
import devopsdistilled.operp.server.data.entity.business.BusinessDescRow;
import devopsdistilled.operp.server.data.entity.business.Purchase;
import devopsdistilled.operp.server.data.entity.business.PurchaseDescRow;

public class PurchaseDetailsPane extends
		EntityPane<Purchase, PurchaseController, PurchaseDetailsPaneController> implements
		PurchaseDetailsPaneModelObserver {

	@Inject
	private PaidTransactionPaneController paidTransactionPaneController;

	private final JPanel pane;
	private final JTextField purchaseIdField;
	private final JTextField customerField;
	private final JTextField dateField;
	private final JTextField discountField;
	private final JLabel lblTotal;
	private final JTextField totalField;
	private final JButton btnOk;
	private final JButton btnReceivePayment;

	private final JTable table;
	BeanTableModel<PurchaseDescRow> tableModel;

	public PurchaseDetailsPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow][grow]", "[][grow][][][][]"));

		JLabel lblPurchaseId = new JLabel("Purchase ID");
		pane.add(lblPurchaseId, "flowx,cell 0 0,alignx trailing");

		JLabel lblCustomer = new JLabel("Customer");
		pane.add(lblCustomer, "flowx,cell 1 0,alignx center");

		JLabel lblDate = new JLabel("Date");
		pane.add(lblDate, "flowx,cell 2 0,alignx trailing");

		dateField = new JTextField();
		dateField.setEditable(false);
		pane.add(dateField, "cell 2 0");
		dateField.setColumns(20);

		customerField = new JTextField();
		customerField.setEditable(false);
		pane.add(customerField, "cell 1 0,alignx center");
		customerField.setColumns(20);

		purchaseIdField = new JTextField();
		purchaseIdField.setEditable(false);
		pane.add(purchaseIdField, "cell 0 0,growx");
		purchaseIdField.setColumns(10);

		table = new JTable(tableModel);
		final JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.add(scrollPane, "cell 0 1 3 1,grow");

		btnReceivePayment = new JButton("Receive Payment");
		btnReceivePayment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PaidTransaction transaction = new PaidTransaction();
				transaction.setAccount(getController().getModel().getEntity()
						.getParty().getAccount());
				transaction.setNote("Purchase #"
						+ getController().getModel().getEntity()
								.getBusinessId());
				transaction.setAmount(getController().getModel().getEntity()
						.getAmount());
				paidTransactionPaneController.init(transaction,
						EntityOperation.Create);
			}
		});
		pane.add(btnReceivePayment, "cell 0 5");

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		pane.add(btnOk, "cell 2 5,alignx trailing");

		JLabel lblDiscount = new JLabel("Discount");
		pane.add(lblDiscount, "flowx,cell 2 2,alignx trailing");

		discountField = new JTextField();
		discountField.setEditable(false);
		pane.add(discountField, "cell 2 2");
		discountField.setColumns(10);

		lblTotal = new JLabel("Total");
		pane.add(lblTotal, "flowx,cell 2 3,alignx trailing");

		totalField = new JTextField();
		totalField.setEditable(false);
		pane.add(totalField, "cell 2 3");
		totalField.setColumns(10);
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void resetComponents() {
	}

	@Override
	public PurchaseController getEntityController() {
		return null;
	}

	@Override
	public void updateEntity(Purchase purchase, EntityOperation entityOperation) {
		purchaseIdField.setText(purchase.getBusinessId().toString());
		customerField.setText(purchase.getParty().toString());
		dateField.setText(purchase.getDate().toString());
		discountField.setText(purchase.getBusinessDesc().getDiscountAmount()
				.toString());
		totalField.setText(purchase.getAmount().toString());

		tableModel = null;
		tableModel = new BeanTableModel<>(PurchaseDescRow.class,
				BusinessDescRow.class, purchase.getBusinessDesc().getDescRows());

		for (int i = 0; i < table.getColumnCount(); i++) {
			tableModel.setColumnEditable(i, false);
		}
		tableModel.setModelEditable(false);
		table.setModel(tableModel);
	}
}
