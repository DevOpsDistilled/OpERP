package devopsdistilled.operp.client.business.sales.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.business.sales.panes.SaleDetailsPane;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDetailsPaneController;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDetailsPaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.business.Sale;

public class SaleDetailsPaneControllerImpl implements SaleDetailsPaneController {

	@Inject
	private SaleDetailsPaneModel model;

	@Inject
	private SaleDetailsPane view;

	@Override
	public void validate() throws EntityValidationException {
	}

	@Override
	public Sale save() {
		return null;
	}

	@Override
	public SaleDetailsPaneModel getModel() {
		return model;
	}

	@Override
	public SaleDetailsPane getView() {
		return view;
	}

	@Override
	public void init(Sale sale, EntityOperation entityOperation) {
		if (EntityOperation.Details != entityOperation)
			return;

		view.setController(this);

		model.registerObserver(view);
		model.setEntityAndEntityOperation(sale, entityOperation);

		view.init();

	}

}
