package devopsdistilled.operp.server.context.business;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import devopsdistilled.operp.server.data.service.sales.PurchaseService;
import devopsdistilled.operp.server.data.service.sales.SaleService;

@Configuration
public class BusinessRmiContext {

	@Inject
	private SaleService saleService;

	@Inject
	private PurchaseService purchaseService;

	@Bean
	public RmiServiceExporter rmiSaleServiceExporter() {
		RmiServiceExporter rmiServiceExportor = new RmiServiceExporter();
		rmiServiceExportor.setServiceInterface(SaleService.class);
		String serviceName = rmiServiceExportor.getServiceInterface()
				.getCanonicalName();
		rmiServiceExportor.setServiceName(serviceName);
		rmiServiceExportor.setService(saleService);
		rmiServiceExportor.setRegistryPort(1099);
		return rmiServiceExportor;
	}

	@Bean
	public RmiServiceExporter rmiPurchaseServiceExporter() {
		RmiServiceExporter rmiServiceExportor = new RmiServiceExporter();
		rmiServiceExportor.setServiceInterface(PurchaseService.class);
		String serviceName = rmiServiceExportor.getServiceInterface()
				.getCanonicalName();
		rmiServiceExportor.setServiceName(serviceName);
		rmiServiceExportor.setService(purchaseService);
		rmiServiceExportor.setRegistryPort(1099);
		return rmiServiceExportor;
	}
}
