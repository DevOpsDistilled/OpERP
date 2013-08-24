package devopsdistilled.operp.client.business.sales.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.business.sales.models.observers.SaleModelObserver;
import devopsdistilled.operp.server.data.entity.business.Sale;
import devopsdistilled.operp.server.data.service.business.SaleService;

public interface SaleModel extends
		EntityModel<Sale, SaleService, SaleModelObserver> {

}
