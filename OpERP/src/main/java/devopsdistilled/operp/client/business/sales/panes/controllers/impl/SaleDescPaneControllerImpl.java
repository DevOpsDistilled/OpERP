package devopsdistilled.operp.client.business.sales.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.business.sales.panes.SaleDescPane;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescPaneController;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDescPaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.business.SaleDesc;

public class SaleDescPaneControllerImpl implements SaleDescPaneController {

	@Inject
	private SaleDescPane view;

	@Inject
	private SaleDescPaneModel model;

	@Override
	public void validate() throws EntityValidationException {
		// TODO Auto-generated method stub

	}

	@Override
	public SaleDesc save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleDescPaneModel getModel() {
		return model;
	}

	@Override
	public SaleDescPane getView() {
		return view;
	}

	@Override
	public void init(SaleDesc entity, EntityOperation entityOperation) {
		// TODO Auto-generated method stub
		model.registerObserver(view);
	}

}
