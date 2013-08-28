package devopsdistilled.operp.client.business.sales.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.business.sales.controllers.SaleController;
import devopsdistilled.operp.client.business.sales.panes.controllers.ListSalePaneController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDetailsPaneController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SalePaneController;
import devopsdistilled.operp.server.data.entity.business.Sale;

public class SaleControllerImpl implements SaleController {

	@Inject
	private SalePaneController salePaneController;

	@Inject
	private SaleDetailsPaneController saleDetailsPaneController;

	@Inject
	private ListSalePaneController listSalePaneController;

	@Override
	public void create() {
		salePaneController.init(new Sale(), EntityOperation.Create);
	}

	@Override
	public void edit(Sale sale) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		listSalePaneController.init();
	}

	@Override
	public void delete(Sale sale) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showDetails(Sale sale) {
		saleDetailsPaneController.init(sale, EntityOperation.Details);
	}

}
