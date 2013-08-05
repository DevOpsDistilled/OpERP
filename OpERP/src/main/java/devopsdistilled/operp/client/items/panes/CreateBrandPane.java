package devopsdistilled.operp.client.items.panes;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.items.models.observers.ManufacturerModelObserver;
import devopsdistilled.operp.client.items.panes.models.observers.CreateBrandPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class CreateBrandPane extends SubTaskPane implements
		CreateBrandPaneModelObserver, ManufacturerModelObserver {

	private final JPanel pane;

	public CreateBrandPane() {
		pane = new JPanel();
		// TODO
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateManufacturers(List<Manufacturer> manufacturers) {
		// TODO Auto-generated method stub

	}

}
