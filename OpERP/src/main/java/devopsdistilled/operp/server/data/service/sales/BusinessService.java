package devopsdistilled.operp.server.data.service.sales;

import devopsdistilled.operp.server.data.entity.business.Business;
import devopsdistilled.operp.server.data.service.EntityService;

public interface BusinessService<B extends Business<?, ?>> extends
		EntityService<B, Long> {

}
