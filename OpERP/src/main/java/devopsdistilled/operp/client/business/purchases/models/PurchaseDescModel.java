package devopsdistilled.operp.client.business.purchases.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.business.purchases.models.observers.PurchaseDescModelObserver;
import devopsdistilled.operp.server.data.entity.business.PurchaseDesc;
import devopsdistilled.operp.server.data.service.business.PurchaseDescService;

public interface PurchaseDescModel
		extends
		EntityModel<PurchaseDesc, PurchaseDescService, PurchaseDescModelObserver> {

}
