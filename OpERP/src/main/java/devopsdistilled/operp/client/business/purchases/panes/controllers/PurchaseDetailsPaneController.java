package devopsdistilled.operp.client.business.purchases.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.business.purchases.panes.PurchaseDetailsPane;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchaseDetailsPaneModel;
import devopsdistilled.operp.server.data.entity.business.Purchase;

public interface PurchaseDetailsPaneController
		extends
		EntityPaneController<Purchase, PurchaseDetailsPaneModel, PurchaseDetailsPane> {

}
