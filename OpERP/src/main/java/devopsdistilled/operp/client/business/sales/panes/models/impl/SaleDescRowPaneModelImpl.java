package devopsdistilled.operp.client.business.sales.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDescRowPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SaleDescRowPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.SaleDescRow;

public class SaleDescRowPaneModelImpl extends
		AbstractEntityPaneModel<SaleDescRow, SaleDescRowPaneModelObserver>
		implements SaleDescRowPaneModel {

	@Override
	public String getTitle() {
		return "Sale Description Row";
	}

}
