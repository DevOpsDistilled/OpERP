package devopsdistilled.operp.client.business.purchases.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.business.purchases.models.observers.PurchaseModelObserver;
import devopsdistilled.operp.server.data.entity.business.Purchase;
import devopsdistilled.operp.server.data.service.business.PurchaseService;

public interface PurchaseModel extends
		EntityModel<Purchase, PurchaseService, PurchaseModelObserver> {

}
