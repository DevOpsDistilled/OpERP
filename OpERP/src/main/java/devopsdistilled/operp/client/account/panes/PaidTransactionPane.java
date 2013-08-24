package devopsdistilled.operp.client.account.panes;

import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.account.controllers.PaidTransactionController;
import devopsdistilled.operp.client.account.panes.controllers.PaidTransactionPaneController;
import devopsdistilled.operp.client.account.panes.models.observers.PaidTransactionPaneModelObserver;
import devopsdistilled.operp.client.party.models.observers.VendorModelObserver;
import devopsdistilled.operp.server.data.entity.account.PaidTransaction;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public class PaidTransactionPane
		extends
		EntityPane<PaidTransaction, PaidTransactionController, PaidTransactionPaneController>
		implements PaidTransactionPaneModelObserver, VendorModelObserver {

	@Inject
	private PaidTransactionController paidTransactionController;

	private final JPanel pane;
	private final JTextField balanceField;
	private final JTextField transactionIdField;
	private final JComboBox<Vendor> vendorCombo;
	private final JTextField amountField;
	private final JLabel lblTransactionId;
	private JPanel opBtnPanel;
	private final JLabel lblNote;
	private final JTextField noteField;

	public PaidTransactionPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][]"));

		lblTransactionId = new JLabel("Transaction ID");
		pane.add(lblTransactionId, "cell 0 0,alignx trailing");

		transactionIdField = new JTextField();
		transactionIdField.setEditable(false);
		pane.add(transactionIdField, "cell 1 0,growx");
		transactionIdField.setColumns(10);

		JLabel lblToVendor = new JLabel("To Vendor");
		pane.add(lblToVendor, "cell 0 1,alignx trailing");

		vendorCombo = new JComboBox<>();
		vendorCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {

					Vendor selVendor = (Vendor) e.getItem();
					getController().getModel().getEntity()
							.setAccount(selVendor.getAccount());

					balanceField.setText(getController().getModel().getEntity()
							.getAccount().getBalance().toString());
				}
			}
		});
		vendorCombo.setMinimumSize(new Dimension(100, 25));
		pane.add(vendorCombo, "cell 1 1,growx");

		JLabel lblBalance = new JLabel("Due Balance");
		pane.add(lblBalance, "flowx,cell 1 2");

		balanceField = new JTextField();
		balanceField.setEditable(false);
		pane.add(balanceField, "cell 1 2");
		balanceField.setColumns(10);

		JLabel lblTransactionAmount = new JLabel("Transaction Amount");
		pane.add(lblTransactionAmount, "flowx,cell 1 4");

		amountField = new JTextField();
		amountField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Double amount = Double.parseDouble(amountField.getText()
							.trim());
					getController().getModel().getEntity().setAmount(amount);

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(getPane(),
							"Amount Field must be a numeric value");
				}
			}
		});
		amountField.setHorizontalAlignment(SwingConstants.TRAILING);
		pane.add(amountField, "cell 1 4,alignx right");
		amountField.setColumns(10);

		lblNote = new JLabel("Note");
		pane.add(lblNote, "flowx,cell 1 5");

		noteField = new JTextField();
		noteField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				getController().getModel().getEntity()
						.setNote(noteField.getText().trim());
			}
		});
		pane.add(noteField, "cell 1 5");
		noteField.setColumns(10);

		opBtnPanel = new JPanel();
		pane.add(opBtnPanel, "cell 1 6,grow");
		opBtnPanel.setLayout(new MigLayout("", "[][][][]", "[]"));
	}

	@Override
	public void updateEntity(PaidTransaction paidTransaction,
			EntityOperation entityOperation) {

		if (EntityOperation.Create == entityOperation) {
			getController().getModel().setTitle("Pay Vendor");
			opBtnPanel = setBtnPanel(createOpPanel, opBtnPanel);

			lblTransactionId.setVisible(false);
			transactionIdField.setVisible(false);

		} else if (EntityOperation.Edit == entityOperation) {

			getController().getModel().setTitle("Edit Paid Transaction");
			opBtnPanel = setBtnPanel(editOpPanel, opBtnPanel);

			transactionIdField.setText(paidTransaction.getTransactionId()
					.toString());
		} else if (EntityOperation.Details == entityOperation) {

			getController().getModel().setTitle("Paid Payment Details");
			opBtnPanel = setBtnPanel(detailsOpPanel, opBtnPanel);

			transactionIdField.setText(paidTransaction.getTransactionId()
					.toString());
			amountField.setEditable(false);
			noteField.setEditable(false);
		}

		amountField.setText(paidTransaction.getAmount().toString());
		noteField.setText(paidTransaction.getNote());

	}

	@Override
	public void resetComponents() {
		vendorCombo.setSelectedItem(null);
		transactionIdField.setVisible(true);
		lblTransactionId.setVisible(true);
		amountField.setEditable(true);
		noteField.setEditable(true);
		balanceField.setText("0");
		amountField.setText("0");
	}

	@Override
	public PaidTransactionController getEntityController() {
		return paidTransactionController;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateVendors(List<Vendor> vendors) {
		Vendor prevSelected = (Vendor) vendorCombo.getSelectedItem();
		vendorCombo.removeAllItems();

		for (Vendor vendor : vendors) {
			vendorCombo.addItem(vendor);
			if (prevSelected != null)
				if (prevSelected.compareTo(vendor) == 0)
					vendorCombo.setSelectedItem(vendor);
		}
	}
}
