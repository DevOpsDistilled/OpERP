package devopsdistilled.operp.client.items.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.items.panes.models.observers.EditProductPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Product;

public class EditProductPane extends SubTaskPane implements
		EditProductPaneModelObserver {

	private final JPanel pane;

	public EditProductPane() {
		pane = new JPanel();
	}

	@Override
	public void updateEntity(Product entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
