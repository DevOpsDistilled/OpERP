package devopsdistilled.operp.client.items.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.items.panes.models.observers.CreateBrandPaneModelObserver;

public class CreateBrandPane extends SubTaskPane implements
		CreateBrandPaneModelObserver {

	private final JPanel pane;

	public CreateBrandPane() {
		pane = new JPanel();
		// TODO
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
