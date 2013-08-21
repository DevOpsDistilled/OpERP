package devopsdistilled.operp.client.business.sales.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.business.sales.controllers.SaleDescController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescPaneController;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SaleDescPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.SaleDesc;

public class SaleDescPane extends
		EntityPane<SaleDesc, SaleDescController, SaleDescPaneController>
		implements SaleDescPaneModelObserver {

	private final JPanel pane;

	public SaleDescPane() {
		pane = new JPanel();
	}

	@Override
	public void resetComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public SaleDescController getEntityController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(SaleDesc entity, EntityOperation entityOperation) {
		// TODO Auto-generated method stub

	}

}
