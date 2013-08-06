package devopsdistilled.operp.client.stock.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.stock.panes.models.observers.ListItemWarehouseCatalogPaneModelObserver;

public class ListItemWarehouseCatalogPane extends SubTaskPane 
		implements ListItemWarehouseCatalogPaneModelObserver{

	private JPanel pane;
	@Override
	public JComponent getPane() {
		return pane;
	}

}
