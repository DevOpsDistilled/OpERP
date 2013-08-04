package devopsdistilled.operp.client.items.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;

public class CreateManufacturerPane extends SubTaskPane {

	private final JPanel pane;

	public CreateManufacturerPane() {
		pane = new JPanel();
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
