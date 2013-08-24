package devopsdistilled.operp.client.business.sales.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.business.sales.controllers.SaleController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SalePaneController;
import devopsdistilled.operp.server.data.entity.business.Sale;

public class SaleControllerImpl implements SaleController {

	@Inject
	private SalePaneController salePaneController;

	@Override
	public void create() {
		salePaneController.init(new Sale(), EntityOperation.Create);
	}

	@Override
	public void edit(Sale entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Sale entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showDetails(Sale entity) {
		// TODO Auto-generated method stub

	}

}
