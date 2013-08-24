package devopsdistilled.operp.client.account.panes;

import java.awt.Dimension;

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
import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;

public class ReceivedTransactionPane
		extends
		EntityPane<ReceivedTransaction, ReceivedTransactionController, ReceivedTransactionPaneController>
		implements ReceivedTransactionPaneModelObserver {

	@Inject
	private ReceivedTransactionController receivedTransactionController;

	private final JPanel pane;
	private final JTextField balanceField;
	private final JTextField transactionIdField;
	private final JTextField textField;

	public ReceivedTransactionPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));

		JLabel lblTransactionId = new JLabel("Transaction ID");
		pane.add(lblTransactionId, "cell 0 0,alignx trailing");

		transactionIdField = new JTextField();
		transactionIdField.setEditable(false);
		pane.add(transactionIdField, "cell 1 0,growx");
		transactionIdField.setColumns(10);

		JLabel lblFromCustomer = new JLabel("From Customer");
		pane.add(lblFromCustomer, "cell 0 1,alignx trailing");

		JComboBox customerCombo = new JComboBox();
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

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		pane.add(textField, "cell 1 4,alignx right");
		textField.setColumns(10);

		JPanel opBtnPanel = new JPanel();
		pane.add(opBtnPanel, "cell 1 5,grow");
		opBtnPanel.setLayout(new MigLayout("", "[]", "[]"));
	}

	@Override
	public void updateEntity(ReceivedTransaction entity,
			EntityOperation entityOperation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public ReceivedTransactionController getEntityController() {
		return receivedTransactionController;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}
}
