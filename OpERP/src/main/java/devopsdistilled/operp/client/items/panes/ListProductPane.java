package devopsdistilled.operp.client.items.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.items.panes.models.observers.ListProductPaneModelObserver;

public class ListProductPane extends SubTaskPane implements
		ListProductPaneModelObserver {

	private final JPanel pane;

	public ListProductPane() {
		pane = new JPanel();
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
