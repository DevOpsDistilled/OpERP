package devopsdistilled.operp.server.data.service.business;

import devopsdistilled.operp.server.data.entity.business.BusinessDesc;
import devopsdistilled.operp.server.data.service.EntityService;

public interface BusinessDescService<B extends BusinessDesc<?, ?>> extends
		EntityService<B, Long> {

}
