package devopsdistilled.operp.client.business.purchases.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.business.purchases.panes.PurchaseDetailsPane;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchaseDetailsPaneController;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchaseDetailsPaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.business.Purchase;

public class PurchaseDetailsPaneControllerImpl implements PurchaseDetailsPaneController {

	@Inject
	private PurchaseDetailsPaneModel model;

	@Inject
	private PurchaseDetailsPane view;

	@Override
	public void validate() throws EntityValidationException {
	}

	@Override
	public Purchase save() {
		return null;
	}

	@Override
	public PurchaseDetailsPaneModel getModel() {
		return model;
	}

	@Override
	public PurchaseDetailsPane getView() {
		return view;
	}

	@Override
	public void init(Purchase purchase, EntityOperation entityOperation) {
		if (EntityOperation.Details != entityOperation)
			return;

		view.setController(this);

		model.registerObserver(view);
		model.setEntityAndEntityOperation(purchase, entityOperation);

		view.init();

	}

}
