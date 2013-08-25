package devopsdistilled.operp.client.business.purchases.panes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.abstracts.libs.BeanTableModel;
import devopsdistilled.operp.client.business.purchases.controllers.PurchaseDescController;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchaseDescPaneController;
import devopsdistilled.operp.client.business.purchases.panes.models.observers.PurchaseDescPaneModelObserver;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.business.BusinessDescRow;
import devopsdistilled.operp.server.data.entity.business.PurchaseDesc;
import devopsdistilled.operp.server.data.entity.business.PurchaseDescRow;

public class PurchaseDescPane extends
		EntityPane<PurchaseDesc, PurchaseDescController, PurchaseDescPaneController>
		implements PurchaseDescPaneModelObserver {

	private final JPanel pane;
	private final JTextField discountField;
	private final JTextField amountField;

	private final JTable table;
	BeanTableModel<PurchaseDescRow> tableModel;
	private JPanel rowDescPanel;
	private final JButton btnAdd;

	public PurchaseDescPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("flowy", "[][grow]", "[][][][]"));

		rowDescPanel = new JPanel();
		pane.add(rowDescPanel, "cell 0 0,grow");

		rowDescPanel.setLayout(new MigLayout("", "[]", "[]"));

		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)
						&& e.getClickCount() == 2
						&& table.getSelectedRow() != -1) {

					PurchaseDescRow purchaseDescRow = tableModel.getRow(table
							.getSelectedRow());

					getController().initEditPurchaseDescRow(purchaseDescRow);

					// XXX
				}
			}
		});

		final JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.add(scrollPane, "cell 1 0 1 2,grow");

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					getController().validate();

					getController().addNewPurchaseDescRow();

					amountField.setText(getController().getModel().getEntity()
							.getBusiness().getAmount().toString());

				} catch (EntityValidationException e1) {
					JOptionPane.showMessageDialog(getPane(), e1.getMessage());
				}
			}
		});
		pane.add(btnAdd, "cell 0 1,alignx right,aligny top");

		JLabel lblDiscount = new JLabel("Discount");
		pane.add(lblDiscount, "flowx,cell 1 2,alignx right");

		JLabel lblAmount = new JLabel("Amount");
		pane.add(lblAmount, "flowx,cell 1 3,alignx right");

		discountField = new JTextField();
		discountField.setHorizontalAlignment(SwingConstants.TRAILING);
		discountField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				try {
					Double discountAmount = Double.parseDouble(discountField
							.getText().trim());
					getController().getModel().getEntity()
							.setDiscountAmount(discountAmount);

					amountField.setText(getController().getModel().getEntity()
							.getBusiness().getAmount().toString());

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(getPane(),
							"Discount Field must be numeric");
				}
			}
		});
		discountField.setText("0");
		pane.add(discountField, "cell 1 2,alignx right");
		discountField.setColumns(10);

		amountField = new JTextField();
		amountField.setHorizontalAlignment(SwingConstants.TRAILING);
		amountField.setText("0");
		amountField.setEditable(false);
		pane.add(amountField, "cell 1 3,alignx right");
		amountField.setColumns(10);
	}

	@Override
	public void resetComponents() {
		btnAdd.setText("Add");
		table.setForeground(null);
		table.setBackground(null);
	}

	@Override
	public PurchaseDescController getEntityController() {
		return null;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(PurchaseDesc purchaseDesc, EntityOperation entityOperation) {
		tableModel = null;
		tableModel = new BeanTableModel<>(PurchaseDescRow.class,
				BusinessDescRow.class, purchaseDesc.getDescRows());

		for (int i = 0; i < table.getColumnCount(); i++) {
			tableModel.setColumnEditable(i, false);
		}
		tableModel.setModelEditable(false);
		table.setModel(tableModel);

		if (EntityOperation.Edit == entityOperation) {

			btnAdd.setText("Update");

			table.setForeground(Color.BLACK);
			table.setBackground(Color.BLUE);

		} else {
			resetComponents();
		}
	}

	public void setPurchaseDescRowpanel(JPanel rowDescPanel) {
		MigLayout layout = (MigLayout) pane.getLayout();
		Object constraints = layout.getComponentConstraints(this.rowDescPanel);

		pane.remove(this.rowDescPanel);
		pane.add(rowDescPanel, constraints);
		this.rowDescPanel = rowDescPanel;
		pane.validate();
	}
}
