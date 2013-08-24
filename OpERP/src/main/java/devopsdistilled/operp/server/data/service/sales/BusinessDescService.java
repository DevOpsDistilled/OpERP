package devopsdistilled.operp.server.data.service.sales;

import devopsdistilled.operp.server.data.entity.business.BusinessDesc;
import devopsdistilled.operp.server.data.service.EntityService;

public interface BusinessDescService<B extends BusinessDesc<?, ?>> extends
		EntityService<B, Long> {

}
