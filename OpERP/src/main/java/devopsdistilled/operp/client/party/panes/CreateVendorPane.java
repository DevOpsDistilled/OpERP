package devopsdistilled.operp.client.party.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.party.panes.models.observers.CreateVendorPaneModelObserver;

public class CreateVendorPane extends SubTaskPane implements
		CreateVendorPaneModelObserver {

	private final JPanel pane;

	public CreateVendorPane() {
		pane = new JPanel();
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
