package devopsdistilled.operp.client.business.sales.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SaleDescPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.SaleDesc;

public interface SaleDescPaneModel extends
		EntityPaneModel<SaleDesc, SaleDescPaneModelObserver> {
}
