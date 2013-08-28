package devopsdistilled.operp.client.business.sales.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDetailsPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SaleDetailsPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.Sale;

public class SaleDetailsPaneModelImpl extends
		AbstractEntityPaneModel<Sale, SaleDetailsPaneModelObserver> implements
		SaleDetailsPaneModel {

	@Override
	public String getTitle() {
		return "Sale Summary";
	}

}
