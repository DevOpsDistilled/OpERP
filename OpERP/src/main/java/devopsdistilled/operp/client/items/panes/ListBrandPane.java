package devopsdistilled.operp.client.items.panes;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.items.models.observers.BrandModelObserver;
import devopsdistilled.operp.client.items.panes.models.observers.ListBrandPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Brand;

public class ListBrandPane extends SubTaskPane implements
		ListBrandPaneModelObserver, BrandModelObserver {

	private final JPanel pane;

	public ListBrandPane() {
		pane = new JPanel();
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateBrands(List<Brand> brands) {
		// TODO Auto-generated method stub

	}

}
