package devopsdistilled.operp.client.sales.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.sales.models.observers.PurchaseModelObserver;
import devopsdistilled.operp.server.data.entity.business.Purchase;
import devopsdistilled.operp.server.data.service.sales.PurchaseService;

public interface PurchaseModel extends
		EntityModel<Purchase, PurchaseService, PurchaseModelObserver> {

}
