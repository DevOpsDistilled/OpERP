package devopsdistilled.operp.client.business.sales.panes.controllers.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.business.sales.panes.SaleDescRowPane;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescRowPaneController;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDescRowPaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.server.data.entity.business.SaleDescRow;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class SaleDescRowPaneControllerImpl implements SaleDescRowPaneController {

	@Inject
	private SaleDescRowPane view;

	@Inject
	private SaleDescRowPaneModel model;

	@Inject
	private StockModel stockModel;

	@Override
	public void validate() throws EntityValidationException {
		// TODO Auto-generated method stub

	}

	@Override
	public SaleDescRow save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleDescRowPaneModel getModel() {
		return model;
	}

	@Override
	public SaleDescRowPane getView() {
		return view;
	}

	@Override
	public void init(SaleDescRow saleDescRow, EntityOperation entityOperation) {

		view.setController(this);
		view.resetComponents();

		model.registerObserver(view);
		model.setEntityAndEntityOperation(saleDescRow, entityOperation);

		stockModel.registerObserver(view);
	}

	@Override
	public List<Item> getItemsInWarehouse(Warehouse selWarehouse) {
		model.getEntity().setWarehouse(selWarehouse);
		Set<Item> itemSet = new HashSet<>();

		for (Stock stock : stockModel.getEntities())
			if (stock.getWarehouse().compareTo(selWarehouse) == 0)
				itemSet.add(stock.getItem());

		return new LinkedList<>(itemSet);
	}

	@Override
	public Long getQuantityOfItem(Item selItem) {
		model.getEntity().setItem(selItem);
		for (Stock stock : stockModel.getEntities())
			if (stock.getWarehouse()
					.compareTo(model.getEntity().getWarehouse()) == 0
					&& stock.getItem().compareTo(selItem) == 0) {

				Long quantity = stock.getQuantity();
				model.getEntity().setQuantity(quantity);
				return quantity;
			}

		return 0L;
	}
}
