package devopsdistilled.operp.client.stock.panes;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.stock.models.observers.StockModelObserver;
import devopsdistilled.operp.client.stock.panes.models.observers.ListStockPaneModelObserver;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public class ListStockPane extends SubTaskPane implements
		ListStockPaneModelObserver, StockModelObserver {

	private final JPanel pane;

	public ListStockPane() {
		pane = new JPanel();
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateStock(List<Stock> stocks) {
		// TODO Auto-generated method stub

	}

}
