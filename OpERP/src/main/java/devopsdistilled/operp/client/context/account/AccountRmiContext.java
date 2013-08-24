package devopsdistilled.operp.client.context.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import devopsdistilled.operp.client.context.RmiContext;
import devopsdistilled.operp.server.data.service.account.PaidTransactionService;
import devopsdistilled.operp.server.data.service.account.PayableAccountService;
import devopsdistilled.operp.server.data.service.account.ReceivableAccountService;
import devopsdistilled.operp.server.data.service.account.ReceivedTransactionService;

@Configuration
public class AccountRmiContext extends RmiContext {

	@Bean
	public RmiProxyFactoryBean payableAccountService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceInterface(PayableAccountService.class);
		String serviceName = rmiProxy.getServiceInterface().getCanonicalName();
		rmiProxy.setServiceUrl(rmiUrl + "/" + serviceName);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean receivableAccountService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceInterface(ReceivableAccountService.class);
		String serviceName = rmiProxy.getServiceInterface().getCanonicalName();
		rmiProxy.setServiceUrl(rmiUrl + "/" + serviceName);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean paidTransactionService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceInterface(PaidTransactionService.class);
		String serviceName = rmiProxy.getServiceInterface().getCanonicalName();
		rmiProxy.setServiceUrl(rmiUrl + "/" + serviceName);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean receivedTransactionService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceInterface(ReceivedTransactionService.class);
		String serviceName = rmiProxy.getServiceInterface().getCanonicalName();
		rmiProxy.setServiceUrl(rmiUrl + "/" + serviceName);
		return rmiProxy;
	}
}
