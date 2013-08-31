package devopsdistilled.operp.client.business.purchases.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.business.purchases.models.observers.SaleDescModelObserver;
import devopsdistilled.operp.server.data.entity.business.SaleDesc;
import devopsdistilled.operp.server.data.service.business.SaleDescService;

public interface SaleDescModel extends
		EntityModel<SaleDesc, SaleDescService, SaleDescModelObserver> {

}
