package devopsdistilled.operp.client.business.sales.panes.controllers.impl;

import javax.inject.Inject;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.business.sales.models.SaleModel;
import devopsdistilled.operp.client.business.sales.panes.SalePane;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescPaneController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SalePaneController;
import devopsdistilled.operp.client.business.sales.panes.models.SalePaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.party.models.CustomerModel;
import devopsdistilled.operp.server.data.entity.business.Sale;
import devopsdistilled.operp.server.data.entity.business.SaleDesc;

public class SalePaneControllerImpl implements SalePaneController {

	@Inject
	private SalePaneModel model;

	@Inject
	private SalePane view;

	@Inject
	private CustomerModel customerModel;

	@Inject
	private SaleDescPaneController saleDescPaneController;

	@Inject
	private SaleModel saleModel;

	@Override
	public void validate() throws EntityValidationException {
		// TODO Auto-generated method stub

	}

	@Override
	public Sale save() {
		return saleModel.saveAndUpdateModel(model.getEntity());
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
			SaleDesc saleDesc = new SaleDesc();
			sale.setBusinessDesc(saleDesc);
			saleDescPaneController.init(saleDesc, EntityOperation.Create);

		} else if (EntityOperation.Edit == entityOperation) {

			// XXX

		} else if (EntityOperation.Details == entityOperation) {

			// XXX
		}

		view.setSaleDescpanel((JPanel) saleDescPaneController.getView()
				.getPane());
		view.setController(this);
		view.resetComponents();

		model.registerObserver(view);
		model.setEntityAndEntityOperation(sale, entityOperation);

		customerModel.registerObserver(view);

		view.init();

	}

}
