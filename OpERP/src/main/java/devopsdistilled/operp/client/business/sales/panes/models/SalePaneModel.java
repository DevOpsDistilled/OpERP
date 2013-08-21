package devopsdistilled.operp.client.business.sales.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SalePaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.Sale;

public interface SalePaneModel extends
		EntityPaneModel<Sale, SalePaneModelObserver> {

}
