package devopsdistilled.operp.client.party.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.party.panes.models.observers.ListVendorPaneModelObserver;

public class ListVendorPane extends SubTaskPane implements
		ListVendorPaneModelObserver {

	private final JPanel pane;

	public ListVendorPane() {
		pane = new JPanel();
		// XXX
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
