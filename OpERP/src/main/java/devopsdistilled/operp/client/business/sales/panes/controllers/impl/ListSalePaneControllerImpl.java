package devopsdistilled.operp.client.business.sales.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.business.sales.models.SaleModel;
import devopsdistilled.operp.client.business.sales.panes.ListSalePane;
import devopsdistilled.operp.client.business.sales.panes.controllers.ListSalePaneController;
import devopsdistilled.operp.client.business.sales.panes.models.ListSalePaneModel;

public class ListSalePaneControllerImpl implements
		ListSalePaneController {

	@Inject
	private ListSalePane view;

	@Inject
	private ListSalePaneModel model;

	@Inject
	private SaleModel saleModel;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		saleModel.registerObserver(view);
	}

}
