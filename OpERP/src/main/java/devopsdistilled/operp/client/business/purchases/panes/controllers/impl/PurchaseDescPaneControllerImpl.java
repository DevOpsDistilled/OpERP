package devopsdistilled.operp.client.business.purchases.panes.controllers.impl;

import javax.inject.Inject;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.business.purchases.panes.PurchaseDescPane;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchaseDescPaneController;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchaseDescRowPaneController;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchaseDescPaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.server.data.entity.business.PurchaseDesc;
import devopsdistilled.operp.server.data.entity.business.PurchaseDescRow;

public class PurchaseDescPaneControllerImpl implements PurchaseDescPaneController {

	@Inject
	private PurchaseDescPane view;

	@Inject
	private PurchaseDescPaneModel model;

	@Inject
	private PurchaseDescRowPaneController purchaseDescRowPaneController;

	@Override
	public void validate() throws EntityValidationException {
		if (model.getPurchaseDescRow().getItem() == null
				|| model.getPurchaseDescRow().getQuantity().equals(0L)
				|| model.getPurchaseDescRow().getRate().equals(0.0)) {

			throw new NullFieldException();
		}

		// XXX More validation checking
	}

	@Override
	public PurchaseDesc save() {
		return null;
	}

	@Override
	public PurchaseDescPaneModel getModel() {
		return model;
	}

	@Override
	public PurchaseDescPane getView() {
		return view;
	}

	@Override
	public void init(PurchaseDesc purchaseDesc, EntityOperation entityOperation) {
		if (EntityOperation.Create == entityOperation) {
			PurchaseDescRow purchaseDescRow = new PurchaseDescRow();
			model.setPurchaseDescRow(purchaseDescRow);
			purchaseDescRowPaneController.init(purchaseDescRow, entityOperation);
		}

		view.setPurchaseDescRowpanel((JPanel) purchaseDescRowPaneController.getView()
				.getPane());
		view.setController(this);
		view.resetComponents();

		model.registerObserver(view);
		model.setEntityAndEntityOperation(purchaseDesc, entityOperation);
	}

	@Override
	public void addNewPurchaseDescRow() {

		if (EntityOperation.Edit != model.getEntityOperation()) {
			model.getEntity().getDescRows().add(model.getPurchaseDescRow());
		}

		model.getEntity().setTotalAmount(
				model.getEntity().getTotalAmount()
						+ model.getPurchaseDescRow().getAmount());

		model.setEntityAndEntityOperation(model.getEntity(),
				EntityOperation.Create);

		PurchaseDescRow purchaseDescRow = new PurchaseDescRow();
		model.setPurchaseDescRow(purchaseDescRow);
		purchaseDescRowPaneController.init(purchaseDescRow, EntityOperation.Create);
	}

	@Override
	public void initEditPurchaseDescRow(PurchaseDescRow purchaseDescRow) {
		model.setPurchaseDescRow(purchaseDescRow);
		model.getEntity().setTotalAmount(
				model.getEntity().getTotalAmount()
						- model.getPurchaseDescRow().getAmount());
		model.setEntityAndEntityOperation(model.getEntity(),
				EntityOperation.Edit);
		purchaseDescRowPaneController.init(purchaseDescRow, EntityOperation.Edit);
	}
}
