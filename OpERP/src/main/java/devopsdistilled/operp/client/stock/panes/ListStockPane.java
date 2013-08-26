package devopsdistilled.operp.client.stock.panes;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.abstracts.libs.BeanTableModel;
import devopsdistilled.operp.client.stock.models.observers.StockModelObserver;
import devopsdistilled.operp.client.stock.panes.models.observers.ListStockPaneModelObserver;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public class ListStockPane extends SubTaskPane implements
		ListStockPaneModelObserver, StockModelObserver {

	private final JPanel pane;

	private final JTable table;
	BeanTableModel<Stock> tableModel;
	
	public ListStockPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("fill"));
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
	public void updateStock(List<Stock> stocks) {
		tableModel = null;
		tableModel = new BeanTableModel<>(Stock.class, stocks);

		for (int i = 0; i < table.getColumnCount(); i++) {
			tableModel.setColumnEditable(i, false);
		}
		tableModel.setModelEditable(false);
		table.setModel(tableModel);

	}
}
