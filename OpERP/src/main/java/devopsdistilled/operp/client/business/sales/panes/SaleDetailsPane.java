package devopsdistilled.operp.client.business.sales.panes;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.abstracts.libs.BeanTableModel;
import devopsdistilled.operp.server.data.entity.business.SaleDescRow;

public class SaleDetailsPane extends SubTaskPane {

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
		pane.setLayout(new MigLayout("", "[][][]", "[][grow][][][][]"));

		JLabel lblSaleId = new JLabel("Sale ID");
		pane.add(lblSaleId, "flowx,cell 0 0,alignx trailing");

		JLabel lblCustomer = new JLabel("Customer");
		pane.add(lblCustomer, "flowx,cell 1 0");

		JLabel lblDate = new JLabel("Date");
		pane.add(lblDate, "flowx,cell 2 0");

		dateField = new JTextField();
		dateField.setEditable(false);
		pane.add(dateField, "cell 2 0");
		dateField.setColumns(10);

		customerField = new JTextField();
		customerField.setEditable(false);
		pane.add(customerField, "cell 1 0");
		customerField.setColumns(10);

		saleIdField = new JTextField();
		saleIdField.setEditable(false);
		pane.add(saleIdField, "cell 0 0,growx");
		saleIdField.setColumns(10);

		table = new JTable(tableModel);
		final JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.add(scrollPane, "cell 0 1 3 1,grow");

		JLabel lblDiscount = new JLabel("Discount");
		pane.add(lblDiscount, "cell 1 2,alignx trailing");

		discountField = new JTextField();
		pane.add(discountField, "cell 2 2,growx");
		discountField.setColumns(10);

		lblTotal = new JLabel("Total");
		pane.add(lblTotal, "cell 1 3,alignx trailing");

		totalField = new JTextField();
		pane.add(totalField, "cell 2 3,growx");
		totalField.setColumns(10);

		btnReceivePayment = new JButton("Receive Payment");
		pane.add(btnReceivePayment, "cell 0 5");

		btnOk = new JButton("OK");
		pane.add(btnOk, "cell 2 5,alignx trailing");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}
}
