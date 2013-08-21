package devopsdistilled.operp.client.business.sales.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.business.sales.controllers.SaleDescRowController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescRowPaneController;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SaleDescRowPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.SaleDescRow;

public class SaleDescRowPane
		extends
		EntityPane<SaleDescRow, SaleDescRowController, SaleDescRowPaneController>
		implements SaleDescRowPaneModelObserver {

	private final JPanel pane;

	public SaleDescRowPane() {
		pane = new JPanel();
	}

	@Override
	public void resetComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public SaleDescRowController getEntityController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(SaleDescRow entity, EntityOperation entityOperation) {
		// TODO Auto-generated method stub

	}

}
