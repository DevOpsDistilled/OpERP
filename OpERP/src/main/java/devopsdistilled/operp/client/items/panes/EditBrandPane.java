package devopsdistilled.operp.client.items.panes;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.items.models.observers.ManufacturerModelObserver;
import devopsdistilled.operp.client.items.panes.models.observers.EditBrandPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class EditBrandPane extends SubTaskPane implements
		EditBrandPaneModelObserver, ManufacturerModelObserver {

	private final JPanel pane;

	public EditBrandPane() {
		pane = new JPanel();
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(Brand brand) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateManufacturers(List<Manufacturer> manufacturers) {
		// TODO Auto-generated method stub

	}

}
