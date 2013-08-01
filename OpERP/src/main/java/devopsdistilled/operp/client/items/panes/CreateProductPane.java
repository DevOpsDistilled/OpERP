package devopsdistilled.operp.client.items.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.items.panes.models.observers.CreateProductPaneModelObserver;

public class CreateProductPane extends SubTaskPane implements
		CreateProductPaneModelObserver {

	private JPanel pane;

	@Override
	public JComponent getPane() {
		return pane;
	}

}
