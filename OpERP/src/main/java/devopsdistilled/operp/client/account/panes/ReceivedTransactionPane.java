package devopsdistilled.operp.client.account.panes;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.account.controllers.ReceivedTransactionController;
import devopsdistilled.operp.client.account.panes.controllers.ReceivedTransactionPaneController;
import devopsdistilled.operp.client.account.panes.models.observers.ReceivedTransactionPaneModelObserver;
import devopsdistilled.operp.client.party.models.observers.CustomerModelObserver;
import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;
import devopsdistilled.operp.server.data.entity.party.Customer;

public class ReceivedTransactionPane
		extends
		EntityPane<ReceivedTransaction, ReceivedTransactionController, ReceivedTransactionPaneController>
		implements ReceivedTransactionPaneModelObserver, CustomerModelObserver {

	@Inject
	private ReceivedTransactionController receivedTransactionController;

	private final JPanel pane;
	private final JTextField balanceField;
	private final JTextField transactionIdField;
	private final JComboBox<Customer> customerCombo;
	private final JTextField amountField;
	private final JLabel lblTransactionId;
	private JPanel opBtnPanel;

	public ReceivedTransactionPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));

		lblTransactionId = new JLabel("Transaction ID");
		pane.add(lblTransactionId, "cell 0 0,alignx trailing");

		transactionIdField = new JTextField();
		transactionIdField.setEditable(false);
		pane.add(transactionIdField, "cell 1 0,growx");
		transactionIdField.setColumns(10);

		JLabel lblFromCustomer = new JLabel("From Customer");
		pane.add(lblFromCustomer, "cell 0 1,alignx trailing");

		customerCombo = new JComboBox<>();
		customerCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {

					Customer selCustomer = (Customer) e.getItem();
					getController().getModel().getEntity()
							.setAccount(selCustomer.getAccount());

					balanceField.setText(getController().getModel().getEntity()
							.getAccount().getBalance().toString());
				}
			}
		});
		customerCombo.setMinimumSize(new Dimension(100, 25));
		pane.add(customerCombo, "cell 1 1,growx");

		JLabel lblBalance = new JLabel("Due Balance");
		pane.add(lblBalance, "flowx,cell 1 2");

		balanceField = new JTextField();
		balanceField.setEditable(false);
		pane.add(balanceField, "cell 1 2");
		balanceField.setColumns(10);

		JLabel lblTransactionAmount = new JLabel("Transaction Amount");
		pane.add(lblTransactionAmount, "flowx,cell 1 4");

		amountField = new JTextField();
		amountField.setHorizontalAlignment(SwingConstants.TRAILING);
		pane.add(amountField, "cell 1 4,alignx right");
		amountField.setColumns(10);

		opBtnPanel = new JPanel();
		pane.add(opBtnPanel, "cell 1 5,grow");
		opBtnPanel.setLayout(new MigLayout("", "[]", "[]"));
	}

	@Override
	public void updateEntity(ReceivedTransaction receivedTransaction,
			EntityOperation entityOperation) {

		if (EntityOperation.Create == entityOperation) {
			getController().getModel().setTitle("Receive Payment");
			opBtnPanel = setBtnPanel(createOpPanel, opBtnPanel);

			lblTransactionId.setVisible(false);
			transactionIdField.setVisible(false);

		} else if (EntityOperation.Edit == entityOperation) {

			getController().getModel().setTitle(
					"Edit Payment Received Transaction");
			opBtnPanel = setBtnPanel(editOpPanel, opBtnPanel);

			transactionIdField.setText(receivedTransaction.getTransactionId()
					.toString());
		} else if (EntityOperation.Details == entityOperation) {

			getController().getModel().setTitle("Received Payment Details");
			opBtnPanel = setBtnPanel(detailsOpPanel, opBtnPanel);

			transactionIdField.setText(receivedTransaction.getTransactionId()
					.toString());
			amountField.setEditable(false);
		}

		amountField.setText(receivedTransaction.getAmount().toString());

	}

	@Override
	public void resetComponents() {
		customerCombo.setSelectedItem(null);
		transactionIdField.setVisible(true);
		lblTransactionId.setVisible(true);
		balanceField.setText("0");
		amountField.setText("0");
	}

	@Override
	public ReceivedTransactionController getEntityController() {
		return receivedTransactionController;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateCustomers(List<Customer> customers) {
		Customer prevSelected = (Customer) customerCombo.getSelectedItem();
		customerCombo.removeAllItems();

		for (Customer customer : customers) {
			customerCombo.addItem(customer);
			if (prevSelected != null)
				if (prevSelected.compareTo(customer) == 0)
					customerCombo.setSelectedItem(customer);
		}
	}
}
