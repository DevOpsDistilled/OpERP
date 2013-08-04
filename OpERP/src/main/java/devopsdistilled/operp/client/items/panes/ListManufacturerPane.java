package devopsdistilled.operp.client.items.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.items.models.observers.ManufacturerModelObserver;
import devopsdistilled.operp.client.items.panes.models.observers.ListManufacturerPaneModelObserver;

public class ListManufacturerPane extends SubTaskPane implements
		ListManufacturerPaneModelObserver, ManufacturerModelObserver {

	private final JPanel pane;

	public ListManufacturerPane() {
		pane = new JPanel();
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
