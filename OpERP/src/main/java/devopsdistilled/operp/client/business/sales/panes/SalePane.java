package devopsdistilled.operp.client.business.sales.panes;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.business.sales.controllers.SaleController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SalePaneController;
import devopsdistilled.operp.server.data.entity.business.Sale;

public class SalePane extends
		EntityPane<Sale, SaleController, SalePaneController> {

	@Inject
	private SaleController saleController;

	private final JPanel pane;

	public SalePane() {
		pane = new JPanel();
	}

	@Override
	public void resetComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public SaleController getEntityController() {
		return saleController;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
