package devopsdistilled.operp.client.business.sales.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.business.sales.panes.SalePane;
import devopsdistilled.operp.client.business.sales.panes.controllers.SalePaneController;
import devopsdistilled.operp.client.business.sales.panes.models.SalePaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.business.Sale;

public class SalePaneControllerImpl implements SalePaneController {

	@Inject
	private SalePaneModel model;

	@Inject
	private SalePane view;

	@Override
	public void validate() throws EntityValidationException {
		// TODO Auto-generated method stub

	}

	@Override
	public Sale save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalePaneModel getModel() {
		return model;
	}

	@Override
	public SalePane getView() {
		return view;
	}

	@Override
	public void init(Sale sale, EntityOperation entityOperation) {
		// TODO Auto-generated method stub

		if (EntityOperation.Create == entityOperation) {

			model.setTitle("New Sale");
			// XXX

		} else if (EntityOperation.Edit == entityOperation) {

			model.setTitle("Edit Sale Description");
			// XXX

		} else if (EntityOperation.Details == entityOperation) {

			model.setTitle("Sale Details");

			// XXX
		}

		view.setController(this);
		view.resetComponents();

		model.registerObserver(view);
		model.setEntityAndEntityOperation(sale, entityOperation);

		view.init();

	}

}
