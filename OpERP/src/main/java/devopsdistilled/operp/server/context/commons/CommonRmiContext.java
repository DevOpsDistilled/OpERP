package devopsdistilled.operp.server.context.commons;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import devopsdistilled.operp.server.data.service.commons.AddressService;
import devopsdistilled.operp.server.data.service.commons.ContactInfoService;

@Configuration
public class CommonRmiContext {

	@Inject
	private AddressService addressService;

	@Inject
	private ContactInfoService contactInfoService;

	@Bean
	public RmiServiceExporter rmiAddressServiceExporter() {
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		rmiServiceExporter.setServiceName("AddressService");
		rmiServiceExporter.setServiceInterface(AddressService.class);
		rmiServiceExporter.setService(addressService);
		rmiServiceExporter.setRegistryPort(1099);
		return rmiServiceExporter;
	}

	@Bean
	public RmiServiceExporter rmiContactInfoServiceExporter() {
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		rmiServiceExporter.setServiceName("ContactInfoService");
		rmiServiceExporter.setServiceInterface(ContactInfoService.class);
		rmiServiceExporter.setService(contactInfoService);
		rmiServiceExporter.setRegistryPort(1099);
		return rmiServiceExporter;
	}
}
