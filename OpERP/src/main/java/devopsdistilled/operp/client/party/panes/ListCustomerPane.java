package devopsdistilled.operp.client.party.panes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.abstracts.libs.BeanTableModel;
import devopsdistilled.operp.client.party.controllers.CustomerController;
import devopsdistilled.operp.client.party.models.observers.CustomerModelObserver;
import devopsdistilled.operp.client.party.panes.models.observers.ListCustomerPaneModelObserver;
import devopsdistilled.operp.server.data.entity.party.Customer;
import devopsdistilled.operp.server.data.entity.party.Party;

public class ListCustomerPane extends SubTaskPane implements
		ListCustomerPaneModelObserver, CustomerModelObserver {

	@Inject
	private CustomerController customerController;

	private final JPanel pane;
	private final JTable table;
	BeanTableModel<Customer> tableModel;

	public ListCustomerPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("fill"));
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)
						&& e.getClickCount() == 2
						&& table.getSelectedRow() != -1) {
					Customer customer = tableModel.getRow(table
							.getSelectedRow());

					customerController.showDetails(customer);

				}
			}
		});

		final JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.add(scrollPane, "grow");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateCustomers(List<Customer> customers) {

		tableModel = null;
		tableModel = new BeanTableModel<>(Customer.class, Party.class,
				customers);

		for (int i = 0; i < table.getColumnCount(); i++) {
			tableModel.setColumnEditable(i, false);
		}
		tableModel.setModelEditable(false);
		table.setModel(tableModel);
	}
}