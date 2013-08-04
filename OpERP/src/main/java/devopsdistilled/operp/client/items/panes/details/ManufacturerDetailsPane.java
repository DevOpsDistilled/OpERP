package devopsdistilled.operp.client.items.panes.details;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class ManufacturerDetailsPane extends
		AbstractEntityDetailsPane<Manufacturer> {

	private final JPanel pane;

	public ManufacturerDetailsPane() {
		pane = new JPanel();
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void show(Manufacturer entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTitle() {
		return "Manufacturer Details";
	}

}
