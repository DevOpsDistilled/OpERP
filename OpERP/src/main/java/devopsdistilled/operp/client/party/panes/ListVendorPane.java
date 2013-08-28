package devopsdistilled.operp.client.party.panes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.abstracts.libs.BeanTableModel;
import devopsdistilled.operp.client.party.controllers.VendorController;
import devopsdistilled.operp.client.party.models.observers.VendorModelObserver;
import devopsdistilled.operp.client.party.panes.models.observers.ListVendorPaneModelObserver;
import devopsdistilled.operp.server.data.entity.party.Party;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public class ListVendorPane extends SubTaskPane implements
		ListVendorPaneModelObserver, VendorModelObserver {

	@Inject
	private VendorController vendorController;

	private final JPanel pane;
	private final JTable table;
	BeanTableModel<Vendor> tableModel;

	public ListVendorPane() {
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
					Vendor vendor = tableModel.getRow(table.getSelectedRow());

					vendorController.showDetails(vendor);

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
	public void updateVendors(List<Vendor> vendors) {
		tableModel = null;
		tableModel = new BeanTableModel<>(Vendor.class, Party.class, vendors);

		for (int i = 0; i < table.getColumnCount(); i++) {
			tableModel.setColumnEditable(i, false);
		}
		tableModel.setModelEditable(false);
		table.setModel(tableModel);

		JTableHeader tableHeader = table.getTableHeader();
		Enumeration<TableColumn> columns = tableHeader.getColumnModel()
				.getColumns();
		while (columns.hasMoreElements()) {
			final TableColumn column = columns.nextElement();
			String columnName = (String) column.getHeaderValue();
			if (columnName.equalsIgnoreCase("Contact Info")) {

				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						table.removeColumn(column);
					}
				});
			}

		}
	}

}
