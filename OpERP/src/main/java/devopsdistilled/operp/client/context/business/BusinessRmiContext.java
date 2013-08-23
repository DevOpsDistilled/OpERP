package devopsdistilled.operp.client.context.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import devopsdistilled.operp.client.context.RmiContext;
import devopsdistilled.operp.server.data.service.sales.PurchaseService;
import devopsdistilled.operp.server.data.service.sales.SaleService;

@Configuration
public class BusinessRmiContext extends RmiContext {

	@Bean
	public RmiProxyFactoryBean saleService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceInterface(SaleService.class);
		String serviceName = rmiProxy.getServiceInterface().getCanonicalName();
		rmiProxy.setServiceUrl(rmiUrl + "/" + serviceName);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean purchaseService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceInterface(PurchaseService.class);
		String serviceName = rmiProxy.getServiceInterface().getCanonicalName();
		rmiProxy.setServiceUrl(rmiUrl + "/" + serviceName);
		return rmiProxy;
	}
}
