package devopsdistilled.operp.client.business.purchases.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.business.purchases.models.PurchaseModel;
import devopsdistilled.operp.client.business.purchases.panes.ListPurchasePane;
import devopsdistilled.operp.client.business.purchases.panes.controllers.ListPurchasePaneController;
import devopsdistilled.operp.client.business.purchases.panes.models.ListPurchasePaneModel;

public class ListPurchasePaneControllerImpl implements
		ListPurchasePaneController {

	@Inject
	private ListPurchasePane view;

	@Inject
	private ListPurchasePaneModel model;

	@Inject
	private PurchaseModel purchaseModel;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		purchaseModel.registerObserver(view);
	}

}
