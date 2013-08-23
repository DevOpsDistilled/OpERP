package devopsdistilled.operp.client.business.purchases.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.business.Purchase;

public interface PurchaseModelObserver extends EntityModelObserver {

	public void updatePurchases(List<Purchase> purchases);

}
