package devopsdistilled.operp.client.business.purchases.panes;

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
import devopsdistilled.operp.client.business.purchases.controllers.PurchaseController;
import devopsdistilled.operp.client.business.purchases.models.observers.PurchaseModelObserver;
import devopsdistilled.operp.client.business.purchases.panes.models.observers.ListPurchasePaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.Business;
import devopsdistilled.operp.server.data.entity.business.Purchase;

public class ListPurchasePane extends SubTaskPane implements
		ListPurchasePaneModelObserver, PurchaseModelObserver {

	@Inject
	private PurchaseController purchaseController;

	private final JPanel pane;
	private final JTable table;
	BeanTableModel<Purchase> tableModel;

	public ListPurchasePane() {
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
					Purchase purchase = tableModel.getRow(table
							.getSelectedRow());

					purchaseController.showDetails(purchase);

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
	public void updatePurchases(List<Purchase> purchases) {
		tableModel = null;
		tableModel = new BeanTableModel<>(Purchase.class, Business.class,
				purchases);

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
			if (columnName.equalsIgnoreCase("Business Desc")) {
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
