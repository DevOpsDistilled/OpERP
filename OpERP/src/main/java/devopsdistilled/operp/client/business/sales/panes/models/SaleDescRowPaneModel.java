package devopsdistilled.operp.client.business.sales.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SaleDescRowPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.SaleDescRow;

public interface SaleDescRowPaneModel extends
		EntityPaneModel<SaleDescRow, SaleDescRowPaneModelObserver> {
}
