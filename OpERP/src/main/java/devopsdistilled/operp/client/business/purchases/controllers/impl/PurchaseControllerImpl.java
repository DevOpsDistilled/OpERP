package devopsdistilled.operp.client.business.purchases.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.business.purchases.controllers.PurchaseController;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchasePaneController;
import devopsdistilled.operp.server.data.entity.business.Purchase;

public class PurchaseControllerImpl implements PurchaseController {

	@Inject
	private PurchasePaneController purchasePaneController;

	@Override
	public void create() {
		purchasePaneController.init(new Purchase(), EntityOperation.Create);
	}

	@Override
	public void edit(Purchase entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Purchase entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showDetails(Purchase entity) {
		// TODO Auto-generated method stub

	}

}
