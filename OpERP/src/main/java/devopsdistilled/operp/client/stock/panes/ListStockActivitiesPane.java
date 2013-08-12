package devopsdistilled.operp.client.stock.panes;

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
import devopsdistilled.operp.client.stock.models.observers.StockKeeperModelObserver;
import devopsdistilled.operp.client.stock.panes.details.StockKeepingDetailsPane;
import devopsdistilled.operp.client.stock.panes.models.observers.ListStockActivitiesPaneModelObserver;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;

public class ListStockActivitiesPane extends SubTaskPane implements
		ListStockActivitiesPaneModelObserver, StockKeeperModelObserver {

	@Inject
	private StockKeepingDetailsPane stockKeepingDetailsPane;

	private final JPanel pane;
	private final JTable table;
	BeanTableModel<StockKeeper> tableModel;

	public ListStockActivitiesPane() {
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
					StockKeeper stockKeeper = tableModel.getRow(table
							.getSelectedRow());
					stockKeepingDetailsPane.show(stockKeeper);

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
	public void updateStockActivities(List<StockKeeper> stockActivities) {
		tableModel = null;
		tableModel = new BeanTableModel<>(StockKeeper.class, stockActivities);

		for (int i = 0; i < table.getColumnCount(); i++) {
			tableModel.setColumnEditable(i, false);
		}
		tableModel.setModelEditable(false);
		table.setModel(tableModel);
	}
}
