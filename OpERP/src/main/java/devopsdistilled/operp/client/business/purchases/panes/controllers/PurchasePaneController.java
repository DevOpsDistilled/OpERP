package devopsdistilled.operp.client.business.purchases.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.business.purchases.panes.PurchasePane;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchasePaneModel;
import devopsdistilled.operp.server.data.entity.business.Purchase;

public interface PurchasePaneController extends
		EntityPaneController<Purchase, PurchasePaneModel, PurchasePane> {

}
