package devopsdistilled.operp.client.stock.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.stock.panes.models.observers.ListStockPaneModelObserver;

public class ListStockPane extends SubTaskPane implements
		ListStockPaneModelObserver {

	private final JPanel pane;

	public ListStockPane() {
		pane = new JPanel();
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
