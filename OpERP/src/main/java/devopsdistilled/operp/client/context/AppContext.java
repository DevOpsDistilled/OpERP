package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import devopsdistilled.operp.client.context.items.ItemContext;

@Configuration
@Import({ ItemContext.class })
public class AppContext {

	@Bean
	public RmiProxyFactoryBean transactionManager() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl("rmi://127.0.1.1:1099/TransactionManager");
		rmiProxy.setServiceInterface(JpaTransactionManager.class);
		return rmiProxy;
	}
}
