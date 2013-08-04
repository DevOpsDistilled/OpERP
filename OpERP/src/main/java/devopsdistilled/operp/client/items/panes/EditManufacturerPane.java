package devopsdistilled.operp.client.items.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.items.panes.models.observers.EditManufacturerPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class EditManufacturerPane extends SubTaskPane implements
		EditManufacturerPaneModelObserver {

	private final JPanel pane;

	public EditManufacturerPane() {
		pane = new JPanel();
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(Manufacturer manufacturer) {
		// TODO Auto-generated method stub

	}

}
