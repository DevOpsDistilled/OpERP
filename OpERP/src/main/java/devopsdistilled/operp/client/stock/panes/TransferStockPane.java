package devopsdistilled.operp.client.stock.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.stock.panes.models.observers.TransferStockPaneModelObserver;

public class TransferStockPane extends SubTaskPane implements
		TransferStockPaneModelObserver {

	private final JPanel pane;

	public TransferStockPane() {
		pane = new JPanel();
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
