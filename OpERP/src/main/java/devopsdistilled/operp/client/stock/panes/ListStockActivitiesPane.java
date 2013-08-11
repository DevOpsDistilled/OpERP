package devopsdistilled.operp.client.stock.panes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.abstracts.libs.BeanTableModel;
import devopsdistilled.operp.client.stock.models.observers.StockModelObserver;
import devopsdistilled.operp.client.stock.panes.details.StockDetailsPane;
import devopsdistilled.operp.client.stock.panes.models.observers.ListStockPaneModelObserver;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;

public class ListStockPane extends SubTaskPane implements
		ListStockPaneModelObserver, StockModelObserver {

	@Inject
	private StockDetailsPane stockDetailsPane;

	private final JPanel pane;
	private final JTable table;
	BeanTableModel<StockKeeper> tableModel;

	public ListStockPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("debug,fill", "[]", "[]"));
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)
						&& e.getClickCount() == 2
						&& table.getSelectedRow() != -1) {
					StockKeeper stockKeeper = tableModel.getRow(table.getSelectedRow());
					stockDetailsPane.show(stockKeeper);
				}
			}
		});

		final JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.add(scrollPane, "grow");

	}

	@Override
	public JPanel getPane() {
		return pane;
	}

	@Override
	public void updateStock(List<StockKeeper> stockKeepers) {
		tableModel = null;
		tableModel = new BeanTableModel<>(StockKeeper.class, stockKeepers);

		for (int i = 0; i < tableModel.getColumnCount(); i++) {
			tableModel.setColumnEditable(i, false);
		}
		tableModel.setModelEditable(false);
		table.setModel(tableModel);
	}

}
