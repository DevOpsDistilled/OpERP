package devopsdistilled.operp.client.business.sales.panes.controllers.impl;

import javax.inject.Inject;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.business.sales.panes.SaleDescPane;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescPaneController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescRowPaneController;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDescPaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.server.data.entity.business.SaleDesc;
import devopsdistilled.operp.server.data.entity.business.SaleDescRow;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public class SaleDescPaneControllerImpl implements SaleDescPaneController {

	@Inject
	private SaleDescPane view;

	@Inject
	private SaleDescPaneModel model;

	@Inject
	private StockModel stockModel;

	@Inject
	private SaleDescRowPaneController saleDescRowPaneController;

	@Override
	public void validate() throws EntityValidationException {
		Long quantity = model.getSaleDescRow().getQuantity();

		Double rate = model.getSaleDescRow().getRate();
		if (model.getSaleDescRow().getItem() == null
				|| model.getSaleDescRow().getWarehouse() == null
				|| quantity.equals(0L) || rate.equals(0.0)) {

			throw new NullFieldException();
		}

		if (quantity.compareTo(0L) <= 0)
			throw new EntityValidationException(
					"Quantity shouldnt' be negative value");

		if (rate.compareTo(0.0) < 0)
			throw new EntityValidationException("Rate can't be negative");

		// Check if quantity exceeds stock
		for (Stock stock : stockModel.getEntities())
			if (stock.getWarehouse().compareTo(
					model.getSaleDescRow().getWarehouse()) == 0
					&& stock.getItem().compareTo(
							model.getSaleDescRow().getItem()) == 0)

				if (stock.getQuantity().compareTo(quantity) <= 0)
					throw new EntityValidationException("Only "
							+ stock.getQuantity() + " " + stock.getItem()
							+ " available in " + stock.getWarehouse());
	}

	@Override
	public SaleDesc save() {
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
	public void init(SaleDesc saleDesc, EntityOperation entityOperation) {
		if (EntityOperation.Create == entityOperation) {
			SaleDescRow saleDescRow = new SaleDescRow();
			model.setSaleDescRow(saleDescRow);
			saleDescRowPaneController.init(saleDescRow, entityOperation);
		}

		view.setSaleDescRowpanel((JPanel) saleDescRowPaneController.getView()
				.getPane());
		view.setController(this);
		view.resetComponents();

		model.registerObserver(view);
		model.setEntityAndEntityOperation(saleDesc, entityOperation);
	}

	@Override
	public void addNewSaleDescRow() {

		model.getSaleDescRow().setBusinessDesc(model.getEntity());

		if (EntityOperation.Edit != model.getEntityOperation()) {
			model.getEntity().getDescRows().add(model.getSaleDescRow());
		}

		model.getEntity().setTotalAmount(
				model.getEntity().getTotalAmount()
						+ model.getSaleDescRow().getAmount());

		model.setEntityAndEntityOperation(model.getEntity(),
				EntityOperation.Create);

		SaleDescRow saleDescRow = new SaleDescRow();
		model.setSaleDescRow(saleDescRow);
		saleDescRowPaneController.init(saleDescRow, EntityOperation.Create);
	}

	@Override
	public void initEditSaleDescRow(SaleDescRow saleDescRow) {
		model.setSaleDescRow(saleDescRow);
		model.getEntity().setTotalAmount(
				model.getEntity().getTotalAmount()
						- model.getSaleDescRow().getAmount());
		model.setEntityAndEntityOperation(model.getEntity(),
				EntityOperation.Edit);
		saleDescRowPaneController.init(saleDescRow, EntityOperation.Edit);
	}
}
