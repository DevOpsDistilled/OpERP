package devopsdistilled.operp.server.context.account;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import devopsdistilled.operp.server.data.service.account.PayableAccountService;
import devopsdistilled.operp.server.data.service.account.ReceivableAccountService;

@Configuration
public class AccountRmiContext {

	@Inject
	private PayableAccountService payableAccountService;

	@Inject
	private ReceivableAccountService receivableAccountService;

	@Bean
	public RmiServiceExporter rmiPayableAccountServiceExporter() {
		RmiServiceExporter rmiServiceExportor = new RmiServiceExporter();
		rmiServiceExportor.setServiceInterface(PayableAccountService.class);
		String serviceName = rmiServiceExportor.getServiceInterface()
				.getCanonicalName();
		rmiServiceExportor.setServiceName(serviceName);
		rmiServiceExportor.setService(payableAccountService);
		rmiServiceExportor.setRegistryPort(1099);
		return rmiServiceExportor;
	}

	@Bean
	public RmiServiceExporter rmiReceivableAccountServiceExporter() {
		RmiServiceExporter rmiServiceExportor = new RmiServiceExporter();
		rmiServiceExportor.setServiceInterface(ReceivableAccountService.class);
		String serviceName = rmiServiceExportor.getServiceInterface()
				.getCanonicalName();
		rmiServiceExportor.setServiceName(serviceName);
		rmiServiceExportor.setService(receivableAccountService);
		rmiServiceExportor.setRegistryPort(1099);
		return rmiServiceExportor;
	}
}
