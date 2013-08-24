package devopsdistilled.operp.client.context.party;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import devopsdistilled.operp.client.context.RmiContext;
import devopsdistilled.operp.server.data.service.party.CustomerService;
import devopsdistilled.operp.server.data.service.party.VendorService;

@Configuration
public class PartyRmiContext extends RmiContext {

	@Bean
	public RmiProxyFactoryBean vendorService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl(rmiUrl + "/VendorService");
		rmiProxy.setServiceInterface(VendorService.class);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean customerService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl(rmiUrl + "/CustomerService");
		rmiProxy.setServiceInterface(CustomerService.class);
		return rmiProxy;
	}
}
