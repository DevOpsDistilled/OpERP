package devopsdistilled.operp.client.business.sales.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.business.sales.panes.SaleDetailsPane;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDetailsPaneModel;
import devopsdistilled.operp.server.data.entity.business.Sale;

public interface SaleDetailsPaneController extends
		EntityPaneController<Sale, SaleDetailsPaneModel, SaleDetailsPane> {

}
