package devopsdistilled.operp.client.business.sales.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDescPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SaleDescPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.SaleDesc;

public class SaleDescPaneModelImpl extends
		AbstractEntityPaneModel<SaleDesc, SaleDescPaneModelObserver> implements
		SaleDescPaneModel {

	@Override
	public String getTitle() {
		return "Sale Description";
	}

}
