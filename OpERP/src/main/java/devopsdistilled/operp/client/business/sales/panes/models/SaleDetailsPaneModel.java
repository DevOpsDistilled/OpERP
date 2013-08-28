package devopsdistilled.operp.client.business.sales.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SaleDetailsPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.Sale;

public interface SaleDetailsPaneModel extends
		EntityPaneModel<Sale, SaleDetailsPaneModelObserver> {

}
