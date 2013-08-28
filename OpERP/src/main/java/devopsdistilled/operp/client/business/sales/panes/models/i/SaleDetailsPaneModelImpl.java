package devopsdistilled.operp.client.business.sales.panes.models.i;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDetailsPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SaleDetailsPaneModelObserver;

public class SaleDetailsPaneModelImpl extends
		AbstractPaneModel<SaleDetailsPaneModelObserver> implements
		SaleDetailsPaneModel {

	@Override
	public String getTitle() {
		return "Sale Summary";
	}

}
