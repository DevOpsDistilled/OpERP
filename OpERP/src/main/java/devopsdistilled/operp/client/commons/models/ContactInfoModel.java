package devopsdistilled.operp.client.commons.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.commons.models.observers.ContactInfoModelObserver;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;
import devopsdistilled.operp.server.data.service.commons.ContactInfoService;

public interface ContactInfoModel extends
		EntityModel<ContactInfo, ContactInfoService, ContactInfoModelObserver> {

}
