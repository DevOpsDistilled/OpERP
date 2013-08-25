package devopsdistilled.operp.server.data.service.business;

import devopsdistilled.operp.server.data.entity.business.Business;
import devopsdistilled.operp.server.data.service.EntityService;

public interface BusinessService<B extends Business<?, ?>> extends
		EntityService<B, Long> {

}
