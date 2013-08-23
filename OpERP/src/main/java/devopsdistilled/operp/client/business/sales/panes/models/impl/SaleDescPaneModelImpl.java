package devopsdistilled.operp.client.business.sales.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDescPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SaleDescPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.SaleDesc;
import devopsdistilled.operp.server.data.entity.business.SaleDescRow;

public class SaleDescPaneModelImpl extends
		AbstractEntityPaneModel<SaleDesc, SaleDescPaneModelObserver> implements
		SaleDescPaneModel {

	private SaleDescRow saleDescRow;

	@Override
	public String getTitle() {
		return "Sale Description";
	}

	@Override
	public SaleDescRow getSaleDescRow() {
		return saleDescRow;
	}

	@Override
	public void setSaleDescRow(SaleDescRow saleDescRow) {
		this.saleDescRow = saleDescRow;
	}

}
