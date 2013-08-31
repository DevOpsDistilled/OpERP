package devopsdistilled.operp.server.data.service.commons.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.client.commons.models.ContactInfoModel;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;
import devopsdistilled.operp.server.data.repo.commons.ContactInfoRepository;
import devopsdistilled.operp.server.data.service.commons.ContactInfoService;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;

@Service
public class ContactInfoServiceImpl
		extends
		AbstractEntityService<ContactInfo, Long, ContactInfoRepository, ContactInfoModel>
		implements ContactInfoService {

	private static final long serialVersionUID = 3910975586559308476L;

	@Inject
	private ContactInfoRepository repo;

	@Override
	protected ContactInfoRepository getRepo() {
		return repo;
	}

	@Override
	protected ContactInfo findByEntityName(String entityName) {
		return null;
	}

}
