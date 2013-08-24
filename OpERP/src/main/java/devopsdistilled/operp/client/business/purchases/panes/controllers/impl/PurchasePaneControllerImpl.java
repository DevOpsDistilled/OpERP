package devopsdistilled.operp.client.business.purchases.panes.controllers.impl;

import javax.inject.Inject;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.business.purchases.models.PurchaseModel;
import devopsdistilled.operp.client.business.purchases.panes.PurchasePane;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchaseDescPaneController;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchasePaneController;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchasePaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.party.models.VendorModel;
import devopsdistilled.operp.server.data.entity.business.Purchase;
import devopsdistilled.operp.server.data.entity.business.PurchaseDesc;

public class PurchasePaneControllerImpl implements PurchasePaneController {

	@Inject
	private PurchasePaneModel model;

	@Inject
	private PurchasePane view;

	@Inject
	private VendorModel vendorModel;

	@Inject
	private PurchaseDescPaneController purchaseDescPaneController;

	@Inject
	private PurchaseModel purchaseModel;

	@Override
	public void validate() throws EntityValidationException {

		if (model.getEntity().getParty() == null)
			throw new NullFieldException("Vendor must be selected");
	}

	@Override
	public Purchase save() {
		return purchaseModel.saveAndUpdateModel(model.getEntity());
	}

	@Override
	public PurchasePaneModel getModel() {
		return model;
	}

	@Override
	public PurchasePane getView() {
		return view;
	}

	@Override
	public void init(Purchase purchase, EntityOperation entityOperation) {

		if (EntityOperation.Create == entityOperation) {
			PurchaseDesc purchaseDesc = new PurchaseDesc();
			purchase.setBusinessDesc(purchaseDesc);
			purchaseDesc.setBusiness(purchase);
			purchaseDescPaneController.init(purchaseDesc,
					EntityOperation.Create);

		} else if (EntityOperation.Edit == entityOperation) {

		} else if (EntityOperation.Details == entityOperation) {

		}

		view.setPurchaseDescpanel((JPanel) purchaseDescPaneController.getView()
				.getPane());
		view.setController(this);
		view.resetComponents();

		model.registerObserver(view);
		model.setEntityAndEntityOperation(purchase, entityOperation);

		vendorModel.registerObserver(view);

		view.init();

	}

}
