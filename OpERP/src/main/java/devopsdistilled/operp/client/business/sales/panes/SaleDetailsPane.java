package devopsdistilled.operp.client.business.sales.panes;

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
import devopsdistilled.operp.client.account.panes.controllers.ReceivedTransactionPaneController;
import devopsdistilled.operp.client.business.sales.controllers.SaleController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDetailsPaneController;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SaleDetailsPaneModelObserver;
import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;
import devopsdistilled.operp.server.data.entity.business.BusinessDescRow;
import devopsdistilled.operp.server.data.entity.business.Sale;
import devopsdistilled.operp.server.data.entity.business.SaleDescRow;

public class SaleDetailsPane extends
		EntityPane<Sale, SaleController, SaleDetailsPaneController> implements
		SaleDetailsPaneModelObserver {

	@Inject
	private ReceivedTransactionPaneController receivedTransactionPaneController;

	private final JPanel pane;
	private final JTextField saleIdField;
	private final JTextField customerField;
	private final JTextField dateField;
	private final JTextField discountField;
	private final JLabel lblTotal;
	private final JTextField totalField;
	private final JButton btnOk;
	private final JButton btnReceivePayment;

	private final JTable table;
	BeanTableModel<SaleDescRow> tableModel;

	public SaleDetailsPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow][grow]", "[][grow][][][][]"));

		JLabel lblSaleId = new JLabel("Sale ID");
		pane.add(lblSaleId, "flowx,cell 0 0,alignx trailing");

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

		saleIdField = new JTextField();
		saleIdField.setEditable(false);
		pane.add(saleIdField, "cell 0 0,growx");
		saleIdField.setColumns(10);

		table = new JTable(tableModel);
		final JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.add(scrollPane, "cell 0 1 3 1,grow");

		btnReceivePayment = new JButton("Receive Payment");
		btnReceivePayment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ReceivedTransaction transaction = new ReceivedTransaction();
				transaction.setAccount(getController().getModel().getEntity()
						.getParty().getAccount());
				transaction.setNote("Sale #"
						+ getController().getModel().getEntity()
								.getBusinessId());
				transaction.setAmount(getController().getModel().getEntity()
						.getAmount());
				receivedTransactionPaneController.init(transaction,
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
	public SaleController getEntityController() {
		return null;
	}

	@Override
	public void updateEntity(Sale sale, EntityOperation entityOperation) {
		saleIdField.setText(sale.getBusinessId().toString());
		customerField.setText(sale.getParty().toString());
		dateField.setText(sale.getDate().toString());
		discountField.setText(sale.getBusinessDesc().getDiscountAmount()
				.toString());
		totalField.setText(sale.getAmount().toString());

		tableModel = null;
		tableModel = new BeanTableModel<>(SaleDescRow.class,
				BusinessDescRow.class, sale.getBusinessDesc().getDescRows());

		for (int i = 0; i < table.getColumnCount(); i++) {
			tableModel.setColumnEditable(i, false);
		}
		tableModel.setModelEditable(false);
		table.setModel(tableModel);
	}
}
